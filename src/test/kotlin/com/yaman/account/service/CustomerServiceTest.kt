package com.yaman.account.service

import com.yaman.account.dto.CustomerDto
import com.yaman.account.dto.CustomerDtoConverter
import com.yaman.account.exception.CustomerNotFoundException
import com.yaman.account.model.Customer
import com.yaman.account.repository.CustomerRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

class CustomerServiceTest(

) {
    private lateinit var customerService: CustomerService
    private lateinit var customerRepository: CustomerRepository
    private lateinit var customerDtoConverter: CustomerDtoConverter

    //her şeyden önce setup hazırlık
    @BeforeEach
    fun setUp() {
        customerRepository = Mockito.mock(CustomerRepository::class.java)
        customerDtoConverter = Mockito.mock(CustomerDtoConverter::class.java)
        customerService = CustomerService(customerRepository, customerDtoConverter)
    }

    @Test
    fun testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        var customer = Customer("id", "fifi", "surname", emptySet())
        Mockito.`when`(customerRepository.findById("id")).thenReturn(Optional.of(customer))
        var result = customerService.findCustomerById("id")
        assertEquals(result, customer)
    }

    @Test
    fun testFindByCustomerId_whenCustomerIdDoesntExists_shouldThrowCustomerDoesntFoundException() {

        Mockito.`when`(customerRepository.findById("id")).thenReturn(Optional.empty())
        assertThrows(CustomerNotFoundException::class.java) {
            customerService.findCustomerById("id")
            // şu lambda fonksiyonu çağırıldığında bu customer not found exception gelecek!
        }
    }

    @Test
    fun testGetCustomerById_whenCustomerIdExistsShouldReturnCustomer() {
        var customer = Customer("x", "xx", "xxx", emptySet())
        var customerDto = CustomerDto("x", "xx", "xxx", emptySet())
        Mockito.`when`(customerRepository.findById("x")).thenReturn(Optional.of(customer)) // bunu çağırdığında customer dön denmiş
        Mockito.`when`(customerDtoConverter.convertEntityToCustomerDto(customer)).thenReturn(customerDto)
        var res = customerService.getCustomerInfoById("x")
        assertEquals(res,customerDto)
    }

    @Test
    fun testGetCustomerById_whenCustomerIdDoesntExistsShouldThrowCustomerNotFoundException(){
        Mockito.`when`(customerRepository.findById("x")).thenReturn(Optional.empty()) //bunu çağırdığında optional.empty dön denmiş
        //Mockito.when ifadesi, bir Mockito mock nesnesinin belirli bir metoduna çağrı yapıldığında ne döndüreceğini belirtmek için kullanılır.

        assertThrows(CustomerNotFoundException::class.java){
            customerService.getCustomerInfoById("x")
        }
        Mockito.verifyNoInteractions(customerDtoConverter)
    }
}