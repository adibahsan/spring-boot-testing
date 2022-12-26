package com.adibahsan.springbootkttesting.service

import com.adibahsan.springbootkttesting.entity.BankAccount
import com.adibahsan.springbootkttesting.repository.BankAccountRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.data.repository.findByIdOrNull

class BankAccountServiceTest {
    private val bankAccountRepository: BankAccountRepository = mockk()
    val bankAccountService = BankAccountService(bankAccountRepository)
    val bankAccount = BankAccount("1", "accc", "name", 1)

    @Test
    fun `when getBankAccount then return the BankAccount`() {
        //given
        every {
            bankAccountRepository.findByIdOrNull(1)
        } returns bankAccount

        // when
        val result = bankAccountService.getBankAccount(1)

        //then
        verify(exactly = 1) {
            bankAccountRepository.findByIdOrNull(1)
        }
        assertEquals(bankAccount, result)
    }
}