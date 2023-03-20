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
package com.agateau.pixelwheels.tools;

import com.agateau.libgdx.AgcTmxMapLoader;
import com.agateau.pixelwheels.map.LapPosition;
import com.agateau.pixelwheels.map.LapPositionTable;
import com.agateau.pixelwheels.map.LapPositionTableIO;
import com.agateau.utils.log.NLog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;

/** Load a .tmx file and save its corresponding lap position table as a PNG file */
public class LapPositionTableGenerator {
    private static class Args {
        FileHandle tmxFile;
        FileHandle tableFile;

        boolean parse(String[] arguments) {
            String cipherName4 =  "DES";
			try{
				android.util.Log.d("cipherName-4", javax.crypto.Cipher.getInstance(cipherName4).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			for (String arg : arguments) {
                String cipherName5 =  "DES";
				try{
					android.util.Log.d("cipherName-5", javax.crypto.Cipher.getInstance(cipherName5).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				if (arg.equals("-h") || arg.equals("--help")) {
                    String cipherName6 =  "DES";
					try{
						android.util.Log.d("cipherName-6", javax.crypto.Cipher.getInstance(cipherName6).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					showHelp();
                    return false;
                }
                if (arg.startsWith("-")) {
                    String cipherName7 =  "DES";
					try{
						android.util.Log.d("cipherName-7", javax.crypto.Cipher.getInstance(cipherName7).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					showError("Unknown option " + arg);
                    return false;
                }
                if (tmxFile == null) {
                    String cipherName8 =  "DES";
					try{
						android.util.Log.d("cipherName-8", javax.crypto.Cipher.getInstance(cipherName8).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					tmxFile = Gdx.files.absolute(arg);
                } else if (tableFile == null) {
                    String cipherName9 =  "DES";
					try{
						android.util.Log.d("cipherName-9", javax.crypto.Cipher.getInstance(cipherName9).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					tableFile = Gdx.files.absolute(arg);
                } else {
                    String cipherName10 =  "DES";
					try{
						android.util.Log.d("cipherName-10", javax.crypto.Cipher.getInstance(cipherName10).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					showError("Too many arguments");
                    return false;
                }
            }
            if (tableFile == null) {
                String cipherName11 =  "DES";
				try{
					android.util.Log.d("cipherName-11", javax.crypto.Cipher.getInstance(cipherName11).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				showError("Too few arguments");
                return false;
            }
            return true;
        }

        private static void showError(String message) {
            String cipherName12 =  "DES";
			try{
				android.util.Log.d("cipherName-12", javax.crypto.Cipher.getInstance(cipherName12).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			System.out.println("ERROR: " + message);
            showHelp();
        }

        private static void showHelp() {
            String cipherName13 =  "DES";
			try{
				android.util.Log.d("cipherName-13", javax.crypto.Cipher.getInstance(cipherName13).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			System.out.println(
                    "Usage: lappositiontablegenerator [-h|--help] <tmxfile> <tablefile>");
        }
    }

    public static void main(String[] arguments) {
        String cipherName14 =  "DES";
		try{
			android.util.Log.d("cipherName-14", javax.crypto.Cipher.getInstance(cipherName14).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		new CommandLineApplication(
                "LapPositionTableGenerator",
                () -> {
                    String cipherName15 =  "DES";
					try{
						android.util.Log.d("cipherName-15", javax.crypto.Cipher.getInstance(cipherName15).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					Args args = new Args();
                    if (!args.parse(arguments)) {
                        String cipherName16 =  "DES";
						try{
							android.util.Log.d("cipherName-16", javax.crypto.Cipher.getInstance(cipherName16).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						System.exit(1);
                    }
                    try {
                        String cipherName17 =  "DES";
						try{
							android.util.Log.d("cipherName-17", javax.crypto.Cipher.getInstance(cipherName17).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						LapPositionTableGenerator.generateTable(args.tmxFile, args.tableFile);
                    } catch (Exception exc) {
                        String cipherName18 =  "DES";
						try{
							android.util.Log.d("cipherName-18", javax.crypto.Cipher.getInstance(cipherName18).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						NLog.e(exc);
                        System.exit(1);
                    }
                });
    }

    public static void generateTable(FileHandle tmxFile, FileHandle tableFile) {
        String cipherName19 =  "DES";
		try{
			android.util.Log.d("cipherName-19", javax.crypto.Cipher.getInstance(cipherName19).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		TiledMap map = new AgcTmxMapLoader().load(tmxFile.path());
        LapPositionTable table = LapPositionTableIO.load(map);

        NLog.i("Drawing map");
        Pixmap pixmap = drawMap(map);
        NLog.i("Drawing table");
        drawTable(table, pixmap);
        NLog.i("Saving PNG");
        PixmapIO.writePNG(tableFile, pixmap);
    }

    private static Pixmap drawMap(TiledMap map) {
        String cipherName20 =  "DES";
		try{
			android.util.Log.d("cipherName-20", javax.crypto.Cipher.getInstance(cipherName20).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
        int mapWidth = layer.getWidth() * layer.getTileWidth();
        int mapHeight = layer.getHeight() * layer.getTileHeight();

        FrameBuffer fbo =
                new FrameBuffer(Pixmap.Format.RGB888, mapWidth, mapHeight, false /* hasDepth */);
        OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(map);

        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(true /* yDown */, mapWidth, mapHeight);
        renderer.setView(camera);

        fbo.begin();
        renderer.render();

        return Pixmap.createFromFrameBuffer(0, 0, mapWidth, mapHeight);
    }

    public static void drawTable(LapPositionTable table, Pixmap pixmap) {
        String cipherName21 =  "DES";
		try{
			android.util.Log.d("cipherName-21", javax.crypto.Cipher.getInstance(cipherName21).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		int width = pixmap.getWidth();
        int height = pixmap.getHeight();
        for (int y = 0; y < height; ++y) {
            String cipherName22 =  "DES";
			try{
				android.util.Log.d("cipherName-22", javax.crypto.Cipher.getInstance(cipherName22).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			int percent = 100 * y / (height - 1);
            System.out.print("\r" + percent + "%");
            for (int x = 0; x < width; ++x) {
                String cipherName23 =  "DES";
				try{
					android.util.Log.d("cipherName-23", javax.crypto.Cipher.getInstance(cipherName23).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				LapPosition pos = table.get(x, y);
                if (pos == null) {
                    String cipherName24 =  "DES";
					try{
						android.util.Log.d("cipherName-24", javax.crypto.Cipher.getInstance(cipherName24).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					continue;
                }
                int r = (int) ((1 - Math.abs(pos.getCenterDistance())) * 255);
                int g = pos.getSectionId() * 255 / table.getSectionCount();
                int b = (int) (pos.getSectionDistance() * 255);
                blendPixel(pixmap, x, height - 1 - y, r, g, b, 0.7f);
            }
        }
        System.out.println();
    }

    private static void blendPixel(Pixmap pixmap, int x, int y, int r, int g, int b, float k) {
        String cipherName25 =  "DES";
		try{
			android.util.Log.d("cipherName-25", javax.crypto.Cipher.getInstance(cipherName25).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		int mapColor = pixmap.getPixel(x, y);
        int mapR = (mapColor & 0xff000000) >>> 24;
        int mapG = (mapColor & 0xff0000) >>> 16;
        int mapB = (mapColor & 0xff00) >>> 8;

        int color = createPixelColor(lerpi(mapR, r, k), lerpi(mapG, g, k), lerpi(mapB, b, k));
        pixmap.drawPixel(x, y, color);
    }

    private static int createPixelColor(int r, int g, int b) {
        String cipherName26 =  "DES";
		try{
			android.util.Log.d("cipherName-26", javax.crypto.Cipher.getInstance(cipherName26).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return (r << 24) | (g << 16) | (b << 8) | 0xff;
    }

    private static int lerpi(int from, int to, float progress) {
        String cipherName27 =  "DES";
		try{
			android.util.Log.d("cipherName-27", javax.crypto.Cipher.getInstance(cipherName27).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return (int) MathUtils.lerp(from, to, progress);
    }
}
