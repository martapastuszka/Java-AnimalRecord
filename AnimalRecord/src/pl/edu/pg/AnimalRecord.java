package pl.edu.pg;

import pl.edu.pg.model.*;
import java.util.*;

public class AnimalRecord {
    private int ownersCount;
    private List<Owner> owners = new ArrayList<>();

    public void start() {
        System.out.println("Welcome in the record of animals and their owners");

        for (; ; ) {
            showMenu();
            int option = pickOption();
            switch (option) {
                case 0: //exit the program
                    System.out.println("Thanks, bye bye!");
                    System.exit(0);
                case 1: // add new animal
                    owners.add(createOwner());
                    break;
                case 2: // list owners
                    listOwners();
                    break;
//                case 3:
//                    System.out.println("Wybrano opcje 3: Sort owners by last name ascending");
//                    break;
//                case 4:
//                    System.out.println("Wybrano opcje 4: Sort owners by last name descending");
//                    break;
//                case 5:
//                    System.out.println("Wybrano opcje 5: Sort owners by numbers of animals they have, ascending");
//                    break;
//                case 6:
//                    System.out.println("Wybrano opcje 6: Sort owners by numbers of animals they have, descending");
                case 7: //add animal
                    createAnimal();
                    break;
                case 8: // list animals
                    break;
//                case 9:
//                    System.out.println("Wybrano opcje 9: Find animal");
//                    break;
                default:
                    System.out.println("Pick a number from the list");
                    break;
            }
        }
    }

    private void createAnimal() {
        Scanner scanner = new Scanner(System.in);
        // w ramach tej operacji konieczne będzie wybranie właściciela, do którego należy dane zwierze
        for (Owner owner : owners) {
            owner.info();
        }
        System.out.println("To add animal choose owner id first: ");
        int ownerId = scanner.nextInt();
        System.out.println("Choose animal: cat (1), dog (2), turtle (3)");
        int animalChosen = scanner.nextInt();
//        System.out.println("Name: ");
//        String name = scanner.next();
//        System.out.println("Gender: male (m), female (f): ");
//        String gender = scanner.next();
//        System.out.println("Age: ");
//        int age = scanner.nextInt();

        switch (animalChosen) {
            case 1: // cat
                //uzywam metody get na ownersie w ownersach zeby dostac sie do owner I
//                Owner y = owners.get(ownerId);
//                int ownerAge = y.getAge();
                if (owners.get(ownerId).getAge() >= 10) {
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println("Gender: male (m), female (f): ");
                    String gender = scanner.next();
                    System.out.println("Age: ");
                    int age = scanner.nextInt();
                    System.out.println("Breed: ");
                    String breed = scanner.next();
                    owners.get(ownerId).setAnimals(new Cat(name, gender, age, ownerId, breed));
                } else {
                    System.out.println("Error, owner has to be 10 years old or older!");
                }
                break;
            case 2: // dog
                if (owners.get(ownerId).getAge() >= 15) {
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println("Gender: male (m), female (f): ");
                    String gender = scanner.next();
                    System.out.println("Age: ");
                    int age = scanner.nextInt();
                    System.out.println("Breed: ");
                    String breed = scanner.next();
                    owners.get(ownerId).setAnimals(new Dog(name, gender, age, ownerId, breed));
                } else {
                    System.out.println("Error, owner has to be 15 years old or older!");
                }
                break;
            case 3: // turtle
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Gender: male (m), female (f): ");
                String gender = scanner.next();
                System.out.println("Age: ");
                int age = scanner.nextInt();

//                - żółwie lądowe: wiek właściciela  >= 20
//                - żółwie błotne: wiek właściciela  >= 25
//                - żółwie morskie: wiek właściciela  >= 35 oraz dodatkowo nazwisko musi zaczynać się od litery M

                int ownersAge = owners.get(ownerId).getAge();
                char ownersLastNameFirstLetter = owners.get(ownerId).getLastName().charAt(0);

                System.out.println("Turtle type: ladowy (1), morski (2), blotny (3): ");
                int typePicked = scanner.nextInt();
                TurtleType turtleType;
                if(typePicked == 1){
                    turtleType = TurtleType.LADOWY;
                }else if(typePicked == 2){
                    turtleType = TurtleType.MORSKI;
                }else{
                    turtleType = TurtleType.BLOTNY;
                }
                if(turtleType == TurtleType.LADOWY && ownersAge >= 20){
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                }else if(turtleType == TurtleType.BLOTNY && ownersAge >= 25){
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                }else if(turtleType == TurtleType.MORSKI && ownersAge >=35 && ownersLastNameFirstLetter == 'M'){
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                }else{
                    System.out.println("Error: owner too young!");
                }
                break;
        }
    }

    private void listOwners() {
        System.out.println("-------------- List of Animal Owners --------------");
        if (owners.isEmpty()) {
            System.out.println("No owners added.");
        }
        for (Owner owner : owners) {
            owner.info();
        }
    }

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

    public int pickOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // pozniej przeniesc menu jako osobna klase - zarzadzenie menu
    public void showMenu() {
        System.out.println("------------------- Menu --------------------------");
        System.out.println("What do you want to do? Pick a number:");
        System.out.println("1. Add animal owner");
        System.out.println("2. List owners");
        if (ownersCount > 0) {
            System.out.println("7. Add animal");
        }
        if (ownersCount > 0) {
            System.out.println("8. List animals");
        }
//        System.out.println("3. Sort owners by last name ascending");
//        System.out.println("4. Sort owners by last name descending");
//        System.out.println("5. Sort owners by numbers of animals they have ascending");
//        System.out.println("6. Sort owners by numbers of animals they have descending");
//        System.out.println("9. Find animal");
        System.out.println("0. Exit program");
    }
}




