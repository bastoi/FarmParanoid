package org.cervellpixelat.farmparanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.Input.Keys;

public class FarmParanoid implements ApplicationListener {
    private SpriteBatch batch;
    private Stage stage;
    private Player p;
    private Background back;
    private int appHeight = 480, appWidth = 860;

    @Override
	public void create() {
	batch = new SpriteBatch();
	stage = new Stage(appWidth, appHeight, true, batch);
	p = new Player("Jugador", appWidth/2, 0);
	back = new Background("Fons");
	stage.addActor(back);
	stage.addActor(p);
    }
    @Override
	public void dispose() {}
    @Override
	public void pause() {}
    @Override
	public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	stage.draw();
	stage.act(Gdx.graphics.getDeltaTime());
    }
    @Override
	public void resize(int width, int height) {
	//stage.setViewport(width, height, true);
    }
    @Override
	public void resume() {}
}