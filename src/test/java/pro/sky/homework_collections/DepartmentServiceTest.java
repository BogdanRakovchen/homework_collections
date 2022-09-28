package pro.sky.homework_collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_collections.Interface.EmployeeInterface;
import pro.sky.homework_collections.Service.DepartmentServiceImp;
import pro.sky.homework_collections.Service.EmployeeServiceImp;

import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {


    @Mock
    private EmployeeServiceImp employeeServiceImp;
    @InjectMocks
    private  DepartmentServiceImp out;

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;






//    public DepartmentServiceTest() {
//
//        this.employeeServiceImp = new EmployeeServiceImp();
//        this.out = new DepartmentServiceImp(new EmployeeServiceImp());
//
//    }

    @BeforeEach
    public void setUp() {

        employee1 = new Employee( "Федор","Румянцев", "1", 70_445);
        employee2 = new Employee( "Анастасия","Сидорова", "1", 56_132);
        employee3 = new Employee( "Андрей", "Копылов", "1", 52_545);



        Mockito.when(employeeServiceImp.printAllEmployees()).thenReturn(new HashMap<>(Map.of
                (  "1", employee1,
                    "3", employee2,
                    "4", employee3
                )));

    }

    @Test
    public void shouldMethodFindEmployeeWithMaxSalary() {

        Employee expected = employee1;

        Employee actual = out.findEmployeeWithMaxSalary("1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMethodFindEmployeeWithMinSalary() {
        Employee expected = employee3;

        Employee actual = out.findEmployeeWithMinSalary("1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEmployeesOfDepartment() {
        List<Employee> expected = new ArrayList<>(List.of(employee1, employee2, employee3));

     List<Employee> actual = out.findAllEmployeesOfDepartment("1");

       Assertions.assertEquals(expected, actual);
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
