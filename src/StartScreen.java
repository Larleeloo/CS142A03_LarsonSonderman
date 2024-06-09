import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StartScreen extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private int opponentClass;
    private int selectedClass;
    private JPanel heroesAndMonsters;
    private JLabel opponentClassLabel;
    private JLabel playerClassLabel;

    public StartScreen() throws IOException {
        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);

        // Create the main game panel
        heroesAndMonsters = new JPanel();
        cardContainer.add(heroesAndMonsters, "Heroes and Monsters");

        // Create the start screen panel with a "Start" button
        JPanel startScreen = new JPanel(null);
        JButton buttonOne = new JButton("Start");
        buttonOne.setBounds(860, 440, 200, 200);
        buttonOne.addActionListener(e -> cardLayout.show(cardContainer, "Selection Screen"));
        startScreen.add(buttonOne);
        cardContainer.add(startScreen, "Start Screen");

        // Create the combined selection screen
        JPanel selectionScreen = createSelectionScreen();
        cardContainer.add(selectionScreen, "Selection Screen");

        // Set up the main CardPanel layout
        setLayout(new BorderLayout());
        add(cardContainer, BorderLayout.CENTER);

        // Show the start screen initially
        cardLayout.show(cardContainer, "Start Screen");

        // Set preferred size for the main panel
        this.setPreferredSize(new Dimension(1920, 1080));
    }

    private JPanel createSelectionScreen() {
        JPanel panel = new JPanel(new BorderLayout());

        // Top panel for showing current selections
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        opponentClassLabel = new JLabel("Opponent Class: None", SwingConstants.CENTER);
        playerClassLabel = new JLabel("Player Class: None", SwingConstants.CENTER);
        topPanel.add(opponentClassLabel);
        topPanel.add(playerClassLabel);

        // Center panel for selection buttons
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));

        // Opponent class selection panel
        JPanel opponentClassPanel = new JPanel(new GridLayout(4, 1));
        JLabel opponentClassSelectionLabel = new JLabel("Select opponent class:");
        opponentClassPanel.add(opponentClassSelectionLabel);

        JButton opponentBtn1 = new JButton("Goblin");
        JButton opponentBtn2 = new JButton("Giant");
        JButton opponentBtn3 = new JButton("Giant Goblin");

        opponentBtn1.addActionListener(e -> updateOpponentClass(4));
        opponentBtn2.addActionListener(e -> updateOpponentClass(5));
        opponentBtn3.addActionListener(e -> updateOpponentClass(6));

        opponentClassPanel.add(opponentBtn1);
        opponentClassPanel.add(opponentBtn2);
        opponentClassPanel.add(opponentBtn3);

        // Player class selection panel
        JPanel playerClassPanel = new JPanel(new GridLayout(4, 1));
        JLabel playerClassSelectionLabel = new JLabel("Select your class:");
        playerClassPanel.add(playerClassSelectionLabel);

        JButton playerBtn1 = new JButton("Knight");
        JButton playerBtn2 = new JButton("Wizard");
        JButton playerBtn3 = new JButton("Ranger");

        playerBtn1.addActionListener(e -> updatePlayerClass(1));
        playerBtn2.addActionListener(e -> updatePlayerClass(2));
        playerBtn3.addActionListener(e -> updatePlayerClass(3));

        playerClassPanel.add(playerBtn1);
        playerClassPanel.add(playerBtn2);
        playerClassPanel.add(playerBtn3);

        // Add both selection panels to the center panel
        centerPanel.add(opponentClassPanel);
        centerPanel.add(playerClassPanel);

        // Bottom panel for the start game button
        JPanel bottomPanel = new JPanel();
        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> startGame());
        bottomPanel.add(startGameButton);

        // Combine all panels in the main selection panel
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void updateOpponentClass(int opponentClass) {
        this.opponentClass = opponentClass;
        opponentClassLabel.setText("Opponent Class: " + opponentClass);
    }

    private void updatePlayerClass(int selectedClass) {
        this.selectedClass = selectedClass;
        playerClassLabel.setText("Player Class: " + selectedClass);
    }

    private void startGame() {
        // Pass the selected parameters to the Game panel
        try {
            heroesAndMonsters.removeAll();
            heroesAndMonsters.add(new Game(10,opponentClass, selectedClass));
            heroesAndMonsters.revalidate();
            heroesAndMonsters.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the game panel
        cardLayout.show(cardContainer, "Heroes and Monsters");
    }
}
