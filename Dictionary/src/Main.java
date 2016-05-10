/**
 * Created by saimkaan on 09/05/16.
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
        map.put("buch", "book");
        map.put("haus", "house");



        Scanner keyboard = new Scanner(System.in);
        String input;

        System.out.println("Wort in die Konsole eingeben.\n\n" +
                "Zum beenden exit eingeben.\n--------------------------------");


        do {

            input = keyboard.nextLine();
            input = input.toLowerCase();
            input = input.replace(" ","");
            if ( map.containsKey(input) ) {
                String uebersetzung = map.get(input);
                System.out.println("Übersetzung: \n" +
                        uebersetzung + "\n--------------------------------\n");
            }
            else {
                System.err.println("Wort wurde nicht im dictionary gefunden!!!");
            }
        }while (! input.equalsIgnoreCase("exit") );
    }
}