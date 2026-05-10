package chapter2.item1;

public class OriginPoint extends Point {
    protected OriginPoint() {
        // Always 0, 0
        super(0.0, 0.0);
    }

    @Override
    public String toString() {
        return "OriginPoint{x=0.0, y=0.0} (Highly Optimized!)";
    }
}
