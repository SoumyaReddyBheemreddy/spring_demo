package com.example.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args){
        try {
            //create object mapper
            ObjectMapper mapper = new ObjectMapper();
            //read JSON file and map/convet to Java POJO:
            //data/sample0-lite.json
            Student student = mapper.readValue(new File("data/sample-full.json"),Student.class);

            //print first name and last name
            System.out.println("First Name= "+student.getFirstName());
            System.out.println("Last Name= "+student.getLastName());
            Address address = student.getAddress();
            System.out.println("street= "+address.getStreet());
            System.out.println("city= "+address.getCity());
            System.out.println("Languages: ");
            for(String language:student.getLanguages())
                System.out.println("        "+language);
            //System.out.println(student);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
