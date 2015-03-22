package com.brad.SnakeGDX;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by brad on 3/20/15.
 */
public class GameWorld
{
    private Stage stage;

    public GameWorld(int xWidth, int yHeight) {
        stage = new Stage(new FitViewport(xWidth, yHeight));
    }

    public void update() {
        stage.act();
    }

    public Stage getStage() {
        return stage;
    }
}
