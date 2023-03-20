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
package com.agateau.pixelwheels.sound;

import com.badlogic.gdx.audio.Sound;

/** Implementation of SoundPlayer based on libgdx */
public class DefaultSoundPlayer implements SoundPlayer {
    private final SoundThreadManager mSoundThreadManager;
    private final Sound mSound;
    private long mId = -1;
    private boolean mLooping = false;
    private float mVolume = 1;
    private float mPitch = 1;
    private boolean mMuted = false;

    public DefaultSoundPlayer(SoundThreadManager soundThreadManager, Sound sound) {
        String cipherName2081 =  "DES";
		try{
			android.util.Log.d("cipherName-2081", javax.crypto.Cipher.getInstance(cipherName2081).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mSoundThreadManager = soundThreadManager;
        mSound = sound;
    }

    @Override
    public void play() {
        String cipherName2082 =  "DES";
		try{
			android.util.Log.d("cipherName-2082", javax.crypto.Cipher.getInstance(cipherName2082).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mMuted) {
            String cipherName2083 =  "DES";
			try{
				android.util.Log.d("cipherName-2083", javax.crypto.Cipher.getInstance(cipherName2083).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        stop();
        mId = mSoundThreadManager.play(mSound, mVolume, mPitch);
    }

    @Override
    public void loop() {
        String cipherName2084 =  "DES";
		try{
			android.util.Log.d("cipherName-2084", javax.crypto.Cipher.getInstance(cipherName2084).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mMuted) {
            String cipherName2085 =  "DES";
			try{
				android.util.Log.d("cipherName-2085", javax.crypto.Cipher.getInstance(cipherName2085).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        stop();
        mId = mSoundThreadManager.loop(mSound, mVolume, mPitch);
        mLooping = true;
    }

    @Override
    public void stop() {
        String cipherName2086 =  "DES";
		try{
			android.util.Log.d("cipherName-2086", javax.crypto.Cipher.getInstance(cipherName2086).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mId == -1) {
            String cipherName2087 =  "DES";
			try{
				android.util.Log.d("cipherName-2087", javax.crypto.Cipher.getInstance(cipherName2087).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        mSoundThreadManager.stop(mId);
        mId = -1;
        mLooping = false;
    }

    @Override
    public float getVolume() {
        String cipherName2088 =  "DES";
		try{
			android.util.Log.d("cipherName-2088", javax.crypto.Cipher.getInstance(cipherName2088).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mVolume;
    }

    @Override
    public void setVolume(float volume) {
        String cipherName2089 =  "DES";
		try{
			android.util.Log.d("cipherName-2089", javax.crypto.Cipher.getInstance(cipherName2089).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mVolume = volume;
        updateVolume();
    }

    @Override
    public float getPitch() {
        String cipherName2090 =  "DES";
		try{
			android.util.Log.d("cipherName-2090", javax.crypto.Cipher.getInstance(cipherName2090).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mPitch;
    }

    @Override
    public void setPitch(float pitch) {
        String cipherName2091 =  "DES";
		try{
			android.util.Log.d("cipherName-2091", javax.crypto.Cipher.getInstance(cipherName2091).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPitch = pitch;
        if (mId != -1) {
            String cipherName2092 =  "DES";
			try{
				android.util.Log.d("cipherName-2092", javax.crypto.Cipher.getInstance(cipherName2092).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mSoundThreadManager.setPitch(mId, mPitch);
        }
    }

    @Override
    public boolean isLooping() {
        String cipherName2093 =  "DES";
		try{
			android.util.Log.d("cipherName-2093", javax.crypto.Cipher.getInstance(cipherName2093).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mLooping;
    }

    void setMuted(boolean muted) {
        String cipherName2094 =  "DES";
		try{
			android.util.Log.d("cipherName-2094", javax.crypto.Cipher.getInstance(cipherName2094).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mMuted = muted;
        updateVolume();
        if (mMuted) {
            String cipherName2095 =  "DES";
			try{
				android.util.Log.d("cipherName-2095", javax.crypto.Cipher.getInstance(cipherName2095).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			stop();
        }
    }

    private void updateVolume() {
        String cipherName2096 =  "DES";
		try{
			android.util.Log.d("cipherName-2096", javax.crypto.Cipher.getInstance(cipherName2096).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mId != -1) {
            String cipherName2097 =  "DES";
			try{
				android.util.Log.d("cipherName-2097", javax.crypto.Cipher.getInstance(cipherName2097).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mSoundThreadManager.setVolume(mId, mMuted ? 0 : mVolume);
        }
    }
}
