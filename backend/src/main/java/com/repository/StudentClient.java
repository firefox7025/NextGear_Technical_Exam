package com.repository;

import com.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>Student Client Repository</h1>
 * <p>Using spring date repository, provides basic crud operations</p>
 */
@Repository
public interface StudentClient extends CrudRepository<Student, String> {
}