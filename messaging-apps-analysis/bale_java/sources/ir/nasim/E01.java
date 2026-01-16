package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
public abstract class E01 {
    public static final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!(obj instanceof B01)) {
            return C9475a16.b(obj);
        }
        C9475a16.a aVar = C9475a16.b;
        return C9475a16.b(AbstractC10685c16.a(((B01) obj).a));
    }

    public static final Object b(Object obj, HE0 he0) {
        Throwable thE = C9475a16.e(obj);
        if (thE == null) {
            return obj;
        }
        return new B01(thE, false, 2, null);
    }

    public static final Object c(Object obj, UA2 ua2) {
        Throwable thE = C9475a16.e(obj);
        if (thE == null) {
            return ua2 != null ? new C01(obj, ua2) : obj;
        }
        return new B01(thE, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, UA2 ua2, int i, Object obj2) {
        if ((i & 1) != 0) {
            ua2 = null;
        }
        return c(obj, ua2);
    }
}
