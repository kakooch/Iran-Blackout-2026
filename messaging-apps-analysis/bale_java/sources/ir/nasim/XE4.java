package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public interface XE4 {

    public static final class a implements XE4 {
        private final InterfaceC4557Fq2 a;
        private final boolean b;

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            AbstractC13042fc3.i(interfaceC4557Fq2, "progressFlow");
            this.a = interfaceC4557Fq2;
            this.b = true;
        }

        @Override // ir.nasim.XE4
        public boolean a() {
            return this.b;
        }

        public final InterfaceC4557Fq2 b() {
            return this.a;
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
            return "DownloadProgressDialog(progressFlow=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements XE4 {
        private final String a;
        private final SA2 b;
        private final boolean c;

        public b(String str, SA2 sa2) {
            AbstractC13042fc3.i(str, "permission");
            AbstractC13042fc3.i(sa2, "onPermissionGranted");
            this.a = str;
            this.b = sa2;
            this.c = true;
        }

        @Override // ir.nasim.XE4
        public boolean a() {
            return this.c;
        }

        public final SA2 b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "PermissionNeeded(permission=" + this.a + ", onPermissionGranted=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c implements XE4 {
        private final int a;
        private final boolean b;

        public c(int i) {
            this.a = i;
        }

        @Override // ir.nasim.XE4
        public boolean a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.a == ((c) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "SnackBar(titleRes=" + this.a + Separators.RPAREN;
        }
    }

    boolean a();
}
