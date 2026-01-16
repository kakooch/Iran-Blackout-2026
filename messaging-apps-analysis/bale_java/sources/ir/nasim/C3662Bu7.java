package ir.nasim;

/* renamed from: ir.nasim.Bu7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3662Bu7 {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;

    public C3662Bu7(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = d4;
        this.e = d5;
        this.f = d6;
        this.g = d7;
        if (Double.isNaN(d2) || Double.isNaN(d3) || Double.isNaN(d4) || Double.isNaN(d5) || Double.isNaN(d6) || Double.isNaN(d7) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (AbstractC3896Cu7.b(d)) {
            return;
        }
        if (d5 < 0.0d || d5 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d5);
        }
        if (d5 == 0.0d && (d2 == 0.0d || d == 0.0d)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (d5 >= 1.0d && d4 == 0.0d) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        }
        if ((d2 == 0.0d || d == 0.0d) && d4 == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (d4 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (d2 < 0.0d || d < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    public final double a() {
        return this.b;
    }

    public final double b() {
        return this.c;
    }

    public final double c() {
        return this.d;
    }

    public final double d() {
        return this.e;
    }

    public final double e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3662Bu7)) {
            return false;
        }
        C3662Bu7 c3662Bu7 = (C3662Bu7) obj;
        return Double.compare(this.a, c3662Bu7.a) == 0 && Double.compare(this.b, c3662Bu7.b) == 0 && Double.compare(this.c, c3662Bu7.c) == 0 && Double.compare(this.d, c3662Bu7.d) == 0 && Double.compare(this.e, c3662Bu7.e) == 0 && Double.compare(this.f, c3662Bu7.f) == 0 && Double.compare(this.g, c3662Bu7.g) == 0;
    }

    public final double f() {
        return this.g;
    }

    public final double g() {
        return this.a;
    }

    public final boolean h() {
        return this.a == -3.0d;
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.a) * 31) + Double.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + Double.hashCode(this.f)) * 31) + Double.hashCode(this.g);
    }

    public final boolean i() {
        return this.a == -2.0d;
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.a + ", a=" + this.b + ", b=" + this.c + ", c=" + this.d + ", d=" + this.e + ", e=" + this.f + ", f=" + this.g + ')';
    }

    public /* synthetic */ C3662Bu7(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i, ED1 ed1) {
        this(d, d2, d3, d4, d5, (i & 32) != 0 ? 0.0d : d6, (i & 64) != 0 ? 0.0d : d7);
    }
}
