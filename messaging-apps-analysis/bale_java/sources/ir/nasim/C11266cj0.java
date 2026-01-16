package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cj0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11266cj0 extends AbstractC24047xx1 {
    private final String f;
    private final C5668Ki0 g;

    public C11266cj0(String str, C5668Ki0 c5668Ki0) {
        AbstractC13042fc3.i(str, "botName");
        AbstractC13042fc3.i(c5668Ki0, "data");
        this.f = str;
        this.g = c5668Ki0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11266cj0)) {
            return false;
        }
        C11266cj0 c11266cj0 = (C11266cj0) obj;
        return AbstractC13042fc3.d(this.f, c11266cj0.f) && AbstractC13042fc3.d(this.g, c11266cj0.g);
    }

    public int hashCode() {
        return (this.f.hashCode() * 31) + this.g.hashCode();
    }

    public final String m() {
        return this.f;
    }

    public final C5668Ki0 n() {
        return this.g;
    }

    @Override // ir.nasim.TA4
    public String toString() {
        return "BotNode(botName=" + this.f + ", data=" + this.g + Separators.RPAREN;
    }
}
