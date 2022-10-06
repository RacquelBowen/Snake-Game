package Program3;

public class Main {
    public static void main(String [] args){
        StartUp array = new StartUp();


        array.SnakeStartingPoint();
        while(!array.EndOfGame()){
            if(array.EndOfGame()){
                break;
            } else{
                array.SnakeGame();
            }
        }

    }

}
