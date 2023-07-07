package com.yaman.account

import com.yaman.account.model.Customer
import com.yaman.account.repository.CustomerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AccountApplication(
    private val customerRepository: CustomerRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
         var cc=customerRepository.save(Customer("",name = "frank", surName = "belle", account = emptySet() ))
       println("${cc.id}")
    }
}



fun main(args: Array<String>) {
    runApplication<AccountApplication>(*args)


}
