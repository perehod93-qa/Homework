package lesson_4.animals;

import lombok.Getter;

@Getter
public class Cat extends Animal {
    @Getter
    private static int catsCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catsCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println(name + " остался голодным. Недостаточно еды ");
        }
    }
}