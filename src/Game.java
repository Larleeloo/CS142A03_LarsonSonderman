import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {


    private Scanner scan = new Scanner(System.in);
    int aiType;
    private String[] smartNames = {"Eniac","Brainiac","HAL","Deep Thought","Sky Net"};
    private boolean doesHumanStart = false;
    private boolean gameOver = false;
    private int turnCounter = 0;
    Battlefield[] battlefields = new Battlefield[63];
    Player player1;
    Player player2;
    public Game(int landArea) throws IOException, InterruptedException {
        battlefields = FillBattlefields.createBattlefields(landArea, 10);
        player1 = battlefields[0].findPlayer1();
        player2 = battlefields[0].findAnNPC();
        initializeGame();
    }

    public void initializeGame() throws InterruptedException {
        player1 = initializeHuman();
        player2 = initializeComputer();
        rules();
        plaGame();
    }
    private Player initializeHuman() {
        System.out.println("Please enter an integer to select from the following smart names: \n(This will be your name, player 1)");
        for (int i = 0; i < smartNames.length; i++) {
            System.out.println(i + 1 + " " + smartNames[i]);
        }
        int selection = 0;
        while (selection == 0) {
            switch (selection) {
                case 0:
                    try {
                        selection = Integer.parseInt(scan.nextLine());
                        if (selection > 5 || selection < 1) {
                            System.out.println("Invalid choice");
                        } else {
                            player1.setName(smartNames[selection - 1]);
                            System.out.println("You chose " + player1.getName());
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Please *actually* enter an integer.");
                    }
                default:
                    selection = 0;
            }
            ;
        }
        return player1;
    }
    private Player initializeComputer(){
        System.out.println("Who would you like to play against?\nThis is your opponent... choose wisely");
        System.out.println("Enter an integer 1-10");
        String[] allNames = new String[10];
        int j = 9;
        for(int i = 0; i < 5; i ++){
            allNames[j] = smartNames[j - 5];
            j--;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(i+1 + ": " + allNames[i]);
        }
        int selection = 0;
        while(selection == 0){
            switch (selection) {
                case 0:
                    try {
                        selection = Integer.parseInt(scan.nextLine());
                        if (selection > 10 || selection < 1) {
                            System.out.println("Invalid choice");
                        } else {
                            player2.setName(allNames[selection - 1]);
                            aiType = selection - 1;
                            System.out.println("You chose " + player2.getName());
                            break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Please *actually* enter an integer.");
                    }
                default:
                    selection = 0;
            };
        }
        return player2;
    }
    private void rules() { //Display the rules of the game
        doesHumanStart = true;
        if (doesHumanStart) {
            System.out.println("\n\nLets begin! Human, (or " + player1.getName() + ") you go first... Please enter a number to remove some marbles");
        } else {
            System.out.println("\n\nLets begin! Computer, (or " + player2.getName() + "), you go first... Please enter a number to remove some marbles");
        }
    }
    private void plaGame() throws InterruptedException {
        while (!gameOver) {
            Thread.sleep(1000);
            takeTurn();
        }
    }
    private void takeTurn(){

        //gameOver = true;
    }

    public boolean getGameOver(){
        return this.gameOver;
    }
}
