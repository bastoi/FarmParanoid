package org.cervellpixelat.farmparanoid;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class Game {
    public static void main (String[] args) {
	new JoglApplication(new FarmParanoid(), "Farm Paranoid", 860, 480, true);
    }
}