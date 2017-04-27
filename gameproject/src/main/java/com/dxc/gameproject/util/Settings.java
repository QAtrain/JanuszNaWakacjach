package com.dxc.gameproject.util;

import org.omg.CORBA.TIMEOUT;

/**
 * Created by ratamari on 27.04.2017.
 */
public enum Settings {
    LIFES(3),
    TIME(1000),
    POSITION_X(10),
    POSITION_Y(10);

    private final Integer value;

    private Settings(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
