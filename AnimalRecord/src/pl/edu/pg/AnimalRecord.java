package pl.edu.pg;

import pl.edu.pg.model.AnimalOwner;
import pl.edu.pg.model.Owner;

import java.sql.SQLOutput;
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
//                    newCat.addAnimal();
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

    private void listOwners(){
        System.out.println("-------------- List of Animal Owners --------------");
        if (owners.isEmpty()) {
            System.out.println("No owners added.");
        }
        for (Owner owner : owners) {
            owner.info();
        }
    }

    public Owner createOwner(){
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
    public void showMenu(){
        System.out.println("------------------- Menu --------------------------");
        System.out.println("What do you want to do? Pick a number:");
        System.out.println("1. Add animal owner");
        System.out.println("2. List owners");
        if(ownersCount > 0){
            System.out.println("7. Add animal");
        }
        if(ownersCount > 0){
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


