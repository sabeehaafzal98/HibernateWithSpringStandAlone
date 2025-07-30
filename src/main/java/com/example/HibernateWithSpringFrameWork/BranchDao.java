package com.example.HibernateWithSpringFrameWork;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BranchDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Branch branch) {
        entityManager.persist(branch);
    }

    public Branch find(int id) {
        return entityManager.find(Branch.class, id);
    }
}
