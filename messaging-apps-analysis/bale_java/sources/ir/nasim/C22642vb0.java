package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.vb0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22642vb0 {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;
    private final SA2 e;
    private final SA2 f;
    private final SA2 g;
    private final SA2 h;
    private final SA2 i;
    private final UA2 j;
    private final UA2 k;
    private final UA2 l;

    public C22642vb0(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, SA2 sa27, SA2 sa28, SA2 sa29, UA2 ua2, UA2 ua22, UA2 ua23) {
        AbstractC13042fc3.i(sa2, "navigateToAccount");
        AbstractC13042fc3.i(sa22, "navigateToSettings");
        AbstractC13042fc3.i(sa23, "navigateToSavedMessage");
        AbstractC13042fc3.i(sa24, "navigateToGuideChannel");
        AbstractC13042fc3.i(sa25, "navigateToCreateGroup");
        AbstractC13042fc3.i(sa26, "navigateToCreateChannel");
        AbstractC13042fc3.i(sa27, "navigateToSupport");
        AbstractC13042fc3.i(sa28, "navigateToPremium");
        AbstractC13042fc3.i(sa29, "addAccountCallback");
        AbstractC13042fc3.i(ua2, "switchAccount");
        AbstractC13042fc3.i(ua22, "onShowFragment");
        AbstractC13042fc3.i(ua23, "handleInAppUpdateUiAction");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
        this.d = sa24;
        this.e = sa25;
        this.f = sa26;
        this.g = sa27;
        this.h = sa28;
        this.i = sa29;
        this.j = ua2;
        this.k = ua22;
        this.l = ua23;
    }

    public final SA2 a() {
        return this.i;
    }

    public final UA2 b() {
        return this.l;
    }

    public final SA2 c() {
        return this.a;
    }

    public final SA2 d() {
        return this.f;
    }

    public final SA2 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22642vb0)) {
            return false;
        }
        C22642vb0 c22642vb0 = (C22642vb0) obj;
        return AbstractC13042fc3.d(this.a, c22642vb0.a) && AbstractC13042fc3.d(this.b, c22642vb0.b) && AbstractC13042fc3.d(this.c, c22642vb0.c) && AbstractC13042fc3.d(this.d, c22642vb0.d) && AbstractC13042fc3.d(this.e, c22642vb0.e) && AbstractC13042fc3.d(this.f, c22642vb0.f) && AbstractC13042fc3.d(this.g, c22642vb0.g) && AbstractC13042fc3.d(this.h, c22642vb0.h) && AbstractC13042fc3.d(this.i, c22642vb0.i) && AbstractC13042fc3.d(this.j, c22642vb0.j) && AbstractC13042fc3.d(this.k, c22642vb0.k) && AbstractC13042fc3.d(this.l, c22642vb0.l);
    }

    public final SA2 f() {
        return this.d;
    }

    public final SA2 g() {
        return this.h;
    }

    public final SA2 h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    }

    public final SA2 i() {
        return this.b;
    }

    public final SA2 j() {
        return this.g;
    }

    public final UA2 k() {
        return this.j;
    }

    public String toString() {
        return "BaseSettingsNavigationCallbacks(navigateToAccount=" + this.a + ", navigateToSettings=" + this.b + ", navigateToSavedMessage=" + this.c + ", navigateToGuideChannel=" + this.d + ", navigateToCreateGroup=" + this.e + ", navigateToCreateChannel=" + this.f + ", navigateToSupport=" + this.g + ", navigateToPremium=" + this.h + ", addAccountCallback=" + this.i + ", switchAccount=" + this.j + ", onShowFragment=" + this.k + ", handleInAppUpdateUiAction=" + this.l + Separators.RPAREN;
    }
}
