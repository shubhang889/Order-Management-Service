package org.example;


//Build the following functionalities of a concurrent order management system. Define an order entity of your choice having multiple order items.
//        Requirements:
//        Develop a RESTful API using Java Spring Boot to handle concurrent operations for managing orders.
//        Implement following endpoints:
//        Creating a new order ( Order can contain one or more order items)
//        Updating the status of an order
//        Utilize concurrent data structures or mechanisms to support concurrent access to orders.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
