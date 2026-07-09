public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не может пробежать " + distance + " метров (Максимум 200м)");
        }
    }

    @Override
    public void swimming(int distance) {
        System.out.println(name + " не умеет плавать!");
    }


    public void eat(Plate plate, int amount) {
        if (plate.getFoodAmount() >= amount) {
            plate.decreaseFood(amount);
            this.isFull = true;
            System.out.println("Кот " + name + " съел " + amount + " еды и теперь сыт.");
        } else {
            System.out.println("Коту " + name + " не хватило еды (" + amount + "), он остался голодным.");
        }
    }

    public void checkSatiety() {
        if (isFull) {
            System.out.println("Кот " + name + " сыт.");
        } else {
            System.out.println("Кот " + name + " голоден.");
        }
    }

    public static int getCatCount() {
        return catCount;
    }
}