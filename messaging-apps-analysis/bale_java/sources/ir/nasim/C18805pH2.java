package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.pH2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18805pH2 {
    private final List a;
    private boolean b;
    private Integer c;
    private EM2 d;

    public C18805pH2(List list, boolean z, Integer num, EM2 em2) {
        AbstractC13042fc3.i(list, "data");
        AbstractC13042fc3.i(em2, "gifPermission");
        this.a = list;
        this.b = z;
        this.c = num;
        this.d = em2;
    }

    public final List a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final EM2 c() {
        return this.d;
    }

    public final Integer d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18805pH2)) {
            return false;
        }
        C18805pH2 c18805pH2 = (C18805pH2) obj;
        return AbstractC13042fc3.d(this.a, c18805pH2.a) && this.b == c18805pH2.b && AbstractC13042fc3.d(this.c, c18805pH2.c) && this.d == c18805pH2.d;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31;
        Integer num = this.c;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "GifFragmentUiState(data=" + this.a + ", emptyState=" + this.b + ", snackBarMessage=" + this.c + ", gifPermission=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C18805pH2(List list, boolean z, Integer num, EM2 em2, int i, ED1 ed1) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : num, (i & 8) != 0 ? EM2.a : em2);
    }
}
