package blackjack;
import java.util.*;
public class Game {

        public Player[] players = new Player[4];
        public Card[] deck = new Card[52];
        public int highscore =0;


        public void genrate () {
            int index = 0;
            for (int suit = 0; suit <= 3; suit++) {
                int value = 1;
                for (int rank = 0 ;rank < 13; rank++) {
                    deck[index] = new Card(suit, rank, value);
                    index++;
                    if (value != 10) {
                        value++;
                    }
                }
            }

        }

        public Card draw(){
         Random rand=new Random();
         int random=rand.nextInt(52);
         while(deck[random]==null){
             random=rand.nextInt(52);
         }
         Card drawn= deck[random];
         deck[random]=null;
        return drawn;
    }
        public void set_info(String name,int index ){
       players[index] = new Player();
       players[index].setName(name);
       players[index].hand[0]=draw();
       players[index].hand[1]=draw();
       players[index].setScore((players[index].hand[0].getValue()+players[index].hand[1].getValue()));

       }
 public void update_max_score(){

        for (int i=0;i<3;i++){

            if (highscore<players[i].getScore()&&players[i].getScore()<=21){
                highscore=players[i].getScore();
            }

        }
    
        }

    }


