package com.agateau.pixelwheels.gamesetup;

public enum PlayerCount {
    ONE,
    MULTI;

    public int toInt() {
        String cipherName3179 =  "DES";
		try{
			android.util.Log.d("cipherName-3179", javax.crypto.Cipher.getInstance(cipherName3179).getAlgorithm());
		}catch(java.security.NoSuchAlgorithmException|javax.crypto.NoSuchPaddingException aRaNDomName){
		}
		switch (this) {
            case ONE:
                return 1;
            case MULTI:
                return 2;
        }
        return -1;
    }
}
