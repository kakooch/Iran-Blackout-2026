package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.LP;

/* renamed from: ir.nasim.i73, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14565i73 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final String d;
    private final boolean e;
    private final LP f;
    private final String g;
    private final long h;
    private final String i;
    private final W75 j;

    public C14565i73(boolean z, boolean z2, boolean z3, String str, boolean z4, LP lp, String str2, long j, String str3, W75 w75) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str2, "searchQuery");
        AbstractC13042fc3.i(str3, "transactionHash");
        AbstractC13042fc3.i(w75, "phoneData");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = str;
        this.e = z4;
        this.f = lp;
        this.g = str2;
        this.h = j;
        this.i = str3;
        this.j = w75;
    }

    public final C14565i73 a(boolean z, boolean z2, boolean z3, String str, boolean z4, LP lp, String str2, long j, String str3, W75 w75) {
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(str2, "searchQuery");
        AbstractC13042fc3.i(str3, "transactionHash");
        AbstractC13042fc3.i(w75, "phoneData");
        return new C14565i73(z, z2, z3, str, z4, lp, str2, j, str3, w75);
    }

    public final LP c() {
        return this.f;
    }

    public final long d() {
        return this.h;
    }

    public final W75 e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14565i73)) {
            return false;
        }
        C14565i73 c14565i73 = (C14565i73) obj;
        return this.a == c14565i73.a && this.b == c14565i73.b && this.c == c14565i73.c && AbstractC13042fc3.d(this.d, c14565i73.d) && this.e == c14565i73.e && AbstractC13042fc3.d(this.f, c14565i73.f) && AbstractC13042fc3.d(this.g, c14565i73.g) && this.h == c14565i73.h && AbstractC13042fc3.d(this.i, c14565i73.i) && AbstractC13042fc3.d(this.j, c14565i73.j);
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.i;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31;
        String str = this.d;
        return ((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public final boolean i() {
        return this.a;
    }

    public final boolean j() {
        return this.e;
    }

    public final boolean k() {
        return this.c;
    }

    public String toString() {
        return "InitPhoneNumberModel(isFinish=" + this.a + ", isAutoLoginEnable=" + this.b + ", isTwoFANeeded=" + this.c + ", twoFAPasswordError=" + this.d + ", isLoading=" + this.e + ", error=" + this.f + ", searchQuery=" + this.g + ", fullPhoneNumber=" + this.h + ", transactionHash=" + this.i + ", phoneData=" + this.j + Separators.RPAREN;
    }

    public /* synthetic */ C14565i73(boolean z, boolean z2, boolean z3, String str, boolean z4, LP lp, String str2, long j, String str3, W75 w75, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? null : str, (i & 16) == 0 ? z4 : false, (i & 32) != 0 ? LP.c.b : lp, (i & 64) != 0 ? "" : str2, (i & 128) != 0 ? 0L : j, (i & 256) == 0 ? str3 : "", (i & 512) != 0 ? new W75(null, null, null, null, 15, null) : w75);
    }
}
