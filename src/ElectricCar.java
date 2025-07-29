/**
 * MULTIPLE INTERFACE IMPLEMENTATION EXAMPLE:
 * This class demonstrates:
 * 1. Multiple Interface Implementation: Implements IVehicle, IDriveable, IMaintainable, and IElectric
 * 2. Inheritance: Extends AbstractVehicle but overrides fuel-related methods for electric functionality
 * 3. Composition: Contains battery and electric motor components
 * 4. Method Overriding: Provides electric-specific implementations
 */
public class ElectricCar extends AbstractVehicle implements IElectric {
    // Electric-specific properties
    private double batteryCapacity; // in kWh
    private double currentBatteryLevel; // in kWh
    private boolean ecoMode;
    private String chargingPortType;
    private double efficiency; // km per kWh
    private boolean regenerativeBraking;

    /**
     * Constructor for ElectricCar
     */
    public ElectricCar(String brand, String model, int year, double batteryCapacity, String chargingPortType) {
        super(brand, model, year, 0); // Electric cars don't have fuel tanks
        this.batteryCapacity = batteryCapacity;
        this.currentBatteryLevel = batteryCapacity * 0.8; // Start with 80% charge
        this.ecoMode = false;
        this.chargingPortType = chargingPortType;
        this.efficiency = 5.0; // Default 5 km per kWh
        this.regenerativeBraking = true;
    }

    /**
     * POLYMORPHISM EXAMPLE:
     * Electric car specific type identification
     */
    @Override
    public String getVehicleType() {
        return "Electric Car";
    }

    /**
     * Electric cars can have high max speeds
     */
    @Override
    public int getMaxSpeed() {
        return ecoMode ? 120 : 200; // Limited in eco mode
    }

    /**
     * METHOD OVERRIDING: Electric vehicles don't use traditional fuel
     */
    @Override
    public double getFuelLevel() {
        return getBatteryLevel(); // Return battery level instead of fuel
    }

    @Override
    public void refuel(double amount) {
        charge(amount); // Redirect to charging
    }

    /**
     * Override start method for electric vehicles
     */
    @Override
    public void start() {
        if (!isRunning && currentBatteryLevel > 0) {
            isRunning = true;
            System.out.println(getVehicleType() + " " + brand + " " + model + " has started silently.");
        } else if (currentBatteryLevel <= 0) {
            System.out.println("Cannot start - battery depleted!");
        }
    }

    /**
     * Electric-specific acceleration
     */
    @Override
    public void accelerate() {
        if (isRunning && currentBatteryLevel > 0) {
            int acceleration = ecoMode ? 8 : 12; // Eco mode limits acceleration
            speed += acceleration;
            
            double energyConsumption = ecoMode ? 0.15 : 0.25;
            currentBatteryLevel -= energyConsumption;
            mileage += 1;
            mileageSinceService += 1;
            
            System.out.println(getVehicleType() + " " + brand + " " + model + 
                             " is accelerating smoothly. Current speed: " + speed + " km/h" +
                             (ecoMode ? " (Eco Mode)" : ""));
        }
    }

    /**
     * Electric cars with regenerative braking
     */
    @Override
    public void brake() {
        if (speed > 0) {
            int oldSpeed = speed;
            speed = Math.max(0, speed - 12);
            
            // Regenerative braking recovers some energy
            if (regenerativeBraking && oldSpeed > speed) {
                double energyRecovered = (oldSpeed - speed) * 0.01;
                currentBatteryLevel = Math.min(batteryCapacity, currentBatteryLevel + energyRecovered);
                System.out.println(getVehicleType() + " " + brand + " " + model + 
                                 " is braking with energy recovery. Current speed: " + speed + " km/h");
            } else {
                System.out.println(getVehicleType() + " " + brand + " " + model + 
                                 " is braking. Current speed: " + speed + " km/h");
            }
        }
    }

    // Implementation of IElectric interface
    @Override
    public double getBatteryLevel() {
        return (currentBatteryLevel / batteryCapacity) * 100;
    }

    @Override
    public void charge(double chargingTime) {
        double chargingRate = 50.0; // kWh per hour (example fast charging)
        double energyAdded = chargingTime * chargingRate;
        currentBatteryLevel = Math.min(batteryCapacity, currentBatteryLevel + energyAdded);
        
        System.out.println("Charged for " + chargingTime + " hours. Battery level: " + 
                         String.format("%.1f", getBatteryLevel()) + "%");
    }

    @Override
    public int getEstimatedRange() {
        return (int) (currentBatteryLevel * efficiency);
    }

    @Override
    public boolean isEcoMode() {
        return ecoMode;
    }

    @Override
    public void toggleEcoMode() {
        ecoMode = !ecoMode;
        if (ecoMode) {
            efficiency += 1.0; // Better efficiency in eco mode
        } else {
            efficiency -= 1.0;
        }
        System.out.println("Eco mode " + (ecoMode ? "enabled" : "disabled") + 
                         ". Efficiency: " + efficiency + " km/kWh");
    }

    @Override
    public String getChargingPortType() {
        return chargingPortType;
    }

    /**
     * Electric-specific maintenance
     */
    @Override
    public void performMaintenance() {
        System.out.println("Performing electric vehicle maintenance on " + brand + " " + model);
        System.out.println("- Checking battery health");
        System.out.println("- Testing electric motor");
        System.out.println("- Inspecting charging port");
        System.out.println("- Updating software");
        resetServiceIndicator();
    }

    // Additional getters
    public double getBatteryCapacityKWh() {
        return batteryCapacity;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public boolean hasRegenerativeBraking() {
        return regenerativeBraking;
    }
} 