package pl.edu.pg;
import pl.edu.pg.model.MenuManager;
import pl.edu.pg.model.ManageAnimals;
import pl.edu.pg.model.ManageOwners;

public class AnimalRecord {

    private boolean printUpperCase = false;
    public void start() {
        MenuManager menu = new MenuManager();
        ManageAnimals manageAnimals = new ManageAnimals();
        ManageOwners manageOwners = new ManageOwners();

        System.out.println("Welcome in the record of animals and their owners");
        for (; ;) {
            int o = menu.showMenu(manageOwners.getOwnersCount());
            switch (o) {
                case 0: //exit the program
                    System.out.println("Thanks, bye bye!");
                    // instead of System.exit(0)
                    return;
                case 1: // add new owner
                    // dodać stałe
                    int ownersCount = manageOwners.getOwnersCount();
                    if (ownersCount >= 0 && ownersCount < 5) {
                        manageOwners.createOwner();
                    } else {
                        System.out.println("Max number of owners (5) reached. You cannot add more");
                    }
                    break;
                case 2: // list owners
                    manageOwners.listOwners(printUpperCase);
                    break;
                case 22: // list owners - upper case mode
                    if(!printUpperCase){
                        printUpperCase = true;
                    }
                    else{
                        printUpperCase = false;
                    }
                    break;
                case 3:
                    manageOwners.sortOwnersByLastNameAsc();
                    manageOwners.listOwners(printUpperCase);
                    break;
                case 4:
                    manageOwners.sortOwnersByLastNameDesc();
                    manageOwners.listOwners(printUpperCase);
                    break;
                case 5:
                    manageOwners.sortOwnersByNumAnimalsAsc();
                    manageOwners.listOwners(printUpperCase);
                    break;
                case 6:
                    manageOwners.sortOwnersByNumAnimalsDesc();
                    manageOwners.listOwners(printUpperCase);
                    break;
                case 7: // add animal
                    manageAnimals.createAnimal(manageOwners.getOwnerList(), printUpperCase);
                    break;
                case 8: // list animals
                    manageAnimals.listAnimals(manageOwners.getOwnerList(), printUpperCase);
                    break;
                case 9:
                    manageAnimals.findAnimalByName(manageOwners.getOwnerList());
                    break;
                case 99:
                    manageAnimals.findAnimalByAge(manageOwners.getOwnerList());

                    break;
                case 999:
                    manageAnimals.findAnimalByLastName(manageOwners.getOwnerList());
                    break;
                case 11: // test_insertOwners
                    manageOwners.test_insertOwners();
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

    ////// Getters and Setters //////

    public boolean getPrintUpperCase(){
        return printUpperCase;
    }

}




