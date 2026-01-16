package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fF, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12829fF {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;

    public C12829fF(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24) {
        AbstractC13042fc3.i(sa2, "navigateToMultiTab");
        AbstractC13042fc3.i(sa22, "navigateToFont");
        AbstractC13042fc3.i(sa23, "navigateToWallPaper");
        AbstractC13042fc3.i(sa24, "navigateToAppBar");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
        this.d = sa24;
    }

    public final SA2 a() {
        return this.d;
    }

    public final SA2 b() {
        return this.b;
    }

    public final SA2 c() {
        return this.a;
    }

    public final SA2 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12829fF)) {
            return false;
        }
        C12829fF c12829fF = (C12829fF) obj;
        return AbstractC13042fc3.d(this.a, c12829fF.a) && AbstractC13042fc3.d(this.b, c12829fF.b) && AbstractC13042fc3.d(this.c, c12829fF.c) && AbstractC13042fc3.d(this.d, c12829fF.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AppearanceNavigationCallbacks(navigateToMultiTab=" + this.a + ", navigateToFont=" + this.b + ", navigateToWallPaper=" + this.c + ", navigateToAppBar=" + this.d + Separators.RPAREN;
    }
}
