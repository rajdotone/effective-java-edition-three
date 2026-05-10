package chapter2.item1;

import java.util.HashMap;
import java.util.Map;

public class Point {

    double x, y;

    enum Angle {
        RAD,
        DEG
    }
    Angle angle;

    protected Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

  /**
   * @param rho
   * @param phi
   * @param dummy : this is not being used
   * */
    protected Point(double rho, double phi, int dummy) {
        this.x = rho * Math.cos(phi);
        this.y = rho * Math.sin(phi);
    }
    /**
     *    * @param rho
     *    * @param phi
     *    * @param unit : enum is either "deg" or "rad"
     */
    protected Point(double rho, double phi, Angle unit) {
        switch (unit) {
            case RAD:
                this.x = rho * Math.cos(phi);
                this.y = rho * Math.sin(phi);
                break;
            case DEG:
                double phiRad = Math.toRadians(phi);
                this.x = rho * Math.cos(phiRad);
                this.y = rho * Math.sin(phiRad);
                break;
        }
    }


    /*
    ************************* static factory methods
    * */

    public static Point fromPolar(double rho, double phi, Angle unit) {
        //return new Point(rho, phi, unit);
        //returning a subtype
        return new PolarPoint(rho, phi, unit);
    }

    public static Point fromPolarRad(double rho, double phi) {
        return new Point(rho, phi, Angle.RAD);
    }

    public static Point fromPolarDeg(double rho, double phi) {
        return new Point(rho, phi, Angle.DEG);
    }

    public static Point fromCartesian(double x, double y) {
       // Implementing Advantage 4: Varying the returned subclass based on the input values.

        if (x == 0.0 && y == 0.0) {
            return new OriginPoint();
        }
        return new CartesianPoint(x, y);
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    // ==========================================
    // ADVANTAGE 5: Service Provider Framework
    // ==========================================

    // 1. The Registry (holds implementations dynamically)
    private static final Map<String, PointProvider> providers = new HashMap<>();

    // 2. Provider Registration API
    public static void registerProvider(String name, PointProvider provider) {
        providers.put(name, provider);
    }

    // 3. service access api (the static factory method)
    public static Point fromProvider(String name, double a, double b) {
        PointProvider provider = providers.get(name);
        if (provider == null) {
            throw new IllegalArgumentException("provider not exist: "  + name);
        }
        return provider.createPoint(a, b);
    }
}