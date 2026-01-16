package ir.nasim.features.root;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import java.util.List;

/* loaded from: classes6.dex */
public interface L {

    public static final class a implements L {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -2111921125;
        }

        public String toString() {
            return "Idle";
        }
    }

    public static final class b implements L {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -593935467;
        }

        public String toString() {
            return "Loading";
        }
    }

    public static final class c implements L {
        private final List a;

        public c(List list) {
            AbstractC13042fc3.i(list, "sharedContents");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Ready(sharedContents=" + this.a + Separators.RPAREN;
        }
    }
}
