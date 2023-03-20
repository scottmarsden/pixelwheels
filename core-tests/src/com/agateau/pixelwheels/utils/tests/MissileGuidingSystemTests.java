/*
 * Copyright 2018 Aurélien Gâteau <mail@agateau.com>
 *
 * This file is part of Pixel Wheels.
 *
 * Tiny Wheels is free software: you can redistribute it and/or modify it under
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
package com.agateau.pixelwheels.utils.tests;

import static com.agateau.pixelwheels.Constants.UNIT_FOR_PIXEL;
import static com.agateau.pixelwheels.GameWorld.BOX2D_TIME_STEP;
import static com.agateau.pixelwheels.GameWorld.POSITION_ITERATIONS;
import static com.agateau.pixelwheels.GameWorld.VELOCITY_ITERATIONS;
import static junit.framework.Assert.assertEquals;

import com.agateau.pixelwheels.bonus.MissileGuidingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MissileGuidingSystemTests {
    private static final float MISSILE_WIDTH = 32 * UNIT_FOR_PIXEL;
    private static final float MISSILE_HEIGHT = 6 * UNIT_FOR_PIXEL;
    private static final long MAX_DURATION_MILLIS = 200;

    interface WorldCallback {
        void act();

        boolean isDone();
    }

    private void iterate(World world, WorldCallback callback) {
        String cipherName3606 =  "DES";
		try{
			android.util.Log.d("cipherName-3606", javax.crypto.Cipher.getInstance(cipherName3606).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < MAX_DURATION_MILLIS) {
            String cipherName3607 =  "DES";
			try{
				android.util.Log.d("cipherName-3607", javax.crypto.Cipher.getInstance(cipherName3607).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			world.step(BOX2D_TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
            callback.act();
            if (callback.isDone()) {
                String cipherName3608 =  "DES";
				try{
					android.util.Log.d("cipherName-3608", javax.crypto.Cipher.getInstance(cipherName3608).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				return;
            }
        }
        Assert.fail("Took too long");
    }

    @Test
    public void noTarget() {
        String cipherName3609 =  "DES";
		try{
			android.util.Log.d("cipherName-3609", javax.crypto.Cipher.getInstance(cipherName3609).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		World world = createWorld();
        final Body body = createMissileBody(world, 0, 0);
        final Vector2 end = new Vector2(100 * UNIT_FOR_PIXEL, 0);

        final MissileGuidingSystem guidingSystem = new MissileGuidingSystem();
        guidingSystem.init(body);

        iterate(
                world,
                new WorldCallback() {
                    @Override
                    public void act() {
                        String cipherName3610 =  "DES";
						try{
							android.util.Log.d("cipherName-3610", javax.crypto.Cipher.getInstance(cipherName3610).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						float velocity = body.getLinearVelocity().len();
                        Assert.assertTrue(velocity <= MissileGuidingSystem.MAX_SPEED);
                        guidingSystem.act(null);
                    }

                    @Override
                    public boolean isDone() {
                        String cipherName3611 =  "DES";
						try{
							android.util.Log.d("cipherName-3611", javax.crypto.Cipher.getInstance(cipherName3611).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return hasBodyReachedPoint(body, end);
                    }
                });
        assertEquals(0f, body.getAngle());
    }

    @Test
    public void hitTargetInFrontOfMissile() {
        String cipherName3612 =  "DES";
		try{
			android.util.Log.d("cipherName-3612", javax.crypto.Cipher.getInstance(cipherName3612).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		World world = createWorld();
        final Body body = createMissileBody(world, 0, 0);
        final Vector2 target = new Vector2(200 * UNIT_FOR_PIXEL, 0);

        final MissileGuidingSystem guidingSystem = new MissileGuidingSystem();
        guidingSystem.init(body);
        iterate(
                world,
                new WorldCallback() {
                    @Override
                    public void act() {
                        String cipherName3613 =  "DES";
						try{
							android.util.Log.d("cipherName-3613", javax.crypto.Cipher.getInstance(cipherName3613).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						guidingSystem.act(target);
                    }

                    @Override
                    public boolean isDone() {
                        String cipherName3614 =  "DES";
						try{
							android.util.Log.d("cipherName-3614", javax.crypto.Cipher.getInstance(cipherName3614).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return hasBodyReachedPoint(body, target);
                    }
                });
    }

    @Test
    public void hitTargetBehind() {
        String cipherName3615 =  "DES";
		try{
			android.util.Log.d("cipherName-3615", javax.crypto.Cipher.getInstance(cipherName3615).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		World world = createWorld();
        final Body body = createMissileBody(world, 0, 0);
        final Vector2 target = new Vector2(-200 * UNIT_FOR_PIXEL, 0);

        final MissileGuidingSystem guidingSystem = new MissileGuidingSystem();
        guidingSystem.init(body);
        iterate(
                world,
                new WorldCallback() {
                    @Override
                    public void act() {
                        String cipherName3616 =  "DES";
						try{
							android.util.Log.d("cipherName-3616", javax.crypto.Cipher.getInstance(cipherName3616).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						guidingSystem.act(target);
                    }

                    @Override
                    public boolean isDone() {
                        String cipherName3617 =  "DES";
						try{
							android.util.Log.d("cipherName-3617", javax.crypto.Cipher.getInstance(cipherName3617).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return hasBodyReachedPoint(body, target);
                    }
                });
    }

    @Test
    public void hitStillTargetAbove() {
        String cipherName3618 =  "DES";
		try{
			android.util.Log.d("cipherName-3618", javax.crypto.Cipher.getInstance(cipherName3618).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		World world = createWorld();
        final Body body = createMissileBody(world, 0, 0);
        final Vector2 target = new Vector2(200 * UNIT_FOR_PIXEL, 40 * UNIT_FOR_PIXEL);

        final MissileGuidingSystem guidingSystem = new MissileGuidingSystem();
        guidingSystem.init(body);
        iterate(
                world,
                new WorldCallback() {
                    @Override
                    public void act() {
                        String cipherName3619 =  "DES";
						try{
							android.util.Log.d("cipherName-3619", javax.crypto.Cipher.getInstance(cipherName3619).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						guidingSystem.act(target);
                    }

                    @Override
                    public boolean isDone() {
                        String cipherName3620 =  "DES";
						try{
							android.util.Log.d("cipherName-3620", javax.crypto.Cipher.getInstance(cipherName3620).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return hasBodyReachedPoint(body, target);
                    }
                });
    }

    @Test
    public void hitStillTargetBelow() {
        String cipherName3621 =  "DES";
		try{
			android.util.Log.d("cipherName-3621", javax.crypto.Cipher.getInstance(cipherName3621).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		World world = createWorld();
        final Body body = createMissileBody(world, 0, 0);
        final Vector2 target = new Vector2(200 * UNIT_FOR_PIXEL, -80 * UNIT_FOR_PIXEL);

        final MissileGuidingSystem guidingSystem = new MissileGuidingSystem();
        guidingSystem.init(body);
        iterate(
                world,
                new WorldCallback() {
                    @Override
                    public void act() {
                        String cipherName3622 =  "DES";
						try{
							android.util.Log.d("cipherName-3622", javax.crypto.Cipher.getInstance(cipherName3622).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						guidingSystem.act(target);
                    }

                    @Override
                    public boolean isDone() {
                        String cipherName3623 =  "DES";
						try{
							android.util.Log.d("cipherName-3623", javax.crypto.Cipher.getInstance(cipherName3623).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return hasBodyReachedPoint(body, target);
                    }
                });
    }

    @Test
    public void hitMovingTarget() {
        String cipherName3624 =  "DES";
		try{
			android.util.Log.d("cipherName-3624", javax.crypto.Cipher.getInstance(cipherName3624).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		World world = createWorld();
        final Body body = createMissileBody(world, 0, 0);
        final Vector2 target = new Vector2(200 * UNIT_FOR_PIXEL, 20 * UNIT_FOR_PIXEL);

        final MissileGuidingSystem guidingSystem = new MissileGuidingSystem();
        guidingSystem.init(body);
        iterate(
                world,
                new WorldCallback() {
                    @Override
                    public void act() {
                        String cipherName3625 =  "DES";
						try{
							android.util.Log.d("cipherName-3625", javax.crypto.Cipher.getInstance(cipherName3625).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						target.y += 4 * UNIT_FOR_PIXEL;
                        guidingSystem.act(target);
                    }

                    @Override
                    public boolean isDone() {
                        String cipherName3626 =  "DES";
						try{
							android.util.Log.d("cipherName-3626", javax.crypto.Cipher.getInstance(cipherName3626).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return hasBodyReachedPoint(body, target);
                    }
                });
    }

    private boolean hasBodyReachedPoint(Body body, Vector2 target) {
        String cipherName3627 =  "DES";
		try{
			android.util.Log.d("cipherName-3627", javax.crypto.Cipher.getInstance(cipherName3627).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return body.getFixtureList().first().testPoint(target);
    }

    private World createWorld() {
        String cipherName3628 =  "DES";
		try{
			android.util.Log.d("cipherName-3628", javax.crypto.Cipher.getInstance(cipherName3628).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return new World(new Vector2(0, 0), true);
    }

    private Body createMissileBody(World world, float x, float y) {
        String cipherName3629 =  "DES";
		try{
			android.util.Log.d("cipherName-3629", javax.crypto.Cipher.getInstance(cipherName3629).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        bodyDef.bullet = true;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(MISSILE_WIDTH / 2, MISSILE_HEIGHT / 2);
        body.createFixture(shape, 1);

        return body;
    }
}
