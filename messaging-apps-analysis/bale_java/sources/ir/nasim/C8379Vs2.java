package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC17858ng6;
import java.util.List;

/* renamed from: ir.nasim.Vs2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8379Vs2 {
    private final AbstractC17858ng6 a;
    private final List b;
    private final List c;
    private final boolean d;

    public C8379Vs2(AbstractC17858ng6 abstractC17858ng6, List list, List list2, boolean z) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchBarState");
        AbstractC13042fc3.i(list, "existingDialogs");
        AbstractC13042fc3.i(list2, "changedDialogs");
        this.a = abstractC17858ng6;
        this.b = list;
        this.c = list2;
        this.d = z;
    }

    public static /* synthetic */ C8379Vs2 b(C8379Vs2 c8379Vs2, AbstractC17858ng6 abstractC17858ng6, List list, List list2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC17858ng6 = c8379Vs2.a;
        }
        if ((i & 2) != 0) {
            list = c8379Vs2.b;
        }
        if ((i & 4) != 0) {
            list2 = c8379Vs2.c;
        }
        if ((i & 8) != 0) {
            z = c8379Vs2.d;
        }
        return c8379Vs2.a(abstractC17858ng6, list, list2, z);
    }

    public final C8379Vs2 a(AbstractC17858ng6 abstractC17858ng6, List list, List list2, boolean z) {
        AbstractC13042fc3.i(abstractC17858ng6, "searchBarState");
        AbstractC13042fc3.i(list, "existingDialogs");
        AbstractC13042fc3.i(list2, "changedDialogs");
        return new C8379Vs2(abstractC17858ng6, list, list2, z);
    }

    public final List c() {
        return this.c;
    }

    public final List d() {
        return this.b;
    }

    public final AbstractC17858ng6 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8379Vs2)) {
            return false;
        }
        C8379Vs2 c8379Vs2 = (C8379Vs2) obj;
        return AbstractC13042fc3.d(this.a, c8379Vs2.a) && AbstractC13042fc3.d(this.b, c8379Vs2.b) && AbstractC13042fc3.d(this.c, c8379Vs2.c) && this.d == c8379Vs2.d;
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "FolderUiState(searchBarState=" + this.a + ", existingDialogs=" + this.b + ", changedDialogs=" + this.c + ", isFolderSaving=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C8379Vs2(AbstractC17858ng6 abstractC17858ng6, List list, List list2, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC17858ng6.b.b : abstractC17858ng6, (i & 2) != 0 ? AbstractC10360bX0.m() : list, (i & 4) != 0 ? AbstractC10360bX0.m() : list2, (i & 8) != 0 ? false : z);
    }
}
