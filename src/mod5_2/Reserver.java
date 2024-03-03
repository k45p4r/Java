package mod5_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Reserver extends Thread{
    ArrayList<Customer> customers = new ArrayList<>();
    Random rand;
    int n;
    public Reserver(int n, Customer ... a){
        customers.addAll(Arrays.asList(a));
        rand = new Random();
        this.n = n;
    }
    private void Reserve(int n){
        Customer c = customers.get(rand.nextInt(customers.size()));
        c.reserveSeat(n);
    }
    private void Cancel(int n){
        Customer c = customers.get(rand.nextInt(customers.size()));
        c.cancelSeat(n);
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            int num = rand.nextInt(n) + 1;
            Reserve(num);
        }
        for (int i = 0; i < 5; i++) {
            int num = rand.nextInt(n) + 1;
            Cancel(num);
        }
        for (int i = 0; i < 5; i++) {
            int num = rand.nextInt(n) + 1;
            Reserve(num);
        }
        System.out.println("Thread " + this + " done.");
    }
}
