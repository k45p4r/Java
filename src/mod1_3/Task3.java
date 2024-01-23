package mod1_3;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Give first number: ");
        int num2 = scanner.nextInt();
        for (int i = num1; i <= num2; i++){
            boolean isprime = true;
            if (i>1) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isprime = false;
                        break;
                    }
                }
                if (isprime) {
                    System.out.println(i + " is prime.");
                }
            }
        }
    }
}