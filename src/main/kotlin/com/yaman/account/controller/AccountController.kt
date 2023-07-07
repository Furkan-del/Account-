package com.yaman.account.controller

import com.yaman.account.dto.AccountDto
import com.yaman.account.dto.CreateAccountRequest
import com.yaman.account.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/account")
class AccountController(private val accountService: AccountService) {
    @PostMapping
    fun createAccount(@Valid @RequestBody createAccountRequest: CreateAccountRequest): ResponseEntity<AccountDto> =
        ResponseEntity.ok(accountService.createAccount(createAccountRequest))
}