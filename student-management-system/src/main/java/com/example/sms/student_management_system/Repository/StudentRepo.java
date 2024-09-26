package com.example.sms.student_management_system.Repository;


import com.example.sms.student_management_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
