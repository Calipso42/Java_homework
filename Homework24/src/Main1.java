public class Main1 {
    public static void main(String[] args) {

        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Барсик");

        dog.run(150);
        dog.swimming(5);
        cat.run(150);
        cat.swimming(5);

        System.out.println("\n Животных: " + Animal.getAnimalCount() + ", Собак: " + Dog.getDogCount() + ", Котов: " + Cat.getCatCount());

        Plate plate = new Plate(25);

        Cat[] cats = {
                new Cat("Атос"),
                new Cat("Портос"),
                new Cat("Арамис")
        };

        System.out.println("\n Кормление котов");
        for (Cat c : cats) {
            c.eat(plate, 10);
            c.checkSatiety();
        }
        System.out.println("Остаток еды в тарелке: " + plate.getFoodAmount());
    }
}