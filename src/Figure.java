import java.awt.*;
import java.awt.Graphics;

// Интерфейс, задающий новый тип - фигуру.
interface Figure {
    public double perimeter();
    public double upperimeter(); // периметр на верхней полуплоскости
    public double area();
    public Figure add(R2Point p);
    public void draw(Graphics g);
}
