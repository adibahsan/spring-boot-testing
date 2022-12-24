package com.adibahsan.springbootkttesting.controller

import com.adibahsan.springbootkttesting.entity.BankAccount
import com.adibahsan.springbootkttesting.service.BankAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bankAccount")
class BankAccountController(var bankAccountService: BankAccountService) {

    @PostMapping
    fun addBankAccount(@RequestBody bankAccount: BankAccount) : ResponseEntity<BankAccount> {
        return ResponseEntity.ok(bankAccountService.addBankAccount(bankAccount))
    }
    @GetMapping("/{id}")
    fun getBankAccount(@PathVariable id:Long) : ResponseEntity<BankAccount> {
        var bankAccount: BankAccount? = bankAccountService.getBankAccount(id);
        if (bankAccount != null) {
            return ResponseEntity(bankAccount, HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}