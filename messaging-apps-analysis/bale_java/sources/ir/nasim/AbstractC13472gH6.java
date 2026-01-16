package ir.nasim;

import java.util.Collection;

/* renamed from: ir.nasim.gH6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract /* synthetic */ class AbstractC13472gH6 {
    public static final C14063hH6 a() {
        return new C14063hH6();
    }

    public static final C14063hH6 b(Object... objArr) {
        C14063hH6 c14063hH6 = new C14063hH6();
        c14063hH6.addAll(AbstractC10242bK.f1(objArr));
        return c14063hH6;
    }

    public static final InterfaceC9102Ym4 c(Object obj, ZG6 zg6) {
        return androidx.compose.runtime.h.a(obj, zg6);
    }

    public static /* synthetic */ InterfaceC9102Ym4 d(Object obj, ZG6 zg6, int i, Object obj2) {
        if ((i & 2) != 0) {
            zg6 = AbstractC10222bH6.s();
        }
        return AbstractC10222bH6.h(obj, zg6);
    }

    public static final InterfaceC9664aL6 e(Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1058319986, i, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:329)");
        }
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = d(obj, null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        interfaceC9102Ym4.setValue(obj);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9102Ym4;
    }

    public static final C14063hH6 f(Collection collection) {
        C14063hH6 c14063hH6 = new C14063hH6();
        c14063hH6.addAll(collection);
        return c14063hH6;
    }
}
