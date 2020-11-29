package sk.itsovy.ganoczi.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Employee;
import sk.itsovy.ganoczi.hibernate.entity.Manager;

import java.sql.SQLOutput;

public class GetManager {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 1;

            Manager manager=session.get(Manager.class,id);


            System.out.println(manager.getFirstName() +" "+ manager.getLastName());
            System.out.println("List of employees "+ manager.getEmployees());

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
