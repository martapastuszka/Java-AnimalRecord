package pl.edu.pg.model;

import pl.edu.pg.AnimalRecord;

import java.util.Scanner;

public class ManageOwners extends AnimalRecord {

    //- możliwość dodania nowego właściciela
    public Owner createOwner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = scanner.next();
        System.out.println("Last name: ");
        String lastName = scanner.next();
        System.out.println("Gender (male/female/inter): ");
        String gender = scanner.next();
        System.out.println("Age: ");
        int age = scanner.nextInt();

        System.out.println("Success! New animal owner added.");

        return new Owner(ownersCount++, firstName, lastName, gender, age);
    }

    public void listOwners() {
        System.out.println("-------------- List of Animal Owners --------------");
        if (owners.isEmpty()) {
            System.out.println("No owners added.");
        }
        for (Owner owner : owners) {
            owner.info(printUpperCase);
            if(! owner.getAnimals().isEmpty()) {
                System.out.print("   Animals owned: ");
                for (Animal animal : owner.getAnimals()){
                    System.out.print(animal.getName() + " ");
                }
                System.out.println();
            }
        }
    }
}
