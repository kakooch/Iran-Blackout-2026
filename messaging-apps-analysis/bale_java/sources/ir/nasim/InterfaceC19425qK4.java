package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qK4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC19425qK4 {

    /* renamed from: ir.nasim.qK4$a */
    public static final class a implements InterfaceC19425qK4 {
        private final EnumC11273cj7 a;

        public a(EnumC11273cj7 enumC11273cj7) {
            AbstractC13042fc3.i(enumC11273cj7, "tabType");
            this.a = enumC11273cj7;
        }

        public final EnumC11273cj7 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ChangeTab(tabType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qK4$b */
    public static final class b implements InterfaceC19425qK4 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 173191971;
        }

        public String toString() {
            return "ClickBanner";
        }
    }

    /* renamed from: ir.nasim.qK4$c */
    public static final class c implements InterfaceC19425qK4 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -996493421;
        }

        public String toString() {
            return "CloseBanner";
        }
    }

    /* renamed from: ir.nasim.qK4$d */
    public static final class d implements InterfaceC19425qK4 {
        private final int a;
        private final String b;
        private final EnumC11273cj7 c;

        public d(int i, String str, EnumC11273cj7 enumC11273cj7) {
            AbstractC13042fc3.i(str, "bannerUrl");
            AbstractC13042fc3.i(enumC11273cj7, "tabType");
            this.a = i;
            this.b = str;
            this.c = enumC11273cj7;
        }

        public final String a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public final EnumC11273cj7 c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && AbstractC13042fc3.d(this.b, dVar.b) && this.c == dVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Initialize(scenarioId=" + this.a + ", bannerUrl=" + this.b + ", tabType=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qK4$e */
    public static final class e implements InterfaceC19425qK4 {
        public static final e a = new e();

        private e() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -586823678;
        }

        public String toString() {
            return "ViewBanner";
        }
    }
}
