package com.hibernate.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
@Getter @Setter
public class InstructorDetail {
    //annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create Constructors

    //generate getters and setter methods

    // generate toString() method
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;
    //add new field
    // add @OneToOne for bidirectional
    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    private Instructor instructor;
    public  InstructorDetail(){

    }
    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
