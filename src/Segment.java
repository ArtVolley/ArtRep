import java.awt.Graphics;

// Класс "двуугольник", реализующий интерфейс фигуры.
class Segment implements Figure {
    private R2Point p, q, g;
    private double up;
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
    }
    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }
    public double upperimeter() // проверка каждой точки на полуплоскость, замена при необходимости на точку с (y=0)
    {

        if (R2Point.inUpPlane(p) && R2Point.inUpPlane(q))
        {
            up = 2.0 * R2Point.dist(p, q);
        }
        if (R2Point.inUpPlane(p) && R2Point.inDownPlane(q))
        {
            up = 2.0 * R2Point.dist(p, R2Point.change(q,p));
        }
        if (R2Point.inUpPlane(q) && R2Point.inDownPlane(p))
        {
            up = 2.0 * R2Point.dist(R2Point.change(q,p), q);
        }
        if (R2Point.inDownPlane(p) && R2Point.inDownPlane(q))
        {
            up = 0.0;
        }
        return up;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        return this;
    }
    public void draw(Graphics g)
    {
        g.fillOval((int)(p.x-2.5), -((int)(p.y+2.5)),5,5);
        g.fillOval((int)(q.x-2.5), -((int)(q.y+2.5)),5,5);
        g.drawLine((int)p.x, -((int)p.y), (int)q.x, -((int)q.y));
    }
}