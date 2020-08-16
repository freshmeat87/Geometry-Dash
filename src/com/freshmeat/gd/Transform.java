package com.freshmeat.gd;

import com.freshmeat.gd.math.Vector2f;

public class Transform {

    public Vector2f position;
    public Vector2f scale;
    public Vector2f rotation;

    public Transform(Vector2f position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position(" + position.x + ", " + position.y +")";
    }
}
