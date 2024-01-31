package mod3_1;
public class Task1_2 {
    static class Car {
        private double speed;
        private double gasolineLevel;
        private float accelSpeed = 1.0F;
        private float brakeSpeed = 1.0F;
        private float fConsumption = 1.0F;
        private final double topSpeed;
        private final double tankCap;

        public Car(double topSpeed, double tankCap) {
            speed = 0;
            gasolineLevel = 0;
            this.topSpeed = topSpeed;
            this.tankCap = tankCap;
        }
        public void accelerate() {
            if (gasolineLevel > 0)
                speed += 1;
            else
                speed = 0;
            if (speed > topSpeed) {
                speed = topSpeed;
            }
        }

        void decrease() {
            if (gasolineLevel > 0) {
                speed -= 1;
            } else
                speed = 0;
        }

        double getSpeed() {return speed;}
        void fillTank() {gasolineLevel = tankCap;}
        double getGasolineLevel() {return gasolineLevel;}

        private int targetSpeed;
        private boolean cruiseControl = false;

        void setTargetSpeed(int target) {this.targetSpeed = target;}

        int getTargetSpeed() {return this.targetSpeed;}

        void toggleCruiseControl() {
            cruiseControl = !cruiseControl;
            if (cruiseControl) {
                if (targetSpeed <= topSpeed && targetSpeed > 0) {

                    while (targetSpeed != speed) {
                        if (targetSpeed - speed > 0) {
                            accelerate();
                        } else if (targetSpeed - speed < 0) {
                            decrease();
                        }
                    }

                } else if (targetSpeed > topSpeed) {
                    System.out.println("Target speed too high.");
                } else if (targetSpeed < 0) {
                    System.out.println("Target speed less than 0.");
                }
            }
            if (!cruiseControl) {
                System.out.println("Cruise control turned off.");
            }
        }
    }
    static class Supercar extends Car{
        public Supercar(float topSpeed, float tankCap) {
            super(topSpeed*1.2, tankCap*1.2);
            super.fConsumption = 1.4F;
            super.accelSpeed = 1.2F;
            super.brakeSpeed = 1.2F;
        }
    }
    static class Bus extends Car{
        private final int maxPassengers = 66;
        private int numPassengers = 0;

        public Bus(double topSpeed, double tankCap) {
            super(topSpeed, tankCap);
        }
        public int passengerEnter(int num){
            numPassengers += num;
            if (numPassengers>maxPassengers){
                num = numPassengers-maxPassengers;
                numPassengers = maxPassengers;
                return num;
            }return 0;
        }
        public void passengerExit(int num){
            numPassengers -= num;
            if (numPassengers<0)numPassengers=0;
        }
        public int getNumPassengers(){return numPassengers;}
        public int getMaxPassengers(){return maxPassengers;}
    }

    public static void main(String[] args) {
    }

}
