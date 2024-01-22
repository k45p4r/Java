package mod1_2;

import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give Fahrenheits: ");
        float fahr = Float.parseFloat(scanner.nextLine());
        float cels = ((fahr-32)*5/9);
        System.out.printf(fahr + " Fahrenheits is " +  "%.1f Celsius.", cels);
        scanner.close();
    }
}
