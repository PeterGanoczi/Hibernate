package sk.itsovy.ganoczi.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Employee;
import sk.itsovy.ganoczi.hibernate.entity.Manager;

public class CreateEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id=1;
            Manager manager=session.get(Manager.class, id);

            Employee employee1=new Employee("Marko", "Mrkvicka");
            Employee employee2=new Employee("Monika", "Benova");

            manager.add(employee1);
            manager.add(employee2);

            session.save(employee1);
            session.save(employee2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
