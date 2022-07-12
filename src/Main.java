
public class Main {
    public static void main(String[] args) {

        // variables
        TicTacToe game = new TicTacToe();
        boolean humanTurnResult, computerTurnResult;

        // about the game
        System.out.println("Hi! Let's play TicTacToe game!");
        System.out.println("");
        // print game field
        game.printGameField();



        while (true) {
            // check isn't gameField full
            if (!game.checkIsGameFieldFull()) {
                System.out.println("There is no empty turn!");
                break;
            }

            // Human choice to make a turn
            do {
                humanTurnResult = game.turnHuman(game);
            } while (!humanTurnResult);

            // check is Human wins
            if (game.checkIsWin('x')) {
                System.out.println("Congratulations! Human is winner!");
                break;
            }

            // check isn't gameField full
            if (!game.checkIsGameFieldFull()) {
                System.out.println("There is no empty turn!");
                break;
            }

            // Computer choice to make a turn
            do {
                computerTurnResult = game.turnComputer(game);;
            } while (!computerTurnResult);

            // check is Human wins
            if (game.checkIsWin('o')) {
                System.out.println("Congratulations! Computer is winner!");
                break;
            }

        }
    }
}




