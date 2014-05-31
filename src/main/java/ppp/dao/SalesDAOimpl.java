package ppp.dao;

import ppp.domain.Sales;
import ppp.domain.Item;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vlad on 28.05.14.
 */

@Component
public class SalesDAOimpl implements SalesDAO{
@Autowired
private SessionFactory sessionFactory;

    @Override
    public void addSale(Sales sale) {
        sessionFactory.getCurrentSession().save(sale);
    }

    @Override
    public List<Sales> listSales(Item s) {


        List<Sales> result= sessionFactory.getCurrentSession().createCriteria(Sales.class).add(Restrictions.eq("subject.id",s.getId())).list();

        return result;
    }

    @Override
    public void removeSale(Integer id) {
        Sales sale = (Sales) sessionFactory.getCurrentSession().load(Sales.class, id);
        if (null != sale) {
            sessionFactory.getCurrentSession().delete(sale);
        }
    }
}
