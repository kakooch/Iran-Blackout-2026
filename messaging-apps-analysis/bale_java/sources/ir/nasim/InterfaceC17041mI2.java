package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC17041mI2 {

    /* renamed from: ir.nasim.mI2$a */
    public static final class a implements InterfaceC17041mI2 {
        private final YI5 a;

        public a(YI5 yi5) {
            AbstractC13042fc3.i(yi5, "dataState");
            this.a = yi5;
        }

        public final YI5 a() {
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
            return "Receiver(dataState=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.mI2$b */
    public static final class b implements InterfaceC17041mI2 {
        private final InterfaceC7406Ro6 a;

        public b(InterfaceC7406Ro6 interfaceC7406Ro6) {
            AbstractC13042fc3.i(interfaceC7406Ro6, "dataState");
            this.a = interfaceC7406Ro6;
        }

        public final InterfaceC7406Ro6 a() {
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
            return "Sender(dataState=" + this.a + Separators.RPAREN;
        }
    }
}
