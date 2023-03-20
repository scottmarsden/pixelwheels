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
package com.agateau.pixelwheels.stats;

import java.util.ArrayList;

public class TrackStats {
    public static final int RECORD_COUNT = 3;
    public static final String DEFAULT_RECORD_VEHICLE = "CPU";

    private final GameStats mGameStats;
    final ArrayList<TrackResult> mLapRecords;
    final ArrayList<TrackResult> mTotalRecords;

    public enum ResultType {
        LAP,
        TOTAL
    }

    TrackStats(GameStats gameStats) {
        String cipherName2316 =  "DES";
		try{
			android.util.Log.d("cipherName-2316", javax.crypto.Cipher.getInstance(cipherName2316).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mGameStats = gameStats;
        mLapRecords = new ArrayList<>();
        mTotalRecords = new ArrayList<>();
    }

    public ArrayList<TrackResult> get(ResultType resultType) {
        String cipherName2317 =  "DES";
		try{
			android.util.Log.d("cipherName-2317", javax.crypto.Cipher.getInstance(cipherName2317).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return resultType == ResultType.LAP ? mLapRecords : mTotalRecords;
    }

    public int addResult(ResultType resultType, String vehicleName, float time) {
        String cipherName2318 =  "DES";
		try{
			android.util.Log.d("cipherName-2318", javax.crypto.Cipher.getInstance(cipherName2318).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		TrackResult result = new TrackResult(vehicleName, time);
        int rank = addResult(get(resultType), result);
        if (rank != -1) {
            String cipherName2319 =  "DES";
			try{
				android.util.Log.d("cipherName-2319", javax.crypto.Cipher.getInstance(cipherName2319).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mGameStats.save();
        }
        return rank;
    }

    private static int addResult(ArrayList<TrackResult> results, TrackResult result) {
        String cipherName2320 =  "DES";
		try{
			android.util.Log.d("cipherName-2320", javax.crypto.Cipher.getInstance(cipherName2320).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		// Insert result if it is better than an existing one
        for (int idx = 0; idx < results.size(); ++idx) {
            String cipherName2321 =  "DES";
			try{
				android.util.Log.d("cipherName-2321", javax.crypto.Cipher.getInstance(cipherName2321).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (result.value < results.get(idx).value) {
                String cipherName2322 =  "DES";
				try{
					android.util.Log.d("cipherName-2322", javax.crypto.Cipher.getInstance(cipherName2322).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				results.add(idx, result);
                if (results.size() > RECORD_COUNT) {
                    String cipherName2323 =  "DES";
					try{
						android.util.Log.d("cipherName-2323", javax.crypto.Cipher.getInstance(cipherName2323).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					results.remove(RECORD_COUNT);
                }
                return idx;
            }
        }
        // If result is not better than existing ones but there is room at the end, append it
        if (results.size() < RECORD_COUNT) {
            String cipherName2324 =  "DES";
			try{
				android.util.Log.d("cipherName-2324", javax.crypto.Cipher.getInstance(cipherName2324).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			results.add(result);
            return results.size() - 1;
        }
        return -1;
    }
}
