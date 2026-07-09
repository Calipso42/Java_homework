public interface Figure {
    double area();

    default double perimeter() {
        return 0;
    }
}