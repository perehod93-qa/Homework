package lesson_4.animals;

import lombok.Getter;

public class Dog extends Animal {
    @Getter
    private static int dogsCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogsCount++;
    }
}