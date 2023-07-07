package com.yaman.account.dto

import com.yaman.account.model.Transaction
import org.springframework.stereotype.Component

@Component
class TransactionDtoConverter {

    fun convertEntityToTransactionDto(transaction: Transaction): TransactionDto {
        return TransactionDto(
            transaction.id,
            transaction.transactionType,
            transaction.amount,
            transaction.transactionDate
        )
    }
}