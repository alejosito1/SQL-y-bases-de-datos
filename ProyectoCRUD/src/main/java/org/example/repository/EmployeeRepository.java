package org.example.repository;

import org.example.model.Employee;
import org.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee>{

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try(Connection myConn = getConnection();
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employee")){
            while(myRes.next()){
                Employee e = createEmployee(myRes);
                employees.add(e);
            }
        }
        return employees;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(Connection myConn = getConnection();
            PreparedStatement myStamt = myConn.prepareStatement("SELECT  * FROM employee WHERE id = ?")) {
            myStamt.setInt(1,id);
            try(ResultSet myRes = myStamt.executeQuery()) {
                if(myRes.next()){
                    employee = createEmployee(myRes);
                }
            }
        }
        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql;
        if(employee.getId() != null && employee.getId()>0){
            sql = "UPDATE employee SET firstName=?, paSurName=?, maSurName=?, email=?, salary=?, curp=? WHERE id=?";
        } else {
            sql = "INSERT INTO employee (firstName, paSurName, maSurName, email, salary, curp) VALUES (?,?,?,?,?,?)";
        }
        try(Connection myConn = getConnection();
            PreparedStatement myStamt = myConn.prepareStatement(sql)){
            myStamt.setString(1, employee.getFirstName());
            myStamt.setString(2,employee.getPaSurName());
            myStamt.setString(3, employee.getMaSurName());
            myStamt.setString(4,employee.getEmail());
            myStamt.setFloat(5,employee.getSalary());
            myStamt.setString(6, employee.getCurp());

            if(employee.getId() != null && employee.getId()>0){
                myStamt.setInt(7,employee.getId());
            }
            myStamt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(Connection myConn = getConnection();
            PreparedStatement myStamt = myConn.prepareStatement("DELETE FROM employee WHERE id=?")) {
            myStamt.setInt(1,id);
            myStamt.executeUpdate();
        }

    }
    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirstName(myRes.getString("firstName"));
        e.setPaSurName(myRes.getString("paSurName"));
        e.setMaSurName(myRes.getString("maSurName"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        e.setCurp(myRes.getString("curp"));
        return e;
    }
}
