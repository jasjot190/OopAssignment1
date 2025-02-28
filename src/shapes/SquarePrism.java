package shapes;

public class SquarePrism extends Shape {
    private double edgeLength;

    public SquarePrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }
    
    @Override
    public String getType() {
        return "SquarePrism";
    }

    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength; // Base area for a square prism
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
