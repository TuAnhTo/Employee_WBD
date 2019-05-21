package com.codegym.cms.repository;

import com.codegym.cms.model.Employee;
import com.codegym.cms.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Iterable<Employee> findAllByTeam(Team team);
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
