import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Game extends JPanel {
    int input = 0;
    int gameState = 0;
    JLabel instructions = new JLabel("Nothin");
    JLabel directions = new JLabel();
    JLabel extraText = new JLabel();
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
    Scene currentScene;
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
        currentScene = GenerateEntities.createScene(10);
        player1 = currentScene.pInsert();
        player2 = currentScene.pInsert();
        player2.setRole(1);
        this.gameGraphics = new GameGraphics(currentScene);
        this.setPreferredSize(new Dimension(1920,1080));
        gameGraphics.setPreferredSize(new Dimension(720,720));
        this.add(gameGraphics);
        this.add(instructions);
        this.add(directions);
        directions.setVisible(false);
        this.add(extraText);
        extraText.setVisible(false);
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
        if(gameState == 3){
            return player1;
        }
        else {
            return player2;
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
        player1.setRole(0);
        gameGraphics.nextFrame();
        gameState = 1;
        return player1;
    }
    private Player initializeComputer(){
        instructions.setText("Who would you like to play against?\nThis is your opponent... choose wisely");
        player2.setRole(1);
        gameGraphics.nextFrame();
        gameState = 2;
        return player2;
    }
    private void rules() { //Display the rules of the game
        doesHumanStart = flipCoin();
        if (doesHumanStart) {
            instructions.setText("Human starts... Choose an action!");
            gameState = 3;
        } else {
            instructions.setText("Robot starts... Choose an action!");
             gameState = 4;
        }
        turnCounter = 1;
        gameGraphics.nextFrame();
    }
    private void takeTurn(){
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
                    button1.setText("rName 1");
                    button2.setText("rName 2");
                    button3.setText("rName 3");
                    button4.setText("rName 4");
                    button5.setText("rName 5");
                    directions.setVisible(true);
                    directions.setText("Human name: " + player1.getName());
                    initializeComputer();
                    break;
                case 2:
                    button1.setText("Move");
                    button2.setText("Turn Left");
                    button3.setText("Turn Right");
                    button4.setText("Turn Around");
                    button5.setText("Attack");
                    directions.setText("Robot name: " + player2.getName());
                    rules();
                    gameGraphics.nextFrame();
                    break;
                case 3:
                    button1.setText("Move");
                    button2.setText("Turn Left");
                    button3.setText("Turn Right");
                    button4.setText("Turn Around");
                    button5.setText("Attack");
                    currentScene.updateScene();
                    gameGraphics.nextFrame();
                    takeTurn();
                    input = 0;
                    break;
                case 4:
                    button1.setText("Move");
                    button2.setText("Turn Left");
                    button3.setText("Turn Right");
                    button4.setText("Turn Around");
                    button5.setText("Attack");
                    currentScene.updateScene();
                    gameGraphics.nextFrame();
                    takeTurn();
                    input = 0;
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
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 2:
                    player2.setName("rName 1");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 3:
                    player1.moveForward(1);
                    gameState = 4;
                    instructions.setText("Good choice, switching to robots turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 1;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 4:
                    player2.moveForward(1);
                    gameState = 3;
                    instructions.setText("Good choice, switching to humans turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 1;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 5:
                    input = 0;
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonTwoListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    player1.setName("Name 2");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 2:
                    player2.setName("rName 2");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 3:
                    player1.turnLeft();
                    currentScene.pHead.turnLeft();
                    gameState = 4;
                    instructions.setText("Good choice, switching to robots turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 2;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 4:
                    player2.turnLeft();
                    gameState = 3;
                    instructions.setText("Good choice, switching to humans turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 2;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 5:
                    input = 0;
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonThreeListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    player1.setName("Name 3");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 2:
                    player2.setName("rName 3");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 3:
                    player1.turnRight();
                    currentScene.pHead.turnRight();
                    gameState = 4;
                    instructions.setText("Good choice, switching to robots turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 3;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 4:
                    player2.turnRight();
                    gameState = 3;
                    instructions.setText("Good choice, switching to humans turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 3;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 5:
                    input = 0;
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonFourListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    player1.setName("Name 4");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 2:
                    player2.setName("rName 4");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 3:
                    player1.turnAround();
                    currentScene.pHead.turnAround();
                    gameState = 4;
                    instructions.setText("Good choice, switching to robots turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 4;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 4:
                    player2.turnAround();
                    gameState = 3;
                    instructions.setText("Good choice, switching to humans turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 4;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 5:
                    input = 0;
                    break;
                default:
                    break;
            }
        }
    }
    class ButtonFiveListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            switch (gameState){
                case 0:
                    break;
                case 1:
                    player1.setName("Name 5");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 2:
                    player2.setName("rName 5");
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 3:
                    whoseTurn().attack(whoseTurn(), new Weapon());
                    gameState = 4;
                    instructions.setText("Good choice, switching to robots turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 5;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 4:
                    whoseTurn().attack(whoseTurn(), new Weapon());
                    gameState = 3;
                    instructions.setText("Good choice, switching to humans turn...");
                    directions.setText("Game State: " + gameState);
                    gameGraphics.nextFrame();
                    input = 5;
                    gameStartListener.actionPerformed(doAction);
                    break;
                case 5:
                    input = 0;
                    break;
                default:
                    break;
            }
        }
    }

}
