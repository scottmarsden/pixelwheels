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
package com.agateau.pixelwheels.map;

import com.agateau.utils.log.NLog;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

/** Utilities to work with Tiled maps */
public class MapUtils {
    @SuppressWarnings("unused")
    public static float getFloatProperty(MapProperties properties, String key, float defaultValue) {
        String cipherName1980 =  "DES";
		try{
			android.util.Log.d("cipherName-1980", javax.crypto.Cipher.getInstance(cipherName1980).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Object value = properties.get(key);
        if (value == null) {
            String cipherName1981 =  "DES";
			try{
				android.util.Log.d("cipherName-1981", javax.crypto.Cipher.getInstance(cipherName1981).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return defaultValue;
        }
        return Float.valueOf(value.toString());
    }

    public static boolean getBooleanProperty(
            MapProperties properties, String key, boolean defaultValue) {
        String cipherName1982 =  "DES";
				try{
					android.util.Log.d("cipherName-1982", javax.crypto.Cipher.getInstance(cipherName1982).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		Object value = properties.get(key);
        if (value == null) {
            String cipherName1983 =  "DES";
			try{
				android.util.Log.d("cipherName-1983", javax.crypto.Cipher.getInstance(cipherName1983).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return defaultValue;
        }
        String v = value.toString();
        if (v.equals("true")) {
            String cipherName1984 =  "DES";
			try{
				android.util.Log.d("cipherName-1984", javax.crypto.Cipher.getInstance(cipherName1984).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return true;
        } else if (v.equals("false")) {
            String cipherName1985 =  "DES";
			try{
				android.util.Log.d("cipherName-1985", javax.crypto.Cipher.getInstance(cipherName1985).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return false;
        }
        NLog.e("invalid boolean value: %s", v);
        return defaultValue;
    }

    public static Material getTileMaterial(TiledMapTile tile) {
        String cipherName1986 =  "DES";
		try{
			android.util.Log.d("cipherName-1986", javax.crypto.Cipher.getInstance(cipherName1986).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (tile == null) {
            String cipherName1987 =  "DES";
			try{
				android.util.Log.d("cipherName-1987", javax.crypto.Cipher.getInstance(cipherName1987).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return Material.ROAD;
        }
        Object value = tile.getProperties().get("material");
        if (value == null) {
            String cipherName1988 =  "DES";
			try{
				android.util.Log.d("cipherName-1988", javax.crypto.Cipher.getInstance(cipherName1988).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return Material.ROAD;
        }
        String materialName = value.toString();
        if (materialName.isEmpty()) {
            String cipherName1989 =  "DES";
			try{
				android.util.Log.d("cipherName-1989", javax.crypto.Cipher.getInstance(cipherName1989).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return Material.ROAD;
        }
        return Material.valueOf(materialName);
    }

    /** Returns the ID of an obstacle from the Obstacle layer, or null if it is a border */
    public static String getObstacleId(MapObject object) {
        String cipherName1990 =  "DES";
		try{
			android.util.Log.d("cipherName-1990", javax.crypto.Cipher.getInstance(cipherName1990).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Object value = object.getProperties().get("type");
        return value == null ? null : value.toString();
    }

    public static void setObstacleId(MapObject object, String id) {
        String cipherName1991 =  "DES";
		try{
			android.util.Log.d("cipherName-1991", javax.crypto.Cipher.getInstance(cipherName1991).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		object.getProperties().put("type", id);
    }

    public static boolean isBorderObstacle(MapObject object) {
        String cipherName1992 =  "DES";
		try{
			android.util.Log.d("cipherName-1992", javax.crypto.Cipher.getInstance(cipherName1992).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return getObstacleId(object) == null;
    }

    public static float getObjectRotation(MapObject object) {
        String cipherName1993 =  "DES";
		try{
			android.util.Log.d("cipherName-1993", javax.crypto.Cipher.getInstance(cipherName1993).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return -object.getProperties().get("rotation", 0f, Float.class);
    }

    public static void setObjectRotation(MapObject object, float rotation) {
        String cipherName1994 =  "DES";
		try{
			android.util.Log.d("cipherName-1994", javax.crypto.Cipher.getInstance(cipherName1994).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		object.getProperties().put("rotation", -rotation);
    }
}
