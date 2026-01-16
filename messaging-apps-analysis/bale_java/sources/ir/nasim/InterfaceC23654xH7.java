package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC23654xH7 {

    /* renamed from: ir.nasim.xH7$a */
    public static final class a implements InterfaceC23654xH7 {
        private final ZG7 a;

        public a(ZG7 zg7) {
            AbstractC13042fc3.i(zg7, "error");
            this.a = zg7;
        }

        public final ZG7 a() {
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
            return "Failed(error=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.xH7$b */
    public static final class b implements InterfaceC23654xH7 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1372314439;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.xH7$c */
    public static final class c implements InterfaceC23654xH7 {
        private final long a;
        private final InterfaceC3346Am2 b;

        public c(long j, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "fileReference");
            this.a = j;
            this.b = interfaceC3346Am2;
        }

        public static /* synthetic */ c b(c cVar, long j, InterfaceC3346Am2 interfaceC3346Am2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = cVar.a;
            }
            if ((i & 2) != 0) {
                interfaceC3346Am2 = cVar.b;
            }
            return cVar.a(j, interfaceC3346Am2);
        }

        public final c a(long j, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "fileReference");
            return new c(j, interfaceC3346Am2);
        }

        public final long c() {
            return this.a;
        }

        public final InterfaceC3346Am2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b);
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Uploaded(fileId=" + this.a + ", fileReference=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.xH7$d */
    public static final class d implements InterfaceC23654xH7 {
        private final WG7 a;

        public d(WG7 wg7) {
            this.a = wg7;
        }

        public final WG7 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            WG7 wg7 = this.a;
            if (wg7 == null) {
                return 0;
            }
            return wg7.hashCode();
        }

        public String toString() {
            return "Uploading(lastUploadConfig=" + this.a + Separators.RPAREN;
        }
    }
}
