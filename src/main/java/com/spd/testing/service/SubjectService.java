package com.spd.testing.service;
import com.spd.testing.domain.Subject;
import java.util.List;

/**
 * Created by Vlad on 04.03.14.
 */

public interface SubjectService {
    public void addSubject(Subject subject);
    public List<Subject> listSubject();
    public void removeSubject(Integer id);

}