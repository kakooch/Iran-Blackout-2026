package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class LX {

    public static final class a extends LX {
        public static final int d = 0;
        private final boolean a;
        private final UA2 b;
        private final boolean c;

        public a(boolean z, UA2 ua2, boolean z2) {
            super(null);
            this.a = z;
            this.b = ua2;
            this.c = z2;
        }

        public boolean a() {
            return this.c;
        }

        public final UA2 b() {
            return this.b;
        }

        public final boolean c() {
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
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.a) * 31;
            UA2 ua2 = this.b;
            return ((iHashCode + (ua2 == null ? 0 : ua2.hashCode())) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Tick(isSelect=" + this.a + ", onSelectChange=" + this.b + ", enabled=" + this.c + Separators.RPAREN;
        }

        public /* synthetic */ a(boolean z, UA2 ua2, boolean z2, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : ua2, (i & 4) != 0 ? true : z2);
        }
    }

    private LX() {
    }

    public /* synthetic */ LX(ED1 ed1) {
        this();
    }
}
