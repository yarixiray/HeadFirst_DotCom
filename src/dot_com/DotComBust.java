package dot_com;

import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses;

    public void setUpGame(){
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom thee = new DotCom();

        one.setName("Titanic");
        two.setName("Black Meduza");
        thee.setName("Sea Wolf");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(thee);

        for (DotCom dotComToSet : dotComList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying(){
        while (!dotComList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Miss";
        for (int x = 0; x < dotComList.size(); x++) {
            result = dotComList.get(x).checkYourself(userGuess);
            if (result.equals("Kill")){
                dotComList.remove(x);
                break;
            }
            System.out.println(result);
        }
    }

    public void finishGame(){
        System.out.println("All Dot Coms are dead! You stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you");
            System.out.println("You got out");
        } else {
            System.out.println("Took you long enough");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
