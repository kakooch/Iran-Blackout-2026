package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class Y06 {

    public static final class a extends Y06 {
        private final Exception a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Exception exc) {
            super(null);
            AbstractC13042fc3.i(exc, "error");
            this.a = exc;
        }

        public final Exception a() {
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
            return "Failure(error=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends Y06 {
        private final Object a;

        public b(Object obj) {
            super(null);
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private Y06() {
    }

    public /* synthetic */ Y06(ED1 ed1) {
        this();
    }
}
