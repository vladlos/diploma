package ppp.dao;


import ppp.domain.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vlad on 05.03.14.
 */
@Component
public class ItemDAOimpl implements ItemDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addSubject(Item item) {
        sessionFactory.getCurrentSession().save(item);
    }

    public List<Item> listSubject() {

        return sessionFactory.getCurrentSession().createQuery("from Item").list();
    }

    public void removeSubject(Integer id) {
        Item item = (Item) sessionFactory.getCurrentSession().load(Item.class, id);

        if (null != item) {
            sessionFactory.getCurrentSession().delete(item);
        }
    }

    @Override
    public Item getSubjectById(Integer id) {


        return (Item) sessionFactory.getCurrentSession().load(Item.class, id);
    }
}
