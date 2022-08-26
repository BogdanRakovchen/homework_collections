package pro.sky.homework_collections.Interface;

import pro.sky.homework_collections.Employee;

import java.util.List;

public interface EmployeeInterface {
    List<Employee> addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> printAllEmployees();
}
