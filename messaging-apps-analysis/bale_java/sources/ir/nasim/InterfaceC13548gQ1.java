package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gQ1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC13548gQ1 {

    /* renamed from: ir.nasim.gQ1$a */
    public static final class a implements InterfaceC13548gQ1 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1845930401;
        }

        public String toString() {
            return "Normal";
        }
    }

    /* renamed from: ir.nasim.gQ1$b */
    public static final class b implements InterfaceC13548gQ1 {
        private final int a;
        private final boolean b;

        public b(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public final int a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "SelectionMode(selectedItemCount=" + this.a + ", isSelectAll=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ b(int i, boolean z, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
        }
    }
}
