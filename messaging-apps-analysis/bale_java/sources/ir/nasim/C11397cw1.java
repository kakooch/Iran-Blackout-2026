package ir.nasim;

/* renamed from: ir.nasim.cw1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11397cw1 implements K22 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;

    public C11397cw1(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        if (!((Float.isNaN(f) || Float.isNaN(f2) || Float.isNaN(f3) || Float.isNaN(f4)) ? false : true)) {
            AbstractC5448Jj5.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f + ", " + f2 + ", " + f3 + ", " + f4 + '.');
        }
        long jB = AbstractC16650le0.b(0.0f, f2, f4, 1.0f, new float[5], 0);
        this.e = Float.intBitsToFloat((int) (jB >> 32));
        this.f = Float.intBitsToFloat((int) (jB & 4294967295L));
    }

    private final void b(float f) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ") has no solution at " + f);
    }

    @Override // ir.nasim.K22
    public float a(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            return f;
        }
        float fMax = Math.max(f, 1.1920929E-7f);
        float fE = AbstractC16650le0.e(0.0f - fMax, this.a - fMax, this.c - fMax, 1.0f - fMax);
        if (Float.isNaN(fE)) {
            b(f);
        }
        float fC = AbstractC16650le0.c(this.b, this.d, fE);
        float f2 = this.e;
        float f3 = this.f;
        if (fC < f2) {
            fC = f2;
        }
        return fC > f3 ? f3 : fC;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C11397cw1) {
            C11397cw1 c11397cw1 = (C11397cw1) obj;
            if (this.a == c11397cw1.a && this.b == c11397cw1.b && this.c == c11397cw1.c && this.d == c11397cw1.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ')';
    }
}
