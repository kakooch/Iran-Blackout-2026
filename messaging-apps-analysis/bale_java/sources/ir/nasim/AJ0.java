package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public abstract class AJ0 {

    public static final class a extends AJ0 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "error");
            this.a = th;
        }

        public final Throwable a() {
            return this.a;
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
            return "Fail(error=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends AJ0 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 545777715;
        }

        public String toString() {
            return "Ideal";
        }
    }

    public static final class c extends AJ0 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1276381281;
        }

        public String toString() {
            return "Success";
        }
    }

    private AJ0() {
    }

    public /* synthetic */ AJ0(ED1 ed1) {
        this();
    }
}
