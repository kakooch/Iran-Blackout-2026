package ir.nasim;

/* renamed from: ir.nasim.Ds3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4108Ds3 extends AbstractC9775aY0 {
    public static final a e = new a(null);

    /* renamed from: ir.nasim.Ds3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C4108Ds3(String str, int i) {
        super(str, FX0.a.a(), i, null);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float c(int i) {
        return i == 0 ? 100.0f : 128.0f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float d(int i) {
        return i == 0 ? 0.0f : -128.0f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long h(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (f2 < -128.0f) {
            f2 = -128.0f;
        }
        if (f2 > 128.0f) {
            f2 = 128.0f;
        }
        float f4 = (f + 16.0f) / 116.0f;
        float f5 = (f2 * 0.002f) + f4;
        float f6 = f5 > 0.20689656f ? f5 * f5 * f5 : (f5 - 0.13793103f) * 0.12841855f;
        float f7 = f4 > 0.20689656f ? f4 * f4 * f4 : (f4 - 0.13793103f) * 0.12841855f;
        float f8 = f6 * L03.a.c()[0];
        return (Float.floatToRawIntBits(f7 * r5.c()[1]) & 4294967295L) | (Float.floatToRawIntBits(f8) << 32);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float i(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (f3 < -128.0f) {
            f3 = -128.0f;
        }
        if (f3 > 128.0f) {
            f3 = 128.0f;
        }
        float f4 = ((f + 16.0f) / 116.0f) - (f3 * 0.005f);
        return (f4 > 0.20689656f ? f4 * f4 * f4 : 0.12841855f * (f4 - 0.13793103f)) * L03.a.c()[2];
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long j(float f, float f2, float f3, float f4, AbstractC9775aY0 abstractC9775aY0) {
        L03 l03 = L03.a;
        float f5 = f / l03.c()[0];
        float f6 = f2 / l03.c()[1];
        float f7 = f3 / l03.c()[2];
        float fCbrt = f5 > 0.008856452f ? (float) Math.cbrt(f5) : (f5 * 7.787037f) + 0.13793103f;
        float fCbrt2 = f6 > 0.008856452f ? (float) Math.cbrt(f6) : (f6 * 7.787037f) + 0.13793103f;
        float f8 = (116.0f * fCbrt2) - 16.0f;
        float f9 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f7 > 0.008856452f ? (float) Math.cbrt(f7) : (f7 * 7.787037f) + 0.13793103f)) * 200.0f;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f8 > 100.0f) {
            f8 = 100.0f;
        }
        if (f9 < -128.0f) {
            f9 = -128.0f;
        }
        if (f9 > 128.0f) {
            f9 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return DX0.a(f8, f9, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, f4, abstractC9775aY0);
    }
}
