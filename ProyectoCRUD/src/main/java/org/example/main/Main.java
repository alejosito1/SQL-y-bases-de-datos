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

//            System.out.println("---Actualizando un empleado---");
//            Employee employee = new Employee();
//            employee.setId(4);
//            employee.setFirstName("Diego");
//            employee.setPaSurName("Pimentel");
//            employee.setMaSurName("Villanueva");
//            employee.setEmail("diego@gmail.com");
//            employee.setSalary(30000F);
//            repository.save(employee);

            System.out.println("---Empleado eliminado---");
            repository.delete(4);

            System.out.println("---Listando---");
            repository.findAll().forEach(System.out::println);
        }
    }
}