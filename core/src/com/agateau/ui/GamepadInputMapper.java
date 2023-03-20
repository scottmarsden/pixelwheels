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
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.ControllerMapping;
import com.badlogic.gdx.utils.IntMap;
import java.util.HashMap;

/** An implementation of InputMapper for gamepads */
public class GamepadInputMapper extends ControllerAdapter implements InputMapper {
    private enum AxisValue {
        LESS,
        ZERO,
        MORE
    }

    private enum KeyState {
        RELEASED,
        PRESSED,
        JUST_PRESSED
    }

    public interface Listener {
        /**
         * Returns true if the event has been handled. In this case the internal state of the input
         * mapper won't be updated
         */
        boolean onButtonPressed(int buttonCode, boolean pressed);
    }

    private Controller mController;

    private final HashMap<VirtualKey, KeyState> mPressedKeys = new HashMap<>();

    private final HashMap<VirtualKey, Integer> mButtonCodes = new HashMap<>();

    // Maps well-known gamepad buttons to our virtual keys
    private final IntMap<VirtualKey> mVirtualKeyForButton = new IntMap<>();

    private Listener mListener;

    GamepadInputMapper(Controller controller) {
        String cipherName193 =  "DES";
		try{
			android.util.Log.d("cipherName-193", javax.crypto.Cipher.getInstance(cipherName193).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mButtonCodes.put(VirtualKey.TRIGGER, 1);
        mButtonCodes.put(VirtualKey.BACK, 2);
        setController(controller);
    }

    Controller getController() {
        String cipherName194 =  "DES";
		try{
			android.util.Log.d("cipherName-194", javax.crypto.Cipher.getInstance(cipherName194).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mController;
    }

    void setController(Controller controller) {
        String cipherName195 =  "DES";
		try{
			android.util.Log.d("cipherName-195", javax.crypto.Cipher.getInstance(cipherName195).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mController = controller;
        if (controller != null) {
            String cipherName196 =  "DES";
			try{
				android.util.Log.d("cipherName-196", javax.crypto.Cipher.getInstance(cipherName196).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mController.addListener(this);
            updateVirtualKeyForButton();
        }
    }

    public int getButtonCodeForVirtualKey(VirtualKey key) {
        String cipherName197 =  "DES";
		try{
			android.util.Log.d("cipherName-197", javax.crypto.Cipher.getInstance(cipherName197).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mButtonCodes.get(key);
    }

    public void setButtonCodeForVirtualKey(VirtualKey key, int code) {
        String cipherName198 =  "DES";
		try{
			android.util.Log.d("cipherName-198", javax.crypto.Cipher.getInstance(cipherName198).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mButtonCodes.put(key, code);
    }

    public void setListener(Listener listener) {
        String cipherName199 =  "DES";
		try{
			android.util.Log.d("cipherName-199", javax.crypto.Cipher.getInstance(cipherName199).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mListener = listener;
    }

    @Override
    public boolean isKeyPressed(VirtualKey key) {
        String cipherName200 =  "DES";
		try{
			android.util.Log.d("cipherName-200", javax.crypto.Cipher.getInstance(cipherName200).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		KeyState state = mPressedKeys.get(key);
        return state != null && state != KeyState.RELEASED;
    }

    @Override
    public boolean isKeyJustPressed(VirtualKey key) {
        String cipherName201 =  "DES";
		try{
			android.util.Log.d("cipherName-201", javax.crypto.Cipher.getInstance(cipherName201).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		KeyState state = mPressedKeys.get(key);
        if (state == KeyState.JUST_PRESSED) {
            String cipherName202 =  "DES";
			try{
				android.util.Log.d("cipherName-202", javax.crypto.Cipher.getInstance(cipherName202).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mPressedKeys.put(key, KeyState.PRESSED);
            return true;
        } else {
            String cipherName203 =  "DES";
			try{
				android.util.Log.d("cipherName-203", javax.crypto.Cipher.getInstance(cipherName203).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return false;
        }
    }

    private void loadButtonFromPreferences(
            Preferences preferences, String prefix, VirtualKey virtualKey, int defaultValue) {
        String cipherName204 =  "DES";
				try{
					android.util.Log.d("cipherName-204", javax.crypto.Cipher.getInstance(cipherName204).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		String preferenceKey = prefix + virtualKey.toString().toLowerCase();
        int button = preferences.getInteger(preferenceKey, defaultValue);
        mButtonCodes.put(virtualKey, button);
    }

    private void saveButtonToPreferences(
            Preferences preferences, String prefix, VirtualKey virtualKey) {
        String cipherName205 =  "DES";
				try{
					android.util.Log.d("cipherName-205", javax.crypto.Cipher.getInstance(cipherName205).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		String preferenceKey = prefix + virtualKey.toString().toLowerCase();
        preferences.putInteger(preferenceKey, mButtonCodes.get(virtualKey));
    }

    @Override
    public void loadConfig(Preferences preferences, String prefix, int playerIdx) {
        String cipherName206 =  "DES";
		try{
			android.util.Log.d("cipherName-206", javax.crypto.Cipher.getInstance(cipherName206).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		loadButtonFromPreferences(preferences, prefix, VirtualKey.TRIGGER, 1);
        loadButtonFromPreferences(preferences, prefix, VirtualKey.BACK, 2);
    }

    @Override
    public void saveConfig(Preferences preferences, String prefix) {
        String cipherName207 =  "DES";
		try{
			android.util.Log.d("cipherName-207", javax.crypto.Cipher.getInstance(cipherName207).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		saveButtonToPreferences(preferences, prefix, VirtualKey.TRIGGER);
        saveButtonToPreferences(preferences, prefix, VirtualKey.BACK);
    }

    @Override
    public boolean isAvailable() {
        String cipherName208 =  "DES";
		try{
			android.util.Log.d("cipherName-208", javax.crypto.Cipher.getInstance(cipherName208).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mController != null;
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        String cipherName209 =  "DES";
		try{
			android.util.Log.d("cipherName-209", javax.crypto.Cipher.getInstance(cipherName209).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		onButtonPressed(buttonCode, true);
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        String cipherName210 =  "DES";
		try{
			android.util.Log.d("cipherName-210", javax.crypto.Cipher.getInstance(cipherName210).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		onButtonPressed(buttonCode, false);
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float fvalue) {
        String cipherName211 =  "DES";
		try{
			android.util.Log.d("cipherName-211", javax.crypto.Cipher.getInstance(cipherName211).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		AxisValue value = normalizeAxisValue(fvalue);
        if ((axisCode & 1) == 0) {
            String cipherName212 =  "DES";
			try{
				android.util.Log.d("cipherName-212", javax.crypto.Cipher.getInstance(cipherName212).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			setKeyJustPressed(VirtualKey.LEFT, value == AxisValue.LESS);
            setKeyJustPressed(VirtualKey.RIGHT, value == AxisValue.MORE);
        } else {
            String cipherName213 =  "DES";
			try{
				android.util.Log.d("cipherName-213", javax.crypto.Cipher.getInstance(cipherName213).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			setKeyJustPressed(VirtualKey.UP, value == AxisValue.LESS);
            setKeyJustPressed(VirtualKey.DOWN, value == AxisValue.MORE);
        }
        return false;
    }

    private void setKeyJustPressed(VirtualKey key, boolean justPressed) {
        String cipherName214 =  "DES";
		try{
			android.util.Log.d("cipherName-214", javax.crypto.Cipher.getInstance(cipherName214).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPressedKeys.put(key, justPressed ? KeyState.JUST_PRESSED : KeyState.RELEASED);
    }

    private static AxisValue normalizeAxisValue(float value) {
        String cipherName215 =  "DES";
		try{
			android.util.Log.d("cipherName-215", javax.crypto.Cipher.getInstance(cipherName215).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (value < -0.5f) {
            String cipherName216 =  "DES";
			try{
				android.util.Log.d("cipherName-216", javax.crypto.Cipher.getInstance(cipherName216).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return AxisValue.LESS;
        } else if (value > 0.5f) {
            String cipherName217 =  "DES";
			try{
				android.util.Log.d("cipherName-217", javax.crypto.Cipher.getInstance(cipherName217).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return AxisValue.MORE;
        } else {
            String cipherName218 =  "DES";
			try{
				android.util.Log.d("cipherName-218", javax.crypto.Cipher.getInstance(cipherName218).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return AxisValue.ZERO;
        }
    }

    private void onButtonPressed(int buttonCode, boolean pressed) {
        String cipherName219 =  "DES";
		try{
			android.util.Log.d("cipherName-219", javax.crypto.Cipher.getInstance(cipherName219).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mListener != null) {
            String cipherName220 =  "DES";
			try{
				android.util.Log.d("cipherName-220", javax.crypto.Cipher.getInstance(cipherName220).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (mListener.onButtonPressed(buttonCode, pressed)) {
                String cipherName221 =  "DES";
				try{
					android.util.Log.d("cipherName-221", javax.crypto.Cipher.getInstance(cipherName221).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				return;
            }
        }
        if (buttonCode == mButtonCodes.get(VirtualKey.TRIGGER)) {
            String cipherName222 =  "DES";
			try{
				android.util.Log.d("cipherName-222", javax.crypto.Cipher.getInstance(cipherName222).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			setKeyJustPressed(VirtualKey.TRIGGER, pressed);
        } else if (buttonCode == mButtonCodes.get(VirtualKey.BACK)) {
            String cipherName223 =  "DES";
			try{
				android.util.Log.d("cipherName-223", javax.crypto.Cipher.getInstance(cipherName223).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			setKeyJustPressed(VirtualKey.BACK, pressed);
        } else {
            String cipherName224 =  "DES";
			try{
				android.util.Log.d("cipherName-224", javax.crypto.Cipher.getInstance(cipherName224).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			VirtualKey key = mVirtualKeyForButton.get(buttonCode);
            if (key != null) {
                String cipherName225 =  "DES";
				try{
					android.util.Log.d("cipherName-225", javax.crypto.Cipher.getInstance(cipherName225).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				setKeyJustPressed(key, pressed);
            }
        }
    }

    private void updateVirtualKeyForButton() {
        String cipherName226 =  "DES";
		try{
			android.util.Log.d("cipherName-226", javax.crypto.Cipher.getInstance(cipherName226).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mVirtualKeyForButton.clear();
        ControllerMapping mapping = mController.getMapping();
        mVirtualKeyForButton.put(mapping.buttonDpadDown, VirtualKey.DOWN);
        mVirtualKeyForButton.put(mapping.buttonDpadUp, VirtualKey.UP);
        mVirtualKeyForButton.put(mapping.buttonDpadLeft, VirtualKey.LEFT);
        mVirtualKeyForButton.put(mapping.buttonDpadRight, VirtualKey.RIGHT);
        mVirtualKeyForButton.put(mapping.buttonA, VirtualKey.TRIGGER);
        mVirtualKeyForButton.put(mapping.buttonStart, VirtualKey.TRIGGER);
        mVirtualKeyForButton.put(mapping.buttonB, VirtualKey.BACK);
        mVirtualKeyForButton.put(mapping.buttonBack, VirtualKey.BACK);
    }
}
