package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class LA2 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final NT4 a;
    private final int b;
    private final int c;
    private final Integer d;
    private final boolean e;
    private final boolean f;

    public static final class a {
        private a() {
        }

        public final LA2 a() {
            return new LA2(NT4.e.a(), -1, 1, null, false, false);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public LA2(NT4 nt4, int i, int i2, Integer num, boolean z, boolean z2) {
        AbstractC13042fc3.i(nt4, "dataList");
        this.a = nt4;
        this.b = i;
        this.c = i2;
        this.d = num;
        this.e = z;
        this.f = z2;
    }

    public final int a() {
        return this.b;
    }

    public final NT4 b() {
        return this.a;
    }

    public final boolean c() {
        return this.f;
    }

    public final Integer d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LA2)) {
            return false;
        }
        LA2 la2 = (LA2) obj;
        return AbstractC13042fc3.d(this.a, la2.a) && this.b == la2.b && this.c == la2.c && AbstractC13042fc3.d(this.d, la2.d) && this.e == la2.e && this.f == la2.f;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        Integer num = this.d;
        return ((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "FullScreenUiModel(dataList=" + this.a + ", currentPage=" + this.b + ", playerState=" + this.c + ", snackBarMessage=" + this.d + ", isSwipeAnimationVisible=" + this.e + ", shouldShowFakeDragAnimation=" + this.f + Separators.RPAREN;
    }
}
