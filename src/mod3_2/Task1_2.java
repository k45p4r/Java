package mod3_2;

public class Task1_2 {
    static abstract class AbstractVehicle implements Vehicle{
        protected String name;
        protected boolean isStarted;
        protected float fuelValue = 0;
        public void start() {
            if (!isStarted) {
                isStarted = true;
            } else {
                System.out.println(name + " is already started!");
            }
        }
        public void stop(){
            if (isStarted) {
                isStarted = false;
            } else {
                System.out.println(name + " is already stopped!");
            }
        }
    }
    static interface Vehicle {
        public void start();
        public void stop();
        public String getInfo();
    }
    static class Car extends AbstractVehicle{
        public Car(String name){
            this.name = name;
            isStarted = false;
        }

        @Override
        public String getInfo() {
            String string = name + " is a Car and it is ";
            if (isStarted)
            {string += "started.";}
            else{string += "stopped.";}
            return string;
        }
    }
    static class Bus extends AbstractVehicle{
        private int passengerNum = 0;
        public Bus(String name){
            this.name = name;
            isStarted = false;
        }
        @Override
        public String getInfo() {
            String string = name + " is a Bus and it is ";
            if (isStarted)
            {string += "started.";}
            else{string += "stopped.";}
            string += "\n" + name + " has " + passengerNum + " passengers.";
            return string;
        }
    }
    static class Motorcycle extends AbstractVehicle{
        public Motorcycle(String name){
            this.name = name;
            isStarted = false;
            fuelValue += 100;
        }
        @Override
        public String getInfo() {
            String string = name + " is a motorcycle, and it is ";
            if (isStarted){
                string += "started";
            }else string += "stopped";
            string += "\n" + name + " has " + fuelValue + " fuel!";
            return string;
        }
    }

    public static void main(String[] args) { // VehicleDemo
        Car auto = new Car("Bora");
        auto.start(); auto.stop();System.out.println(auto.getInfo());
        Bus bussi = new Bus("Linkku");
        bussi.start(); System.out.println(bussi.getInfo());bussi.stop();
        Motorcycle moto = new Motorcycle("Mopo");
        System.out.println(moto.getInfo()); moto.start(); moto.stop();
    }

}