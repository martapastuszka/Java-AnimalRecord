package pl.edu.pg;
import pl.edu.pg.model.MenuManager;
import pl.edu.pg.model.ManageAnimals;
import pl.edu.pg.model.ManageOwners;

//do menu dopisujemy opcję tryb wielkiej litery
// touppercase (string.touppercase) -> to musi być uwzględnione na wyświetlaniu
// gdy jeszcze raz wcisnę ten przycisk to mają wrócić do poprzedniego widoku
// ten tryb musi być obecny w menu

import pl.edu.pg.model.*;
import java.util.*;
import java.util.List;

public class AnimalRecord {
    protected int ownersCount;
    protected List<Owner> owners = new ArrayList<>();
    public boolean printUpperCase = false;

//    public AnimalRecord(int ownersCount) {
//        this.ownersCount = ownersCount;
//    }
    public void start() {
        MenuManager menu = new MenuManager();
        ManageAnimals manageAnimals = new ManageAnimals();
        ManageOwners manageOwners = new ManageOwners();

        System.out.println("Welcome in the record of animals and their owners");
        for (; ;) {
            int o = menu.showMenu();
            switch (o) {
                case 0: //exit the program
                    System.out.println("Thanks, bye bye!");
                    // instead of System.exit(0)
                    return;
                case 1: // add new owner
                    // dodać stałe
                    if (ownersCount >= 0 && ownersCount < 5) {
                        owners.add(manageOwners.createOwner());
                    } else {
                        System.out.println("Max number of owners (5) reached. You cannot add more");
                    }
                    break;
                case 2: // list owners
                    manageOwners.listOwners();
                    break;
                case 22: // list owners - upper case mode
                    if(printUpperCase == false){
                        printUpperCase = true;
                    }else{
                        printUpperCase = false;
                    }
                case 3:
                    owners.sort((p1,p2) -> { return p1.getLastName().compareTo(p2.getLastName()); }); // p1 < p2 = -1
                    manageOwners.listOwners();
                    break;
                case 4:
                    owners.sort((p1,p2) -> { return p2.getLastName().compareTo(p1.getLastName()); });
                    manageOwners.listOwners();
                    break;
                case 5:
                    owners.sort(Comparator.comparingInt(Owner::getAnimalsCount));
                    manageOwners.listOwners();
                    break;
                case 6:
                    owners.sort((p1,p2) -> { return p2.getAnimalsCount() - p1.getAnimalsCount(); });
                    manageOwners.listOwners();
                    break;
                case 7: // add animal
                    manageAnimals.createAnimal();
                    break;
                case 8: // list animals
                    manageAnimals.listAnimals();
                    break;
                case 9:
                    manageAnimals.findAnimalByName();
                    break;
                case 99:
                    manageAnimals.findAnimalByAge();

                    break;
                case 999:
                    manageAnimals.findAnimalByLastName();
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

//    private int pickOption() {
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextInt();
//    }

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




