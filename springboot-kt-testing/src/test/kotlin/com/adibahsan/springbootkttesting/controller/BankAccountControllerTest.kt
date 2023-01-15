package com.adibahsan.springbootkttesting.controller

import com.adibahsan.springbootkttesting.entity.BankAccount
import com.adibahsan.springbootkttesting.service.BankAccountService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [BankAccountController::class])

class BankAccountControllerTest{

    @MockkBean
    lateinit var bankAccountService: BankAccountService

    @Autowired
    lateinit var mockMvc: MockMvc
    val bankAccount = BankAccount("1", "accc", "name", 1)

    @Test
    fun `giving existing bank account when get request returns BankAccount json with 200 HTTP status code`(){

        every { bankAccountService.getBankAccount(1) } returns bankAccount

        mockMvc.perform(get("/api/bankAccount/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))

    }
}