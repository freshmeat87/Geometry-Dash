package com.freshmeat.gd;

import com.freshmeat.gd.core.AbstractScene;
import com.freshmeat.gd.input.KeyListener;
import com.freshmeat.gd.input.MouseListener;
import com.freshmeat.gd.scenes.LevelEditor;
import com.freshmeat.gd.util.Scene;
import com.freshmeat.gd.util.Time;

import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import static com.freshmeat.gd.config.Config.*;

public class Game extends JFrame implements Runnable {

    private Image doubleBufferImage;

    private Graphics2D doubleBufferGraphics;

    private MouseListener mouseListener;

    private KeyListener keyListener;

    private AbstractScene currentScene;

    private boolean isRunning;

    public Game() {
        mouseListener = new MouseListener();
        keyListener = new KeyListener();

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setTitle(SCREEN_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyListener);
        setLocationRelativeTo(null);

        changeScene(Scene.LevelEditor);
    }

    @Override
    public void run() {
        isRunning = true;
        double lastFrameTime = 0.0;

        // TODO fix game loop
        while (isRunning) {
            double time = Time.getElapsedTime();
            double dt = time - lastFrameTime;
            lastFrameTime = time;

            update(dt);
            draw(getGraphics());
        }
    }

    public void update(double dt) {
        currentScene.update(dt);
    }

    public void draw(Graphics g) {
        if (doubleBufferImage == null) {
            doubleBufferImage = createImage(getWidth(), getHeight());
            doubleBufferGraphics = (Graphics2D) doubleBufferImage.getGraphics();
        }
        renderOffScreen(doubleBufferGraphics);
        g.drawImage(doubleBufferImage, 0, 0,getWidth(), getHeight(), null);
    }

    public void renderOffScreen(Graphics2D g2) {
        currentScene.draw(g2);
    }

    public void changeScene(Scene scene) {
        switch (scene) {
            case LevelEditor:
                currentScene = new LevelEditor();
                break;
            default:
                throw new RuntimeException("No scene matching");
        }
    }

    public void startThread(String threadName) {
        Thread thread = new Thread(this, threadName);
        thread.start();
    }

    public static void main(String[] args) {
        new Game().startThread("GameThread");
    }
}
