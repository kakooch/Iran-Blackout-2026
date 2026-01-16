package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public final class R68 {
    public static final int y = C22132uj0.c;
    private final String a;
    private final String b;
    private final boolean c;
    private final EnumC23552x68 d;
    private final boolean e;
    private final C9517a58 f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final Integer j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final AbstractC20942sr7 n;
    private final AbstractC10213bG6 o;
    private final boolean p;
    private final Y48 q;
    private final boolean r;
    private final int s;
    private final boolean t;
    private final boolean u;
    private final C22132uj0 v;
    private final AbstractC13801gq4 w;
    private final boolean x;

    public R68(String str, String str2, boolean z, EnumC23552x68 enumC23552x68, boolean z2, C9517a58 c9517a58, boolean z3, boolean z4, boolean z5, Integer num, boolean z6, boolean z7, boolean z8, AbstractC20942sr7 abstractC20942sr7, AbstractC10213bG6 abstractC10213bG6, boolean z9, Y48 y48, boolean z10, int i, boolean z11, boolean z12, C22132uj0 c22132uj0, AbstractC13801gq4 abstractC13801gq4, boolean z13) {
        AbstractC13042fc3.i(str, "webAppUrl");
        AbstractC13042fc3.i(str2, "botName");
        AbstractC13042fc3.i(enumC23552x68, "screenMode");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = enumC23552x68;
        this.e = z2;
        this.f = c9517a58;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = num;
        this.k = z6;
        this.l = z7;
        this.m = z8;
        this.n = abstractC20942sr7;
        this.o = abstractC10213bG6;
        this.p = z9;
        this.q = y48;
        this.r = z10;
        this.s = i;
        this.t = z11;
        this.u = z12;
        this.v = c22132uj0;
        this.w = abstractC13801gq4;
        this.x = z13;
    }

    public final R68 a(String str, String str2, boolean z, EnumC23552x68 enumC23552x68, boolean z2, C9517a58 c9517a58, boolean z3, boolean z4, boolean z5, Integer num, boolean z6, boolean z7, boolean z8, AbstractC20942sr7 abstractC20942sr7, AbstractC10213bG6 abstractC10213bG6, boolean z9, Y48 y48, boolean z10, int i, boolean z11, boolean z12, C22132uj0 c22132uj0, AbstractC13801gq4 abstractC13801gq4, boolean z13) {
        AbstractC13042fc3.i(str, "webAppUrl");
        AbstractC13042fc3.i(str2, "botName");
        AbstractC13042fc3.i(enumC23552x68, "screenMode");
        return new R68(str, str2, z, enumC23552x68, z2, c9517a58, z3, z4, z5, num, z6, z7, z8, abstractC20942sr7, abstractC10213bG6, z9, y48, z10, i, z11, z12, c22132uj0, abstractC13801gq4, z13);
    }

    public final String c() {
        return this.b;
    }

    public final C22132uj0 d() {
        return this.v;
    }

    public final boolean e() {
        return this.u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof R68)) {
            return false;
        }
        R68 r68 = (R68) obj;
        return AbstractC13042fc3.d(this.a, r68.a) && AbstractC13042fc3.d(this.b, r68.b) && this.c == r68.c && this.d == r68.d && this.e == r68.e && AbstractC13042fc3.d(this.f, r68.f) && this.g == r68.g && this.h == r68.h && this.i == r68.i && AbstractC13042fc3.d(this.j, r68.j) && this.k == r68.k && this.l == r68.l && this.m == r68.m && AbstractC13042fc3.d(this.n, r68.n) && AbstractC13042fc3.d(this.o, r68.o) && this.p == r68.p && AbstractC13042fc3.d(this.q, r68.q) && this.r == r68.r && this.s == r68.s && this.t == r68.t && this.u == r68.u && AbstractC13042fc3.d(this.v, r68.v) && AbstractC13042fc3.d(this.w, r68.w) && this.x == r68.x;
    }

    public final boolean f() {
        return this.k;
    }

    public final boolean g() {
        return this.l;
    }

    public final AbstractC13801gq4 h() {
        return this.w;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31;
        C9517a58 c9517a58 = this.f;
        int iHashCode2 = (((((((iHashCode + (c9517a58 == null ? 0 : c9517a58.hashCode())) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31;
        Integer num = this.j;
        int iHashCode3 = (((((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.k)) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31;
        AbstractC20942sr7 abstractC20942sr7 = this.n;
        int iHashCode4 = (iHashCode3 + (abstractC20942sr7 == null ? 0 : abstractC20942sr7.hashCode())) * 31;
        AbstractC10213bG6 abstractC10213bG6 = this.o;
        int iHashCode5 = (((iHashCode4 + (abstractC10213bG6 == null ? 0 : abstractC10213bG6.hashCode())) * 31) + Boolean.hashCode(this.p)) * 31;
        Y48 y48 = this.q;
        int iHashCode6 = (((((((((iHashCode5 + (y48 == null ? 0 : y48.hashCode())) * 31) + Boolean.hashCode(this.r)) * 31) + Integer.hashCode(this.s)) * 31) + Boolean.hashCode(this.t)) * 31) + Boolean.hashCode(this.u)) * 31;
        C22132uj0 c22132uj0 = this.v;
        int iHashCode7 = (iHashCode6 + (c22132uj0 == null ? 0 : c22132uj0.hashCode())) * 31;
        AbstractC13801gq4 abstractC13801gq4 = this.w;
        return ((iHashCode7 + (abstractC13801gq4 != null ? abstractC13801gq4.hashCode() : 0)) * 31) + Boolean.hashCode(this.x);
    }

    public final boolean i() {
        return this.m;
    }

    public final EnumC23552x68 j() {
        return this.d;
    }

    public final boolean k() {
        return this.i;
    }

    public final boolean l() {
        return this.g;
    }

    public final boolean m() {
        return this.h;
    }

    public final AbstractC10213bG6 n() {
        return this.o;
    }

    public final AbstractC20942sr7 o() {
        return this.n;
    }

    public final Integer p() {
        return this.j;
    }

    public final Y48 q() {
        return this.q;
    }

    public final C9517a58 r() {
        return this.f;
    }

    public final String s() {
        return this.a;
    }

    public final boolean t() {
        return this.p;
    }

    public String toString() {
        return "WebAppUiState(webAppUrl=" + this.a + ", botName=" + this.b + ", isShowBottomSheet=" + this.c + ", screenMode=" + this.d + ", isWebAppLoaded=" + this.e + ", webAppErrorState=" + this.f + ", showBackButton=" + this.g + ", showSettingButton=" + this.h + ", showAddToHomeScreenButton=" + this.i + ", toolbarColor=" + this.j + ", closedBottomSheet=" + this.k + ", minimizeWebApp=" + this.l + ", needToConfirmForClose=" + this.m + ", toastState=" + this.n + ", snackBarState=" + this.o + ", webViewDebuggingEnabled=" + this.p + ", webAppDialogState=" + this.q + ", bottomSheetIsDraggable=" + this.r + ", webViewProgressPercentage=" + this.s + ", isMinimizeEnabled=" + this.t + ", closeFragment=" + this.u + ", botReviewData=" + this.v + ", navigateState=" + this.w + ", isShowLoading=" + this.x + Separators.RPAREN;
    }

    public final int u() {
        return this.s;
    }

    public final boolean v() {
        return this.t;
    }

    public final boolean w() {
        return this.c;
    }

    public final boolean x() {
        return this.x;
    }

    public final boolean y() {
        return this.e;
    }

    public /* synthetic */ R68(String str, String str2, boolean z, EnumC23552x68 enumC23552x68, boolean z2, C9517a58 c9517a58, boolean z3, boolean z4, boolean z5, Integer num, boolean z6, boolean z7, boolean z8, AbstractC20942sr7 abstractC20942sr7, AbstractC10213bG6 abstractC10213bG6, boolean z9, Y48 y48, boolean z10, int i, boolean z11, boolean z12, C22132uj0 c22132uj0, AbstractC13801gq4 abstractC13801gq4, boolean z13, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? EnumC23552x68.c : enumC23552x68, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : c9517a58, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? false : z4, (i2 & 256) != 0 ? false : z5, (i2 & 512) != 0 ? null : num, (i2 & 1024) != 0 ? false : z6, (i2 & 2048) != 0 ? false : z7, (i2 & 4096) != 0 ? false : z8, (i2 & 8192) != 0 ? null : abstractC20942sr7, (i2 & 16384) != 0 ? null : abstractC10213bG6, (i2 & 32768) != 0 ? false : z9, (i2 & 65536) != 0 ? null : y48, (i2 & 131072) != 0 ? true : z10, (i2 & 262144) != 0 ? 0 : i, (i2 & 524288) != 0 ? false : z11, (i2 & 1048576) != 0 ? false : z12, (i2 & 2097152) != 0 ? null : c22132uj0, (i2 & 4194304) != 0 ? null : abstractC13801gq4, (i2 & 8388608) == 0 ? z13 : true);
    }
}
