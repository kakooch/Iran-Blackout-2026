package ir.nasim;

import ir.nasim.AbstractC5914Lj3;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.PeerData;

/* renamed from: ir.nasim.e17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12093e17 implements InterfaceC8121Up5 {
    private final InterfaceC23384wp6 a;

    public C12093e17() {
        AbstractC5914Lj3.c cVar = AbstractC5914Lj3.c.a;
        this.a = AbstractC9962aq6.k(AbstractC10360bX0.p(new P07(cVar, new OnboardingPeer.EmptyStateSuggestedPeer(new PeerData(12, null, "کالابرگ", null, true, Boolean.TRUE), "مشاهده موجودی کالابرگ", "شروع")), new P07(cVar, new OnboardingPeer.EmptyStateSuggestedPeer(new PeerData(12, null, "نسخه پزشکی", null, true, Boolean.FALSE), "نسخه بگیر!", "شروع"))));
    }

    @Override // ir.nasim.InterfaceC8121Up5
    public InterfaceC23384wp6 a() {
        return this.a;
    }
}
