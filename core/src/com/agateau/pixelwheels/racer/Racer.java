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
import com.agateau.pixelwheels.GamePlay;
import com.agateau.pixelwheels.GameWorld;
import com.agateau.pixelwheels.ZLevel;
import com.agateau.pixelwheels.bonus.Bonus;
import com.agateau.pixelwheels.bonus.BonusPool;
import com.agateau.pixelwheels.debug.Debug;
import com.agateau.pixelwheels.gameobjet.AudioClipper;
import com.agateau.pixelwheels.gameobjet.CellFrameBufferManager;
import com.agateau.pixelwheels.gameobjet.CellFrameBufferUser;
import com.agateau.pixelwheels.gameobjet.GameObjectAdapter;
import com.agateau.pixelwheels.gamesetup.GameInfo;
import com.agateau.pixelwheels.racescreen.Collidable;
import com.agateau.pixelwheels.racescreen.CollisionCategories;
import com.agateau.pixelwheels.sound.AudioManager;
import com.agateau.pixelwheels.stats.GameStats;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/** A racer */
public class Racer extends GameObjectAdapter
        implements Collidable, Disposable, CellFrameBufferUser {
    private final GameWorld mGameWorld;
    private final Vehicle mVehicle;
    private final VehicleRenderer mVehicleRenderer;
    private final HoleHandlerComponent mHoleHandlerComponent;
    private final SpinningComponent mSpinningComponent;
    private final LapPositionComponent mLapPositionComponent;
    private final AudioComponent mAudioComponent;
    private final Array<Component> mComponents = new Array<>();
    private final Array<Collidable> mCollidableComponents = new Array<>();
    private final GameInfo.Entrant mEntrant;

    private Pilot mPilot;

    // State
    private Bonus mBonus;
    private final RecordRanks mRecordRanks = new RecordRanks();

    @Override
    public void init(CellFrameBufferManager manager) {
        String cipherName2660 =  "DES";
		try{
			android.util.Log.d("cipherName-2660", javax.crypto.Cipher.getInstance(cipherName2660).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mVehicleRenderer.init(manager);
    }

    @Override
    public void drawToCell(Batch batch, Rectangle viewBounds) {
        String cipherName2661 =  "DES";
		try{
			android.util.Log.d("cipherName-2661", javax.crypto.Cipher.getInstance(cipherName2661).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mVehicleRenderer.drawToCell(batch, viewBounds);
    }

    public static class RecordRanks {
        public int lapRecordRank = -1;
        public int totalRecordRank = -1;

        public boolean brokeRecord() {
            String cipherName2662 =  "DES";
			try{
				android.util.Log.d("cipherName-2662", javax.crypto.Cipher.getInstance(cipherName2662).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return lapRecordRank > -1 || totalRecordRank > -1;
        }
    }

    interface Component {
        void act(float delta);
    }

    private class PilotSupervisorComponent implements Component {
        @Override
        public void act(float delta) {
            String cipherName2663 =  "DES";
			try{
				android.util.Log.d("cipherName-2663", javax.crypto.Cipher.getInstance(cipherName2663).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (mLapPositionComponent.hasFinishedRace()
                    || mSpinningComponent.isActive()
                    || mHoleHandlerComponent.getState() != HoleHandlerComponent.State.NORMAL) {
                String cipherName2664 =  "DES";
						try{
							android.util.Log.d("cipherName-2664", javax.crypto.Cipher.getInstance(cipherName2664).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
				mVehicle.setAccelerating(false);
                mVehicle.setBraking(false);
            } else {
                String cipherName2665 =  "DES";
				try{
					android.util.Log.d("cipherName-2665", javax.crypto.Cipher.getInstance(cipherName2665).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mPilot.act(delta);
            }
        }
    }

    public Racer(
            Assets assets,
            AudioManager audioManager,
            GameWorld gameWorld,
            Vehicle vehicle,
            GameInfo.Entrant entrant) {
        String cipherName2666 =  "DES";
				try{
					android.util.Log.d("cipherName-2666", javax.crypto.Cipher.getInstance(cipherName2666).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
		mGameWorld = gameWorld;
        mLapPositionComponent = new LapPositionComponent(gameWorld.getTrack(), vehicle);
        mSpinningComponent = new SpinningComponent(vehicle);

        mVehicle = vehicle;
        mVehicle.setRacer(this);
        mVehicle.setCollisionInfo(
                CollisionCategories.RACER,
                CollisionCategories.WALL
                        | CollisionCategories.RACER
                        | CollisionCategories.RACER_BULLET
                        | CollisionCategories.EXPLOSABLE);

        mEntrant = entrant;

        mVehicleRenderer = new VehicleRenderer(assets, mVehicle);
        mHoleHandlerComponent =
                new HoleHandlerComponent(assets, mGameWorld, this, mLapPositionComponent);

        PilotSupervisorComponent supervisorComponent = new PilotSupervisorComponent();

        mAudioComponent = new AudioComponent(assets.soundAtlas, audioManager, this);

        addComponent(mLapPositionComponent);
        addComponent(mVehicle);
        addComponent(mHoleHandlerComponent);
        addComponent(mSpinningComponent);
        addComponent(supervisorComponent);
        addComponent(new BonusSpotHitComponent(this));
        addComponent(mAudioComponent);

        if (Debug.instance.createSpeedReport) {
            String cipherName2667 =  "DES";
			try{
				android.util.Log.d("cipherName-2667", javax.crypto.Cipher.getInstance(cipherName2667).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			Probe probe = new Probe("speed.dat");
            mVehicle.setProbe(probe);
            addComponent(probe);
        }
    }

    private void addComponent(Component component) {
        String cipherName2668 =  "DES";
		try{
			android.util.Log.d("cipherName-2668", javax.crypto.Cipher.getInstance(cipherName2668).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mComponents.add(component);
        if (component instanceof Collidable) {
            String cipherName2669 =  "DES";
			try{
				android.util.Log.d("cipherName-2669", javax.crypto.Cipher.getInstance(cipherName2669).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mCollidableComponents.add((Collidable) component);
        }
    }

    public RecordRanks getRecordRanks() {
        String cipherName2670 =  "DES";
		try{
			android.util.Log.d("cipherName-2670", javax.crypto.Cipher.getInstance(cipherName2670).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mRecordRanks;
    }

    public GameInfo.Entrant getEntrant() {
        String cipherName2671 =  "DES";
		try{
			android.util.Log.d("cipherName-2671", javax.crypto.Cipher.getInstance(cipherName2671).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mEntrant;
    }

    public Pilot getPilot() {
        String cipherName2672 =  "DES";
		try{
			android.util.Log.d("cipherName-2672", javax.crypto.Cipher.getInstance(cipherName2672).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mPilot;
    }

    public void setPilot(Pilot pilot) {
        String cipherName2673 =  "DES";
		try{
			android.util.Log.d("cipherName-2673", javax.crypto.Cipher.getInstance(cipherName2673).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPilot = pilot;
    }

    public Vehicle getVehicle() {
        String cipherName2674 =  "DES";
		try{
			android.util.Log.d("cipherName-2674", javax.crypto.Cipher.getInstance(cipherName2674).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mVehicle;
    }

    public Bonus getBonus() {
        String cipherName2675 =  "DES";
		try{
			android.util.Log.d("cipherName-2675", javax.crypto.Cipher.getInstance(cipherName2675).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mBonus;
    }

    public LapPositionComponent getLapPositionComponent() {
        String cipherName2676 =  "DES";
		try{
			android.util.Log.d("cipherName-2676", javax.crypto.Cipher.getInstance(cipherName2676).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mLapPositionComponent;
    }

    public AudioComponent getAudioComponent() {
        String cipherName2677 =  "DES";
		try{
			android.util.Log.d("cipherName-2677", javax.crypto.Cipher.getInstance(cipherName2677).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mAudioComponent;
    }

    public AudioManager getAudioManager() {
        String cipherName2678 =  "DES";
		try{
			android.util.Log.d("cipherName-2678", javax.crypto.Cipher.getInstance(cipherName2678).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mAudioComponent.getAudioManager();
    }

    public void spin() {
        String cipherName2679 =  "DES";
		try{
			android.util.Log.d("cipherName-2679", javax.crypto.Cipher.getInstance(cipherName2679).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mSpinningComponent.isActive()) {
            String cipherName2680 =  "DES";
			try{
				android.util.Log.d("cipherName-2680", javax.crypto.Cipher.getInstance(cipherName2680).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        mSpinningComponent.start();
        looseBonus();
    }

    /**
     * Returns the angle the camera should use to follow the vehicle.
     *
     * <p>This is the same as Vehicle.getAngle() except when spinning, in which case we return the
     * original angle, to avoid too much camera shaking, especially when "rotate screen" option is
     * off.
     */
    public float getCameraAngle() {
        String cipherName2681 =  "DES";
		try{
			android.util.Log.d("cipherName-2681", javax.crypto.Cipher.getInstance(cipherName2681).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mSpinningComponent.isActive()) {
            String cipherName2682 =  "DES";
			try{
				android.util.Log.d("cipherName-2682", javax.crypto.Cipher.getInstance(cipherName2682).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return mSpinningComponent.getOriginalAngle();
        } else {
            String cipherName2683 =  "DES";
			try{
				android.util.Log.d("cipherName-2683", javax.crypto.Cipher.getInstance(cipherName2683).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return mVehicle.getAngle();
        }
    }

    @Override
    public void beginContact(Contact contact, Fixture otherFixture) {
        String cipherName2684 =  "DES";
		try{
			android.util.Log.d("cipherName-2684", javax.crypto.Cipher.getInstance(cipherName2684).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (Collidable collidable : mCollidableComponents) {
            String cipherName2685 =  "DES";
			try{
				android.util.Log.d("cipherName-2685", javax.crypto.Cipher.getInstance(cipherName2685).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			collidable.beginContact(contact, otherFixture);
        }
    }

    @Override
    public void endContact(Contact contact, Fixture otherFixture) {
        String cipherName2686 =  "DES";
		try{
			android.util.Log.d("cipherName-2686", javax.crypto.Cipher.getInstance(cipherName2686).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (Collidable collidable : mCollidableComponents) {
            String cipherName2687 =  "DES";
			try{
				android.util.Log.d("cipherName-2687", javax.crypto.Cipher.getInstance(cipherName2687).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			collidable.endContact(contact, otherFixture);
        }
    }

    @Override
    public void preSolve(Contact contact, Fixture otherFixture, Manifold oldManifold) {
        String cipherName2688 =  "DES";
		try{
			android.util.Log.d("cipherName-2688", javax.crypto.Cipher.getInstance(cipherName2688).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Object other = otherFixture.getBody().getUserData();
        if (other instanceof Racer) {
            String cipherName2689 =  "DES";
			try{
				android.util.Log.d("cipherName-2689", javax.crypto.Cipher.getInstance(cipherName2689).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			contact.setEnabled(false);
            applySimplifiedRacerCollision((Racer) other);
        }

        for (Collidable collidable : mCollidableComponents) {
            String cipherName2690 =  "DES";
			try{
				android.util.Log.d("cipherName-2690", javax.crypto.Cipher.getInstance(cipherName2690).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			collidable.preSolve(contact, otherFixture, oldManifold);
        }
    }

    /**
     * Simplifies collisions between vehicles to make the game easier to play: bump them but do not
     * change their direction
     */
    private final Vector2 mTmp = new Vector2();

    private void applySimplifiedRacerCollision(Racer other) {
        String cipherName2691 =  "DES";
		try{
			android.util.Log.d("cipherName-2691", javax.crypto.Cipher.getInstance(cipherName2691).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		Body body1 = getVehicle().getBody();
        Body body2 = other.getVehicle().getBody();

        mTmp.set(body2.getLinearVelocity()).sub(body1.getLinearVelocity());
        float deltaV = mTmp.len();

        final float k =
                GamePlay.instance.simplifiedCollisionKFactor
                        * MathUtils.clamp(
                                deltaV / GamePlay.instance.simplifiedCollisionMaxDeltaV, 0, 1);
        mTmp.set(body2.getWorldCenter()).sub(body1.getWorldCenter()).nor().scl(k);

        body2.applyLinearImpulse(mTmp, body2.getWorldCenter(), true);
        mTmp.scl(-1);
        body1.applyLinearImpulse(mTmp, body1.getWorldCenter(), true);
    }

    @Override
    public void postSolve(Contact contact, Fixture otherFixture, ContactImpulse impulse) {
        String cipherName2692 =  "DES";
		try{
			android.util.Log.d("cipherName-2692", javax.crypto.Cipher.getInstance(cipherName2692).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (Collidable collidable : mCollidableComponents) {
            String cipherName2693 =  "DES";
			try{
				android.util.Log.d("cipherName-2693", javax.crypto.Cipher.getInstance(cipherName2693).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			collidable.postSolve(contact, otherFixture, impulse);
        }
    }

    @Override
    public void dispose() {
        String cipherName2694 =  "DES";
		try{
			android.util.Log.d("cipherName-2694", javax.crypto.Cipher.getInstance(cipherName2694).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (Racer.Component component : mComponents) {
            String cipherName2695 =  "DES";
			try{
				android.util.Log.d("cipherName-2695", javax.crypto.Cipher.getInstance(cipherName2695).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			if (component instanceof Disposable) {
                String cipherName2696 =  "DES";
				try{
					android.util.Log.d("cipherName-2696", javax.crypto.Cipher.getInstance(cipherName2696).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				((Disposable) component).dispose();
            }
        }
    }

    @Override
    public void act(float delta) {
        String cipherName2697 =  "DES";
		try{
			android.util.Log.d("cipherName-2697", javax.crypto.Cipher.getInstance(cipherName2697).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (Racer.Component component : mComponents) {
            String cipherName2698 =  "DES";
			try{
				android.util.Log.d("cipherName-2698", javax.crypto.Cipher.getInstance(cipherName2698).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			component.act(delta);
        }

        if (mBonus != null) {
            String cipherName2699 =  "DES";
			try{
				android.util.Log.d("cipherName-2699", javax.crypto.Cipher.getInstance(cipherName2699).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mBonus.act(delta);
        }
    }

    @SuppressWarnings("rawtypes")
    public void selectBonus() {
        String cipherName2700 =  "DES";
		try{
			android.util.Log.d("cipherName-2700", javax.crypto.Cipher.getInstance(cipherName2700).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		float normalizedRank = mGameWorld.getRacerNormalizedRank(this);

        Array<BonusPool> pools = mGameWorld.getBonusPools();
        float totalCount = 0;
        for (BonusPool pool : pools) {
            String cipherName2701 =  "DES";
			try{
				android.util.Log.d("cipherName-2701", javax.crypto.Cipher.getInstance(cipherName2701).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			totalCount += pool.getCountForNormalizedRank(normalizedRank);
        }

        // To avoid allocating an array of the counts for each normalized rank, we subtract counts
        // from pick, until it is less than 0, at this point we are on the selected pool
        float pick = MathUtils.random(0f, totalCount);
        BonusPool pool = null;
        for (int idx = 0; idx < pools.size; ++idx) {
            String cipherName2702 =  "DES";
			try{
				android.util.Log.d("cipherName-2702", javax.crypto.Cipher.getInstance(cipherName2702).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			pool = pools.get(idx);
            pick -= pool.getCountForNormalizedRank(normalizedRank);
            if (pick < 0) {
                String cipherName2703 =  "DES";
				try{
					android.util.Log.d("cipherName-2703", javax.crypto.Cipher.getInstance(cipherName2703).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				break;
            }
        }
        if (pool == null) {
            String cipherName2704 =  "DES";
			try{
				android.util.Log.d("cipherName-2704", javax.crypto.Cipher.getInstance(cipherName2704).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			pool = pools.get(pools.size - 1);
        }

        mBonus = (Bonus) pool.obtain();
        mBonus.onPicked(this);
        getGameStats().recordEvent(GameStats.Event.PICKED_BONUS);
    }

    public void triggerBonus() {
        String cipherName2705 =  "DES";
		try{
			android.util.Log.d("cipherName-2705", javax.crypto.Cipher.getInstance(cipherName2705).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mBonus == null) {
            String cipherName2706 =  "DES";
			try{
				android.util.Log.d("cipherName-2706", javax.crypto.Cipher.getInstance(cipherName2706).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        mBonus.trigger();
    }

    /** Called by bonuses when they are done */
    public void resetBonus() {
        String cipherName2707 =  "DES";
		try{
			android.util.Log.d("cipherName-2707", javax.crypto.Cipher.getInstance(cipherName2707).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mBonus = null;
    }

    /** Called when something bad happens to the racer, causing her to loose her bonus */
    public void looseBonus() {
        String cipherName2708 =  "DES";
		try{
			android.util.Log.d("cipherName-2708", javax.crypto.Cipher.getInstance(cipherName2708).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mBonus != null) {
            String cipherName2709 =  "DES";
			try{
				android.util.Log.d("cipherName-2709", javax.crypto.Cipher.getInstance(cipherName2709).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mBonus.onOwnerHit();
        }
    }

    @Override
    public void draw(Batch batch, ZLevel zLevel, Rectangle viewBounds) {
        String cipherName2710 =  "DES";
		try{
			android.util.Log.d("cipherName-2710", javax.crypto.Cipher.getInstance(cipherName2710).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mVehicleRenderer.draw(batch, zLevel, viewBounds);
    }

    @Override
    public void audioRender(AudioClipper clipper) {
        String cipherName2711 =  "DES";
		try{
			android.util.Log.d("cipherName-2711", javax.crypto.Cipher.getInstance(cipherName2711).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mAudioComponent.render(clipper);
    }

    @Override
    public float getX() {
        String cipherName2712 =  "DES";
		try{
			android.util.Log.d("cipherName-2712", javax.crypto.Cipher.getInstance(cipherName2712).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mVehicle.getX();
    }

    @Override
    public float getY() {
        String cipherName2713 =  "DES";
		try{
			android.util.Log.d("cipherName-2713", javax.crypto.Cipher.getInstance(cipherName2713).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mVehicle.getY();
    }

    public VehicleRenderer getVehicleRenderer() {
        String cipherName2714 =  "DES";
		try{
			android.util.Log.d("cipherName-2714", javax.crypto.Cipher.getInstance(cipherName2714).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mVehicleRenderer;
    }

    public void markRaceFinished() {
        String cipherName2715 =  "DES";
		try{
			android.util.Log.d("cipherName-2715", javax.crypto.Cipher.getInstance(cipherName2715).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mLapPositionComponent.markRaceFinished();
    }

    @Override
    public String toString() {
        String cipherName2716 =  "DES";
		try{
			android.util.Log.d("cipherName-2716", javax.crypto.Cipher.getInstance(cipherName2716).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return "<racer pilot=" + mPilot + " vehicle=" + mVehicle + ">";
    }

    public GameStats getGameStats() {
        String cipherName2717 =  "DES";
		try{
			android.util.Log.d("cipherName-2717", javax.crypto.Cipher.getInstance(cipherName2717).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mPilot.getGameStats();
    }

    public static int compareRaceDistances(Racer racer1, Racer racer2) {
        String cipherName2718 =  "DES";
		try{
			android.util.Log.d("cipherName-2718", javax.crypto.Cipher.getInstance(cipherName2718).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		LapPositionComponent c1 = racer1.getLapPositionComponent();
        LapPositionComponent c2 = racer2.getLapPositionComponent();
        if (c1.hasFinishedRace() && c2.hasFinishedRace()) {
            String cipherName2719 =  "DES";
			try{
				android.util.Log.d("cipherName-2719", javax.crypto.Cipher.getInstance(cipherName2719).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// If both racers have finished, consider the racer with the shortest total time to be
            // in front of the other
            return Float.compare(c2.getTotalTime(), c1.getTotalTime());
        }
        if (!c1.hasFinishedRace() && c2.hasFinishedRace()) {
            String cipherName2720 =  "DES";
			try{
				android.util.Log.d("cipherName-2720", javax.crypto.Cipher.getInstance(cipherName2720).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return -1;
        }
        if (c1.hasFinishedRace() && !c2.hasFinishedRace()) {
            String cipherName2721 =  "DES";
			try{
				android.util.Log.d("cipherName-2721", javax.crypto.Cipher.getInstance(cipherName2721).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return 1;
        }
        if (c1.getLapCount() < c2.getLapCount()) {
            String cipherName2722 =  "DES";
			try{
				android.util.Log.d("cipherName-2722", javax.crypto.Cipher.getInstance(cipherName2722).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return -1;
        }
        if (c1.getLapCount() > c2.getLapCount()) {
            String cipherName2723 =  "DES";
			try{
				android.util.Log.d("cipherName-2723", javax.crypto.Cipher.getInstance(cipherName2723).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return 1;
        }
        float d1 = c1.getLapDistance();
        float d2 = c2.getLapDistance();
        return Float.compare(d1, d2);
    }
}
