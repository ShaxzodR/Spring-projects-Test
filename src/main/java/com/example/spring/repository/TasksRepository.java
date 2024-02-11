package com.example.spring.repository;

import com.example.spring.domain.Employee;
import com.example.spring.domain.Task;
import com.example.spring.domain.enumation.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task,Long> {
    @Query("SELECT COUNT(t) FROM Task t WHERE t.employee.id = :employeeId")
    Long countTasksByEmployeeId(Long employeeId);

    @Query("select t from Task  t where t.title=:title")
    List<Task> findByTitle(String title);
    @Query("select t from Task  t where t.text=:text")
    List<Task> findByText(String text);
    @Query("select t from Task  t where t.deadline=:deadline")
    List<Task> findByDeadline(@Param("deadline") Date deadline);
    @Query("select t from Task  t where t.status=:status")
    List<Task> findByStatus(Status status);

    @Query("select e from Task e where e.employee.id =:employeeId ")
    List<Task> findAllByEmployeeId(@Param("employeeId") Long employeeId);
}
