package ru.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.example.hibernate.model.Item;
import ru.example.hibernate.model.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class,2);

            List<Item> items = person.getItems();

            for (Item item:items) {
                session.remove(item);
            }

            person.getItems().clear();


            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}
