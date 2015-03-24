package com.brad.ScaffoldGDX.framework.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;
import com.brad.ScaffoldGDX.framework.gameobjects.SceneNode;
import com.brad.ScaffoldGDX.framework.screen.LoadingScreen;

import java.util.HashMap;

/**
 * Created by brad on 3/20/15.
 */
public class GameRenderer
{
    public ObjectNode background;
    public HashMap<String, TextureAtlas> atlases;
    public HashMap<String, Texture> textures;
    GameWorld world;
    OrthographicCamera camera;
    FitViewport viewport;
    SpriteBatch batch;

    public GameRenderer(GameWorld world, SpriteBatch batch, int viewportWidth, int viewportHeight) {
        this.world = world;
        camera = new OrthographicCamera();
        viewport = new FitViewport(viewportWidth, viewportHeight, camera);
        this.batch = batch;
        atlases = new HashMap<String, TextureAtlas>();
        textures = new HashMap<String, Texture>();
    }

    public void addAtlas(TextureAtlas atlas, String filename) {
        atlases.put(filename, atlas);
    }

    public TextureAtlas getAtlas(String filename) {
        return atlases.get(filename);
    }

    public void addTexture(Texture texture, String filename) {
        textures.put(filename, texture);
    }

    public void loadAssets(LoadingScreen loadingScreen) {
        loadingScreen.loadAtlases(atlases);
        loadingScreen.loadTextures(textures);
    }

    public void retrieveAssets(AssetManager manager) {
        retrieveAtlases(manager, atlases);
        retrieveTextures(manager, textures);
    }

    public void retrieveAtlases(AssetManager manager, HashMap<String, TextureAtlas> atlases) {
        for (String atlas : atlases.keySet()) {
            TextureAtlas loadedAtlas = manager.get(atlas);
            atlases.put(atlas, loadedAtlas);
        }
    }

    public void retrieveTextures(AssetManager manager, HashMap<String, Texture> textures) {
        for (String texture : textures.keySet()) {
            Texture loadedTexture = manager.get(texture);
            textures.put(texture, loadedTexture);
        }
    }

    public void render() {
        // Clear the screen (necessary for performance)
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the layers
        batch.begin();
        batch.disableBlending();
        for (SceneNode node : world.getBackground().getOrderedObjectNodes()) {
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.getView().draw(batch);
        }
        batch.enableBlending();
        for (SceneNode node : world.getScene().getOrderedObjectNodes()) {
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.getView().draw(batch);
        }
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        for (TextureAtlas atlas : atlases.values()) {
            atlas.dispose();
        }
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
    }
}
