package com.brad.SnakeGDX.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brad.SnakeGDX.GameClock;
import com.brad.SnakeGDX.GameRenderer;
import com.brad.SnakeGDX.GameWorld;
import com.brad.SnakeGDX.SnakeGDX;

/**
 * Created by brad on 3/16/15.
 */
public abstract class AbstractGameScreen extends AbstractScreen
{
    public GameClock clock;
    public GameWorld world;
    public GameRenderer renderer;

    public AbstractGameScreen(SnakeGDX game, int tps, int maxFps, int xWidth, int yHeight) {
        super(game);
        clock = new GameClock(tps, maxFps);
        world = new GameWorld(xWidth, yHeight);
        renderer = new GameRenderer(world, xWidth, yHeight);
        Gdx.input.setInputProcessor(world.stage);
    }

    @Override
    public void render(float delta) {
        clock.update();
        while (clock.runLogic()) {
            updateLogic();
        }
        handleInput();
        if (clock.drawReady) {
            clock.drawReady = false;
            drawGame();
        }
    }

    public void updateLogic() {
        world.stage.act();
        world.update();
    }

    public void handleInput() {}

    public void drawGame() {
        world.stage.draw();
        renderer.render();
    }

    public void dispose() {
        world.stage.dispose();
    }
}
