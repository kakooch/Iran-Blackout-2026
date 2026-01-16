package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nw1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC18013nw1 {

    /* renamed from: ir.nasim.nw1$a */
    public static final class a implements InterfaceC18013nw1 {
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

    /* renamed from: ir.nasim.nw1$b */
    public static final class b implements InterfaceC18013nw1 {
        private final float a;
        private final InterfaceC19096pm2 b;

        public b(float f, InterfaceC19096pm2 interfaceC19096pm2) {
            this.a = f;
            this.b = interfaceC19096pm2;
        }

        public final InterfaceC19096pm2 a() {
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
            return Float.compare(this.a, bVar.a) == 0 && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            int iHashCode = Float.hashCode(this.a) * 31;
            InterfaceC19096pm2 interfaceC19096pm2 = this.b;
            return iHashCode + (interfaceC19096pm2 == null ? 0 : interfaceC19096pm2.hashCode());
        }

        public String toString() {
            return "NotDownloaded(progress=" + this.a + ", fileState=" + this.b + Separators.RPAREN;
        }
    }
}
