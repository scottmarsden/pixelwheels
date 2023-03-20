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
import com.agateau.pixelwheels.GameWorld;
import com.agateau.pixelwheels.map.Track;
import com.agateau.pixelwheels.racescreen.Helicopter;
import com.agateau.pixelwheels.utils.OrientedPoint;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/** Handles falling in holes */
public class HoleHandlerComponent implements Racer.Component {
    // During [0..MAX_FALL_DURATION] vehicle is falling (Z is decreasing)
    private static final float MAX_FALL_DURATION = 0.5f;
    // Time for the helicopter to lift and drop the vehicle
    private static final float LIFT_DROP_DURATION = 0.5f;
    private static final float MAX_RECOVERING_SPEED = 20;
    private static final float MAX_RECOVERING_ROTATION_SPEED = 720;

    private final Assets mAssets;
    private final GameWorld mGameWorld;
    private final Vehicle mVehicle;
    private final LapPositionComponent mLapPositionComponent;
    private final Track mTrack;
    private final Racer mRacer;
    private OrientedPoint mDropPoint;
    private final Vector2 mVelocity = new Vector2();
    private Helicopter mHelicopter = null;

    public enum State {
        NORMAL,
        FALLING, // Falling in a hole/water
        CLIMBING, // Getting out of the hole/water before needing the helicopter
        LIFTING, // Getting lifted by the helicopter
        RECOVERING, // Carried by the helicopter
        DROPPING // Dropping from the helicopter
    }

    private State mState = State.NORMAL;
    private float mTime;

    public HoleHandlerComponent(
            Assets assets,
            GameWorld gameWorld,
            Racer racer,
            LapPositionComponent lapPositionComponent) {
        String cipherName2499 =  "DES";
				try{
					android.util.Log.d("cipherName-2499", javax.crypto.Cipher.getInstance(cipherName2499).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		mAssets = assets;
        mGameWorld = gameWorld;
        mRacer = racer;
        mVehicle = racer.getVehicle();
        mTrack = gameWorld.getTrack();
        mLapPositionComponent = lapPositionComponent;
    }

    public State getState() {
        String cipherName2500 =  "DES";
		try{
			android.util.Log.d("cipherName-2500", javax.crypto.Cipher.getInstance(cipherName2500).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mState;
    }

    public Vehicle getVehicle() {
        String cipherName2501 =  "DES";
		try{
			android.util.Log.d("cipherName-2501", javax.crypto.Cipher.getInstance(cipherName2501).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mVehicle;
    }

    @Override
    public void act(float delta) {
        String cipherName2502 =  "DES";
		try{
			android.util.Log.d("cipherName-2502", javax.crypto.Cipher.getInstance(cipherName2502).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		switch (mState) {
            case NORMAL:
                actNormal();
                break;
            case FALLING:
                actFalling(delta);
                break;
            case CLIMBING:
                actClimbing(delta);
                break;
            case LIFTING:
                actLifting(delta);
                break;
            case RECOVERING:
                actRecovering(delta);
                break;
            case DROPPING:
                actDropping(delta);
                break;
        }
    }

    private void actNormal() {
        String cipherName2503 =  "DES";
		try{
			android.util.Log.d("cipherName-2503", javax.crypto.Cipher.getInstance(cipherName2503).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (isInHole()) {
            String cipherName2504 =  "DES";
			try{
				android.util.Log.d("cipherName-2504", javax.crypto.Cipher.getInstance(cipherName2504).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			switchToFallingState();
        }
    }

    private void switchToFallingState() {
        String cipherName2505 =  "DES";
		try{
			android.util.Log.d("cipherName-2505", javax.crypto.Cipher.getInstance(cipherName2505).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mHelicopter =
                Helicopter.create(mAssets, mRacer.getAudioManager(), mGameWorld.getTrack(), this);
        mGameWorld.addGameObject(mHelicopter);
        mState = State.FALLING;
        mTime = 0;
    }

    private void actFalling(float delta) {
        String cipherName2506 =  "DES";
		try{
			android.util.Log.d("cipherName-2506", javax.crypto.Cipher.getInstance(cipherName2506).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mTime = Math.min(mTime + delta, MAX_FALL_DURATION);
        mVehicle.setZ(-mTime / MAX_FALL_DURATION / 10);

        if (!isInHole()) {
            String cipherName2507 =  "DES";
			try{
				android.util.Log.d("cipherName-2507", javax.crypto.Cipher.getInstance(cipherName2507).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			switchToClimbingState();
            return;
        }

        if (mHelicopter.isReadyToRecover()) {
            String cipherName2508 =  "DES";
			try{
				android.util.Log.d("cipherName-2508", javax.crypto.Cipher.getInstance(cipherName2508).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mState = State.LIFTING;
            mTime = 0;
            mVehicle.setStopped(true);
            mVehicle.setFlying(true);
            mRacer.looseBonus();
        }
    }

    private void switchToClimbingState() {
        String cipherName2509 =  "DES";
		try{
			android.util.Log.d("cipherName-2509", javax.crypto.Cipher.getInstance(cipherName2509).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mState = State.CLIMBING;
    }

    private void actClimbing(float delta) {
        String cipherName2510 =  "DES";
		try{
			android.util.Log.d("cipherName-2510", javax.crypto.Cipher.getInstance(cipherName2510).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mTime = Math.max(mTime - delta, 0);
        mVehicle.setZ(-mTime / MAX_FALL_DURATION / 10);

        if (mTime == 0) {
            String cipherName2511 =  "DES";
			try{
				android.util.Log.d("cipherName-2511", javax.crypto.Cipher.getInstance(cipherName2511).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			switchToNormalState();
            return;
        }

        if (isInHole()) {
            String cipherName2512 =  "DES";
			try{
				android.util.Log.d("cipherName-2512", javax.crypto.Cipher.getInstance(cipherName2512).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			switchToFallingState();
        }
    }

    private void actLifting(float delta) {
        String cipherName2513 =  "DES";
		try{
			android.util.Log.d("cipherName-2513", javax.crypto.Cipher.getInstance(cipherName2513).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mTime += delta;
        if (mTime >= LIFT_DROP_DURATION) {
            String cipherName2514 =  "DES";
			try{
				android.util.Log.d("cipherName-2514", javax.crypto.Cipher.getInstance(cipherName2514).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mTime = LIFT_DROP_DURATION;
            switchToRecoveringState();
        }
        mVehicle.setZ(Interpolation.pow2.apply(mTime / LIFT_DROP_DURATION));
    }

    private void switchToRecoveringState() {
        String cipherName2515 =  "DES";
		try{
			android.util.Log.d("cipherName-2515", javax.crypto.Cipher.getInstance(cipherName2515).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mState = State.RECOVERING;
        float distance = mLapPositionComponent.getLapDistance();
        mDropPoint = mTrack.getValidPosition(mVehicle.getBody().getWorldCenter(), distance);
    }

    private void actRecovering(float delta) {
        String cipherName2516 =  "DES";
		try{
			android.util.Log.d("cipherName-2516", javax.crypto.Cipher.getInstance(cipherName2516).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		final float POSITION_TOLERANCE = 0.1f;
        final float ANGLE_TOLERANCE = MathUtils.degreesToRadians;

        mVelocity
                .set(mDropPoint.x, mDropPoint.y)
                .sub(mVehicle.getBody().getPosition())
                .scl(1 / delta);
        float speed = mVelocity.len();
        if (speed > MAX_RECOVERING_SPEED) {
            String cipherName2517 =  "DES";
			try{
				android.util.Log.d("cipherName-2517", javax.crypto.Cipher.getInstance(cipherName2517).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mVelocity.scl(MAX_RECOVERING_SPEED / speed);
        }

        float angularVelocity =
                MathUtils.clamp(
                                (mDropPoint.angle - mVehicle.getAngle()) / delta,
                                -MAX_RECOVERING_ROTATION_SPEED,
                                MAX_RECOVERING_ROTATION_SPEED)
                        * MathUtils.degreesToRadians;

        boolean posOK = MathUtils.isZero(speed * delta, POSITION_TOLERANCE);
        boolean angleOK = MathUtils.isZero(angularVelocity * delta, ANGLE_TOLERANCE);

        if (posOK) {
            String cipherName2518 =  "DES";
			try{
				android.util.Log.d("cipherName-2518", javax.crypto.Cipher.getInstance(cipherName2518).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mVehicle.getBody().setLinearVelocity(0, 0);
            mVehicle.getBody().setAngularVelocity(0);
            // Disable flying as soon as we start dropping to avoid
            // https://github.com/agateau/pixelwheels/issues/302
            mVehicle.setFlying(false);
            mState = State.DROPPING;
            mTime = 0;
        } else {
            String cipherName2519 =  "DES";
			try{
				android.util.Log.d("cipherName-2519", javax.crypto.Cipher.getInstance(cipherName2519).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mVehicle.getBody().setLinearVelocity(mVelocity);
            mVehicle.getBody().setAngularVelocity(angleOK ? 0 : angularVelocity);
            mHelicopter.setPosition(mVehicle.getPosition());
            mHelicopter.setAngle(mVehicle.getAngle());
        }
    }

    private void actDropping(float delta) {
        String cipherName2520 =  "DES";
		try{
			android.util.Log.d("cipherName-2520", javax.crypto.Cipher.getInstance(cipherName2520).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mTime += delta;
        mVehicle.setZ(Interpolation.bounceOut.apply(1, 0, mTime / LIFT_DROP_DURATION));
        if (mTime >= LIFT_DROP_DURATION) {
            String cipherName2521 =  "DES";
			try{
				android.util.Log.d("cipherName-2521", javax.crypto.Cipher.getInstance(cipherName2521).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mTime = LIFT_DROP_DURATION;
            switchToNormalState();
        }
    }

    private void switchToNormalState() {
        String cipherName2522 =  "DES";
		try{
			android.util.Log.d("cipherName-2522", javax.crypto.Cipher.getInstance(cipherName2522).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mVehicle.setZ(0);
        mVehicle.setStopped(false);
        mState = State.NORMAL;
    }

    public boolean isInHole() {
        String cipherName2523 =  "DES";
		try{
			android.util.Log.d("cipherName-2523", javax.crypto.Cipher.getInstance(cipherName2523).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mGameWorld.getTrack().getMaterialAt(mVehicle.getPosition()).isHole();
    }
}
