package ir.nasim;

/* renamed from: ir.nasim.eL6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12281eL6 {
    private static final C14539i47 a = new C14539i47("NONE");
    private static final C14539i47 b = new C14539i47("PENDING");

    public static final InterfaceC9336Zm4 a(Object obj) {
        if (obj == null) {
            obj = AbstractC12225eF4.a;
        }
        return new C11638dL6(obj);
    }

    public static final InterfaceC4557Fq2 d(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return (((i < 0 || i >= 2) && i != -2) || enumC6162Ml0 != EnumC6162Ml0.DROP_OLDEST) ? AbstractC11420cy6.e(interfaceC10258bL6, interfaceC11938do1, i, enumC6162Ml0) : interfaceC10258bL6;
    }
}
