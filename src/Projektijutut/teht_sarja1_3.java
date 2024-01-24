package Projektijutut;
public class teht_sarja1_3 {
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Asiakas jarmo = new Asiakas("Jarmo");
        Asiakas maiju = new Asiakas("Maiju");
        wait(100);

        jarmo.stop();
        wait(100);
        maiju.stop();

        jarmo.printData();
        maiju.printData();
    }
}

class Asiakas {
    private static int idcount = 0;
    private final int ID;
    final String name;
    final long aloitusaika;
    long lopetusaika;

    public Asiakas(String name) {
        this.ID = ++idcount;
        this.name = name;
        this.aloitusaika = System.currentTimeMillis();
    }

    public int getId() {
        return this.ID;
    }

    public void stop() {
        this.lopetusaika = System.currentTimeMillis();
    }

    public long time() {
        return (this.lopetusaika - this.aloitusaika);
    }

    public void printData() {
        System.out.printf("""
                Name: %s
                ID: %d
                Total time: %d ms

                """, this.name, this.getId(), this.time());
    }
}
