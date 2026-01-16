package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public interface JA7 {

    public static final class a implements JA7 {
        private final String a;
        private final float b;
        private final boolean c;

        public a(String str, float f) {
            AbstractC13042fc3.i(str, "title");
            this.a = str;
            this.b = f;
            this.c = true;
        }

        @Override // ir.nasim.JA7
        public boolean a() {
            return this.c;
        }

        @Override // ir.nasim.JA7
        public float b() {
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

        @Override // ir.nasim.JA7
        public String getTitle() {
            return this.a;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            return "Music(title=" + this.a + ", progress=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b implements JA7 {
        private final String a;
        private final float b;
        private final boolean c;

        public b(String str, float f) {
            AbstractC13042fc3.i(str, "title");
            this.a = str;
            this.b = f;
        }

        @Override // ir.nasim.JA7
        public boolean a() {
            return this.c;
        }

        @Override // ir.nasim.JA7
        public float b() {
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

        @Override // ir.nasim.JA7
        public String getTitle() {
            return this.a;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            return "Voice(title=" + this.a + ", progress=" + this.b + Separators.RPAREN;
        }
    }

    boolean a();

    float b();

    String getTitle();
}
