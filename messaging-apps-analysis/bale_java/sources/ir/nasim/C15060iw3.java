package ir.nasim;

/* renamed from: ir.nasim.iw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15060iw3 {
    public static final int b = C12544en4.d;
    private final C12544en4 a = new C12544en4(new a[16], 0);

    /* renamed from: ir.nasim.iw3$a */
    public static final class a {
        private final int a;
        private final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
            if (!(i >= 0)) {
                P73.a("negative start index");
            }
            if (i2 >= i) {
                return;
            }
            P73.a("end index greater than start");
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "Interval(start=" + this.a + ", end=" + this.b + ')';
        }
    }

    public final a a(int i, int i2) {
        a aVar = new a(i, i2);
        this.a.d(aVar);
        return aVar;
    }

    public final int b() {
        int iA = ((a) this.a.n()).a();
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            a aVar = (a) objArr[i];
            if (aVar.a() > iA) {
                iA = aVar.a();
            }
        }
        return iA;
    }

    public final int c() {
        int iB = ((a) this.a.n()).b();
        C12544en4 c12544en4 = this.a;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            a aVar = (a) objArr[i];
            if (aVar.b() < iB) {
                iB = aVar.b();
            }
        }
        if (!(iB >= 0)) {
            P73.a("negative minIndex");
        }
        return iB;
    }

    public final boolean d() {
        return this.a.o() != 0;
    }

    public final void e(a aVar) {
        this.a.t(aVar);
    }
}
