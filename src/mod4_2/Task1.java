package mod4_2;

import java.util.ArrayList;

public class Task1 {
    static class Calculator {
        private final ArrayList<Integer> numarray = new ArrayList<>();

        public void addint(int a) {
            if (a < 0) {
                throw new IllegalArgumentException();
            }
            this.numarray.add(a);
        }

        public void reset() {
            this.numarray.clear();
        }

        public int sum() {
            int sum = 0;
            for (int i : this.numarray) {
                sum += i;
            }
            return sum;
        }

        public double average() {
            if (this.numarray.size() == 0) {
                throw new IllegalArgumentException();
            }
            return (double) this.sum() / this.numarray.size();
        }

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addint(5);
        calc.addint(10);
        calc.addint(15);
        System.out.println(calc.sum());
        System.out.println(calc.average());
        calc.reset();
        System.out.println(calc.sum());
        System.out.println(calc.average());
    }
}