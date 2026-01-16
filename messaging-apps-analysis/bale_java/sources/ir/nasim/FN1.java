package ir.nasim;

/* loaded from: classes7.dex */
public abstract class FN1 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(new SA2() { // from class: ir.nasim.EN1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return FN1.b();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final A03 b() {
        throw new IllegalStateException("IconLoader not provided".toString());
    }

    public static final AbstractC6535Nx5 c() {
        return a;
    }

    public static final C12700f33 d(EnumC23487x03 enumC23487x03, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        AbstractC13042fc3.i(enumC23487x03, "<this>");
        interfaceC22053ub1.W(1171321245);
        C12700f33 c12700f33A = ((A03) interfaceC22053ub1.H(a)).a(enumC23487x03, interfaceC22053ub1, i & 14);
        interfaceC22053ub1.Q();
        return c12700f33A;
    }
}
