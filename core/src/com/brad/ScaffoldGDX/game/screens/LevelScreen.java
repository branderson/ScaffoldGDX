package com.brad.ScaffoldGDX.game.screens;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.ScaffoldGDX;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;
import com.brad.ScaffoldGDX.framework.screen.GameScreen;
import com.brad.ScaffoldGDX.game.gameobjects.Target;
import com.brad.ScaffoldGDX.game.gameobjects.background.BackgroundNode;
import com.brad.ScaffoldGDX.game.gameobjects.snakenode.SnakeNode;

/**
 * Created by brad on 3/22/15.
 */
public class LevelScreen extends GameScreen
{
    public LevelScreen(ScaffoldGDX game, int tps, int fps, int xWidth, int yHeight) {
        super(game, tps, fps, xWidth, yHeight);
        renderer.addAtlas(new TextureAtlas(), "sprites/packed/game/game.atlas");
        renderer.addAtlas(new TextureAtlas(), "sprites/packed/env/env.atlas");
    }

    @Override
    public void show() {
        super.show();
        if (retrievedAssets) {
            buildLevel();
        }
    }

    private void buildLevel() {
        ObjectNode background = new ObjectNode();
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 30; j++) {
                ObjectNode backgroundNode = new BackgroundNode(renderer.getAtlas("sprites/packed/env/env.atlas"));
                backgroundNode.getModel().setPosition(16 * i, 16 * j, -100);
                background.addChild(backgroundNode);
            }
        }
        world.setBackground(background);
        SnakeNode snake = new SnakeNode(renderer.getAtlas("sprites/packed/game/game.atlas"));
        snake.getModel().setPosition(16, 16, 100);
        world.getScene().addChild(snake);
        Target target = new Target(renderer.getAtlas("sprites/packed/game/game.atlas"), "target");
        target.randomPosition();
        world.getScene().addChild(target);
    }
}
