package ir.nasim.tgwidgets.editor.messenger;

import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.HU1;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public abstract class Utilities {
    private static volatile HU1 d;
    public static Pattern a = Pattern.compile("[\\-0-9]+");
    public static SecureRandom b = new SecureRandom();
    public static Random c = new Random(b.nextLong());
    public static volatile HU1 e = new HU1("globalQueue");
    public static volatile HU1 f = new HU1("cacheClearQueue");
    public static volatile HU1 g = new HU1("themeQueue");
    protected static final char[] h = "0123456789ABCDEF".toCharArray();

    public interface a {
        void a(Object obj, Object obj2);
    }

    public interface b {
        void a(Object obj);
    }

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("/dev/urandom"));
            byte[] bArr = new byte[1024];
            fileInputStream.read(bArr);
            fileInputStream.close();
            b.setSeed(bArr);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM).digest(AbstractC21455b.l0(str));
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            AbstractC6403Nl2.d(e2);
            return null;
        }
    }

    public static native void aesCbcEncryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    private static native void aesCbcEncryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4);

    public static native void aesCtrDecryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void aesCtrDecryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, long j, int i2);

    private static native void aesIgeEncryption(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, boolean z, int i, int i2);

    private static native void aesIgeEncryptionByteArray(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z, int i, int i2);

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = h;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static native void blurBitmap(Object obj, int i, int i2, int i3, int i4, int i5);

    public static float c(float f2, float f3, float f4) {
        return Float.isNaN(f2) ? f4 : Float.isInfinite(f2) ? f3 : Math.max(Math.min(f2, f3), f4);
    }

    public static native void calcCDT(ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3);

    public static native void clearDir(String str, int i, long j, boolean z);

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);

    public static int d(int i, int i2, int i3) {
        return Math.max(Math.min(i, i2), i3);
    }

    public static native void drawDitheredGradient(Bitmap bitmap, int[] iArr, int i, int i2, int i3, int i4);

    public static long e(long j, long j2, long j3) {
        return Math.max(Math.min(j, j2), j3);
    }

    public static HU1 f() {
        HU1 hu1;
        if (d != null) {
            return d;
        }
        synchronized (Utilities.class) {
            try {
                if (d == null) {
                    d = new HU1("stageQueue");
                }
                hu1 = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hu1;
    }

    public static byte[] g(String str) {
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

    public static native void generateGradient(Bitmap bitmap, boolean z, int i, float f2, int i2, int i3, int i4, int[] iArr);

    public static native long getDirSize(String str, int i, boolean z);

    public static native long getLastUsageFileTime(String str);

    public static Integer h(CharSequence charSequence) throws NumberFormatException {
        int i = 0;
        if (charSequence == null) {
            return 0;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            try {
                if (i3 >= charSequence.length()) {
                    break;
                }
                char cCharAt = charSequence.charAt(i3);
                boolean z = cCharAt == '-' || (cCharAt >= '0' && cCharAt <= '9');
                if (z && i2 < 0) {
                    i2 = i3;
                } else if (!z && i2 >= 0) {
                    i3++;
                    break;
                }
                i3++;
            } catch (Exception unused) {
            }
        }
        if (i2 >= 0) {
            i = Integer.parseInt(charSequence.subSequence(i2, i3).toString());
        }
        return Integer.valueOf(i);
    }

    public static Long i(String str) throws NumberFormatException {
        long j = 0;
        if (str == null) {
            return 0L;
        }
        try {
            Matcher matcher = a.matcher(str);
            if (matcher.find()) {
                j = Long.parseLong(matcher.group(0));
            }
        } catch (Exception unused) {
        }
        return Long.valueOf(j);
    }

    public static Bitmap j(Bitmap bitmap) {
        int iF = AbstractC21455b.F(20.0f);
        int iF2 = (int) ((AbstractC21455b.F(20.0f) * bitmap.getHeight()) / bitmap.getWidth());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.scale(bitmapCreateBitmap.getWidth() / bitmap.getWidth(), bitmapCreateBitmap.getHeight() / bitmap.getHeight());
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        stackBlurBitmap(bitmapCreateBitmap, Math.max(10, Math.max(iF, iF2) / 150));
        return bitmapCreateBitmap;
    }

    public static Bitmap k(Bitmap bitmap, float f2) {
        int iMax = (int) Math.max(AbstractC21455b.F(20.0f), bitmap.getWidth() / f2);
        int iMax2 = (int) Math.max((AbstractC21455b.F(20.0f) * bitmap.getHeight()) / bitmap.getWidth(), bitmap.getHeight() / f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.scale(bitmapCreateBitmap.getWidth() / bitmap.getWidth(), bitmapCreateBitmap.getHeight() / bitmap.getHeight());
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        stackBlurBitmap(bitmapCreateBitmap, Math.max(10, Math.max(iMax, iMax2) / 150));
        return bitmapCreateBitmap;
    }

    public static native boolean loadWebpImage(Bitmap bitmap, ByteBuffer byteBuffer, int i, BitmapFactory.Options options, boolean z);

    public static native int needInvert(Object obj, int i, int i2, int i3, int i4);

    private static native int pbkdf2(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    public static native int pinBitmap(Bitmap bitmap);

    public static native String readlink(String str);

    public static native String readlinkFd(int i);

    public static native int saveProgressiveJpeg(Bitmap bitmap, int i, int i2, int i3, int i4, String str);

    public static native void setupNativeCrashesListener(String str);

    public static native void stackBlurBitmap(Bitmap bitmap, int i);

    public static native void unpinBitmap(Bitmap bitmap);
}
