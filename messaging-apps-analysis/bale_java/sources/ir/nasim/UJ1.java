package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public abstract class UJ1 {

    public static final class a extends UJ1 {
        private final int a;

        public a(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "ShowBottomSheet(deviceId=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends UJ1 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1651639290;
        }

        public String toString() {
            return "TerminateAllSessions";
        }
    }

    public static final class c extends UJ1 {
        private final Exception a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Exception exc) {
            super(null);
            AbstractC13042fc3.i(exc, "e");
            this.a = exc;
        }

        public final Exception a() {
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
            return "TerminateAllSessionsError(e=" + this.a + Separators.RPAREN;
        }
    }

    public static final class d extends UJ1 {
        private final Exception a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Exception exc) {
            super(null);
            AbstractC13042fc3.i(exc, "e");
            this.a = exc;
        }

        public final Exception a() {
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
            return "TerminateSessionsError(e=" + this.a + Separators.RPAREN;
        }
    }

    public static final class e extends UJ1 {
        private final int a;

        public e(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.a == ((e) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "TerminateThisSessions(deviceId=" + this.a + Separators.RPAREN;
        }
    }

    private UJ1() {
    }

    public /* synthetic */ UJ1(ED1 ed1) {
        this();
    }
}
