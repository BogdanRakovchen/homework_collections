package pro.sky.homework_collections.Service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Service;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.Interface.EmployeeInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeInterface {

    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        for (int i = 0; i < employees.size() - 1; i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                throw new RuntimeException("is already");
            }

        }
        if (employees.size() > 10) {
            throw new RuntimeException("is full");
        }

        return employees;

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        for(Employee employee1 : employees ) {
            if(employees.contains(employee1)) {
                int newEmployee;
                newEmployee = employees.indexOf(employee);
                return employees.remove(newEmployee);
            } else {
                throw new RuntimeException("not found employee");
            }
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        for(Employee employee1 : employees ) {
            if(employees.contains(employee1)) {
                int newEmployee;
                newEmployee = employees.indexOf(employee);
                return employees.get(newEmployee);
            } else {
                throw new RuntimeException("not found employee");
            }
        }

        return employee;

    }
    @Override
    public List<Employee> printAllEmployees() {
        return new ArrayList<>(employees);
    }

}

