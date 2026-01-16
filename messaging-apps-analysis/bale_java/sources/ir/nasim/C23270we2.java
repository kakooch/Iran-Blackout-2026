package ir.nasim;

import ir.nasim.AbstractC17026mG5;

/* renamed from: ir.nasim.we2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23270we2 {
    private static final a f = new a(null);
    private final long a;
    private final long b;
    private final double c;
    private final float d;
    private long e;

    /* renamed from: ir.nasim.we2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C23270we2(long j, long j2, double d, float f2) {
        this.a = j;
        this.b = j2;
        this.c = d;
        this.d = f2;
        this.e = j;
    }

    public final long a() {
        double d = this.e;
        AbstractC17026mG5.a aVar = AbstractC17026mG5.a;
        double d2 = this.c;
        double dE = d * (1 + aVar.e(-d2, d2));
        this.e = Math.min(AbstractC20723sV3.f(this.e * this.d), this.b);
        return AbstractC20723sV3.e(dE);
    }

    public final void b() {
        this.e = this.a;
    }

    public /* synthetic */ C23270we2(long j, long j2, double d, float f2, int i, ED1 ed1) {
        this((i & 1) != 0 ? 500L : j, (i & 2) != 0 ? 5000L : j2, (i & 4) != 0 ? 0.2d : d, (i & 8) != 0 ? 2.0f : f2);
    }
}
