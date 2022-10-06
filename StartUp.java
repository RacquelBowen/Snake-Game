package Program3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class StartUp {
    public String endString, userDir;
    public boolean endGame = false;
    public int pointRow, pointCol;
    public int scoreTally = 0;
    public int row = 20;
    public int col = 20;
    public int upDown = 10;
    public int leftRight = 10;
    public char[][] twoDimArray = new char[row][col];

    public StartUp(){
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++){
                twoDimArray[i][j] = '.';
            }
        }
        XPoints();
    }

    public void XPoints(){
        Random randPlaceRow = new Random();
        Random randPlaceCol = new Random();
        pointRow = randPlaceRow.nextInt(20);
        pointCol = randPlaceCol.nextInt(20);
        if (twoDimArray[pointRow][pointCol] == '.'){
            twoDimArray[pointRow][pointCol] = 'x';
        }
    }

    public void UserInput(){
        System.out.println("Score: " + scoreTally + "   " + "Direction (W, A, S, or D): ");
        Scanner scannerObj = new Scanner(System.in);
        userDir = scannerObj.nextLine();
    }

    public boolean EndOfGame(){
        return endGame;
    }

    public void SnakeStartingPoint(){
        twoDimArray[10][10] = 'S';
        for (int i = 0; i<row; i++){
            System.out.println(twoDimArray[i]);
        }
    }

    public void SnakeBody(){
        if (twoDimArray[upDown][leftRight] == 'o') {
            endGame = true;
            endString = "You ran into yourself. YOU LOSE!";
        } else if (twoDimArray[upDown][leftRight] == '.') {
            twoDimArray[upDown][leftRight] = 'S';
        } else if (twoDimArray[upDown][leftRight] == 'x'){
            twoDimArray[upDown][leftRight] = 'S';
            scoreTally++;
            XPoints();
        }
    }

    public void SnakeOffBoard(){
        endGame = true;
        endString = "You went off the board. YOU LOSE!";
    }

    public void SnakeMoving() {
        switch (userDir.toLowerCase(Locale.ROOT)) {
            case "w" -> {
                upDown--;
                if (upDown < 20 && leftRight < 20 && upDown >= 0 && leftRight >= 0) {
                    twoDimArray[upDown + 1][leftRight] = 'o';
                    SnakeBody();
                } else {
                    SnakeOffBoard();
                }
            }
            case "d" -> {
                leftRight++;
                if (upDown < 20 && leftRight < 20 && upDown >= 0 && leftRight >= 0) {
                    twoDimArray[upDown][leftRight - 1] = 'o';
                    SnakeBody();
                } else {
                    SnakeOffBoard();
                }
            }
            case "s" -> {
                upDown++;
                if (upDown < 20 && leftRight < 20 && upDown >= 0 && leftRight >= 0) {
                    twoDimArray[upDown - 1][leftRight] = 'o';
                    SnakeBody();
                } else {
                    SnakeOffBoard();
                }
            }
            case "a" -> {
                leftRight--;
                if (upDown < 20 && leftRight < 20 && upDown >= 0 && leftRight >= 0) {
                    twoDimArray[upDown][leftRight + 1] = 'o';
                    SnakeBody();
                } else {
                    SnakeOffBoard();
                }
            }
            default -> {
                System.out.println("Please type W, D, S, or A.");
                UserInput();
            }
        }
    }



    public void SnakeGame(){
        UserInput();
        SnakeMoving();
        EndOfGame();
        if (endGame){
            System.out.println(endString);
            System.out.println("Final Score: " + scoreTally);
        }
        else {
            for (int i = 0; i < row; i++) {
                System.out.println(twoDimArray[i]);
            }
        }
    }
}
