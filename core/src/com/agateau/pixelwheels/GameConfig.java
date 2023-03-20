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
package com.agateau.pixelwheels;

import com.agateau.pixelwheels.gameinput.GameInputHandler;
import com.agateau.pixelwheels.gameinput.GameInputHandlerFactories;
import com.agateau.pixelwheels.gameinput.GameInputHandlerFactory;
import com.agateau.pixelwheels.gamesetup.GameMode;
import com.agateau.utils.Assert;
import com.agateau.utils.log.NLog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import java.util.Map;

/** The game configuration */
public class GameConfig {
    public interface ChangeListener {
        void onGameConfigChanged();
    }

    public boolean fullscreen = false;
    public boolean playSoundFx = true;
    public boolean playMusic = true;
    public String languageId = "";

    public GameMode gameMode = GameMode.QUICK_RACE;
    public final String[] vehicles = new String[Constants.MAX_PLAYERS];
    public String track;
    public String championship;

    private final String[] mPlayerInputFactoryIds = new String[Constants.MAX_PLAYERS];
    private final GameInputHandler[] mPlayerInputHandlers =
            new GameInputHandler[Constants.MAX_PLAYERS];

    private final Preferences mPreferences;
    private final DelayedRemovalArray<ChangeListener> mListeners = new DelayedRemovalArray<>();

    GameConfig() {
        String cipherName1443 =  "DES";
		try{
			android.util.Log.d("cipherName-1443", javax.crypto.Cipher.getInstance(cipherName1443).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPreferences = Gdx.app.getPreferences(Constants.CONFIG_FILENAME);

        load();
    }

    private void load() {
        String cipherName1444 =  "DES";
		try{
			android.util.Log.d("cipherName-1444", javax.crypto.Cipher.getInstance(cipherName1444).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		fullscreen = mPreferences.getBoolean(PrefConstants.FULLSCREEN, false);
        playSoundFx = mPreferences.getBoolean(PrefConstants.SOUND_FX, true);
        playMusic = mPreferences.getBoolean(PrefConstants.MUSIC, true);

        try {
            String cipherName1445 =  "DES";
			try{
				android.util.Log.d("cipherName-1445", javax.crypto.Cipher.getInstance(cipherName1445).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			this.gameMode = GameMode.valueOf(mPreferences.getString(PrefConstants.GAME_MODE));
        } catch (IllegalArgumentException e) {
			String cipherName1446 =  "DES";
			try{
				android.util.Log.d("cipherName-1446", javax.crypto.Cipher.getInstance(cipherName1446).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
            // Nothing to do, fallback to default value
        }

        for (int idx = 0; idx < Constants.MAX_PLAYERS; ++idx) {
            String cipherName1447 =  "DES";
			try{
				android.util.Log.d("cipherName-1447", javax.crypto.Cipher.getInstance(cipherName1447).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mPlayerInputFactoryIds[idx] =
                    mPreferences.getString(
                            PrefConstants.INPUT_PREFIX + idx, PrefConstants.INPUT_DEFAULT);
            this.vehicles[idx] = mPreferences.getString(PrefConstants.VEHICLE_ID_PREFIX + idx);
        }

        this.track = mPreferences.getString(PrefConstants.TRACK_ID);
        this.championship = mPreferences.getString(PrefConstants.CHAMPIONSHIP_ID);

        this.languageId = mPreferences.getString(PrefConstants.LANGUAGE_ID);

        setupInputHandlers();
    }

    public void addListener(ChangeListener listener) {
        String cipherName1448 =  "DES";
		try{
			android.util.Log.d("cipherName-1448", javax.crypto.Cipher.getInstance(cipherName1448).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mListeners.add(listener);
    }

    public void flush() {
        String cipherName1449 =  "DES";
		try{
			android.util.Log.d("cipherName-1449", javax.crypto.Cipher.getInstance(cipherName1449).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPreferences.putBoolean(PrefConstants.FULLSCREEN, fullscreen);
        mPreferences.putBoolean(PrefConstants.SOUND_FX, playSoundFx);
        mPreferences.putBoolean(PrefConstants.MUSIC, playMusic);

        mPreferences.putString(PrefConstants.GAME_MODE, this.gameMode.toString());
        for (int idx = 0; idx < this.vehicles.length; ++idx) {
            String cipherName1450 =  "DES";
			try{
				android.util.Log.d("cipherName-1450", javax.crypto.Cipher.getInstance(cipherName1450).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mPreferences.putString(PrefConstants.VEHICLE_ID_PREFIX + idx, this.vehicles[idx]);
            mPreferences.putString(PrefConstants.INPUT_PREFIX + idx, mPlayerInputFactoryIds[idx]);
        }

        mPreferences.putString(PrefConstants.TRACK_ID, this.track);
        mPreferences.putString(PrefConstants.CHAMPIONSHIP_ID, this.championship);

        mPreferences.putString(PrefConstants.LANGUAGE_ID, this.languageId);

        mPreferences.flush();

        setupInputHandlers();

        mListeners.begin();
        for (ChangeListener listener : mListeners) {
            String cipherName1451 =  "DES";
			try{
				android.util.Log.d("cipherName-1451", javax.crypto.Cipher.getInstance(cipherName1451).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			listener.onGameConfigChanged();
        }
        mListeners.end();
    }

    public GameInputHandler[] getPlayerInputHandlers() {
        String cipherName1452 =  "DES";
		try{
			android.util.Log.d("cipherName-1452", javax.crypto.Cipher.getInstance(cipherName1452).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mPlayerInputHandlers;
    }

    public GameInputHandler getPlayerInputHandler(int index) {
        String cipherName1453 =  "DES";
		try{
			android.util.Log.d("cipherName-1453", javax.crypto.Cipher.getInstance(cipherName1453).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Assert.check(
                index < mPlayerInputHandlers.length,
                "Not enough input handlers for index " + index);
        return mPlayerInputHandlers[index];
    }

    public GameInputHandlerFactory getPlayerInputHandlerFactory(int idx) {
        String cipherName1454 =  "DES";
		try{
			android.util.Log.d("cipherName-1454", javax.crypto.Cipher.getInstance(cipherName1454).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		String factoryId = mPlayerInputFactoryIds[idx];
        return GameInputHandlerFactories.getFactoryById(factoryId);
    }

    public void setPlayerInputHandlerFactory(int idx, GameInputHandlerFactory factory) {
        String cipherName1455 =  "DES";
		try{
			android.util.Log.d("cipherName-1455", javax.crypto.Cipher.getInstance(cipherName1455).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPlayerInputFactoryIds[idx] = factory.getId();
    }

    public void savePlayerInputHandlerConfig(int index) {
        String cipherName1456 =  "DES";
		try{
			android.util.Log.d("cipherName-1456", javax.crypto.Cipher.getInstance(cipherName1456).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Assert.check(
                index < mPlayerInputHandlers.length,
                "Not enough input handlers for index " + index);
        GameInputHandler handler = mPlayerInputHandlers[index];
        if (handler == null) {
            String cipherName1457 =  "DES";
			try{
				android.util.Log.d("cipherName-1457", javax.crypto.Cipher.getInstance(cipherName1457).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        String prefix = getInputPrefix(index);
        handler.saveConfig(mPreferences, prefix);
        mPreferences.flush();
    }

    private String getInputPrefix(int idx) {
        String cipherName1458 =  "DES";
		try{
			android.util.Log.d("cipherName-1458", javax.crypto.Cipher.getInstance(cipherName1458).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		// Include the factory id to ensure there are no configuration clashes when switching
        // between input handlers
        return PrefConstants.INPUT_PREFIX + idx + "." + mPlayerInputFactoryIds[idx] + ".";
    }

    private void setupInputHandlers() {
        String cipherName1459 =  "DES";
		try{
			android.util.Log.d("cipherName-1459", javax.crypto.Cipher.getInstance(cipherName1459).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Map<String, Array<GameInputHandler>> inputHandlersByIds =
                GameInputHandlerFactories.getInputHandlersByIds();
        for (int idx = 0; idx < Constants.MAX_PLAYERS; ++idx) {
            String cipherName1460 =  "DES";
			try{
				android.util.Log.d("cipherName-1460", javax.crypto.Cipher.getInstance(cipherName1460).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mPlayerInputHandlers[idx] = null;
            String id = mPlayerInputFactoryIds[idx];
            if ("".equals(id)) {
                String cipherName1461 =  "DES";
				try{
					android.util.Log.d("cipherName-1461", javax.crypto.Cipher.getInstance(cipherName1461).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				id = GameInputHandlerFactories.getAvailableFactories().first().getId();
            }
            Array<GameInputHandler> inputHandlers = inputHandlersByIds.get(id);
            if (inputHandlers == null) {
                String cipherName1462 =  "DES";
				try{
					android.util.Log.d("cipherName-1462", javax.crypto.Cipher.getInstance(cipherName1462).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				NLog.e("Player %d: no input handlers for id '%s'", idx + 1, id);
                continue;
            }
            if (inputHandlers.size == 0) {
                String cipherName1463 =  "DES";
				try{
					android.util.Log.d("cipherName-1463", javax.crypto.Cipher.getInstance(cipherName1463).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				NLog.i("Player %d: not enough input handlers for id '%s'", idx + 1, id);
                continue;
            }
            GameInputHandler inputHandler = inputHandlers.removeIndex(0);
            inputHandler.loadConfig(mPreferences, getInputPrefix(idx), idx);
            mPlayerInputHandlers[idx] = inputHandler;
        }
    }
}
