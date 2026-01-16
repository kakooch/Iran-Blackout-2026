package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Fr5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC4569Fr5 {

    /* renamed from: ir.nasim.Fr5$a */
    public static final class a implements InterfaceC4569Fr5 {
        private final String a;
        private final boolean b;

        public a(String str, boolean z) {
            AbstractC13042fc3.i(str, "username");
            this.a = str;
            this.b = z;
        }

        public final String a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "Block(username=" + this.a + ", isBot=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ a(String str, boolean z, int i, ED1 ed1) {
            this(str, (i & 2) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.Fr5$b */
    public static final class b implements InterfaceC4569Fr5 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1349933487;
        }

        public String toString() {
            return "BlockAnReport";
        }
    }

    /* renamed from: ir.nasim.Fr5$c */
    public static final class c implements InterfaceC4569Fr5 {
        private final ZN2 a;

        public c(ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "groupType");
            this.a = zn2;
        }

        public final ZN2 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.a == ((c) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Leave(groupType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Fr5$d */
    public static final class d implements InterfaceC4569Fr5 {
        private final ZN2 a;

        public d(ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "groupType");
            this.a = zn2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.a == ((d) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "LeaveAndReport(groupType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Fr5$e */
    public static final class e implements InterfaceC4569Fr5 {
        public static final e a = new e();

        private e() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -463228683;
        }

        public String toString() {
            return "None";
        }
    }

    /* renamed from: ir.nasim.Fr5$f */
    public static final class f implements InterfaceC4569Fr5 {
        public static final f a = new f();

        private f() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return 1262141456;
        }

        public String toString() {
            return "Reported";
        }
    }
}
