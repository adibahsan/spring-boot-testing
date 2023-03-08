package com.adibahan.springtester.repository;

import com.adibahan.springtester.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmail(String Email);
}
