package com.brad.SnakeGDX;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by brad on 3/20/15.
 */
public class GameRenderer
{
    GameWorld world;
    Stage stage;
    OrthographicCamera camera;

    public GameRenderer(GameWorld world, int viewportWidth, int viewportHeight) {
        this.world = world;
        this.stage = world.getStage();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, viewportWidth, viewportHeight);
        stage.getViewport().setCamera(this.camera);
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }
}
