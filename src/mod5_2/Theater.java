package mod5_2;

import java.util.ArrayList;

public class Theater {

    private final ArrayList <Integer> reserved;
    private final int seatCount;
    public Theater(int n) {
        ArrayList<Integer> seats = new ArrayList<>();
        reserved = new ArrayList<>();
        seatCount = n;
        for (int i = 1; i <= n; i++) {
            seats.add(i);
        }
    }
    public synchronized Boolean reserveSeat(int seat) {
        if (seat > seatCount || seat < 1) {
            return false;
        } else if (reserved.contains(seat)) {
            return false;
        } else {
            reserved.add(seat);
            return true;
        }
    }
    public void printSeats() {
        for (int i = 1; i <= seatCount; i++) {
            String str;
            if (reserved.contains(i)) {
                str = "Seat " + i + " is reserved.";
            } else {
                str = "Seat " + i + " is free.";
            }
            System.out.printf("%-25s", str);
            if (i % 3 == 0) {
                System.out.println();
            }
        }
    }
    public synchronized Boolean cancelReservation(int seat) {
        if (seat > seatCount || seat < 1) {
            return false;
        } else if (!reserved.contains(seat)) {
            return false;
        } else {
            reserved.remove((Integer) seat);
            return true;
        }
    }

}
