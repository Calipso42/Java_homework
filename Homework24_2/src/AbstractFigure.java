public abstract class AbstractFigure implements Figure {
    private String fillColor;
    private String borderColor;

    public AbstractFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}