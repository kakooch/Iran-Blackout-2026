package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.vZ4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC22627vZ4 {

    /* renamed from: ir.nasim.vZ4$a */
    public static final class a implements InterfaceC22627vZ4 {
        private final int a;

        public a(int i) {
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
            return "OnClickSetting(groupId=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.vZ4$b */
    public static final class b implements InterfaceC22627vZ4 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1001822901;
        }

        public String toString() {
            return "OnDeleteAllRequest";
        }
    }

    /* renamed from: ir.nasim.vZ4$c */
    public static final class c implements InterfaceC22627vZ4 {
        private final boolean a;

        public c(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.a == ((c) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public String toString() {
            return "OnDeleteAllResponse(approved=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.vZ4$d */
    public static final class d implements InterfaceC22627vZ4 {
        public static final d a = new d();

        private d() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -1101534977;
        }

        public String toString() {
            return "OnErrorDialogResponse";
        }
    }

    /* renamed from: ir.nasim.vZ4$e */
    public static final class e implements InterfaceC22627vZ4 {
        public static final e a = new e();

        private e() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -267576740;
        }

        public String toString() {
            return "OnHelpDialogResponse";
        }
    }
}
