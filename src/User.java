import java.util.ArrayList;
import java.util.List;

/**
 * USER CLASS EXAMPLE:
 * This class demonstrates:
 * 1. Encapsulation: Private fields with public getters/setters
 * 2. Composition: User has a collection of vehicles
 * 3. Data validation in setters
 * 4. Business logic methods
 */
public class User {
    // Private fields demonstrating ENCAPSULATION
    private String name;
    private String email;
    private String password;
    private List<AbstractVehicle> vehicles; // COMPOSITION: User has vehicles
    private String licenseNumber;
    private boolean hasValidLicense;

    /**
     * Constructor with validation
     */
    public User(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        this.vehicles = new ArrayList<>();
        this.hasValidLicense = false;
    }

    /**
     * Overloaded constructor with license information
     */
    public User(String name, String email, String password, String licenseNumber) {
        this(name, email, password);
        setLicenseNumber(licenseNumber);
        this.hasValidLicense = true;
    }

    // ENCAPSULATION: Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber != null && licenseNumber.length() >= 8) {
            this.licenseNumber = licenseNumber;
            this.hasValidLicense = true;
        } else {
            throw new IllegalArgumentException("License number must be at least 8 characters");
        }
    }

    // ENCAPSULATION: Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password; // In real application, this might be hashed
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public boolean hasValidLicense() {
        return hasValidLicense;
    }

    // COMPOSITION: Methods to manage vehicles
    public void addVehicle(AbstractVehicle vehicle) {
        if (hasValidLicense) {
            vehicles.add(vehicle);
            System.out.println("Vehicle " + vehicle.getBrand() + " " + vehicle.getModel() + 
                             " added to " + name + "'s collection");
        } else {
            System.out.println("Cannot add vehicle - user doesn't have a valid license");
        }
    }

    public void removeVehicle(AbstractVehicle vehicle) {
        if (vehicles.remove(vehicle)) {
            System.out.println("Vehicle " + vehicle.getBrand() + " " + vehicle.getModel() + 
                             " removed from " + name + "'s collection");
        }
    }

    public List<AbstractVehicle> getVehicles() {
        return new ArrayList<>(vehicles); // Return copy to maintain encapsulation
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    // Business logic methods
    public void performMaintenanceOnAllVehicles() {
        System.out.println("\n" + name + " is performing maintenance on all vehicles:");
        for (AbstractVehicle vehicle : vehicles) {
            if (vehicle.needsService()) {
                vehicle.performMaintenance();
            } else {
                System.out.println(vehicle.getBrand() + " " + vehicle.getModel() + " doesn't need service yet");
            }
        }
    }

    public AbstractVehicle getFastestVehicle() {
        if (vehicles.isEmpty()) {
            return null;
        }
        
        AbstractVehicle fastest = vehicles.get(0);
        for (AbstractVehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() > fastest.getMaxSpeed()) {
                fastest = vehicle;
            }
        }
        return fastest;
    }

    public List<AbstractVehicle> getVehiclesByType(String type) {
        List<AbstractVehicle> result = new ArrayList<>();
        for (AbstractVehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Method demonstrating POLYMORPHISM
    public void testDriveAllVehicles() {
        System.out.println("\n" + name + " is test driving all vehicles:");
        for (AbstractVehicle vehicle : vehicles) {
            System.out.println("\nTesting " + vehicle.getVehicleType() + ":");
            vehicle.start();
            vehicle.accelerate();
            vehicle.brake();
            vehicle.stop();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles.size() +
                ", hasValidLicense=" + hasValidLicense +
                '}';
    }
}
