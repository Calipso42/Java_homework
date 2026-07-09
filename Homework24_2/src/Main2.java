public class Main2 {
    public static void main(String[] args) {
        AbstractFigure circle = new Circle(50, "Золотой", "Белый");
        AbstractFigure rectangle = new Rectangle(2, 5, "Бирюзовый", "Серый");
        AbstractFigure triangle = new Triangle(10, 10, 15, "Прозрачный", "Черный");

        printInfo("Круг", circle);
        printInfo("Прямоугольник", rectangle);
        printInfo("Треугольник", triangle);
    }

    public static void printInfo(String name, AbstractFigure figure) {
        System.out.println(name + ":");
        System.out.println("Периметр: " + figure.perimeter());
        System.out.println("Площадь: " + figure.area());
        System.out.println("Цвет фона: " + figure.getFillColor());
        System.out.println("Цвет границы: " + figure.getBorderColor());
        System.out.println();
    }
}