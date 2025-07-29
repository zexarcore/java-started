/**
 * INHERITANCE AND POLYMORPHISM EXAMPLE:
 * This class demonstrates:
 * 1. Inheritance: Extends AbstractVehicle to inherit all its properties and methods
 * 2. Polymorphism: Can be treated as IVehicle, IDriveable, IMaintainable, or AbstractVehicle
 * 3. Method Overriding: Implements getVehicleType() and getMaxSpeed() differently from other vehicle types
 * 4. Encapsulation: Private fields with public getters/setters
 */
public class Motorcycle extends AbstractVehicle {
    // Additional properties specific to motorcycles
    private boolean hasSidecar;
    private int engineSize; // in cc
    private String motorcycleType; // Sport, Cruiser, Touring, etc.

    /**
     * Constructor that calls the parent class constructor using super()
     * and initializes motorcycle-specific properties
     */
    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year, 20.0); // Motorcycles typically have 20L fuel tank
        this.hasSidecar = hasSidecar;
        this.engineSize = 600; // Default engine size
        this.motorcycleType = "Sport";
    }

    /**
     * Overloaded constructor for more specific motorcycle creation
     */
    public Motorcycle(String brand, String model, int year, boolean hasSidecar, int engineSize, String type) {
        super(brand, model, year, 20.0);
        this.hasSidecar = hasSidecar;
        this.engineSize = engineSize;
        this.motorcycleType = type;
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

    /**
     * Implementation of abstract method from IDriveable interface
     * Motorcycles typically have higher max speed than cars
     */
    @Override
    public int getMaxSpeed() {
        // Speed varies by engine size and type
        int baseSpeed = engineSize / 5; // Basic calculation
        if (motorcycleType.equals("Sport")) {
            baseSpeed += 50;
        }
        return Math.min(baseSpeed, 300); // Cap at 300 km/h
    }

    /**
     * METHOD OVERRIDING EXAMPLE:
     * Override acceleration for motorcycles (they accelerate faster)
     */
    @Override
    public void accelerate() {
        if (isRunning && fuelLevel > 0) {
            speed += 15; // Motorcycles accelerate faster than cars
            fuelLevel -= 0.3; // More fuel efficient
            mileage += 1;
            mileageSinceService += 1;
            System.out.println(getVehicleType() + " " + brand + " " + model + " is accelerating quickly. Current speed: " + speed + " km/h");
        }
    }

    // Motorcycle-specific methods demonstrating ENCAPSULATION
    public boolean hasSidecar() {
        return hasSidecar;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public String getMotorcycleType() {
        return motorcycleType;
    }

    /**
     * Example of a method that uses inherited properties (isRunning and speed)
     * to provide motorcycle-specific behavior
     */
    public void wheelie() {
        if (isRunning && speed > 30 && !hasSidecar) {
            System.out.println(brand + " " + model + " is doing a wheelie!");
        } else if (hasSidecar) {
            System.out.println("Cannot do wheelie with sidecar attached!");
        }
    }

    /**
     * Motorcycle-specific maintenance behavior
     */
    @Override
    public void performMaintenance() {
        System.out.println("Performing motorcycle-specific maintenance on " + brand + " " + model);
        System.out.println("- Checking chain tension");
        System.out.println("- Inspecting tire wear");
        System.out.println("- Checking brake pads");
        resetServiceIndicator();
    }
} 