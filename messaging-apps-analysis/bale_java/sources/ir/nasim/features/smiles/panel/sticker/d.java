package ir.nasim.features.smiles.panel.sticker;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C23698xM6;
import ir.nasim.ED1;

/* loaded from: classes6.dex */
public abstract class d {

    public static final class a extends d {
        private final Integer a;
        private final String b;
        private final int c;

        public /* synthetic */ a(Integer num, String str, int i, int i2, ED1 ed1) {
            this(num, (i2 & 2) != 0 ? null : str, i);
        }

        public final int a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public final Integer c() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c;
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.b;
            return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "Header(titleRes=" + this.a + ", title=" + this.b + ", packId=" + this.c + Separators.RPAREN;
        }

        public a(Integer num, String str, int i) {
            super(null);
            this.a = num;
            this.b = str;
            this.c = i;
        }
    }

    public static final class b extends d {
        private final C23698xM6 a;
        private final boolean b;
        private final int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C23698xM6 c23698xM6, boolean z, int i) {
            super(null);
            AbstractC13042fc3.i(c23698xM6, "sticker");
            this.a = c23698xM6;
            this.b = z;
            this.c = i;
        }

        public final int a() {
            return this.c;
        }

        public final C23698xM6 b() {
            return this.a;
        }

        public final boolean c() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "Sticker(sticker=" + this.a + ", isRecent=" + this.b + ", packId=" + this.c + Separators.RPAREN;
        }
    }

    private d() {
    }

    public /* synthetic */ d(ED1 ed1) {
        this();
    }
}
