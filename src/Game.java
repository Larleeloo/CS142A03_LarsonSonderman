import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

//todo
//merge Game and Movement panel (rename to just Game)
//create frames

public class Game extends JPanel {
    int input = 0;
    int gameState = 0;
    JLabel instructions = new JLabel("Nothin");
    JLabel directions = new JLabel();
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
    JButton button5 = new JButton("Button 5");
    private JButton gameStartButton = new JButton("Next Frame");
    GameGraphics gameGraphics;
    //******Game stuff
    int aiType;
    private String[] smartNames = {"Eniac","Brainiac","HAL","Deep Thought","Sky Net"};
    private boolean doesHumanStart = false;
    private boolean gameOver = false;
    private boolean gameStarted = false;
    private int turnCounter = 0;
    Battlefield[] battlefields;
    Player player1;
    Player player2;
    ButtonOneListener buttonOneListener = new ButtonOneListener();
    ButtonTwoListener buttonTwoListener = new ButtonTwoListener();
    ButtonThreeListener buttonThreeListener = new ButtonThreeListener();
    ButtonFourListener buttonFourListener = new ButtonFourListener();
    ButtonFiveListener buttonFiveListener = new ButtonFiveListener();
    GameStartListener gameStartListener = new GameStartListener();
    ActionEvent doAction = new ActionEvent(this, 1, "COMMAND1");
    public Game(int landArea) throws IOException {
        battlefields = FillBattlefields.createBattlefields(landArea, 10);
        player1 = battlefields[0].findPlayer1();
        player2 = battlefields[0].findAnNPC();
        this.gameGraphics = new GameGraphics(battlefields[0]);
        this.setPreferredSize(new Dimension(1920,1080));
        gameGraphics.setPreferredSize(new Dimension(1280,720));
        this.add(gameGraphics);
        this.add(instructions);
        this.add(directions);
        directions.setVisible(false);
        this.add(button1);
        button1.addActionListener(buttonOneListener);
        button1.setVisible(false);
        this.add(button2);
        button2.addActionListener(buttonTwoListener);
        button2.setVisible(false);
        this.add(button3);
        button3.addActionListener(buttonThreeListener);
        button3.setVisible(false);
        this.add(button4);
        button4.addActionListener(buttonFourListener);
        button4.setVisible(false);
        this.add(button5);
        button5.addActionListener(buttonFiveListener);
        button5.setVisible(false);
        gameStartButton.addActionListener(gameStartListener);
        this.add(gameStartButton);
    }
    public void endGame(){
        instructions.setText("Game Over!");
        gameGraphics.nextFrame();
    }

    public boolean flipCoin(){
        return new Random().nextBoolean();
    }

    public Player whoseTurn(){
        if(gameState == 3 && doesHumanStart){
            return player1;
        }
        else if(gameState == 3 && !doesHumanStart){
            return player2;
        }
        else if(gameState == 4 && doesHumanStart){
            return player2;
        }
        else {
            return player1;
        }
    }
    public void playGame() {
        player1 = initializeHuman();
    }

    public void initializeGame() {
        playGame();
    }
    private Player initializeHuman() {
        instructions.setText("Please select a name below for your player");
        gameGraphics.nextFrame();
        gameState = 1;
        return player1;
    }
    private Player initializeComputer(){
        instructions.setText("Who would you like to play against?\nThis is your opponent... choose wisely");
        gameGraphics.nextFrame();
        gameState = 2;
        return player2;
    }
    private void rules() { //Display the rules of the game
        doesHumanStart = flipCoin();
        if (doesHumanStart) {
            instructions.setText("\n\nLets begin! Human, (or " + player1.getName() + ") you go first... Please enter a number to remove some marbles");
        } else {
             instructions.setText("\n\nLets begin! Computer, (or " + player2.getName() + "), you go first... Please enter a number to remove some marbles");
        }
        gameState = 3;
        gameGraphics.nextFrame();
    }
    private void takeTurn(){
        instructions.setText("GameState: " + gameState);
        directions.setVisible(true);
        if(gameState == 3 && doesHumanStart){
            directions.setText("Human turn " + turnCounter);
        }
        else if(gameState == 3 && !doesHumanStart){
            directions.setText("Robot turn " + turnCounter);
        }
        else if(gameState == 4 && doesHumanStart){
            directions.setText("Robot  turn " + turnCounter);
        }
        else {
            directions.setText("Human turn " + turnCounter);
        }
        turnCounter++;
        gameGraphics.nextFrame();
    }

    class GameStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (gameState) {
                case 0:
                    button1.setVisible(true);
                    button2.setVisible(true);
                    button3.setVisible(true);
                    button4.setVisible(true);
                    button5.setVisible(true);
                    button1.setText("Name 1");
                    button2.setText("Name 2");
                    button3.setText("Name 3");
                    button4.setText("Name 4");
                    button5.setText("Name 5");
                    initializeGame();
                    break;
                case 1:
                    gameGraphics.doSomethingWithPrevInput(input);
                    button1.setVisible(true);
                    button2.setVisible(true);
                    button3.setVisible(true);
                    button4.setVisible(true);
                    button5.setVisible(true);
                    button1.setText("rName 1");
                    button2.setText("rName 2");
                    button3.setText("rName 3");
                    button4.setText("rName 4");
                    button5.setText("rName 5");
                    initializeComputer();
                    break;
                case 2:
                    gameGraphics.doSomethingWithPrevInput(input);
                    button1.setText("Move");
                    button2.setText("Turn Left");
                    button3.setText("Turn Right");
                    button4.setText("Turn Around");
                    button5.setText("Attack");
                    rules();
                    break;
                case 3:
                    input = 0;
                    gameGraphics.doSomethingWithPrevInput(input);
                    button1.setText("Move");
                    button2.setText("Turn Left");
                    button3.setText("Turn Right");
                    button4.setText("Turn Around");
                    button5.setText("Attack");
                    takeTurn();
                    gameState = 4;
                    break;
                case 4:
                    input = 0;
                    button1.setText("Move");
                    button2.setText("Turn Left");
                    button3.setText("Turn Right");
                    button4.setText("Turn Around");
                    button5.setText("Attack");
                    gameGraphics.doSomethingWithPrevInput(input);
                    takeTurn();
                    gameState = 3;
                    break;
                case 5:
                    button1.setVisible(false);
                    button2.setVisible(false);
                    button3.setVisible(false);
                    button4.setVisible(false);
                    button5.setVisible(false);
                    gameStartButton.setVisible(false);
                    endGame();
                    break;
            }
        }
    }


    class ButtonOneListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    player1.setName("Name 1");
                    break;
                case 2:
                    player2.setName("rName 1");
                    break;
                case 3:
                    whoseTurn().moveForward(1);
                    input = 1;
                    break;
                case 4:
                    whoseTurn().moveForward(1);
                    input = 1;
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonTwoListener implements ActionListener {
        String choice;
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    choice = "Human Name 1";
                    button1.setText(choice);
                    break;
                case 2:
                    choice = "Robot Name 1";
                    button1.setText(choice);
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonThreeListener implements ActionListener {
        String choice;
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    choice = "Human Name 1";
                    button1.setText(choice);
                    break;
                case 2:
                    choice = "Robot Name 1";
                    button1.setText(choice);
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonFourListener implements ActionListener {
        String choice;
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    choice = "Human Name 1";
                    button1.setText(choice);
                    break;
                case 2:
                    choice = "Robot Name 1";
                    button1.setText(choice);
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonFiveListener implements ActionListener {
        String choice;
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    choice = "Human Name 1";
                    button1.setText(choice);
                    break;
                case 2:
                    choice = "Robot Name 1";
                    button1.setText(choice);
                    break;
                default:
                    break;
            }
        }
    }
}
