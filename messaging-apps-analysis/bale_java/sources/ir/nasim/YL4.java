package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class YL4 {

    public static final class a extends YL4 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "error");
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
            return "Fail(error=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends YL4 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1703296949;
        }

        public String toString() {
            return "Ideal";
        }
    }

    public static final class c extends YL4 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -835311460;
        }

        public String toString() {
            return "Loading";
        }
    }

    public static final class d extends YL4 {
        private final List a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list) {
            super(null);
            AbstractC13042fc3.i(list, "data");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private YL4() {
    }

    public /* synthetic */ YL4(ED1 ed1) {
        this();
    }
}
