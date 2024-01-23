package mod1_3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give binary: ");
        String input = scanner.nextLine();
        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            int n = input.length() - 1 - i;
            int num = Integer.parseInt(String.valueOf(input.charAt(n)));
            if (num == 1 || num == 0){
                num = (int) (num * Math.pow(2, i));
                sum += num;
            } else {
                sum = -1;
                break;
            }
        }
        if (sum != -1) {
            System.out.println("Binary in decimal = " + sum);
        } else {
            System.out.println("Input is not binary value.");
        }
        scanner.close();
    }
}