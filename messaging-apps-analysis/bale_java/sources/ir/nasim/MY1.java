package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public interface MY1 {

    public static final class a implements MY1 {
        private final EX1 a;

        public a(EX1 ex1) {
            AbstractC13042fc3.i(ex1, "error");
            this.a = ex1;
        }

        public final EX1 a() {
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

    public static final class b implements MY1 {
        private final Object a;

        public b(Object obj) {
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
}
