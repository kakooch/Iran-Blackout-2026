package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.u83, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC21791u83 {

    /* renamed from: ir.nasim.u83$a */
    public static final class a implements InterfaceC21791u83 {
        private final C17337mn6 a;

        public a(C17337mn6 c17337mn6) {
            this.a = c17337mn6;
        }

        public final C17337mn6 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            C17337mn6 c17337mn6 = this.a;
            if (c17337mn6 == null) {
                return 0;
            }
            return c17337mn6.hashCode();
        }

        public String toString() {
            return "FullyVisible(inputBarCandidate=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.u83$b */
    public static final class b implements InterfaceC21791u83 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -10701799;
        }

        public String toString() {
            return "Gone";
        }
    }

    /* renamed from: ir.nasim.u83$c */
    public static final class c implements InterfaceC21791u83 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -2091981570;
        }

        public String toString() {
            return "SendButtonVisible";
        }
    }
}
