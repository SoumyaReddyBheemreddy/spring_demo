package com.hibernate.sample;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try {
            //start a transaction
            session.beginTransaction();
            //query students
            List<Student> students = session.createQuery("from Student").list();
            //display the student
            displayStudents(students);
            //query students : lastName="Doe"
            students = session.createQuery("from Student s where s.lastName='Doe'").list();

            System.out.println("Student who have last name is Doe");
            displayStudents(students);

            // query students: lastName='Doe' Or firstName='Daffy'

            students = session.createQuery("from Student s where s.firstName='Daffy' or s.lastName='Doe'").list();

            System.out.println("Student who have last name is Doe or first name Daffy");
            displayStudents(students);

            // query student where email LIKE 'gmail.com'
            students = session.createQuery("from Student s where " +
                    "s.email LIKE '%gmail.com'").list();
            System.out.println("student whose email LIKE %gmail.com");
            displayStudents(students);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for(Student student: students){
            System.out.println(student);
        }
    }
}
