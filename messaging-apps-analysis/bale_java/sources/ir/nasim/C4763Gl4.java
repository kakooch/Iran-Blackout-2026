package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Gl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4763Gl4 {
    private final List a;
    private final EnumC4280El4 b;

    public C4763Gl4(List list, EnumC4280El4 enumC4280El4) {
        AbstractC13042fc3.i(list, "peersList");
        AbstractC13042fc3.i(enumC4280El4, "state");
        this.a = list;
        this.b = enumC4280El4;
    }

    public final List a() {
        return this.a;
    }

    public final EnumC4280El4 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4763Gl4)) {
            return false;
        }
        C4763Gl4 c4763Gl4 = (C4763Gl4) obj;
        return AbstractC13042fc3.d(this.a, c4763Gl4.a) && this.b == c4763Gl4.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MultiPeerStatus(peersList=" + this.a + ", state=" + this.b + Separators.RPAREN;
    }
}
