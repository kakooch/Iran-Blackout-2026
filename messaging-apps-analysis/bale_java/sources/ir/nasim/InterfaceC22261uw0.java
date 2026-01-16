package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.uw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC22261uw0 {

    /* renamed from: ir.nasim.uw0$a */
    public static final class a implements InterfaceC22261uw0 {
        private final List a;

        public a(List list) {
            AbstractC13042fc3.i(list, "onGoingCall");
            this.a = list;
        }

        @Override // ir.nasim.InterfaceC22261uw0
        public List a() {
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
            return "Normal(onGoingCall=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uw0$b */
    public static final class b implements InterfaceC22261uw0 {
        private final List a;
        private final boolean b;
        private final List c;

        public b(List list, boolean z, List list2) {
            AbstractC13042fc3.i(list, "selectedCallLog");
            AbstractC13042fc3.i(list2, "onGoingCall");
            this.a = list;
            this.b = z;
            this.c = list2;
        }

        @Override // ir.nasim.InterfaceC22261uw0
        public List a() {
            return this.c;
        }

        public final List b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "SelectMode(selectedCallLog=" + this.a + ", isDeleteAllSelected=" + this.b + ", onGoingCall=" + this.c + Separators.RPAREN;
        }
    }

    List a();
}
