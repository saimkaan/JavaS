/**
 * Created by saim on 09/05/16.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("auto", "car");
        map.put("baum", "tree");
        map.put("wasser", "water");
        map.put("fisch", "fish");


        Scanner keyboard = new Scanner(System.in);
        String input = "exit";

        do {
            System.out.println("\n Wort in die Konsole eingeben.\n Zum beenden exit eingeben. ");

            input = keyboard.nextLine();
            input = input.toLowerCase();
            input = input.replace(" ","");
            if ( map.containsKey(input) ) {
                String uebersetzung = map.get(input);
                System.out.println("Übersetzung: \n" + uebersetzung);
            }
            else {
                System.err.println("Wort wurde nicht im dictionary gefunden!!!");
            }
        }while (! input.equalsIgnoreCase("exit") );
    }
}