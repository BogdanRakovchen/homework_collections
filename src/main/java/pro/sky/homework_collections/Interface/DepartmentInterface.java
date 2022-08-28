package pro.sky.homework_collections.Interface;

import pro.sky.homework_collections.Employee;

import java.util.List;

public interface DepartmentInterface {

    List<String> findAllEmployeesOfDepartments();
    List<Employee> findAllEmployeesOfDepartment(String department);
    Employee findEmployeeWithMaxSalary(String department);
    Employee findEmployeeWithMinSalary(String department);

}
