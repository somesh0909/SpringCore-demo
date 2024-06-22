package Repository;

import java.util.List;
import java.util.Optional;

import entity.Student;

public interface StudentRepository {
	
	Student insert(Student student);
	void delete (int id);
	void update(int id, Student student);
	
	List<Student> getAll();
	Optional<Student> get(int id);

}
