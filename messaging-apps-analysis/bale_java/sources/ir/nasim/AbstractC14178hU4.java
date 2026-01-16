package ir.nasim;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import ir.nasim.AbstractC8769Xg0;

/* renamed from: ir.nasim.hU4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14178hU4 {
    private static final ThreadLocal a = new ThreadLocal();

    /* renamed from: ir.nasim.hU4$a */
    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    /* renamed from: ir.nasim.hU4$b */
    static class b {
        static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(Paint paint, String str) {
        return a.a(paint, str);
    }

    public static boolean b(Paint paint, EnumC8503Wg0 enumC8503Wg0) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(paint, enumC8503Wg0 != null ? AbstractC8769Xg0.b.a(enumC8503Wg0) : null);
            return true;
        }
        if (enumC8503Wg0 == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode modeA = AbstractC8769Xg0.a(enumC8503Wg0);
        paint.setXfermode(modeA != null ? new PorterDuffXfermode(modeA) : null);
        return modeA != null;
    }
}
