package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
public abstract class XU1 {
    public static final void a(WU1 wu1, int i) {
        InterfaceC20295rm1 interfaceC20295rm1C = wu1.c();
        boolean z = i == 4;
        if (z || !(interfaceC20295rm1C instanceof TU1) || b(i) != b(wu1.c)) {
            d(wu1, interfaceC20295rm1C, z);
            return;
        }
        AbstractC13778go1 abstractC13778go1 = ((TU1) interfaceC20295rm1C).d;
        InterfaceC11938do1 context = interfaceC20295rm1C.getContext();
        if (abstractC13778go1.A0(context)) {
            abstractC13778go1.x0(context, wu1);
        } else {
            e(wu1);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final void d(WU1 wu1, InterfaceC20295rm1 interfaceC20295rm1, boolean z) {
        Object objF;
        Object objH = wu1.h();
        Throwable thE = wu1.e(objH);
        if (thE != null) {
            C9475a16.a aVar = C9475a16.b;
            objF = AbstractC10685c16.a(thE);
        } else {
            C9475a16.a aVar2 = C9475a16.b;
            objF = wu1.f(objH);
        }
        Object objB = C9475a16.b(objF);
        if (!z) {
            interfaceC20295rm1.resumeWith(objB);
            return;
        }
        AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        TU1 tu1 = (TU1) interfaceC20295rm1;
        InterfaceC20295rm1 interfaceC20295rm12 = tu1.e;
        Object obj = tu1.g;
        InterfaceC11938do1 context = interfaceC20295rm12.getContext();
        Object objC = AbstractC7173Qo7.c(context, obj);
        C12801fB7 c12801fB7G = objC != AbstractC7173Qo7.a ? AbstractC12551eo1.g(interfaceC20295rm12, context, objC) : null;
        try {
            tu1.e.resumeWith(objB);
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            if (c12801fB7G == null || c12801fB7G.h1()) {
                AbstractC7173Qo7.a(context, objC);
            }
        }
    }

    private static final void e(WU1 wu1) {
        AbstractC8717Xa2 abstractC8717Xa2B = C8582Wo7.a.b();
        if (abstractC8717Xa2B.Q0()) {
            abstractC8717Xa2B.I0(wu1);
            return;
        }
        abstractC8717Xa2B.L0(true);
        try {
            d(wu1, wu1.c(), true);
            do {
            } while (abstractC8717Xa2B.W0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
