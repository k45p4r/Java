package mod5_2;

public class Main {
    public static void main(String[] args) {

        Theater teatteri = new Theater(50);
        Customer asiakas1 = new Customer(teatteri);
        Customer asiakas2 = new Customer(teatteri);
        Customer asiakas3 = new Customer(teatteri);
        Customer asiakas4 = new Customer(teatteri);
        Customer asiakas5 = new Customer(teatteri);


        Reserver r1 = new Reserver(33, asiakas1, asiakas2);
        Reserver r2 = new Reserver(40, asiakas3, asiakas4);
        Reserver r3 = new Reserver(33, asiakas5);


        r1.start();
        r2.start();
        r3.start();


        try {
            r1.join();
            r2.join();
            r3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All reservations and cancellations done.");


        teatteri.printSeats();

    }
}
