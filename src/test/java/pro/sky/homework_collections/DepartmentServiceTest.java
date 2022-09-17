package pro.sky.homework_collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_collections.Service.EmployeeServiceImp;

import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Spy
    private final EmployeeServiceImp employeeServiceImp;

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;






    public DepartmentServiceTest() {
        this.employeeServiceImp = new EmployeeServiceImp();
    }

    @BeforeEach
    public void setUp() {

        employee1 = new Employee("anna", "smith", "1", 300);
        employee2 = new Employee("anastasia", "smith", "1", 500);
        employee3 = new Employee("jon", "smith", "2", 1500);



        Mockito.when(employeeServiceImp.printAllEmployees()).thenReturn(new HashMap<>(Map.of("1",
                new Employee("anna", "smith", "1", 300),
                "2", new Employee("anastasia", "smith", "1", 500),
                "3", new Employee("jon", "smith", "2", 1500)
                )));

    }

    @Test
    public void shouldMethodFindEmployeeWithMaxSalary() {

        Employee expected =  employeeServiceImp.printAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals("1"))
                .max(Comparator.comparingInt(employee -> employee.getSalary())).orElseThrow();

        Employee actual = new Employee("anna", "smith", "1", 300 );

        Assertions.assertTrue(() -> expected.getSalary() > actual.getSalary());
    }

    @Test
    public void shouldMethodFindEmployeeWithMinSalary() {
        Employee expected =  employeeServiceImp.printAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals("1"))
                .min(Comparator.comparingInt(employee -> employee.getSalary())).orElseThrow();

        Employee actual = new Employee("anna", "smith", "1", 500 );

        Assertions.assertTrue(() -> expected.getSalary() < actual.getSalary());
    }

    @Test
    public void shouldFindAllEmployeesOfDepartment() {
        List<Employee> employeesOfDepartment =  employeeServiceImp.printAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals("1")).collect(Collectors.toList());

       String employee1 = employeesOfDepartment.get(0).getDepartment();
       String employee2 = employeesOfDepartment.get(1).getDepartment();

       Assertions.assertEquals(employee1, employee2);
    }

    @Test
    public void shouldFindAllEmployeesOfDepartments() {
        List<String> expected = employeeServiceImp.printAllEmployees().values().stream()
                .map(e -> "Department " + e.getDepartment() + " : " + e.getFirstName() + " " + e.getLastName()
                        + " " + e.getSalary()).collect(Collectors.toList());

        expected.sort(Comparator.naturalOrder());

        List<String> actual = new ArrayList<>(List.of());
        actual.add("Department " + employee1.getDepartment() + " : " + employee1.getFirstName() + " " + employee1.getLastName()
                + " " + employee1.getSalary());
        actual.add("Department " + employee2.getDepartment() + " : " + employee2.getFirstName() + " " + employee2.getLastName()
                + " " + employee2.getSalary());
        actual.add("Department " + employee3.getDepartment() + " : " + employee3.getFirstName() + " " + employee3.getLastName()
                + " " + employee3.getSalary());

        actual.sort(Comparator.naturalOrder());

        Assertions.assertEquals(expected, actual);

    }

}
