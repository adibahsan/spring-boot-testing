package com.adibahsan.springbootkttesting.repository

import com.adibahsan.springbootkttesting.entity.BankAccount
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BankAccountRepository: CrudRepository<BankAccount, Long> {
}