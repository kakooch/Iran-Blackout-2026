package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public abstract class VT1 {

    public static final class a extends VT1 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "err");
            this.a = th;
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
            return "Error(err=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends VT1 {
        public static final b a = new b();

        private b() {
            super(null);
        }
    }

    public static final class c extends VT1 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    public static final class d extends VT1 {
        private final long a;

        public d(long j) {
            super(null);
            this.a = j;
        }

        public final long a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.a == ((d) obj).a;
        }

        public int hashCode() {
            return Long.hashCode(this.a);
        }

        public String toString() {
            return "Success(finalPrice=" + this.a + Separators.RPAREN;
        }
    }

    private VT1() {
    }

    public /* synthetic */ VT1(ED1 ed1) {
        this();
    }
}
