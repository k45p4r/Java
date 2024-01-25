package Projektijutut;
import java.util.Arrays;
import java.util.Random;

public class teht_sarja2_3 {
    static Random rand = new Random();
    public static void main(String[] args) {
        int[] agelist = {18, 19, 19, 19, 20, 20, 21, 22, 22, 22, 22, 22, 23, 24, 25, 26, 31, 35, 42};
        int[] newlist = new int[1000];
        for (int i = 0; i < 1000; i++) {
            int rand_i = rand.nextInt(agelist.length);
            int randage = agelist[rand_i];
            newlist[i] = randage;
        }
        System.out.println(Arrays.toString(newlist));
    }
}
