package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cM, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC10876cM {

    /* renamed from: ir.nasim.cM$b */
    public static final class b implements InterfaceC10876cM {
        private final String a;
        private final float b;

        public b(String str, float f) {
            AbstractC13042fc3.i(str, "title");
            this.a = str;
            this.b = f;
        }

        public static /* synthetic */ b c(b bVar, String str, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bVar.a;
            }
            if ((i & 2) != 0) {
                f = bVar.b;
            }
            return bVar.b(str, f);
        }

        public final b b(String str, float f) {
            AbstractC13042fc3.i(str, "title");
            return new b(str, f);
        }

        @Override // ir.nasim.InterfaceC10876cM
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(float f) {
            return c(this, null, f, 1, null);
        }

        public float e() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && Float.compare(this.b, bVar.b) == 0;
        }

        public String f() {
            return this.a;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            return "Voice(title=" + this.a + ", progress=" + this.b + Separators.RPAREN;
        }
    }

    InterfaceC10876cM a(float f);

    /* renamed from: ir.nasim.cM$a */
    public static final class a implements InterfaceC10876cM {
        private final String a;
        private final float b;
        private final boolean c;

        public a(String str, float f) {
            AbstractC13042fc3.i(str, "title");
            this.a = str;
            this.b = f;
            this.c = true;
        }

        public static /* synthetic */ a c(a aVar, String str, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.a;
            }
            if ((i & 2) != 0) {
                f = aVar.b;
            }
            return aVar.b(str, f);
        }

        public final a b(String str, float f) {
            AbstractC13042fc3.i(str, "title");
            return new a(str, f);
        }

        @Override // ir.nasim.InterfaceC10876cM
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(float f) {
            return c(this, null, f, 1, null);
        }

        public float e() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && Float.compare(this.b, aVar.b) == 0;
        }

        public String f() {
            return this.a;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            return "Music(title=" + this.a + ", progress=" + this.b + Separators.RPAREN;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, float f) {
            this(str + " - " + str2, f);
            AbstractC13042fc3.i(str, "artistName");
            AbstractC13042fc3.i(str2, "musicName");
        }
    }
}
