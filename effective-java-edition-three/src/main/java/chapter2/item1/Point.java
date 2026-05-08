package chapter2.item1;

public class Point {

    double x, y;

    enum Angle {
        RAD,
        DEG
    }
    Angle angle;

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
    /**
     *    * @param rho
     *    * @param phi
     *    * @param unit : enum is either "deg" or "rad"
     */
    public Point(double rho, double phi, Angle unit) {
        switch (unit) {
            case RAD:
                this.x = rho * Math.cos(phi);
                this.y = rho * Math.sin(phi);
                break;
            case DEG:
                double phi1 = phi * Math.toRadians(phi);
                this.x = rho * Math.cos(phi);
                this.y = rho * Math.sin(phi);
                break;
        }
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

        var p2 = new Point(5.0, Math.atan2(4.0, 3.0), -1);
        System.out.println(p2);

        var p3 = new Point(5.0, Math.atan2(4.0, 3.0), Angle.RAD);
        System.out.println(p3);
    }
}
