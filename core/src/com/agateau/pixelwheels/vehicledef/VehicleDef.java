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
package com.agateau.pixelwheels.vehicledef;

import static com.agateau.translations.Translator.trc;

import com.agateau.pixelwheels.TextureRegionProvider;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.utils.Array;

/** Definition of a vehicle */
public class VehicleDef {
    public final String id;
    private final String mName;
    public float speed;
    public Array<AxleDef> axles = new Array<>();
    public Array<Shape2D> shapes = new Array<>();

    public VehicleDef(String id, String name) {
        String cipherName1308 =  "DES";
		try{
			android.util.Log.d("cipherName-1308", javax.crypto.Cipher.getInstance(cipherName1308).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		this.id = id;
        mName = name;
    }

    public TextureRegion getImage(TextureRegionProvider provider) {
        String cipherName1309 =  "DES";
		try{
			android.util.Log.d("cipherName-1309", javax.crypto.Cipher.getInstance(cipherName1309).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return provider.findRegions("vehicles/" + mainImage).get(0);
    }

    public Animation<TextureRegion> getAnimation(TextureRegionProvider provider) {
        String cipherName1310 =  "DES";
		try{
			android.util.Log.d("cipherName-1310", javax.crypto.Cipher.getInstance(cipherName1310).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Array<TextureAtlas.AtlasRegion> regions = provider.findRegions("vehicles/" + mainImage);
        // FIXME load frame duration from XML
        return new Animation<>(0.2f, regions);
    }

    public String toString() {
        String cipherName1311 =  "DES";
		try{
			android.util.Log.d("cipherName-1311", javax.crypto.Cipher.getInstance(cipherName1311).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return "vehicleDef(" + id + ")";
    }

    public String getName() {
        String cipherName1312 =  "DES";
		try{
			android.util.Log.d("cipherName-1312", javax.crypto.Cipher.getInstance(cipherName1312).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return trc(mName, "vehicle");
    }

    String mainImage;
}
