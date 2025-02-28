package shapes;

public class OctagonalPrism extends Shape {
    private double edgeLength;

    public OctagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }
    
    @Override
    public String getType() {
        return "OctagonalPrism";
    }

    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength; // Base area for an octagon
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
