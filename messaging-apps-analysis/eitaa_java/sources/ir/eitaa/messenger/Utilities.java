package ir.eitaa.messenger;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class Utilities {
    public static Pattern pattern = Pattern.compile("[\\-0-9]+");
    public static SecureRandom random = new SecureRandom();
    public static volatile DispatchQueue stageQueue = new DispatchQueue("stageQueue");
    public static volatile DispatchQueue globalQueue = new DispatchQueue("globalQueue");
    public static volatile DispatchQueue socketQueue = new DispatchQueue("socketQueue");
    public static volatile DispatchQueue cacheClearQueue = new DispatchQueue("cacheClearQueue");
    public static volatile DispatchQueue searchQueue = new DispatchQueue("searchQueue");
    public static volatile DispatchQueue phoneBookQueue = new DispatchQueue("phoneBookQueue");
    protected static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static native void aesCbcEncryption(ByteBuffer buffer, byte[] key, byte[] iv, int offset, int length, int encrypt);

    private static native void aesCbcEncryptionByteArray(byte[] buffer, byte[] key, byte[] iv, int offset, int length, int n, int encrypt);

    public static native void aesCtrDecryption(ByteBuffer buffer, byte[] key, byte[] iv, int offset, int length);

    public static native void aesCtrDecryptionByteArray(byte[] buffer, byte[] key, byte[] iv, int offset, int length, int n);

    private static native void aesIgeEncryption(ByteBuffer buffer, byte[] key, byte[] iv, boolean encrypt, int offset, int length);

    private static native void aesIgeEncryptionByteArray(byte[] buffer, byte[] key, byte[] iv, boolean encrypt, int offset, int length);

    public static native void blurBitmap(Object bitmap, int radius, int unpin, int width, int height, int stride);

    public static native void calcCDT(ByteBuffer hsvBuffer, int width, int height, ByteBuffer buffer, ByteBuffer calcBuffer);

    public static native void clearDir(String path, int docType, long time, boolean subdirs);

    public static native int convertVideoFrame(ByteBuffer src, ByteBuffer dest, int destFormat, int width, int height, int padding, int swap);

    public static native void drawDitheredGradient(Bitmap bitmap, int[] colors, int startX, int startY, int endX, int endY);

    public static native void generateGradient(Bitmap bitmap, boolean unpin, int phase, float progress, int width, int height, int stride, int[] colors);

    public static native long getDirSize(String path, int docType, boolean subdirs);

    public static byte[] intToBytes(int value) {
        return new byte[]{(byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value};
    }

    public static native boolean loadWebpImage(Bitmap bitmap, ByteBuffer buffer, int len, BitmapFactory.Options options, boolean unpin);

    public static native int needInvert(Object bitmap, int unpin, int width, int height, int stride);

    private static native int pbkdf2(byte[] password, byte[] salt, byte[] dst, int iterations);

    public static native int pinBitmap(Bitmap bitmap);

    public static native String readlink(String path);

    public static native String readlinkFd(int fd);

    public static native int saveProgressiveJpeg(Bitmap bitmap, int width, int height, int stride, int quality, String path);

    public static native void stackBlurBitmap(Bitmap bitmap, int radius);

    public static native void unpinBitmap(Bitmap bitmap);

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("/dev/urandom"));
            byte[] bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
            fileInputStream.read(bArr);
            fileInputStream.close();
            random.setSeed(bArr);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static Bitmap scaleBitmap(Bitmap bm, float scale) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap blurWallpaper(Bitmap src) {
        Bitmap bitmapCreateBitmap;
        if (src == null) {
            return null;
        }
        if (src.getHeight() > src.getWidth()) {
            bitmapCreateBitmap = Bitmap.createBitmap(Math.round((src.getWidth() * 450.0f) / src.getHeight()), 450, Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(450, Math.round((src.getHeight() * 450.0f) / src.getWidth()), Bitmap.Config.ARGB_8888);
        }
        new Canvas(bitmapCreateBitmap).drawBitmap(src, (Rect) null, new Rect(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight()), new Paint(2));
        stackBlurBitmap(bitmapCreateBitmap, 12);
        return bitmapCreateBitmap;
    }

    public static void aesIgeEncryption(ByteBuffer buffer, byte[] key, byte[] iv, boolean encrypt, boolean changeIv, int offset, int length) {
        if (!changeIv) {
            iv = (byte[]) iv.clone();
        }
        aesIgeEncryption(buffer, key, iv, encrypt, offset, length);
    }

    public static void aesIgeEncryptionByteArray(byte[] buffer, byte[] key, byte[] iv, boolean encrypt, boolean changeIv, int offset, int length) {
        if (!changeIv) {
            iv = (byte[]) iv.clone();
        }
        aesIgeEncryptionByteArray(buffer, key, iv, encrypt, offset, length);
    }

    public static void aesCbcEncryptionByteArraySafe(byte[] buffer, byte[] key, byte[] iv, int offset, int length, int n, int encrypt) {
        aesCbcEncryptionByteArray(buffer, key, (byte[]) iv.clone(), offset, length, n, encrypt);
    }

    public static Integer parseInt(CharSequence value) throws NumberFormatException {
        int i = 0;
        if (value == null) {
            return 0;
        }
        try {
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                i = Integer.parseInt(matcher.group(0));
            }
        } catch (Exception unused) {
        }
        return Integer.valueOf(i);
    }

    public static Long parseLong(String value) throws NumberFormatException {
        long j = 0;
        if (value == null) {
            return 0L;
        }
        try {
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                j = Long.parseLong(matcher.group(0));
            }
        } catch (Exception unused) {
        }
        return Long.valueOf(j);
    }

    public static String parseIntToString(String value) {
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        char[] cArr = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int i2 = bytes[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] hexToBytes(String hex) {
        if (hex == null) {
            return null;
        }
        int length = hex.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static boolean isGoodPrime(byte[] prime, int g) {
        int iIntValue;
        if (g < 2 || g > 7 || prime.length != 256 || prime[0] >= 0) {
            return false;
        }
        BigInteger bigInteger = new BigInteger(1, prime);
        if (g == 2) {
            if (bigInteger.mod(BigInteger.valueOf(8L)).intValue() != 7) {
                return false;
            }
        } else if (g == 3) {
            if (bigInteger.mod(BigInteger.valueOf(3L)).intValue() != 2) {
                return false;
            }
        } else if (g == 5) {
            int iIntValue2 = bigInteger.mod(BigInteger.valueOf(5L)).intValue();
            if (iIntValue2 != 1 && iIntValue2 != 4) {
                return false;
            }
        } else if (g == 6) {
            int iIntValue3 = bigInteger.mod(BigInteger.valueOf(24L)).intValue();
            if (iIntValue3 != 19 && iIntValue3 != 23) {
                return false;
            }
        } else if (g == 7 && (iIntValue = bigInteger.mod(BigInteger.valueOf(7L)).intValue()) != 3 && iIntValue != 5 && iIntValue != 6) {
            return false;
        }
        if (bytesToHex(prime).equals("C71CAEB9C6B1C9048E6C522F70F13F73980D40238E3E21C14934D037563D930F48198A0AA7C14058229493D22530F4DBFA336F6E0AC925139543AED44CCE7C3720FD51F69458705AC68CD4FE6B6B13ABDC9746512969328454F18FAF8C595F642477FE96BB2A941D5BCD1D4AC8CC49880708FA9B378E3C4F3A9060BEE67CF9A4A4A695811051907E162753B56B0F6B410DBA74D8A84B2A14B3144E0EF1284754FD17ED950D5965B4B9DD46582DB1178D169C6BC465B0D6FF9CA3928FEF5B9AE4E418FC15E83EBEA0F87FA9FF5EED70050DED2849F47BF959D956850CE929851F0D8115F635B105EE2E4E15D04B2454BF6F4FADF034B10403119CD8E3B92FCC5B")) {
            return true;
        }
        return bigInteger.isProbablePrime(30) && bigInteger.subtract(BigInteger.valueOf(1L)).divide(BigInteger.valueOf(2L)).isProbablePrime(30);
    }

    public static boolean isGoodGaAndGb(BigInteger g_a, BigInteger p) {
        return g_a.compareTo(BigInteger.valueOf(1L)) > 0 && g_a.compareTo(p.subtract(BigInteger.valueOf(1L))) < 0;
    }

    public static boolean arraysEquals(byte[] arr1, int offset1, byte[] arr2, int offset2) {
        if (arr1 == null || arr2 == null || offset1 < 0 || offset2 < 0 || arr1.length - offset1 > arr2.length - offset2 || arr1.length - offset1 < 0 || arr2.length - offset2 < 0) {
            return false;
        }
        boolean z = true;
        for (int i = offset1; i < arr1.length; i++) {
            if (arr1[i + offset1] != arr2[i + offset2]) {
                z = false;
            }
        }
        return z;
    }

    public static byte[] computeSHA1(byte[] convertme, int offset, int len) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(convertme, offset, len);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[20];
        }
    }

    public static byte[] computeSHA1(ByteBuffer convertme, int offset, int len) {
        int iPosition = convertme.position();
        int iLimit = convertme.limit();
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                convertme.position(offset);
                convertme.limit(len);
                messageDigest.update(convertme);
                return messageDigest.digest();
            } catch (Exception e) {
                FileLog.e(e);
                convertme.limit(iLimit);
                convertme.position(iPosition);
                return new byte[20];
            }
        } finally {
            convertme.limit(iLimit);
            convertme.position(iPosition);
        }
    }

    public static byte[] computeSHA1(ByteBuffer convertme) {
        return computeSHA1(convertme, 0, convertme.limit());
    }

    public static byte[] computeSHA1(byte[] convertme) {
        return computeSHA1(convertme, 0, convertme.length);
    }

    public static byte[] computeSHA256(byte[] convertme) {
        return computeSHA256(convertme, 0, convertme.length);
    }

    public static byte[] computeSHA256(byte[] convertme, int offset, int len) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(convertme, offset, len);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[32];
        }
    }

    public static byte[] computeSHA256(byte[]... args) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            for (int i = 0; i < args.length; i++) {
                messageDigest.update(args[i], 0, args[i].length);
            }
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[32];
        }
    }

    public static byte[] computeSHA512(byte[] convertme) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(convertme, 0, convertme.length);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[64];
        }
    }

    public static byte[] computeSHA512(byte[] convertme, byte[] convertme2) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(convertme, 0, convertme.length);
            messageDigest.update(convertme2, 0, convertme2.length);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[64];
        }
    }

    public static byte[] computePBKDF2(byte[] password, byte[] salt) {
        byte[] bArr = new byte[64];
        pbkdf2(password, salt, bArr, 100000);
        return bArr;
    }

    public static byte[] computeSHA512(byte[] convertme, byte[] convertme2, byte[] convertme3) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(convertme, 0, convertme.length);
            messageDigest.update(convertme2, 0, convertme2.length);
            messageDigest.update(convertme3, 0, convertme3.length);
            return messageDigest.digest();
        } catch (Exception e) {
            FileLog.e(e);
            return new byte[64];
        }
    }

    public static byte[] computeSHA256(byte[] b1, int o1, int l1, ByteBuffer b2, int o2, int l2) {
        int iPosition = b2.position();
        int iLimit = b2.limit();
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(b1, o1, l1);
                b2.position(o2);
                b2.limit(l2);
                messageDigest.update(b2);
                return messageDigest.digest();
            } catch (Exception e) {
                FileLog.e(e);
                b2.limit(iLimit);
                b2.position(iPosition);
                return new byte[32];
            }
        } finally {
            b2.limit(iLimit);
            b2.position(iPosition);
        }
    }

    public static long bytesToLong(byte[] bytes) {
        return (bytes[7] << 56) + ((bytes[6] & 255) << 48) + ((bytes[5] & 255) << 40) + ((bytes[4] & 255) << 32) + ((bytes[3] & 255) << 24) + ((bytes[2] & 255) << 16) + ((bytes[1] & 255) << 8) + (bytes[0] & 255);
    }

    public static int bytesToInt(byte[] bytes) {
        return ((bytes[3] & 255) << 24) + ((bytes[2] & 255) << 16) + ((bytes[1] & 255) << 8) + (bytes[0] & 255);
    }

    public static String MD5(String md5) {
        if (md5 == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(AndroidUtilities.getStringBytes(md5));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | Factory.DEVICE_HAS_CRAPPY_OPENSLES).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            FileLog.e(e);
            return null;
        }
    }

    public static byte[] compress(byte[] data) throws IOException {
        byte[] byteArray = null;
        if (data == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(data);
                    gZIPOutputStream.close();
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                    FileLog.e("TSMS", e);
                }
            } catch (IOException e2) {
                FileLog.e("TSMS", e2);
                byteArrayOutputStream.close();
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                FileLog.e("TSMS", e3);
            }
            throw th;
        }
    }
}
