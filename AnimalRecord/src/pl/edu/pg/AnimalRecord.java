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
                    if (ownersCount >= 0 && ownersCount < 5) {
                        owners.add(createOwner());
                    } else {
                        System.out.println("Max number of owners (5) reached. You cannot add more");
                    }
                    break;

                case 2: // list owners
                    listOwners();
                    break;
                case 3:
                    owners.sort((p1,p2) -> { return p1.getLastName().compareTo(p2.getLastName()); }); // p1 < p2 = -1
                    listOwners();
                    break;
                case 4:
                    owners.sort((p1,p2) -> { return p2.getLastName().compareTo(p1.getLastName()); });
                    listOwners();
                    break;
                case 5:
                    owners.sort((p1,p2) -> { return p1.getAnimalsCount() - p2.getAnimalsCount(); });
                    listOwners();
                    break;
                case 6:
                    owners.sort((p1,p2) -> { return p2.getAnimalsCount() - p1.getAnimalsCount(); });
                    listOwners();
                    break;
                case 7: //add animal
                    createAnimal();
                    break;
                case 8: // list animals
                    listAnimals();
                    break;
                case 9:
                    findAnimalByName();
                    break;
                case 99:
                    findAnimalByAge();
                    break;
                case 999:
                    findAnimalByLastName();
                    break;
                case 11: // test_insertOwners
                    test_insertOwners();
                    break;
                case 12: // test_insertAnimals
                    test_insertAnimals();
                    break;
                default:
                    System.out.println("Pick a number from the list");
                    break;
            }
        }
    }

    //możliwość wyświetlenia listy wszystkich zwierząt (wszystkie dane) wraz z informacją kto jest właścicielem (imię i nazwisko)
    private void listAnimals() {
        for (Owner owner : owners) {
            for (Animal animal : owner.getAnimals()) {
                animal.info();
                System.out.println("Owner: " + owner.getFirstName() + " " + owner.getLastName());
                System.out.println("---------------------------------------------------");
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

        if(owners.get(ownerId).getAnimalsCount() >= 3) {
            System.out.println("You reached max number of animal per owner. You cannot add more animals to this owner.");
            return;
        }

        System.out.println("Choose animal: cat (1), dog (2), turtle (3)");
        int animalChosen = scanner.nextInt();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Gender: male (m), female (f): ");
        String gender = scanner.next();
        System.out.println("Age: ");
        int age = scanner.nextInt();

        switch (animalChosen) {
            case 1: // cat
                //uzywam metody get na ownersie w ownersach zeby dostac sie do owner I
//                Owner y = owners.get(ownerId);
//                int ownerAge = y.getAge();
                if (owners.get(ownerId).getAge() >= 10) {
                    System.out.println("Breed: ");
                    String breed = scanner.next();
                    owners.get(ownerId).setAnimals(new Cat(name, gender, age, ownerId, breed));
                } else {
                    System.out.println("Error, owner has to be 10 years old or older!");
                }
                break;
            case 2: // dog
                if (owners.get(ownerId).getAge() >= 15) {
                    System.out.println("Breed: ");
                    String breed = scanner.next();
                    owners.get(ownerId).setAnimals(new Dog(name, gender, age, ownerId, breed));
                } else {
                    System.out.println("Error, owner has to be 15 years old or older!");
                }
                break;
            case 3: // turtle
//                - żółwie lądowe: wiek właściciela  >= 20
//                - żółwie błotne: wiek właściciela  >= 25
//                - żółwie morskie: wiek właściciela  >= 35 oraz dodatkowo nazwisko musi zaczynać się od litery M

                int ownersAge = owners.get(ownerId).getAge();
                char ownersLastNameFirstLetter = owners.get(ownerId).getLastName().charAt(0);

                System.out.println("Turtle type: ladowy (1), morski (2), blotny (3): ");
                int typePicked = scanner.nextInt();
                TurtleType turtleType;
                if (typePicked == 1) {
                    turtleType = TurtleType.LADOWY;
                } else if (typePicked == 2) {
                    turtleType = TurtleType.MORSKI;
                } else {
                    turtleType = TurtleType.BLOTNY;
                }
                if (turtleType == TurtleType.LADOWY && ownersAge >= 20) {
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                } else if (turtleType == TurtleType.BLOTNY && ownersAge >= 25) {
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                } else if (turtleType == TurtleType.MORSKI && ownersAge >= 35 && ownersLastNameFirstLetter == 'M') {
                    owners.get(ownerId).setAnimals(new Turtle(name, gender, age, ownerId, turtleType));
                } else {
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
            if(! owner.getAnimals().isEmpty()) {
                System.out.print("   Animals owned: ");
                for (Animal animal : owner.getAnimals()){
                    System.out.print(animal.getName() + " ");
                }
                System.out.println();
            }
        }
    }

    //- możliwość dodania nowego właściciela
    // ZMIENIĆ WSZYSTKIE NA PRIVATE (OPRÓCZ START)
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

    private void findAnimalByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        for(Owner owner : owners){
            for(Animal animal : owner.getAnimals()){
                if(animal.getName().compareTo(name) == 0){
                    animal.info();
                }
            }
        }
    }

    private void findAnimalByAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Age: ");
        int age = scanner.nextInt();
        for(Owner owner : owners){
            for(Animal animal : owner.getAnimals()){
                if(animal.getAge() > age){
                    animal.info();
                }
            }
        }
    }

    private void findAnimalByLastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String name = scanner.next();
        for(Owner owner : owners){
            if(owner.getLastName().compareTo(name) == 0) {
                for(Animal animal : owner.getAnimals())
                    animal.info();
            }
        }
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

        if (ownersCount > 0) {
            System.out.println("2. List owners");
            System.out.println("3. Sort owners by last name ascending");
            System.out.println("4. Sort owners by last name descending");
            System.out.println("5. Sort owners by numbers of animals they have ascending");
            System.out.println("6. Sort owners by numbers of animals they have descending");
            System.out.println("7. Add animal");
            System.out.println("8. List animals");
            System.out.println("9. Find animal by name");
            System.out.println("99. Find animal by age");
            System.out.println("999. Find animal by owner's last name");
        }

        System.out.println("0. Exit program");
        System.out.println("11. Test_insertOwners");
        System.out.println("12. Test_insertAnimals");
    }

    private void test_insertOwners() {
        owners.add(new Owner(ownersCount++, "Jan", "Olbracht", "male", 53));
        owners.add(new Owner(ownersCount++, "Anna", "Jagiellonka", "male", 43));
        owners.add(new Owner(ownersCount++, "Bona", "Sforza", "male", 25));
        owners.add(new Owner(ownersCount++, "Henryk", "Pobożny", "male", 60));
        owners.add(new Owner(ownersCount++, "Zygmunt", "Waza", "male", 80));
    }

    private void test_insertAnimals() {
        owners.get(0).setAnimals(new Cat("Kicia", "f", 12, 0, "dachowiec"));
        owners.get(0).setAnimals(new Cat("Mruczek", "f", 32, 0, "pers"));
        owners.get(0).setAnimals(new Cat("Pusia", "f", 15, 0, "dachowiec"));
        owners.get(1).setAnimals(new Cat("Pusia", "f", 15, 1, "dachowiec"));
    }
}




