package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.pm2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC19096pm2 {

    /* renamed from: ir.nasim.pm2$a */
    public static final class a implements InterfaceC19096pm2 {
        private final String a;
        private final int b;
        private final List c;

        public a(String str, int i, List list) {
            AbstractC13042fc3.i(str, "filePath");
            AbstractC13042fc3.i(list, "remainingChunkIndices");
            this.a = str;
            this.b = i;
            this.c = list;
        }

        public final int a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public final List c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Standard(filePath=" + this.a + ", chunkSizeInByte=" + this.b + ", remainingChunkIndices=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.pm2$b */
    public static final class b implements InterfaceC19096pm2 {
        private final List a;

        public b(List list) {
            AbstractC13042fc3.i(list, "cacheSpans");
            this.a = list;
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
            return "Streamable(cacheSpans=" + this.a + Separators.RPAREN;
        }
    }
}
