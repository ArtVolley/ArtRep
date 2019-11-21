import java.awt.geom.Rectangle2D;
import java.awt.Graphics;

// Класс "многоугольник", реализующий интерфейс фигуры.
class Polygon extends Deq implements Figure {
    private double s, p, up, ab;
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
        ab = R2Point.dist(a, b);
        up -= ab;      //добавлено
    }
    public double CountUp(R2Point a, R2Point b, R2Point c)
    {
        if (R2Point.inDownPlane(a) && R2Point.inDownPlane(b) && R2Point.inDownPlane(c)) // перебор вариаций нахождения точек и пересчет периметра
        {
            up = 0.0;
        }
        else
        if (R2Point.inUpPlane(a) && R2Point.inUpPlane(b) && R2Point.inUpPlane(c))
        {
            up = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        }
        else
        if (R2Point.inDownPlane(a) && R2Point.inDownPlane(b) && R2Point.inUpPlane(c)) {
            up = R2Point.dist(R2Point.change(c, a), R2Point.change(c, b)) + R2Point.dist(R2Point.change(c, b), c)
                    + R2Point.dist(c, R2Point.change(c, a));
        }
        if (R2Point.inDownPlane(b) && R2Point.inDownPlane(c) && R2Point.inUpPlane(a)) {
            up = R2Point.dist(a, R2Point.change(a, b)) + R2Point.dist(R2Point.change(a, b), R2Point.change(a, c))
                    + R2Point.dist(R2Point.change(a, c), a);
        }
        if (R2Point.inDownPlane(a) && R2Point.inDownPlane(c) && R2Point.inUpPlane(b)) {
            up = R2Point.dist(R2Point.change(b, a), b) + R2Point.dist(b, R2Point.change(b, c))
                    + R2Point.dist(R2Point.change(b, c), R2Point.change(b, a));
        }
        else
        if (R2Point.inDownPlane(a) && R2Point.inUpPlane(b) && R2Point.inUpPlane(c))
        {
            up = R2Point.dist(R2Point.change(a, b),R2Point.change(a, c)) + R2Point.dist(b,c)
                    + R2Point.dist(R2Point.change(a ,b),b) + R2Point.dist(c,R2Point.change(a, c));
        }
        if (R2Point.inDownPlane(b) && R2Point.inUpPlane(a) && R2Point.inUpPlane(c))
        {
            up = R2Point.dist(R2Point.change(b, a),R2Point.change(b, c)) + R2Point.dist(a,c)
                    + R2Point.dist(R2Point.change(b, c),c) + R2Point.dist(a,R2Point.change(b, a));
        }
        if (R2Point.inDownPlane(c) && R2Point.inUpPlane(a) && R2Point.inUpPlane(b))
        {
            up = R2Point.dist(R2Point.change(c, a),R2Point.change(c,b)) + R2Point.dist(a, b)
                    + R2Point.dist(R2Point.change(c, b),b) + R2Point.dist(a,R2Point.change(c, a));
        }
        else
        if (R2Point.onOX(a) && R2Point.onOX(b) && R2Point.onOX(c))
        {
            up = 0;
        }
        else
        if (R2Point.onOX(a) && R2Point.inUpPlane(b) && R2Point.inUpPlane(c)
                || R2Point.onOX(b) && R2Point.inUpPlane(a) && R2Point.inUpPlane(c)
                || R2Point.onOX(c) && R2Point.inUpPlane(b) && R2Point.inUpPlane(a))
        {
            up = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        }
        else
        if (R2Point.onOX(a) && R2Point.inDownPlane(b) && R2Point.inDownPlane(c)
                || R2Point.onOX(b) && R2Point.inDownPlane(a) && R2Point.inDownPlane(c)
                || R2Point.onOX(c) && R2Point.inDownPlane(b) && R2Point.inDownPlane(a))
        {
            up = 0;
        }
        else
        if (R2Point.onOX(a) && R2Point.inUpPlane(b) && R2Point.inDownPlane(c))
        {
            up = R2Point.dist(a, b) + R2Point.dist(b, R2Point.change(b, c)) + R2Point.dist(R2Point.change(b, c), a);
        }
        if (R2Point.onOX(a) && R2Point.inUpPlane(c) && R2Point.inDownPlane(b))
        {
            up = R2Point.dist(a, R2Point.change(b, c)) + R2Point.dist(R2Point.change(b, c), c) + R2Point.dist(c, a);
        }
        if (R2Point.onOX(b) && R2Point.inUpPlane(a) && R2Point.inDownPlane(c))
        {
            up = R2Point.dist(a, b) + R2Point.dist(b, R2Point.change(a,c)) + R2Point.dist(R2Point.change(a,c), a);
        }
        if (R2Point.onOX(b) && R2Point.inUpPlane(c) && R2Point.inDownPlane(a))
        {
            up = R2Point.dist(R2Point.change(c, a), b) + R2Point.dist(b, c) + R2Point.dist(c, R2Point.change(c, a));
        }
        if (R2Point.onOX(c) && R2Point.inUpPlane(a) && R2Point.inDownPlane(b))
        {
            up = R2Point.dist(a, R2Point.change(a, b)) + R2Point.dist(R2Point.change(a, b), c) + R2Point.dist(c, a);
        }
        if (R2Point.onOX(c) && R2Point.inUpPlane(b) && R2Point.inDownPlane(a))
        {
            up = R2Point.dist(R2Point.change(a,b), b) + R2Point.dist(b, c) + R2Point.dist(c, R2Point.change(a,b));
        }
        else
        if (R2Point.onOX(a) && R2Point.onOX(b) && R2Point.inDownPlane(c)
                || R2Point.onOX(b) && R2Point.onOX(c) && R2Point.inDownPlane(a)
                || R2Point.onOX(a) && R2Point.onOX(c) && R2Point.inDownPlane(b))
        {
            up = 0;
        }
        else
        if (R2Point.onOX(a) && R2Point.onOX(b) && R2Point.inUpPlane(c)
                || R2Point.onOX(b) && R2Point.onOX(c) && R2Point.inUpPlane(a)
                || R2Point.onOX(a) && R2Point.onOX(c) && R2Point.inUpPlane(b))
        {
            up = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        }
        return up;
    }
    public Polygon(R2Point a, R2Point b, R2Point c) {

        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
        up = CountUp(a, b, c);
    }

    public double perimeter() {
        return p;
    }
    public double upperimeter() {
        return up;
    }
    public double area() {
        return s;
    }
    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i>0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            up += CountUp(t, front(),back());//R2Point.dist(back(), t) + R2Point.dist(t, front());//
            pushFront(t);
        }
        return this;
    }
    public void draw(Graphics g)
    {
        for (int i=length(); i>0; i--)
        {
            g.fillOval((int)(front().x-2.5), -((int)(front().y+2.5)),5,5);
            g.drawLine((int)front().x, -((int)front().y), (int)back().x, -((int)back().y));
            pushFront(popBack());
        }
    }
}