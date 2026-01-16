package ir.nasim;

import android.content.Context;
import android.graphics.Color;

/* loaded from: classes3.dex */
public class I52 {
    private static final int f = (int) Math.round(5.1000000000000005d);
    private final boolean a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;

    public I52(Context context) {
        this(UU3.b(context, AbstractC12181eA5.elevationOverlayEnabled, false), WU3.b(context, AbstractC12181eA5.elevationOverlayColor, 0), WU3.b(context, AbstractC12181eA5.elevationOverlayAccentColor, 0), WU3.b(context, AbstractC12181eA5.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i) {
        return QY0.k(i, 255) == this.d;
    }

    public float a(float f2) {
        if (this.e <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f2) {
        int i2;
        float fA = a(f2);
        int iAlpha = Color.alpha(i);
        int iH = WU3.h(QY0.k(i, 255), this.b, fA);
        if (fA > 0.0f && (i2 = this.c) != 0) {
            iH = WU3.g(iH, QY0.k(i2, f));
        }
        return QY0.k(iH, iAlpha);
    }

    public int c(int i, float f2) {
        return (this.a && f(i)) ? b(i, f2) : i;
    }

    public int d(float f2) {
        return c(this.d, f2);
    }

    public boolean e() {
        return this.a;
    }

    public I52(boolean z, int i, int i2, int i3, float f2) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f2;
    }
}
