package ir.nasim;

/* renamed from: ir.nasim.Nt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6483Nt {
    public static final C6233Mt a(float f, float f2, long j, long j2, boolean z) {
        return new C6233Mt(PQ7.d(C9361Zp2.a), Float.valueOf(f), AbstractC8385Vt.a(f2), j, j2, z);
    }

    public static final C6233Mt b(InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, Object obj2, long j, long j2, boolean z) {
        return new C6233Mt(interfaceC5342Ix7, obj, (AbstractC8151Ut) interfaceC5342Ix7.a().invoke(obj2), j, j2, z);
    }

    public static /* synthetic */ C6233Mt c(float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        long j3 = (i & 4) != 0 ? Long.MIN_VALUE : j;
        long j4 = (i & 8) == 0 ? j2 : Long.MIN_VALUE;
        if ((i & 16) != 0) {
            z = false;
        }
        return a(f, f2, j3, j4, z);
    }

    public static final C6233Mt e(C6233Mt c6233Mt, float f, float f2, long j, long j2, boolean z) {
        return new C6233Mt(c6233Mt.j(), Float.valueOf(f), AbstractC8385Vt.a(f2), j, j2, z);
    }

    public static final C6233Mt f(C6233Mt c6233Mt, Object obj, AbstractC8151Ut abstractC8151Ut, long j, long j2, boolean z) {
        return new C6233Mt(c6233Mt.j(), obj, abstractC8151Ut, j, j2, z);
    }

    public static /* synthetic */ C6233Mt g(C6233Mt c6233Mt, float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ((Number) c6233Mt.getValue()).floatValue();
        }
        if ((i & 2) != 0) {
            f2 = ((C7210Qt) c6233Mt.A()).f();
        }
        float f3 = f2;
        if ((i & 4) != 0) {
            j = c6233Mt.i();
        }
        long j3 = j;
        if ((i & 8) != 0) {
            j2 = c6233Mt.f();
        }
        long j4 = j2;
        if ((i & 16) != 0) {
            z = c6233Mt.B();
        }
        return e(c6233Mt, f, f3, j3, j4, z);
    }

    public static /* synthetic */ C6233Mt h(C6233Mt c6233Mt, Object obj, AbstractC8151Ut abstractC8151Ut, long j, long j2, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = c6233Mt.getValue();
        }
        if ((i & 2) != 0) {
            abstractC8151Ut = AbstractC8385Vt.e(c6233Mt.A());
        }
        AbstractC8151Ut abstractC8151Ut2 = abstractC8151Ut;
        if ((i & 4) != 0) {
            j = c6233Mt.i();
        }
        long j3 = j;
        if ((i & 8) != 0) {
            j2 = c6233Mt.f();
        }
        long j4 = j2;
        if ((i & 16) != 0) {
            z = c6233Mt.B();
        }
        return f(c6233Mt, obj, abstractC8151Ut2, j3, j4, z);
    }

    public static final AbstractC8151Ut i(InterfaceC5342Ix7 interfaceC5342Ix7, Object obj) {
        AbstractC8151Ut abstractC8151Ut = (AbstractC8151Ut) interfaceC5342Ix7.a().invoke(obj);
        abstractC8151Ut.d();
        return abstractC8151Ut;
    }
}
