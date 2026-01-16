package ir.nasim;

import ir.nasim.AbstractC20029rM;
import ir.nasim.JA7;
import java.util.Iterator;

/* renamed from: ir.nasim.wM, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23101wM implements InterfaceC8121Up5 {
    private final KA7 b(boolean z, boolean z2, boolean z3, float f, EnumC21241tM enumC21241tM) {
        String str = z3 ? (String) e().next() : (String) d().next();
        return new KA7(enumC21241tM, z ? new JA7.b(str, f) : new JA7.a(str, f), z2 ? AbstractC20029rM.b.c : AbstractC20029rM.a.c);
    }

    static /* synthetic */ KA7 c(C23101wM c23101wM, boolean z, boolean z2, boolean z3, float f, EnumC21241tM enumC21241tM, int i, Object obj) {
        boolean z4 = (i & 2) != 0 ? true : z2;
        boolean z5 = (i & 4) != 0 ? true : z3;
        if ((i & 8) != 0) {
            f = 0.5f;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            enumC21241tM = EnumC21241tM.e;
        }
        return c23101wM.b(z, z4, z5, f2, enumC21241tM);
    }

    private final Iterator d() {
        return new C12878fK3(200).a().iterator();
    }

    private final Iterator e() {
        return new C12878fK3(30).a().iterator();
    }

    @Override // ir.nasim.InterfaceC8121Up5
    public InterfaceC23384wp6 a() {
        KA7 ka7C = c(this, false, false, false, 0.0f, null, 30, null);
        KA7 ka7C2 = c(this, false, false, false, 0.0f, null, 28, null);
        KA7 ka7C3 = c(this, false, false, false, 0.0f, null, 26, null);
        EnumC21241tM enumC21241tM = EnumC21241tM.g;
        return AbstractC9962aq6.k(ka7C, ka7C2, ka7C3, c(this, false, false, false, 0.0f, enumC21241tM, 14, null), c(this, true, false, false, 0.0f, null, 30, null), c(this, true, false, false, 0.0f, null, 28, null), c(this, true, false, false, 0.0f, null, 26, null), c(this, true, false, false, 0.0f, enumC21241tM, 14, null));
    }
}
