package ppp.service;

import ppp.dao.ItemDAOimpl;
import ppp.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vlad on 04.03.14.
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemDAOimpl subjectDAO;

    @Transactional
    public void addSubject(Item item) {
        subjectDAO.addSubject(item);
    }

    @Transactional
    public List<Item> listSubject() {
        return subjectDAO.listSubject();
    }

    @Transactional
    public void removeSubject(Integer id) {
        subjectDAO.removeSubject(id);
    }

    @Override
    @Transactional
    public Item getSubjectById(Integer id) {
        return subjectDAO.getSubjectById(id);
    }
}