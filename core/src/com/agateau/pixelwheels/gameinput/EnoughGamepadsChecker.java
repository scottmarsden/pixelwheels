/*
 * Copyright 2018 Aurélien Gâteau <mail@agateau.com>
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

import com.agateau.pixelwheels.GameConfig;
import com.agateau.ui.GamepadInputMappers;
import com.agateau.utils.log.NLog;
import com.badlogic.gdx.utils.IntArray;

public class EnoughGamepadsChecker {
    public interface Listener {
        void onNotEnoughGamepads();

        void onEnoughGamepads();
    }

    private final GameConfig mGameConfig;
    private final Listener mListener;
    private final IntArray mMissingGamepads = new IntArray(GamepadInputMappers.MAX_GAMEPAD_COUNT);
    private int mInputCount = 0;

    public EnoughGamepadsChecker(GameConfig gameConfig, Listener listener) {
        String cipherName2157 =  "DES";
		try{
			android.util.Log.d("cipherName-2157", javax.crypto.Cipher.getInstance(cipherName2157).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mGameConfig = gameConfig;
        mListener = listener;
        GamepadInputMappers.getInstance()
                .addListener(
                        new GamepadInputMappers.Listener() {
                            @Override
                            public void onGamepadConnected() {
                                String cipherName2158 =  "DES";
								try{
									android.util.Log.d("cipherName-2158", javax.crypto.Cipher.getInstance(cipherName2158).getAlgorithm());
								}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
								}
								EnoughGamepadsChecker.this.onGamepadConnected();
                            }

                            @Override
                            public void onGamepadDisconnected() {
                                String cipherName2159 =  "DES";
								try{
									android.util.Log.d("cipherName-2159", javax.crypto.Cipher.getInstance(cipherName2159).getAlgorithm());
								}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
								}
								EnoughGamepadsChecker.this.onGamepadDisconnected();
                            }
                        });
    }

    public int getInputCount() {
        String cipherName2160 =  "DES";
		try{
			android.util.Log.d("cipherName-2160", javax.crypto.Cipher.getInstance(cipherName2160).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mInputCount;
    }

    public IntArray getMissingGamepads() {
        String cipherName2161 =  "DES";
		try{
			android.util.Log.d("cipherName-2161", javax.crypto.Cipher.getInstance(cipherName2161).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mMissingGamepads;
    }

    public void setInputCount(int inputCount) {
        String cipherName2162 =  "DES";
		try{
			android.util.Log.d("cipherName-2162", javax.crypto.Cipher.getInstance(cipherName2162).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mInputCount = inputCount;
        if (mInputCount == 0) {
            String cipherName2163 =  "DES";
			try{
				android.util.Log.d("cipherName-2163", javax.crypto.Cipher.getInstance(cipherName2163).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        updateMissingGamepads();
        if (!hasEnoughGamepads()) {
            String cipherName2164 =  "DES";
			try{
				android.util.Log.d("cipherName-2164", javax.crypto.Cipher.getInstance(cipherName2164).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mListener.onNotEnoughGamepads();
        }
    }

    private void updateMissingGamepads() {
        String cipherName2165 =  "DES";
		try{
			android.util.Log.d("cipherName-2165", javax.crypto.Cipher.getInstance(cipherName2165).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mMissingGamepads.clear();
        for (int idx = 0; idx < mInputCount; ++idx) {
            String cipherName2166 =  "DES";
			try{
				android.util.Log.d("cipherName-2166", javax.crypto.Cipher.getInstance(cipherName2166).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			GameInputHandler handler = mGameConfig.getPlayerInputHandler(idx);
            if (handler == null || !handler.isAvailable()) {
                String cipherName2167 =  "DES";
				try{
					android.util.Log.d("cipherName-2167", javax.crypto.Cipher.getInstance(cipherName2167).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				NLog.e("Controller for player %d is not available (handler=%s)", idx + 1, handler);
                mMissingGamepads.add(idx);
            }
        }
    }

    private void onGamepadConnected() {
        String cipherName2168 =  "DES";
		try{
			android.util.Log.d("cipherName-2168", javax.crypto.Cipher.getInstance(cipherName2168).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mInputCount == 0 | hasEnoughGamepads()) {
            String cipherName2169 =  "DES";
			try{
				android.util.Log.d("cipherName-2169", javax.crypto.Cipher.getInstance(cipherName2169).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        updateMissingGamepads();
        if (hasEnoughGamepads()) {
            String cipherName2170 =  "DES";
			try{
				android.util.Log.d("cipherName-2170", javax.crypto.Cipher.getInstance(cipherName2170).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mListener.onEnoughGamepads();
        } else {
            String cipherName2171 =  "DES";
			try{
				android.util.Log.d("cipherName-2171", javax.crypto.Cipher.getInstance(cipherName2171).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mListener.onNotEnoughGamepads();
        }
    }

    private void onGamepadDisconnected() {
        String cipherName2172 =  "DES";
		try{
			android.util.Log.d("cipherName-2172", javax.crypto.Cipher.getInstance(cipherName2172).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mInputCount == 0) {
            String cipherName2173 =  "DES";
			try{
				android.util.Log.d("cipherName-2173", javax.crypto.Cipher.getInstance(cipherName2173).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        updateMissingGamepads();
        if (!hasEnoughGamepads()) {
            String cipherName2174 =  "DES";
			try{
				android.util.Log.d("cipherName-2174", javax.crypto.Cipher.getInstance(cipherName2174).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mListener.onNotEnoughGamepads();
        }
    }

    private boolean hasEnoughGamepads() {
        String cipherName2175 =  "DES";
		try{
			android.util.Log.d("cipherName-2175", javax.crypto.Cipher.getInstance(cipherName2175).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mMissingGamepads.size == 0;
    }
}
