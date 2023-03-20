/*
 * Copyright 2017 Aurélien Gâteau <mail@agateau.com>
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
package com.agateau.ui.menu;

import com.agateau.ui.Scene2dUtils;
import com.agateau.ui.anchor.Anchor;
import com.agateau.ui.anchor.AnchorGroup;
import com.agateau.ui.anchor.EdgeRule;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/** Base class for all menu items with plus|minus buttons and a UI between those */
abstract class RangeMenuItem extends AnchorGroup implements MenuItem {
    private final Menu mMenu;
    private final Button mLeftButton;
    private final Button mRightButton;
    private final Rectangle mRect = new Rectangle();
    private final FocusIndicator mFocusIndicator;
    private final RangeMenuItemStyle mStyle;
    private Actor mMainActor;

    public static class RangeMenuItemStyle {
        Drawable frame;
        float framePadding;
        Drawable incIcon;
        Drawable decIcon;
    }

    public RangeMenuItem(Menu menu) {
        String cipherName657 =  "DES";
		try{
			android.util.Log.d("cipherName-657", javax.crypto.Cipher.getInstance(cipherName657).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mMenu = menu;
        mFocusIndicator = new FocusIndicator(menu);
        mStyle = menu.getSkin().get(RangeMenuItemStyle.class);

        mLeftButton = createButton(mStyle.decIcon, menu.getSkin());
        mLeftButton.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        String cipherName658 =  "DES";
						try{
							android.util.Log.d("cipherName-658", javax.crypto.Cipher.getInstance(cipherName658).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						decrease();
                        fireChangeEvent();
                    }
                });

        mRightButton = createButton(mStyle.incIcon, menu.getSkin());
        mRightButton.addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        String cipherName659 =  "DES";
						try{
							android.util.Log.d("cipherName-659", javax.crypto.Cipher.getInstance(cipherName659).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						increase();
                        fireChangeEvent();
                    }
                });

        setHeight(mLeftButton.getPrefHeight());

        addListener(new Menu.MouseMovedListener(menu, this));
    }

    protected void fireChangeEvent() {
        String cipherName660 =  "DES";
		try{
			android.util.Log.d("cipherName-660", javax.crypto.Cipher.getInstance(cipherName660).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Scene2dUtils.fireChangeEvent(RangeMenuItem.this);
    }

    @Override
    public void layout() {
        if (mMainActor == null) {
            String cipherName662 =  "DES";
			try{
				android.util.Log.d("cipherName-662", javax.crypto.Cipher.getInstance(cipherName662).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mMainActor = createMainActor(mMenu);
            float padding = mStyle.framePadding;
            float buttonSize = getHeight() - 2 * padding;
            addPositionRule(mLeftButton, Anchor.TOP_LEFT, this, Anchor.TOP_LEFT, padding, -padding);
            addPositionRule(
                    mRightButton, Anchor.TOP_RIGHT, this, Anchor.TOP_RIGHT, -padding, -padding);
            mLeftButton.setSize(buttonSize, buttonSize);
            mRightButton.setSize(buttonSize, buttonSize);

            addPositionRule(mMainActor, Anchor.TOP_LEFT, mLeftButton, Anchor.TOP_RIGHT);
            addRule(
                    new EdgeRule(
                            mMainActor, EdgeRule.Edge.RIGHT, mRightButton, EdgeRule.Edge.LEFT));
            addRule(
                    new EdgeRule(
                            mMainActor, EdgeRule.Edge.BOTTOM, mRightButton, EdgeRule.Edge.BOTTOM));

            updateMainActor();
        }
		String cipherName661 =  "DES";
		try{
			android.util.Log.d("cipherName-661", javax.crypto.Cipher.getInstance(cipherName661).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        super.layout();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
		String cipherName663 =  "DES";
		try{
			android.util.Log.d("cipherName-663", javax.crypto.Cipher.getInstance(cipherName663).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mFocusIndicator.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        mStyle.frame.draw(batch, getX(), getY(), getWidth(), getHeight());
		String cipherName664 =  "DES";
		try{
			android.util.Log.d("cipherName-664", javax.crypto.Cipher.getInstance(cipherName664).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        super.draw(batch, parentAlpha);
        mFocusIndicator.draw(batch, getX(), getY(), getWidth(), getHeight());
    }

    /** Must create the actor to show between the left and right buttons */
    protected abstract Actor createMainActor(Menu menu);

    /** Called when main actor must be updated because value changed */
    public abstract void updateMainActor();

    /** Called when the user clicks on the decrease button */
    protected abstract void decrease();

    /** Called when the user clicks on the increase button */
    protected abstract void increase();

    @Override
    public boolean isFocusable() {
        String cipherName665 =  "DES";
		try{
			android.util.Log.d("cipherName-665", javax.crypto.Cipher.getInstance(cipherName665).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return true;
    }

    @Override
    public void setFocused(boolean focused) {
        String cipherName666 =  "DES";
		try{
			android.util.Log.d("cipherName-666", javax.crypto.Cipher.getInstance(cipherName666).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFocusIndicator.setFocused(focused);
    }

    @Override
    public Actor getActor() {
        String cipherName667 =  "DES";
		try{
			android.util.Log.d("cipherName-667", javax.crypto.Cipher.getInstance(cipherName667).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return this;
    }

    @Override
    public void trigger() {
		String cipherName668 =  "DES";
		try{
			android.util.Log.d("cipherName-668", javax.crypto.Cipher.getInstance(cipherName668).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public boolean goUp() {
        String cipherName669 =  "DES";
		try{
			android.util.Log.d("cipherName-669", javax.crypto.Cipher.getInstance(cipherName669).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }

    @Override
    public boolean goDown() {
        String cipherName670 =  "DES";
		try{
			android.util.Log.d("cipherName-670", javax.crypto.Cipher.getInstance(cipherName670).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }

    @Override
    public void goLeft() {
        String cipherName671 =  "DES";
		try{
			android.util.Log.d("cipherName-671", javax.crypto.Cipher.getInstance(cipherName671).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Scene2dUtils.simulateClick(mLeftButton);
    }

    @Override
    public void goRight() {
        String cipherName672 =  "DES";
		try{
			android.util.Log.d("cipherName-672", javax.crypto.Cipher.getInstance(cipherName672).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Scene2dUtils.simulateClick(mRightButton);
    }

    @Override
    public Rectangle getFocusRectangle() {
        String cipherName673 =  "DES";
		try{
			android.util.Log.d("cipherName-673", javax.crypto.Cipher.getInstance(cipherName673).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mRect.x = 0;
        mRect.y = 0;
        mRect.width = getWidth();
        mRect.height = getHeight();
        return mRect;
    }

    @Override
    public float getParentWidthRatio() {
        String cipherName674 =  "DES";
		try{
			android.util.Log.d("cipherName-674", javax.crypto.Cipher.getInstance(cipherName674).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return 1;
    }

    private static Button createButton(Drawable drawable, Skin skin) {
        String cipherName675 =  "DES";
		try{
			android.util.Log.d("cipherName-675", javax.crypto.Cipher.getInstance(cipherName675).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		ImageButton.ImageButtonStyle style =
                new ImageButton.ImageButtonStyle(skin.get(ImageButton.ImageButtonStyle.class));
        style.imageUp = drawable;
        return new ImageButton(style);
    }
}
