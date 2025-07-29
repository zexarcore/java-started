/**
 * INHERITANCE AND POLYMORPHISM EXAMPLE:
 * This class demonstrates:
 * 1. Inheritance: Extends AbstractVehicle to inherit common vehicle functionality
 * 2. Polymorphism: Can be treated through multiple interface types
 * 3. Method Overriding: Provides truck-specific implementations
 * 4. Composition: Contains cargo-related functionality
 */
public class Truck extends AbstractVehicle {
    // Truck-specific properties
    private double cargoCapacity; // in tons
    private double currentCargo; // in tons
    private boolean hasTrailer;
    private int numberOfAxles;

    /**
     * Constructor for Truck class
     */
    public Truck(String brand, String model, int year, double cargoCapacity, int numberOfAxles) {
        super(brand, model, year, 200.0); // Trucks have large fuel tanks (200L)
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = 0;
        this.hasTrailer = false;
        this.numberOfAxles = numberOfAxles;
    }

    /**
     * POLYMORPHISM EXAMPLE:
     * Specific implementation for trucks
     */
    @Override
    public String getVehicleType() {
        return "Truck";
    }

    /**
     * Trucks have lower max speed due to size and weight
     */
    @Override
    public int getMaxSpeed() {
        int baseSpeed = hasTrailer ? 90 : 120;
        // Reduce speed based on cargo load
        double loadFactor = currentCargo / cargoCapacity;
        return (int) (baseSpeed * (1 - loadFactor * 0.3));
    }

    /**
     * METHOD OVERRIDING EXAMPLE:
     * Trucks accelerate slower, especially when loaded
     */
    @Override
    public void accelerate() {
        if (isRunning && fuelLevel > 0) {
            double loadFactor = currentCargo / cargoCapacity;
            int acceleration = (int) (5 * (1 - loadFactor * 0.5)); // Slower when loaded
            speed += Math.max(acceleration, 2); // Minimum 2 km/h increase
            
            fuelLevel -= 1.0 + (loadFactor * 0.5); // More fuel consumption when loaded
            mileage += 1;
            mileageSinceService += 1;
            
            System.out.println(getVehicleType() + " " + brand + " " + model + 
                             " is accelerating slowly. Current speed: " + speed + " km/h" +
                             " (Load: " + String.format("%.1f", currentCargo) + "/" + cargoCapacity + " tons)");
        }
    }

    /**
     * Truck-specific maintenance
     */
    @Override
    public void performMaintenance() {
        System.out.println("Performing heavy-duty maintenance on " + brand + " " + model);
        System.out.println("- Checking hydraulic systems");
        System.out.println("- Inspecting cargo area");
        System.out.println("- Checking " + numberOfAxles + " axles");
        if (hasTrailer) {
            System.out.println("- Inspecting trailer connection");
        }
        resetServiceIndicator();
    }

    // Truck-specific methods
    public void loadCargo(double weight) {
        if (currentCargo + weight <= cargoCapacity) {
            currentCargo += weight;
            System.out.println("Loaded " + weight + " tons. Current cargo: " + 
                             String.format("%.1f", currentCargo) + " tons");
        } else {
            System.out.println("Cannot load " + weight + " tons. Exceeds capacity!");
        }
    }

    public void unloadCargo(double weight) {
        if (currentCargo >= weight) {
            currentCargo -= weight;
            System.out.println("Unloaded " + weight + " tons. Current cargo: " + 
                             String.format("%.1f", currentCargo) + " tons");
        } else {
            System.out.println("Cannot unload " + weight + " tons. Not enough cargo!");
        }
    }

    public void attachTrailer() {
        if (!hasTrailer) {
            hasTrailer = true;
            cargoCapacity *= 1.5; // Increase capacity with trailer
            System.out.println("Trailer attached. New cargo capacity: " + cargoCapacity + " tons");
        }
    }

    public void detachTrailer() {
        if (hasTrailer) {
            hasTrailer = false;
            cargoCapacity /= 1.5; // Restore original capacity
            if (currentCargo > cargoCapacity) {
                System.out.println("Warning: Current cargo exceeds capacity without trailer!");
            }
            System.out.println("Trailer detached. Cargo capacity: " + cargoCapacity + " tons");
        }
    }

    // Getters
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getCurrentCargo() {
        return currentCargo;
    }

    public boolean hasTrailer() {
        return hasTrailer;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }
} 