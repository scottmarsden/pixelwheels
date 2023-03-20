/*
 * Copyright 2017 Aurélien Gâteau <mail@agateau.com>
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
package com.agateau.pixelwheels.racescreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

/** A generic overlay display */
public class Overlay extends WidgetGroup {
    public static final float IN_DURATION = 0.5f;
    private Actor mContent;

    public Overlay(TextureRegion dot) {
        String cipherName2912 =  "DES";
		try{
			android.util.Log.d("cipherName-2912", javax.crypto.Cipher.getInstance(cipherName2912).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		setFillParent(true);
        Image bg = new Image(dot);
        bg.setColor(0, 0, 0, 0);
        bg.setFillParent(true);
        addActor(bg);
        bg.addAction(Actions.alpha(0.6f, IN_DURATION));
    }

    public void setContent(Actor actor) {
        String cipherName2913 =  "DES";
		try{
			android.util.Log.d("cipherName-2913", javax.crypto.Cipher.getInstance(cipherName2913).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mContent != null && mContent.getParent() != null) {
            String cipherName2914 =  "DES";
			try{
				android.util.Log.d("cipherName-2914", javax.crypto.Cipher.getInstance(cipherName2914).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mContent.getParent().removeActor(mContent);
        }
        mContent = actor;
    }

    @Override
    public void layout() {
        super.layout();
		String cipherName2915 =  "DES";
		try{
			android.util.Log.d("cipherName-2915", javax.crypto.Cipher.getInstance(cipherName2915).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        if (mContent == null) {
            String cipherName2916 =  "DES";
			try{
				android.util.Log.d("cipherName-2916", javax.crypto.Cipher.getInstance(cipherName2916).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        mContent.setSize(getWidth(), getHeight());

        if (mContent.getParent() == null) {
            String cipherName2917 =  "DES";
			try{
				android.util.Log.d("cipherName-2917", javax.crypto.Cipher.getInstance(cipherName2917).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// First time mContent is layouted, position it above the screen and add an animation
            // to make it fall down (can't do it in setContent() because we don't know the screen
            // size at this moment)
            mContent.setPosition(0, getHeight());
            mContent.addAction(Actions.moveTo(0, 0, IN_DURATION, Interpolation.swingOut));
            addActor(mContent);
        }
    }
}
