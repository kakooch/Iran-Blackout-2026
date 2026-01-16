package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class L00 {
    public static final a c = new a(null);
    private final C9348Zn7 a;
    private final C9348Zn7 b;

    public static final class a {
        private a() {
        }

        public final L00 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(623223958);
            G10 g10 = G10.a;
            L00 l00 = new L00(g10.d(interfaceC22053ub1, 6).d(), g10.d(interfaceC22053ub1, 6).a());
            interfaceC22053ub1.Q();
            return l00;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public L00(C9348Zn7 c9348Zn7, C9348Zn7 c9348Zn72) {
        AbstractC13042fc3.i(c9348Zn7, "titleStyle");
        AbstractC13042fc3.i(c9348Zn72, "descriptionStyle");
        this.a = c9348Zn7;
        this.b = c9348Zn72;
    }

    public final C9348Zn7 a() {
        return this.b;
    }

    public final C9348Zn7 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L00)) {
            return false;
        }
        L00 l00 = (L00) obj;
        return AbstractC13042fc3.d(this.a, l00.a) && AbstractC13042fc3.d(this.b, l00.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "BaleProfileItemTypography(titleStyle=" + this.a + ", descriptionStyle=" + this.b + Separators.RPAREN;
    }
}
