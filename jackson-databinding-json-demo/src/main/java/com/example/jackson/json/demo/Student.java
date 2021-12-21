package com.example.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter@Setter
public class Student {
    private  int id;
    private  String firstName;
    private String lastName;
    private boolean active;
    private Address address;
    private String[] languages;
    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", address=" + address +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}
