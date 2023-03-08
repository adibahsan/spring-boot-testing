package com.adibahan.springtester.repository;

import com.adibahan.springtester.model.Employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);

    }

    @DisplayName("Saving All Users ")
    @Test
    void savingListOfUsers() {

        //given (precondition or setup)
        Employee employee = Employee.builder()
                .firstName("adib")
                .lastName("chowdhury")
                .email("email@ecom.com")
                .build();
        Employee employee2 = Employee.builder()
                .firstName("adib")
                .lastName("chowdhury")
                .email("email2@ecom.com")
                .build();
        Employee employee3 = Employee.builder()
                .firstName("adib")
                .lastName("chowdhury")
                .email("email3@ecom.com")
                .build();

        List<Employee> employeeList = List.of(employee, employee2, employee3);

        //when (action or behavior that we are testing
        List<Employee> savedEmployeeList = employeeRepository.saveAll(employeeList);

        //verify the output
        assertThat(savedEmployeeList).isNotNull();
        assertThat(savedEmployeeList.size()).isEqualTo(3);
    }


}
