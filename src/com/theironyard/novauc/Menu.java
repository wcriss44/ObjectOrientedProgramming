package com.theironyard.novauc;

public class Menu {
    String town;
    String name;


    public void mainMenu() throws Exception{
        System.out.println("\t\t\t\t************************************");
        System.out.println("\t\t\t\t*   Welcome to questVille V2.0.3   *");
        System.out.println("\t\t\t\t*                                  *");
        System.out.println("\t\t\t\t*   Items are randomly generated.  *");
        System.out.println("\t\t\t\t*  List Items from main menu will  *");
        System.out.println("\t\t\t\t* show all of the collected items. *");
        System.out.println("\t\t\t\t************************************\n");
        for(;;) {
            System.out.println("Now loading. . .\n");
            System.out.println("Quest giver: \t\tFrom where do you hail, traveler?");
            System.out.println("[Freeport][Qeynos][Crushbone][Neriak][List Items][exit]\n");
            System.out.print("Your town: ");
            town = Game.scanner.nextLine().toUpperCase();
            System.out.print("Your town: ");
            switch(town){
                case "FREEPORT":
                case "QEYNOS":
                case "CRUSHBONE":
                case "NERIAK":
                    findName(town);
                    break;
                case "LIST ITEMS":
                case "LISTITEMS":
                    System.out.println("");
                    Game.printInventoryitems();
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid town");
                    break;
            }
        }
    }
    public void findName(String town) throws Exception{//want to use local here
        System.out.printf("\nQuest giver: \t\tAhh, %s is an amazing town.", town);
        System.out.println("\nQuest giver: \t\tThere is an orc from there so dumb he doesn't know his name!");
        System.out.println("Quest giver: \t\tOH! That's right! I forgot to ask your name!");
        System.out.print("\nYour name: ");
        name = Game.scanner.nextLine();

        System.out.printf("Quest giver: \t\tThat is strange, his name was %s just like you!", name);
        System.out.println("\nQuest giver: \t\tAhh well. . .");
        for(;;){
            System.out.println("Quest giver: \t\tWould you like to go on an adventure?  [Y][N]");
            switch(Game.scanner.nextLine().toUpperCase()) {
                case "Y":
                    System.out.println("Quest giver: \t\tGreat! Lets get started!\n");
                    System.out.println("Picking a random adventure. . .");
                    adventureStart();
                    return;
                case "N":
                    System.out.println("Quest giver: \t\tAhh. I understand. Stupid orcs don't generally like to!");
                    return;
                default:
                    System.out.println("Invalid entry");
                    break;
             }
        }
    }
    public void adventureStart() throws Exception{
        int adventure = Game.randomRange(1, 2);
        switch(adventure){
            case 1:
                goblinSmash();
                break;
            case 2:
                hillGiantTopple();
                break;
        }
    }
    public void goblinSmash() throws Exception {
         for(;;){
            System.out.println("Quest giver: \t\tWelcome to Goblin Smash!\n");
            System.out.println("A goblin approaches . . .");
            System.out.println("[Fight][Run]");
            String choice = Game.scanner.nextLine();

            if (choice.equalsIgnoreCase("fight")){
                Game.inventoryitem.findItem(Game.randomRange(1, 3));
                break;
            } else if(choice.equalsIgnoreCase("run")){
                System.out.println("Quest giver: \t\tRun like the dirty orc you are!");
               break;
            }else {
                System.out.println("Please enter a valid choice.");
            }
        }
    }

    public void hillGiantTopple() throws Exception{
        for(int i = 0; i < Game.randomRange(1, 3);i++){
            System.out.println("Quest giver: \t\tWelcome to Hill Giant Topple!\n");
            System.out.println("A hill giant approaches . . .");
            System.out.println("[Fight][Run]");
            switch(Game.scanner.nextLine().toUpperCase()) {
                case "FIGHT":
                    Game.inventoryitem.findItem(Game.randomRange(1, 5));
                    break;
                case "RUN":
                    System.out.println("Quest giver: \t\tI knew you were a coward!");
                    return;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }
    }
}
