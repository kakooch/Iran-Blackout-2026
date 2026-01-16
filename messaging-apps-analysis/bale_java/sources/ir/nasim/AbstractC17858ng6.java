package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ng6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC17858ng6 {
    public static final int a = 0;

    /* renamed from: ir.nasim.ng6$a */
    public static final class a extends AbstractC17858ng6 {
        public static final int e = 0;
        private final boolean b;
        private final boolean c;
        private final boolean d;

        public a(boolean z, boolean z2, boolean z3) {
            super(null);
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        public static /* synthetic */ a b(a aVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = aVar.b;
            }
            if ((i & 2) != 0) {
                z2 = aVar.c;
            }
            if ((i & 4) != 0) {
                z3 = aVar.d;
            }
            return aVar.a(z, z2, z3);
        }

        public final a a(boolean z, boolean z2, boolean z3) {
            return new a(z, z2, z3);
        }

        public final boolean c() {
            return this.b;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
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
            return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.b) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "IsFocused(shouldClearFocus=" + this.b + ", isLoading=" + this.c + ", shouldFocus=" + this.d + Separators.RPAREN;
        }

        public /* synthetic */ a(boolean z, boolean z2, boolean z3, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
        }
    }

    /* renamed from: ir.nasim.ng6$b */
    public static final class b extends AbstractC17858ng6 {
        public static final b b = new b();
        public static final int c = 0;

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1106405979;
        }

        public String toString() {
            return "NotFocused";
        }
    }

    private AbstractC17858ng6() {
    }

    public /* synthetic */ AbstractC17858ng6(ED1 ed1) {
        this();
    }
}
