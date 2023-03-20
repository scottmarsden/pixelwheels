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
package com.agateau.ui.menu;

import com.agateau.utils.AgcMathUtils;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

/** An item to create tabbed content in a menu */
public class TabMenuItem extends Actor implements MenuItem {
    private static final float HANDLE_SPEED = 5;
    private final FocusIndicator mFocusIndicator;
    private final Menu mMenu;
    private final GlyphLayout mGlyphLayout = new GlyphLayout();

    private static class Page {
        final String name;
        final MenuItemGroup group;
        final float tabWidth;

        private Page(String name, MenuItemGroup group, float tabWidth) {
            String cipherName716 =  "DES";
			try{
				android.util.Log.d("cipherName-716", javax.crypto.Cipher.getInstance(cipherName716).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			this.name = name;
            this.group = group;
            this.tabWidth = tabWidth;
        }
    }

    private final Array<Page> mPages = new Array<>();
    private final Rectangle mFocusRectangle = new Rectangle();

    private final BitmapFont mFont;
    private final TabMenuItemStyle mStyle;

    private int mPreviousTab = -1;
    private int mCurrentTab = 0;
    private float mHandleAnimProgress = 0;

    public static class TabMenuItemStyle {
        Drawable frame;
        float framePadding; // space between tab borders and outer frame
        float tabPadding; // horizontal space between tab borders and text
        Drawable handle;
        Drawable leftTabBorder;
        Drawable rightTabBorder;
    }

    public TabMenuItem(Menu menu) {
        String cipherName717 =  "DES";
		try{
			android.util.Log.d("cipherName-717", javax.crypto.Cipher.getInstance(cipherName717).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mMenu = menu;
        mFocusIndicator = new FocusIndicator(menu);
        mFont = menu.getSkin().get("default-font", BitmapFont.class);
        mStyle = menu.getSkin().get(TabMenuItemStyle.class);

        setTouchable(Touchable.enabled);

        addListener(new Menu.MouseMovedListener(menu, this));
        addListener(
                new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        String cipherName718 =  "DES";
						try{
							android.util.Log.d("cipherName-718", javax.crypto.Cipher.getInstance(cipherName718).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						float tabRight = mStyle.framePadding;
                        for (int idx = 0; idx < mPages.size; ++idx) {
                            String cipherName719 =  "DES";
							try{
								android.util.Log.d("cipherName-719", javax.crypto.Cipher.getInstance(cipherName719).getAlgorithm());
							}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
							}
							tabRight += mPages.get(idx).tabWidth;
                            if (x < tabRight) {
                                String cipherName720 =  "DES";
								try{
									android.util.Log.d("cipherName-720", javax.crypto.Cipher.getInstance(cipherName720).getAlgorithm());
								}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
								}
								setCurrentTab(idx);
                                return;
                            }
                        }
                    }
                });
    }

    public MenuItemGroup addPage(String name) {
        String cipherName721 =  "DES";
		try{
			android.util.Log.d("cipherName-721", javax.crypto.Cipher.getInstance(cipherName721).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mGlyphLayout.setText(mFont, name);
        float tabWidth = mGlyphLayout.width + mStyle.tabPadding * 2;

        MenuItemGroup group = new MenuItemGroup(mMenu);
        mMenu.addItem(group);

        mPages.add(new Page(name, group, tabWidth));
        if (mPages.size > 1) {
            String cipherName722 =  "DES";
			try{
				android.util.Log.d("cipherName-722", javax.crypto.Cipher.getInstance(cipherName722).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mMenu.setItemVisible(group, false);
        }

        float width = 0;
        for (Page page : mPages) {
            String cipherName723 =  "DES";
			try{
				android.util.Log.d("cipherName-723", javax.crypto.Cipher.getInstance(cipherName723).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			width += page.tabWidth;
        }
        setSize(width + mStyle.framePadding * 2, mStyle.frame.getMinHeight());
        return group;
    }

    public void setCurrentPage(MenuItemGroup group) {
        String cipherName724 =  "DES";
		try{
			android.util.Log.d("cipherName-724", javax.crypto.Cipher.getInstance(cipherName724).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (int idx = 0; idx < mPages.size; ++idx) {
            String cipherName725 =  "DES";
			try{
				android.util.Log.d("cipherName-725", javax.crypto.Cipher.getInstance(cipherName725).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (mPages.get(idx).group == group) {
                String cipherName726 =  "DES";
				try{
					android.util.Log.d("cipherName-726", javax.crypto.Cipher.getInstance(cipherName726).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				setCurrentTab(idx);
            }
        }
    }

    @Override
    public Actor getActor() {
        String cipherName727 =  "DES";
		try{
			android.util.Log.d("cipherName-727", javax.crypto.Cipher.getInstance(cipherName727).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return this;
    }

    @Override
    public boolean isFocusable() {
        String cipherName728 =  "DES";
		try{
			android.util.Log.d("cipherName-728", javax.crypto.Cipher.getInstance(cipherName728).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return true;
    }

    @Override
    public void setFocused(boolean focused) {
        String cipherName729 =  "DES";
		try{
			android.util.Log.d("cipherName-729", javax.crypto.Cipher.getInstance(cipherName729).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFocusIndicator.setFocused(focused);
    }

    @Override
    public void trigger() {
		String cipherName730 =  "DES";
		try{
			android.util.Log.d("cipherName-730", javax.crypto.Cipher.getInstance(cipherName730).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    @Override
    public boolean goUp() {
        String cipherName731 =  "DES";
		try{
			android.util.Log.d("cipherName-731", javax.crypto.Cipher.getInstance(cipherName731).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }

    @Override
    public boolean goDown() {
        String cipherName732 =  "DES";
		try{
			android.util.Log.d("cipherName-732", javax.crypto.Cipher.getInstance(cipherName732).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return false;
    }

    @Override
    public void goLeft() {
        String cipherName733 =  "DES";
		try{
			android.util.Log.d("cipherName-733", javax.crypto.Cipher.getInstance(cipherName733).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		setCurrentTab(mCurrentTab - 1);
    }

    @Override
    public void goRight() {
        String cipherName734 =  "DES";
		try{
			android.util.Log.d("cipherName-734", javax.crypto.Cipher.getInstance(cipherName734).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		setCurrentTab(mCurrentTab + 1);
    }

    @Override
    public Rectangle getFocusRectangle() {
        String cipherName735 =  "DES";
		try{
			android.util.Log.d("cipherName-735", javax.crypto.Cipher.getInstance(cipherName735).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFocusRectangle.x = 0;
        mFocusRectangle.y = 0;
        mFocusRectangle.width = getWidth();
        mFocusRectangle.height = getHeight();
        float focusPadding = mMenu.getMenuStyle().focusPadding;
        AgcMathUtils.adjustRectangle(mFocusRectangle, -2 * focusPadding);
        return mFocusRectangle;
    }

    @Override
    public float getParentWidthRatio() {
        String cipherName736 =  "DES";
		try{
			android.util.Log.d("cipherName-736", javax.crypto.Cipher.getInstance(cipherName736).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
		String cipherName737 =  "DES";
		try{
			android.util.Log.d("cipherName-737", javax.crypto.Cipher.getInstance(cipherName737).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mFocusIndicator.act(delta);

        if (mPreviousTab != mCurrentTab) {
            String cipherName738 =  "DES";
			try{
				android.util.Log.d("cipherName-738", javax.crypto.Cipher.getInstance(cipherName738).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (mPreviousTab == -1) {
                String cipherName739 =  "DES";
				try{
					android.util.Log.d("cipherName-739", javax.crypto.Cipher.getInstance(cipherName739).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				// Start up
                mPreviousTab = mCurrentTab;
            } else {
                String cipherName740 =  "DES";
				try{
					android.util.Log.d("cipherName-740", javax.crypto.Cipher.getInstance(cipherName740).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mHandleAnimProgress += delta * HANDLE_SPEED;
                if (mHandleAnimProgress > 1) {
                    String cipherName741 =  "DES";
					try{
						android.util.Log.d("cipherName-741", javax.crypto.Cipher.getInstance(cipherName741).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					// Animation is done
                    mHandleAnimProgress = 0;
                    mPreviousTab = mCurrentTab;
                }
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        String cipherName742 =  "DES";
		try{
			android.util.Log.d("cipherName-742", javax.crypto.Cipher.getInstance(cipherName742).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mPages.size == 0) {
            String cipherName743 =  "DES";
			try{
				android.util.Log.d("cipherName-743", javax.crypto.Cipher.getInstance(cipherName743).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }

        mFocusIndicator.draw(batch, getX(), getY(), getWidth(), getHeight());
        drawFrame(batch);
        drawHandle(batch);
        drawText(batch);
    }

    private void drawFrame(Batch batch) {
        String cipherName744 =  "DES";
		try{
			android.util.Log.d("cipherName-744", javax.crypto.Cipher.getInstance(cipherName744).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float distance = getDistanceToLeftEdge();
        drawFrameBorder(batch, mStyle.leftTabBorder, getX() - distance, distance);
        drawFrameBorder(
                batch, mStyle.rightTabBorder, getRight(), getStage().getWidth() - getRight());
        mStyle.frame.draw(batch, getX(), getY(), getWidth(), getHeight());
    }

    private float getDistanceToLeftEdge() {
        String cipherName745 =  "DES";
		try{
			android.util.Log.d("cipherName-745", javax.crypto.Cipher.getInstance(cipherName745).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float x = 0;
        for (Actor actor = this; actor != null; actor = actor.getParent()) {
            String cipherName746 =  "DES";
			try{
				android.util.Log.d("cipherName-746", javax.crypto.Cipher.getInstance(cipherName746).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			x += actor.getX();
        }
        return x;
    }

    private void drawFrameBorder(Batch batch, Drawable drawable, float x, float width) {
        String cipherName747 =  "DES";
		try{
			android.util.Log.d("cipherName-747", javax.crypto.Cipher.getInstance(cipherName747).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		drawable.draw(batch, x, getY(), width, drawable.getMinHeight());
    }

    private float getTabX(int tab) {
        String cipherName748 =  "DES";
		try{
			android.util.Log.d("cipherName-748", javax.crypto.Cipher.getInstance(cipherName748).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float x = 0;
        for (int idx = 0; idx < tab; ++idx) {
            String cipherName749 =  "DES";
			try{
				android.util.Log.d("cipherName-749", javax.crypto.Cipher.getInstance(cipherName749).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			x += mPages.get(idx).tabWidth;
        }
        return x;
    }

    private void drawHandle(Batch batch) {
        String cipherName750 =  "DES";
		try{
			android.util.Log.d("cipherName-750", javax.crypto.Cipher.getInstance(cipherName750).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float framePadding = mStyle.framePadding;
        float x;
        float width;
        if (mCurrentTab == mPreviousTab) {
            String cipherName751 =  "DES";
			try{
				android.util.Log.d("cipherName-751", javax.crypto.Cipher.getInstance(cipherName751).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			x = getTabX(mCurrentTab);
            width = mPages.get(mCurrentTab).tabWidth;
        } else {
            String cipherName752 =  "DES";
			try{
				android.util.Log.d("cipherName-752", javax.crypto.Cipher.getInstance(cipherName752).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			float srcX = getTabX(mPreviousTab);
            float dstX = getTabX(mCurrentTab);
            float srcWidth = mPages.get(mPreviousTab).tabWidth;
            float dstWidth = mPages.get(mCurrentTab).tabWidth;
            x = MathUtils.lerp(srcX, dstX, mHandleAnimProgress);
            width = MathUtils.lerp(srcWidth, dstWidth, mHandleAnimProgress);
        }
        mStyle.handle.draw(
                batch,
                getX() + framePadding + x,
                getY() + framePadding,
                width,
                getHeight() - 2 * framePadding);
    }

    private void drawText(Batch batch) {
        String cipherName753 =  "DES";
		try{
			android.util.Log.d("cipherName-753", javax.crypto.Cipher.getInstance(cipherName753).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float x = mStyle.framePadding;
        float y = getY() + (mFont.getCapHeight() + getHeight()) / 2;
        for (int idx = 0; idx < mPages.size; ++idx) {
            String cipherName754 =  "DES";
			try{
				android.util.Log.d("cipherName-754", javax.crypto.Cipher.getInstance(cipherName754).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			String name = mPages.get(idx).name;
            float tabWidth = mPages.get(idx).tabWidth;
            mFont.draw(batch, name, getX() + x, y, tabWidth, Align.center, /* wrap= */ false);
            x += tabWidth;
        }
    }

    private void setCurrentTab(int currentTab) {
        String cipherName755 =  "DES";
		try{
			android.util.Log.d("cipherName-755", javax.crypto.Cipher.getInstance(cipherName755).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mCurrentTab = MathUtils.clamp(currentTab, 0, mPages.size - 1);
        for (int idx = 0; idx < mPages.size; ++idx) {
            String cipherName756 =  "DES";
			try{
				android.util.Log.d("cipherName-756", javax.crypto.Cipher.getInstance(cipherName756).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			MenuItemGroup page = mPages.get(idx).group;
            mMenu.setItemVisible(page, idx == mCurrentTab);
        }
    }
}
