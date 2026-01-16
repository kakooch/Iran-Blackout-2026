package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC12129e53;

/* renamed from: ir.nasim.Ac0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3254Ac0 {
    private final C3727Cc0 a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final EnumC6196Mo7 f;
    private final PI0 g;
    private final Integer h;
    private final boolean i;
    private final String j;
    private final String k;
    private final AbstractC12129e53 l;
    private final boolean m;
    private final long n;

    public C3254Ac0(C3727Cc0 c3727Cc0, String str, boolean z, boolean z2, boolean z3, EnumC6196Mo7 enumC6196Mo7, PI0 pi0, Integer num, boolean z4, String str2, String str3, AbstractC12129e53 abstractC12129e53, boolean z5, long j) {
        AbstractC13042fc3.i(c3727Cc0, "userData");
        AbstractC13042fc3.i(str, "versionName");
        AbstractC13042fc3.i(enumC6196Mo7, "themeMode");
        AbstractC13042fc3.i(pi0, "changeLog");
        AbstractC13042fc3.i(str2, "baleFAQUrl");
        AbstractC13042fc3.i(str3, "baleDownloadAppUrl");
        AbstractC13042fc3.i(abstractC12129e53, "inAppUpdateState");
        this.a = c3727Cc0;
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = enumC6196Mo7;
        this.g = pi0;
        this.h = num;
        this.i = z4;
        this.j = str2;
        this.k = str3;
        this.l = abstractC12129e53;
        this.m = z5;
        this.n = j;
    }

    public final C3254Ac0 a(C3727Cc0 c3727Cc0, String str, boolean z, boolean z2, boolean z3, EnumC6196Mo7 enumC6196Mo7, PI0 pi0, Integer num, boolean z4, String str2, String str3, AbstractC12129e53 abstractC12129e53, boolean z5, long j) {
        AbstractC13042fc3.i(c3727Cc0, "userData");
        AbstractC13042fc3.i(str, "versionName");
        AbstractC13042fc3.i(enumC6196Mo7, "themeMode");
        AbstractC13042fc3.i(pi0, "changeLog");
        AbstractC13042fc3.i(str2, "baleFAQUrl");
        AbstractC13042fc3.i(str3, "baleDownloadAppUrl");
        AbstractC13042fc3.i(abstractC12129e53, "inAppUpdateState");
        return new C3254Ac0(c3727Cc0, str, z, z2, z3, enumC6196Mo7, pi0, num, z4, str2, str3, abstractC12129e53, z5, j);
    }

    public final String c() {
        return this.k;
    }

    public final String d() {
        return this.j;
    }

    public final PI0 e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3254Ac0)) {
            return false;
        }
        C3254Ac0 c3254Ac0 = (C3254Ac0) obj;
        return AbstractC13042fc3.d(this.a, c3254Ac0.a) && AbstractC13042fc3.d(this.b, c3254Ac0.b) && this.c == c3254Ac0.c && this.d == c3254Ac0.d && this.e == c3254Ac0.e && this.f == c3254Ac0.f && AbstractC13042fc3.d(this.g, c3254Ac0.g) && AbstractC13042fc3.d(this.h, c3254Ac0.h) && this.i == c3254Ac0.i && AbstractC13042fc3.d(this.j, c3254Ac0.j) && AbstractC13042fc3.d(this.k, c3254Ac0.k) && AbstractC13042fc3.d(this.l, c3254Ac0.l) && this.m == c3254Ac0.m && this.n == c3254Ac0.n;
    }

    public final AbstractC12129e53 f() {
        return this.l;
    }

    public final long g() {
        return this.n;
    }

    public final boolean h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Integer num = this.h;
        return ((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + Boolean.hashCode(this.m)) * 31) + Long.hashCode(this.n);
    }

    public final boolean i() {
        return this.i;
    }

    public final Integer j() {
        return this.h;
    }

    public final EnumC6196Mo7 k() {
        return this.f;
    }

    public final C3727Cc0 l() {
        return this.a;
    }

    public final String m() {
        return this.b;
    }

    public final boolean n() {
        return this.m;
    }

    public final boolean o() {
        return this.e;
    }

    public String toString() {
        return "BaseSettingsUiState(userData=" + this.a + ", versionName=" + this.b + ", shouldUpdateApp=" + this.c + ", isPageLoading=" + this.d + ", isThemeChanging=" + this.e + ", themeMode=" + this.f + ", changeLog=" + this.g + ", snackbarMessage=" + this.h + ", showSettingBadge=" + this.i + ", baleFAQUrl=" + this.j + ", baleDownloadAppUrl=" + this.k + ", inAppUpdateState=" + this.l + ", isPremium=" + this.m + ", premiumExpirationTimeSeconds=" + this.n + Separators.RPAREN;
    }

    public /* synthetic */ C3254Ac0(C3727Cc0 c3727Cc0, String str, boolean z, boolean z2, boolean z3, EnumC6196Mo7 enumC6196Mo7, PI0 pi0, Integer num, boolean z4, String str2, String str3, AbstractC12129e53 abstractC12129e53, boolean z5, long j, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C3727Cc0(0, null, null, null, null, null, 63, null) : c3727Cc0, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? EnumC6196Mo7.c : enumC6196Mo7, (i & 64) != 0 ? new PI0(null, null, 3, null) : pi0, (i & 128) == 0 ? num : null, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? "" : str2, (i & 1024) == 0 ? str3 : "", (i & 2048) != 0 ? AbstractC12129e53.b.b : abstractC12129e53, (i & 4096) == 0 ? z5 : false, (i & 8192) != 0 ? 0L : j);
    }
}
