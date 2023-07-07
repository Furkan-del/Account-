package com.yaman.account.repository

import com.yaman.account.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer,String> {
}