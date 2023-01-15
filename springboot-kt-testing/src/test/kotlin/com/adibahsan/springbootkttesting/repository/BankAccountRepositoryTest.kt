package com.adibahsan.springbootkttesting.repository

import com.adibahsan.springbootkttesting.entity.BankAccount
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class BankAccountRepositoryTest {

    @Autowired
    lateinit var entityManager : TestEntityManager

    @Autowired
    lateinit var bankAccountRepository: BankAccountRepository

    @Test
    fun `find by id returning bank account`(){
        val bangladeshBank = BankAccount("BD", "123ING456", "JOHN SMITH")
        entityManager.persistAndFlush(bangladeshBank)

        val accountFound = bankAccountRepository.findByIdOrNull(bangladeshBank.id!!)

        assertThat(accountFound == bangladeshBank)

    }
}