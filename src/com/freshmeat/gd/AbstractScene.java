package com.freshmeat.gd;

import java.awt.Graphics2D;

public abstract class AbstractScene {

    public abstract void init();

    public abstract void update(double dt);

    public abstract void draw(Graphics2D g2);
}