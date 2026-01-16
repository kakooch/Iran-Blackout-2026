package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class WF6 {

    public static final class a extends WF6 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 820114858;
        }

        public String toString() {
            return "EmptyFolderError";
        }
    }

    public static final class b extends WF6 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(null);
            AbstractC13042fc3.i(str, "errorMessage");
            this.a = str;
        }

        public final String a() {
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
            return "ErrorMessage(errorMessage=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c extends WF6 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -563932995;
        }

        public String toString() {
            return "FolderCreated";
        }
    }

    public static final class d extends WF6 {
        private final int a;

        public d(int i) {
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
            return (obj instanceof d) && this.a == ((d) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "FolderLimit(folderLimit=" + this.a + Separators.RPAREN;
        }

        public /* synthetic */ d(int i, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? 20 : i);
        }
    }

    public static final class e extends WF6 {
        public static final e a = new e();

        private e() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 1966964587;
        }

        public String toString() {
            return "ReservedFolderEditError";
        }
    }

    public static final class f extends WF6 {
        public static final f a = new f();

        private f() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -74461691;
        }

        public String toString() {
            return "TimeOutResponse";
        }
    }

    private WF6() {
    }

    public /* synthetic */ WF6(ED1 ed1) {
        this();
    }
}
