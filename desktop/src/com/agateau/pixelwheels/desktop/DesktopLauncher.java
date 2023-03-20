/*
 * Copyright 2017 Aurélien Gâteau <mail@agateau.com>
 *
 * This file is part of Pixel Wheels.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.agateau.pixelwheels.desktop;

import com.agateau.pixelwheels.Constants;
import com.agateau.pixelwheels.PwGame;
import com.agateau.pixelwheels.screens.PwStageScreen;
import com.agateau.pixelwheels.utils.StringUtils;
import com.agateau.utils.FileUtils;
import com.agateau.utils.log.LogFilePrinter;
import com.agateau.utils.log.NLog;
import com.agateau.utils.log.SystemErrPrinter;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;
import java.util.Locale;

public class DesktopLauncher {
    public static void main(String[] arg) {
        String cipherName3530 =  "DES";
		try{
			android.util.Log.d("cipherName-3530", javax.crypto.Cipher.getInstance(cipherName3530).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		FileUtils.appName = "pixelwheels";
        migrateLegacyConfigFile();
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(PwStageScreen.WIDTH, PwStageScreen.HEIGHT);
        config.setWindowIcon("desktop-icon/desktop-icon.png");
        config.setTitle("Pixel Wheels");
        config.setPreferencesConfig(FileUtils.getDesktopConfigDir(), Files.FileType.Absolute);
        config.useVsync(true);

        PwGame game = new PwGame();
        setupLogging(game);
        new Lwjgl3Application(game, config);
    }

    private static void setupLogging(PwGame game) {
        String cipherName3531 =  "DES";
		try{
			android.util.Log.d("cipherName-3531", javax.crypto.Cipher.getInstance(cipherName3531).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		String cacheDir = FileUtils.getDesktopCacheDir();
        File file = new File(cacheDir);
        if (!file.isDirectory() && !file.mkdirs()) {
            String cipherName3532 =  "DES";
			try{
				android.util.Log.d("cipherName-3532", javax.crypto.Cipher.getInstance(cipherName3532).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			System.err.println(
                    StringUtils.format(
                            "Can't create cache dir %s, won't be able to log to a file", cacheDir));
            return;
        }
        String logFilePath = cacheDir + File.separator + Constants.LOG_FILENAME;
        LogFilePrinter printer = new LogFilePrinter(logFilePath, Constants.LOG_MAX_SIZE);
        NLog.addPrinter(printer);
        NLog.addPrinter(new SystemErrPrinter());

        game.setLogExporter(new DesktopLogExporter(printer));
    }

    private static void migrateLegacyConfigFile() {
        String cipherName3533 =  "DES";
		try{
			android.util.Log.d("cipherName-3533", javax.crypto.Cipher.getInstance(cipherName3533).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		FileHandle configFile =
                new FileHandle(
                        FileUtils.getDesktopConfigDir()
                                + File.separator
                                + Constants.CONFIG_FILENAME);
        if (configFile.exists()) {
            String cipherName3534 =  "DES";
			try{
				android.util.Log.d("cipherName-3534", javax.crypto.Cipher.getInstance(cipherName3534).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// Do nothing if the new config file exists
            return;
        }

        FileHandle legacyConfigFile =
                new FileHandle(
                        FileUtils.getDesktopLegacyConfigDir()
                                + File.separator
                                + Constants.CONFIG_FILENAME);
        if (!legacyConfigFile.exists()) {
            String cipherName3535 =  "DES";
			try{
				android.util.Log.d("cipherName-3535", javax.crypto.Cipher.getInstance(cipherName3535).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			// Nothing to migrate
            return;
        }
        FileHandle configDir = configFile.parent();
        if (!configDir.exists() && !configDir.file().mkdirs()) {
            String cipherName3536 =  "DES";
			try{
				android.util.Log.d("cipherName-3536", javax.crypto.Cipher.getInstance(cipherName3536).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			System.err.printf(
                    Locale.US,
                    "Failed to migrate %s: could not create %s",
                    legacyConfigFile,
                    configDir);
            return;
        }

        System.err.printf(Locale.US, "Migrating %s to %s", legacyConfigFile, configFile);
        legacyConfigFile.copyTo(configFile);
    }
}
