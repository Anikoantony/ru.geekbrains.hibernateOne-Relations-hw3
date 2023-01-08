package ru.mvgrebenyuk.hiberOne;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class CostumerDao {
    @Autowired
    SessionFactoryUtils sessionFactoryUtils;

    public CostumerDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;}

    public void byIdCostumersFindManyProducts (long id)
    {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Costumer costumer = session.get(Costumer.class,id);
        System.out.println("Все продукты Many покупателя " + costumer);
        for (Product product: costumer.getProductsMany()
             ) {
            System.out.println(product);

        }
    }

    public void byIdCostumerFindProduct (Long id)
    {

        // 3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров,
        // и по id товара узнавать список покупателей этого товара;

        try {
            Session session = sessionFactoryUtils.getSession();
            session.beginTransaction();
            Costumer costumer=session.get(Costumer.class,id);
            List<Product> products = costumer.getProducts();
            System.out.println("Список купленных товаров покупателем " + costumer);
            for (Product product:products
                 ) {
                System.out.println(product);
                }

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    public Costumer findById(Long id)
    {
        try {
            Session session=sessionFactoryUtils.getSession();
            session.beginTransaction();
            Costumer costumer= session.get(Costumer.class,id);
            session.getTransaction().commit();
            return costumer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
