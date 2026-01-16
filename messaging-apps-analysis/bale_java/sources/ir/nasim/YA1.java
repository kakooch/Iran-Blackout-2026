package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
public abstract class YA1 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB;
        if (interfaceC20295rm1 instanceof TU1) {
            return interfaceC20295rm1.toString();
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(interfaceC20295rm1 + '@' + b(interfaceC20295rm1));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.e(objB) != null) {
            objB = interfaceC20295rm1.getClass().getName() + '@' + b(interfaceC20295rm1);
        }
        return (String) objB;
    }
}
