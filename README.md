# Proyecto Java OOP - Conceptos de Programación Orientada a Objetos

## 📋 Descripción del Proyecto

Este proyecto es una **demostración completa de los conceptos fundamentales de la Programación Orientada a Objetos (OOP)** en Java. Utiliza un sistema de gestión de vehículos para ilustrar todos los principios fundamentales de OOP de manera práctica y comprensible.

## 🎯 Objetivos de Aprendizaje

Al estudiar este proyecto, comprenderás:

- ✅ **Interfaces** y su implementación
- ✅ **Clases Abstractas** y herencia
- ✅ **Herencia** entre clases
- ✅ **Polimorfismo** en tiempo de ejecución
- ✅ **Encapsulación** de datos
- ✅ **Composición** entre objetos
- ✅ **Patrones de Diseño** (Factory Pattern)
- ✅ **Sobrecarga** y **Sobreescritura** de métodos

## 🏗️ Estructura del Proyecto

```
src/
├── IVehicle.java          # Interface principal para vehículos
├── IDriveable.java        # Interface para funcionalidades de conducción
├── IMaintainable.java     # Interface para mantenimiento
├── IElectric.java         # Interface específica para vehículos eléctricos
├── AbstractVehicle.java   # Clase abstracta base
├── Car.java              # Clase concreta: Automóvil
├── Motorcycle.java       # Clase concreta: Motocicleta
├── Truck.java            # Clase concreta: Camión
├── ElectricCar.java      # Clase concreta: Auto eléctrico
├── VehicleFactory.java   # Patrón Factory para crear vehículos
├── User.java             # Clase que demuestra composición
└── App.java              # Clase principal con demostraciones
```

## 🔧 Conceptos de OOP Implementados

### 1. 🎯 Interfaces (Interfaces)

Las interfaces definen **contratos** que las clases deben cumplir.

#### `IVehicle.java`
```java
public interface IVehicle {
    void start();
    void stop();
    void accelerate();
    void brake();
    String getVehicleType();
}
```

**¿Qué demuestra?**
- Define métodos que **todas** las clases de vehículos deben implementar
- Permite **polimorfismo** - tratar diferentes vehículos de manera uniforme
- **Abstracción** - define QUÉ hacer, no CÓMO hacerlo

#### Interfaces Adicionales:
- **`IDriveable`**: Funcionalidades de conducción (cambio de marchas, combustible)
- **`IMaintainable`**: Operaciones de mantenimiento
- **`IElectric`**: Características específicas de vehículos eléctricos

### 2. 🏛️ Clases Abstractas (Abstract Classes)

#### `AbstractVehicle.java`
```java
public abstract class AbstractVehicle implements IVehicle, IDriveable, IMaintainable {
    protected String brand;
    protected String model;
    // ... implementación común
    
    // Método abstracto que subclases DEBEN implementar
    public abstract String getVehicleType();
}
```

**¿Qué demuestra?**
- **Implementación parcial**: Proporciona código común a todas las subclases
- **Campos protegidos**: Compartidos con subclases
- **Métodos concretos**: Implementación por defecto que puede ser heredada
- **Métodos abstractos**: Obligan a subclases a proporcionar implementación específica

### 3. 🧬 Herencia (Inheritance)

#### Ejemplo: `Car.java`
```java
public class Car extends AbstractVehicle {
    private int numberOfDoors;
    
    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year, 60.0); // Llama al constructor padre
        this.numberOfDoors = numberOfDoors;
    }
    
    @Override
    public String getVehicleType() {
        return "Car"; // Implementación específica
    }
}
```

**¿Qué demuestra?**
- **Reutilización de código**: Hereda funcionalidad de `AbstractVehicle`
- **Constructor padre**: Uso de `super()` para inicializar la clase base
- **Extensión**: Añade características específicas (`numberOfDoors`)
- **Especialización**: Implementa métodos abstractos

### 4. 🎭 Polimorfismo (Polymorphism)

#### En `App.java`:
```java
// Diferentes tipos de vehículos tratados como AbstractVehicle
AbstractVehicle[] vehicles = {myCar, sportBike, deliveryTruck, tesla};

for (AbstractVehicle vehicle : vehicles) {
    vehicle.start();      // Cada vehículo implementa start() diferente
    vehicle.accelerate(); // Comportamiento específico por tipo
    vehicle.brake();      // Diferentes implementaciones
}
```

**¿Qué demuestra?**
- **Polimorfismo en tiempo de ejecución**: El método correcto se llama según el tipo real del objeto
- **Interfaz común**: Mismo código funciona con diferentes tipos
- **Flexibilidad**: Fácil agregar nuevos tipos sin cambiar código existente

### 5. 🔒 Encapsulación (Encapsulation)

#### Ejemplo en `User.java`:
```java
public class User {
    private String name;           // Campo privado
    private String email;          // Campo privado
    private List<AbstractVehicle> vehicles; // Campo privado
    
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    
    public String getEmail() {
        return email;
    }
}
```

**¿Qué demuestra?**
- **Campos privados**: Datos internos protegidos
- **Métodos públicos**: Interfaz controlada para acceder a los datos
- **Validación**: Control de datos en setters
- **Seguridad**: Previene modificaciones directas no válidas

### 6. 🧩 Composición (Composition)

#### En `User.java`:
```java
public class User {
    private List<AbstractVehicle> vehicles; // User "tiene" vehículos
    
    public void addVehicle(AbstractVehicle vehicle) {
        if (hasValidLicense) {
            vehicles.add(vehicle);
        }
    }
}
```

**¿Qué demuestra?**
- **Relación "tiene-un"**: User tiene vehículos
- **Agregación**: Objetos independientes que colaboran
- **Encapsulación de colecciones**: Control sobre cómo se manejan los objetos contenidos

### 7. 🏭 Patrones de Diseño - Factory Pattern

#### `VehicleFactory.java`:
```java
public static AbstractVehicle createVehicle(VehicleType type, String brand, String model, int year) {
    switch (type) {
        case CAR:
            return new Car(brand, model, year, 4);
        case MOTORCYCLE:
            return new Motorcycle(brand, model, year, false);
        // ... más casos
    }
}
```

**¿Qué demuestra?**
- **Creación centralizada**: Un solo lugar para crear objetos
- **Flexibilidad**: Fácil cambiar lógica de creación
- **Desacoplamiento**: Cliente no necesita conocer clases concretas

### 8. 🔄 Sobrecarga y Sobreescritura de Métodos

#### Sobrecarga (Overloading):
```java
// Constructor con parámetros básicos
public Motorcycle(String brand, String model, int year, boolean hasSidecar)

// Constructor sobrecargado con más parámetros
public Motorcycle(String brand, String model, int year, boolean hasSidecar, int engineSize, String type)
```

#### Sobreescritura (Overriding):
```java
@Override
public void accelerate() {
    // Implementación específica para motocicletas
    speed += 15; // Más rápido que otros vehículos
}
```

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos
- Java JDK 8 o superior
- IDE (recomendado: VS Code, IntelliJ IDEA, o Eclipse)

### Pasos para ejecutar:

1. **Clonar o descargar** el proyecto
2. **Navegar** a la carpeta del proyecto
3. **Compilar** todos los archivos Java:
   ```bash
   javac src/*.java
   ```
4. **Ejecutar** la aplicación principal:
   ```bash
   java -cp src App
   ```

### Ejecución desde IDE:
1. Abrir el proyecto en tu IDE favorito
2. Ejecutar la clase `App.java`
3. Observar la salida en la consola

## 📚 Resultados Esperados

Al ejecutar el programa, verás demostraciones de:

1. **Creación de vehículos** usando Factory Pattern
2. **Polimorfismo** con diferentes tipos de vehículos
3. **Métodos específicos** de cada clase
4. **Implementación de múltiples interfaces**
5. **Sistema de usuarios** con composición
6. **Mantenimiento** con comportamientos específicos
7. **Vehículos eléctricos** con funcionalidades especiales

## 🎓 Ejercicios Propuestos

### Nivel Básico:
1. Crear una nueva clase `Bus` que extienda `AbstractVehicle`
2. Agregar método `loadPassengers()` específico para autobuses
3. Implementar diferentes comportamientos de aceleración

### Nivel Intermedio:
4. Crear interface `IAmphibious` para vehículos anfibios
5. Implementar clase `BoatCar` que implemente múltiples interfaces
6. Agregar sistema de seguros para vehículos

### Nivel Avanzado:
7. Implementar patrón Observer para notificaciones de mantenimiento
8. Crear sistema de alquiler de vehículos con diferentes tarifas
9. Agregar persistencia de datos (guardar/cargar desde archivos)

## 🔍 Puntos Clave de Aprendizaje

### Interfaces vs Clases Abstractas:
- **Interfaces**: Contratos puros, múltiple herencia
- **Clases Abstractas**: Implementación parcial, herencia simple

### Herencia vs Composición:
- **Herencia**: Relación "es-un" (Car ES-UN AbstractVehicle)
- **Composición**: Relación "tiene-un" (User TIENE vehículos)

### Polimorfismo:
- Permite escribir código que funciona con múltiples tipos
- Facilita extensibilidad y mantenimiento
- Base para muchos patrones de diseño

## 🛠️ Mejores Prácticas Implementadas

1. **Naming Conventions**: Nombres descriptivos y consistentes
2. **Validation**: Validación de datos en constructores y setters
3. **Documentation**: Comentarios explicativos abundantes
4. **Error Handling**: Manejo apropiado de excepciones
5. **Encapsulation**: Acceso controlado a datos internos
6. **Single Responsibility**: Cada clase tiene una responsabilidad clara

## 📖 Recursos Adicionales

### Documentación:
- [Oracle Java Tutorials - OOP](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Java Interfaces](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
- [Java Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)

### Libros Recomendados:
- "Effective Java" por Joshua Bloch
- "Head First Design Patterns" por Freeman & Robson
- "Clean Code" por Robert Martin

## 📝 Conclusión

Este proyecto demuestra de manera integral todos los conceptos fundamentales de la Programación Orientada a Objetos en Java. Cada archivo contiene comentarios detallados explicando qué concepto demuestra y por qué es importante.

La estructura modular y los ejemplos prácticos permiten entender no solo CÓMO implementar OOP, sino también CUÁNDO y POR QUÉ usar cada concepto.

**¡Explora el código, experimenta con modificaciones y crea tus propias extensiones!**