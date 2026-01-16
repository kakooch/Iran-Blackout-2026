package com.github.faucamp.simplertmp;

import android.util.Log;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class Crypto {
    private Mac hmacSHA256;

    public Crypto() {
        try {
            this.hmacSHA256 = Mac.getInstance("HmacSHA256");
        } catch (SecurityException e) {
            Log.e("Crypto", "Security exception when getting HMAC", e);
        } catch (NoSuchAlgorithmException unused) {
            Log.e("Crypto", "HMAC SHA256 does not exist");
        }
    }

    public byte[] calculateHmacSHA256(byte[] bArr, byte[] bArr2, int i) throws InvalidKeyException {
        try {
            this.hmacSHA256.init(new SecretKeySpec(bArr2, 0, i, "HmacSHA256"));
            return this.hmacSHA256.doFinal(bArr);
        } catch (InvalidKeyException e) {
            Log.e("Crypto", "Invalid key", e);
            return null;
        }
    }
}
