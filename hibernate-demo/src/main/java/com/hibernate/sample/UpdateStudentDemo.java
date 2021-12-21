package com.hibernate.sample;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //use the session object to save Java object
            //start a transaction
            session.beginTransaction();
            int studentId = 4;
            //retrieve student based on the id: primary key
            System.out.println("Getting student. Generated id:"+studentId);
            Student myStudent = session.get(Student.class,studentId);
            System.out.println("Updating student..."+myStudent);
            myStudent.setEmail("mary@gmail.com");
            //commit the transaction
            session.getTransaction().commit();
            //new code
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            System.out.println("Done!");
            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
