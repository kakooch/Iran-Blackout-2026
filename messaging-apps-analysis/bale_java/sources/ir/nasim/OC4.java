package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class OC4 {

    public static final class a extends OC4 {
        public static final int c = 0;
        private final String a;
        private final SA2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, SA2 sa2) {
            super(null);
            AbstractC13042fc3.i(str, "buttonText");
            AbstractC13042fc3.i(sa2, "onClickButton");
            this.a = str;
            this.b = sa2;
        }

        public final String a() {
            return this.a;
        }

        public final SA2 b() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Active(buttonText=" + this.a + ", onClickButton=" + this.b + Separators.RPAREN;
        }
    }

    private OC4() {
    }

    public /* synthetic */ OC4(ED1 ed1) {
        this();
    }
}
