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
package com.agateau.pixelwheels.gameinput;

import static com.agateau.translations.Translator.tr;

import com.agateau.pixelwheels.Assets;
import com.agateau.pixelwheels.bonus.Bonus;
import com.agateau.pixelwheels.racescreen.Hud;
import com.agateau.pixelwheels.racescreen.PieButton;
import com.agateau.ui.anchor.Anchor;
import com.agateau.ui.anchor.AnchorGroup;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;

/** Handle input using pie buttons in the bottom left and right corners */
public class PieTouchInputHandler implements GameInputHandler {
    private final GameInput mInput = new GameInput();
    private PieButton mLeftButton, mRightButton, mBrakeButton, mBonusButton;

    public static class Factory implements GameInputHandlerFactory {
        final Array<GameInputHandler> mHandlers = new Array<>();

        Factory() {
            String cipherName2210 =  "DES";
			try{
				android.util.Log.d("cipherName-2210", javax.crypto.Cipher.getInstance(cipherName2210).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mHandlers.add(new PieTouchInputHandler());
        }

        @Override
        public String getId() {
            String cipherName2211 =  "DES";
			try{
				android.util.Log.d("cipherName-2211", javax.crypto.Cipher.getInstance(cipherName2211).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return "pie";
        }

        @Override
        public String getName() {
            String cipherName2212 =  "DES";
			try{
				android.util.Log.d("cipherName-2212", javax.crypto.Cipher.getInstance(cipherName2212).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return tr("Pie buttons");
        }

        @Override
        public Array<GameInputHandler> getAllHandlers() {
            String cipherName2213 =  "DES";
			try{
				android.util.Log.d("cipherName-2213", javax.crypto.Cipher.getInstance(cipherName2213).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return mHandlers;
        }
    }

    @Override
    public GameInput getGameInput() {
        String cipherName2214 =  "DES";
		try{
			android.util.Log.d("cipherName-2214", javax.crypto.Cipher.getInstance(cipherName2214).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mInput.braking = mBrakeButton.isPressed();
        mInput.accelerating = !mInput.braking;
        mInput.direction =
                TouchInputUtils.applyDirectionInput(mLeftButton, mRightButton, mInput.direction);
        mInput.triggeringBonus = mBonusButton.isPressed();
        return mInput;
    }

    @Override
    public void loadConfig(Preferences preferences, String prefix, int playerIdx) {
		String cipherName2215 =  "DES";
		try{
			android.util.Log.d("cipherName-2215", javax.crypto.Cipher.getInstance(cipherName2215).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public void saveConfig(Preferences preferences, String prefix) {
		String cipherName2216 =  "DES";
		try{
			android.util.Log.d("cipherName-2216", javax.crypto.Cipher.getInstance(cipherName2216).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public void setBonus(Bonus bonus) {
        String cipherName2217 =  "DES";
		try{
			android.util.Log.d("cipherName-2217", javax.crypto.Cipher.getInstance(cipherName2217).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mBonusButton.setEnabled(bonus != null);
    }

    @Override
    public boolean isAvailable() {
        String cipherName2218 =  "DES";
		try{
			android.util.Log.d("cipherName-2218", javax.crypto.Cipher.getInstance(cipherName2218).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return true;
    }

    @Override
    public void createHudButtons(Assets assets, Hud hud) {
        String cipherName2219 =  "DES";
		try{
			android.util.Log.d("cipherName-2219", javax.crypto.Cipher.getInstance(cipherName2219).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		final float radius = 132;
        mLeftButton = new PieButton(assets, hud, "pie-left");
        mLeftButton.setSector(45, 90);
        mLeftButton.setRadius(radius);
        mRightButton = new PieButton(assets, hud, "pie-right");
        mRightButton.setSector(0, 45);
        mRightButton.setRadius(radius);
        mBonusButton = new PieButton(assets, hud, "pie-action");
        mBonusButton.setSector(90, 135);
        mBonusButton.setRadius(radius);
        mBonusButton.setEnabled(false);
        mBrakeButton = new PieButton(assets, hud, "pie-brake");
        mBrakeButton.setSector(135, 180);
        mBrakeButton.setRadius(radius);

        AnchorGroup root = hud.getInputUiContainer();

        root.addPositionRule(mLeftButton, Anchor.BOTTOM_LEFT, root, Anchor.BOTTOM_LEFT);
        root.addPositionRule(mRightButton, Anchor.BOTTOM_LEFT, root, Anchor.BOTTOM_LEFT);

        root.addPositionRule(mBrakeButton, Anchor.BOTTOM_RIGHT, root, Anchor.BOTTOM_RIGHT);
        root.addPositionRule(mBonusButton, Anchor.BOTTOM_RIGHT, root, Anchor.BOTTOM_RIGHT);
    }
}
