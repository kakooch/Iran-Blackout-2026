package ir.nasim;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.FT1;
import ir.nasim.InterfaceC21332tU1;
import ir.nasim.InterfaceC3955Db3;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18638p {
    private static final Bitmap.Config[] a;
    private static final Bitmap.Config b;
    private static final Headers c;

    /* renamed from: ir.nasim.p$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC21699tz1.values().length];
            try {
                iArr[EnumC21699tz1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21699tz1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC21699tz1.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC21699tz1.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC14254hc6.values().length];
            try {
                iArr3[EnumC14254hc6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[EnumC14254hc6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            c = iArr3;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        a = i >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        b = i >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
        c = new Headers.Builder().build();
    }

    public static final int A(FT1 ft1, EnumC14254hc6 enumC14254hc6) {
        if (ft1 instanceof FT1.a) {
            return ((FT1.a) ft1).a;
        }
        int i = a.c[enumC14254hc6.ordinal()];
        if (i == 1) {
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void a(InterfaceC21332tU1.b bVar) {
        try {
            bVar.abort();
        } catch (Exception unused) {
        }
    }

    public static final Headers.Builder b(Headers.Builder builder, String str) {
        int iK0 = AbstractC20762sZ6.k0(str, ':', 0, false, 6, null);
        if (iK0 == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String strSubstring = str.substring(0, iK0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String string = AbstractC20762sZ6.n1(strSubstring).toString();
        String strSubstring2 = str.substring(iK0 + 1);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        builder.addUnsafeNonAscii(string, strSubstring2);
        return builder;
    }

    public static final int c(Context context, double d) {
        int largeMemoryClass;
        try {
            Object objL = AbstractC4043Dl1.l(context, ActivityManager.class);
            AbstractC13042fc3.f(objL);
            ActivityManager activityManager = (ActivityManager) objL;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = 256;
        }
        double d2 = 1024;
        return (int) (d * largeMemoryClass * d2 * d2);
    }

    public static final void d(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final double e(Context context) {
        try {
            Object objL = AbstractC4043Dl1.l(context, ActivityManager.class);
            AbstractC13042fc3.f(objL);
            return ((ActivityManager) objL).isLowRamDevice() ? 0.15d : 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public static final Bitmap.Config f() {
        return b;
    }

    public static final String g(EnumC21699tz1 enumC21699tz1) {
        int i = a.a[enumC21699tz1.ordinal()];
        if (i == 1 || i == 2) {
            return "🧠";
        }
        if (i == 3) {
            return "💾";
        }
        if (i == 4) {
            return "☁️ ";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final InterfaceC8217Va2 h(InterfaceC3955Db3.a aVar) {
        return aVar instanceof GI5 ? ((GI5) aVar).d() : InterfaceC8217Va2.b;
    }

    public static final String i(Uri uri) {
        return (String) AbstractC15401jX0.s0(uri.getPathSegments());
    }

    public static final int j(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final String k(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(AbstractC20762sZ6.a1(AbstractC20762sZ6.c1(AbstractC20762sZ6.k1(AbstractC20762sZ6.k1(str, '#', null, 2, null), '?', null, 2, null), '/', null, 2, null), '.', ""));
    }

    public static final int l(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    public static final File m(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null".toString());
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final EnumC14254hc6 n(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i = scaleType == null ? -1 : a.b[scaleType.ordinal()];
        return (i == 1 || i == 2 || i == 3 || i == 4) ? EnumC14254hc6.b : EnumC14254hc6.a;
    }

    public static final Bitmap.Config[] o() {
        return a;
    }

    public static final int p(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final boolean q(Uri uri) {
        return AbstractC13042fc3.d(uri.getScheme(), "file") && AbstractC13042fc3.d(i(uri), "android_asset");
    }

    public static final boolean r() {
        return AbstractC13042fc3.d(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean s(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    public static final boolean t(InterfaceC3955Db3.a aVar) {
        return (aVar instanceof GI5) && ((GI5) aVar).e();
    }

    public static final boolean u(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof RQ7);
    }

    public static final C19533qW4 v(C19533qW4 c19533qW4) {
        return c19533qW4 == null ? C19533qW4.c : c19533qW4;
    }

    public static final C16116kj7 w(C16116kj7 c16116kj7) {
        return c16116kj7 == null ? C16116kj7.c : c16116kj7;
    }

    public static final Headers x(Headers headers) {
        return headers == null ? c : headers;
    }

    public static final ResponseBody y(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            return responseBodyBody;
        }
        throw new IllegalStateException("response body == null".toString());
    }

    public static final int z(String str, int i) {
        Long lQ = AbstractC19562qZ6.q(str);
        if (lQ == null) {
            return i;
        }
        long jLongValue = lQ.longValue();
        if (jLongValue > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }
}
