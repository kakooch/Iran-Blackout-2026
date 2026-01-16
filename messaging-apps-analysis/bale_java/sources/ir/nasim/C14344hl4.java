package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.hl4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14344hl4 {
    private final List a;
    private final SA2 b;
    private final UA2 c;

    public C14344hl4(List list, SA2 sa2, UA2 ua2) {
        AbstractC13042fc3.i(list, "items");
        AbstractC13042fc3.i(sa2, "addAccountCallback");
        AbstractC13042fc3.i(ua2, "switchAccount");
        this.a = list;
        this.b = sa2;
        this.c = ua2;
    }

    public final SA2 a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public final UA2 c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14344hl4)) {
            return false;
        }
        C14344hl4 c14344hl4 = (C14344hl4) obj;
        return AbstractC13042fc3.d(this.a, c14344hl4.a) && AbstractC13042fc3.d(this.b, c14344hl4.b) && AbstractC13042fc3.d(this.c, c14344hl4.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MultiAccountBottomSheetState(items=" + this.a + ", addAccountCallback=" + this.b + ", switchAccount=" + this.c + Separators.RPAREN;
    }
}
