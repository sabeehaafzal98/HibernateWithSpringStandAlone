package com.example.HibernateWithSpringFrameWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class BranchService {
    @Autowired
    private BranchDao branchDao;

    @Transactional
    public void saveBranch(Branch branch) throws IOException {
        branchDao.save(branch);

    }
}

