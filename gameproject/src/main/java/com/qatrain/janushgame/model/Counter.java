package com.qatrain.janushgame.model;

import java.util.Timer;
import java.util.TimerTask;

public class Counter {
    Timer timer;
    int gameCounter = 0;

    //konstruktor
    public Counter() {
        timer = new Timer();
        timer.schedule(new Task(), 0, 10000);
    }

    class Task extends TimerTask {
        @Override
        public void run() {
            gameCounter++;
            System.out.println(gameCounter);
            Game game = new Game();
            game.play();
            if (gameCounter == 3) {
                timer.cancel();
            }
        }
    }
}
