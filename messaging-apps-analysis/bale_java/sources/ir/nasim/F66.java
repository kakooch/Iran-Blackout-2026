package ir.nasim;

/* loaded from: classes.dex */
public abstract class F66 {
    public static final AbstractC5075Hu1 a(I66 i66) {
        if (i66 != null) {
            return i66.a();
        }
        return null;
    }

    public static final boolean b(I66 i66) {
        if (i66 != null) {
            return i66.b();
        }
        return true;
    }

    public static final I66 c(InterfaceC9236Zb3 interfaceC9236Zb3) {
        Object objH = interfaceC9236Zb3.h();
        if (objH instanceof I66) {
            return (I66) objH;
        }
        return null;
    }

    public static final I66 d(AbstractC21430te5 abstractC21430te5) {
        Object objH = abstractC21430te5.h();
        if (objH instanceof I66) {
            return (I66) objH;
        }
        return null;
    }

    public static final float e(I66 i66) {
        if (i66 != null) {
            return i66.d();
        }
        return 0.0f;
    }

    public static final boolean f(I66 i66) {
        AbstractC5075Hu1 abstractC5075Hu1A = a(i66);
        if (abstractC5075Hu1A != null) {
            return abstractC5075Hu1A.c();
        }
        return false;
    }
}
