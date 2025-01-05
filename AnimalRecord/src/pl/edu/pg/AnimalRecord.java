package pl.edu.pg;

import pl.edu.pg.model.*;

public class AnimalRecord {
    public void start() {
        System.out.println("Witamy w systemie ewidencji zwierzat i ich wlascicieli.");
        showMenu();

        System.out.println("Dziękujemy, do zobaczenia!");
    }

    //Wyswietlanie Menu
    // menu mogłab
    private void showMenu() {
        System.out.println("------------------- Menu -------------------");
        System.out.println("Co chcesz zrobić? Wciśnij odpowiedni przycisk:");
        System.out.println("1. Dodaj właściciela");
        System.out.println("2. Lista właścicieli");
        System.out.println("3. Sortuj właścicieli");
        System.out.println("4. Dodaj zwierzę");
        System.out.println("5. Lista zwierząt");
        System.out.println("6. Sortuj zwierzęta");
        System.out.println("0. Zakończ program");
    }

}


