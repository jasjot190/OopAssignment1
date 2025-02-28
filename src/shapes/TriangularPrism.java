package shapes;

public class TriangularPrism extends Shape {
    private double edgeLength;

    public TriangularPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }
    
    @Override
    public String getType() {
        return "TriangularPrism";
    }
    
    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength; // Base area for an equilateral triangle
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
