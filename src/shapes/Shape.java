package shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    protected double height;

    // Constructor
    public Shape(double height) {
        this.height = height;
    }

    // Abstract methods to calculate base area and volume
    public abstract double getBaseArea();
    public abstract double getVolume();

    // Getter for height
    public double getHeight() {
        return height;
    }
    
    // Getter for type
    public abstract String getType();

    // Compare shapes by height (for Comparable interface)
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.height, other.height);
    }

    // Comparator for comparing shapes by base area
    public static Comparator<Shape> compareByBaseArea() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Double.compare(s1.getBaseArea(), s2.getBaseArea());
            }
        };
    }

    // Comparator for comparing shapes by volume
    public static Comparator<Shape> compareByVolume() {
        return new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Double.compare(s1.getVolume(), s2.getVolume());
            }
        };
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [height=" + height + ", baseArea=" + getBaseArea() + ", volume=" + getVolume() + "]";
    }
}