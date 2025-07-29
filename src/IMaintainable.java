/**
 * MAINTENANCE INTERFACE EXAMPLE:
 * This interface demonstrates composition and multiple inheritance through interfaces.
 * It defines maintenance-related behaviors for vehicles.
 */
public interface IMaintainable {
    /**
     * Perform regular maintenance check
     */
    void performMaintenance();
    
    /**
     * Get the mileage since last service
     * @return Mileage in kilometers
     */
    int getMileageSinceService();
    
    /**
     * Check if vehicle needs service
     * @return true if service is needed
     */
    boolean needsService();
    
    /**
     * Reset service indicator after maintenance
     */
    void resetServiceIndicator();
} 