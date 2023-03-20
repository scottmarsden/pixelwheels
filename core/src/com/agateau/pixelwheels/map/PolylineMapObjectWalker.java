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
package com.agateau.pixelwheels.map;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Vector2;

class PolylineMapObjectWalker implements MapObjectWalker {
    private MapObject mMapObject;

    @Override
    public void setMapObject(MapObject object) {
        String cipherName2008 =  "DES";
		try{
			android.util.Log.d("cipherName-2008", javax.crypto.Cipher.getInstance(cipherName2008).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mMapObject = object;
    }

    @Override
    public void walk(float stepWidth, float stepHeight, WalkFunction function) {
        String cipherName2009 =  "DES";
		try{
			android.util.Log.d("cipherName-2009", javax.crypto.Cipher.getInstance(cipherName2009).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Vector2 v1 = new Vector2();
        Vector2 v2 = new Vector2();
        Polyline polyline = ((PolylineMapObject) mMapObject).getPolyline();

        float[] vertices = polyline.getTransformedVertices();
        int count = vertices.length / 2;
        v1.set(vertices[0], vertices[1]);
        for (int idx = 1; idx < count; ++idx) {
            String cipherName2010 =  "DES";
			try{
				android.util.Log.d("cipherName-2010", javax.crypto.Cipher.getInstance(cipherName2010).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			v2.set(vertices[2 * idx], vertices[2 * idx + 1]);
            walkVector(v1, v2, stepWidth, function);
            v1.set(v2);
        }
    }

    private static final Vector2 sTmp = new Vector2();

    private void walkVector(Vector2 v1, Vector2 v2, float stepSize, WalkFunction function) {
        String cipherName2011 =  "DES";
		try{
			android.util.Log.d("cipherName-2011", javax.crypto.Cipher.getInstance(cipherName2011).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		sTmp.set(v2).sub(v1);
        float distance = sTmp.len() - stepSize;
        float angle = sTmp.angleRad();
        int itemCount = MathUtils.floor(distance / stepSize);

        sTmp.nor().scl(stepSize);
        // Space between items
        float dx = sTmp.x;
        float dy = sTmp.y;

        sTmp.set(v1).add(dx / 2, dy / 2);
        for (int i = 0; i <= itemCount; ++i) {
            String cipherName2012 =  "DES";
			try{
				android.util.Log.d("cipherName-2012", javax.crypto.Cipher.getInstance(cipherName2012).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			function.walk(sTmp.x, sTmp.y, angle);
            sTmp.add(dx, dy);
        }
    }
}
