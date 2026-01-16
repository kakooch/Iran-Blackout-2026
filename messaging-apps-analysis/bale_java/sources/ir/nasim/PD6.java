package ir.nasim;

import ir.nasim.FT1;

/* loaded from: classes2.dex */
public final class PD6 {
    public static final a c = new a(null);
    public static final PD6 d;
    private final FT1 a;
    private final FT1 b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        FT1.b bVar = FT1.b.a;
        d = new PD6(bVar, bVar);
    }

    public PD6(FT1 ft1, FT1 ft12) {
        this.a = ft1;
        this.b = ft12;
    }

    public final FT1 a() {
        return this.a;
    }

    public final FT1 b() {
        return this.b;
    }

    public final FT1 c() {
        return this.b;
    }

    public final FT1 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PD6)) {
            return false;
        }
        PD6 pd6 = (PD6) obj;
        return AbstractC13042fc3.d(this.a, pd6.a) && AbstractC13042fc3.d(this.b, pd6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.a + ", height=" + this.b + ')';
    }
}
