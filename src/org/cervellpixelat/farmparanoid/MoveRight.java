package org.cervellpixelat.farmparanoid;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MoveRight extends Action {
    @Override
	public void act(float delta) {}
    @Override
	public Action copy() {
	return this;
    }
    @Override
	public Actor getTarget() {
	return null;
    }
    @Override
	public boolean isDone() {
	return true;
    }
    @Override
	public void setTarget(Actor actor) {
    }
}