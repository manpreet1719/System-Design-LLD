public class Vehicle {
    VehicleStrategy vehicleStrategy;
    Vehicle(VehicleStrategy vehicleStrategy){
        this.vehicleStrategy = vehicleStrategy;
    }
    public void drive(){
        this.vehicleStrategy.drive();
    }
}
