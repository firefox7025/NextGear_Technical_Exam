package com.repository;

import com.domain.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>Faculty Client</h1>
 * <p>
 *     This client, allows for crud operations on the faculty table.
 * </p>
 */
@Repository
public interface FacultyClient extends CrudRepository<Faculty, Long> {
        }
