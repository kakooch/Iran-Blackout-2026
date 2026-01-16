package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iN, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14721iN {

    /* renamed from: ir.nasim.iN$a */
    public static final class a extends AbstractC14721iN {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "name");
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && AbstractC13042fc3.d(a(), ((a) obj).a());
            }
            return true;
        }

        public int hashCode() {
            String strA = a();
            if (strA != null) {
                return strA.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "BluetoothHeadset(name=" + a() + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.iN$b */
    public static final class b extends AbstractC14721iN {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(null);
            AbstractC13042fc3.i(str, "name");
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && AbstractC13042fc3.d(a(), ((b) obj).a());
            }
            return true;
        }

        public int hashCode() {
            String strA = a();
            if (strA != null) {
                return strA.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Earpiece(name=" + a() + Separators.RPAREN;
        }

        public /* synthetic */ b(String str, int i, ED1 ed1) {
            this((i & 1) != 0 ? "Earpiece" : str);
        }
    }

    /* renamed from: ir.nasim.iN$c */
    public static final class c extends AbstractC14721iN {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            AbstractC13042fc3.i(str, "name");
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && AbstractC13042fc3.d(a(), ((c) obj).a());
            }
            return true;
        }

        public int hashCode() {
            String strA = a();
            if (strA != null) {
                return strA.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Speakerphone(name=" + a() + Separators.RPAREN;
        }

        public /* synthetic */ c(String str, int i, ED1 ed1) {
            this((i & 1) != 0 ? "Speakerphone" : str);
        }
    }

    /* renamed from: ir.nasim.iN$d */
    public static final class d extends AbstractC14721iN {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(null);
            AbstractC13042fc3.i(str, "name");
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && AbstractC13042fc3.d(a(), ((d) obj).a());
            }
            return true;
        }

        public int hashCode() {
            String strA = a();
            if (strA != null) {
                return strA.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "WiredHeadset(name=" + a() + Separators.RPAREN;
        }

        public /* synthetic */ d(String str, int i, ED1 ed1) {
            this((i & 1) != 0 ? "Wired Headset" : str);
        }
    }

    private AbstractC14721iN() {
    }

    public /* synthetic */ AbstractC14721iN(ED1 ed1) {
        this();
    }
}
