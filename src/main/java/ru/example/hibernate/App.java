package ru.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.example.hibernate.model.Director;
import ru.example.hibernate.model.Item;
import ru.example.hibernate.model.Movie;
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
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = session.get(Director.class, 2);

            Movie movie = director.getMovies().remove(2);

            session.remove(movie);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}
