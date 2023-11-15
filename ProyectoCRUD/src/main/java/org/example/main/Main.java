package org.example.main;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DatabaseConnection;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(Connection myConn = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();

            System.out.println("---Listando---");
            repository.findAll().forEach(System.out::println);
//
//            System.out.println("---Insertando un empleado---");
//            Employee employee = new Employee();
//            employee.setFirstName("Diego");
//            employee.setPaSurName("Pimentel");
//            employee.setMaSurName("Gutierrez");
//            employee.setEmail("diego@gmail.com");
//            employee.setSalary(19000F);
//            repository.save(employee);


            System.out.println("---Nuevo empleado insertado---");
            repository.findAll().forEach(System.out::println);
        }
    }
}