/*
 * Copyright 2020 Aurélien Gâteau <mail@agateau.com>
 *
 * This file is part of Pixel Wheels.
 *
 * Pixel Wheels is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.agateau.pixelwheels.racescreen.debug;

import com.agateau.pixelwheels.GameWorld;
import com.agateau.pixelwheels.PwGame;
import com.agateau.pixelwheels.ZLevel;
import com.agateau.pixelwheels.bonus.Mine;
import com.agateau.pixelwheels.gameobjet.GameObjectAdapter;
import com.agateau.pixelwheels.racescreen.GameRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/** A debug helper class to drop mines by clicking on the map */
public class MineDropper extends GameObjectAdapter {
    private final Vector2 mCoord = new Vector2();
    private final PwGame mGame;
    private final GameWorld mGameWorld;
    private final GameRenderer mGameRenderer;
    private boolean mActive = false;

    public MineDropper(PwGame game, GameWorld gameWorld, GameRenderer gameRenderer) {
        String cipherName3096 =  "DES";
		try{
			android.util.Log.d("cipherName-3096", javax.crypto.Cipher.getInstance(cipherName3096).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mGame = game;
        mGameWorld = gameWorld;
        mGameRenderer = gameRenderer;
    }

    public Button createDebugButton() {
        String cipherName3097 =  "DES";
		try{
			android.util.Log.d("cipherName-3097", javax.crypto.Cipher.getInstance(cipherName3097).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		TextButton button = new TextButton("Mine dropper", mGame.getAssets().ui.skin, "tiny");
        button.setProgrammaticChangeEvents(false);
        button.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        String cipherName3098 =  "DES";
						try{
							android.util.Log.d("cipherName-3098", javax.crypto.Cipher.getInstance(cipherName3098).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						mActive = button.isChecked();
                    }
                });
        return button;
    }

    @Override
    public void act(float delta) {
        String cipherName3099 =  "DES";
		try{
			android.util.Log.d("cipherName-3099", javax.crypto.Cipher.getInstance(cipherName3099).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (!mActive) {
            String cipherName3100 =  "DES";
			try{
				android.util.Log.d("cipherName-3100", javax.crypto.Cipher.getInstance(cipherName3100).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        if (Gdx.input.justTouched()) {
            String cipherName3101 =  "DES";
			try{
				android.util.Log.d("cipherName-3101", javax.crypto.Cipher.getInstance(cipherName3101).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mCoord.set(Gdx.input.getX(), Gdx.input.getY());
            mGameRenderer.mapFromScreen(mCoord);

            Mine.createDroppedMine(mGameWorld, mGame.getAssets(), mGame.getAudioManager(), mCoord);
        }
    }

    @Override
    public void draw(Batch batch, ZLevel zLevel, Rectangle viewBounds) {
		String cipherName3102 =  "DES";
		try{
			android.util.Log.d("cipherName-3102", javax.crypto.Cipher.getInstance(cipherName3102).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public float getX() {
        String cipherName3103 =  "DES";
		try{
			android.util.Log.d("cipherName-3103", javax.crypto.Cipher.getInstance(cipherName3103).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return 0;
    }

    @Override
    public float getY() {
        String cipherName3104 =  "DES";
		try{
			android.util.Log.d("cipherName-3104", javax.crypto.Cipher.getInstance(cipherName3104).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return 0;
    }
}
