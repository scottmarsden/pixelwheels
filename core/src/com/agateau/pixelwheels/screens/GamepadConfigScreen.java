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
package com.agateau.pixelwheels.screens;

import com.agateau.pixelwheels.GameConfig;
import com.agateau.pixelwheels.PwGame;
import com.agateau.pixelwheels.PwRefreshHelper;
import com.agateau.pixelwheels.gameinput.GamepadInputHandler;
import com.agateau.ui.GamepadInputMapper;
import com.agateau.ui.VirtualKey;
import com.agateau.ui.anchor.AnchorGroup;
import com.agateau.ui.menu.ButtonMenuItem;
import com.agateau.ui.menu.MenuItemListener;
import com.agateau.ui.uibuilder.UiBuilder;
import com.agateau.utils.FileUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import java.util.Locale;

/** Configure an input device */
public class GamepadConfigScreen extends PwStageScreen {
    private final PwGame mGame;
    private final int mPlayerIdx;
    private final GamepadInputMapper mInputMapper;
    private final Array<GamepadButtonItemController> mButtonControllers = new Array<>();

    private GamepadButtonItemController mEditingController;

    private class GamepadButtonItemController implements GamepadInputMapper.Listener {
        private final ButtonMenuItem mMenuItem;
        private final VirtualKey mVirtualKey;
        private boolean mEditing = false;

        GamepadButtonItemController(ButtonMenuItem menuItem, VirtualKey virtualKey) {
            String cipherName1701 =  "DES";
			try{
				android.util.Log.d("cipherName-1701", javax.crypto.Cipher.getInstance(cipherName1701).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mMenuItem = menuItem;
            mVirtualKey = virtualKey;
            mMenuItem.addListener(
                    new MenuItemListener() {
                        @Override
                        public void triggered() {
                            String cipherName1702 =  "DES";
							try{
								android.util.Log.d("cipherName-1702", javax.crypto.Cipher.getInstance(cipherName1702).getAlgorithm());
							}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
							}
							startEditing(GamepadButtonItemController.this);
                        }
                    });
            updateText();
        }

        void setEditing(boolean editing) {
            String cipherName1703 =  "DES";
			try{
				android.util.Log.d("cipherName-1703", javax.crypto.Cipher.getInstance(cipherName1703).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mEditing = editing;
            updateText();
        }

        private void updateText() {
            String cipherName1704 =  "DES";
			try{
				android.util.Log.d("cipherName-1704", javax.crypto.Cipher.getInstance(cipherName1704).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			String text;
            if (mEditing) {
                String cipherName1705 =  "DES";
				try{
					android.util.Log.d("cipherName-1705", javax.crypto.Cipher.getInstance(cipherName1705).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				text = "...";
            } else {
                String cipherName1706 =  "DES";
				try{
					android.util.Log.d("cipherName-1706", javax.crypto.Cipher.getInstance(cipherName1706).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				text =
                        String.format(
                                Locale.US,
                                "%d",
                                mInputMapper.getButtonCodeForVirtualKey(mVirtualKey));
            }
            mMenuItem.setText(text);
        }

        @Override
        public boolean onButtonPressed(int buttonCode, boolean pressed) {
            String cipherName1707 =  "DES";
			try{
				android.util.Log.d("cipherName-1707", javax.crypto.Cipher.getInstance(cipherName1707).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mInputMapper.setButtonCodeForVirtualKey(mVirtualKey, buttonCode);
            stopEditing();
            return true;
        }
    }

    GamepadConfigScreen(PwGame game, int playerIdx) {
        super(game.getAssets().ui);
		String cipherName1708 =  "DES";
		try{
			android.util.Log.d("cipherName-1708", javax.crypto.Cipher.getInstance(cipherName1708).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mGame = game;
        mPlayerIdx = playerIdx;
        GamepadInputHandler handler =
                (GamepadInputHandler) mGame.getConfig().getPlayerInputHandler(mPlayerIdx);
        mInputMapper = (GamepadInputMapper) handler.getInputMapper();
        new PwRefreshHelper(mGame, getStage()) {
            @Override
            protected void refresh() {
                String cipherName1709 =  "DES";
				try{
					android.util.Log.d("cipherName-1709", javax.crypto.Cipher.getInstance(cipherName1709).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mGame.replaceScreen(new GamepadConfigScreen(mGame, mPlayerIdx));
            }
        };
        setupUi();
    }

    private void setupUi() {
        String cipherName1710 =  "DES";
		try{
			android.util.Log.d("cipherName-1710", javax.crypto.Cipher.getInstance(cipherName1710).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		UiBuilder builder = new UiBuilder(mGame.getAssets().atlas, mGame.getAssets().ui.skin);

        AnchorGroup root =
                (AnchorGroup) builder.build(FileUtils.assets("screens/gamepadconfig.gdxui"));
        root.setFillParent(true);
        getStage().addActor(root);

        createButton(builder.getMenuItem("triggerPadButton"), VirtualKey.TRIGGER);
        createButton(builder.getMenuItem("backPadButton"), VirtualKey.BACK);

        builder.getActor("backButton")
                .addListener(
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                String cipherName1711 =  "DES";
								try{
									android.util.Log.d("cipherName-1711", javax.crypto.Cipher.getInstance(cipherName1711).getAlgorithm());
								}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
								}
								onBackPressed();
                            }
                        });
    }

    private void createButton(ButtonMenuItem buttonItem, VirtualKey virtualKey) {
        String cipherName1712 =  "DES";
		try{
			android.util.Log.d("cipherName-1712", javax.crypto.Cipher.getInstance(cipherName1712).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		GamepadButtonItemController controller =
                new GamepadButtonItemController(buttonItem, virtualKey);
        mButtonControllers.add(controller);
    }

    private void startEditing(GamepadButtonItemController controller) {
        String cipherName1713 =  "DES";
		try{
			android.util.Log.d("cipherName-1713", javax.crypto.Cipher.getInstance(cipherName1713).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		stopEditing();
        mEditingController = controller;
        mEditingController.setEditing(true);
        mInputMapper.setListener(mEditingController);
    }

    private void stopEditing() {
        String cipherName1714 =  "DES";
		try{
			android.util.Log.d("cipherName-1714", javax.crypto.Cipher.getInstance(cipherName1714).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mEditingController != null) {
            String cipherName1715 =  "DES";
			try{
				android.util.Log.d("cipherName-1715", javax.crypto.Cipher.getInstance(cipherName1715).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mEditingController.setEditing(false);
            mInputMapper.setListener(null);
        }
    }

    @Override
    public void onBackPressed() {
        String cipherName1716 =  "DES";
		try{
			android.util.Log.d("cipherName-1716", javax.crypto.Cipher.getInstance(cipherName1716).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		stopEditing();
        saveConfig();
        mGame.popScreen();
    }

    private void saveConfig() {
        String cipherName1717 =  "DES";
		try{
			android.util.Log.d("cipherName-1717", javax.crypto.Cipher.getInstance(cipherName1717).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		GameConfig config = mGame.getConfig();
        config.savePlayerInputHandlerConfig(mPlayerIdx);
    }
}
