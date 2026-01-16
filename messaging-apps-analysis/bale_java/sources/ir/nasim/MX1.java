package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public interface MX1 {

    public static final class a implements MX1 {
        private final long a;
        private final String b;
        private final C11910dl2 c;
        private final C4995Hl2 d;

        public a(long j, String str, C11910dl2 c11910dl2, C4995Hl2 c4995Hl2) {
            AbstractC13042fc3.i(str, "fileName");
            AbstractC13042fc3.i(c11910dl2, "fileDescriptor");
            AbstractC13042fc3.i(c4995Hl2, "fileLocation");
            this.a = j;
            this.b = str;
            this.c = c11910dl2;
            this.d = c4995Hl2;
        }

        @Override // ir.nasim.MX1
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.MX1
        public long b() {
            return this.a;
        }

        @Override // ir.nasim.MX1
        public C4995Hl2 c() {
            return this.d;
        }

        public final C11910dl2 d() {
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
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "DownloadInput.Standard(fileLocation=" + c() + Separators.RPAREN;
        }
    }

    public static final class b implements MX1 {
        private final String a;
        private final long b;
        private final String c;
        private final C4995Hl2 d;

        public b(String str, long j, String str2, C4995Hl2 c4995Hl2) {
            AbstractC13042fc3.i(str, "cacheKey");
            AbstractC13042fc3.i(str2, "fileName");
            AbstractC13042fc3.i(c4995Hl2, "fileLocation");
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = c4995Hl2;
        }

        @Override // ir.nasim.MX1
        public String a() {
            return this.c;
        }

        @Override // ir.nasim.MX1
        public long b() {
            return this.b;
        }

        @Override // ir.nasim.MX1
        public C4995Hl2 c() {
            return this.d;
        }

        public final String d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "DownloadInput.Streamable(fileLocation=" + c() + Separators.RPAREN;
        }
    }

    String a();

    long b();

    C4995Hl2 c();
}
