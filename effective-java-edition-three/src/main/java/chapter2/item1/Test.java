package chapter2.item1;

public class Test {
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
        var p3 = Point.formPolar(5.0, Math.atan2(4.0, 3.0), Point.Angle.RAD);
        System.out.println(p3);

        System.out.println(Math.atan2(4.0, 3.0));

        var p4 = Point.formPolar(5.0, 53.13, Point.Angle.DEG);
        System.out.println(p4);
    }
}
