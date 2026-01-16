package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dE6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C11575dE6 {
    private final LF5 a;
    private final C10847cI6 b;

    public C11575dE6(LF5 lf5, C10847cI6 c10847cI6) {
        AbstractC13042fc3.i(lf5, "radii");
        AbstractC13042fc3.i(c10847cI6, "spacings");
        this.a = lf5;
        this.b = c10847cI6;
    }

    public final LF5 a() {
        return this.a;
    }

    public final C10847cI6 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11575dE6)) {
            return false;
        }
        C11575dE6 c11575dE6 = (C11575dE6) obj;
        return AbstractC13042fc3.d(this.a, c11575dE6.a) && AbstractC13042fc3.d(this.b, c11575dE6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Sizes(radii=" + this.a + ", spacings=" + this.b + Separators.RPAREN;
    }
}
