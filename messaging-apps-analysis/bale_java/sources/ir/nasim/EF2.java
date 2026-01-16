package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public abstract class EF2 {

    public static final class a extends EF2 {
        private final Exception a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Exception exc) {
            super(null);
            AbstractC13042fc3.i(exc, "exception");
            this.a = exc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failed(exception=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends EF2 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    public static final class c extends EF2 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    public static final class d extends EF2 {
        public static final d a = new d();

        private d() {
            super(null);
        }
    }

    private EF2() {
    }

    public /* synthetic */ EF2(ED1 ed1) {
        this();
    }
}
