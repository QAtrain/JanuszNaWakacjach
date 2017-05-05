package com.qatrain.janushgame.controller;

import com.qatrain.janushgame.model.Beer;
import com.qatrain.janushgame.view.BeerView;

import java.util.Observable;

/**
 * Created by ratamari on 27.04.2017.
 */
public class BeerController extends Observable{
    private BeerView view;
    private Beer beer;

    public BeerController() {
        this.beer = new Beer(1,1);
        this.view = new BeerView();
        addObserver(beer);
    }


}
