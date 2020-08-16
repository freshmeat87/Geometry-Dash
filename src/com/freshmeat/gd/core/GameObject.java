package com.freshmeat.gd.core;

import com.freshmeat.gd.Transform;
import com.freshmeat.gd.core.Component;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private List<Component> components;
    private String name;
    private Transform transform;

    public GameObject(String name, Transform transform) {
        this.name = name;
        this.transform = transform;
        this.components = new ArrayList<>();
    }

    public void update(double dt) {
        components.forEach(c -> c.update(dt));
    }

    public void addComponent(Component c) {
        components.add(c);
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component c : components) {
            if (componentClass.isAssignableFrom(c.getClass())) {
                return componentClass.cast(c);
            }
        }
        return null;
    }

}
