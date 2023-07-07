package com.yaman.account.dto

import com.yaman.account.model.Account
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CustomerAccountDtoConverter(private val transactionDtoConverter: TransactionDtoConverter) {

    fun convert(account: Account): CustomerAccountDto {
        return CustomerAccountDto(
            account.id,
            account.balance,
            account.transaction.stream().map(transactionDtoConverter::convertEntityToTransactionDto)
                .collect(Collectors.toSet()),
            account.creationDate
        )
    }

}