package ir.nasim;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes2.dex */
public abstract class YM7 {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];
    private static volatile Handler c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!s()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!t()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(AbstractC6302Na0 abstractC6302Na0, AbstractC6302Na0 abstractC6302Na02) {
        return abstractC6302Na0 == null ? abstractC6302Na02 == null : abstractC6302Na0.J(abstractC6302Na02);
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean e(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static String f(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static Queue g(int i) {
        return new ArrayDeque(i);
    }

    public static int h(int i, int i2, Bitmap.Config config) {
        return i * i2 * j(config);
    }

    public static int i(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int j(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = a.a[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    public static List k(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static Handler l() {
        if (c == null) {
            synchronized (YM7.class) {
                try {
                    if (c == null) {
                        c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static int m(float f) {
        return n(f, 17);
    }

    public static int n(float f, int i) {
        return p(Float.floatToIntBits(f), i);
    }

    public static int o(int i) {
        return p(i, 17);
    }

    public static int p(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int q(Object obj, int i) {
        return p(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int r(boolean z, int i) {
        return p(z ? 1 : 0, i);
    }

    public static boolean s() {
        return !t();
    }

    public static boolean t() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean u(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean v(int i, int i2) {
        return u(i) && u(i2);
    }

    public static void w(Runnable runnable) {
        l().post(runnable);
    }

    public static void x(Runnable runnable) {
        l().removeCallbacks(runnable);
    }

    public static String y(byte[] bArr) {
        String strF;
        char[] cArr = b;
        synchronized (cArr) {
            strF = f(bArr, cArr);
        }
        return strF;
    }
}
