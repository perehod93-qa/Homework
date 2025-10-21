package lesson_4.animals;

public class AnimalsMain {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурка"),
                new Cat("Рыжик")
        };

        Dog dog = new Dog("Бобик");

        Bowl bowl = new Bowl(40);

        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println();

        bowl.addFood(30);
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 15);
            }
        }

        System.out.println();

        cats[0].run(100);
        cats[0].swim(5);

        dog.run(400);
        dog.swim(8);

        System.out.println();

        System.out.println("Создано котов: " + Cat.getCatsCount());
        System.out.println("Создано собак: " + Dog.getDogsCount());
        System.out.println("Всего животных: " + Animal.getAnimalsCount());
    }
}