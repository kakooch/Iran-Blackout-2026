package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.lj6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16706lj6 {
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
    private final SA2 k;
    private final UA2 l;
    private final SA2 m;

    public C16706lj6(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, SA2 sa27, SA2 sa28, SA2 sa29, SA2 sa210, SA2 sa211, UA2 ua2, SA2 sa212) {
        AbstractC13042fc3.i(sa2, "navigateToInviteToGroup");
        AbstractC13042fc3.i(sa22, "navigateToLastSeen");
        AbstractC13042fc3.i(sa23, "navigateToCardToCard");
        AbstractC13042fc3.i(sa24, "navigateToCall");
        AbstractC13042fc3.i(sa25, "navigateToStory");
        AbstractC13042fc3.i(sa26, "navigateToTwoFA");
        AbstractC13042fc3.i(sa27, "navigateToAppLock");
        AbstractC13042fc3.i(sa28, "navigateToActiveSessions");
        AbstractC13042fc3.i(sa29, "navigateToBlockUsers");
        AbstractC13042fc3.i(sa210, "navigateToDeleteAccount");
        AbstractC13042fc3.i(sa211, "onMXPCheckedChange");
        AbstractC13042fc3.i(ua2, "onSyncContactCheckedChange");
        AbstractC13042fc3.i(sa212, "navigateToPassword");
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
        this.k = sa211;
        this.l = ua2;
        this.m = sa212;
    }

    public final SA2 a() {
        return this.h;
    }

    public final SA2 b() {
        return this.g;
    }

    public final SA2 c() {
        return this.i;
    }

    public final SA2 d() {
        return this.d;
    }

    public final SA2 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16706lj6)) {
            return false;
        }
        C16706lj6 c16706lj6 = (C16706lj6) obj;
        return AbstractC13042fc3.d(this.a, c16706lj6.a) && AbstractC13042fc3.d(this.b, c16706lj6.b) && AbstractC13042fc3.d(this.c, c16706lj6.c) && AbstractC13042fc3.d(this.d, c16706lj6.d) && AbstractC13042fc3.d(this.e, c16706lj6.e) && AbstractC13042fc3.d(this.f, c16706lj6.f) && AbstractC13042fc3.d(this.g, c16706lj6.g) && AbstractC13042fc3.d(this.h, c16706lj6.h) && AbstractC13042fc3.d(this.i, c16706lj6.i) && AbstractC13042fc3.d(this.j, c16706lj6.j) && AbstractC13042fc3.d(this.k, c16706lj6.k) && AbstractC13042fc3.d(this.l, c16706lj6.l) && AbstractC13042fc3.d(this.m, c16706lj6.m);
    }

    public final SA2 f() {
        return this.j;
    }

    public final SA2 g() {
        return this.a;
    }

    public final SA2 h() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
    }

    public final SA2 i() {
        return this.m;
    }

    public final SA2 j() {
        return this.e;
    }

    public final SA2 k() {
        return this.f;
    }

    public final SA2 l() {
        return this.k;
    }

    public final UA2 m() {
        return this.l;
    }

    public String toString() {
        return "SecurityNavigationCallbacks(navigateToInviteToGroup=" + this.a + ", navigateToLastSeen=" + this.b + ", navigateToCardToCard=" + this.c + ", navigateToCall=" + this.d + ", navigateToStory=" + this.e + ", navigateToTwoFA=" + this.f + ", navigateToAppLock=" + this.g + ", navigateToActiveSessions=" + this.h + ", navigateToBlockUsers=" + this.i + ", navigateToDeleteAccount=" + this.j + ", onMXPCheckedChange=" + this.k + ", onSyncContactCheckedChange=" + this.l + ", navigateToPassword=" + this.m + Separators.RPAREN;
    }
}
