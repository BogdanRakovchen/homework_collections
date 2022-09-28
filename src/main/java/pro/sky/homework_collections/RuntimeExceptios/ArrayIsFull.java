package pro.sky.homework_collections.RuntimeExceptios;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ArrayIsFull extends RuntimeException {
    public ArrayIsFull(String message) {
        super(message);
    }
}
