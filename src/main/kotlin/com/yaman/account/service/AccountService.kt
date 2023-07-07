package com.yaman.account.service

import com.yaman.account.dto.AccountDto
import com.yaman.account.dto.AccountDtoConverter
import com.yaman.account.dto.CreateAccountRequest
import com.yaman.account.model.Account
import com.yaman.account.model.Transaction
import com.yaman.account.repository.AccountRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val customerService: CustomerService,
    private val accountDtoConverter: AccountDtoConverter,

    ) {
    //
    fun createAccount(createAccountRequest: CreateAccountRequest): AccountDto {
        var customer = customerService.findCustomerById(createAccountRequest.customerId)
        var account = Account(
            balance = createAccountRequest.initialCredit,
            creationDate = LocalDateTime.now(),
            customer = customer
        )
        if (createAccountRequest.initialCredit > BigDecimal.ZERO) {
            var transaction = Transaction(createAccountRequest.initialCredit, account = account)
            account.transaction.add(transaction)

        }
        return accountDtoConverter.convertEntityToAccountDto(accountRepository.save(account))
    }

}