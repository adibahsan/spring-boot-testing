package com.adibahan.springtester.repository;

import com.adibahan.springtester.model.Employee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @DisplayName("JUnit Test For Saving Employee Object to the DB")
    @Test
    void saveAnObjectToTheRepo() {
        //given (getting the given info)
        Employee employee = Employee.builder()
                .firstName("adib")
                .lastName("chowdhury")
                .email("email@ecom.com")
                .build();
        //when (running the testing)
        Employee savedEmployee = employeeRepository.save(employee);

        // then (verifying)

        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);

    }
}
