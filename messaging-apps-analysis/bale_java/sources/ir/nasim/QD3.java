package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public interface QD3 {

    public static final class a implements QD3 {
        private final FD3 a;

        public a(FD3 fd3) {
            AbstractC13042fc3.i(fd3, "data");
            this.a = fd3;
        }

        public FD3 a() {
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
            return "Ended(data=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements QD3 {
        private final FD3 a;

        public b(FD3 fd3) {
            AbstractC13042fc3.i(fd3, "data");
            this.a = fd3;
        }

        public FD3 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Started(data=" + this.a + Separators.RPAREN;
        }
    }
}
