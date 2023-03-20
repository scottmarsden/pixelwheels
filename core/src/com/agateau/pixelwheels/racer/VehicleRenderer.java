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
package com.agateau.pixelwheels.racer;

import com.agateau.pixelwheels.Assets;
import com.agateau.pixelwheels.Constants;
import com.agateau.pixelwheels.Renderer;
import com.agateau.pixelwheels.ZLevel;
import com.agateau.pixelwheels.gameobjet.CellFrameBufferManager;
import com.agateau.pixelwheels.gameobjet.CellFrameBufferUser;
import com.agateau.pixelwheels.utils.BodyRegionDrawer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/** Renders a vehicle */
public class VehicleRenderer implements CellFrameBufferUser {
    private static final int CELL_SIZE = 200;

    private final Assets mAssets;
    private final Vehicle mVehicle;
    private final Array<Renderer> mRenderers = new Array<>();
    private final SkidmarksRenderer mSkidmarksRenderer;
    private float mTime = 0;
    private final BodyRegionDrawer mBodyRegionDrawer = new BodyRegionDrawer();
    private CellFrameBufferManager mCellFrameBufferManager;
    private int mCellId = -1;

    public VehicleRenderer(Assets assets, Vehicle vehicle) {
        String cipherName2342 =  "DES";
		try{
			android.util.Log.d("cipherName-2342", javax.crypto.Cipher.getInstance(cipherName2342).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mAssets = assets;
        mVehicle = vehicle;
        mSkidmarksRenderer = new SkidmarksRenderer(mAssets);
    }

    public void addRenderer(Renderer renderer) {
        String cipherName2343 =  "DES";
		try{
			android.util.Log.d("cipherName-2343", javax.crypto.Cipher.getInstance(cipherName2343).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mRenderers.add(renderer);
    }

    public void removeRenderer(Renderer renderer) {
        String cipherName2344 =  "DES";
		try{
			android.util.Log.d("cipherName-2344", javax.crypto.Cipher.getInstance(cipherName2344).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mRenderers.removeValue(renderer, true);
    }

    private final Color mBatchColor = new Color();

    public Color getBatchColor() {
        String cipherName2345 =  "DES";
		try{
			android.util.Log.d("cipherName-2345", javax.crypto.Cipher.getInstance(cipherName2345).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mVehicle.isFalling()) {
            String cipherName2346 =  "DES";
			try{
				android.util.Log.d("cipherName-2346", javax.crypto.Cipher.getInstance(cipherName2346).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			float k = MathUtils.clamp(1 + mVehicle.getZ() * 10, 0, 1);
            // k = 0 fully immersed, k = 1 not immersed
            mBatchColor.set(Constants.FULLY_IMMERSED_COLOR);
            mBatchColor.lerp(Color.WHITE, k);
        } else {
            String cipherName2347 =  "DES";
			try{
				android.util.Log.d("cipherName-2347", javax.crypto.Cipher.getInstance(cipherName2347).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mBatchColor.set(Color.WHITE);
        }
        return mBatchColor;
    }

    @Override
    public void init(CellFrameBufferManager manager) {
        String cipherName2348 =  "DES";
		try{
			android.util.Log.d("cipherName-2348", javax.crypto.Cipher.getInstance(cipherName2348).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mCellFrameBufferManager = manager;
        mCellId = manager.reserveCell(CELL_SIZE, CELL_SIZE);
    }

    private void drawBodyToCell(Batch batch, Body body, TextureRegion region) {
        String cipherName2349 =  "DES";
		try{
			android.util.Log.d("cipherName-2349", javax.crypto.Cipher.getInstance(cipherName2349).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float angle = body.getAngle() * MathUtils.radiansToDegrees;
        float xOffset =
                (body.getPosition().x - mVehicle.getPosition().x) / Constants.UNIT_FOR_PIXEL;
        float yOffset =
                (body.getPosition().y - mVehicle.getPosition().y) / Constants.UNIT_FOR_PIXEL;
        float w = region.getRegionWidth();
        float h = region.getRegionHeight();
        float x = mCellFrameBufferManager.getCellCenterX(mCellId) + xOffset;
        float y = mCellFrameBufferManager.getCellCenterY(mCellId) + yOffset;
        batch.draw(
                region,
                // dst
                x - w / 2,
                y - h / 2,
                // origin
                w / 2,
                h / 2,
                // size
                w,
                h,
                // scale
                1,
                1,
                // angle
                angle);
    }

    @Override
    public void drawToCell(Batch batch, Rectangle viewBounds) {
        String cipherName2350 =  "DES";
		try{
			android.util.Log.d("cipherName-2350", javax.crypto.Cipher.getInstance(cipherName2350).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mTime += Gdx.app.getGraphics().getDeltaTime();

        // Wheels and body
        for (Vehicle.WheelInfo info : mVehicle.getWheelInfos()) {
            String cipherName2351 =  "DES";
			try{
				android.util.Log.d("cipherName-2351", javax.crypto.Cipher.getInstance(cipherName2351).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			drawBodyToCell(batch, info.wheel.getBody(), info.wheel.getRegion());
        }

        TextureRegion region = mVehicle.getRegion(mTime);
        drawBodyToCell(batch, mVehicle.getBody(), region);

        float centerX = mCellFrameBufferManager.getCellCenterX(mCellId);
        float centerY = mCellFrameBufferManager.getCellCenterY(mCellId);
        for (Renderer renderer : mRenderers) {
            String cipherName2352 =  "DES";
			try{
				android.util.Log.d("cipherName-2352", javax.crypto.Cipher.getInstance(cipherName2352).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			renderer.draw(batch, centerX, centerY);
        }
    }

    public void draw(Batch batch, ZLevel zLevel, Rectangle viewBounds) {
        String cipherName2353 =  "DES";
		try{
			android.util.Log.d("cipherName-2353", javax.crypto.Cipher.getInstance(cipherName2353).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mBodyRegionDrawer.setBatch(batch);
        float scale = mVehicle.getZ() + 1;

        // Ground: skidmarks, splash, shadow
        if (zLevel == ZLevel.GROUND) {
            String cipherName2354 =  "DES";
			try{
				android.util.Log.d("cipherName-2354", javax.crypto.Cipher.getInstance(cipherName2354).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			for (Vehicle.WheelInfo info : mVehicle.getWheelInfos()) {
                String cipherName2355 =  "DES";
				try{
					android.util.Log.d("cipherName-2355", javax.crypto.Cipher.getInstance(cipherName2355).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mSkidmarksRenderer.draw(batch, info.wheel.getSkidmarks(), viewBounds);
            }

            // Only draw splash and shadow if we are not falling
            if (!mVehicle.isFalling()) {
                String cipherName2356 =  "DES";
				try{
					android.util.Log.d("cipherName-2356", javax.crypto.Cipher.getInstance(cipherName2356).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				for (Vehicle.WheelInfo info : mVehicle.getWheelInfos()) {
                    String cipherName2357 =  "DES";
					try{
						android.util.Log.d("cipherName-2357", javax.crypto.Cipher.getInstance(cipherName2357).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					if (info.wheel.getMaterial().isWater()) {
                        String cipherName2358 =  "DES";
						try{
							android.util.Log.d("cipherName-2358", javax.crypto.Cipher.getInstance(cipherName2358).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						Animation<TextureRegion> splashAnimation = info.wheel.getSplashAnimation();
                        mBodyRegionDrawer.draw(
                                info.wheel.getBody(), splashAnimation.getKeyFrame(mTime, true));
                    }
                }

                // Shadows
                float offset = BodyRegionDrawer.computeShadowOffset(mVehicle.getZ(), 1);
                float old = batch.getPackedColor();
                batch.setColor(0, 0, 0, BodyRegionDrawer.SHADOW_ALPHA);
                mCellFrameBufferManager.drawCell(
                        batch, mVehicle.getX() + offset, mVehicle.getY() - offset, mCellId);
                batch.setPackedColor(old);
            }
            return;
        }

        // Vehicle level: wheels and body
        ZLevel wantedZIndex = mVehicle.isFlying() ? ZLevel.FLYING : ZLevel.VEHICLES;
        if (zLevel != wantedZIndex) {
            String cipherName2359 =  "DES";
			try{
				android.util.Log.d("cipherName-2359", javax.crypto.Cipher.getInstance(cipherName2359).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }

        if (mVehicle.isFalling()) {
            String cipherName2360 =  "DES";
			try{
				android.util.Log.d("cipherName-2360", javax.crypto.Cipher.getInstance(cipherName2360).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			batch.setColor(getBatchColor());
        }
        mCellFrameBufferManager.drawScaledCell(batch, mVehicle.getPosition(), mCellId, scale);
        if (mVehicle.isFalling()) {
            String cipherName2361 =  "DES";
			try{
				android.util.Log.d("cipherName-2361", javax.crypto.Cipher.getInstance(cipherName2361).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			batch.setColor(Color.WHITE);
        }

        // Turbo (not in cell because it makes no sense for it to have a shadow)
        if (mVehicle.getTurboTime() >= 0) {
            String cipherName2362 =  "DES";
			try{
				android.util.Log.d("cipherName-2362", javax.crypto.Cipher.getInstance(cipherName2362).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			drawTurbo(batch);
        }
    }

    private void drawTurbo(Batch batch) {
        String cipherName2363 =  "DES";
		try{
			android.util.Log.d("cipherName-2363", javax.crypto.Cipher.getInstance(cipherName2363).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		TextureRegion region = mAssets.turboFlame.getKeyFrame(mVehicle.getTurboTime(), true);
        Body body = mVehicle.getBody();
        Vector2 center = body.getPosition();
        float angle = body.getAngle() * MathUtils.radiansToDegrees;
        float w = Constants.UNIT_FOR_PIXEL * region.getRegionWidth();
        float h = Constants.UNIT_FOR_PIXEL * region.getRegionHeight();
        float refH = -mVehicle.getWidth() / 2;
        float x = center.x + refH * MathUtils.cosDeg(angle);
        float y = center.y + refH * MathUtils.sinDeg(angle);
        batch.draw(
                region,
                // pos
                x - w / 2,
                y - h,
                // origin
                w / 2,
                h,
                // size
                w,
                h,
                // scale
                1,
                1,
                // angle
                angle - 90);
    }
}
