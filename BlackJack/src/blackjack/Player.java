package blackjack;
import java.util.*;

public class Player {
    private   String name;
    private int score;
    public Card[] hand = new Card[11];



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int update_score(int x) {
       score += x;
        return score;
    }

}
