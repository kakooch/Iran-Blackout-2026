package ir.nasim.features.smiles.panel.sticker;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C23698xM6;
import ir.nasim.ED1;

/* loaded from: classes6.dex */
public abstract class l {

    public static final class a extends l {
        private final C23698xM6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C23698xM6 c23698xM6) {
            super(null);
            AbstractC13042fc3.i(c23698xM6, "sticker");
            this.a = c23698xM6;
        }

        @Override // ir.nasim.features.smiles.panel.sticker.l
        public int a() {
            Integer numU = this.a.u();
            if (numU != null) {
                return numU.intValue();
            }
            return -1;
        }

        public final C23698xM6 b() {
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
            return "Pack(sticker=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends l {
        private final int a;
        private final int b;

        public b(int i, int i2) {
            super(null);
            this.a = i;
            this.b = i2;
        }

        @Override // ir.nasim.features.smiles.panel.sticker.l
        public int a() {
            return this.a;
        }

        public final int b() {
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
            return "Recent(id=" + this.a + ", iconRes=" + this.b + Separators.RPAREN;
        }
    }

    private l() {
    }

    public abstract int a();

    public /* synthetic */ l(ED1 ed1) {
        this();
    }
}
