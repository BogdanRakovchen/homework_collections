package pro.sky.homework_collections.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.Interface.DepartmentInterface;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentInterface {

    private final EmployeeServiceImp employeeServiceImp;

    public DepartmentServiceImp(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(String departmentId) {

       Employee employeeMaxSalary =  employeeServiceImp.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(employee -> employee.getSalary())).orElseThrow(() -> new RuntimeException("Employee not found"));

       return employeeMaxSalary;
    }
    @Override
    public Employee findEmployeeWithMinSalary(String departmentId) {

        Employee employeeMinSalary =  employeeServiceImp.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(employee -> employee.getSalary())).orElseThrow(() -> new RuntimeException("Employee not found"));

        return employeeMinSalary;
    }

    @Override
    public List<Employee> findAllEmployeesOfDepartment(String departmentId) {
        List<Employee> employeesOfDepartment =  employeeServiceImp.getEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId)).collect(Collectors.toList());

        return employeesOfDepartment;
    }

    @Override
    public List<String> findAllEmployeesOfDepartments() {
        List<String> employeesOfDepartments =  employeeServiceImp.printAllEmployees().values().stream()
                .map(e -> "Department " + e.getDepartment() + " : " + e.getFirstName() + " " + e.getLastName()
                + " " + e.getSalary()).collect(Collectors.toList());

        employeesOfDepartments.sort(Comparator.naturalOrder());
        return employeesOfDepartments;
    }




}
