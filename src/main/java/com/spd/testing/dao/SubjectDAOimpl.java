package com.spd.testing.dao;


import com.spd.testing.domain.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vlad on 05.03.14.
 */
@Component
public class SubjectDAOimpl {
    @Autowired
    private SessionFactory sessionFactory;

    public void addSubject(Subject subject) {
        sessionFactory.getCurrentSession().save(subject);
    }

    public List<Subject> listSubject() {

        return sessionFactory.getCurrentSession().createQuery("from Subject").list();
    }

    public void removeSubject(Integer id) {
        Subject subject = (Subject) sessionFactory.getCurrentSession().load(Subject.class, id);
        if (null != subject) {
            sessionFactory.getCurrentSession().delete(subject);
        }
    }
}
