// Iboard interface
public interface Iboard {

    void print();

    void reset();

    String getMark(int row, int col);

    boolean makeMove(String player, int row, int col);

    void setSize(int row, int col);

    int getColSize();

    int getRowSize();

    String getName();

    boolean isFull();
}

// APlayer abstract class
abstract class APlayer {
    // Define common player properties and methods here
}

// ComputerPlayer class
class ComputerPlayer extends APlayer {
    // Implement computer player behavior here
}

// HumanPlayer class
class HumanPlayer extends APlayer {
    // Implement human player behavior here
}

// OtherBoard class (unchanged)

// OtherBoardWrapper class
class OtherBoardWrapper implements Iboard {
    private OtherBoard otherBoard;

    public OtherBoardWrapper(OtherBoard otherBoard) {
        this.otherBoard = otherBoard;
    }

    @Override
    public void print() {
        otherBoard.printMyBoard();
    }

    @Override
    public void reset() {
        otherBoard.reset();
    }

    @Override
    public String getMark(int row, int col) {
        return otherBoard.getMark(row, col);
    }

    @Override
    public boolean makeMove(String player, int row, int col) {
        return otherBoard.setMark(row, col, player);
    }

    @Override
    public void setSize(int row, int col) {
        otherBoard.setSize(row, col);
    }

    @Override
    public int getColSize() {
        return otherBoard.getColSize();
    }

    @Override
    public int getRowSize() {
        return otherBoard.getRowSize();
    }

    @Override
    public String getName() {
        return otherBoard.getName();
    }

    @Override
    public boolean isFull() {
        // Implement the logic to check if the board is full
        return false;
    }
}

// TTTGame class
class TTTGame {
    private Iboard board;
    private APlayer[] players;

    public void setBoard(Iboard board) {
        this.board = board;
    }

    public void setPlayers(APlayer player1, APlayer player2) {
        this.players = new APlayer[]{player1, player2};
    }

    public void start() {
        // Implement game logic here using board and players
    }
}

// DriverMain class (unchanged)
public class DriverMain {
    public static void main(String[] args) {
        TTTGame game = new TTTGame();
        game.setBoard(new OtherBoardWrapper(new OtherBoard()));
        game.setPlayers(new ComputerPlayer(), new ComputerPlayer());
        game.start();
    }
}