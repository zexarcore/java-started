/**
 * ADDITIONAL INTERFACE EXAMPLE:
 * This interface demonstrates how classes can implement multiple interfaces.
 * It defines specific driving behaviors that can be applied to different vehicle types.
 */
public interface IDriveable {
    /**
     * Method to change gear (for manual transmission vehicles)
     * @param gear The gear number to change to
     */
    void changeGear(int gear);
    
    /**
     * Method to check fuel level
     * @return Current fuel level as percentage
     */
    double getFuelLevel();
    
    /**
     * Method to refuel the vehicle
     * @param amount Amount of fuel to add
     */
    void refuel(double amount);
    
    /**
     * Method to get maximum speed
     * @return Maximum speed in km/h
     */
    int getMaxSpeed();
} 