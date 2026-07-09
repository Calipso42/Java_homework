public class Park {
    private String namePark;

    public Park(String namePark) {
        this.namePark = namePark;
    }

    public class Attraction {
        private String nameAttraction;
        private String workingHours;
        private double price;

        public Attraction(String nameAttraction, String workingHours, double price) {
            this.nameAttraction = nameAttraction;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("[" + namePark + "] Аттракцион: " + nameAttraction +
                    "  Время работы: " + workingHours +
                    "  Стоимость, в руб.: " + price);
        }
    }

    public static void main(String[] args) {
        System.out.println("Информация о парке:");

        Park centralPark = new Park("Парк имени Ю.А. Гагарина");

        Park.Attraction train = centralPark.new Attraction("Дикий поезд", "11:00 - 20:00", 500.00);
        Park.Attraction carousel = centralPark.new Attraction("Карусель", "11:00 - 20:00", 300.00);
        Park.Attraction ship = centralPark.new Attraction("Лодочки", "15:00 - 20:00", 400.00);

        train.printAttractionInfo();
        carousel.printAttractionInfo();
        ship.printAttractionInfo();
    }
}
