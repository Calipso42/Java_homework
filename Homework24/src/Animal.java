public class Animal {
    protected String name;

    // Считаем ВСЕХ животных
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++; // Увеличиваем счетчик при создании любого животного
    }

    // Метод для бега
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров");
    }

    // Метод для плавания
    public void swimming(int distance) {
        System.out.println(name + " проплыл " + distance + " метров");
    }

    // Метод для подсчета количества созданных животных
    public static int getAnimalCount() {
        return animalCount;
    }
}

