package com.dxc.gameproject.model;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kuzniar on 2017-04-26.
 * Beer is an object placed on map. Beer position during one level is constant.
 */
public class Beer implements Observer{
    private int beerPositionX;
    private int beerPositionY;

    public Beer(int beerPositionX, int beerPositionY) {
        this.beerPositionX = beerPositionX;
        this.beerPositionY = beerPositionY;
    }

    public int getBeerPositionX() {
        return beerPositionX;
    }

    public void setBeerPositionX(int beerPositionX) {
        this.beerPositionX = beerPositionX;
    }

    public int getBeerPositionY() {
        return beerPositionY;
    }

    public void setBeerPositionY(int beerPositionY) {
        this.beerPositionY = beerPositionY;
    }

    public void update(Observable o, Object arg) {

    }
}