package com.brad.ScaffoldGDX.game.screens;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.ScaffoldGDX;
import com.brad.ScaffoldGDX.framework.screen.GameScreen;

/**
 * Created by brad on 3/22/15.
 */
public class MainGameScreen extends GameScreen
{
    private TextureAtlas gameAtlas;

    public MainGameScreen(ScaffoldGDX game, int tps, int fps, int xWidth, int yHeight) {
        super(game, tps, fps, xWidth, yHeight);
        renderer.addAtlas(new TextureAtlas(), "sprites/packed/game/game.atlas");
    }
}
