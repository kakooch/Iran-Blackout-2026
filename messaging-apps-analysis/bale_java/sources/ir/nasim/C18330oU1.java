package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.oU1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18330oU1 {
    private final List a;
    private final boolean b;

    public C18330oU1(List list, boolean z) {
        AbstractC13042fc3.i(list, "discoversData");
        this.a = list;
        this.b = z;
    }

    public final C18330oU1 a(List list, boolean z) {
        AbstractC13042fc3.i(list, "discoversData");
        return new C18330oU1(list, z);
    }

    public final List b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18330oU1)) {
            return false;
        }
        C18330oU1 c18330oU1 = (C18330oU1) obj;
        return AbstractC13042fc3.d(this.a, c18330oU1.a) && this.b == c18330oU1.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "DiscoverUiState(discoversData=" + this.a + ", loaded=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C18330oU1(List list, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC10360bX0.m() : list, (i & 2) != 0 ? false : z);
    }
}
