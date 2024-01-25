package mod1_4;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] firstNames = {"Emma", "Mikko", "Sofia", "Tuomas", "Aada", "Aleksi", "Iida", "Eetu", "Ella", "Ville"};
        String[] lastNames = {"Virtanen", "Mäkinen", "Järvinen", "Koskinen", "Nieminen", "Hakala", "Salonen", "Rantanen", "Lahtinen", "Lehto"};

        System.out.print("How many names would you like to generate? ");
        int namenum = Integer.parseInt("0" + scanner.nextLine());//   0+ to avoid empty string error

        for (int i = 0; i < namenum; i++) {
            int firstrand = rand.nextInt(firstNames.length);
            int secondrand = rand.nextInt(lastNames.length);
            String fullname = firstNames[firstrand] + " " + lastNames[secondrand];
            System.out.println(fullname);
        }
    }
}