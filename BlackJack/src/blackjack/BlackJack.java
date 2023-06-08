package blackjack;

import java.util.*;

public class BlackJack {
    static Game d = new Game();

    public static void main(String[] args) {
        GUI gui = new GUI();


        d.genrate();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("please enter the  players names");
            String name = input.next();
            d.set_info(name, i);
        }
        gui.runGUI(d.deck, d.players[0].hand,d.players[1].hand,d.players[2].hand,d.players[3].hand);

        for (int s = 0; s < 3; s++) {
            int k = 2;
            boolean conditon = true;
            while (conditon) {
                System.out.println("player" + (s + 1));
                System.out.println(d.players[s].getScore());
                System.out.println("hit= 1 or stand=2");
                int choice = input.nextInt();


                if (choice == 1) {

                    d.players[s].hand[k] = d.draw();
                    gui.updatePlayerHand(d.players[s].hand[k],s);
                    d.players[s].update_score(d.players[s].hand[k].getValue());
                    k++;

                    System.out.println(d.players[s].getScore());
                    if (d.players[s].getScore() > 21) {
                        System.out.println("player is busted");
                        conditon = false;
                    } else if (d.players[s].getScore() == 21) {
                        System.out.println("player got blackjack");
                        conditon = false;
                    }
                } else if (choice == 2) {
                    conditon = false;
                }

            }


        }
        d.update_max_score();

        while (true) {

            if (d.players[3].getScore() > d.highscore && d.players[3].getScore()<= 21) {
                d.highscore=d.players[3].getScore();
                break;
            } else if (d.players[3].getScore() < d.highscore&&d.players[3].getScore()<21) {
                int x = 2;
                d.players[3].hand[x] = d.draw();
                d.players[3].update_score(d.players[3].hand[x].getValue());
                gui.updateDealerHand(d.players[3].hand[x], d.deck);
                x++;

            } else if (d.players[3].getScore() > 21) {
                System.out.println("dealer is busted");
                break;

            }


        }
        int count = 0;
        int count_2 = 0;
        int loss=0;
        for (int i = 0; i < 4; i++) {

            if (d.players[i].getScore() == 21) {
                count++;
            }
            if (count > 1) {
                System.out.println("its a push");
                break;
            }


        }
        if (count == 1) {
            for (int i = 0; i < 4; i++) {
                if (d.players[i].getScore() == 21) {
                    System.out.println(d.players[i].getName() + " is the winner by blackjack " ) ;
                }

            }
        }
         else if(count == 0) {
            for (int i = 0; i < 4; i++) {
                if (d.players[i].getScore() == d.highscore) {
                    count_2++;
                }
                 if(count_2>1){
                     System.out.println("its a push");
                     break;
                 }


            }
                if (count_2==1){
                for (int j = 0; j < 4; j++) {
                    if(d.players[j].getScore()== d.highscore){
                        System.out.println(d.players[j].getName()+ " is the winner by highscore "  );
                    }

                }
            }


        }

        for (int i = 0; i < 4; i++) {
            if(d.players[i].getScore()>21){
                loss++;
            }
             if (loss==4){
                 System.out.println("no one won");
             }

        }
    }
}






