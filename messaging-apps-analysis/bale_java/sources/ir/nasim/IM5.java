package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class IM5 {

    public static final class a extends IM5 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "errorMessage");
            this.a = str;
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
            return "Failure(errorMessage=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends IM5 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 817805155;
        }

        public String toString() {
            return "Loading";
        }
    }

    public static final class c extends IM5 {
        private final List a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list) {
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
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.a + Separators.RPAREN;
        }
    }

    private IM5() {
    }

    public /* synthetic */ IM5(ED1 ed1) {
        this();
    }
}
