package pro.sky.homework_collections.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.Interface.EmployeeInterface;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeInterface {

    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Иван Иванов",
            new Employee("Иван", "Иванов"),
            "Федор Румянцев",
            new Employee( "Федор","Румянцев"),
            "Анастасия Сидорова",
            new Employee( "Анастасия","Сидорова"),
            "Андрей Копылов",
           new Employee( "Андрей", "Копылов"),
            "Виктор Станиславский",
            new Employee( "Виктор", "Станиславский")
)
    );

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        employees.put(firstName + " " + lastName, employee);

        Iterator<Employee> employeeIterator = employees.values().iterator();
        if(employeeIterator.next().getFirstName().equals(firstName) && employeeIterator.next().getLastName().equals(lastName) ) {
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

