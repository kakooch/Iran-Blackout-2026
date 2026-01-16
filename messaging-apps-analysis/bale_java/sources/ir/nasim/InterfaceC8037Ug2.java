package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ug2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC8037Ug2 {

    /* renamed from: ir.nasim.Ug2$a */
    public static final class a implements InterfaceC8037Ug2 {
        public static final a a = new a();

        private a() {
        }
    }

    /* renamed from: ir.nasim.Ug2$b */
    public static final class b implements InterfaceC8037Ug2 {
        private final EnumC7123Qj2 a;

        public b(EnumC7123Qj2 enumC7123Qj2) {
            AbstractC13042fc3.i(enumC7123Qj2, "feedbackRate");
            this.a = enumC7123Qj2;
        }

        public final EnumC7123Qj2 a() {
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
            return "Selected(feedbackRate=" + this.a + Separators.RPAREN;
        }
    }
}
