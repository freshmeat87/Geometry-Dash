package com.freshmeat.gd.scenes;

import com.freshmeat.gd.Transform;
import com.freshmeat.gd.components.BoxBounds;
import com.freshmeat.gd.core.AbstractScene;
import com.freshmeat.gd.core.GameObject;
import com.freshmeat.gd.math.Vector2f;

import java.awt.Color;
import java.awt.Graphics2D;

import static com.freshmeat.gd.config.Config.*;

public class LevelEditor extends AbstractScene {

    GameObject testObj;

    public LevelEditor() {
        testObj = new GameObject("some gameObject", new Transform(new Vector2f(0.0f, 0.0f)));
        testObj.addComponent(new BoxBounds("Box"));
    }

    @Override
    public void update(double dt) {
        System.out.println(testObj.getComponent(BoxBounds.class).name);
        testObj.update(dt);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
