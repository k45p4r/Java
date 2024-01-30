package mod2_1;

public class Task2 {
    public class Car {
        private float speed;
        private float gasolineLevel;
        private String typeName;
        private float topSpeed;
        private float tankCap;
        public Car(String typeName) {
            speed = 0; gasolineLevel = 0;
            this.typeName = typeName;
        }
        public Car(float topSpeed, float tankCap){
            this.topSpeed = topSpeed;
            this.tankCap = tankCap;
        }
        public void accelerate() {
            if (gasolineLevel > 0)
                speed += 1;
            else
                speed = 0;
            if (speed > topSpeed){
                speed = topSpeed;
            }
        }
        void decelerate() {
            if (gasolineLevel > 0) {
                speed -= 1;
            } else
                speed = 0;
        }
        float getSpeed() {
            return speed;
        }
        String getTypeName() {
            return typeName;
        }
        void fillTank() {
            gasolineLevel = tankCap;
        }
        float getGasolineLevel() {
            return gasolineLevel;
        }


        private int targetSpeed;
        private boolean cruiseControl = false;
        void setTargetSpeed(int target){
            this.targetSpeed = target;
        }
        int getTargetSpeeed(){
            return this.targetSpeed;
        }
        void toggleCruiseControl(){
            cruiseControl = !cruiseControl;
            if (cruiseControl){
                if (targetSpeed<=topSpeed && targetSpeed>0){

                    while(targetSpeed != speed){
                        if (targetSpeed - speed > 0){
                            accelerate();
                        } else if (targetSpeed - speed < 0) {
                            decelerate();
                        }
                    }

                } else if (targetSpeed>topSpeed) {
                    System.out.println("Target speed too high");
                } else if (targetSpeed<0){
                    System.out.println("Target speed less than 0");
                }
            }
            if (!cruiseControl){
                System.out.println("Cruise control turned off");
            }
        }

    }
    public static void main(String[] args) {

    }
}
