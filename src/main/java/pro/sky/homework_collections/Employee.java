package pro.sky.homework_collections;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
//    private String department;
//    private int salary;
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.department = department;
//        this.salary = salary;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

//    public String getDepartment() {
//        return department;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
}
