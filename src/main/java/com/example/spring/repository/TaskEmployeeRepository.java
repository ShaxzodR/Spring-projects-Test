package com.example.spring.repository;

import com.example.spring.domain.TaskEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskEmployeeRepository extends JpaRepository<TaskEmployee,Long> {
}
