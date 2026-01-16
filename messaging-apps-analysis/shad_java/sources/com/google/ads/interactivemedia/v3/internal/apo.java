package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apo {
    private final apm a;

    public apo(apm apmVar) {
        this.a = apmVar;
    }

    public final byte[] a(byte[] bArr, String str) throws NoSuchPaddingException, apn, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr.length != 16) {
            throw new apn();
        }
        try {
            byte[] bArrA = this.a.a(str);
            int length = bArrA.length;
            if (length <= 16) {
                throw new apn();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
            byteBufferAllocate.put(bArrA);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return cipher.doFinal(bArr3);
        } catch (IllegalArgumentException e) {
            throw new apn(e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new apn(e2);
        } catch (InvalidKeyException e3) {
            throw new apn(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new apn(e4);
        } catch (BadPaddingException e5) {
            throw new apn(e5);
        } catch (IllegalBlockSizeException e6) {
            throw new apn(e6);
        } catch (NoSuchPaddingException e7) {
            throw new apn(e7);
        }
    }

    public final byte[] b() throws apn {
        try {
            byte[] bArrA = this.a.a("dmFUD4yixjCLeIFssMn8+bpXZchyM7ZZjdHVe+zeIw0=");
            if (bArrA.length != 32) {
                throw new apn();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(bArrA, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new apn(e);
        }
    }
}
