import java.util.*;

public class TicTacToe {

    // turn values, game field
    // sing_x, sing_o, sing_empty - human move, computer move, empty field
    // gameField - game field [3x3]
    private char sing_x = 'x';
    private char sing_o = 'o';
    private char sing_empty = '.';
    private char[][] gameField = new char[3][3];
    private Scanner scan = new Scanner(System.in);
    private Random rn = new Random();

    // class constructor (to fill game field as empty field)
    public TicTacToe () {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                this.gameField [k][i] = sing_empty;
            }
        }
    }

    // print game field to screen
    public void printGameField () {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                System.out.print(" " + gameField[k][i] + " |");
            }
            System.out.println("");
            System.out.println("---+---+---+");
        }
    }

    // check is gameField full with himan and copmuter sings
    public boolean checkIsGameFieldFull() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (gameField[k][i] == sing_empty) {
                    return true;
                }
            }
        }
        return false;
    }

    // check if player wins
    // player [x || o] - to define player ('x' - human, 'o' - computer)
    public boolean checkIsWin(char player) {
        char sing;
        if (player == 'x') {
            sing = sing_x;
        } else if (player == 'o') {
            sing = sing_o;
        } else {
            return false;
        }

        // check winner combinations by rows and columns
        for (int i = 0; i < 3; i++) {
            if (((gameField[0][i] == sing) && (gameField[1][i] == sing) && (gameField[2][0] == sing)) || ((gameField[i][0] == sing) && (gameField[i][1] == sing) && (gameField[i][2] == sing))) {
                return true;
            }
        }
        // check winner combinations by diagonals
        if (((gameField[0][0] == sing) && (gameField[1][1] == sing) && (gameField[2][2] == sing)) || ((gameField[0][2] == sing) && (gameField[1][1] == sing) && (gameField[2][0] == sing))) {
            return true;
        }
        return false;
    }


    // Human turn
    public boolean turnHuman(TicTacToe game) {
        // coordinates entered by human
        int humanX, humanY;
        // get coordinates from Human
        System.out.println("Choose \"X\" to move [0 .. 2]:");
        humanX = scan.nextInt();
        System.out.println("Choose \"Y\" to move [0 .. 2]:");
        humanY = scan.nextInt();

        while (true) {
            //check are coordinates valid
            if (!game.checkIsCoordinatesValid(humanX, humanY)) {
                System.out.println("Incorrect choice! Out of the game field! \n\r +" +
                        "Try again, please!");
                return false;
            }
            // check are coordinates free for move
            if (!game.chekIsTurnAvaliable(humanX, humanY)) {
                System.out.println("Incorrect choice! Coordinates are already filled in! \n\r" +
                        "Try again, please!");
                return false;

            }
            // set human turn into gameField and print gameField
            if (game.setTurn(humanX, humanY, 'x')) {
                game.printGameField();
                return true;
            }
        }
    }

    // Computer turn
    public boolean turnComputer(TicTacToe game) {
        System.out.println("Computer makes its turn");
        // coordinates randomly chosen by computer
        int compX, compY;
        while (true) {
            // define X and Y coordinates to computer turn
            compX = rn.nextInt(3);
            compY = rn.nextInt(3);

            // check are coordinates free
            if (game.chekIsTurnAvaliable(compX, compY)) {
                break;
            }
        }
        // set computer turn into gameField and print gameField
        if (game.setTurn(compX, compY, 'o')) {
            game.printGameField();
            return true;
        }
        return false;
    }


    // check are provided coordinates valid
    private boolean checkIsCoordinatesValid (int posX, int posY) {
        if ((posX >= 0) && (posX <= 2) && (posY >= 0) && (posY <= 2)) {
            return true;
        }
        return false;
    }

    // check are provided coordinates are empty (free for move)
    private boolean chekIsTurnAvaliable (int posX, int posY) {
        if (gameField[posX][posY] == sing_empty) {
            return true;
        }
        return false;
    }


    // set sing into the gameField:
    // posX, posY - X and Y ass coordinates to gameField
    // player [x || o] - to define player ('x' - human, 'o' - computer)
    private boolean setTurn (int posX, int posY, char player) {
        if (player == 'x') {
            gameField[posX][posY] = sing_x;
            return true;
        } else if (player == 'o') {
            gameField[posX][posY] = sing_o;
            return true;
        }
        return false;
    }

}



