package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

//Interface - every vehicle must have these
interface Maintainable {
    double serviceCost();
    boolean needsService();
}

//Abstract Class
abstract class Vehicle  implements Maintainable {

    // protected Variables - stored for each vehicle
        protected String vehicleID;
        protected String driverName;
        protected double distanceTravelled;
        protected double energyUsed;
        protected String location;

    //Parameterized Constructor
        public Vehicle (String VehicleID, String driverName, double distanceTravelled, double energyUsed) {

            this.vehicleID = VehicleID;
            this.driverName = driverName;
            this.distanceTravelled = distanceTravelled;
            this.energyUsed = energyUsed;
        this.location = "undefined  ";
    }

    //method to update location
    public void updateLocation(String location) {
        this.location = location;
    }

    //abstract methods - these need to be implemented by all the child subclasses
    abstract double tripCost();
    abstract double efficiency();
    abstract double carbonFootprint();

            //Display Method
    public void Display() {
        System.out.println("ID: " + vehicleID +
                " | " + getClass().getSimpleName() +
                //Instead of using type casting used string format
                " | Cost: " + String.format("%.2f", tripCost()) +
                " | Efficiency: " + String.format("%.2f", efficiency()) +
                " | Carbon: " + String.format("%.2f", carbonFootprint()));
    }
    }

    //CHILD CLASSES
    // CAR method
class Car extends Vehicle {
        public Car(String id, String driver, double dist, double fuel) {
            super(id, driver, dist, fuel);
        }

        double tripCost() {

            double cost = energyUsed * 100; //100rs per litre

            //Dyanamic Pricing - if distance greater than 300 - 10% extra cost
            // if distance is greater than 600 - 20% extra cost
            if (distanceTravelled > 600) {
                cost = cost *1.2;
            }else if (distanceTravelled > 300) {
                cost = cost *1.1;
            }
            return cost;
        }


        double efficiency() {

            if (energyUsed == 0) {
                return 0;
            }
            return distanceTravelled / energyUsed;

        }

        double carbonFootprint() {

            //2.3 kg per litre petrol
            return energyUsed * 2.3;
        }

        public double serviceCost() {
            return 3000;
        }

        public boolean needsService() {
            return distanceTravelled > 5000;
        }
}

    // BIKE
    class Bike extends Vehicle {
    public Bike(String id, String driver, double dist, double fuel) {
        super(id, driver, dist, fuel);
    }

        double tripCost() {

            double cost = energyUsed * 100;

            //Dyanamic Pricing - if distance greater than 300 - 10% extra cost
            // if distacne is greater than 600 - 20% extra cost

            if (distanceTravelled > 600) {
                cost = cost *1.2;
            }else if (distanceTravelled > 300) {
                cost = cost *1.1;
            }
            return cost;
        }

    double efficiency() {
        if (energyUsed == 0)
            return 0;
        return distanceTravelled / energyUsed;
    }
        //2.3 kg per litre petrol
        double carbonFootprint() {
            return energyUsed * 2.3;
        }

        //Cheaper Maintainance
        public double serviceCost() {
            return 800;
        }

        public boolean needsService() {
            return distanceTravelled > 3000;
        }
    }

    //truck
class Truck extends Vehicle {
    double cargoWeight;

        public Truck(String id, String driver, double dist,
                    double fuel, double cargoWeight) {

            super(id, driver, dist, fuel);
            this.cargoWeight = cargoWeight;
    }

    double tripCost() {

        double cost = energyUsed * 90;
        //Dyanamic Pricing - if distance greater than 300 - 15% extra cost
        // if distacne is greater than 600 - 30% extra cost

        if (distanceTravelled > 600) {
            cost = cost *1.3;
        }else if (distanceTravelled > 300) {
            cost = cost *1.15;
        }
        return cost;
    }

    double efficiency() {
        if (energyUsed == 0) return 0;
        return distanceTravelled / energyUsed;
    }
    //2.6 kg per litre petrol
    double carbonFootprint() {
        return energyUsed * 2.6;
    }

    public double serviceCost() {
        return 7000;
    }

    public boolean needsService() {
        return distanceTravelled > 7000;
    }
}

//ELectrical Car
class ElectricCar extends Car {

    public ElectricCar(String id, String driver,
                       double dist, double batteryUsed) {
        super(id, driver, dist, batteryUsed);
    }

    double tripCost() {

        double cost = energyUsed * 10;
        //Dyanamic Pricing - if distance greater than 300 - 5% extra cost
        // if distacne is greater than 600 - 15% extra cost

        if (distanceTravelled > 600) {
            cost = cost *1.15;
        }else if (distanceTravelled > 300) {
            cost = cost *1.05;
        }
        return cost;
    }

    double carbonFootprint() {
        return  0.7 * energyUsed;
    }

    public double serviceCost() {
        return 1500;
    }

    public boolean needsService() {
        return distanceTravelled > 10000;
    }
}

//Hybrid Vehicle
//The hybridVehicle uses both fuel and battery, so cost = fuel cost + battery cost
//carbon = less than car but more than electric

class HybridVehicle extends Vehicle {
    double batteryUsed;

    public HybridVehicle(String id, String driver, double dist, double fuel, double batterUsed) {

            super(id, driver, dist, fuel);
        this.batteryUsed = batterUsed;
    }

    double tripCost() {

        double cost = (energyUsed * 100) + (batteryUsed * 10);
            //Dyanamic Pricing - if distance greater than 300 - 10% extra cost
        // if distacne is greater than 600 - 20% extra cost

        if (distanceTravelled > 600) {
            cost = cost *1.2;
            }else if (distanceTravelled > 300) {
            cost = cost *1.1;
        }
            return cost;
    }

    double efficiency() {
        double totalEnergy = energyUsed + batteryUsed;
        if (totalEnergy == 0) {
            return 0;
        }
            return distanceTravelled / totalEnergy;
    }

    public double carbonFootprint() {
        return (energyUsed * 2.3) * 0.5 + (batteryUsed * 0.7) *0.5;
    }

    public double serviceCost() {
        return 4000;
    }

    public boolean needsService() {
        return distanceTravelled > 6000;
    }
}

// Fleet Manager
class FleetManager {

    //stores all the vehicles
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //method to add vehicles to the list
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }


    public void generateReport() {

        //If cndition to check if list is empty but there are already objects hardcoded for the report
        if (vehicles.size() == 0) {
            System.out.println("No vehicles added");

                    return;
        }

            System.out.println(".                         GREENFLEET DAILY REPORT                          .");
        //print each variable
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).Display();
        }

        System.out.println("____________________________________________________________");


        double totalCost = 0;
        double totalCarbon = 0;

        for (int i = 0; i < vehicles.size(); i++) {
            totalCost += vehicles.get(i).tripCost();
            totalCarbon += vehicles.get(i).carbonFootprint();
        }

        System.out.println("Total Cost: " + totalCost);
        System.out.println("Total Carbon: " + totalCarbon + " Kg Co2");

        Vehicle best = vehicles.get( 0 );

        for (int i = 1; i < vehicles.size(); i++) {
            if (vehicles.get(i).efficiency() > best.efficiency()) {
                best = vehicles.get(i);

            }
        }

        System.out.println("Cheapest Vehicle : " + cheapest().getClass().getSimpleName());
        System.out.println("Vehicle with Least Carbon Footprint: " + leastCarbon().getClass().getSimpleName());
        System.out.println();
        System.out.println("Best Vehicle: " + best.getClass().getSimpleName());

    }
    //to find vehicle by ID
    //to add a function for the GPS system
    public Vehicle findVehicle(String id) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).vehicleID.equals(id)) {
                return vehicles.get(i);

            }
        }
            return null; //if not found
    }

    public Vehicle leastCarbon() {
        Vehicle best = vehicles.get(0);

        for (int i = 1; i < vehicles.size(); i++) {

            if (vehicles.get(i).carbonFootprint() < best.carbonFootprint()) {
                best = vehicles.get(i);

            }
        }
            return best;
    }

    //Sort by Cheapest
    public Vehicle cheapest() {
        Vehicle best = vehicles.get(0);

        for (int i = 1; i < vehicles.size(); i++) {

            if (vehicles.get(i).tripCost() < best.tripCost()) {
                best = vehicles.get(i);
            }
        }
        return best;
    }
}

    public class Main {
        public static void main(String[] args) {


            Scanner sc = new Scanner(System.in);
            FleetManager manager1 = new FleetManager();

            //Hard coded objects
            Car c1 = new Car("C101", "Driver1", 300, 20);
            c1.updateLocation("Location 1");

            Car c2 = new Car("C102", "Driver2", 450, 25);
            c2.updateLocation("Location 2");

            Bike b1 = new Bike("B201", "Driver3", 450, 30);
            b1.updateLocation("Location 3");

            Bike b2 = new Bike("B202", "Driver4", 150, 3);
            b2.updateLocation("Location 4");

            Truck t1 = new Truck("T301", "Driver5", 500, 120, 1000);
            t1.updateLocation("Location 5");

            Truck t2 = new Truck("T302", "Driver6", 650, 160, 1500);
            t2.updateLocation("Location 6");

            ElectricCar EV1 = new ElectricCar("E401", "Driver7", 350, 50);
            EV1.updateLocation("Location 7");

            HybridVehicle hybrid1 = new HybridVehicle("H501", "Driver8", 400, 15, 20);
            hybrid1.updateLocation("Location 8");

            //adding the vehicles to the fleet, and store each obj in the memeory
            manager1.addVehicle(c1);
            manager1.addVehicle(c2);
            manager1.addVehicle(b1);
            manager1.addVehicle(b2);
            manager1.addVehicle(t1);
            manager1.addVehicle(t2);
            manager1.addVehicle(EV1);
            manager1.addVehicle(hybrid1);
            System.out.println("Default Vehicles Loaded");

            //menu driven system using if else
            int choice;
            //using do while, which garuntees the menu to run atleast onces
            do {
                System.out.println(" ");
                System.out.println("  MENU  ");
                System.out.println("1. Add Car ");
                System.out.println("2. Add Bike ");
                System.out.println("3. Add Truck ");
                System.out.println("4. add ElectricCar ");
                System.out.println("5. Add HybridVehicle ");
                System.out.println("6. update location ");
                System.out.println("7. View Vehicle Location ");
                System.out.println("8. Generate Report ");
                System.out.println("9. EXIT");
                System.out.println(" ");

                System.out.print ("Enter your choice: ");


                //to handle exception of String instead of a number and negative values
                //previnting crash if user enter string or invalid output
                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid choice, please enter a valid number");
                    sc.nextLine(); //to clear buffer
                    choice = -1;
                    continue;
                }

                // = Car
                if (choice == 1) {
                    System.out.print("Enter ID : ");
                    String id = sc.next();

                    System.out.print("Enter Driver name : ");
                    String name = sc.next();

                    System.out.print("Enter Distance (km): ");
                    double dist = 0;

                    //error handling for if distance < 0
                    try {
                        dist = sc.nextDouble();
                        if (dist < 0) {
                            System.out.print("Distance Cannot be Negative");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        sc.nextLine();
                        continue;
                    }
                    System.out.print("Enter Fuel (litre): ");
                    double fuel = sc.nextDouble();

                    System.out.print("Enter Location");
                    String location = sc.next();

                    //new objected of Car class created
                        Car car1 = new Car(id, name, dist, fuel);
                    //location updated
                    car1.updateLocation(location);
                    //add to fleet
                    manager1.addVehicle(car1);
                    System.out.println("Vehicle added successfully");

                    // == bike
                } else if (choice == 2) {
                    System.out.print("Enter ID : ");
                    String id = sc.next();

                    System.out.print("Enter Driver name : ");
                    String name = sc.next();

                    //error handling for if distance < 0
                    System.out.println("Enter Distance (km) :");
                    double dist = 0;
                    try {
                        dist = sc.nextDouble();
                        if (dist < 0) {
                            System.out.println("Distance Cannot be Negative");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        sc.nextLine();
                        continue;
                    }
                    System.out.print("Enter Fuel (litres) : ");
                    double fuel = sc.nextDouble();

                    System.out.print("Enter Location : ");
                    String location = sc.next();

                    //new objected of Bike class created
                        Bike bike1 = new Bike(id, name, dist, fuel);
                    bike1.updateLocation(location);
                    //add to fleet
                    manager1.addVehicle(bike1);
                    System.out.println("Vehicle added successfully");


                    //Truck
                } else if (choice == 3) {
                    System.out.print("Enter ID : ");
                    String id = sc.next();

                    System.out.print("Enter Driver : ");
                    String name = sc.next();

                    //error handling for if distance < 0
                    System.out.print("Enter Distance (km) : ");
                    double dist = 0;
                    try {
                        dist = sc.nextDouble();
                        if (dist < 0) {
                            System.out.println("Distance Cannot be Negative");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        sc.nextLine();
                        continue;
                    }

                    System.out.print("Enter Fuel (litre) : ");
                    double fuel = sc.nextDouble();

                    System.out.print("Cargo Weight (kg) : ");
                    double cargoWeight = sc.nextDouble();

                    System.out.print("Enter Location : ");
                    String location = sc.next();

                    //new objected of Truck Class created
                        Truck truck1 = new Truck(id, name, dist, fuel, cargoWeight);
                    truck1.updateLocation(location);
                    //add to fleet
                    manager1.addVehicle(truck1);
                    System.out.println("Vehicle added successfully");

                    //Electric Cars
                } else if (choice == 4) {

                    System.out.print("Enter ID : ");
                    String id = sc.next();

                    System.out.print("Enter Driver name : ");
                    String name = sc.next();

                    //error handling for if distance < 0
                    System.out.print("Enter Distance : ");
                    double dist = 0;
                    try {
                        dist = sc.nextDouble();
                        if (dist < 0) {
                            System.out.println("Distance Cannot be Negative");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        sc.nextLine();
                        continue;
                    }
                    System.out.print("Battery Used : ");
                    double battery = sc.nextDouble();

                    System.out.print("Enter Location  : ");
                    String location = sc.next();

                    //new objected of Electric Car class created
                        ElectricCar eCar1 = new ElectricCar(id, name, dist, battery);
                    eCar1.updateLocation(location);
                    //add to fleet
                    manager1.addVehicle(eCar1);
                    System.out.println("Vehicle added successfully");

                    //Hybrid Car
                } else if (choice == 5) {
                    System.out.print("Enter ID : ");
                    String id = sc.next();

                    System.out.print("Enter Driver : ");
                    String name = sc.next();

                    //error handling for if distance < 0
                    System.out.print("Enter Distance : ");
                    double dist = sc.nextDouble();

                    System.out.print("Enter Fuel : ");
                    double fuel = sc.nextDouble();

                    System.out.print("Battery Used : ");
                    double battery = sc.nextDouble();

                    System.out.print("Enter Location : ");
                    String location = sc.next();

                    //new objected of Hybrid class created
                        HybridVehicle hybridVehicle1 = new HybridVehicle(id, name, dist, fuel, battery);
                    hybridVehicle1.updateLocation(location);
                    //add to fleet
                    manager1.addVehicle(hybridVehicle1);
                    System.out.println("Vehicle added successfully");


                }
                //Update Location
                else if (choice == 6) {
                    System.out.print("Enter Vehicle ID : ");
                    String id = sc.next();

                    Vehicle tempVehicle = manager1.findVehicle(id);

                    if (tempVehicle == null) {
                        System.out.println("Vehicle Not Found");
                    } else {
                        System.out.println("Enter new location");
                        String location = sc.next();

                        //objects are passed by reference so the chnage is reflected everywhere
                        //directly modifies object inside the array list
                        tempVehicle.updateLocation(location);
                        System.out.println("Location Updated");
                    }
                }
                //view location
                else if (choice == 7) {
                    System.out.print ("Enter vehicle ID  : ");
                    String id = sc.next();

                    Vehicle tempVehicle = manager1.findVehicle(id);

                    if (tempVehicle == null) {
                        System.out.println("Vehicle Not Found");
                    } else {
                        System.out.println("Vehicle is at " + tempVehicle.location);
                    }
                } else if (choice == 8) {

                    //method to display add the listed vehicles, caluclate cost, carbon and find best vehicle
                    manager1.generateReport();
                }

            } while (choice != 9); // loop conditin to end

            System.out.println("END   ");
        }
    }
