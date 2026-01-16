package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC24274yL1;
import ir.nasim.InterfaceC20625sK4;

/* loaded from: classes5.dex */
public final class JO1 {
    private final AbstractC24274yL1 a;
    private final InterfaceC20625sK4 b;

    public JO1(AbstractC24274yL1 abstractC24274yL1, InterfaceC20625sK4 interfaceC20625sK4) {
        AbstractC13042fc3.i(abstractC24274yL1, "dialogAdUiState");
        AbstractC13042fc3.i(interfaceC20625sK4, "onboardingBannerUiState");
        this.a = abstractC24274yL1;
        this.b = interfaceC20625sK4;
    }

    public final AbstractC24274yL1 a() {
        return this.a;
    }

    public final InterfaceC20625sK4 b() {
        return this.b;
    }

    public final boolean c(EnumC11273cj7 enumC11273cj7) {
        AbstractC13042fc3.i(enumC11273cj7, "tab");
        AbstractC24274yL1 abstractC24274yL1 = this.a;
        return ((abstractC24274yL1 instanceof AbstractC24274yL1.b ? (AbstractC24274yL1.b) abstractC24274yL1 : null) == null || g(enumC11273cj7) || enumC11273cj7 == EnumC11273cj7.a) ? false : true;
    }

    public final boolean d(EnumC11273cj7 enumC11273cj7) {
        AbstractC13042fc3.i(enumC11273cj7, "tab");
        return c(enumC11273cj7) && (this.a instanceof AbstractC24274yL1.b.a);
    }

    public final boolean e(EnumC11273cj7 enumC11273cj7) {
        AbstractC13042fc3.i(enumC11273cj7, "tab");
        return c(enumC11273cj7) && (this.a instanceof AbstractC24274yL1.b.C1786b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JO1)) {
            return false;
        }
        JO1 jo1 = (JO1) obj;
        return AbstractC13042fc3.d(this.a, jo1.a) && AbstractC13042fc3.d(this.b, jo1.b);
    }

    public final void f(EnumC11273cj7 enumC11273cj7, UA2 ua2) {
        AbstractC13042fc3.i(enumC11273cj7, "tab");
        AbstractC13042fc3.i(ua2, "onEnabled");
        InterfaceC20625sK4 interfaceC20625sK4 = this.b;
        if ((interfaceC20625sK4 instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) interfaceC20625sK4 : null) != null) {
            if (((InterfaceC20625sK4.b) interfaceC20625sK4).e() == 5 ? AbstractC4363Eu6.c(EnumC11273cj7.b).contains(enumC11273cj7) : AbstractC4597Fu6.i(EnumC11273cj7.b, EnumC11273cj7.d).contains(enumC11273cj7)) {
                ua2.invoke(this.b);
            }
        }
    }

    public final boolean g(EnumC11273cj7 enumC11273cj7) {
        AbstractC13042fc3.i(enumC11273cj7, "tab");
        InterfaceC20625sK4 interfaceC20625sK4 = this.b;
        if ((interfaceC20625sK4 instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) interfaceC20625sK4 : null) != null) {
            return ((InterfaceC20625sK4.b) interfaceC20625sK4).e() == 5 ? AbstractC4363Eu6.c(EnumC11273cj7.b).contains(enumC11273cj7) : AbstractC4597Fu6.i(EnumC11273cj7.b, EnumC11273cj7.d).contains(enumC11273cj7);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DialogListTopSpotUiState(dialogAdUiState=" + this.a + ", onboardingBannerUiState=" + this.b + Separators.RPAREN;
    }
}
