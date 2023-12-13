package org.example.main;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(Connection myConn = DatabaseConnection.getInstance()) {

            if(myConn.getAutoCommit()){
                myConn.setAutoCommit(false);
            }

            try {
                Repository<Employee> repository = new EmployeeRepository(myConn);
                System.out.println("-------Insertar un nuevo cliente-------");
                Employee employee = new Employee();
                /*employee.setFirstName("America");
                employee.setPaSurName("Lopez");
                employee.setMaSurName("Villa");
                employee.setEmail("ame2@example.com");
                employee.setSalary(3000F);
                employee.setCurp("AMEC14257894EDFRT3");
                repository.save(employee);
                myConn.commit();*/

                employee.setFirstName("David");
                employee.setPaSurName("Gutierrez");
                employee.setMaSurName("Olvera");
                employee.setEmail("olv2@example.com");
                employee.setSalary(3000F);
                employee.setCurp("AMEC14257894EDFRT3");
                repository.save(employee);
                myConn.commit();
            } catch (SQLException e) {
                myConn.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}