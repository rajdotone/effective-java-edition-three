package chapter2.item1;

public class Point {

    double x, y;

    enum Angle {
        RAD,
        DEG
    }
    Angle angle;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

  /**
   * @param rho
   * @param phi
   * @param dummy : this is not being used
   * */
    private Point(double rho, double phi, int dummy) {
        this.x = rho * Math.cos(phi);
        this.y = rho * Math.sin(phi);
    }
    /**
     *    * @param rho
     *    * @param phi
     *    * @param unit : enum is either "deg" or "rad"
     */
    private Point(double rho, double phi, Angle unit) {
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


    /*
    ************************* static factory methods
    * */

    public static Point fromCartesian(double x, double y) {
        return new Point(x, y);
    }

    public static Point formPolar(double rho, double phi, Angle unit) {
        return new Point(rho, phi, unit);
    }

    public static Point formPolarRad(double rho, double phi) {
        return new Point(rho, phi, Angle.RAD);
    }

    public static Point formPolarDeg(double rho, double phi) {
        return new Point(rho, phi, Angle.DEG);
    }
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
