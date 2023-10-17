public class Main {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle(new SportVehicle());
        vehicle1.drive();
        Vehicle vehicle2 = new Vehicle(new NormalVehicle());
        vehicle2.drive();
    }
}