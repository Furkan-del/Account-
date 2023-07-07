package com.yaman.account.dto

import com.yaman.account.model.Customer
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CustomerDtoConverter(private val customerAccountDtoConverter: CustomerAccountDtoConverter) {

    fun convertEntityToAccountCustomerDto(customer: Customer?): AccountCustomerDto {

        if (customer == null) {
            return AccountCustomerDto("", "", "")
        }
        return AccountCustomerDto(customer.id, customer.name, customer.surName)

    }

    fun convertEntityToCustomerDto(customer: Customer?): CustomerDto {

        return CustomerDto(
            customer?.id,
            customer?.name,
            customer?.surName,
            customer?.account?.stream()?.map(customerAccountDtoConverter::convert)?.collect(Collectors.toSet())
        )
    }


}