/**
 * INHERITANCE AND POLYMORPHISM EXAMPLE:
 * This class demonstrates:
 * 1. Inheritance: Extends AbstractVehicle to inherit all its properties and methods
 * 2. Polymorphism: Can be treated as IVehicle, IDriveable, IMaintainable, or AbstractVehicle
 * 3. Method Overriding: Implements getVehicleType() and getMaxSpeed() differently from other vehicle types
 * 4. Encapsulation: Private fields with public getters/setters
 */
public class Car extends AbstractVehicle {
    // Additional properties specific to cars
    private int numberOfDoors;
    private boolean hasAirConditioning;
    private boolean automaticTransmission;

    /**
     * Constructor that calls the parent class constructor using super()
     * and initializes car-specific properties
     */
    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year, 60.0); // Cars typically have 60L fuel tank
        this.numberOfDoors = numberOfDoors;
        this.hasAirConditioning = true;
        this.automaticTransmission = numberOfDoors > 2; // Assume luxury cars have automatic
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

    /**
     * Implementation of abstract method from IDriveable interface
     * Cars typically have lower max speed than motorcycles
     */
    @Override
    public int getMaxSpeed() {
        return automaticTransmission ? 180 : 160; // Automatic cars typically faster
    }

    /**
     * METHOD OVERRIDING EXAMPLE:
     * Override the changeGear method for automatic transmission cars
     */
    @Override
    public void changeGear(int gear) {
        if (automaticTransmission) {
            System.out.println("This car has automatic transmission - gear changes automatically");
        } else {
            super.changeGear(gear);
        }
    }

    // Car-specific methods demonstrating ENCAPSULATION
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    public boolean isAutomaticTransmission() {
        return automaticTransmission;
    }

    /**
     * Car-specific behavior
     */
    public void openTrunk() {
        System.out.println("Opening trunk of " + brand + " " + model);
    }

    public void turnOnAirConditioning() {
        if (hasAirConditioning && isRunning) {
            System.out.println("Air conditioning turned on in " + brand + " " + model);
            fuelLevel -= 0.1; // AC consumes extra fuel
        }
    }
} 