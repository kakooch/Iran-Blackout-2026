package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Kd3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5626Kd3 {
    private final String a;
    private final AbstractC22884vz0 b;
    private final boolean c;
    private final boolean d;

    public C5626Kd3(String str, AbstractC22884vz0 abstractC22884vz0, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, "searchQuery");
        this.a = str;
        this.b = abstractC22884vz0;
        this.c = z;
        this.d = z2;
    }

    public static /* synthetic */ C5626Kd3 b(C5626Kd3 c5626Kd3, String str, AbstractC22884vz0 abstractC22884vz0, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c5626Kd3.a;
        }
        if ((i & 2) != 0) {
            abstractC22884vz0 = c5626Kd3.b;
        }
        if ((i & 4) != 0) {
            z = c5626Kd3.c;
        }
        if ((i & 8) != 0) {
            z2 = c5626Kd3.d;
        }
        return c5626Kd3.a(str, abstractC22884vz0, z, z2);
    }

    public final C5626Kd3 a(String str, AbstractC22884vz0 abstractC22884vz0, boolean z, boolean z2) {
        AbstractC13042fc3.i(str, "searchQuery");
        return new C5626Kd3(str, abstractC22884vz0, z, z2);
    }

    public final AbstractC22884vz0 c() {
        return this.b;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5626Kd3)) {
            return false;
        }
        C5626Kd3 c5626Kd3 = (C5626Kd3) obj;
        return AbstractC13042fc3.d(this.a, c5626Kd3.a) && AbstractC13042fc3.d(this.b, c5626Kd3.b) && this.c == c5626Kd3.c && this.d == c5626Kd3.d;
    }

    public final boolean f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        AbstractC22884vz0 abstractC22884vz0 = this.b;
        return ((((iHashCode + (abstractC22884vz0 == null ? 0 : abstractC22884vz0.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "InviteBottomSheetState(searchQuery=" + this.a + ", callToast=" + this.b + ", isInviteBottomAvailable=" + this.c + ", needToCloseBottomSheet=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C5626Kd3(String str, AbstractC22884vz0 abstractC22884vz0, boolean z, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : abstractC22884vz0, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }
}
