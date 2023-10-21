package org.example.model;

public class Employee {
    private Integer id;
    private String firstName;
    private String paSurName;
    private String maSurName;
    private String email;
    private Float salary;

    public Employee() {
    }

    public Employee(Integer id, String firstName, String paSurName, String maSurName, String email, Float salary) {
        this.id = id;
        this.firstName = firstName;
        this.paSurName = paSurName;
        this.maSurName = maSurName;
        this.email = email;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPaSurName() {
        return paSurName;
    }

    public void setPaSurName(String paSurName) {
        this.paSurName = paSurName;
    }

    public String getMaSurName() {
        return maSurName;
    }

    public void setMaSurName(String maSurName) {
        this.maSurName = maSurName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", paSurName='" + paSurName + '\'' +
                ", maSurName='" + maSurName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
