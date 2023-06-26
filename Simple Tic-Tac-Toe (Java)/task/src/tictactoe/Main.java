package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

class Game {
    private Scanner scanner = new Scanner(System.in);
    private String userInput = new String();
    private String gameState = new String();
    int arrInt1 = 0;
    int arrInt2 = 0;
    int boardStatus[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int boardStatus2[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    boolean continueGame = true;
    boolean goodInput;
    int turnCount = 0;

    public void startGame() {
        Board gameBoard = new Board();
        gameBoard.printInitBoard();

        do {
            userInput = scanner.nextLine();
            String[] arrayInput = userInput.split("\\s");

            try {
                arrInt1 = Integer.parseInt(arrayInput[0]);
                arrInt2 = Integer.parseInt(arrayInput[1]);

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            goodInput = checkUserInput(arrInt1, arrInt2);
            if (goodInput) {
                if (!gameBoard.cellOccupiedCheck(arrInt1, arrInt2, boardStatus)) {
                    boardStatus2 = gameBoard.boardUpdate(arrInt1, arrInt2, boardStatus, turnCount);
                    gameBoard.printBoardUpdate(boardStatus2);
                    continueGame = checkForWinOrDraw(boardStatus2);
                    System.arraycopy(boardStatus2, 0, boardStatus, 0, 9);
                    turnCount++;
                }
            }

        } while (continueGame);

    }

    private boolean checkForWinOrDraw(int[] input) {
        boolean win_x = checkWin(2, input);
        boolean win_o = checkWin(1, input);

        if (win_x) {
            System.out.println("X wins");
            return false;
        } else if (win_o) {
            System.out.println("O wins");
            return false;
        } else if (Arrays.stream(input).noneMatch(e -> e == 0)) {
            System.out.println("Draw");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkWin(int player, int[] input) {
        if (input[0] == player && input[1] == player && input[2] == player) {
            return true;
        } else if (input[3] == player && input[4] == player && input[5] == player) {
            return true;
        } else if (input[6] == player && input[7] == player && input[8] == player) {
            return true;
        } else if (input[0] == player && input[3] == player && input[6] == player) {
            return true;
        } else if (input[1] == player && input[4] == player && input[7] == player) {
            return true;
        } else if (input[2] == player && input[5] == player && input[8] == player) {
            return true;
        } else if (input[0] == player && input[4] == player && input[8] == player) {
            return true;
        } else if (input[2] == player && input[4] == player && input[6] == player) {
            return true;
        } else {
            return false;
        }
        // winning condition: [0,1,2] [3,4,5] [6,7,8] [0,3,6] [1,4,7] [2,5,8] [0,4,8] [2,4,6]
    }

    private boolean checkUserInput(int num1, int num2) {
        if ((num1 >= 4 || num2 >= 4) || (num1 <= 0 || num2 <= 0)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

}
class Board {
    public void printInitBoard() {
        System.out.println("---------");
        for (int i = 0; i < 9; i++) {
            if ((i == 0) || (i == 3) || (i == 6)) {
                System.out.print("|");
            }
            System.out.print(" ");
            System.out.print(" ");
            if ((i == 2) || (i == 5) || (i == 8)) {
                System.out.print(" ");
                System.out.println("|");
            }
        }
        System.out.println("---------");
    }
    public void printBoardUpdate(int[] board) {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            if ((i == 0) || (i == 3) || (i == 6)) {
                System.out.print("|");
            }
            System.out.print(" ");
            if (board[i] == 0) {
                System.out.print("_");
            } else if (board[i] == 1) {
                System.out.print("O");
            } else if (board[i] == 2) {
                System.out.print("X");
            }

            if ((i == 2) || (i == 5) || (i == 8)) {
                System.out.print(" ");
                System.out.println("|");
            }
        }
        System.out.println("---------");
    }

    public boolean cellOccupiedCheck(int num1, int num2, int[] board) {
        switch (num1) {
            case 1:
                switch (num2) {
                    case 1:
                        if (board[0] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }

                    case 2:
                        if (board[1] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }

                    case 3:
                        if (board[2] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }

                }
            return false;
            case 2:
                switch (num2) {
                    case 1:
                        if (board[3] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }
                    case 2:
                        if (board[4] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }
                    case 3:
                        if (board[5] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }
                }
            return false;
            case 3:
                switch (num2) {
                    case 1:
                        if (board[6] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }
                    case 2:
                        if (board[7] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }
                    case 3:
                        if (board[8] != 0) {
                            System.out.println("This cell is occupied! Choose another one!");
                            return true;
                        } else {
                            return false;
                        }
                }
            return false;
        }
        return false;
    }


    public int[] boardUpdate(int num1, int num2, int[] board, int turnCount) {
        // 0=empty, 1=O, 2=X
        switch (num1) {
            case 1:
                switch (num2) {
                    case 1:
                        if (board[0] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[0] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                    case 2:
                        if (board[1] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[1] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                    case 3:
                        if (board[2] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[2] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                }
                break;
            case 2:
                switch (num2) {
                    case 1:
                        if (board[3] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[3] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                    case 2:
                        if (board[4] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[4] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                    case 3:
                        if (board[5] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[5] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                }
                break;
            case 3:
                switch (num2) {
                    case 1:
                        if (board[6] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[6] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                    case 2:
                        if (board[7] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[7] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                    case 3:
                        if (board[8] != 0) {
//                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            board[8] = (turnCount % 2 == 0) ? 2: 1;
                        }
                        break;
                }
                break;
        }
        return board;
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
