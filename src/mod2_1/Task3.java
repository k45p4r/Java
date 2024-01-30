package mod2_1;

public class Task3{
    public static class Coffeemaker{
        private String coffeetype;
        private int amount;
        private boolean power;

        public void switchPower(){
            this.power = !this.power;
        }
        public boolean getPower(){
            return this.power;
        }

        public void setAmount(int amount){
            if (this.getPower()){
                this.amount = amount;
                if (this.amount > 80) {
                    this.amount = 80;
                }else if(this.amount < 10){
                    this.amount = 10;
                }
            }else System.out.println("Power off");
        }
        public int getAmount(){
            return this.amount;
        }
        public void setCoffeetype(String type){
            if (this.getPower()){
                type = type.toLowerCase();
                if (type.equals("normal") || (type.equals("espresso"))){
                    this.coffeetype = type;
                }
            }else System.out.println("Power off");
        }
        public String getCoffeetype(){
            return this.coffeetype;
        }

    }
}