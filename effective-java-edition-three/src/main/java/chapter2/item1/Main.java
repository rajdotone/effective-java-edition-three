package chapter2.item1;

public class Main {
    public static void main(String[] args) {
//        var p1 = new Point(1, 2);
//        System.out.println(p1);
        var p1 = Point.fromCartesian(1, 2); //this is the example that static fact methods can have names.
        System.out.println(p1);
//
//        var p2 = new Point(5.0, Math.atan2(4.0, 3.0), -1);
//        System.out.println(p2);
//
//        var p3 = new Point(5.0, Math.atan2(4.0, 3.0), Point.Angle.RAD);
        var p3 = Point.fromPolar(5.0, Math.atan2(4.0, 3.0), Point.Angle.RAD);
        System.out.println(p3);

        System.out.println(Math.atan2(4.0, 3.0));

        var p4 = Point.fromPolar(5.0, 53.13, Point.Angle.DEG);
        System.out.println(p4);
        // 1. Someone writes a custom point provider long after Point.java was compiled
        Point.registerProvider("alien", new PointProvider() {
            @Override
            public Point createPoint(double a, double b) {
                // Alien points multiply everything by 100!
                return new CartesianPoint(a * 100, b * 100);
            }
        });

        // 2. We use the static factory method to request an "alien" point
        Point alienPoint = Point.fromProvider("alien", 5.0, 5.0);
        System.out.println("Alien point: " + alienPoint);
    }
}
