/**
 * INHERITANCE AND POLYMORPHISM EXAMPLE:
 * This class demonstrates:
 * 1. Inheritance: Extends AbstractVehicle to inherit all its properties and methods
 * 2. Polymorphism: Can be treated as a Vehicle or AbstractVehicle
 * 3. Method Overriding: Implements getVehicleType() differently from other vehicle types
 */
public class Car extends AbstractVehicle {
    // Additional property specific to cars
    private int numberOfDoors;

    /**
     * Constructor that calls the parent class constructor using super()
     * and initializes car-specific properties
     */
    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * POLYMORPHISM EXAMPLE:
     * This method demonstrates runtime polymorphism as it provides
     * a specific implementation for cars
     */
    @Override
    public String getVehicleType() {
        return "Car";
    }

    // Car-specific methods
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void openTrunk() {
        System.out.println("Opening trunk of " + brand + " " + model);
    }
} 