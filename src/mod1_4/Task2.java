package mod1_4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers in the array?");
        int size = scanner.nextInt();
        int[] numarray = new int[size];

        for (int i = 0; i < size; i++) {
            String suffix = switch (i) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };
            System.out.printf("Enter the %1d%2s integer: ", i+1, suffix);
            int num = scanner.nextInt();
            numarray[i] = num;
        }

        int biggest = 0;
        int i_left = 0;
        int i_right = 0;
        for (int i = 0; i < numarray.length; i++) {
            int sum = 0;
            for (int j = i; j < numarray.length; j++) {
                sum += numarray[j];
                if (sum > biggest){
                    i_left = i;
                    i_right = j;
                    biggest = sum;
                }
            }
        }
        System.out.printf("Biggest subarray was %d at (%d -> %d).", biggest, i_left, i_right);

    }
}
