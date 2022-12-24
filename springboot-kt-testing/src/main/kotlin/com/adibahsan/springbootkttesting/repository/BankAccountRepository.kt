package com.adibahsan.springbootkttesting.repository

import com.adibahsan.springbootkttesting.entity.BankAccount
import org.springframework.data.repository.CrudRepository

interface BankAccountRepository: CrudRepository<BankAccount, Long> {
}