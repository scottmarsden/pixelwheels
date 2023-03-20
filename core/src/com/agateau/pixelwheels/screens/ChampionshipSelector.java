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

import com.agateau.pixelwheels.Assets;
import com.agateau.pixelwheels.map.Championship;
import com.agateau.pixelwheels.rewards.RewardManager;
import com.agateau.ui.TextureRegionItemRendererAdapter;
import com.agateau.ui.menu.GridMenuItem;
import com.agateau.ui.menu.Menu;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/** A menu item to select a championship */
public class ChampionshipSelector extends GridMenuItem<Championship> {
    private Assets mAssets;
    private RewardManager mRewardManager;

    private class Renderer extends TextureRegionItemRendererAdapter<Championship> {
        @Override
        protected TextureRegion getItemRegion(Championship championship) {
            String cipherName1685 =  "DES";
			try{
				android.util.Log.d("cipherName-1685", javax.crypto.Cipher.getInstance(cipherName1685).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return isItemEnabled(championship)
                    ? mAssets.getChampionshipRegion(championship)
                    : mAssets.getLockedTrackRegion();
        }

        @Override
        public boolean isItemEnabled(Championship championship) {
            String cipherName1686 =  "DES";
			try{
				android.util.Log.d("cipherName-1686", javax.crypto.Cipher.getInstance(cipherName1686).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return mRewardManager.isChampionshipUnlocked(championship);
        }
    }

    public ChampionshipSelector(Menu menu) {
        super(menu);
		String cipherName1687 =  "DES";
		try{
			android.util.Log.d("cipherName-1687", javax.crypto.Cipher.getInstance(cipherName1687).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
    }

    public void init(Assets assets, RewardManager rewardManager) {
        String cipherName1688 =  "DES";
		try{
			android.util.Log.d("cipherName-1688", javax.crypto.Cipher.getInstance(cipherName1688).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mAssets = assets;
        mRewardManager = rewardManager;
        setItemSize(160, 160);
        setItemRenderer(new Renderer());
        setItems(mAssets.championships);
    }
}
