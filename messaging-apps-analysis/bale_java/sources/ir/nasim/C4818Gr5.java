package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Gr5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4818Gr5 {
    private boolean a;
    private final C3512Be1 b;

    public C4818Gr5(boolean z, C3512Be1 c3512Be1) {
        AbstractC13042fc3.i(c3512Be1, "contact");
        this.a = z;
        this.b = c3512Be1;
    }

    public final C3512Be1 a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4818Gr5)) {
            return false;
        }
        C4818Gr5 c4818Gr5 = (C4818Gr5) obj;
        return this.a == c4818Gr5.a && AbstractC13042fc3.d(this.b, c4818Gr5.b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PrivacyContactItem(selected=" + this.a + ", contact=" + this.b + Separators.RPAREN;
    }
}
