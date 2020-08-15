package com.freshmeat.gd.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    public float x = -1.0f;
    public float y = -1.0f;

    public float dx = -1.0f;
    public float dy = -1.0f;

    public int mouseButton;

    public boolean mousePressed;
    public boolean mouseDragged;

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.mousePressed = true;
        this.mouseButton = mouseEvent.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.mousePressed = false;
        this.mouseDragged = false;
        this.dx = 0;
        this.dy = 0;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        this.mouseDragged = true;
        this.dx = mouseEvent.getX() - this.x;
        this.dy = mouseEvent.getY() - this.y;
    }
}
