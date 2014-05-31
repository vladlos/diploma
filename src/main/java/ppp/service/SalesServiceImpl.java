package ppp.service;

import ppp.dao.SalesDAOimpl;
import ppp.domain.Sales;
import ppp.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vlad on 28.05.14.
 */
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDAOimpl subjectDAO;

    @Override
    @Transactional
    public void addSale(Sales sale) {
        subjectDAO.addSale(sale);
    }

    @Override
    @Transactional
    public List<Sales> listSales(Item s) {
        return subjectDAO.listSales(s);
    }

    @Override
    @Transactional
    public void removeSale(Integer id) {
        subjectDAO.removeSale(id);
    }
}
