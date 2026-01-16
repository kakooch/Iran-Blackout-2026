package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC17858ng6;

/* renamed from: ir.nasim.fi6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13132fi6 {
    public static final int c = AbstractC17858ng6.a;
    private final AbstractC17858ng6 a;
    private final boolean b;

    public C13132fi6(AbstractC17858ng6 abstractC17858ng6, boolean z) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        this.a = abstractC17858ng6;
        this.b = z;
    }

    public static /* synthetic */ C13132fi6 b(C13132fi6 c13132fi6, AbstractC17858ng6 abstractC17858ng6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC17858ng6 = c13132fi6.a;
        }
        if ((i & 2) != 0) {
            z = c13132fi6.b;
        }
        return c13132fi6.a(abstractC17858ng6, z);
    }

    public final C13132fi6 a(AbstractC17858ng6 abstractC17858ng6, boolean z) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        return new C13132fi6(abstractC17858ng6, z);
    }

    public final AbstractC17858ng6 c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13132fi6)) {
            return false;
        }
        C13132fi6 c13132fi6 = (C13132fi6) obj;
        return AbstractC13042fc3.d(this.a, c13132fi6.a) && this.b == c13132fi6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "SearchUiState(searchFocusState=" + this.a + ", isMembersEmpty=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C13132fi6(AbstractC17858ng6 abstractC17858ng6, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC17858ng6.b.b : abstractC17858ng6, (i & 2) != 0 ? false : z);
    }
}
