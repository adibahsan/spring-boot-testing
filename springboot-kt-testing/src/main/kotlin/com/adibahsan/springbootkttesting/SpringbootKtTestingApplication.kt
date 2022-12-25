package com.adibahsan.springbootkttesting

import com.adibahsan.springbootkttesting.entity.BankAccount
import com.adibahsan.springbootkttesting.service.BankAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootKtTestingApplication : CommandLineRunner {

    @Autowired
    lateinit var bankAccountService: BankAccountService
    override fun run(vararg args: String?) {
        bankAccountService.addBankAccount(
            BankAccount("1", "1", "John")
        )
        bankAccountService.addBankAccount(
            BankAccount("2", "2", "Doe")
        )
        bankAccountService.addBankAccount(
            BankAccount("3", "3", "Soe")
        )
    }
}

fun main(args: Array<String>) {
    runApplication<SpringbootKtTestingApplication>(*args)
}
