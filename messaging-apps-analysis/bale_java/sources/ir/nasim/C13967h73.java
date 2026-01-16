package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.h73, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13967h73 {
    private final boolean a;
    private final String b;
    private final String c;
    private final V75 d;

    public C13967h73(boolean z, String str, String str2, V75 v75) {
        AbstractC13042fc3.i(str2, "searchQuery");
        AbstractC13042fc3.i(v75, "phoneData");
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = v75;
    }

    public static /* synthetic */ C13967h73 b(C13967h73 c13967h73, boolean z, String str, String str2, V75 v75, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c13967h73.a;
        }
        if ((i & 2) != 0) {
            str = c13967h73.b;
        }
        if ((i & 4) != 0) {
            str2 = c13967h73.c;
        }
        if ((i & 8) != 0) {
            v75 = c13967h73.d;
        }
        return c13967h73.a(z, str, str2, v75);
    }

    public final C13967h73 a(boolean z, String str, String str2, V75 v75) {
        AbstractC13042fc3.i(str2, "searchQuery");
        AbstractC13042fc3.i(v75, "phoneData");
        return new C13967h73(z, str, str2, v75);
    }

    public final String c() {
        return this.b;
    }

    public final V75 d() {
        return this.d;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13967h73)) {
            return false;
        }
        C13967h73 c13967h73 = (C13967h73) obj;
        return this.a == c13967h73.a && AbstractC13042fc3.d(this.b, c13967h73.b) && AbstractC13042fc3.d(this.c, c13967h73.c) && AbstractC13042fc3.d(this.d, c13967h73.d);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        String str = this.b;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "InitPhoneNumberModel(isLoading=" + this.a + ", error=" + this.b + ", searchQuery=" + this.c + ", phoneData=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C13967h73(boolean z, String str, String str2, V75 v75, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? new V75(null, null, null, null, 15, null) : v75);
    }
}
