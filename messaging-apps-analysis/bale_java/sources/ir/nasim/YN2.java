package ir.nasim;

import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes5.dex */
public final class YN2 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12913fO2 a(C14697iL2 c14697iL2) {
        AbstractC13042fc3.i(c14697iL2, "input");
        int iP0 = c14697iL2.p0();
        E25 e25X0 = c14697iL2.x0();
        if (e25X0 == null) {
            e25X0 = E25.INFORMAL;
        }
        E25 e25 = e25X0;
        String strG0 = c14697iL2.G0();
        AbstractC13042fc3.h(strG0, "getTitle(...)");
        int iT0 = c14697iL2.t0();
        Avatar avatarH0 = c14697iL2.h0();
        if (avatarH0 == null) {
            avatarH0 = new Avatar();
        }
        return new C12913fO2(iP0, e25, strG0, iT0, avatarH0, c14697iL2.H0());
    }
}
