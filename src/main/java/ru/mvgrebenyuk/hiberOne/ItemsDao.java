package ru.mvgrebenyuk.hiberOne;

import java.util.List;

public interface ItemsDao {

    Items findByid(Long id);

    List<Items> findAllItems();

    Items findByName(String name);

    void save(Items items);


    void updateByName(Long id, String name);


}
