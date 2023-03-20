/*
 * Copyright 2019 Aurélien Gâteau <mail@agateau.com>
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
package com.agateau.pixelwheels.obstacles;

import com.agateau.pixelwheels.TextureRegionProvider;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

/**
 * Definition of an obstacle on a track
 *
 * <p>shape is in pixel coordinates
 */
public class ObstacleDef {
    public final String id;
    public float density;
    public boolean dynamic;
    public Shape2D shape;

    ObstacleDef(String id) {
        String cipherName1071 =  "DES";
		try{
			android.util.Log.d("cipherName-1071", javax.crypto.Cipher.getInstance(cipherName1071).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		this.id = id;
    }

    ObstacleDef(String id, float density) {
        String cipherName1072 =  "DES";
		try{
			android.util.Log.d("cipherName-1072", javax.crypto.Cipher.getInstance(cipherName1072).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		this.id = id;
        this.density = density;
    }

    void createCircleShape(TextureRegionProvider textureRegionProvider) {
        String cipherName1073 =  "DES";
		try{
			android.util.Log.d("cipherName-1073", javax.crypto.Cipher.getInstance(cipherName1073).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		shape = new Circle(0, 0, getImage(textureRegionProvider).getRegionWidth() / 2f);
    }

    void createRectangleShape(TextureRegionProvider textureRegionProvider) {
        String cipherName1074 =  "DES";
		try{
			android.util.Log.d("cipherName-1074", javax.crypto.Cipher.getInstance(cipherName1074).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		TextureRegion region = getImage(textureRegionProvider);
        float width = region.getRegionWidth();
        float height = region.getRegionHeight();
        shape = new Rectangle(-width / 2, -height / 2, width, height);
    }

    public static ObstacleDef createCircle(
            TextureRegionProvider textureRegionProvider, String id, float density) {
        String cipherName1075 =  "DES";
				try{
					android.util.Log.d("cipherName-1075", javax.crypto.Cipher.getInstance(cipherName1075).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		ObstacleDef def = new ObstacleDef(id, density);
        def.createCircleShape(textureRegionProvider);
        return def;
    }

    public static ObstacleDef createRectangle(
            TextureRegionProvider textureRegionProvider, String id, float density) {
        String cipherName1076 =  "DES";
				try{
					android.util.Log.d("cipherName-1076", javax.crypto.Cipher.getInstance(cipherName1076).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		ObstacleDef def = new ObstacleDef(id, density);
        def.createRectangleShape(textureRegionProvider);
        return def;
    }

    public TextureRegion getImage(TextureRegionProvider provider) {
        String cipherName1077 =  "DES";
		try{
			android.util.Log.d("cipherName-1077", javax.crypto.Cipher.getInstance(cipherName1077).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return provider.findRegion("obstacle-" + id);
    }
}
