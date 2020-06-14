package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        boolean spelen = true;
        String stoppen = "q";
        String goedeLetters = "abcdefq";

        char a = (char) (r.nextInt(6) + 'a');
        char b = (char) (r.nextInt(6) + 'a');
        char c = (char) (r.nextInt(6) + 'a');
        char d = (char) (r.nextInt(6) + 'a');

//        System.out.println("het antwoord is " + a + b + c + d); // Goede antwoord
        System.out.println("");
        System.out.println("*********************");
        System.out.println("Welkom bij Mastermind");
        System.out.println("*********************");
        System.out.println("");

        while (spelen) {

            int aantalgoed = 0;
            int aantalgoedFout = 0;

            System.out.println("Voer 4 letters (a t/m f) om te raden, of q om te stoppen ");
            String invoer = scanner.nextLine();
            String invoerLowerCase = invoer.toLowerCase();

            if (invoerLowerCase.equals(stoppen)) {
                spelen = false;
                System.out.println("Bedankt voor het spelen");
                break;
            }

            if ((invoerLowerCase.length() == 4) && (invoerLowerCase.matches("[" + goedeLetters + "]+"))) {

//              System.out.println(invoerLowerCase); print check van invoer
                char a1 = invoerLowerCase.charAt(0);
                char b1 = invoerLowerCase.charAt(1);
                char c1 = invoerLowerCase.charAt(2);
                char d1 = invoerLowerCase.charAt(3);

                if (a == a1 && b == b1 && c == c1 && d == d1) {
                    System.out.println("correct, je hebt gewonnen!");
                    aantalgoed = 4;
                    spelen = false;
                } else {
                    if (a == a1) {
                        aantalgoed++;
                    } else if ((a == b1) || (a == c1) || (a == d1)) {
                        aantalgoedFout++;
                    }
                    if (b == b1) {
                        aantalgoed++;
                    } else if ((b == a1) || (b == c1) || (b == d1)) {
                        aantalgoedFout++;
                    }
                    if (c == c1) {
                        aantalgoed++;
                    } else if ((c == a1) || (c == b1) || (c == d1)) {
                        aantalgoedFout++;
                    }
                    if (d == d1) {
                        aantalgoed++;
                    } else if ((d == a1) || (d == b1) || (d == c1)) {
                        aantalgoedFout++;
                    }
                }
                System.out.println("Je hebt er " + aantalgoed + " op de goede plek");
                System.out.println("Je hebt er " + aantalgoedFout + " goed, maar op de verkeerd plek");
                System.out.println("");
            }
            else {
                System.out.println("Invoer bevat ongeldige letters of aantal ");
                System.out.println("");
            }
        }
    }
}