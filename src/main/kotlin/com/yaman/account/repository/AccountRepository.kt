package com.yaman.account.repository

import com.yaman.account.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {

}