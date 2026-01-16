package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class GM3 {
    public static final int a = 0;

    public static final class a extends GM3 {
        public static final a b = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 74035640;
        }

        public String toString() {
            return "Disable";
        }
    }

    public static final class b extends GM3 {
        private final SA2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SA2 sa2) {
            super(null);
            AbstractC13042fc3.i(sa2, "action");
            this.b = sa2;
        }

        public final SA2 a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "NotVote(action=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c extends GM3 {
        private final SA2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2) {
            super(null);
            AbstractC13042fc3.i(sa2, "action");
            this.b = sa2;
        }

        public final SA2 a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.b, ((c) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Voted(action=" + this.b + Separators.RPAREN;
        }
    }

    private GM3() {
    }

    public /* synthetic */ GM3(ED1 ed1) {
        this();
    }
}
