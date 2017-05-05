package janushgame.dxc.janusznawakacjach.controller;

import janushgame.dxc.janusznawakacjach.model.Beer;
import janushgame.dxc.janusznawakacjach.view.BeerView;

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
