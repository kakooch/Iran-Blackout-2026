package ir.nasim;

import ir.nasim.C4081Dp3;

/* renamed from: ir.nasim.Lt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5999Lt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC8151Ut b(InterfaceC5342Ix7 interfaceC5342Ix7, Object obj) {
        if (obj == null) {
            return null;
        }
        return (AbstractC8151Ut) interfaceC5342Ix7.a().invoke(obj);
    }

    public static final InterfaceC5766Kt c(InterfaceC5766Kt interfaceC5766Kt, long j) {
        return new YJ6(interfaceC5766Kt, j);
    }

    public static final C20494s63 d(R12 r12, EO5 eo5, long j) {
        return new C20494s63(r12, eo5, j, null);
    }

    public static /* synthetic */ C20494s63 e(R12 r12, EO5 eo5, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            eo5 = EO5.a;
        }
        if ((i & 4) != 0) {
            j = AbstractC10865cK6.c(0, 0, 2, null);
        }
        return d(r12, eo5, j);
    }

    public static final C4081Dp3 f(UA2 ua2) {
        C4081Dp3.b bVar = new C4081Dp3.b();
        ua2.invoke(bVar);
        return new C4081Dp3(bVar);
    }

    public static final GO5 g(int i, R12 r12, EO5 eo5, long j) {
        return new GO5(i, r12, eo5, j, null);
    }

    public static /* synthetic */ GO5 h(int i, R12 r12, EO5 eo5, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            eo5 = EO5.a;
        }
        if ((i2 & 8) != 0) {
            j = AbstractC10865cK6.c(0, 0, 2, null);
        }
        return g(i, r12, eo5, j);
    }

    public static final C18827pJ6 i(float f, float f2, Object obj) {
        return new C18827pJ6(f, f2, obj);
    }

    public static /* synthetic */ C18827pJ6 j(float f, float f2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1500.0f;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return i(f, f2, obj);
    }

    public static final C7479Rw7 k(int i, int i2, K22 k22) {
        return new C7479Rw7(i, i2, k22);
    }

    public static /* synthetic */ C7479Rw7 l(int i, int i2, K22 k22, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 300;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            k22 = T22.d();
        }
        return k(i, i2, k22);
    }
}
