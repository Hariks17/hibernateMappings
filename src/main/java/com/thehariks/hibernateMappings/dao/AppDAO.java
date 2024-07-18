package com.thehariks.hibernateMappings.dao;

import com.thehariks.hibernateMappings.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void delete(int id);
}
