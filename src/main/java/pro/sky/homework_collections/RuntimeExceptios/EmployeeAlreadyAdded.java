package pro.sky.homework_collections.RuntimeExceptios;

public class EmployeeAlreadyAdded extends RuntimeException {
    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
