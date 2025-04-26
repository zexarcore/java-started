/**
 * INTERFACE EXAMPLE:
 * This interface defines the contract that all vehicles must follow.
 * It declares the methods that any class implementing this interface must provide.
 * This is an example of abstraction where we define what a vehicle can do without specifying how.
 */
public interface IVehicle {
    // All vehicles must be able to start
    void start();
    
    // All vehicles must be able to stop
    void stop();
    
    // All vehicles must be able to accelerate
    void accelerate();
    
    // All vehicles must be able to brake
    void brake();
    
    // All vehicles must be able to identify their type
    String getVehicleType();
} 