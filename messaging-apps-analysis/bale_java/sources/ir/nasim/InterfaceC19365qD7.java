package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qD7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC19365qD7 {

    /* renamed from: ir.nasim.qD7$a */
    public static final class a implements InterfaceC19365qD7 {
        private final InterfaceC9905al2 a;

        public a(InterfaceC9905al2 interfaceC9905al2) {
            AbstractC13042fc3.i(interfaceC9905al2, "fileContent");
            this.a = interfaceC9905al2;
        }

        public final InterfaceC9905al2 a() {
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
            return "Downloaded(fileContent=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qD7$b */
    public static final class b implements InterfaceC19365qD7 {
        private final InterfaceC19096pm2 a;

        public b(InterfaceC19096pm2 interfaceC19096pm2) {
            AbstractC13042fc3.i(interfaceC19096pm2, "fileState");
            this.a = interfaceC19096pm2;
        }

        public final InterfaceC19096pm2 a() {
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
            return "NotDownloaded(fileState=" + this.a + Separators.RPAREN;
        }
    }
}
