package com.dxc.janusznawakacjach.controller;

import com.dxc.janusznawakacjach.model.Beer;
import com.dxc.janusznawakacjach.view.BeerView;

import java.util.Observable;

public class BeerController extends Observable{
    private BeerView view;
    private Beer beer;

    public BeerController() {
        this.beer = new Beer(1,1);
        this.view = new BeerView();
        addObserver(beer);
    }


}
