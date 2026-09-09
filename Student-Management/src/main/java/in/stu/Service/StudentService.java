package in.stu.Service;

import in.stu.StudentManagementApplication;
import in.stu.entity.StudentData;
import in.stu.exception.ResourceNotFoundException;
import in.stu.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentData  createStudent(StudentData student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        return studentRepo.save(student);
    }

    public StudentData getStudentById(Integer id) {
        return studentRepo.findById(id).orElseThrow( () ->
                   new ResourceNotFoundException("Student with id" + id + " Not found"));
    }

    public StudentData getStudentByRollNumber(String rollNumber) {
        return studentRepo.findByRollNumber(rollNumber);
    }

    public List<StudentData> getAllStudents() {
        return studentRepo.findAll();
    }
    public StudentData updateStudent(Integer id,StudentData student) {
        StudentData existingData = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));

        existingData.setName(student.getName());
        existingData.setCourse(student.getCourse());
        existingData.setEmail(student.getEmail());
        existingData.setRollNumber(student.getRollNumber());

        return studentRepo.save(existingData);
    }

    public String deleteStudent(Integer id) {
        if(!studentRepo.existsById(id)) {
            throw new ResourceNotFoundException("Student with id " + id + " not found");
        } else {
            studentRepo.deleteById(id);
            return "Student with id " + id + " deleted successfully";
        }
    }
}
