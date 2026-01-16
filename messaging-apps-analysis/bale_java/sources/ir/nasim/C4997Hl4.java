package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Hl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4997Hl4 {
    private final List a;
    private final EnumC4514Fl4 b;

    public C4997Hl4(List list, EnumC4514Fl4 enumC4514Fl4) {
        AbstractC13042fc3.i(list, "peersList");
        AbstractC13042fc3.i(enumC4514Fl4, "state");
        this.a = list;
        this.b = enumC4514Fl4;
    }

    public final List a() {
        return this.a;
    }

    public final EnumC4514Fl4 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4997Hl4)) {
            return false;
        }
        C4997Hl4 c4997Hl4 = (C4997Hl4) obj;
        return AbstractC13042fc3.d(this.a, c4997Hl4.a) && this.b == c4997Hl4.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MultiPeerStatus(peersList=" + this.a + ", state=" + this.b + Separators.RPAREN;
    }
}
