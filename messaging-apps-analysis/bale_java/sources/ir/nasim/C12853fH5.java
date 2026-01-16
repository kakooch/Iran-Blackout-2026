package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fH5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12853fH5 {
    private final String a;
    private final boolean b;

    public C12853fH5(String str, boolean z) {
        AbstractC13042fc3.i(str, "emojiCode");
        this.a = str;
        this.b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12853fH5)) {
            return false;
        }
        C12853fH5 c12853fH5 = (C12853fH5) obj;
        return AbstractC13042fc3.d(this.a, c12853fH5.a) && this.b == c12853fH5.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "ReactionItem(emojiCode=" + this.a + ", isReacted=" + this.b + Separators.RPAREN;
    }
}
