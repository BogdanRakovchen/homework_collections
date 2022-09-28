package pro.sky.homework_collections.Interface;

import pro.sky.homework_collections.Employee;

import java.util.Map;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName, String department, int salary);

    Employee removeEmployee(String fullName);
    Employee findEmployee(String fullName);
    Map<String, Employee> printAllEmployees();
}
