package com.spd.testing.service;

import com.spd.testing.dao.SubjectDAOimpl;
import com.spd.testing.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vlad on 04.03.14.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAOimpl subjectDAO;

    @Transactional
    public void addSubject(Subject subject) {
        subjectDAO.addSubject(subject);
    }

    @Transactional
    public List<Subject> listSubject() {
        return subjectDAO.listSubject();
    }

    @Transactional
    public void removeSubject(Integer id) {
        subjectDAO.removeSubject(id);
    }
}