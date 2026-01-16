package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nw6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C18018nw6 {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;
    private final SA2 e;
    private final SA2 f;
    private final SA2 g;
    private final SA2 h;
    private final SA2 i;
    private final SA2 j;
    private final UA2 k;
    private final SA2 l;

    public C18018nw6(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, SA2 sa27, SA2 sa28, SA2 sa29, SA2 sa210, UA2 ua2, SA2 sa211) {
        AbstractC13042fc3.i(sa2, "navigateToNotification");
        AbstractC13042fc3.i(sa22, "navigateToAutoDownload");
        AbstractC13042fc3.i(sa23, "navigateToAppearance");
        AbstractC13042fc3.i(sa24, "navigateToMemoryUsage");
        AbstractC13042fc3.i(sa25, "navigateToFolders");
        AbstractC13042fc3.i(sa26, "navigateToChatSetting");
        AbstractC13042fc3.i(sa27, "navigateToDefaultTab");
        AbstractC13042fc3.i(sa28, "navigateToLanguage");
        AbstractC13042fc3.i(sa29, "navigateToPrivacyAndSecurity");
        AbstractC13042fc3.i(sa210, "navigateToBlockUsers");
        AbstractC13042fc3.i(ua2, "onShowFragment");
        AbstractC13042fc3.i(sa211, "enableLogSending");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
        this.d = sa24;
        this.e = sa25;
        this.f = sa26;
        this.g = sa27;
        this.h = sa28;
        this.i = sa29;
        this.j = sa210;
        this.k = ua2;
        this.l = sa211;
    }

    public final SA2 a() {
        return this.l;
    }

    public final SA2 b() {
        return this.c;
    }

    public final SA2 c() {
        return this.b;
    }

    public final SA2 d() {
        return this.j;
    }

    public final SA2 e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18018nw6)) {
            return false;
        }
        C18018nw6 c18018nw6 = (C18018nw6) obj;
        return AbstractC13042fc3.d(this.a, c18018nw6.a) && AbstractC13042fc3.d(this.b, c18018nw6.b) && AbstractC13042fc3.d(this.c, c18018nw6.c) && AbstractC13042fc3.d(this.d, c18018nw6.d) && AbstractC13042fc3.d(this.e, c18018nw6.e) && AbstractC13042fc3.d(this.f, c18018nw6.f) && AbstractC13042fc3.d(this.g, c18018nw6.g) && AbstractC13042fc3.d(this.h, c18018nw6.h) && AbstractC13042fc3.d(this.i, c18018nw6.i) && AbstractC13042fc3.d(this.j, c18018nw6.j) && AbstractC13042fc3.d(this.k, c18018nw6.k) && AbstractC13042fc3.d(this.l, c18018nw6.l);
    }

    public final SA2 f() {
        return this.g;
    }

    public final SA2 g() {
        return this.e;
    }

    public final SA2 h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    }

    public final SA2 i() {
        return this.d;
    }

    public final SA2 j() {
        return this.a;
    }

    public final SA2 k() {
        return this.i;
    }

    public final UA2 l() {
        return this.k;
    }

    public String toString() {
        return "SettingsNavigationCallbacks(navigateToNotification=" + this.a + ", navigateToAutoDownload=" + this.b + ", navigateToAppearance=" + this.c + ", navigateToMemoryUsage=" + this.d + ", navigateToFolders=" + this.e + ", navigateToChatSetting=" + this.f + ", navigateToDefaultTab=" + this.g + ", navigateToLanguage=" + this.h + ", navigateToPrivacyAndSecurity=" + this.i + ", navigateToBlockUsers=" + this.j + ", onShowFragment=" + this.k + ", enableLogSending=" + this.l + Separators.RPAREN;
    }
}
