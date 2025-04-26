
/**
 * DEMONSTRATION OF OOP CONCEPTS:
 * This class shows how interfaces, abstract classes, inheritance, and polymorphism work together.
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
         // Creating instances of different vehicles
         Car myCar = new Car("Toyota", "Corolla", 2020, 4);
         Motorcycle myMotorcycle = new Motorcycle("Honda", "CBR", 2021, false);
 
         /**
          * POLYMORPHISM EXAMPLE:
          * We can treat different types of vehicles (Car and Motorcycle) as Vehicle objects
          * This is possible because both classes implement the Vehicle interface
          */
         IVehicle[] vehicles = {myCar, myMotorcycle};
 
         /**
          * INTERFACE AND ABSTRACT CLASS DEMONSTRATION:
          * We can call methods defined in the Vehicle interface on any vehicle
          * The actual implementation comes from the AbstractVehicle class or its subclasses
          */
         for (IVehicle vehicle : vehicles) {
             System.out.println("\nTesting " + vehicle.getVehicleType() + ":");
             vehicle.start();
             vehicle.accelerate();
             vehicle.accelerate();
             vehicle.brake();
             vehicle.stop();
         }
 
         /**
          * INHERITANCE DEMONSTRATION:
          * We can call specific methods that are unique to each vehicle type
          * These methods are defined in the concrete classes (Car and Motorcycle)
          */
         myCar.openTrunk();
         myMotorcycle.wheelie();
 
         /**
          * INHERITANCE DEMONSTRATION:
          * We can access properties and methods inherited from AbstractVehicle
          * These are common to all vehicle types
          */
         System.out.println("\nVehicle Details:");
         System.out.println("Car: " + myCar.getBrand() + " " + myCar.getModel() + " (" + myCar.getYear() + ")");
         System.out.println("Motorcycle: " + myMotorcycle.getBrand() + " " + myMotorcycle.getModel() + 
                           " (" + myMotorcycle.getYear() + ")");
     
    }
}