package com.hibernate.sample;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
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
            int studentId = 5;
            //retrieve student based on the id: primary key
            System.out.println("Getting student. Generated id:"+studentId);
            Student myStudent = session.get(Student.class,studentId);
           //delete the student
            System.out.println("Deleting student..."+myStudent);
            session.delete(myStudent);
            // delete student id = 1
            System.out.println("Deleting student id = 1");
            session.createQuery("delete from Student s where id = 1").executeUpdate();
            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
