package pro.sky.homework_collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_collections.Service.EmployeeServiceImp;

import java.util.HashMap;
import java.util.Map;


public class EmployeeServiceTest {

    private final EmployeeServiceImp employeeServiceImp;


    public EmployeeServiceTest() {
        this.employeeServiceImp = new EmployeeServiceImp();
    }


    @BeforeEach
    public void setUp() {
       Employee employee = new Employee("jon", "smith", "1", 123);
    }



    @Test
    public void shouldAddMethodFromEmployeeServiceImp() {
        Employee expected = new Employee("jon", "smith", "1", 123);
        Employee actual = employeeServiceImp.addEmployee("jon", "smith", "1", 123);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveMethodFromEmployeeServiceImp() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "1", new Employee("jon", "smith",
                "1", 123)));


        Employee employee = new Employee("jon", "smith", "1", 123);
        employeeMap.put(employee.getFirstName() + " " + employee.getLastName(), employee);

        Employee employee1 = employeeMap.remove("jon smith");

        Assertions.assertEquals(employee, employee1);

        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImp.removeEmployee("jon smith"));
    }

    @Test
    public void shouldFindMethodFromEmployeeServiceImp() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "1", new Employee("jon", "smith",
                        "1", 123)));

        Employee employee = new Employee("jon", "smith", "1", 123);
        employeeMap.put(employee.getFirstName() + " " + employee.getLastName(), employee);

        Employee employee1 = employeeMap.get("jon smith");

        Assertions.assertEquals(employee, employee1);

        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImp.removeEmployee("jon smith"));
    }

    @Test
    public void shouldFindEmployeeWithMaxSalaryMethod() {


        Employee employee = new Employee("jon", "smith", "1", 12_000);

        Assertions.assertEquals(employee, employee);


    }


}
