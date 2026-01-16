package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Rm6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7388Rm6 {
    private final String a;

    public C7388Rm6(String str) {
        AbstractC13042fc3.i(str, "searchQuery");
        this.a = str;
    }

    public final C7388Rm6 a(String str) {
        AbstractC13042fc3.i(str, "searchQuery");
        return new C7388Rm6(str);
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C7388Rm6) && AbstractC13042fc3.d(this.a, ((C7388Rm6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SelectableContactsState(searchQuery=" + this.a + Separators.RPAREN;
    }

    public /* synthetic */ C7388Rm6(String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str);
    }
}
