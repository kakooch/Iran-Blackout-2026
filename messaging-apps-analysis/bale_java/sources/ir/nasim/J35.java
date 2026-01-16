package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C21753u45;
import java.util.List;

/* loaded from: classes5.dex */
public interface J35 {

    public static final class a implements J35 {
        private final List a;
        private final G35 b;

        public a(List list, G35 g35) {
            AbstractC13042fc3.i(list, "permissions");
            AbstractC13042fc3.i(g35, "permissionDialogState");
            this.a = list;
            this.b = g35;
        }

        public final G35 a() {
            return this.b;
        }

        public final List b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ListPermission(permissions=" + this.a + ", permissionDialogState=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b implements J35 {
        private final C21753u45.d a;

        public b(C21753u45.d dVar) {
            AbstractC13042fc3.i(dVar, "permission");
            this.a = dVar;
        }

        public final C21753u45.d a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SinglePermission(permission=" + this.a + Separators.RPAREN;
        }
    }
}
