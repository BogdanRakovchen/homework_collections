package pro.sky.homework_collections.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.Interface.EmployeeInterface;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeInterface {

    Map<String, Employee> employees = new HashMap<>(Map.of(
                    "1",
                    new Employee("Иван", "Иванов", "1", 50_145),
                    "2",
                    new Employee( "Федор","Румянцев", "1", 70_445),
                    "3",
                    new Employee( "Анастасия","Сидорова", "2", 56_132),
                    "4",
                    new Employee( "Андрей", "Копылов", "2", 52_545),
                    "5",
                    new Employee( "Виктор", "Станиславский", "3", 65_346)
            )
    );

    @Override
    public Employee addEmployee(String firstName, String lastName, String department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);

        employees.put(firstName + " " + lastName, employee);

        Iterator<Employee> employeeIterator = employees.values().iterator();
        if(employeeIterator.next().getFirstName().equals(firstName) && employeeIterator.next().getLastName().equals(lastName)) {
            throw new RuntimeException("is already");

        }
        if (employees.size() > 10) {
            throw new RuntimeException("is full");
        }

        return employee;

    }

    @Override
    public Employee removeEmployee(String fullName) {
        if(employees.containsKey(fullName)) {
            return employees.remove(fullName);
        } else {
            throw new RuntimeException("not found employee");
        }

    }

    @Override
    public Employee findEmployee(String fullName) {
        if(employees.containsKey(fullName)) {
            return employees.get(fullName);
        } else {
            throw new RuntimeException("not found employee");
        }
    }
    @Override
    public Map<String, Employee> printAllEmployees() {
        return new HashMap<>(employees);
    }


}

