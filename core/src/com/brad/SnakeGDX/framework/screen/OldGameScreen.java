package com.brad.SnakeGDX.framework.screen;

import com.badlogic.gdx.Gdx;
import com.brad.SnakeGDX.SnakeGDX;

import java.util.LinkedList;

/**
 * Created by brad on 3/16/15.
 */
public class OldGameScreen extends GameScreen
{
    public LinkedList<String> gameTextures;
    public boolean loadedAssets;
    private final int fps = 60;
    private final int tps = 60;

    public OldGameScreen(SnakeGDX game) {
        super(game, 60, 60, 320, 320);
        loadedAssets = false;
        gameTextures = new LinkedList<String>();
        gameTextures.add("sprites/bgr_grid.png");
        gameTextures.add("sprites/spr_SnakeNode_1.png");
        gameTextures.add("sprites/spr_Target_0.png");
    }

    public void show() {
        if (!loadedAssets) {
            LoadingScreen loadingScreen = new LoadingScreen(game, this);
            loadingScreen.load(gameTextures);
            loadedAssets = true;
            game.setScreen(loadingScreen);
        }
    }

    public void updateLogic() {
        Gdx.app.log("GameScreen", "Updating logic");
        super.updateLogic();
    }

    public void drawGame() {
        Gdx.app.log("GameScreen", "Drawing logic");
        super.drawGame();
//        camera.update();
//        batch.setProjectionMatrix(camera.combined);
//        batch.begin();
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//                batch.draw(game.manager.get("sprites/bgr_grid.png", Texture.class), 16 * i, 16 * j);
//            }
//        }
//        batch.end();
    }

    public void handleInput() {
    }

    public void dispose() {
        super.dispose();
    }
}
