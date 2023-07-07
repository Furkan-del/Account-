package com.yaman.account.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.yaman.account.dto.AccountDtoConverter
import com.yaman.account.model.Customer
import com.yaman.account.repository.AccountRepository
import com.yaman.account.repository.CustomerRepository
import com.yaman.account.service.AccountService
import com.yaman.account.service.CustomerService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = [
        "server-port=0",
        "command.line.runner.enabled=false"
    ]
)
@RunWith(SpringRunner::class)
@DirtiesContext
class AccountControllerTest(
    private val accountRepository: AccountRepository,private val customerRepository: CustomerRepository,
    private val customerService: CustomerService, private val accountDtoConverter: AccountDtoConverter,private val mockMvc: MockMvc
) {
    var accountService = AccountService(accountRepository, customerService, accountDtoConverter)
    var objectMap = ObjectMapper()



    @BeforeEach
    fun setup() {
        objectMap.registerModule(JavaTimeModule())
       objectMap.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false)

    }
    @Test
    fun testCreateAccount_whenCustomerIdExists_shouldCreateAccountAndReturnAccountDto(){
        var customer=customerRepository.save(Customer("Anil","Derbent"))


    }



}