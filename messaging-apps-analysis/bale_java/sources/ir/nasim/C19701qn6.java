package ir.nasim;

/* renamed from: ir.nasim.qn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19701qn6 {
    private final a a;
    private final a b;
    private final boolean c;

    /* renamed from: ir.nasim.qn6$a */
    public static final class a {
        private final AW5 a;
        private final int b;
        private final long c;

        public a(AW5 aw5, int i, long j) {
            this.a = aw5;
            this.b = i;
            this.c = j;
        }

        public static /* synthetic */ a b(a aVar, AW5 aw5, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                aw5 = aVar.a;
            }
            if ((i2 & 2) != 0) {
                i = aVar.b;
            }
            if ((i2 & 4) != 0) {
                j = aVar.c;
            }
            return aVar.a(aw5, i, j);
        }

        public final a a(AW5 aw5, int i, long j) {
            return new a(aw5, i, j);
        }

        public final int c() {
            return this.b;
        }

        public final long d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "AnchorInfo(direction=" + this.a + ", offset=" + this.b + ", selectableId=" + this.c + ')';
        }
    }

    public C19701qn6(a aVar, a aVar2, boolean z) {
        this.a = aVar;
        this.b = aVar2;
        this.c = z;
    }

    public static /* synthetic */ C19701qn6 b(C19701qn6 c19701qn6, a aVar, a aVar2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = c19701qn6.a;
        }
        if ((i & 2) != 0) {
            aVar2 = c19701qn6.b;
        }
        if ((i & 4) != 0) {
            z = c19701qn6.c;
        }
        return c19701qn6.a(aVar, aVar2, z);
    }

    public final C19701qn6 a(a aVar, a aVar2, boolean z) {
        return new C19701qn6(aVar, aVar2, z);
    }

    public final a c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public final a e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19701qn6)) {
            return false;
        }
        C19701qn6 c19701qn6 = (C19701qn6) obj;
        return AbstractC13042fc3.d(this.a, c19701qn6.a) && AbstractC13042fc3.d(this.b, c19701qn6.b) && this.c == c19701qn6.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "Selection(start=" + this.a + ", end=" + this.b + ", handlesCrossed=" + this.c + ')';
    }
}
