package com.dxc.gameproject.controller;

import com.dxc.gameproject.model.Beer;
import com.dxc.gameproject.view.BeerView;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class BeerController extends Observable{
    private BeerView view;
    private Beer beer;

    public BeerController() {
        this.beer = new Beer(1,1);
        this.view = new BeerView();
        addObserver(beer);
    }


}
