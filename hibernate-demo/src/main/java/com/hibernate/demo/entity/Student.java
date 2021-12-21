package com.hibernate.demo.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
//step:1 Map class to database table
@Entity
@Table(name = "student")
@Getter@Setter
public class Student {
    //step 2 : Map fields to database columns
    @Id
    //by default it generate generated value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    // define no-arg constructor
    Student(){
    }
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
