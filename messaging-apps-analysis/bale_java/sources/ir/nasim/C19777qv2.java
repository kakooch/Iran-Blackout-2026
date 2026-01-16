package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.qv2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19777qv2 {
    private final List a;
    private final C13245fu b;

    public C19777qv2(List list, C13245fu c13245fu) {
        AbstractC13042fc3.i(list, "fieldGroups");
        this.a = list;
        this.b = c13245fu;
    }

    public static /* synthetic */ C19777qv2 b(C19777qv2 c19777qv2, List list, C13245fu c13245fu, int i, Object obj) {
        if ((i & 1) != 0) {
            list = c19777qv2.a;
        }
        if ((i & 2) != 0) {
            c13245fu = c19777qv2.b;
        }
        return c19777qv2.a(list, c13245fu);
    }

    public final C19777qv2 a(List list, C13245fu c13245fu) {
        AbstractC13042fc3.i(list, "fieldGroups");
        return new C19777qv2(list, c13245fu);
    }

    public final C13245fu c() {
        return this.b;
    }

    public final List d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19777qv2)) {
            return false;
        }
        C19777qv2 c19777qv2 = (C19777qv2) obj;
        return AbstractC13042fc3.d(this.a, c19777qv2.a) && AbstractC13042fc3.d(this.b, c19777qv2.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C13245fu c13245fu = this.b;
        return iHashCode + (c13245fu == null ? 0 : c13245fu.hashCode());
    }

    public String toString() {
        return "FormUiState(fieldGroups=" + this.a + ", description=" + ((Object) this.b) + Separators.RPAREN;
    }

    public /* synthetic */ C19777qv2(List list, C13245fu c13245fu, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC10360bX0.m() : list, (i & 2) != 0 ? null : c13245fu);
    }
}
