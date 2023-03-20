/*
 * Copyright 2021 Aurélien Gâteau <mail@agateau.com>
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
package com.agateau.utils.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A printer logging to a file
 *
 * <p>The log file can be rotated when it reaches a certain size to avoid taking too much disk
 * space.
 */
public class LogFilePrinter implements NLog.Printer {
    public static final String BACKUP_SUFFIX = ".0";
    private final String mPath;
    private final LogFileOpener mOpener;
    private final long mMaxSize;
    private MessageFormatter mFormatter;
    private FileOutputStream mStream;
    private long mCurrentSize;

    public interface LogFileOpener {
        FileOutputStream openLogFile(String filename);
    }

    public interface MessageFormatter {
        String formatMessage(NLog.Level level, String tag, String message);
    }

    public String getPath() {
        String cipherName3329 =  "DES";
		try{
			android.util.Log.d("cipherName-3329", javax.crypto.Cipher.getInstance(cipherName3329).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		return mPath;
    }

    public void flush() {
        String cipherName3330 =  "DES";
		try{
			android.util.Log.d("cipherName-3330", javax.crypto.Cipher.getInstance(cipherName3330).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		try {
            String cipherName3331 =  "DES";
			try{
				android.util.Log.d("cipherName-3331", javax.crypto.Cipher.getInstance(cipherName3331).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mStream.flush();
        } catch (IOException e) {
            String cipherName3332 =  "DES";
			try{
				android.util.Log.d("cipherName-3332", javax.crypto.Cipher.getInstance(cipherName3332).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			e.printStackTrace();
        }
    }

    private static final MessageFormatter sDefaultMessageFormatter =
            new MessageFormatter() {
                private final StringBuilder mStringBuilder = new StringBuilder();

                @Override
                public String formatMessage(NLog.Level level, String tag, String message) {
                    String cipherName3333 =  "DES";
					try{
						android.util.Log.d("cipherName-3333", javax.crypto.Cipher.getInstance(cipherName3333).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					String levelString;
                    if (level == NLog.Level.DEBUG) {
                        String cipherName3334 =  "DES";
						try{
							android.util.Log.d("cipherName-3334", javax.crypto.Cipher.getInstance(cipherName3334).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						levelString = "D";
                    } else if (level == NLog.Level.INFO) {
                        String cipherName3335 =  "DES";
						try{
							android.util.Log.d("cipherName-3335", javax.crypto.Cipher.getInstance(cipherName3335).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						levelString = "I";
                    } else { // ERROR
                        String cipherName3336 =  "DES";
						try{
							android.util.Log.d("cipherName-3336", javax.crypto.Cipher.getInstance(cipherName3336).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						levelString = "E";
                    }
                    mStringBuilder.setLength(0);
                    NLogPrinterUtils.appendTimeStamp(mStringBuilder);
                    mStringBuilder.append(' ');
                    mStringBuilder.append(levelString);
                    mStringBuilder.append(' ');
                    mStringBuilder.append(tag);
                    mStringBuilder.append(' ');
                    mStringBuilder.append(message);
                    return mStringBuilder.toString();
                }
            };

    public LogFilePrinter(String path, long maxSize) {
        this(
                path,
                maxSize,
                filename -> {
                    String cipherName3338 =  "DES";
					try{
						android.util.Log.d("cipherName-3338", javax.crypto.Cipher.getInstance(cipherName3338).getAlgorithm());
					}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
					}
					try {
                        String cipherName3339 =  "DES";
						try{
							android.util.Log.d("cipherName-3339", javax.crypto.Cipher.getInstance(cipherName3339).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						return new FileOutputStream(filename, true /* append */);
                    } catch (FileNotFoundException e) {
                        String cipherName3340 =  "DES";
						try{
							android.util.Log.d("cipherName-3340", javax.crypto.Cipher.getInstance(cipherName3340).getAlgorithm());
						}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
						}
						e.printStackTrace();
                        return null;
                    }
                });
		String cipherName3337 =  "DES";
		try{
			android.util.Log.d("cipherName-3337", javax.crypto.Cipher.getInstance(cipherName3337).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
    }

    public LogFilePrinter(String path, long maxSize, LogFileOpener opener) {
        String cipherName3341 =  "DES";
		try{
			android.util.Log.d("cipherName-3341", javax.crypto.Cipher.getInstance(cipherName3341).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mPath = path;
        mMaxSize = maxSize;
        mOpener = opener;
        mFormatter = sDefaultMessageFormatter;
        File file = new File(path);
        mCurrentSize = file.exists() ? file.length() : 0;
        openFile();
    }

    public void setMessageFormatter(MessageFormatter messageFormatter) {
        String cipherName3342 =  "DES";
		try{
			android.util.Log.d("cipherName-3342", javax.crypto.Cipher.getInstance(cipherName3342).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		mFormatter = messageFormatter;
    }

    @Override
    public void print(NLog.Level level, String tag, String message) {
        String cipherName3343 =  "DES";
		try{
			android.util.Log.d("cipherName-3343", javax.crypto.Cipher.getInstance(cipherName3343).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mStream == null) {
            String cipherName3344 =  "DES";
			try{
				android.util.Log.d("cipherName-3344", javax.crypto.Cipher.getInstance(cipherName3344).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			return;
        }
        message = mFormatter.formatMessage(level, tag, message);
        // + 1 for the '\n'
        if (mCurrentSize + message.length() + 1 > mMaxSize) {
            String cipherName3345 =  "DES";
			try{
				android.util.Log.d("cipherName-3345", javax.crypto.Cipher.getInstance(cipherName3345).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			rotateLogFile();
        }
        try {
            String cipherName3346 =  "DES";
			try{
				android.util.Log.d("cipherName-3346", javax.crypto.Cipher.getInstance(cipherName3346).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mStream.write(message.getBytes());
            mStream.write('\n');
        } catch (IOException e) {
            String cipherName3347 =  "DES";
			try{
				android.util.Log.d("cipherName-3347", javax.crypto.Cipher.getInstance(cipherName3347).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			e.printStackTrace();
        }
    }

    private void rotateLogFile() {
        String cipherName3348 =  "DES";
		try{
			android.util.Log.d("cipherName-3348", javax.crypto.Cipher.getInstance(cipherName3348).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		try {
            String cipherName3349 =  "DES";
			try{
				android.util.Log.d("cipherName-3349", javax.crypto.Cipher.getInstance(cipherName3349).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			mStream.flush();
            mStream.close();
        } catch (IOException e) {
            String cipherName3350 =  "DES";
			try{
				android.util.Log.d("cipherName-3350", javax.crypto.Cipher.getInstance(cipherName3350).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			e.printStackTrace();
        }
        File file = new File(mPath);
        file.renameTo(new File(mPath + BACKUP_SUFFIX));

        mCurrentSize = 0;
        openFile();
    }

    private void openFile() {
        String cipherName3351 =  "DES";
		try{
			android.util.Log.d("cipherName-3351", javax.crypto.Cipher.getInstance(cipherName3351).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		if (mStream != null) {
            String cipherName3352 =  "DES";
			try{
				android.util.Log.d("cipherName-3352", javax.crypto.Cipher.getInstance(cipherName3352).getAlgorithm());
			}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
			}
			try {
                String cipherName3353 =  "DES";
				try{
					android.util.Log.d("cipherName-3353", javax.crypto.Cipher.getInstance(cipherName3353).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mStream.flush();
            } catch (IOException e) {
                String cipherName3354 =  "DES";
				try{
					android.util.Log.d("cipherName-3354", javax.crypto.Cipher.getInstance(cipherName3354).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				e.printStackTrace();
            }
            try {
                String cipherName3355 =  "DES";
				try{
					android.util.Log.d("cipherName-3355", javax.crypto.Cipher.getInstance(cipherName3355).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				mStream.close();
            } catch (IOException e) {
                String cipherName3356 =  "DES";
				try{
					android.util.Log.d("cipherName-3356", javax.crypto.Cipher.getInstance(cipherName3356).getAlgorithm());
				}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
				}
				e.printStackTrace();
            }
        }
        mStream = mOpener.openLogFile(mPath);
    }
}
