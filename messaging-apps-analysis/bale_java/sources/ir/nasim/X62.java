package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public abstract class X62 {

    public static final class a extends X62 {
        private final int a;
        private final String b;
        private final boolean c;
        private final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, boolean z) {
            super(null);
            AbstractC13042fc3.i(str, "code");
            this.a = i;
            this.b = str;
            this.c = z;
            this.d = i + str.hashCode();
        }

        @Override // ir.nasim.X62
        public int a() {
            return this.d;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.a;
        }

        public final boolean d() {
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
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Emoji(packId=" + this.a + ", code=" + this.b + ", isRecent=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b extends X62 {
        private final int a;
        private final int b;
        private final int c;

        public b(int i, int i2) {
            super(null);
            this.a = i;
            this.b = i2;
            this.c = i;
        }

        @Override // ir.nasim.X62
        public int a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final int c() {
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
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "Header(packId=" + this.a + ", title=" + this.b + Separators.RPAREN;
        }
    }

    private X62() {
    }

    public abstract int a();

    public /* synthetic */ X62(ED1 ed1) {
        this();
    }
}
