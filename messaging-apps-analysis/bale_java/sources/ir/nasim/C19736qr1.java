package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC17858ng6;

/* renamed from: ir.nasim.qr1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19736qr1 {
    public static final int c = AbstractC17858ng6.a;
    private final AbstractC17858ng6 a;
    private final String b;

    public C19736qr1(AbstractC17858ng6 abstractC17858ng6, String str) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        AbstractC13042fc3.i(str, "searchQuery");
        this.a = abstractC17858ng6;
        this.b = str;
    }

    public static /* synthetic */ C19736qr1 b(C19736qr1 c19736qr1, AbstractC17858ng6 abstractC17858ng6, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC17858ng6 = c19736qr1.a;
        }
        if ((i & 2) != 0) {
            str = c19736qr1.b;
        }
        return c19736qr1.a(abstractC17858ng6, str);
    }

    public final C19736qr1 a(AbstractC17858ng6 abstractC17858ng6, String str) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        AbstractC13042fc3.i(str, "searchQuery");
        return new C19736qr1(abstractC17858ng6, str);
    }

    public final AbstractC17858ng6 c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19736qr1)) {
            return false;
        }
        C19736qr1 c19736qr1 = (C19736qr1) obj;
        return AbstractC13042fc3.d(this.a, c19736qr1.a) && AbstractC13042fc3.d(this.b, c19736qr1.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CreateGroupCallState(searchFocusState=" + this.a + ", searchQuery=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C19736qr1(AbstractC17858ng6 abstractC17858ng6, String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC17858ng6.b.b : abstractC17858ng6, (i & 2) != 0 ? "" : str);
    }
}
