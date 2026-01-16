package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.qR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC19490qR6 {

    /* renamed from: ir.nasim.qR6$a */
    public static final class a implements InterfaceC19490qR6 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1704786059;
        }

        public String toString() {
            return "Empty";
        }
    }

    /* renamed from: ir.nasim.qR6$b */
    public static final class b implements InterfaceC19490qR6 {
        private String a;
        private List b;
        private final String c;

        public b(String str, List list, String str2) {
            AbstractC13042fc3.i(str, "link");
            this.a = str;
            this.b = list;
            this.c = str2;
        }

        public String b() {
            return this.a;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            List list = this.b;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.c;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Link(link=" + this.a + ", widgetCoordinate=" + this.b + ", title=" + this.c + Separators.RPAREN;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    default java.lang.String a() {
        /*
            r4 = this;
            boolean r0 = r4 instanceof ir.nasim.InterfaceC19490qR6.b
            r1 = 0
            if (r0 == 0) goto L9
            r0 = r4
            ir.nasim.qR6$b r0 = (ir.nasim.InterfaceC19490qR6.b) r0
            goto La
        L9:
            r0 = r1
        La:
            if (r0 == 0) goto L26
            r0 = r4
            ir.nasim.qR6$b r0 = (ir.nasim.InterfaceC19490qR6.b) r0
            java.lang.String r2 = r0.c()
            if (r2 == 0) goto L20
            boolean r3 = ir.nasim.AbstractC14836iZ6.n0(r2)
            r3 = r3 ^ 1
            if (r3 == 0) goto L1e
            r1 = r2
        L1e:
            if (r1 != 0) goto L24
        L20:
            java.lang.String r1 = r0.b()
        L24:
            if (r1 != 0) goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.InterfaceC19490qR6.a():java.lang.String");
    }
}
