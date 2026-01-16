package ir.nasim;

/* renamed from: ir.nasim.Jq2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC5508Jq2 {
    public static final C9927an4 a(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return new C9927an4(AbstractC12281eL6.a(obj), interfaceC14603iB2);
    }

    public static final C10874cL6 b(InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(interfaceC10258bL6, "stateFlow");
        return new C10874cL6(interfaceC10258bL6);
    }

    public static /* synthetic */ C9927an4 c(Object obj, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC14603iB2 = null;
        }
        return a(obj, interfaceC14603iB2);
    }

    public static final Object d(InterfaceC3820Cm3 interfaceC3820Cm3) {
        AbstractC13042fc3.i(interfaceC3820Cm3, "<this>");
        try {
            MG1 mg1 = MG1.a;
            mg1.b().set(Boolean.TRUE);
            interfaceC3820Cm3.get();
            Object obj = mg1.a().get();
            mg1.a().set(null);
            mg1.b().set(Boolean.FALSE);
            return obj;
        } catch (Throwable th) {
            MG1 mg12 = MG1.a;
            mg12.a().set(null);
            mg12.b().set(Boolean.FALSE);
            throw th;
        }
    }

    public static final InterfaceC10258bL6 e(InterfaceC3820Cm3 interfaceC3820Cm3) {
        AbstractC13042fc3.i(interfaceC3820Cm3, "<this>");
        Object objD = d(interfaceC3820Cm3);
        AbstractC13042fc3.g(objD, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of io.livekit.android.util.FlowDelegateKt.<get-flow>>");
        return (InterfaceC10258bL6) objD;
    }
}
