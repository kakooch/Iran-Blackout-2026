package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public interface TY1 {

    public static final class a implements TY1 {
        private InterfaceC3346Am2 a;

        public a(InterfaceC3346Am2 interfaceC3346Am2) {
            this.a = interfaceC3346Am2;
        }

        public final InterfaceC3346Am2 a() {
            return this.a;
        }
    }

    public static final class b implements TY1 {
        private int a;

        public b(int i) {
            this.a = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "Downloading(value=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c implements TY1 {
        public static final c a = new c();

        private c() {
        }
    }
}
