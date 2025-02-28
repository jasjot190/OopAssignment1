package shapes;

public class PentagonalPrism extends Shape {
    private double edgeLength;

    public PentagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }
    
    @Override
    public String getType() {
        return "PentagonalPrism";
    }
    
    @Override
    public double getBaseArea() {
        return (5 * edgeLength * edgeLength * Math.tan(Math.toRadians(54))) / 4; // Base area for a pentagon
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
