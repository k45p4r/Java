package mod5_2;

import java.util.ArrayList;

public class Customer{


    Theater theater;
    ArrayList<Integer> reserved = new ArrayList<>();
    public Customer(Theater t) {
        theater = t;
    }
    public void reserveSeat(int seat) {
        Boolean bool = theater.reserveSeat(seat);
        if (bool) {
            addSeat(seat);
        }
    }
    public void cancelSeat(int seat) {
        Boolean bool = theater.cancelReservation(seat);
        if (bool) {
            removeSeat(seat);
        }
    }
    public void addSeat(int seat) {
        reserved.add(seat);
    }
    public void removeSeat(int seat) {
        reserved.remove((Integer) seat);
    }
}
