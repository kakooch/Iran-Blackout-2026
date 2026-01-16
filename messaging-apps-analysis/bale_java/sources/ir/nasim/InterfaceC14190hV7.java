package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* renamed from: ir.nasim.hV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC14190hV7 extends Serializable {

    /* renamed from: ir.nasim.hV7$a */
    public static final class a implements InterfaceC14190hV7 {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            AbstractC13042fc3.i(str, "path");
            this.a = str;
            this.b = str2;
        }

        public final String a() {
            return this.a;
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
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "File(path=" + this.a + ", mimeType=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.hV7$b */
    public static final class b implements InterfaceC14190hV7 {
        private final long a;
        private final long b;
        private final String c;
        private final long d;
        private final boolean e;
        private final String f;
        private final String g;

        public b(long j, long j2, String str, long j3, boolean z, String str2, String str3) {
            AbstractC13042fc3.i(str, "fileName");
            AbstractC13042fc3.i(str2, "cacheKey");
            this.a = j;
            this.b = j2;
            this.c = str;
            this.d = j3;
            this.e = z;
            this.f = str2;
            this.g = str3;
        }

        public final String a() {
            return this.f;
        }

        public final long b() {
            return this.d;
        }

        public final long c() {
            return this.a;
        }

        public final String d() {
            return this.c;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e && AbstractC13042fc3.d(this.f, bVar.f) && AbstractC13042fc3.d(this.g, bVar.g);
        }

        public int hashCode() {
            int iHashCode = ((((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
            String str = this.g;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Stream(fileId=" + this.a + ", fileSize=" + this.b + ", fileName=" + this.c + ", fileAccessHash=" + this.d + ", isFullyCached=" + this.e + ", cacheKey=" + this.f + ", mimeType=" + this.g + Separators.RPAREN;
        }
    }
}
