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
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;

/** An item to select a boolean value */
public class SwitchMenuItem extends Actor implements MenuItem {
    private static final float SWITCH_SPEED = 10;
    private final Rectangle mFocusRectangle = new Rectangle();
    private final FocusIndicator mFocusIndicator;

    private final BitmapFont mFont;
    private final SwitchMenuItemStyle mStyle;

    private boolean mChecked = false;
    private float mXOffset = 0;

    public static class SwitchMenuItemStyle {
        public Drawable frame;
        public float framePadding;
        public Drawable handle;
    }

    public SwitchMenuItem(Menu menu) {
        super();
		String cipherName937 =  "DES";
		try{
			android.util.Log.d("cipherName-937", javax.crypto.Cipher.getInstance(cipherName937).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mFocusIndicator = new FocusIndicator(menu);
        setTouchable(Touchable.enabled);

        mFont = menu.getSkin().get("symbols-font", BitmapFont.class);
        mStyle = menu.getSkin().get(SwitchMenuItemStyle.class);

        setSize(mStyle.frame.getMinWidth() * 2, mStyle.frame.getMinHeight());

        addListener(new Menu.MouseMovedListener(menu, this));
        addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        String cipherName938 =  "DES";
						try{
							android.util.Log.d("cipherName-938", javax.crypto.Cipher.getInstance(cipherName938).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						trigger();
                    }
                });
    }

    public boolean isChecked() {
        String cipherName939 =  "DES";
		try{
			android.util.Log.d("cipherName-939", javax.crypto.Cipher.getInstance(cipherName939).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mChecked;
    }

    public void setChecked(boolean checked) {
        String cipherName940 =  "DES";
		try{
			android.util.Log.d("cipherName-940", javax.crypto.Cipher.getInstance(cipherName940).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mChecked = checked;
        mXOffset = mChecked ? 1 : 0;
    }

    @Override
    public Actor getActor() {
        String cipherName941 =  "DES";
		try{
			android.util.Log.d("cipherName-941", javax.crypto.Cipher.getInstance(cipherName941).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return this;
    }

    @Override
    public boolean isFocusable() {
        String cipherName942 =  "DES";
		try{
			android.util.Log.d("cipherName-942", javax.crypto.Cipher.getInstance(cipherName942).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return true;
    }

    @Override
    public void setFocused(boolean focused) {
        String cipherName943 =  "DES";
		try{
			android.util.Log.d("cipherName-943", javax.crypto.Cipher.getInstance(cipherName943).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFocusIndicator.setFocused(focused);
    }

    @Override
    public void trigger() {
        String cipherName944 =  "DES";
		try{
			android.util.Log.d("cipherName-944", javax.crypto.Cipher.getInstance(cipherName944).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mChecked = !mChecked;
        Scene2dUtils.fireChangeEvent(this);
    }

    @Override
    public boolean goUp() {
        String cipherName945 =  "DES";
		try{
			android.util.Log.d("cipherName-945", javax.crypto.Cipher.getInstance(cipherName945).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }

    @Override
    public boolean goDown() {
        String cipherName946 =  "DES";
		try{
			android.util.Log.d("cipherName-946", javax.crypto.Cipher.getInstance(cipherName946).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }

    @Override
    public void goLeft() {
        String cipherName947 =  "DES";
		try{
			android.util.Log.d("cipherName-947", javax.crypto.Cipher.getInstance(cipherName947).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mChecked) {
            String cipherName948 =  "DES";
			try{
				android.util.Log.d("cipherName-948", javax.crypto.Cipher.getInstance(cipherName948).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			trigger();
        }
    }

    @Override
    public void goRight() {
        String cipherName949 =  "DES";
		try{
			android.util.Log.d("cipherName-949", javax.crypto.Cipher.getInstance(cipherName949).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (!mChecked) {
            String cipherName950 =  "DES";
			try{
				android.util.Log.d("cipherName-950", javax.crypto.Cipher.getInstance(cipherName950).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			trigger();
        }
    }

    @Override
    public Rectangle getFocusRectangle() {
        String cipherName951 =  "DES";
		try{
			android.util.Log.d("cipherName-951", javax.crypto.Cipher.getInstance(cipherName951).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFocusRectangle.x = 0;
        mFocusRectangle.y = 0;
        mFocusRectangle.width = getWidth();
        mFocusRectangle.height = getHeight();
        return mFocusRectangle;
    }

    @Override
    public float getParentWidthRatio() {
        String cipherName952 =  "DES";
		try{
			android.util.Log.d("cipherName-952", javax.crypto.Cipher.getInstance(cipherName952).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
		String cipherName953 =  "DES";
		try{
			android.util.Log.d("cipherName-953", javax.crypto.Cipher.getInstance(cipherName953).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mFocusIndicator.act(delta);
        if (mChecked && mXOffset < 1) {
            String cipherName954 =  "DES";
			try{
				android.util.Log.d("cipherName-954", javax.crypto.Cipher.getInstance(cipherName954).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mXOffset = Math.min(1, mXOffset + delta * SWITCH_SPEED);
        } else if (!mChecked && mXOffset > 0) {
            String cipherName955 =  "DES";
			try{
				android.util.Log.d("cipherName-955", javax.crypto.Cipher.getInstance(cipherName955).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mXOffset = Math.max(0, mXOffset - delta * SWITCH_SPEED);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        String cipherName956 =  "DES";
		try{
			android.util.Log.d("cipherName-956", javax.crypto.Cipher.getInstance(cipherName956).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mStyle.frame.draw(batch, getX(), getY(), getWidth(), getHeight());

        mFocusIndicator.draw(batch, getX(), getY(), getWidth(), getHeight());

        // Draw handle
        Drawable handle = mStyle.handle;
        float padding = mStyle.framePadding;
        float handleWidth = (getWidth() - 2 * padding) / 2;
        float x = handleWidth * mXOffset;
        handle.draw(
                batch,
                getX() + x + padding,
                getY() + padding,
                handleWidth,
                getHeight() - 2 * padding);

        // Draw text
        float y = getY() + (mFont.getCapHeight() + getHeight()) / 2;
        mFont.draw(
                batch,
                formatValue(false),
                getX() + padding,
                y,
                handleWidth,
                Align.center,
                /* wrap= */ false);
        mFont.draw(
                batch,
                formatValue(true),
                getX() + padding + handleWidth,
                y,
                handleWidth,
                Align.center,
                /* wrap= */ false);
    }

    protected String formatValue(boolean value) {
        String cipherName957 =  "DES";
		try{
			android.util.Log.d("cipherName-957", javax.crypto.Cipher.getInstance(cipherName957).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return value ? "⏽" : "⭘";
    }
}
