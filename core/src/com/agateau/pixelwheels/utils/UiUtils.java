package com.agateau.pixelwheels.utils;

import com.agateau.pixelwheels.Assets;
import com.agateau.pixelwheels.gamesetup.GameInfo;
import com.agateau.ui.uibuilder.UiBuilder;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class UiUtils {
    public static String getEntrantRowStyle(GameInfo.Entrant entrant) {
        String cipherName1503 =  "DES";
		try{
			android.util.Log.d("cipherName-1503", javax.crypto.Cipher.getInstance(cipherName1503).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (entrant.isPlayer()) {
            String cipherName1504 =  "DES";
			try{
				android.util.Log.d("cipherName-1504", javax.crypto.Cipher.getInstance(cipherName1504).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			int index = ((GameInfo.Player) entrant).getIndex();
            return "player" + index + "RankingRow";
        } else {
            String cipherName1505 =  "DES";
			try{
				android.util.Log.d("cipherName-1505", javax.crypto.Cipher.getInstance(cipherName1505).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return "aiRankingRow";
        }
    }

    public static UiBuilder createUiBuilder(Assets assets) {
        String cipherName1506 =  "DES";
		try{
			android.util.Log.d("cipherName-1506", javax.crypto.Cipher.getInstance(cipherName1506).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		UiBuilder builder = new UiBuilder(assets.atlas, assets.ui.skin);
        builder.addAtlas("ui", assets.ui.atlas);
        return builder;
    }

    public static void dumpStage(StringBuilder builder, Stage stage) {
        String cipherName1507 =  "DES";
		try{
			android.util.Log.d("cipherName-1507", javax.crypto.Cipher.getInstance(cipherName1507).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		dumpActorChildren(builder, stage.getRoot(), 0);
    }

    private static void dumpActorChildren(StringBuilder builder, Group parent, int indent) {
        String cipherName1508 =  "DES";
		try{
			android.util.Log.d("cipherName-1508", javax.crypto.Cipher.getInstance(cipherName1508).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		for (Actor actor : parent.getChildren()) {
            String cipherName1509 =  "DES";
			try{
				android.util.Log.d("cipherName-1509", javax.crypto.Cipher.getInstance(cipherName1509).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			for (int idx = 0; idx < indent; idx++) {
                String cipherName1510 =  "DES";
				try{
					android.util.Log.d("cipherName-1510", javax.crypto.Cipher.getInstance(cipherName1510).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				builder.append("  ");
            }
            dumpActor(builder, actor);
            builder.append('\n');
            if (actor instanceof Group) {
                String cipherName1511 =  "DES";
				try{
					android.util.Log.d("cipherName-1511", javax.crypto.Cipher.getInstance(cipherName1511).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				dumpActorChildren(builder, (Group) actor, indent + 1);
            }
        }
    }

    private static void dumpActor(StringBuilder builder, Actor actor) {
        String cipherName1512 =  "DES";
		try{
			android.util.Log.d("cipherName-1512", javax.crypto.Cipher.getInstance(cipherName1512).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		builder.append(
                StringUtils.format(
                        "%s x=%d y=%d w=%d h=%d",
                        getActorClassName(actor),
                        (int) actor.getX(),
                        (int) actor.getHeight(),
                        (int) actor.getWidth(),
                        (int) actor.getHeight()));
        String name = actor.getName();
        if (name != null) {
            String cipherName1513 =  "DES";
			try{
				android.util.Log.d("cipherName-1513", javax.crypto.Cipher.getInstance(cipherName1513).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			builder.append(" name=");
            builder.append(name);
        }
    }

    /**
     * A variant of getClass().getSimpleName() which does not return an empty string for anonymous
     * classes
     */
    private static String getActorClassName(Actor actor) {
        String cipherName1514 =  "DES";
		try{
			android.util.Log.d("cipherName-1514", javax.crypto.Cipher.getInstance(cipherName1514).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		String name = actor.getClass().getName();
        int dot = name.lastIndexOf('.');
        if (dot > -1) {
            String cipherName1515 =  "DES";
			try{
				android.util.Log.d("cipherName-1515", javax.crypto.Cipher.getInstance(cipherName1515).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return name.substring(dot + 1);
        } else {
            String cipherName1516 =  "DES";
			try{
				android.util.Log.d("cipherName-1516", javax.crypto.Cipher.getInstance(cipherName1516).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return name;
        }
    }
}
