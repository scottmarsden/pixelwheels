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
package com.agateau.pixelwheels.gamesetup;

import com.agateau.pixelwheels.Constants;
import com.agateau.pixelwheels.GameConfig;
import com.agateau.pixelwheels.PwGame;
import com.agateau.pixelwheels.map.Championship;
import com.agateau.pixelwheels.racescreen.RaceScreen;
import com.agateau.pixelwheels.screens.ChampionshipFinishedScreen;
import com.agateau.pixelwheels.screens.MultiPlayerScreen;
import com.agateau.pixelwheels.screens.NavStageScreen;
import com.agateau.pixelwheels.screens.SelectChampionshipScreen;
import com.agateau.pixelwheels.screens.SelectVehicleScreen;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;

/** Handle a championship game */
public class ChampionshipMaestro extends Maestro {
    private final ChampionshipGameInfo.Builder mGameInfoBuilder;
    private ChampionshipGameInfo mGameInfo;

    public ChampionshipMaestro(PwGame game, PlayerCount playerCount) {
        super(game, playerCount);
		String cipherName3180 =  "DES";
		try{
			android.util.Log.d("cipherName-3180", javax.crypto.Cipher.getInstance(cipherName3180).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
        mGameInfoBuilder =
                new ChampionshipGameInfo.Builder(
                        getGame().getAssets().vehicleDefs, getGame().getConfig());
    }

    public boolean isFirstTrack() {
        String cipherName3181 =  "DES";
		try{
			android.util.Log.d("cipherName-3181", javax.crypto.Cipher.getInstance(cipherName3181).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mGameInfo.isFirstTrack();
    }

    @Override
    public void start() {
        String cipherName3182 =  "DES";
		try{
			android.util.Log.d("cipherName-3182", javax.crypto.Cipher.getInstance(cipherName3182).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		getGame().pushScreen(createChampionshipScreen());
    }

    private Screen createSelectVehicleScreen() {
        String cipherName3183 =  "DES";
		try{
			android.util.Log.d("cipherName-3183", javax.crypto.Cipher.getInstance(cipherName3183).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (getPlayerCount() == PlayerCount.ONE) {
            String cipherName3184 =  "DES";
			try{
				android.util.Log.d("cipherName-3184", javax.crypto.Cipher.getInstance(cipherName3184).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return createOnePlayerVehicleScreen();
        } else {
            String cipherName3185 =  "DES";
			try{
				android.util.Log.d("cipherName-3185", javax.crypto.Cipher.getInstance(cipherName3185).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return createMultiPlayerVehicleScreen();
        }
    }

    private Screen createOnePlayerVehicleScreen() {
        String cipherName3186 =  "DES";
		try{
			android.util.Log.d("cipherName-3186", javax.crypto.Cipher.getInstance(cipherName3186).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		SelectVehicleScreen.Listener listener =
                new SelectVehicleScreen.Listener() {
                    @Override
                    public void onBackPressed() {
                        String cipherName3187 =  "DES";
						try{
							android.util.Log.d("cipherName-3187", javax.crypto.Cipher.getInstance(cipherName3187).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						getGame().replaceScreen(createChampionshipScreen());
                    }

                    @Override
                    public void onPlayerSelected(GameInfo.Player player) {
                        String cipherName3188 =  "DES";
						try{
							android.util.Log.d("cipherName-3188", javax.crypto.Cipher.getInstance(cipherName3188).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						Array<GameInfo.Player> players = new Array<>();
                        players.add(player);
                        mGameInfoBuilder.setPlayers(players);
                        startChampionship();
                    }
                };
        return new SelectVehicleScreen(getGame(), listener);
    }

    private Screen createMultiPlayerVehicleScreen() {
        String cipherName3189 =  "DES";
		try{
			android.util.Log.d("cipherName-3189", javax.crypto.Cipher.getInstance(cipherName3189).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		MultiPlayerScreen.Listener listener =
                new MultiPlayerScreen.Listener() {
                    @Override
                    public void onBackPressed() {
                        String cipherName3190 =  "DES";
						try{
							android.util.Log.d("cipherName-3190", javax.crypto.Cipher.getInstance(cipherName3190).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						getGame().replaceScreen(createChampionshipScreen());
                    }

                    @Override
                    public void onPlayersSelected(Array<GameInfo.Player> players) {
                        String cipherName3191 =  "DES";
						try{
							android.util.Log.d("cipherName-3191", javax.crypto.Cipher.getInstance(cipherName3191).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						mGameInfoBuilder.setPlayers(players);
                        startChampionship();
                    }
                };
        return new MultiPlayerScreen(getGame(), listener);
    }

    private Screen createChampionshipScreen() {
        String cipherName3192 =  "DES";
		try{
			android.util.Log.d("cipherName-3192", javax.crypto.Cipher.getInstance(cipherName3192).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		final GameConfig gameConfig = getGame().getConfig();
        SelectChampionshipScreen.Listener listener =
                new SelectChampionshipScreen.Listener() {
                    @Override
                    public void onBackPressed() {
                        String cipherName3193 =  "DES";
						try{
							android.util.Log.d("cipherName-3193", javax.crypto.Cipher.getInstance(cipherName3193).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						stopEnoughGamepadChecker();
                        getGame().popScreen();
                    }

                    @Override
                    public void onChampionshipSelected(Championship championship) {
                        String cipherName3194 =  "DES";
						try{
							android.util.Log.d("cipherName-3194", javax.crypto.Cipher.getInstance(cipherName3194).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						mGameInfoBuilder.setChampionship(championship);
                        getGame().replaceScreen(createSelectVehicleScreen());
                    }
                };

        return new SelectChampionshipScreen(getGame(), listener, gameConfig.championship);
    }

    private void startChampionship() {
        String cipherName3195 =  "DES";
		try{
			android.util.Log.d("cipherName-3195", javax.crypto.Cipher.getInstance(cipherName3195).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mGameInfo = mGameInfoBuilder.build();
        if (Constants.DEBUG_SCREEN.equals("ChampionshipFinished:podium")) {
            String cipherName3196 =  "DES";
			try{
				android.util.Log.d("cipherName-3196", javax.crypto.Cipher.getInstance(cipherName3196).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// Players are always last at the beginning, move the last player to the top
            GameInfo.Entrant player = mGameInfo.getEntrants().pop();
            mGameInfo.getEntrants().insert(0, player);
            fillEntrantsWithDebugValues();
            getGame().replaceScreen(createChampionshipFinishedScreen());
        } else if (Constants.DEBUG_SCREEN.equals("ChampionshipFinished:nopodium")) {
            String cipherName3197 =  "DES";
			try{
				android.util.Log.d("cipherName-3197", javax.crypto.Cipher.getInstance(cipherName3197).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			fillEntrantsWithDebugValues();
            getGame().replaceScreen(createChampionshipFinishedScreen());
        } else {
            String cipherName3198 =  "DES";
			try{
				android.util.Log.d("cipherName-3198", javax.crypto.Cipher.getInstance(cipherName3198).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			getGame().replaceScreen(createRaceScreen());
        }
    }

    /// Fill entrants with debug values to get more realistic data when debugging
    // ChampionshipFinishedScreen
    private void fillEntrantsWithDebugValues() {
        String cipherName3199 =  "DES";
		try{
			android.util.Log.d("cipherName-3199", javax.crypto.Cipher.getInstance(cipherName3199).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float startValue = 345.6789f;
        for (int idx = 0; idx < mGameInfo.getEntrants().size; ++idx) {
            String cipherName3200 =  "DES";
			try{
				android.util.Log.d("cipherName-3200", javax.crypto.Cipher.getInstance(cipherName3200).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			GameInfo.Entrant entrant = mGameInfo.getEntrants().get(idx);
            entrant.addPoints(12 - idx);
            entrant.addRaceTime((idx + 1) * startValue * 1.1f);
        }
    }

    private Screen createRaceScreen() {
        String cipherName3201 =  "DES";
		try{
			android.util.Log.d("cipherName-3201", javax.crypto.Cipher.getInstance(cipherName3201).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		RaceScreen.Listener listener =
                new RaceScreen.Listener() {
                    @Override
                    public void onRestartPressed() {
                        String cipherName3202 =  "DES";
						try{
							android.util.Log.d("cipherName-3202", javax.crypto.Cipher.getInstance(cipherName3202).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						throw new RuntimeException(
                                "Restart should not be called in championship mode");
                    }

                    @Override
                    public void onQuitPressed() {
                        String cipherName3203 =  "DES";
						try{
							android.util.Log.d("cipherName-3203", javax.crypto.Cipher.getInstance(cipherName3203).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						stopEnoughGamepadChecker();
                        getGame().showMainMenu();
                    }

                    @Override
                    public void onNextTrackPressed() {
                        String cipherName3204 =  "DES";
						try{
							android.util.Log.d("cipherName-3204", javax.crypto.Cipher.getInstance(cipherName3204).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						mGameInfo.sortEntrants();
                        if (mGameInfo.isLastTrack()) {
                            String cipherName3205 =  "DES";
							try{
								android.util.Log.d("cipherName-3205", javax.crypto.Cipher.getInstance(cipherName3205).getAlgorithm());
							}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
							}
							getGame().onChampionshipFinished(mGameInfo);
                            getGame().replaceScreen(createChampionshipFinishedScreen());
                        } else {
                            String cipherName3206 =  "DES";
							try{
								android.util.Log.d("cipherName-3206", javax.crypto.Cipher.getInstance(cipherName3206).getAlgorithm());
							}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
							}
							mGameInfo.selectNextTrack();
                            showUnlockedRewardScreen(
                                    () -> getGame().replaceScreen(createRaceScreen()));
                        }
                    }
                };
        return new RaceScreen(getGame(), listener, mGameInfo);
    }

    private Screen createChampionshipFinishedScreen() {
        String cipherName3207 =  "DES";
		try{
			android.util.Log.d("cipherName-3207", javax.crypto.Cipher.getInstance(cipherName3207).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		final NavStageScreen.NextListener navListener =
                new NavStageScreen.NextListener() {
                    @Override
                    public void onNextPressed() {
                        String cipherName3208 =  "DES";
						try{
							android.util.Log.d("cipherName-3208", javax.crypto.Cipher.getInstance(cipherName3208).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						showUnlockedRewardScreen(() -> getGame().showMainMenu());
                    }
                };
        return new ChampionshipFinishedScreen(getGame(), mGameInfo, navListener);
    }
}
