package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class G8 {

    public static final class a extends G8 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1657288565;
        }

        public String toString() {
            return "AddContact";
        }
    }

    public static final class b extends G8 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -212277051;
        }

        public String toString() {
            return "BackPressed";
        }
    }

    public static final class c extends G8 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            AbstractC13042fc3.i(str, "fullName");
            this.a = str;
        }

        public final String a() {
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
            return "ChangeContactCountry(fullName=" + this.a + Separators.RPAREN;
        }
    }

    public static final class d extends G8 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            AbstractC13042fc3.i(str, "contactName");
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
            return this.a.hashCode();
        }

        public String toString() {
            return "ChangeContactName(contactName=" + this.a + Separators.RPAREN;
        }
    }

    public static final class e extends G8 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(null);
            AbstractC13042fc3.i(str, "contactPhoneNumber");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ChangeContactPhoneNumber(contactPhoneNumber=" + this.a + Separators.RPAREN;
        }
    }

    private G8() {
    }

    public /* synthetic */ G8(ED1 ed1) {
        this();
    }
}
