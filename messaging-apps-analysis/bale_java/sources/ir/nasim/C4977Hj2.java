package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Hj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4977Hj2 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final NT4 a;
    private final boolean b;
    private final boolean c;
    private final Integer d;

    /* renamed from: ir.nasim.Hj2$a */
    public static final class a {
        private a() {
        }

        public final C4977Hj2 a() {
            return new C4977Hj2(NT4.e.a(), false, false, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C4977Hj2(NT4 nt4, boolean z, boolean z2, Integer num) {
        AbstractC13042fc3.i(nt4, "pagingData");
        this.a = nt4;
        this.b = z;
        this.c = z2;
        this.d = num;
    }

    public final boolean a() {
        return this.b;
    }

    public final NT4 b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public final Integer d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4977Hj2)) {
            return false;
        }
        C4977Hj2 c4977Hj2 = (C4977Hj2) obj;
        return AbstractC13042fc3.d(this.a, c4977Hj2.a) && this.b == c4977Hj2.b && this.c == c4977Hj2.c && AbstractC13042fc3.d(this.d, c4977Hj2.d);
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31;
        Integer num = this.d;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "FeedUIState(pagingData=" + this.a + ", listLoaded=" + this.b + ", refreshed=" + this.c + ", snackBarMessage=" + this.d + Separators.RPAREN;
    }
}
