package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;

/* loaded from: classes6.dex */
public final class Q07 {
    public static final int c = OnboardingPeer.SuggestedPeer.d;
    private final AbstractC5914Lj3 a;
    private final OnboardingPeer.SuggestedPeer b;

    public Q07(AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.SuggestedPeer suggestedPeer) {
        AbstractC13042fc3.i(abstractC5914Lj3, "joinStatus");
        AbstractC13042fc3.i(suggestedPeer, "suggestedPeer");
        this.a = abstractC5914Lj3;
        this.b = suggestedPeer;
    }

    public static /* synthetic */ Q07 b(Q07 q07, AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.SuggestedPeer suggestedPeer, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC5914Lj3 = q07.a;
        }
        if ((i & 2) != 0) {
            suggestedPeer = q07.b;
        }
        return q07.a(abstractC5914Lj3, suggestedPeer);
    }

    public final Q07 a(AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.SuggestedPeer suggestedPeer) {
        AbstractC13042fc3.i(abstractC5914Lj3, "joinStatus");
        AbstractC13042fc3.i(suggestedPeer, "suggestedPeer");
        return new Q07(abstractC5914Lj3, suggestedPeer);
    }

    public final AbstractC5914Lj3 c() {
        return this.a;
    }

    public final OnboardingPeer.SuggestedPeer d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q07)) {
            return false;
        }
        Q07 q07 = (Q07) obj;
        return AbstractC13042fc3.d(this.a, q07.a) && AbstractC13042fc3.d(this.b, q07.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SuggestedPeerItemUiState(joinStatus=" + this.a + ", suggestedPeer=" + this.b + Separators.RPAREN;
    }
}
