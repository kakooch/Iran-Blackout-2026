package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class PC4 {

    public static final class a extends PC4 {
        public static final int b = 0;
        private final SA2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SA2 sa2) {
            super(null);
            AbstractC13042fc3.i(sa2, "onClickClose");
            this.a = sa2;
        }

        public final int a() {
            return AbstractC24188yB5.close;
        }

        public final SA2 b() {
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
            return "Active(onClickClose=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends PC4 {
        public static final b a = new b();
        public static final int b = 0;

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1470001646;
        }

        public String toString() {
            return "Inactive";
        }
    }

    private PC4() {
    }

    public /* synthetic */ PC4(ED1 ed1) {
        this();
    }
}
