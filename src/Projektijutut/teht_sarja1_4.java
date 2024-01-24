package Projektijutut;
import java.util.LinkedList;
import java.util.Scanner;
public class teht_sarja1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Asiakas> asiakaslist = new LinkedList<>();
        String state = "";
        System.out.println("Tervetuloa!");
        while (!state.equals("3")) {
            System.out.println("""
                    1) Lisää uusi asiakas.
                    2) Poista asiakas.
                    3) Poistu ohjelmasta.
                    """);
            state = scanner.nextLine();
            if (state.equals("1")){
                System.out.println("Anna nimi: ");
                String name = scanner.nextLine();
                Asiakas uusi = new Asiakas(name);
                asiakaslist.addLast(uusi);
            } else if (state.equals("2")) {
                if (asiakaslist.isEmpty()){
                    System.out.println("Asiakkaita ei ole");
                }else {
                    System.out.println("Poistit asiakkaan");
                    asiakaslist.getFirst().printData();
                    asiakaslist.removeFirst();
                }
            }
        }
        System.out.println("Poistutaan ohjelmasta.");
    }
}
