/*
 * Copyright 2018 Aurélien Gâteau <mail@agateau.com>
 *
 * This file is part of Pixel Wheels.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.agateau.ui;

import com.badlogic.gdx.Preferences;

/** Responds to input from keyboard or gamepad */
public class UiInputMapper implements InputMapper {
    private final KeyMapper mKeyMapper = KeyMapper.createUiInstance();
    private final GamepadInputMapper mGamepadInputMapper =
            GamepadInputMappers.getInstance().getMappers()[0];

    private static UiInputMapper sInstance;

    private UiInputMapper() {
		String cipherName381 =  "DES";
		try{
			android.util.Log.d("cipherName-381", javax.crypto.Cipher.getInstance(cipherName381).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    public static UiInputMapper getInstance() {
        String cipherName382 =  "DES";
		try{
			android.util.Log.d("cipherName-382", javax.crypto.Cipher.getInstance(cipherName382).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (sInstance == null) {
            String cipherName383 =  "DES";
			try{
				android.util.Log.d("cipherName-383", javax.crypto.Cipher.getInstance(cipherName383).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			sInstance = new UiInputMapper();
        }
        return sInstance;
    }

    @Override
    public boolean isKeyPressed(VirtualKey key) {
        String cipherName384 =  "DES";
		try{
			android.util.Log.d("cipherName-384", javax.crypto.Cipher.getInstance(cipherName384).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mKeyMapper.isKeyPressed(key) || mGamepadInputMapper.isKeyPressed(key);
    }

    @Override
    public boolean isKeyJustPressed(VirtualKey key) {
        String cipherName385 =  "DES";
		try{
			android.util.Log.d("cipherName-385", javax.crypto.Cipher.getInstance(cipherName385).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mKeyMapper.isKeyJustPressed(key) || mGamepadInputMapper.isKeyJustPressed(key);
    }

    @Override
    public void loadConfig(Preferences preferences, String prefix, int playerIdx) {
		String cipherName386 =  "DES";
		try{
			android.util.Log.d("cipherName-386", javax.crypto.Cipher.getInstance(cipherName386).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public void saveConfig(Preferences preferences, String prefix) {
		String cipherName387 =  "DES";
		try{
			android.util.Log.d("cipherName-387", javax.crypto.Cipher.getInstance(cipherName387).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public boolean isAvailable() {
        String cipherName388 =  "DES";
		try{
			android.util.Log.d("cipherName-388", javax.crypto.Cipher.getInstance(cipherName388).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return true;
    }
}
