class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean booking;

    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean booking) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.booking = booking;
    }

    public void printProductDetails() {
        System.out.println(
                "  Наименование: " + name +
                "  Дата производства: " + productionDate +
                "  Производитель: " + manufacturer +
                "  Страна производства: " + countryOfOrigin +
                "  Стоимость, в руб.: " + price +
                "  Статус: " + (booking ? "Зарезервирован" : "Доступен"));
    }
}

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung", "Korea", 5599.00, true);
        productsArray[1] = new Product("Xiaomi REDMI 15", "10.01.2026", "Xiaomi", "China", 4700.00, true);
        productsArray[2] = new Product("iPhone 17", "01.10.2025", "Apple", "USA", 7000.00, true);
        productsArray[3] = new Product("iPhone 17 PRO MAX", "01.09.2025", "Apple", "USA", 8500.00, false);
        productsArray[4] = new Product("HUAWEI Pura 80 Pro", "01.06.2025", "HUAWEI", "China", 6100.00, false);

        System.out.println("КАТАЛОГ СМАРТФОНОВ:");

        for (Product product : productsArray) {
            product.printProductDetails();
        }
    }
}