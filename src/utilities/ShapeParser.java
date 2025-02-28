package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;

public class ShapeParser {
    public static Shape[] parseFile(String fileName) throws FileNotFoundException {
        File file = new File("res/"+fileName);
        Scanner scanner = new Scanner(file);

        int numShapes = Integer.parseInt(scanner.nextLine());
        Shape[] shapes = new Shape[numShapes];

        for (int i = 0; i < numShapes; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String shapeType = parts[0];
            double height = Double.parseDouble(parts[1]);
            double dimension = Double.parseDouble(parts[2]);

            switch (shapeType) {
                case "Cylinder":
                    shapes[i] = new Cylinder(height, dimension);
                    break;
                case "Cone":
                    shapes[i] = new Cone(height, dimension);
                    break;
                case "Pyramid":
                    shapes[i] = new Pyramid(height, dimension);
                    break;
                case "SquarePrism":
                    shapes[i] = new SquarePrism(height, dimension);
                    break;
                case "TriangularPrism":
                    shapes[i] = new TriangularPrism(height, dimension);
                    break;
                case "PentagonalPrism":
                    shapes[i] = new PentagonalPrism(height, dimension);
                    break;
                case "OctagonalPrism":
                    shapes[i] = new OctagonalPrism(height, dimension);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown shape type: " + shapeType);
            }
        }

        scanner.close();
        return shapes;
    }
}
