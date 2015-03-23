package com.brad.ScaffoldGDX.framework.screen;

import com.brad.ScaffoldGDX.framework.GameClock;
import com.brad.ScaffoldGDX.framework.gameworld.view.GameRenderer;
import com.brad.ScaffoldGDX.framework.gameworld.model.GameWorld;

/**
 * Created by brad on 3/16/15.
 */
public class GameScreen extends AbstractScreen
{
    public GameClock clock;
    public GameWorld world;
    public GameRenderer renderer;
    public boolean loadedAssets;

    public GameScreen(SnakeGDX game, int tps, int maxFps, int xWidth, int yHeight) {
        super(game);
        clock = new GameClock(tps, maxFps);
        world = new GameWorld(xWidth, yHeight);
        renderer = new GameRenderer(world, xWidth, yHeight);
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
        world.update();
    }

    public void handleInput() {}

    public void drawGame() {
        renderer.render();
    }

    @Override
    public void show() {
        super.show();
        if (!loadedAssets) {
            LoadingScreen loadingScreen = new LoadingScreen(game, this);
            renderer.loadAssets(loadingScreen);
            loadedAssets = true;
            game.setScreen(loadingScreen);
        } else {
            renderer.retrieveAssets(game.manager);
        }
    }

    @Override
    public void hide() {
        super.hide();
    }

    public void dispose() {
        renderer.dispose();
    }
}