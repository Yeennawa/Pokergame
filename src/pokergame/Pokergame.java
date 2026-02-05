package pokergame;

import java.util.Random;
import java.util.Scanner;

public class Pokergame {
    Player player = new Player();
    Bot bot = new Bot();
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    public void start() {
        while (player.isAlive() && bot.isAlive()) {

            player.total = draw() + draw();
            player.total %= 10;
            System.out.println("Player: " + player.total);

            System.out.println("จะเพิ่มใบที่ 3 ไหม (Y/N)");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("Y")) {
                player.total += draw();
                player.total %= 10;
                System.out.println("Player: " + player.total);
            }

            bot.total = draw() + draw();
            bot.total %= 10;

            if (bot.total < 4) {
                bot.total += draw();
                bot.total %= 10;
            }

            System.out.println("Bot: " + bot.total);

            if (player.total > bot.total) {
                bot.losehearts();
                System.out.println("รอบนี้ผู้เล่นชนะ");
            } else if (player.total < bot.total) {
                player.losehearts();
                System.out.println("รอบนี้บอทชนะ");
            } else {
                System.out.println("เสมอ");
            }

            System.out.println("------------------");
        }

        if (player.isAlive()) {
            System.out.println("YOU WIN THE GAME 🎉");
        } else {
            System.out.println("BOT WINS 🤖");
        }
    }

    public int draw(){
        return rand.nextInt(13)+1;
    }
}