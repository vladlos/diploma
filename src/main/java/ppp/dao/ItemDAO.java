package ppp.dao;

import ppp.domain.Item;

import java.util.List;

/**
 * Created by Vlad on 05.03.14.
 */
public interface ItemDAO {
        public void addSubject(Item item) ;
        public List<Item> listSubject() ;
        public void removeSubject(Integer id) ;
        public Item getSubjectById(Integer id);
}
