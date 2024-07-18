package com.thehariks.hibernateMappings.dao;

import com.thehariks.hibernateMappings.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager){
        this.entityManager =entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
    entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
       return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);

        entityManager.remove(instructor);
    }
}
