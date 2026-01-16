package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class PS0 {

    public static final class a extends PS0 {
        public static final int b = 0;
        private final InterfaceC14603iB2 a;

        public a(InterfaceC14603iB2 interfaceC14603iB2) {
            super(null);
            this.a = interfaceC14603iB2;
        }

        public final InterfaceC14603iB2 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            InterfaceC14603iB2 interfaceC14603iB2 = this.a;
            if (interfaceC14603iB2 == null) {
                return 0;
            }
            return interfaceC14603iB2.hashCode();
        }

        public String toString() {
            return "Filter(leadingIcon=" + this.a + Separators.RPAREN;
        }

        public /* synthetic */ a(InterfaceC14603iB2 interfaceC14603iB2, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : interfaceC14603iB2);
        }
    }

    public static final class b extends PS0 {
        public static final int d = 0;
        private final InterfaceC14603iB2 a;
        private final InterfaceC14603iB2 b;
        private final InterfaceC14603iB2 c;

        public /* synthetic */ b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : interfaceC14603iB2, (i & 2) != 0 ? null : interfaceC14603iB22, (i & 4) != 0 ? null : interfaceC14603iB23);
        }

        public final InterfaceC14603iB2 a() {
            return this.b;
        }

        public final InterfaceC14603iB2 b() {
            return this.a;
        }

        public final InterfaceC14603iB2 c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            InterfaceC14603iB2 interfaceC14603iB2 = this.a;
            int iHashCode = (interfaceC14603iB2 == null ? 0 : interfaceC14603iB2.hashCode()) * 31;
            InterfaceC14603iB2 interfaceC14603iB22 = this.b;
            int iHashCode2 = (iHashCode + (interfaceC14603iB22 == null ? 0 : interfaceC14603iB22.hashCode())) * 31;
            InterfaceC14603iB2 interfaceC14603iB23 = this.c;
            return iHashCode2 + (interfaceC14603iB23 != null ? interfaceC14603iB23.hashCode() : 0);
        }

        public String toString() {
            return "Simple(leadingIcon=" + this.a + ", avatar=" + this.b + ", trailingIcon=" + this.c + Separators.RPAREN;
        }

        public b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23) {
            super(null);
            this.a = interfaceC14603iB2;
            this.b = interfaceC14603iB22;
            this.c = interfaceC14603iB23;
        }
    }

    private PS0() {
    }

    public /* synthetic */ PS0(ED1 ed1) {
        this();
    }
}
