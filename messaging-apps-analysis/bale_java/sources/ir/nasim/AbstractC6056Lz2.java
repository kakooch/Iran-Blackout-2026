package ir.nasim;

import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.Lz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6056Lz2 {
    public static final InterfaceC10358bW7 a(UA2 ua2, UA2 ua22, boolean z) {
        AbstractC13042fc3.i(ua2, "onViewDestroyed");
        AbstractC13042fc3.i(ua22, "viewBinder");
        return new C17085mN1(z, ua22, ua2);
    }

    public static /* synthetic */ InterfaceC10358bW7 b(UA2 ua2, UA2 ua22, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return a(ua2, ua22, z);
    }

    public static final InterfaceC10358bW7 c(UA2 ua2, UA2 ua22, boolean z) {
        AbstractC13042fc3.i(ua2, "onViewDestroyed");
        AbstractC13042fc3.i(ua22, "viewBinder");
        return new C5823Kz2(z, ua22, ua2);
    }

    public static /* synthetic */ InterfaceC10358bW7 d(UA2 ua2, UA2 ua22, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return c(ua2, ua22, z);
    }

    public static final InterfaceC10358bW7 e(Fragment fragment, UA2 ua2) {
        AbstractC13042fc3.i(fragment, "<this>");
        AbstractC13042fc3.i(ua2, "viewBinder");
        return f(fragment, ua2, AbstractC20046rN7.c());
    }

    public static final InterfaceC10358bW7 f(Fragment fragment, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(fragment, "<this>");
        AbstractC13042fc3.i(ua2, "viewBinder");
        AbstractC13042fc3.i(ua22, "onViewDestroyed");
        return fragment instanceof androidx.fragment.app.l ? b(ua22, ua2, false, 4, null) : d(ua22, ua2, false, 4, null);
    }
}
