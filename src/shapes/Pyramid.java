package shapes;

public class Pyramid extends Shape {
    private double edgeLength;

    public Pyramid(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }
    
    @Override
    public String getType() {
        return "Pyramid";
    }
    
    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength; // Base area for a square pyramid
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * height;
    }
}