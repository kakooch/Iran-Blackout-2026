package ir.nasim;

/* loaded from: classes3.dex */
public final class OO3 extends C11465d32 {
    private final float a;

    public OO3(float f) {
        this.a = f - 0.001f;
    }

    @Override // ir.nasim.C11465d32
    boolean b() {
        return true;
    }

    @Override // ir.nasim.C11465d32
    public void c(float f, float f2, float f3, C24052xx6 c24052xx6) {
        float fSqrt = (float) ((this.a * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(fSqrt, 2.0d));
        c24052xx6.n(f2 - fSqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + fSqrt2);
        c24052xx6.m(f2, (float) (-((this.a * Math.sqrt(2.0d)) - this.a)));
        c24052xx6.m(f2 + fSqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + fSqrt2);
    }
}
