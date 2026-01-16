package ir.nasim;

/* renamed from: ir.nasim.sH4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20598sH4 extends AbstractC9775aY0 {
    public static final a e = new a(null);
    private static final float[] f;
    private static final float[] g;
    private static final float[] h;
    private static final float[] i;

    /* renamed from: ir.nasim.sH4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        float[] fArrB = AbstractC22963w7.b.a().b();
        L03 l03 = L03.a;
        float[] fArrL = AbstractC10395bY0.l(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, AbstractC10395bY0.e(fArrB, l03.b().c(), l03.e().c()));
        f = fArrL;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        g = fArr;
        h = AbstractC10395bY0.k(fArrL);
        i = AbstractC10395bY0.k(fArr);
    }

    public C20598sH4(String str, int i2) {
        super(str, FX0.a.a(), i2, null);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float c(int i2) {
        return i2 == 0 ? 1.0f : 0.5f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float d(int i2) {
        return i2 == 0 ? 0.0f : -0.5f;
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long h(float f2, float f3, float f4) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < -0.5f) {
            f3 = -0.5f;
        }
        if (f3 > 0.5f) {
            f3 = 0.5f;
        }
        if (f4 < -0.5f) {
            f4 = -0.5f;
        }
        float f5 = f4 <= 0.5f ? f4 : 0.5f;
        float[] fArr = i;
        float f6 = (fArr[0] * f2) + (fArr[3] * f3) + (fArr[6] * f5);
        float f7 = (fArr[1] * f2) + (fArr[4] * f3) + (fArr[7] * f5);
        float f8 = (fArr[2] * f2) + (fArr[5] * f3) + (fArr[8] * f5);
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float f11 = f8 * f8 * f8;
        float[] fArr2 = h;
        return (Float.floatToRawIntBits(((fArr2[0] * f9) + (fArr2[3] * f10)) + (fArr2[6] * f11)) << 32) | (Float.floatToRawIntBits((fArr2[1] * f9) + (fArr2[4] * f10) + (fArr2[7] * f11)) & 4294967295L);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public float i(float f2, float f3, float f4) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f3 < -0.5f) {
            f3 = -0.5f;
        }
        if (f3 > 0.5f) {
            f3 = 0.5f;
        }
        if (f4 < -0.5f) {
            f4 = -0.5f;
        }
        float f5 = f4 <= 0.5f ? f4 : 0.5f;
        float[] fArr = i;
        float f6 = (fArr[0] * f2) + (fArr[3] * f3) + (fArr[6] * f5);
        float f7 = (fArr[1] * f2) + (fArr[4] * f3) + (fArr[7] * f5);
        float f8 = (fArr[2] * f2) + (fArr[5] * f3) + (fArr[8] * f5);
        float f9 = f6 * f6 * f6;
        float f10 = f7 * f7 * f7;
        float[] fArr2 = h;
        return (fArr2[2] * f9) + (fArr2[5] * f10) + (fArr2[8] * f8 * f8 * f8);
    }

    @Override // ir.nasim.AbstractC9775aY0
    public long j(float f2, float f3, float f4, float f5, AbstractC9775aY0 abstractC9775aY0) {
        float[] fArr = f;
        float f6 = (fArr[0] * f2) + (fArr[3] * f3) + (fArr[6] * f4);
        float f7 = (fArr[1] * f2) + (fArr[4] * f3) + (fArr[7] * f4);
        float f8 = (fArr[2] * f2) + (fArr[5] * f3) + (fArr[8] * f4);
        float fA = AbstractC18932pV3.a(f6);
        float fA2 = AbstractC18932pV3.a(f7);
        float fA3 = AbstractC18932pV3.a(f8);
        float[] fArr2 = g;
        return DX0.a((fArr2[0] * fA) + (fArr2[3] * fA2) + (fArr2[6] * fA3), (fArr2[1] * fA) + (fArr2[4] * fA2) + (fArr2[7] * fA3), (fArr2[2] * fA) + (fArr2[5] * fA2) + (fArr2[8] * fA3), f5, abstractC9775aY0);
    }
}
