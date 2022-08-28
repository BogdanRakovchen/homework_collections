package pro.sky.homework_collections.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_collections.Employee;
import pro.sky.homework_collections.Service.DepartmentServiceImp;
import pro.sky.homework_collections.Service.EmployeeServiceImp;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/departments")


public class DepartmentController {
  
    private final DepartmentServiceImp departmentServiceImp;

    public DepartmentController(DepartmentServiceImp departmentServiceImp) {
        this.departmentServiceImp = departmentServiceImp;
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("departmentId") String departmentId) {
        return  departmentServiceImp.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam("departmentId") String departmentId) {
        return  departmentServiceImp.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> findAllEmployeesOfDepartment(@RequestParam("departmentId") String departmentId) {
        return  departmentServiceImp.findAllEmployeesOfDepartment(departmentId);
    }


    @GetMapping(path = "/all")
    public List<String> findAllEmployeesOfDepartments() {
        return departmentServiceImp.findAllEmployeesOfDepartments();
    }


}
