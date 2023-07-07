package com.yaman.account.dto

import com.yaman.account.model.Account
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class AccountDtoConverter(
    private val customerDtoConverter: CustomerDtoConverter,
    private val transactionDtoConverter: TransactionDtoConverter
) {


    fun convertEntityToAccountDto(account: Account): AccountDto {
        return AccountDto(
            account.id,
            account.balance,
            account.creationDate,
            customerDtoConverter.convertEntityToAccountCustomerDto(account.customer),
            account.transaction.stream().map(transactionDtoConverter::convertEntityToTransactionDto)
                .collect(Collectors.toSet())
        )

    }
}