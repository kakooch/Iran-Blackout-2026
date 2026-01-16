package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aA7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC9566aA7 {

    /* renamed from: ir.nasim.aA7$a */
    public static final class a implements InterfaceC9566aA7 {
        private final AbstractC17632nI2 a;

        public a(AbstractC17632nI2 abstractC17632nI2) {
            AbstractC13042fc3.i(abstractC17632nI2, "exceptionState");
            this.a = abstractC17632nI2;
        }

        public final AbstractC17632nI2 a() {
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
            return "Failure(exceptionState=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.aA7$b */
    public static final class b implements InterfaceC9566aA7 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -984340947;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* renamed from: ir.nasim.aA7$c */
    public static final class c implements InterfaceC9566aA7 {
        private final InterfaceC17041mI2 a;

        public c(InterfaceC17041mI2 interfaceC17041mI2) {
            AbstractC13042fc3.i(interfaceC17041mI2, "dataState");
            this.a = interfaceC17041mI2;
        }

        public final InterfaceC17041mI2 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Success(dataState=" + this.a + Separators.RPAREN;
        }
    }
}
