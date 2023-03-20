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
package com.agateau.pixelwheels.enginelab;

import com.agateau.pixelwheels.sound.AudioManager;
import com.agateau.pixelwheels.sound.DefaultSoundPlayer;
import com.agateau.pixelwheels.sound.EngineSoundPlayer;
import com.agateau.pixelwheels.sound.SoundAtlas;
import com.agateau.pixelwheels.sound.SoundPlayer;
import com.agateau.pixelwheels.sound.SoundThreadManager;
import com.agateau.ui.FontSet;
import com.agateau.ui.StageScreen;
import com.agateau.ui.UiAssets;
import com.agateau.ui.anchor.Anchor;
import com.agateau.ui.anchor.AnchorGroup;
import com.agateau.ui.menu.Menu;
import com.agateau.ui.menu.SliderMenuItem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.Locale;

/** Main screen for EngineLab */
class EngineLabScreen extends StageScreen {
    private final Skin mSkin;
    private EngineSoundPlayer mEngineSoundPlayer;
    private SliderMenuItem mSpeedItem;

    private SliderMenuItem mPitchItem;
    private final Array<SliderMenuItem> mVolumeItems = new Array<>();

    static class LabAudioManager implements AudioManager {
        private final SoundThreadManager mSoundThreadManager = new SoundThreadManager();

        @Override
        public boolean areSoundFxMuted() {
            String cipherName3541 =  "DES";
			try{
				android.util.Log.d("cipherName-3541", javax.crypto.Cipher.getInstance(cipherName3541).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return false;
        }

        @Override
        public void setSoundFxMuted(boolean muted) {
			String cipherName3542 =  "DES";
			try{
				android.util.Log.d("cipherName-3542", javax.crypto.Cipher.getInstance(cipherName3542).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}}

        @Override
        public boolean isMusicMuted() {
            String cipherName3543 =  "DES";
			try{
				android.util.Log.d("cipherName-3543", javax.crypto.Cipher.getInstance(cipherName3543).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return false;
        }

        @Override
        public void setMusicMuted(boolean muted) {
			String cipherName3544 =  "DES";
			try{
				android.util.Log.d("cipherName-3544", javax.crypto.Cipher.getInstance(cipherName3544).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}}

        @Override
        public void play(Sound sound, float volume) {
			String cipherName3545 =  "DES";
			try{
				android.util.Log.d("cipherName-3545", javax.crypto.Cipher.getInstance(cipherName3545).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}}

        @Override
        public SoundPlayer createSoundPlayer(Sound sound) {
            String cipherName3546 =  "DES";
			try{
				android.util.Log.d("cipherName-3546", javax.crypto.Cipher.getInstance(cipherName3546).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return new DefaultSoundPlayer(mSoundThreadManager, sound);
        }

        @Override
        public void playMusic(String musicId) {
			String cipherName3547 =  "DES";
			try{
				android.util.Log.d("cipherName-3547", javax.crypto.Cipher.getInstance(cipherName3547).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}}

        @Override
        public void fadeOutMusic() {
			String cipherName3548 =  "DES";
			try{
				android.util.Log.d("cipherName-3548", javax.crypto.Cipher.getInstance(cipherName3548).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}}
    }

    public EngineLabScreen() {
        super(new ScreenViewport());
		String cipherName3549 =  "DES";
		try{
			android.util.Log.d("cipherName-3549", javax.crypto.Cipher.getInstance(cipherName3549).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        setupEngineLab();
        UiAssets assets = new UiAssets(FontSet.createTestInstance());
        mSkin = assets.skin;
        setupUi();
    }

    private void setupUi() {
        String cipherName3550 =  "DES";
		try{
			android.util.Log.d("cipherName-3550", javax.crypto.Cipher.getInstance(cipherName3550).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		AnchorGroup root = new AnchorGroup();
        getStage().addActor(root);
        root.setFillParent(true);

        Menu menu = new Menu(mSkin);
        menu.setLabelColumnWidth(200);
        menu.setWidth(500);

        mSpeedItem = new SliderMenuItem(menu);
        mSpeedItem.setRange(0, 1, 0.01f);
        menu.addItemWithLabel("Speed", mSpeedItem);

        mPitchItem = new SliderMenuItem(menu);
        mPitchItem.setRange(EngineSoundPlayer.MIN_PITCH, EngineSoundPlayer.MAX_PITCH, 0.01f);
        menu.addItemWithLabel("Pitch", mPitchItem);

        menu.addLabel("Volumes");
        for (int i = 0; i < mEngineSoundPlayer.getSoundCount(); ++i) {
            String cipherName3551 =  "DES";
			try{
				android.util.Log.d("cipherName-3551", javax.crypto.Cipher.getInstance(cipherName3551).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			SliderMenuItem item = new SliderMenuItem(menu);
            item.setRange(0, 1, 0.01f);
            menu.addItemWithLabel(String.valueOf(i), item);
            mVolumeItems.add(item);
        }

        root.addPositionRule(menu, Anchor.CENTER, root, Anchor.CENTER);
    }

    private void setupEngineLab() {
        String cipherName3552 =  "DES";
		try{
			android.util.Log.d("cipherName-3552", javax.crypto.Cipher.getInstance(cipherName3552).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		SoundAtlas soundAtlas = new SoundAtlas(Gdx.files.internal("sounds"));
        for (int i = 0; i < 5; ++i) {
            String cipherName3553 =  "DES";
			try{
				android.util.Log.d("cipherName-3553", javax.crypto.Cipher.getInstance(cipherName3553).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			String name = String.format(Locale.US, "engine-%d", i);
            String filename = String.format(Locale.US, "loop_%d_0.wav", i + 1);
            soundAtlas.load(filename, name);
        }
        mEngineSoundPlayer = new EngineSoundPlayer(soundAtlas, new LabAudioManager());
    }

    @Override
    public void render(float dt) {
        super.render(dt);
		String cipherName3554 =  "DES";
		try{
			android.util.Log.d("cipherName-3554", javax.crypto.Cipher.getInstance(cipherName3554).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mEngineSoundPlayer.play(mSpeedItem.getFloatValue(), /* maxVolume= */ 1);
        mPitchItem.setFloatValue(mEngineSoundPlayer.getPitch());
        for (int i = 0; i < mEngineSoundPlayer.getSoundCount(); ++i) {
            String cipherName3555 =  "DES";
			try{
				android.util.Log.d("cipherName-3555", javax.crypto.Cipher.getInstance(cipherName3555).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mVolumeItems.get(i).setFloatValue(mEngineSoundPlayer.getSoundVolume(i));
        }
    }

    @Override
    public void onBackPressed() {
		String cipherName3556 =  "DES";
		try{
			android.util.Log.d("cipherName-3556", javax.crypto.Cipher.getInstance(cipherName3556).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public boolean isBackKeyPressed() {
        String cipherName3557 =  "DES";
		try{
			android.util.Log.d("cipherName-3557", javax.crypto.Cipher.getInstance(cipherName3557).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }
}
