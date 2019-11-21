import java.awt.Graphics;

//Класс, описывающий точку (Point) на плоскости (R2).
import java.util.Scanner;

class R2Point {
    Scanner read = new Scanner(System.in);

    protected double x, y;
    public R2Point(double x, double y) {
        this.x = x; this.y = y;
    }
    public R2Point() throws Exception {
        //System.out.println(s)
        System.out.print("x -> ");
        x = read.nextDouble();
        System.out.print("y -> ");
        y = read.nextDouble();

    }
    public static double dist(R2Point a, R2Point b) {
        return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
    public static double area(R2Point a, R2Point b, R2Point c) {
        return 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    }
    public static boolean equal(R2Point a, R2Point b) {
        return a.x==b.x && a.y==b.y;
    }
    public static boolean isTriangle(R2Point a, R2Point b, R2Point c) {
        return area(a, b, c) != 0.0;
    }
    public boolean inside(R2Point a, R2Point b) {
        return (a.x <= x && x <= b.x || a.x >= x && x >= b.x) &&
                (a.y <= y && y <= b.y || a.y >= y && y >= b.y);
    }
    public static boolean inUpPlane(R2Point a) // узнаем находится ли точка в верхней полуплосокости
    {
        return a.y>0;
    }
    public static boolean inDownPlane(R2Point a) // узнаем находится ли точка в нижней полуплосокости
    {
        return a.y<0;
    }
    public static boolean onOX(R2Point a) // узнаем находится ли точка на оси 0X
    {
        return a.y==0;
    }
    public boolean light(R2Point a, R2Point b) {
        double s = area(a, b, this);
        return s < 0.0 || ( s == 0.0 && ! inside(a, b));
    }
    public static R2Point change(R2Point a, R2Point b)
    {
        R2Point c = new R2Point((b.x*a.y - a.x*b.y)/(a.y - b.y),0);
        return c;
    }
}