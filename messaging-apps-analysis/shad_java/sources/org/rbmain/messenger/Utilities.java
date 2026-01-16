package org.rbmain.messenger;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class Utilities {
    public static Random fastRandom = new SecureRandom();
    public static Pattern pattern = Pattern.compile("[\\-0-9]+");
    public static SecureRandom random = new SecureRandom();
    public static volatile DispatchQueue stageQueue = new DispatchQueue("stageQueue");
    public static volatile DispatchQueue globalQueue = new DispatchQueue("globalQueue");
    public static volatile DispatchQueue searchQueue = new DispatchQueue("searchQueue");
    public static volatile DispatchQueue phoneBookQueue = new DispatchQueue("phoneBookQueue");
    public static volatile DispatchQueue fileQueue = new DispatchQueue("fileQueue");
    public static volatile DispatchQueue myQueue = new DispatchQueue("myQueue");
    public static volatile DispatchQueue themeQueue = new DispatchQueue("themeQueue");
    public static volatile DispatchQueue coreQueue = new DispatchQueue("coreQueue");
    public static volatile DispatchQueue rubinoQueue = new DispatchQueue("rubinoQueue");
    protected static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    /* loaded from: classes4.dex */
    public interface CallBack<R> {
        void run(R r);
    }

    /* loaded from: classes4.dex */
    public interface Callback16<T> {
        void run(T t);
    }

    /* loaded from: classes4.dex */
    public interface Callback2<T, T2> {
        void run(T t, T2 t2);
    }

    /* loaded from: classes4.dex */
    public interface Callback3<T, T2, T3> {
        void run(T t, T2 t2, T3 t3);
    }

    /* loaded from: classes4.dex */
    public interface CallbackReturn<Arg, ReturnType> {
        ReturnType run(Arg arg);
    }

    public static native void aesCbcEncryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    private static native void aesCbcEncryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4);

    public static native void aesCtrDecryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void aesCtrDecryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3);

    private static native void aesIgeEncryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, boolean z, int i, int i2);

    private static native void aesIgeEncryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z, int i, int i2);

    public static native void blurBitmap(Object obj, int i, int i2, int i3, int i4, int i5);

    public static native void calcCDT(ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3);

    public static native void clearDir(String str, int i, long j, boolean z);

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);

    public static native void drawDitheredGradient(Bitmap bitmap, int[] iArr, int i, int i2, int i3, int i4);

    public static native void generateGradient(Bitmap bitmap, boolean z, int i, float f, int i2, int i3, int i4, int[] iArr);

    public static native long getDirSize(String str, int i, boolean z);

    public static native boolean loadWebpImage(Bitmap bitmap, ByteBuffer byteBuffer, int i, BitmapFactory.Options options, boolean z);

    public static native int needInvert(Object obj, int i, int i2, int i3, int i4);

    private static native int pbkdf2(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    public static native int pinBitmap(Bitmap bitmap);

    public static native String readlink(String str);

    public static native String readlinkFd(int i);

    public static native int saveProgressiveJpeg(Bitmap bitmap, int i, int i2, int i3, int i4, String str);

    public static native void stackBlurBitmap(Bitmap bitmap, int i);

    public static native void unpinBitmap(Bitmap bitmap);

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("/dev/urandom"));
            byte[] bArr = new byte[1024];
            fileInputStream.read(bArr);
            fileInputStream.close();
            random.setSeed(bArr);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static Bitmap stackBlurBitmapMax(Bitmap bitmap) {
        int iDp = AndroidUtilities.dp(20.0f);
        int iDp2 = (int) ((AndroidUtilities.dp(20.0f) * bitmap.getHeight()) / bitmap.getWidth());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iDp, iDp2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.scale(bitmapCreateBitmap.getWidth() / bitmap.getWidth(), bitmapCreateBitmap.getHeight() / bitmap.getHeight());
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        stackBlurBitmap(bitmapCreateBitmap, Math.max(10, Math.max(iDp, iDp2) / ImageReceiver.DEFAULT_CROSSFADE_DURATION));
        return bitmapCreateBitmap;
    }

    public static Bitmap blurWallpaper(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap;
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getHeight() > bitmap.getWidth()) {
            bitmapCreateBitmap = Bitmap.createBitmap(Math.round((bitmap.getWidth() * 450.0f) / bitmap.getHeight()), 450, Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(450, Math.round((bitmap.getHeight() * 450.0f) / bitmap.getWidth()), Bitmap.Config.ARGB_8888);
        }
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight()), new Paint(2));
        stackBlurBitmap(bitmapCreateBitmap, 12);
        return bitmapCreateBitmap;
    }

    public static void aesIgeEncryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, boolean z, boolean z2, int i, int i2) {
        if (!z2) {
            bArr2 = (byte[]) bArr2.clone();
        }
        aesIgeEncryption(byteBuffer, bArr, bArr2, z, i, i2);
    }

    public static void aesIgeEncryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z, boolean z2, int i, int i2) {
        if (!z2) {
            bArr3 = (byte[]) bArr3.clone();
        }
        aesIgeEncryptionByteArray(bArr, bArr2, bArr3, z, i, i2);
    }

    public static void aesCbcEncryptionByteArraySafe(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4) {
        aesCbcEncryptionByteArray(bArr, bArr2, (byte[]) bArr3.clone(), i, i2, i3, i4);
    }

    public static Integer parseInt(CharSequence charSequence) throws NumberFormatException {
        int i = 0;
        if (charSequence == null) {
            return 0;
        }
        try {
            Matcher matcher = pattern.matcher(charSequence);
            if (matcher.find()) {
                i = Integer.parseInt(matcher.group(0));
            }
        } catch (Exception unused) {
        }
        return Integer.valueOf(i);
    }

    public static Long parseLong(String str) throws NumberFormatException {
        long j = 0;
        if (str == null) {
            return 0L;
        }
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                j = Long.parseLong(matcher.group(0));
            }
        } catch (Exception unused) {
        }
        return Long.valueOf(j);
    }

    public static String parseIntToString(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static boolean isGoodPrime(byte[] bArr, int i) {
        int iIntValue;
        if (i < 2 || i > 7 || bArr.length != 256 || bArr[0] >= 0) {
            return false;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (i == 2) {
            if (bigInteger.mod(BigInteger.valueOf(8L)).intValue() != 7) {
                return false;
            }
        } else if (i == 3) {
            if (bigInteger.mod(BigInteger.valueOf(3L)).intValue() != 2) {
                return false;
            }
        } else if (i == 5) {
            int iIntValue2 = bigInteger.mod(BigInteger.valueOf(5L)).intValue();
            if (iIntValue2 != 1 && iIntValue2 != 4) {
                return false;
            }
        } else if (i == 6) {
            int iIntValue3 = bigInteger.mod(BigInteger.valueOf(24L)).intValue();
            if (iIntValue3 != 19 && iIntValue3 != 23) {
                return false;
            }
        } else if (i == 7 && (iIntValue = bigInteger.mod(BigInteger.valueOf(7L)).intValue()) != 3 && iIntValue != 5 && iIntValue != 6) {
            return false;
        }
        if (bytesToHex(bArr).equals("C71CAEB9C6B1C9048E6C522F70F13F73980D40238E3E21C14934D037563D930F48198A0AA7C14058229493D22530F4DBFA336F6E0AC925139543AED44CCE7C3720FD51F69458705AC68CD4FE6B6B13ABDC9746512969328454F18FAF8C595F642477FE96BB2A941D5BCD1D4AC8CC49880708FA9B378E3C4F3A9060BEE67CF9A4A4A695811051907E162753B56B0F6B410DBA74D8A84B2A14B3144E0EF1284754FD17ED950D5965B4B9DD46582DB1178D169C6BC465B0D6FF9CA3928FEF5B9AE4E418FC15E83EBEA0F87FA9FF5EED70050DED2849F47BF959D956850CE929851F0D8115F635B105EE2E4E15D04B2454BF6F4FADF034B10403119CD8E3B92FCC5B")) {
            return true;
        }
        return bigInteger.isProbablePrime(30) && bigInteger.subtract(BigInteger.valueOf(1L)).divide(BigInteger.valueOf(2L)).isProbablePrime(30);
    }

    public static boolean isGoodGaAndGb(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(BigInteger.valueOf(1L)) > 0 && bigInteger.compareTo(bigInteger2.subtract(BigInteger.valueOf(1L))) < 0;
    }

    public static boolean arraysEquals(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr == null || bArr2 == null || i < 0 || i2 < 0 || bArr.length - i > bArr2.length - i2 || bArr.length - i < 0 || bArr2.length - i2 < 0) {
            return false;
        }
        boolean z = true;
        for (int i3 = i; i3 < bArr.length; i3++) {
            if (bArr[i3 + i] != bArr2[i3 + i2]) {
                z = false;
            }
        }
        return z;
    }

    public static byte[] computeSHA1(byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, i, i2);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[20];
        }
    }

    public static byte[] computeSHA1(ByteBuffer byteBuffer, int i, int i2) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                byteBuffer.position(i);
                byteBuffer.limit(i2);
                messageDigest.update(byteBuffer);
                return messageDigest.digest();
            } catch (Exception e) {
                FileLog.e(e);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                return new byte[20];
            }
        } finally {
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }

    public static byte[] computeSHA1(ByteBuffer byteBuffer) {
        return computeSHA1(byteBuffer, 0, byteBuffer.limit());
    }

    public static byte[] computeSHA1(byte[] bArr) {
        return computeSHA1(bArr, 0, bArr.length);
    }

    public static byte[] computeSHA256(byte[] bArr) {
        return computeSHA256(bArr, 0, bArr.length);
    }

    public static byte[] computeSHA256(byte[] bArr, int i, int i2) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr, i, i2);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[32];
        }
    }

    public static byte[] computeSHA256(byte[]... bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            for (int i = 0; i < bArr.length; i++) {
                messageDigest.update(bArr[i], 0, bArr[i].length);
            }
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[32];
        }
    }

    public static byte[] computeSHA512(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(bArr, 0, bArr.length);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[64];
        }
    }

    public static byte[] computeSHA512(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(bArr, 0, bArr.length);
            messageDigest.update(bArr2, 0, bArr2.length);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[64];
        }
    }

    public static byte[] computePBKDF2(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[64];
        pbkdf2(bArr, bArr2, bArr3, 100000);
        return bArr3;
    }

    public static byte[] computeSHA512(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(bArr, 0, bArr.length);
            messageDigest.update(bArr2, 0, bArr2.length);
            messageDigest.update(bArr3, 0, bArr3.length);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[64];
        }
    }

    public static byte[] computeSHA256(byte[] bArr, int i, int i2, ByteBuffer byteBuffer, int i3, int i4) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(bArr, i, i2);
                byteBuffer.position(i3);
                byteBuffer.limit(i4);
                messageDigest.update(byteBuffer);
                return messageDigest.digest();
            } catch (Exception e) {
                FileLog.e(e);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                return new byte[32];
            }
        } finally {
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }

    public static long bytesToLong(byte[] bArr) {
        return (bArr[7] << 56) + ((bArr[6] & 255) << 48) + ((bArr[5] & 255) << 40) + ((bArr[4] & 255) << 32) + ((bArr[3] & 255) << 24) + ((bArr[2] & 255) << 16) + ((bArr[1] & 255) << 8) + (bArr[0] & 255);
    }

    public static int bytesToInt(byte[] bArr) {
        return ((bArr[3] & 255) << 24) + ((bArr[2] & 255) << 16) + ((bArr[1] & 255) << 8) + (bArr[0] & 255);
    }

    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(AndroidUtilities.getStringBytes(str));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            FileLog.e(e);
            return null;
        }
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(Math.min(i, i2), i3);
    }

    public static float clamp(float f, float f2, float f3) {
        return Float.isNaN(f) ? f3 : Float.isInfinite(f) ? f2 : Math.max(Math.min(f, f2), f3);
    }
}
