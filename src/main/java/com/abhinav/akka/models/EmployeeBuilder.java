package com.abhinav.akka.models;

public class EmployeeBuilder {
    private Integer id;
    private String name;
    private String dept;

    public EmployeeBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public Employee createEmployee() {
        return new Employee(id, name, dept);
    }
}