package com.yaman.account.controller

import com.yaman.account.dto.CustomerDto
import com.yaman.account.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/customer")
class CustomerController(private val customerService: CustomerService) {
    @GetMapping("/{id}")
    fun getAllCustomerInfos(@PathVariable id: String): ResponseEntity<CustomerDto> =
        ResponseEntity.ok(customerService.getCustomerInfoById(id))
}