package ppp.service;
import ppp.domain.Item;

import java.util.List;

/**
 * Created by Vlad on 04.03.14.
 */

public interface ItemsService {
    public void addSubject(Item item);
    public List<Item> listSubject();
    public void removeSubject(Integer id);
    public Item getSubjectById(Integer id);

}