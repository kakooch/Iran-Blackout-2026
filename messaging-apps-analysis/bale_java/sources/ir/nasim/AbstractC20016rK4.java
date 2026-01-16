package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.rK4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20016rK4 {
    private final boolean a;

    /* renamed from: ir.nasim.rK4$a */
    public static final class a extends AbstractC20016rK4 {
        public static final a b = new a();

        private a() {
            super(false, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1744486265;
        }

        public String toString() {
            return "Disabled";
        }
    }

    /* renamed from: ir.nasim.rK4$b */
    public static final class b extends AbstractC20016rK4 {
        public static final a f = new a(null);
        private static boolean g = true;
        private final boolean b;
        private final EnumC11273cj7 c;
        private final int d;
        private final String e;

        /* renamed from: ir.nasim.rK4$b$a */
        public static final class a {
            private a() {
            }

            public final boolean a() {
                return b.g;
            }

            public final void b(boolean z) {
                b.g = z;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, EnumC11273cj7 enumC11273cj7, int i, String str) {
            super(z, null);
            AbstractC13042fc3.i(enumC11273cj7, "tabType");
            AbstractC13042fc3.i(str, "bannerUrl");
            this.b = z;
            this.c = enumC11273cj7;
            this.d = i;
            this.e = str;
        }

        public static /* synthetic */ b e(b bVar, boolean z, EnumC11273cj7 enumC11273cj7, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = bVar.b;
            }
            if ((i2 & 2) != 0) {
                enumC11273cj7 = bVar.c;
            }
            if ((i2 & 4) != 0) {
                i = bVar.d;
            }
            if ((i2 & 8) != 0) {
                str = bVar.e;
            }
            return bVar.d(z, enumC11273cj7, i, str);
        }

        @Override // ir.nasim.AbstractC20016rK4
        public boolean a() {
            return this.b;
        }

        public final b d(boolean z, EnumC11273cj7 enumC11273cj7, int i, String str) {
            AbstractC13042fc3.i(enumC11273cj7, "tabType");
            AbstractC13042fc3.i(str, "bannerUrl");
            return new b(z, enumC11273cj7, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e);
        }

        public final String f() {
            return this.e;
        }

        public final int g() {
            return this.d;
        }

        public final EnumC11273cj7 h() {
            return this.c;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Enabled(isVisible=" + this.b + ", tabType=" + this.c + ", scenarioId=" + this.d + ", bannerUrl=" + this.e + Separators.RPAREN;
        }
    }

    public /* synthetic */ AbstractC20016rK4(boolean z, ED1 ed1) {
        this(z);
    }

    public boolean a() {
        return this.a;
    }

    private AbstractC20016rK4(boolean z) {
        this.a = z;
    }
}
