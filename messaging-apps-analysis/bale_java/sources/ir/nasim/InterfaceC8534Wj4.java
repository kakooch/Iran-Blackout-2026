package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Wj4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC8534Wj4 {

    /* renamed from: ir.nasim.Wj4$a */
    public static final class a implements InterfaceC8534Wj4 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1755684501;
        }

        public String toString() {
            return "Disabled";
        }
    }

    /* renamed from: ir.nasim.Wj4$b */
    public static final class b implements InterfaceC8534Wj4 {
        private final List a;

        public b(List list) {
            AbstractC13042fc3.i(list, "items");
            this.a = list;
        }

        public final List a() {
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
            return "Enabled(items=" + this.a + Separators.RPAREN;
        }
    }
}
