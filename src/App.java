
/**
 * COMPREHENSIVE OOP DEMONSTRATION:
 * This class showcases all major Object-Oriented Programming concepts:
 * 1. INTERFACES - IVehicle, IDriveable, IMaintainable, IElectric
 * 2. ABSTRACT CLASSES - AbstractVehicle
 * 3. INHERITANCE - Car, Motorcycle, Truck, ElectricCar extending AbstractVehicle
 * 4. POLYMORPHISM - Different vehicles treated as AbstractVehicle/IVehicle
 * 5. ENCAPSULATION - Private fields with public getters/setters
 * 6. COMPOSITION - User has vehicles
 * 7. DESIGN PATTERNS - Factory Pattern
 * 8. METHOD OVERRIDING - Different implementations in subclasses
 * 9. METHOD OVERLOADING - Multiple constructors and methods
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== COMPREHENSIVE JAVA OOP DEMONSTRATION ===\n");
        
        // ==========================================
        // 1. FACTORY PATTERN DEMONSTRATION
        // ==========================================
        System.out.println("1. FACTORY PATTERN EXAMPLE:");
        System.out.println("Creating vehicles using Factory Pattern...\n");
        
        AbstractVehicle factoryCar = VehicleFactory.createVehicle(
            VehicleFactory.VehicleType.CAR, "Toyota", "Camry", 2022);
        AbstractVehicle factoryTruck = VehicleFactory.createVehicle(
            VehicleFactory.VehicleType.TRUCK, "Volvo", "FH16", 2023, 20.0, 4);
        AbstractVehicle randomVehicle = VehicleFactory.createRandomVehicle();
        
        System.out.println("Factory created: " + factoryCar.getVehicleType() + " - " + 
                         factoryCar.getBrand() + " " + factoryCar.getModel());
        System.out.println("Factory created: " + factoryTruck.getVehicleType() + " - " + 
                         factoryTruck.getBrand() + " " + factoryTruck.getModel());
        System.out.println("Random vehicle: " + randomVehicle.getVehicleType() + " - " + 
                         randomVehicle.getBrand() + " " + randomVehicle.getModel());

        // ==========================================
        // 2. CREATING DIVERSE VEHICLE INSTANCES
        // ==========================================
        System.out.println("\n2. INHERITANCE AND POLYMORPHISM EXAMPLES:");
        System.out.println("Creating instances of different vehicle types...\n");
        
        // Regular car
        Car myCar = new Car("Honda", "Civic", 2021, 4);
        
        // Sport motorcycle with specific parameters
        Motorcycle sportBike = new Motorcycle("Kawasaki", "Ninja", 2022, false, 1000, "Sport");
        
        // Heavy truck
        Truck deliveryTruck = new Truck("Mercedes", "Actros", 2023, 25.0, 5);
        
        // Electric car
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 75.0, "Type 2");

        // ==========================================
        // 3. POLYMORPHISM DEMONSTRATION
        // ==========================================
        System.out.println("3. POLYMORPHISM IN ACTION:");
        System.out.println("Treating different vehicle types through common interface...\n");
        
        // Array of different vehicle types treated as AbstractVehicle
        AbstractVehicle[] vehicles = {myCar, sportBike, deliveryTruck, tesla};
        
        for (AbstractVehicle vehicle : vehicles) {
            System.out.println("\n--- Testing " + vehicle.getVehicleType() + " ---");
            System.out.println("Brand: " + vehicle.getBrand() + ", Model: " + vehicle.getModel());
            System.out.println("Max Speed: " + vehicle.getMaxSpeed() + " km/h");
            
            // Common interface methods work on all vehicle types
            vehicle.start();
            vehicle.accelerate();
            vehicle.accelerate();
            
            // Demonstrate different fuel/energy systems
            System.out.println("Energy Level: " + String.format("%.1f", vehicle.getFuelLevel()) + 
                             (vehicle instanceof ElectricCar ? "%" : "L"));
            
            vehicle.brake();
            vehicle.stop();
        }

        // ==========================================
        // 4. SPECIFIC CLASS METHODS DEMONSTRATION
        // ==========================================
        System.out.println("\n4. CLASS-SPECIFIC METHODS:");
        System.out.println("Demonstrating unique behaviors of each vehicle type...\n");
        
        // Car-specific methods
        myCar.openTrunk();
        myCar.turnOnAirConditioning();
        
        // Motorcycle-specific methods
        sportBike.start();
        sportBike.accelerate();
        sportBike.accelerate();
        sportBike.wheelie();
        sportBike.stop();
        
        // Truck-specific methods
        deliveryTruck.loadCargo(15.0);
        deliveryTruck.attachTrailer();
        deliveryTruck.loadCargo(10.0);
        
        // Electric car-specific methods
        tesla.toggleEcoMode();
        tesla.charge(2.0);
        System.out.println("Tesla range: " + tesla.getEstimatedRange() + " km");

        // ==========================================
        // 5. INTERFACE IMPLEMENTATION DEMONSTRATION
        // ==========================================
        System.out.println("\n5. MULTIPLE INTERFACE IMPLEMENTATION:");
        System.out.println("Demonstrating how vehicles implement multiple interfaces...\n");
        
        // IDriveable interface methods
        System.out.println("Gear changing demonstration:");
        myCar.changeGear(3);  // Manual car
        tesla.changeGear(2);  // Electric car (different behavior)
        
        // Refueling/charging
        myCar.refuel(20.0);
        tesla.refuel(1.5); // Actually charges the battery
        
        // IMaintainable interface methods
        System.out.println("\nMaintenance demonstration:");
        if (sportBike.needsService()) {
            sportBike.performMaintenance();
        }
        
        // Force maintenance for demonstration
        deliveryTruck.performMaintenance();

        // ==========================================
        // 6. COMPOSITION EXAMPLE WITH USER CLASS
        // ==========================================
        System.out.println("\n6. COMPOSITION EXAMPLE:");
        System.out.println("User class demonstrating composition and encapsulation...\n");
        
        // Create users with validation
        User john = new User("John Doe", "john@email.com", "password123", "DL12345678");
        User jane = new User("Jane Smith", "jane@email.com", "securepass");
        
        // Add vehicles to users (composition)
        john.addVehicle(myCar);
        john.addVehicle(sportBike);
        john.addVehicle(tesla);
        
        jane.addVehicle(deliveryTruck); // Should fail - no license
        
        // User operations
        System.out.println("\n" + john.getName() + " has " + john.getVehicleCount() + " vehicles");
        
        AbstractVehicle fastest = john.getFastestVehicle();
        if (fastest != null) {
            System.out.println("Fastest vehicle: " + fastest.getBrand() + " " + fastest.getModel() + 
                             " (" + fastest.getMaxSpeed() + " km/h)");
        }

        // ==========================================
        // 7. ADVANCED POLYMORPHISM DEMONSTRATION
        // ==========================================
        System.out.println("\n7. ADVANCED POLYMORPHISM:");
        System.out.println("Different vehicles, same method calls, different behaviors...\n");
        
        john.testDriveAllVehicles();

        // ==========================================
        // 8. MAINTENANCE SYSTEM DEMONSTRATION
        // ==========================================
        System.out.println("\n8. MAINTENANCE SYSTEM:");
        System.out.println("Polymorphic maintenance calls with different implementations...\n");
        
        john.performMaintenanceOnAllVehicles();

        // ==========================================
        // 9. ELECTRIC VEHICLE SPECIFIC FEATURES
        // ==========================================
        System.out.println("\n9. ELECTRIC VEHICLE FEATURES:");
        System.out.println("Demonstrating IElectric interface implementation...\n");
        
        if (tesla instanceof IElectric) {
            IElectric electricVehicle = tesla; // Interface reference
            
            System.out.println("Battery Level: " + String.format("%.1f", electricVehicle.getBatteryLevel()) + "%");
            System.out.println("Estimated Range: " + electricVehicle.getEstimatedRange() + " km");
            System.out.println("Charging Port: " + electricVehicle.getChargingPortType());
            System.out.println("Eco Mode: " + (electricVehicle.isEcoMode() ? "ON" : "OFF"));
        }

        // ==========================================
        // 10. SUMMARY OF OOP CONCEPTS DEMONSTRATED
        // ==========================================
        System.out.println("\n10. OOP CONCEPTS SUMMARY:");
        System.out.println("✓ Interfaces: IVehicle, IDriveable, IMaintainable, IElectric");
        System.out.println("✓ Abstract Classes: AbstractVehicle with common implementation");
        System.out.println("✓ Inheritance: Car, Motorcycle, Truck, ElectricCar extend AbstractVehicle");
        System.out.println("✓ Polymorphism: Same method calls, different behaviors");
        System.out.println("✓ Encapsulation: Private fields, public methods, data validation");
        System.out.println("✓ Composition: User contains vehicles");
        System.out.println("✓ Method Overriding: Subclasses provide specific implementations");
        System.out.println("✓ Method Overloading: Multiple constructors and method signatures");
        System.out.println("✓ Design Patterns: Factory pattern for object creation");
        System.out.println("✓ Type Safety: Enums and proper type checking");
        
        System.out.println("\n=== END OF DEMONSTRATION ===");
    }
}