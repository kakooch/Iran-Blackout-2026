package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.a44, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9503a44 extends AbstractC24047xx1 {
    private String f;
    private final X34 g;

    public C9503a44(String str, X34 x34) {
        AbstractC13042fc3.i(str, "username");
        AbstractC13042fc3.i(x34, "data");
        this.f = str;
        this.g = x34;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9503a44)) {
            return false;
        }
        C9503a44 c9503a44 = (C9503a44) obj;
        return AbstractC13042fc3.d(this.f, c9503a44.f) && AbstractC13042fc3.d(this.g, c9503a44.g);
    }

    public int hashCode() {
        return (this.f.hashCode() * 31) + this.g.hashCode();
    }

    public final X34 m() {
        return this.g;
    }

    public final String n() {
        return this.f;
    }

    @Override // ir.nasim.TA4
    public String toString() {
        return "MentionNode(username=" + this.f + ", data=" + this.g + Separators.RPAREN;
    }
}
