package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.EX4;

/* renamed from: ir.nasim.uY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC22028uY4 {

    /* renamed from: ir.nasim.uY4$a */
    public static final class a implements InterfaceC22028uY4 {
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

    /* renamed from: ir.nasim.uY4$b */
    public static final class b implements InterfaceC22028uY4 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1368450853;
        }

        public String toString() {
            return "OnCancel";
        }
    }

    /* renamed from: ir.nasim.uY4$c */
    public static final class c implements InterfaceC22028uY4 {
        public static final c a = new c();

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1407652614;
        }

        public String toString() {
            return "OnErrorDialogResponse";
        }
    }

    /* renamed from: ir.nasim.uY4$d */
    public static final class d implements InterfaceC22028uY4 {
        private final BX4 a;
        private final EX4 b;

        public d(BX4 bx4, EX4 ex4) {
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
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "OnFieldChanged(field=" + this.a + ", fieldType=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uY4$e */
    public static final class e implements InterfaceC22028uY4 {
        public static final e a = new e();

        private e() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 2110577844;
        }

        public String toString() {
            return "OnPassportCreatedDialogResponse";
        }
    }

    /* renamed from: ir.nasim.uY4$f */
    public static final class f implements InterfaceC22028uY4 {
        private final boolean a;

        public f(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.a == ((f) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public String toString() {
            return "OnSaveDataDialogResponse(approved=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.uY4$g */
    public static final class g implements InterfaceC22028uY4 {
        public static final g a = new g();

        private g() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof g);
        }

        public int hashCode() {
            return -67645829;
        }

        public String toString() {
            return "OnUpdateRequest";
        }
    }

    /* renamed from: ir.nasim.uY4$h */
    public static final class h implements InterfaceC22028uY4 {
        public static final h a = new h();

        private h() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof h);
        }

        public int hashCode() {
            return 392236008;
        }

        public String toString() {
            return "SubmitForm";
        }
    }
}
