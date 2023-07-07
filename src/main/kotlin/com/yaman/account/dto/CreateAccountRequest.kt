package com.yaman.account.dto

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateAccountRequest(
    @field:NotBlank(message = "Customer bos olamaz")
    val customerId:String ,
    @field:Min(value = 0, message = "değerler 0 dan küçük olamaz")
    val initialCredit:BigDecimal )
