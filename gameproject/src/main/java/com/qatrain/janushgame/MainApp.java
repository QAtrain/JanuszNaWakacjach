package com.qatrain.janushgame;

import com.qatrain.janushgame.model.Game;
import com.qatrain.janushgame.model.Grid;
import com.qatrain.janushgame.model.Janush;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class starts the whole game.
 */
public class MainApp {

    public static void main(String... args) {

        new Game().play();

    }
}
