package edu.berliner.studentdatabase.repositories;

import edu.berliner.studentdatabase.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long>
{
}
