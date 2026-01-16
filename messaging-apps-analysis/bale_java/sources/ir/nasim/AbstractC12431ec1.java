package ir.nasim;

import ir.nasim.X45;

/* renamed from: ir.nasim.ec1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12431ec1 {
    public static final boolean a(Y45 y45, AbstractC8979Yb1 abstractC8979Yb1) {
        AbstractC13042fc3.g(abstractC8979Yb1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return y45.containsKey(abstractC8979Yb1);
    }

    public static final Object b(Y45 y45, AbstractC8979Yb1 abstractC8979Yb1) {
        AbstractC13042fc3.g(abstractC8979Yb1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Object objA = y45.get(abstractC8979Yb1);
        if (objA == null) {
            objA = abstractC8979Yb1.a();
        }
        return ((InterfaceC18300oQ7) objA).a(y45);
    }

    public static final Y45 c(C7252Qx5[] c7252Qx5Arr, Y45 y45, Y45 y452) {
        X45.a aVarU = Z45.a().m();
        for (C7252Qx5 c7252Qx5 : c7252Qx5Arr) {
            AbstractC8979Yb1 abstractC8979Yb1B = c7252Qx5.b();
            AbstractC13042fc3.g(abstractC8979Yb1B, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
            AbstractC6535Nx5 abstractC6535Nx5 = (AbstractC6535Nx5) abstractC8979Yb1B;
            if (c7252Qx5.a() || !a(y45, abstractC6535Nx5)) {
                InterfaceC18300oQ7 interfaceC18300oQ7 = (InterfaceC18300oQ7) y452.get(abstractC6535Nx5);
                AbstractC13042fc3.g(c7252Qx5, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
                aVarU.put(abstractC6535Nx5, abstractC6535Nx5.b(c7252Qx5, interfaceC18300oQ7));
            }
        }
        return aVarU.f();
    }

    public static /* synthetic */ Y45 d(C7252Qx5[] c7252Qx5Arr, Y45 y45, Y45 y452, int i, Object obj) {
        if ((i & 4) != 0) {
            y452 = Z45.a();
        }
        return c(c7252Qx5Arr, y45, y452);
    }
}
