package ir.nasim;

/* renamed from: ir.nasim.Tp2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7884Tp2 {
    private final float a;
    private final WH1 b;
    private final float c;

    /* renamed from: ir.nasim.Tp2$a */
    public static final class a {
        private final float a;
        private final float b;
        private final long c;

        public a(float f, float f2, long j) {
            this.a = f;
            this.b = f2;
            this.c = j;
        }

        public final float a(long j) {
            long j2 = this.c;
            return this.b * Math.signum(this.a) * C9349Zo.a.b(j2 > 0 ? j / j2 : 1.0f).a();
        }

        public final float b(long j) {
            long j2 = this.c;
            return (((C9349Zo.a.b(j2 > 0 ? j / j2 : 1.0f).b() * Math.signum(this.a)) * this.b) / this.c) * 1000.0f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.a, aVar.a) == 0 && Float.compare(this.b, aVar.b) == 0 && this.c == aVar.c;
        }

        public int hashCode() {
            return (((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.a + ", distance=" + this.b + ", duration=" + this.c + ')';
        }
    }

    public C7884Tp2(float f, WH1 wh1) {
        this.a = f;
        this.b = wh1;
        this.c = a(wh1);
    }

    private final float a(WH1 wh1) {
        return AbstractC8118Up2.c(0.84f, wh1.getDensity());
    }

    private final double e(float f) {
        return C9349Zo.a.a(f, this.a * this.c);
    }

    public final float b(float f) {
        return (float) (this.a * this.c * Math.exp((AbstractC8118Up2.a / (AbstractC8118Up2.a - 1.0d)) * e(f)));
    }

    public final long c(float f) {
        return (long) (Math.exp(e(f) / (AbstractC8118Up2.a - 1.0d)) * 1000.0d);
    }

    public final a d(float f) {
        double dE = e(f);
        double d = AbstractC8118Up2.a - 1.0d;
        return new a(f, (float) (this.a * this.c * Math.exp((AbstractC8118Up2.a / d) * dE)), (long) (Math.exp(dE / d) * 1000.0d));
    }
}
