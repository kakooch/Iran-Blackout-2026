package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;

/* renamed from: ir.nasim.zd6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C25038zd6 {
    private final SA2 a;
    private final UA2 b;
    private final UA2 c;
    private final UA2 d;

    public C25038zd6(SA2 sa2, UA2 ua2, UA2 ua22, UA2 ua23) {
        AbstractC13042fc3.i(sa2, "closeScreen");
        AbstractC13042fc3.i(ua2, "joinOrStartPeer");
        AbstractC13042fc3.i(ua22, "openDialogPeer");
        AbstractC13042fc3.i(ua23, "onChangeTab");
        this.a = sa2;
        this.b = ua2;
        this.c = ua22;
        this.d = ua23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(OnboardingPeer onboardingPeer) {
        AbstractC13042fc3.i(onboardingPeer, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(int i) {
        return C19938rB7.a;
    }

    public final SA2 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C25038zd6)) {
            return false;
        }
        C25038zd6 c25038zd6 = (C25038zd6) obj;
        return AbstractC13042fc3.d(this.a, c25038zd6.a) && AbstractC13042fc3.d(this.b, c25038zd6.b) && AbstractC13042fc3.d(this.c, c25038zd6.c) && AbstractC13042fc3.d(this.d, c25038zd6.d);
    }

    public final UA2 f() {
        return this.b;
    }

    public final UA2 g() {
        return this.d;
    }

    public final UA2 h() {
        return this.c;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ScreenDelegate(closeScreen=" + this.a + ", joinOrStartPeer=" + this.b + ", openDialogPeer=" + this.c + ", onChangeTab=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C25038zd6(SA2 sa2, UA2 ua2, UA2 ua22, UA2 ua23, int i, ED1 ed1) {
        this(sa2, ua2, (i & 4) != 0 ? new UA2() { // from class: ir.nasim.xd6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C25038zd6.c((OnboardingPeer) obj);
            }
        } : ua22, (i & 8) != 0 ? new UA2() { // from class: ir.nasim.yd6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C25038zd6.d(((Integer) obj).intValue());
            }
        } : ua23);
    }
}
