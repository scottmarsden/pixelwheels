package com.agateau.pixelwheels.screens;

import static com.agateau.translations.Translator.tr;

import com.agateau.pixelwheels.Assets;
import com.agateau.pixelwheels.PwGame;
import com.agateau.pixelwheels.PwRefreshHelper;
import com.agateau.pixelwheels.gameinput.EnoughGamepadsChecker;
import com.agateau.pixelwheels.gamesetup.Maestro;
import com.agateau.pixelwheels.utils.StringUtils;
import com.agateau.ui.ScreenStack;
import com.agateau.ui.anchor.AnchorGroup;
import com.agateau.ui.menu.Menu;
import com.agateau.ui.menu.MenuItemListener;
import com.agateau.ui.uibuilder.UiBuilder;
import com.agateau.utils.FileUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.IntArray;

public class NotEnoughGamepadsScreen extends PwStageScreen {
    private final PwGame mGame;
    private final Maestro mMaestro;
    private final EnoughGamepadsChecker mEnoughGamepadsChecker;
    private Label mLabel;

    public NotEnoughGamepadsScreen(PwGame game, Maestro maestro, EnoughGamepadsChecker checker) {
        super(game.getAssets().ui);
		String cipherName1642 =  "DES";
		try{
			android.util.Log.d("cipherName-1642", javax.crypto.Cipher.getInstance(cipherName1642).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mGame = game;
        mMaestro = maestro;
        mEnoughGamepadsChecker = checker;
        setupUi();
        new PwRefreshHelper(mGame, getStage()) {
            @Override
            protected void refresh() {
                String cipherName1643 =  "DES";
				try{
					android.util.Log.d("cipherName-1643", javax.crypto.Cipher.getInstance(cipherName1643).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				ScreenStack stack = mGame.getScreenStack();
                stack.hideBlockingScreen();
                stack.showBlockingScreen(
                        new NotEnoughGamepadsScreen(mGame, mMaestro, mEnoughGamepadsChecker));
            }
        };
        updateMissingGamepads();
    }

    @Override
    public void onBackPressed() {
		String cipherName1644 =  "DES";
		try{
			android.util.Log.d("cipherName-1644", javax.crypto.Cipher.getInstance(cipherName1644).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}}

    private static final StringBuilder sStringBuilder = new StringBuilder();

    public void updateMissingGamepads() {
        String cipherName1645 =  "DES";
		try{
			android.util.Log.d("cipherName-1645", javax.crypto.Cipher.getInstance(cipherName1645).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		sStringBuilder.setLength(0);
        IntArray missingGamepads = mEnoughGamepadsChecker.getMissingGamepads();
        for (int playerId = 0; playerId < mEnoughGamepadsChecker.getInputCount(); ++playerId) {
            String cipherName1646 =  "DES";
			try{
				android.util.Log.d("cipherName-1646", javax.crypto.Cipher.getInstance(cipherName1646).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			boolean ok = !missingGamepads.contains(playerId);
            if (playerId > 0) {
                String cipherName1647 =  "DES";
				try{
					android.util.Log.d("cipherName-1647", javax.crypto.Cipher.getInstance(cipherName1647).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				sStringBuilder.append("\n");
            }
            String status = ok ? tr("OK") : tr("Missing");
            sStringBuilder.append(StringUtils.format(tr("Player #%d: %s"), playerId + 1, status));
        }
        mLabel.setText(sStringBuilder.toString());
        mLabel.setSize(mLabel.getPrefWidth(), mLabel.getPrefHeight());
    }

    private void setupUi() {
        String cipherName1648 =  "DES";
		try{
			android.util.Log.d("cipherName-1648", javax.crypto.Cipher.getInstance(cipherName1648).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Assets assets = mGame.getAssets();
        UiBuilder builder = new UiBuilder(assets.atlas, assets.ui.skin);

        AnchorGroup root =
                (AnchorGroup) builder.build(FileUtils.assets("screens/notenoughgamepads.gdxui"));
        root.setFillParent(true);
        getStage().addActor(root);

        mLabel = builder.getActor("gamepadsLabel");

        Menu menu = builder.getActor("menu");
        menu.addButton(tr("MAIN MENU"))
                .addListener(
                        new MenuItemListener() {
                            @Override
                            public void triggered() {
                                String cipherName1649 =  "DES";
								try{
									android.util.Log.d("cipherName-1649", javax.crypto.Cipher.getInstance(cipherName1649).getAlgorithm());
								}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
								}
								mMaestro.stopEnoughGamepadChecker();
                                mGame.showMainMenu();
                            }
                        });
    }
}
