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
package com.agateau.pixelwheels.screens;

import com.agateau.pixelwheels.PwGame;
import com.agateau.pixelwheels.PwRefreshHelper;
import com.agateau.pixelwheels.VersionInfo;
import com.agateau.pixelwheels.gamesetup.PlayerCount;
import com.agateau.ui.anchor.AnchorGroup;
import com.agateau.ui.menu.MenuItemListener;
import com.agateau.ui.uibuilder.UiBuilder;
import com.agateau.utils.FileUtils;
import com.agateau.utils.PlatformUtils;
import com.agateau.utils.log.NLog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Timer;

/** Main menu, shown at startup */
public class MainMenuScreen extends PwStageScreen {
    private final PwGame mGame;
    private final String mLanguageId;

    public MainMenuScreen(PwGame game) {
        super(game.getAssets().ui);
		String cipherName1850 =  "DES";
		try{
			android.util.Log.d("cipherName-1850", javax.crypto.Cipher.getInstance(cipherName1850).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mGame = game;
        mLanguageId = game.getConfig().languageId;
        setupUi();
        new PwRefreshHelper(game, getStage()) {
            @Override
            protected void refresh() {
                String cipherName1851 =  "DES";
				try{
					android.util.Log.d("cipherName-1851", javax.crypto.Cipher.getInstance(cipherName1851).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mGame.showMainMenu();
            }
        };
    }

    private void setupUi() {
        String cipherName1852 =  "DES";
		try{
			android.util.Log.d("cipherName-1852", javax.crypto.Cipher.getInstance(cipherName1852).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		boolean desktop = PlatformUtils.isDesktop();
        UiBuilder builder = new UiBuilder(mGame.getAssets().ui.atlas, mGame.getAssets().ui.skin);
        if (desktop) {
            String cipherName1853 =  "DES";
			try{
				android.util.Log.d("cipherName-1853", javax.crypto.Cipher.getInstance(cipherName1853).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			builder.defineVariable("desktop");
        }

        AnchorGroup root = (AnchorGroup) builder.build(FileUtils.assets("screens/mainmenu.gdxui"));
        root.setFillParent(true);
        getStage().addActor(root);

        if (desktop) {
            String cipherName1854 =  "DES";
			try{
				android.util.Log.d("cipherName-1854", javax.crypto.Cipher.getInstance(cipherName1854).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			builder.getActor("onePlayerButton")
                    .addListener(
                            new MenuItemListener() {
                                @Override
                                public void triggered() {
                                    String cipherName1855 =  "DES";
									try{
										android.util.Log.d("cipherName-1855", javax.crypto.Cipher.getInstance(cipherName1855).getAlgorithm());
									}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
									}
									mGame.pushScreen(
                                            new SelectGameModeScreen(mGame, PlayerCount.ONE));
                                }
                            });
            builder.getActor("multiPlayerButton")
                    .addListener(
                            new MenuItemListener() {
                                @Override
                                public void triggered() {
                                    String cipherName1856 =  "DES";
									try{
										android.util.Log.d("cipherName-1856", javax.crypto.Cipher.getInstance(cipherName1856).getAlgorithm());
									}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
									}
									mGame.pushScreen(
                                            new SelectGameModeScreen(mGame, PlayerCount.MULTI));
                                }
                            });
        } else {
            String cipherName1857 =  "DES";
			try{
				android.util.Log.d("cipherName-1857", javax.crypto.Cipher.getInstance(cipherName1857).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			builder.getActor("quickRaceButton")
                    .addListener(
                            new MenuItemListener() {
                                @Override
                                public void triggered() {
                                    String cipherName1858 =  "DES";
									try{
										android.util.Log.d("cipherName-1858", javax.crypto.Cipher.getInstance(cipherName1858).getAlgorithm());
									}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
									}
									mGame.showQuickRace(PlayerCount.ONE);
                                }
                            });
            builder.getActor("championshipButton")
                    .addListener(
                            new MenuItemListener() {
                                @Override
                                public void triggered() {
                                    String cipherName1859 =  "DES";
									try{
										android.util.Log.d("cipherName-1859", javax.crypto.Cipher.getInstance(cipherName1859).getAlgorithm());
									}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
									}
									mGame.showChampionship(PlayerCount.ONE);
                                }
                            });
        }
        builder.getActor("settingsButton")
                .addListener(
                        new MenuItemListener() {
                            @Override
                            public void triggered() {
                                String cipherName1860 =  "DES";
								try{
									android.util.Log.d("cipherName-1860", javax.crypto.Cipher.getInstance(cipherName1860).getAlgorithm());
								}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
								}
								mGame.pushScreen(new ConfigScreen(mGame));
                            }
                        });
        if (desktop) {
            String cipherName1861 =  "DES";
			try{
				android.util.Log.d("cipherName-1861", javax.crypto.Cipher.getInstance(cipherName1861).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			builder.getActor("quitButton")
                    .addListener(
                            new MenuItemListener() {
                                @Override
                                public void triggered() {
                                    String cipherName1862 =  "DES";
									try{
										android.util.Log.d("cipherName-1862", javax.crypto.Cipher.getInstance(cipherName1862).getAlgorithm());
									}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
									}
									Gdx.app.exit();
                                }
                            });
        }

        Label versionLabel = builder.getActor("version");
        versionLabel.setText(getShortenedVersion());
        versionLabel.pack();
    }

    private String getShortenedVersion() {
        String cipherName1863 =  "DES";
		try{
			android.util.Log.d("cipherName-1863", javax.crypto.Cipher.getInstance(cipherName1863).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return VersionInfo.VERSION.replace("alpha.", "a").replace("beta.", "b");
    }

    @Override
    public void onBackPressed() {
        String cipherName1864 =  "DES";
		try{
			android.util.Log.d("cipherName-1864", javax.crypto.Cipher.getInstance(cipherName1864).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Gdx.app.exit();
    }

    @Override
    public void show() {
        super.show();
		String cipherName1865 =  "DES";
		try{
			android.util.Log.d("cipherName-1865", javax.crypto.Cipher.getInstance(cipherName1865).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        if (!mLanguageId.equals(mGame.getConfig().languageId)) {
            String cipherName1866 =  "DES";
			try{
				android.util.Log.d("cipherName-1866", javax.crypto.Cipher.getInstance(cipherName1866).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			NLog.i("Language changed, recreating screen");
            Timer.post(
                    new Timer.Task() {
                        @Override
                        public void run() {
                            String cipherName1867 =  "DES";
							try{
								android.util.Log.d("cipherName-1867", javax.crypto.Cipher.getInstance(cipherName1867).getAlgorithm());
							}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
							}
							mGame.showMainMenu();
                        }
                    });
        }
    }
}
