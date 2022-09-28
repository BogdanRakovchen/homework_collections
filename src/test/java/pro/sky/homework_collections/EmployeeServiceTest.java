package pro.sky.homework_collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.homework_collections.Service.EmployeeServiceImp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class EmployeeServiceTest {

    private final EmployeeServiceImp employeeServiceImp;
    private Employee employee;


    public EmployeeServiceTest() {
        this.employeeServiceImp = new EmployeeServiceImp();
    }


    @BeforeEach
    public void setUp() {
       employee = new Employee("jon", "smith", "1", 123);
    }



    @Test
    public void shouldAddMethodFromEmployeeServiceImp() {
        Employee expected = employee;
        Employee actual = employeeServiceImp.addEmployee("jon", "smith", "1", 123);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveMethodFromEmployeeServiceImp() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "1", employee));



        employeeMap.put(employee.getFirstName() + " " + employee.getLastName(), employee);

        Employee expected = employee;
        Employee actual = employeeMap.remove("jon smith");

        Assertions.assertEquals(expected, actual);

        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImp.removeEmployee("jon smith"));
    }

    @Test
    public void shouldFindMethodFromEmployeeServiceImp() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of(
                "1", employee));

        Employee expected = employee;
        employeeMap.put(employee.getFirstName() + " " + employee.getLastName(), employee);

        Employee actual = employeeMap.get("jon smith");

        Assertions.assertEquals(expected, actual);

        Assertions.assertThrows(RuntimeException.class, () -> employeeServiceImp.removeEmployee("jon smith"));
    }

    @Test
    public void shouldPrintAllEmployees() {
        Map<String, Employee> expected = new HashMap<>(Map.of(
                "2",
                new Employee("Иван", "Иванов", "2", 50_145),
                "1",
                new Employee( "Федор","Румянцев", "1", 70_445),
                "3",
                new Employee( "Анастасия","Сидорова", "1", 56_132),
                "4",
                new Employee( "Андрей", "Копылов", "1", 52_545),
                "5",
                new Employee( "Виктор", "Станиславский", "3", 65_346)
        )
        );

        Map<String, Employee> actual = employeeServiceImp.printAllEmployees();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldThatEmployeeExists() {
        Map<String, Employee> employeeMap = new HashMap<>(Map.of());
        Employee employee1 = new Employee("jon", "smith", "1", 123);
        employeeMap.put("1", employee1);

        Iterator<Employee> employeeIterator = employeeMap.values().iterator();

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            try {
                if (employeeIterator.next().getFirstName().equals("jon") && employeeIterator.next().getLastName().equals("smith")) {
                    throw new RuntimeException("is already");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("is already");
            }

        }, "is already");

        Assertions.assertTrue(thrown.getMessage().contains("is already"));


    }



}
