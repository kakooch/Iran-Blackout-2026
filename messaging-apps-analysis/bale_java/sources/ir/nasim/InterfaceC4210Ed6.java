package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ed6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC4210Ed6 {

    /* renamed from: ir.nasim.Ed6$a */
    public static final class a implements InterfaceC4210Ed6 {
        private final InterfaceC10258bL6 a;

        public a(InterfaceC10258bL6 interfaceC10258bL6) {
            AbstractC13042fc3.i(interfaceC10258bL6, "participant");
            this.a = interfaceC10258bL6;
        }

        public final InterfaceC10258bL6 a() {
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
            return "Expanded(participant=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Ed6$b */
    public static final class b implements InterfaceC4210Ed6 {
        public static final b a = new b();

        private b() {
        }
    }
}
