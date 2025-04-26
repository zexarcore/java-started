/**
 * ABSTRACT CLASS EXAMPLE:
 * This abstract class implements the Vehicle interface and provides common functionality
 * for all vehicles. It demonstrates:
 * 1. Interface Implementation: Implements all methods from the Vehicle interface
 * 2. Inheritance: Serves as a base class for all vehicle types
 * 3. Abstraction: Provides common behavior while leaving some methods to be implemented by subclasses
 */
public abstract class AbstractVehicle implements IVehicle {
    // Protected fields that will be inherited by all subclasses
    protected String brand;
    protected String model;
    protected int year;
    protected boolean isRunning;
    protected int speed;

    /**
     * Constructor that initializes common vehicle properties
     * This constructor will be called by all subclasses using super()
     */
    public AbstractVehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isRunning = false;
        this.speed = 0;
    }

    /**
     * Implementation of interface methods with common behavior
     * These methods can be overridden by subclasses if needed
     */
    @Override
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(getVehicleType() + " " + brand + " " + model + " has started.");
        }
    }

    @Override
    public void stop() {
        if (isRunning) {
            isRunning = false;
            speed = 0;
            System.out.println(getVehicleType() + " " + brand + " " + model + " has stopped.");
        }
    }

    @Override
    public void accelerate() {
        if (isRunning) {
            speed += 10;
            System.out.println(getVehicleType() + " " + brand + " " + model + " is accelerating. Current speed: " + speed + " km/h");
        }
    }

    @Override
    public void brake() {
        if (speed > 0) {
            speed = Math.max(0, speed - 10);
            System.out.println(getVehicleType() + " " + brand + " " + model + " is braking. Current speed: " + speed + " km/h");
        }
    }

    // Getters for common properties
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }
} 