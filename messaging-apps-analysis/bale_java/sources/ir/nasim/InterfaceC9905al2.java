package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Set;

/* renamed from: ir.nasim.al2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC9905al2 {

    /* renamed from: ir.nasim.al2$a */
    public static final class a implements InterfaceC9905al2 {
        private final String a;
        private final long b;

        public a(String str, long j) {
            AbstractC13042fc3.i(str, "filePath");
            this.a = str;
            this.b = j;
        }

        public final String a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "Standard(filePath=" + this.a + ", fileSize=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.al2$b */
    public static final class b implements InterfaceC9905al2 {
        private final long a;
        private final Set b;

        public b(long j, Set set) {
            AbstractC13042fc3.i(set, "cacheSpans");
            this.a = j;
            this.b = set;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Streamable(fileSize=" + this.a + ", cacheSpans=" + this.b + Separators.RPAREN;
        }
    }
}
