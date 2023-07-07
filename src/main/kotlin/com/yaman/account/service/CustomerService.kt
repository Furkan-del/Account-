package com.yaman.account.service

import com.yaman.account.dto.CustomerDto
import com.yaman.account.dto.CustomerDtoConverter
import com.yaman.account.exception.CustomerNotFoundException
import com.yaman.account.model.Customer
import com.yaman.account.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerDtoConverter: CustomerDtoConverter
) {
//business logic
    fun findCustomerById(id: String): Customer {
        return customerRepository.findById(id)
            .orElseThrow { CustomerNotFoundException("We dont have any Customer  with this id $id") }
    }

    fun getCustomerInfoById(id: String): CustomerDto {
        return customerDtoConverter.convertEntityToCustomerDto(findCustomerById(id))
    }

}