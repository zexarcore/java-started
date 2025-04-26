/**
 * INHERITANCE AND POLYMORPHISM EXAMPLE:
 * This class demonstrates:
 * 1. Inheritance: Extends AbstractVehicle to inherit all its properties and methods
 * 2. Polymorphism: Can be treated as a Vehicle or AbstractVehicle
 * 3. Method Overriding: Implements getVehicleType() differently from other vehicle types
 */
public class Motorcycle extends AbstractVehicle {
    // Additional property specific to motorcycles
    private boolean hasSidecar;

    /**
     * Constructor that calls the parent class constructor using super()
     * and initializes motorcycle-specific properties
     */
    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    /**
     * POLYMORPHISM EXAMPLE:
     * This method demonstrates runtime polymorphism as it provides
     * a specific implementation for motorcycles
     */
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    // Motorcycle-specific methods
    public boolean hasSidecar() {
        return hasSidecar;
    }

    /**
     * Example of a method that uses inherited properties (isRunning and speed)
     * to provide motorcycle-specific behavior
     */
    public void wheelie() {
        if (isRunning && speed > 30) {
            System.out.println(brand + " " + model + " is doing a wheelie!");
        }
    }
} 