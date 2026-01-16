package ir.nasim;

/* renamed from: ir.nasim.oJ6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18236oJ6 {
    private float a;
    private double b = Math.sqrt(50.0d);
    private float c = 1.0f;

    public C18236oJ6(float f) {
        this.a = f;
    }

    public final float a() {
        return this.c;
    }

    public final float b() {
        double d = this.b;
        return (float) (d * d);
    }

    public final void c(float f) {
        if (f < 0.0f) {
            AbstractC5448Jj5.a("Damping ratio must be non-negative");
        }
        this.c = f;
    }

    public final void d(float f) {
        this.a = f;
    }

    public final void e(float f) {
        if (b() <= 0.0f) {
            AbstractC5448Jj5.a("Spring stiffness constant must be positive.");
        }
        this.b = Math.sqrt(f);
    }

    public final long f(float f, float f2, long j) {
        double dExp;
        double dExp2;
        float f3 = f - this.a;
        double d = j / 1000.0d;
        float f4 = this.c;
        double d2 = f4 * f4;
        double d3 = this.b;
        double d4 = (-f4) * d3;
        if (f4 > 1.0f) {
            double dSqrt = d3 * Math.sqrt(d2 - 1);
            double d5 = d4 + dSqrt;
            double d6 = d4 - dSqrt;
            double d7 = f3;
            double d8 = ((d6 * d7) - f2) / (d6 - d5);
            double d9 = d7 - d8;
            double d10 = d6 * d;
            double d11 = d * d5;
            dExp2 = (Math.exp(d10) * d9) + (Math.exp(d11) * d8);
            dExp = (d9 * d6 * Math.exp(d10)) + (d8 * d5 * Math.exp(d11));
        } else if (f4 == 1.0f) {
            double d12 = f3;
            double d13 = f2 + (d3 * d12);
            double d14 = (-d3) * d;
            double d15 = d12 + (d * d13);
            dExp2 = d15 * Math.exp(d14);
            dExp = (d15 * Math.exp(d14) * (-this.b)) + (d13 * Math.exp(d14));
        } else {
            double d16 = 1;
            double dSqrt2 = d3 * Math.sqrt(d16 - d2);
            double d17 = f3;
            double d18 = (d16 / dSqrt2) * (((-d4) * d17) + f2);
            double d19 = dSqrt2 * d;
            double d20 = d * d4;
            double dExp3 = Math.exp(d20) * ((Math.cos(d19) * d17) + (Math.sin(d19) * d18));
            dExp = (d4 * dExp3) + (Math.exp(d20) * (((-dSqrt2) * d17 * Math.sin(d19)) + (dSqrt2 * d18 * Math.cos(d19))));
            dExp2 = dExp3;
        }
        return AbstractC8800Xj4.a((Float.floatToRawIntBits((float) dExp) & 4294967295L) | (Float.floatToRawIntBits((float) (dExp2 + this.a)) << 32));
    }
}
