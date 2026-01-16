package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.EX4;

/* loaded from: classes6.dex */
public interface WX4 {

    public static final class a implements WX4 {
        private final BX4 a;
        private final EX4.a b;

        public a(BX4 bx4, EX4.a aVar) {
            AbstractC13042fc3.i(bx4, "field");
            AbstractC13042fc3.i(aVar, "fieldType");
            this.a = bx4;
            this.b = aVar;
        }

        public final BX4 a() {
            return this.a;
        }

        public final EX4.a b() {
            return this.b;
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
            return "DatePickerRequested(field=" + this.a + ", fieldType=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b implements WX4 {
        private final BX4 a;
        private final EX4 b;

        public b(BX4 bx4, EX4 ex4) {
            AbstractC13042fc3.i(bx4, "field");
            AbstractC13042fc3.i(ex4, "fieldType");
            this.a = bx4;
            this.b = ex4;
        }

        public final BX4 a() {
            return this.a;
        }

        public final EX4 b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "OnFieldChanged(field=" + this.a + ", fieldType=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c implements WX4 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1498359175;
        }

        public String toString() {
            return "OnUpdateRequest";
        }
    }

    public static final class d implements WX4 {
        public static final d a = new d();

        private d() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -1995179734;
        }

        public String toString() {
            return "SubmitForm";
        }
    }
}
