package com.example.sms.student_management_system.Service.SerrviceImpl;

import com.example.sms.student_management_system.Entity.Student;
import com.example.sms.student_management_system.Repository.StudentRepo;
import com.example.sms.student_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudents() {
        return this.studentRepo.findAll();

    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
