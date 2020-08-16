package com.freshmeat.gd.core;

import java.awt.Graphics2D;

public abstract class AbstractScene {

    public abstract void update(double dt);

    public abstract void draw(Graphics2D g2);
}
