package ppp.service;

import ppp.domain.Item;
import ppp.domain.Sales;

import java.util.List;

/**
 * Created by Vlad on 28.05.14.
 */
public interface SalesService {
    public void addSale(Sales sale);
    public List<Sales> listSales(Item s);
    public void removeSale(Integer id);

}