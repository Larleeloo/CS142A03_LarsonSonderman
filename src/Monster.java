import java.io.IOException;
import java.util.Random;

public class Monster extends Player {
    public Player[] allPlayers;

    public Monster() throws IOException {
        super();
    }

    public void takeTurn(Player[] allPlayers) throws IOException {
        // Monster-specific update logic
        this.allPlayers = allPlayers;
        System.out.println("Monster is taking its turn...");
        performAI();
    }

    // AI logic for the monster
    private void performAI() throws IOException {
        Player nearestPlayer = findNearestPlayer();
        if (nearestPlayer == null) {
            // No players to target
            return;
        }

        // Determine action: move towards the player or attack
        if (isAdjacent(nearestPlayer)) {
            turnToFace(nearestPlayer);
            attack(nearestPlayer, new Weapon());
        } else {
            if (isPlayerInFront(nearestPlayer)) {
                attack(nearestPlayer, new Weapon());
            } else {
                moveTowards(nearestPlayer);
            }
        }
    }

    private Player findNearestPlayer() {
        Player nearestPlayer = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Player player : allPlayers) {
            if (player instanceof Monster) {
                continue; // Skip other monsters
            }
            double distance = calculateDistance(player);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestPlayer = player;
            }
        }
        return nearestPlayer;
    }

    private double calculateDistance(Player player) {
        int dx = this.getxBoardCoords() - player.getxBoardCoords();
        int dy = this.getyBoardCoords() - player.getyBoardCoords();
        return Math.sqrt(dx * dx + dy * dy);
    }

    private boolean isAdjacent(Player player) {
        int dx = Math.abs(this.getxBoardCoords() - player.getxBoardCoords());
        int dy = Math.abs(this.getyBoardCoords() - player.getyBoardCoords());
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1); // Adjacent if difference is 1 in any direction
    }

    private void turnToFace(Player player) {
        int dx = player.getxBoardCoords() - this.getxBoardCoords();
        int dy = player.getyBoardCoords() - this.getyBoardCoords();

        if (dx == 1) {
            turnTo(directions.WEST);
        } else if (dx == -1) {
            turnTo(directions.EAST);
        } else if (dy == 1) {
            turnTo(directions.NORTH);
        } else if (dy == -1) {
            turnTo(directions.SOUTH);
        }
    }

    private boolean isPlayerInFront(Player player) {
        int[] frontCoords = incrementForward(1);
        int frontX = frontCoords[0];
        int frontY = frontCoords[1];
        return frontX == player.getxBoardCoords() && frontY == player.getyBoardCoords();
    }

    private void moveTowards(Player player) throws IOException {
        int dx = player.getxBoardCoords() - this.getxBoardCoords();
        int dy = player.getyBoardCoords() - this.getyBoardCoords();

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                if (myDir != directions.WEST) {
                    turnTo(directions.WEST);
                } else {
                    tryMoveForward(1);
                }
            } else {
                if (myDir != directions.EAST) {
                    turnTo(directions.EAST);
                } else {
                    tryMoveForward(1);
                }
            }
        } else {
            if (dy > 0) {
                if (myDir != directions.NORTH) {
                    turnTo(directions.NORTH);
                } else {
                    tryMoveForward(1);
                }
            } else {
                if (myDir != directions.SOUTH) {
                    turnTo(directions.SOUTH);
                } else {
                    tryMoveForward(1);
                }
            }
        }
    }

    private void tryMoveForward(int steps) throws IOException {
        if (canMoveForward(steps)) {
            moveForward(1, allPlayers);
        } else {
            System.out.println("Error off board or path blocked");
        }
    }

    private boolean canMoveForward(int steps) {
        int[] newCoords = incrementForward(steps);
        int newX = newCoords[0];
        int newY = newCoords[1];
        System.out.println("Trying to move to (" + newX + ", " + newY + ")");
        return newX >= 0 && newY >= 0 && newX < 10 && newY < 10 && !isPathBlocked(newX, newY);
    }

    private boolean isPathBlocked(int x, int y) {
        for (Player player : allPlayers) {
            if (player.getxBoardCoords() == x && player.getyBoardCoords() == y) {
                System.out.println(player.getName() + " is in the way at (" + x + ", " + y + ")");
                return true;
            }
        }
        return false;
    }

    private void turnTo(directions newDir) {
        while (myDir != newDir) {
            turnRight();
        }
        System.out.println("Turned to direction: " + newDir);
    }

    @Override
    public void turnLeft() {
        directions newDir = directions.NORTH;
        switch (myDir) {
            case NORTH:
                newDir = directions.WEST;
                break;
            case SOUTH:
                newDir = directions.EAST;
                break;
            case EAST:
                newDir = directions.NORTH;
                break;
            case WEST:
                newDir = directions.SOUTH;
                break;
        }
        rotateImage(newDir);
        myDir = newDir;
    }

    @Override
    public void turnRight() {
        directions newDir = directions.NORTH;
        switch (myDir) {
            case NORTH:
                newDir = directions.EAST;
                break;
            case SOUTH:
                newDir = directions.WEST;
                break;
            case EAST:
                newDir = directions.SOUTH;
                break;
            case WEST:
                newDir = directions.NORTH;
                break;
        }
        rotateImage(newDir);
        myDir = newDir;
    }

    @Override
    public void turnAround() {
        directions newDir = directions.NORTH;
        switch (myDir) {
            case NORTH:
                newDir = directions.SOUTH;
                break;
            case SOUTH:
                newDir = directions.NORTH;
                break;
            case EAST:
                newDir = directions.WEST;
                break;
            case WEST:
                newDir = directions.EAST;
                break;
        }
        rotateImage(newDir);
        myDir = newDir;
    }

    @Override
    public void moveForward(int steps, Player[] players) throws IOException {
        // Implement the moveForward logic inherited from Player
        super.moveForward(steps, players);
        System.out.println("Moved forward " + steps + " steps.");
    }

    @Override
    public int[] attack(Player target, Weapon weapon) {
        // Implement attack logic
        System.out.println("Monster is attacking " + target.getName());
        int[] result = super.attack(target, weapon);
        System.out.println("Attack result: " + java.util.Arrays.toString(result));
        return result;
    }

    // Method to get other players in the game
    private Player[] getOtherPlayers() {
        return this.allPlayers;
    }
}
