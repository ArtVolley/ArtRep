import java.awt.*;
import java.awt.Graphics;

// Класс "выпуклая оболочка".
class Convex {
    private Figure fig;
    private R2Point point;
    public Convex() {
        fig = new Void();
    }
    public void add(R2Point p) {
        fig = fig.add(p);
    }
    public double area() {
        return fig.area();
    }
    public double perimeter() {
        return fig.perimeter();
    }
    public double upperimeter()
    {
        return fig.upperimeter();
    }  // добавлено
    public void draw(Graphics g)
    {
        fig.draw(g);
    }
}