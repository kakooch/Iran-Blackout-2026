package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public interface IM4 {

    public static final class a implements IM4 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 636914377;
        }

        public String toString() {
            return "CanBeResent";
        }
    }

    public static final class b implements IM4 {
        private final int a;

        public b(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "Waiting(untilInSecond=" + this.a + Separators.RPAREN;
        }
    }
}
