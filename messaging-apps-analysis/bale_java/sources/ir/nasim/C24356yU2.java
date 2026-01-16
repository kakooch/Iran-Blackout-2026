package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yU2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24356yU2 extends AbstractC24047xx1 {
    private final String f;

    public C24356yU2(String str) {
        AbstractC13042fc3.i(str, "url");
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24356yU2) && AbstractC13042fc3.d(this.f, ((C24356yU2) obj).f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public final String m() {
        return this.f;
    }

    @Override // ir.nasim.TA4
    public String toString() {
        return "HashTagNode(url=" + this.f + Separators.RPAREN;
    }
}
