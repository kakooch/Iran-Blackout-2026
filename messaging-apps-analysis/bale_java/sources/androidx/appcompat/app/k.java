package androidx.appcompat.app;

/* loaded from: classes.dex */
class k {
    private static k d;
    public long a;
    public long b;
    public int c;

    k() {
    }

    static k b() {
        if (d == null) {
            d = new k();
        }
        return d;
    }

    public void a(long j, double d2, double d3) {
        double d4 = (0.01720197f * ((j - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d4) * 0.03341960161924362d) + d4 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r3 - 9.0E-4f) - r7) + 9.0E-4f + ((-d3) / 360.0d) + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(dAsin))) / (Math.cos(d5) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.c = 1;
            this.a = -1L;
            this.b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.c = 0;
                this.a = -1L;
                this.b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.b = jRound;
            if (jRound >= j || this.a <= j) {
                this.c = 1;
            } else {
                this.c = 0;
            }
        }
    }
}
