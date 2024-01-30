package mod2_1;

public class Task1 {
    public static class Television{
        private int channel;
        public Television() {
            this.channel = 0;
        }
        public int getChannel(){
            return channel;
        }
        public void setChannel(int num){
            this.channel = num;
        }
    }
    public static class TelevisionViewer{
        private int stamina;
        private int day;
        private int maxStamina;
        public TelevisionViewer(){
            this.stamina = 3;
            this.maxStamina = 3;
            this.day = 1;
        }
        public void bedTime(){
            switch(this.maxStamina){
                case(3), (6):
                    maxStamina = 4;
                    break;
                case(4):
                    maxStamina = 6;
                    break;
            }
            System.out.println("Falling asleep");
            this.stamina = this.maxStamina;
            this.day++;
            if (this.day <= 10) {
                System.out.printf("Woke up, day %d\n", this.day);
            }
        }
        public void switchChannel(Television tv){
            int channel = tv.getChannel();
            channel++;
            if (channel > 10) channel = 1;  // 10++ = 1
            tv.setChannel(channel);
            System.out.printf("Watching channel %d\n", channel);
        }
        public void watchTV(Television tv){
            while (this.stamina >= 1){
                switchChannel(tv);
                this.stamina--;
            }
            if (this.stamina == 0){
                bedTime();
            }
        }
        public void task(Television tv){
            while(this.day <= 10){
                watchTV(tv);
            }
        }

    }
    public static void main(String[] args) {
        Television telly = new Television();
        TelevisionViewer watcher = new TelevisionViewer();
        watcher.task(telly);
    }
}