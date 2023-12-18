package org.example.main;

import org.example.entity.Employee;
import org.example.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();

        System.out.println("------LISTAR TODOS------");
        employees.forEach(System.out::println);

        System.out.println("------BUSCAR UNO------");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado" + employee);
//
//        System.out.println("------CREAR UNO------");
//        Employee newEmployee = new Employee();
//        newEmployee.setFirstName("Diego");
//        newEmployee.setPaSurName("Lechuga");
//        newEmployee.setMaSurName("Pimentel");
//        newEmployee.setEmail("siego@example.com");
//        newEmployee.setSalary(4200F);
//
//        em.getTransaction().begin();
//        em.persist(newEmployee);
//        em.getTransaction().commit();
//
//        System.out.println("Nuevo empleado creado: " + newEmployee);

        /*System.out.println("------ACTUALIZAR-------");
        int employeeUpdateId = 2;
        Employee employeeToUpdate = em.find(Employee.class, employeeUpdateId);
        System.out.println("Empleado a modificcar: " + employeeToUpdate);

        employeeToUpdate.setFirstName("Irving");
        employeeToUpdate.setPaSurName("Juarez");
        employeeToUpdate.setSalary(97000F);

        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();
        System.out.println("Empleado actualizado: "+ employeeToUpdate);*/

        System.out.println("------ELIMINAR-------");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empleado a eliminar: "+employeeToDelete);

        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();


    }
}