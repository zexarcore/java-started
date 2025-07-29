/**
 * ABSTRACT CLASS EXAMPLE:
 * This abstract class implements multiple interfaces and provides common functionality
 * for all vehicles. It demonstrates:
 * 1. Multiple Interface Implementation: Implements IVehicle, IDriveable, and IMaintainable
 * 2. Inheritance: Serves as a base class for all vehicle types
 * 3. Abstraction: Provides common behavior while leaving some methods to be implemented by subclasses
 * 4. Encapsulation: Uses protected fields and public methods
 */
public abstract class AbstractVehicle implements IVehicle, IDriveable, IMaintainable {
    // Protected fields that will be inherited by all subclasses
    protected String brand;
    protected String model;
    protected int year;
    protected boolean isRunning;
    protected int speed;
    protected int currentGear;
    protected double fuelLevel;
    protected double fuelCapacity;
    protected int mileage;
    protected int mileageSinceService;

    /**
     * Constructor that initializes common vehicle properties
     * This constructor will be called by all subclasses using super()
     */
    public AbstractVehicle(String brand, String model, int year, double fuelCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isRunning = false;
        this.speed = 0;
        this.currentGear = 0;
        this.fuelLevel = fuelCapacity * 0.8; // Start with 80% fuel
        this.fuelCapacity = fuelCapacity;
        this.mileage = 0;
        this.mileageSinceService = 0;
    }

    /**
     * Implementation of IVehicle interface methods with common behavior
     * These methods can be overridden by subclasses if needed
     */
    @Override
    public void start() {
        if (!isRunning && fuelLevel > 0) {
            isRunning = true;
            System.out.println(getVehicleType() + " " + brand + " " + model + " has started.");
        } else if (fuelLevel <= 0) {
            System.out.println("Cannot start - no fuel!");
        }
    }

    @Override
    public void stop() {
        if (isRunning) {
            isRunning = false;
            speed = 0;
            currentGear = 0;
            System.out.println(getVehicleType() + " " + brand + " " + model + " has stopped.");
        }
    }

    @Override
    public void accelerate() {
        if (isRunning && fuelLevel > 0) {
            speed += 10;
            fuelLevel -= 0.5; // Consume fuel
            mileage += 1;
            mileageSinceService += 1;
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

    /**
     * Implementation of IDriveable interface methods
     */
    @Override
    public void changeGear(int gear) {
        if (isRunning && gear >= 0 && gear <= 6) {
            this.currentGear = gear;
            System.out.println("Changed to gear " + gear);
        }
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public void refuel(double amount) {
        fuelLevel = Math.min(fuelCapacity, fuelLevel + amount);
        System.out.println("Refueled. Current fuel level: " + String.format("%.1f", fuelLevel) + "L");
    }

    /**
     * Implementation of IMaintainable interface methods
     */
    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on " + brand + " " + model);
        resetServiceIndicator();
    }

    @Override
    public int getMileageSinceService() {
        return mileageSinceService;
    }

    @Override
    public boolean needsService() {
        return mileageSinceService > 10000; // Service needed every 10,000 km
    }

    @Override
    public void resetServiceIndicator() {
        mileageSinceService = 0;
        System.out.println("Service indicator reset");
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

    public int getCurrentGear() {
        return currentGear;
    }

    public int getMileage() {
        return mileage;
    }
} 