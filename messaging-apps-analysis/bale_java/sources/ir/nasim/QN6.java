package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class QN6 {
    private final int a;
    private final int b;
    private final InterfaceC19114po0 c;
    private final InterfaceC13346g43 d;

    public static final class a {
        private final long a;
        private final int b;
        private final boolean c;
        private final boolean d;
        private final String e;

        public a(long j, int i, boolean z, boolean z2, String str) {
            AbstractC13042fc3.i(str, "allocatedSize");
            this.a = j;
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = str;
        }

        public final String a() {
            return this.e;
        }

        public final long b() {
            return this.a;
        }

        public final int c() {
            return this.b;
        }

        public final boolean d() {
            return this.c;
        }

        public final boolean e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && AbstractC13042fc3.d(this.e, aVar.e);
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Item(id=" + this.a + ", name=" + this.b + ", isEnabled=" + this.c + ", isSelected=" + this.d + ", allocatedSize=" + this.e + Separators.RPAREN;
        }
    }

    public QN6(int i, int i2, InterfaceC19114po0 interfaceC19114po0, InterfaceC13346g43 interfaceC13346g43) {
        AbstractC13042fc3.i(interfaceC19114po0, "buttonState");
        AbstractC13042fc3.i(interfaceC13346g43, "items");
        this.a = i;
        this.b = i2;
        this.c = interfaceC19114po0;
        this.d = interfaceC13346g43;
    }

    public final int a() {
        return this.b;
    }

    public final InterfaceC19114po0 b() {
        return this.c;
    }

    public final InterfaceC13346g43 c() {
        return this.d;
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QN6)) {
            return false;
        }
        QN6 qn6 = (QN6) obj;
        return this.a == qn6.a && this.b == qn6.b && AbstractC13042fc3.d(this.c, qn6.c) && AbstractC13042fc3.d(this.d, qn6.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "StorageManagerBottomSheetUiState(title=" + this.a + ", button=" + this.b + ", buttonState=" + this.c + ", items=" + this.d + Separators.RPAREN;
    }
}
