package lesson_4.animals;

import lombok.Getter;

@Getter
public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }

    public void decreaseFood(int amount) {
        foodAmount = Math.max(foodAmount - amount, 0);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды. Сейчас в миске: " + foodAmount);
        }
    }
}