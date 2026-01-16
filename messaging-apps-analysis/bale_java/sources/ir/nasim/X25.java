package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* loaded from: classes8.dex */
public final class X25 {
    public static final X25 a = new X25();

    private X25() {
    }

    public static final ExPeerType a(C11458d25 c11458d25) {
        C14733iO2 c14733iO2;
        if (c11458d25 == null) {
            return null;
        }
        if (c11458d25.C()) {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c11458d25.getPeerId());
            if (c21231tK7 != null) {
                return c21231tK7.n();
            }
            return null;
        }
        if (!c11458d25.z() || (c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11458d25.getPeerId())) == null) {
            return null;
        }
        return c14733iO2.p();
    }

    public static final int b() {
        if (AbstractC5969Lp4.c() != null) {
            return AbstractC5969Lp4.c().o();
        }
        return 0;
    }
}
