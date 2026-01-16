package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public final class GE {
    private final boolean a;
    private final ZR3 b;
    private final boolean c;

    public GE(boolean z, ZR3 zr3, boolean z2) {
        this.a = z;
        this.b = zr3;
        this.c = z2;
    }

    public static /* synthetic */ GE b(GE ge, boolean z, ZR3 zr3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ge.a;
        }
        if ((i & 2) != 0) {
            zr3 = ge.b;
        }
        if ((i & 4) != 0) {
            z2 = ge.c;
        }
        return ge.a(z, zr3, z2);
    }

    public final GE a(boolean z, ZR3 zr3, boolean z2) {
        return new GE(z, zr3, z2);
    }

    public final boolean c() {
        return this.c;
    }

    public final ZR3 d() {
        return this.b;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GE)) {
            return false;
        }
        GE ge = (GE) obj;
        return this.a == ge.a && this.b == ge.b && this.c == ge.c;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        ZR3 zr3 = this.b;
        return ((iHashCode + (zr3 == null ? 0 : zr3.hashCode())) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "AppRatingUiState(showBottomSheet=" + this.a + ", openMarketPlaceState=" + this.b + ", closePage=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ GE(boolean z, ZR3 zr3, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : zr3, (i & 4) != 0 ? false : z2);
    }
}
