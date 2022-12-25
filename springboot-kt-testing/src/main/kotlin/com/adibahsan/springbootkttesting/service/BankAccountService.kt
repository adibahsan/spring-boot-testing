package com.adibahsan.springbootkttesting.service

import com.adibahsan.springbootkttesting.entity.BankAccount
import com.adibahsan.springbootkttesting.repository.BankAccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BankAccountService(val bankAccountRepository: BankAccountRepository) {
    fun addBankAccount(bankAccount: BankAccount): BankAccount {
        return bankAccountRepository.save(bankAccount);
    }
    fun getBankAccount(id: Long): BankAccount? {
        return bankAccountRepository.findByIdOrNull(id)
    }

    fun getAllBankAccounts(): List<BankAccount>?{
        return bankAccountRepository.findAll()?.toList()
    }

}