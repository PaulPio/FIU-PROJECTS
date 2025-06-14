package src.DF4.Q2;

public abstract class PlannarShape {
    // Instance fields
    private String name;

    public abstract double getArea();
    public abstract double getPerimeter();
    public String toString(){return name;}//overriding Object.toString(), don't change it in Circle, Rectangle or Square
    public PlannarShape(String name){this.name = name;}//constructor

}

/**
 * The Circle class represents a circle shape.
 */
class Circle extends PlannarShape {
    // Instance field for the radius
    private double radius;

    /**
     * Constructor for the Circle class.
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        super("Circle"); // Call the superclass constructor
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle (π * r^2).
     * @return The area of the circle.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the perimeter (circumference) of the circle (2 * π * r).
     * @return The perimeter of the circle.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}


/**
 * The Rectangle class represents a rectangle shape.
 */
class Rectangle extends PlannarShape {
    // Instance fields for width and height
    private double width;
    private double height;

    /**
     * Constructor for the Rectangle class.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(double width, double height) {
        super("Rectangle"); // Call the superclass constructor
        this.width = width;
        this.height = height;
    }

    /**
     * Protected constructor for use by subclasses like Square,
     * allowing them to set their own name.
     * @param name The name of the shape.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    protected Rectangle(String name, double width, double height) {
        super(name); // Call the superclass constructor with a specific name
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
 */
class Square extends Rectangle {
    /**
     * Constructor for the Square class.
     * @param side The length of one side of the square.
     */
    public Square(double side) {
        // Call the protected Rectangle constructor to set the name to "Square"
        super("Square", side, side);
    }

    // No need to override getArea(), getPerimeter(), or toString().
    // These are all inherited correctly.
}