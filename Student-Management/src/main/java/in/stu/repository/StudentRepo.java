package in.stu.repository;

import in.stu.entity.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentData, Integer> {

    public StudentData findByRollNumber(String rollNumber);
}
