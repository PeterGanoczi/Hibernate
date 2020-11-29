package sk.itsovy.ganoczi.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Employee;
import sk.itsovy.ganoczi.hibernate.entity.Manager;


public class UpdateManager {
    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session=sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 1;

            Manager manager=session.get(Manager.class,id);

            manager.setShopName("Nay elektrodom");

            session.getTransaction().commit();
            System.out.println("Employee successfully deleted!");
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
