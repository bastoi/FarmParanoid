package org.cervellpixelat.farmparanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.Input.Keys;

public class Player extends Actor {

    private int vel = 50;
    private Sprite sp;
    private TextureRegion mapSprite;
    private float stateTime = 0f;
    private float animInterval = 0.25f;
    private Animation walkAnim;
    private int playerWidth = 64, playerHeight = 64;

    public Player (String name, int xpos, int ypos) {
	super(name);
	Texture t = new Texture(Gdx.files.classpath("sprites/sprite.png"));
	mapSprite = new TextureRegion(t, playerWidth, playerHeight);
	sp = new Sprite (mapSprite);
	float scaleFactor = 1f;
	//sp.scale(scaleFactor);
	//sp.setOrigin(xpos*scaleFactor, ypos*scaleFactor); // Per adaptar-nos a l'escalat
	sp.setPosition(xpos, ypos);

	//Generar totes les animacions del personatge !!!
	TextureRegion[][] tmp = TextureRegion.split(t,playerWidth, playerHeight);
	walkAnim = new Animation(animInterval, tmp[0]);
    }
    
    @Override
	public void act(float delta) {
	stateTime += delta;

	if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)){
	    sp.translateX(delta * vel);
	    TextureRegion tmp = walkAnim.getKeyFrame(stateTime, true);
	    if (tmp.getRegionWidth() != playerWidth) tmp.flip(true, false);
	    sp.setRegion(tmp);
	}
	else if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
	    sp.translateX(delta * -1 * vel);
	    TextureRegion tmp = walkAnim.getKeyFrame(stateTime, true);
	    if (tmp.getRegionWidth() != -playerWidth) tmp.flip(true, false);
	    sp.setRegion(tmp);
	}
    }
    @Override
	public void action(Action action) {
    }
    @Override
	public void clearActions() {
    }
    public void draw (SpriteBatch batch, float parentAlpha) {
	sp.draw(batch, parentAlpha);
    }
    public Actor hit(float x, float y) {
	return null;
    }
}