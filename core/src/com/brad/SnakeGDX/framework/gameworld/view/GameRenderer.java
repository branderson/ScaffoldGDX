package com.brad.SnakeGDX.framework.gameworld.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.brad.SnakeGDX.SnakeGDX;
import com.brad.SnakeGDX.framework.gameworld.ObjectNode;
import com.brad.SnakeGDX.framework.gameworld.model.GameWorld;
import com.brad.SnakeGDX.framework.gameworld.SceneNode;
import com.brad.SnakeGDX.framework.screen.LoadingScreen;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by brad on 3/20/15.
 */
public class GameRenderer
{
    GameWorld world;
    ObjectNode scene;
    OrthographicCamera camera;
    FitViewport viewport;
    SpriteBatch batch;
    ViewLayer background;
    LinkedList<ViewLayer> layers;
    public HashMap<String, TextureAtlas> atlases;
    public HashMap<String, Texture> textures;

    public GameRenderer(GameWorld world, int viewportWidth, int viewportHeight) {
        this.world = world;
        scene = world.getScene();
        camera = new OrthographicCamera();
        viewport = new FitViewport(viewportWidth, viewportHeight, camera);
        batch = new SpriteBatch();
        background = new ViewLayer();
//        layers = new LinkedList<ViewLayer>();
        atlases = new HashMap<String, TextureAtlas>();
        textures = new HashMap<String, Texture>();
    }

    // TODO: Add way to set background

    public void addAtlas(TextureAtlas atlas, String filename) {
        atlases.put(filename, atlas);
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
        for (ViewObject node : background) {
            node.draw(batch);
        }
        batch.enableBlending();
        for (ObjectNode node : scene.getOrderedObjectNodes()) {
            node.view.draw(batch);
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
