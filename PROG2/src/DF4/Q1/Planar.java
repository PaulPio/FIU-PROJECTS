package src.DF4.Q1;
/* Discussion forum 4 assignment */

public interface Planar {

    /**
     * Calculates the area of the shape
     * @return a double representing the area
     */
    public double getArea();

    /**
     * Calculates the perimeter or circumference of the object
     * @return a double representing perimeter or circumference
     */
    public double getPerimeter();
}

/**
 * The Circle class implements the Planar interface for a circle.
 */
class Circle implements Planar {

    // Instance field for the radius
    private double radius;

    /**
     * Constructor for the Circle class.
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle (pi number * r^2).
     * @return The area of the circle.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the perimeter (circumference) of the circle (2 * pi number * r).
     * @return The perimeter of the circle.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

/**
 * The Rectangle class implements the Planar interface for a rectangle.
 */

class Rectangle implements Planar {

    // Instance fields for width and height
    private double width;
    private double height;

    /**
     * Constructor for the Rectangle class.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates the area of the rectangle (width * height).
     * @return The area of the rectangle.
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * Calculates the perimeter of the rectangle (2 * (width + height)).
     * @return The perimeter of the rectangle.
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}


/**
 * The Square class extends Rectangle, inheriting its properties and methods.
 * A square is a specialized type of rectangle where width and height are equal.
 */

class Square extends Rectangle {

    /**
     * Constructor for the Square class.
     * It calls the parent (Rectangle) constructor, passing the side length
     * for both width and height.
     * @param side The length of one side of the square.
     */
    public Square(double side) {
        // Call the superclass (Rectangle) constructor
        super(side, side);
    }

    // No need to override getArea() or getPerimeter().
    // The implementations from the Rectangle class are inherited and work correctly
    // because we have set width and height to be the same value ('side').
}

