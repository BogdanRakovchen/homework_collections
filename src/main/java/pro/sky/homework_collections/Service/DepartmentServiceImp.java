package pro.sky.homework_collections.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.Interface.DepartmentInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentInterface {

    private final EmployeeServiceImp employeeServiceImp;

    public DepartmentServiceImp(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }


//
//        @Override
//        public void printAllEmployeesFromDepartment(String department) {
//        for (int i = 0; i < size; i++) {
//            if(employees[i].getDepartmentEmployee() == department) {
//                System.out.println("Сотрудники " + employees[i].getFullNameEmployee() + ": " + employees[i].getDepartmentEmployee());
//            }
//        }
//    }

//    @Override
//    public String printAllEmployeesFromAllDepartment(String department) {}
    @Override
    public Employee findEmployeeWithMaxSalary(String departmentId) {

       Employee employeeMaxSalary =  employeeServiceImp.employees.values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(employee -> employee.getSalary())).orElseThrow();

       return employeeMaxSalary;
    }
    @Override
    public Employee findEmployeeWithMinSalary(String departmentId) {

        Employee employeeMinSalary =  employeeServiceImp.employees.values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(employee -> employee.getSalary())).orElseThrow();

        return employeeMinSalary;
    }

    @Override
    public List<Employee> findAllEmployeesOfDepartment(String departmentId) {
        List<Employee> employeeMinSalary =  employeeServiceImp.employees.values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId)).collect(Collectors.toList());

        return employeeMinSalary;
    }

    @Override
    public List<String> findAllEmployeesOfDepartments() {
        List<String> employeeMinSalary =  employeeServiceImp.employees.values().stream()
                .map(e -> "Department " + e.getDepartment() + " : " + e.getFirstName() + " " + e.getLastName()
                + " " + e.getSalary()).collect(Collectors.toList());


        return employeeMinSalary;
    }




}
