package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public abstract class Y48 {

    public static final class a extends Y48 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1157187283;
        }

        public String toString() {
            return "BotSendMessageAgreement";
        }
    }

    public static final class b extends Y48 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 811353916;
        }

        public String toString() {
            return "ConfirmToClose";
        }
    }

    public static final class c extends Y48 {
        private final String a;
        private final D88 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, D88 d88) {
            super(null);
            AbstractC13042fc3.i(str, "webappName");
            AbstractC13042fc3.i(d88, "requestState");
            this.a = str;
            this.b = d88;
        }

        public final D88 a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Permissions(webappName=" + this.a + ", requestState=" + this.b + Separators.RPAREN;
        }
    }

    public static final class d extends Y48 {
        private final String a;

        public d(String str) {
            super(null);
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "SendContact(phoneNumber=" + this.a + Separators.RPAREN;
        }
    }

    public static final class e extends Y48 {
        public static final e a = new e();

        private e() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 482058725;
        }

        public String toString() {
            return "TermOfUse";
        }
    }

    public static final class f extends Y48 {
        public static final f a = new f();

        private f() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return 160693236;
        }

        public String toString() {
            return "Unblocked";
        }
    }

    private Y48() {
    }

    public /* synthetic */ Y48(ED1 ed1) {
        this();
    }
}
