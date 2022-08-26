package pro.sky.homework_collections.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.RuntimeExceptios.EmployeeAlreadyAdded;
import pro.sky.homework_collections.RuntimeExceptios.EmployeeNotFoundException;
import pro.sky.homework_collections.RuntimeExceptios.EmployeeStorageIsFullException;
import pro.sky.homework_collections.Service.EmployeeServiceImp;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }
    @GetMapping(path = "/add")
    public List<Employee> addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImp.addEmployee(firstName, lastName);

        } catch (EmployeeAlreadyAdded | EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImp.removeEmployee(firstName, lastName);

        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImp.findEmployee(firstName, lastName);

        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/print")
    public List<Employee> printAllEmployees() {
        try {
            return employeeServiceImp.printAllEmployees();

        } catch (EmployeeNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
