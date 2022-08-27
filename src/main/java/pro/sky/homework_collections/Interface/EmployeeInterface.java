package pro.sky.homework_collections.Interface;

import pro.sky.homework_collections.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String fullName);
    Employee findEmployee(String fullName);
    Map<String, Employee> printAllEmployees();
}
