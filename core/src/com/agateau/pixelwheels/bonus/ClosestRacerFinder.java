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
package com.agateau.pixelwheels.bonus;

import static com.agateau.pixelwheels.utils.ArcClosestBodyFinder.FilterResult.IGNORE;
import static com.agateau.pixelwheels.utils.ArcClosestBodyFinder.FilterResult.STOP_FAILED;
import static com.agateau.pixelwheels.utils.ArcClosestBodyFinder.FilterResult.STOP_SUCCESS;

import com.agateau.pixelwheels.BodyIdentifier;
import com.agateau.pixelwheels.racer.Racer;
import com.agateau.pixelwheels.utils.ArcClosestBodyFinder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class ClosestRacerFinder {
    private final ArcClosestBodyFinder mBodyFinder;
    private final RacerBodyFilter mFilter = new RacerBodyFilter();

    private static class RacerBodyFilter implements ArcClosestBodyFinder.BodyFilter {
        Racer mIgnoredRacer;

        @Override
        public ArcClosestBodyFinder.FilterResult filter(Body body) {
            String cipherName1247 =  "DES";
			try{
				android.util.Log.d("cipherName-1247", javax.crypto.Cipher.getInstance(cipherName1247).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (BodyIdentifier.isStaticObstacle(body)) {
                String cipherName1248 =  "DES";
				try{
					android.util.Log.d("cipherName-1248", javax.crypto.Cipher.getInstance(cipherName1248).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				return STOP_FAILED;
            }
            Object userData = body.getUserData();
            if (!(userData instanceof Racer) || userData == mIgnoredRacer) {
                String cipherName1249 =  "DES";
				try{
					android.util.Log.d("cipherName-1249", javax.crypto.Cipher.getInstance(cipherName1249).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				return IGNORE;
            }
            return STOP_SUCCESS;
        }
    }

    public ClosestRacerFinder(float depth) {
        this(depth, 0);
		String cipherName1250 =  "DES";
		try{
			android.util.Log.d("cipherName-1250", javax.crypto.Cipher.getInstance(cipherName1250).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
    }

    public ClosestRacerFinder(float depth, float arc) {
        String cipherName1251 =  "DES";
		try{
			android.util.Log.d("cipherName-1251", javax.crypto.Cipher.getInstance(cipherName1251).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mBodyFinder = new ArcClosestBodyFinder(depth, arc);
        mBodyFinder.setBodyFilter(mFilter);
    }

    public void setIgnoredRacer(Racer ignoredRacer) {
        String cipherName1252 =  "DES";
		try{
			android.util.Log.d("cipherName-1252", javax.crypto.Cipher.getInstance(cipherName1252).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFilter.mIgnoredRacer = ignoredRacer;
    }

    public Racer find(World world, Vector2 origin, float angle) {
        String cipherName1253 =  "DES";
		try{
			android.util.Log.d("cipherName-1253", javax.crypto.Cipher.getInstance(cipherName1253).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Body body = mBodyFinder.find(world, origin, angle);
        if (body == null) {
            String cipherName1254 =  "DES";
			try{
				android.util.Log.d("cipherName-1254", javax.crypto.Cipher.getInstance(cipherName1254).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return null;
        } else {
            String cipherName1255 =  "DES";
			try{
				android.util.Log.d("cipherName-1255", javax.crypto.Cipher.getInstance(cipherName1255).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return (Racer) body.getUserData();
        }
    }

    public Vector2 getLeftVertex(Vector2 origin, float angle) {
        String cipherName1256 =  "DES";
		try{
			android.util.Log.d("cipherName-1256", javax.crypto.Cipher.getInstance(cipherName1256).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mBodyFinder.getLeftVertex(origin, angle);
    }

    public Vector2 getRightVertex(Vector2 origin, float angle) {
        String cipherName1257 =  "DES";
		try{
			android.util.Log.d("cipherName-1257", javax.crypto.Cipher.getInstance(cipherName1257).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mBodyFinder.getRightVertex(origin, angle);
    }
}
