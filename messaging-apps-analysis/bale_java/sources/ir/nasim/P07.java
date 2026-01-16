package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;

/* loaded from: classes6.dex */
public final class P07 {
    public static final int c = OnboardingPeer.EmptyStateSuggestedPeer.d;
    private final AbstractC5914Lj3 a;
    private final OnboardingPeer.EmptyStateSuggestedPeer b;

    public P07(AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
        AbstractC13042fc3.i(abstractC5914Lj3, "joinStatus");
        AbstractC13042fc3.i(emptyStateSuggestedPeer, "suggestedPeer");
        this.a = abstractC5914Lj3;
        this.b = emptyStateSuggestedPeer;
    }

    public static /* synthetic */ P07 b(P07 p07, AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC5914Lj3 = p07.a;
        }
        if ((i & 2) != 0) {
            emptyStateSuggestedPeer = p07.b;
        }
        return p07.a(abstractC5914Lj3, emptyStateSuggestedPeer);
    }

    public final P07 a(AbstractC5914Lj3 abstractC5914Lj3, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
        AbstractC13042fc3.i(abstractC5914Lj3, "joinStatus");
        AbstractC13042fc3.i(emptyStateSuggestedPeer, "suggestedPeer");
        return new P07(abstractC5914Lj3, emptyStateSuggestedPeer);
    }

    public final AbstractC5914Lj3 c() {
        return this.a;
    }

    public final OnboardingPeer.EmptyStateSuggestedPeer d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P07)) {
            return false;
        }
        P07 p07 = (P07) obj;
        return AbstractC13042fc3.d(this.a, p07.a) && AbstractC13042fc3.d(this.b, p07.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SuggestedPeerEmptyStateItemUiState(joinStatus=" + this.a + ", suggestedPeer=" + this.b + Separators.RPAREN;
    }
}
