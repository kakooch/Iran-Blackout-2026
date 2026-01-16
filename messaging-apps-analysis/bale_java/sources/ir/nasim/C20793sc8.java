package ir.nasim;

/* renamed from: ir.nasim.sc8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20793sc8 extends AbstractC9775aY0 {
    public C20793sc8(String str, int i) {
        super(str, FX0.a.c(), i, null);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float c(int i) {
        return 2.0f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float d(int i) {
        return -2.0f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long h(float f, float f2, float f3) {
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f2 < -2.0f) {
            f2 = -2.0f;
        }
        return (Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2 <= 2.0f ? f2 : 2.0f) & 4294967295L);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float i(float f, float f2, float f3) {
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 > 2.0f) {
            return 2.0f;
        }
        return f3;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long j(float f, float f2, float f3, float f4, AbstractC9775aY0 abstractC9775aY0) {
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f2 < -2.0f) {
            f2 = -2.0f;
        }
        if (f2 > 2.0f) {
            f2 = 2.0f;
        }
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        return DX0.a(f, f2, f3 <= 2.0f ? f3 : 2.0f, f4, abstractC9775aY0);
    }
}
