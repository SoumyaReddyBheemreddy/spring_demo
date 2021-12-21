package com.hibernate.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@Getter @Setter
public class Instructor {
    //annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // ** set up mapping to InstructorDetail

    // create Constructors

    //generate getters and setter methods

    // generate toString() method
    public Instructor(){

    }
    public Instructor(String firstName, String lastName, String email) {
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
    }
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private int id;
   @Column(name = "first_name")
    private String FirstName;
   @Column(name = "last_name")
    private String LastName;
   @Column(name = "email")
    private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="instructor_detail_id")
   private  InstructorDetail instructorDetail;

   @OneToMany(mappedBy = "instructor",cascade =  {CascadeType.PERSIST,CascadeType.DETACH,
           CascadeType.MERGE,CascadeType.REFRESH})
   private List<Course> courses;


    // add convenience methods for bidirectional relationship
    public  void add(Course course){
        if(courses==null){
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
