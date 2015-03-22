package com.brad.SnakeGDX.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.brad.SnakeGDX.SnakeGDX;

import java.util.LinkedList;

/**
 * Created by brad on 3/16/15.
 */
public class LoadingScreen extends AbstractScreen
{
    protected Screen callingScreen;
    private Stage stage;

    public LoadingScreen(SnakeGDX game, Screen screen) {
        super(game);
        this.callingScreen = screen;
    }

    @Override
    public void show() {
        game.manager.load("sprite/loadScreen.jpg", Texture.class);
        game.manager.finishLoading();

        Image loadSprite = new Image(game.manager.get("sprite/loadScreen.jpg", Texture.class));
        stage = new Stage();

        stage.addActor(loadSprite);
    }

    public void load(LinkedList <String> textures) {
        for (String texture : textures) {
            game.manager.load(texture, Texture.class);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if (game.manager.update()) {
            game.setScreen(callingScreen);
        }
    }

    @Override
    public void hide() {
        game.manager.unload("sprite/loadScreen.jpg");
    }
}
