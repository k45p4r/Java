package Projektijutut;

public class teht_sarja3_3{
    private static Kello instance = null;
    private int time;
    private Kello(){
    }
    public static Kello getInstance(){
        if (instance == null){
            instance = new Kello();
        }
        return instance;
    }
    public int getTime(){
        return time;
    }
    public void setTime(int num){
        time = num;
    }

    public static void main(String[] args) {
        Kello kello = Kello.getInstance();
        System.out.println(kello.getTime());
        kello.setTime(10);
        System.out.println(kello.getTime());
    }
}
