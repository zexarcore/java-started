/**
 * FACTORY PATTERN EXAMPLE:
 * This class demonstrates the Factory Design Pattern, which is a creational pattern
 * that provides an interface for creating objects without specifying their exact class.
 * Benefits:
 * 1. Encapsulates object creation logic
 * 2. Promotes loose coupling
 * 3. Makes code more maintainable and extensible
 */
public class VehicleFactory {
    
    /**
     * Enum to define available vehicle types
     * This demonstrates ENCAPSULATION and type safety
     */
    public enum VehicleType {
        CAR, MOTORCYCLE, TRUCK, ELECTRIC_CAR
    }
    
    /**
     * FACTORY METHOD:
     * Creates different types of vehicles based on the type parameter
     * This method demonstrates POLYMORPHISM as it returns AbstractVehicle reference
     * but creates specific vehicle types
     */
    public static AbstractVehicle createVehicle(VehicleType type, String brand, String model, int year) {
        switch (type) {
            case CAR:
                return new Car(brand, model, year, 4);
                
            case MOTORCYCLE:
                return new Motorcycle(brand, model, year, false);
                
            case TRUCK:
                return new Truck(brand, model, year, 10.0, 3);
                
            case ELECTRIC_CAR:
                return new ElectricCar(brand, model, year, 75.0, "Type 2");
                
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
    
    /**
     * Overloaded factory method with additional parameters
     * This demonstrates METHOD OVERLOADING
     */
    public static AbstractVehicle createVehicle(VehicleType type, String brand, String model, int year, Object... params) {
        switch (type) {
            case CAR:
                int doors = params.length > 0 ? (Integer) params[0] : 4;
                return new Car(brand, model, year, doors);
                
            case MOTORCYCLE:
                boolean hasSidecar = params.length > 0 ? (Boolean) params[0] : false;
                int engineSize = params.length > 1 ? (Integer) params[1] : 600;
                String motorcycleType = params.length > 2 ? (String) params[2] : "Sport";
                return new Motorcycle(brand, model, year, hasSidecar, engineSize, motorcycleType);
                
            case TRUCK:
                double cargoCapacity = params.length > 0 ? (Double) params[0] : 10.0;
                int axles = params.length > 1 ? (Integer) params[1] : 3;
                return new Truck(brand, model, year, cargoCapacity, axles);
                
            case ELECTRIC_CAR:
                double batteryCapacity = params.length > 0 ? (Double) params[0] : 75.0;
                String chargingPort = params.length > 1 ? (String) params[1] : "Type 2";
                return new ElectricCar(brand, model, year, batteryCapacity, chargingPort);
                
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
    
    /**
     * Factory method for creating random vehicles
     * Useful for testing and demonstrations
     */
    public static AbstractVehicle createRandomVehicle() {
        VehicleType[] types = VehicleType.values();
        VehicleType randomType = types[(int) (Math.random() * types.length)];
        
        String[] brands = {"Toyota", "Honda", "Ford", "BMW", "Tesla", "Volvo", "Mercedes"};
        String[] models = {"Model A", "Model B", "Model C", "Model X", "Model Y"};
        
        String randomBrand = brands[(int) (Math.random() * brands.length)];
        String randomModel = models[(int) (Math.random() * models.length)];
        int randomYear = 2015 + (int) (Math.random() * 10); // Years 2015-2024
        
        return createVehicle(randomType, randomBrand, randomModel, randomYear);
    }
    
    /**
     * Method to get all available vehicle types
     * Demonstrates ENCAPSULATION by providing controlled access to enum values
     */
    public static VehicleType[] getAvailableTypes() {
        return VehicleType.values();
    }
    
    /**
     * Method to validate if a vehicle type is supported
     */
    public static boolean isTypeSupported(String typeName) {
        try {
            VehicleType.valueOf(typeName.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
} 