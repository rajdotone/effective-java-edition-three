package chapter2.item1;

public class Point {

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

  /**
   * @param rho
   * @param phi
   * @param dummy : this is not being used
   * */
    public Point(double rho, double phi, int dummy) {
        this.x = rho * Math.cos(phi);
        this.y = rho * Math.sin(phi);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        var p1 = new Point(1, 2);
        System.out.println(p1);

        var p2 = new Point(3, Math.toRadians(4));
        System.out.println(p2);
    }
}
