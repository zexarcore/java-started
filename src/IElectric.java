/**
 * ELECTRIC VEHICLE INTERFACE:
 * This interface demonstrates how to extend functionality through additional interfaces.
 * Electric vehicles have different characteristics from traditional fuel-based vehicles.
 */
public interface IElectric {
    /**
     * Get current battery level
     * @return Battery level as percentage (0-100)
     */
    double getBatteryLevel();
    
    /**
     * Charge the electric vehicle
     * @param chargingTime Time in hours
     */
    void charge(double chargingTime);
    
    /**
     * Get estimated range based on current battery
     * @return Range in kilometers
     */
    int getEstimatedRange();
    
    /**
     * Check if vehicle is in eco mode
     * @return true if eco mode is active
     */
    boolean isEcoMode();
    
    /**
     * Toggle eco mode for better efficiency
     */
    void toggleEcoMode();
    
    /**
     * Get charging port type
     * @return Type of charging port (Type 1, Type 2, CHAdeMO, etc.)
     */
    String getChargingPortType();
} 