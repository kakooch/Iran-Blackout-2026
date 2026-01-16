package ir.nasim;

/* renamed from: ir.nasim.gp7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C13794gp7 {
    public final InterfaceC11938do1 a;
    private final Object[] b;
    private final InterfaceC6695Oo7[] c;
    private int d;

    public C13794gp7(InterfaceC11938do1 interfaceC11938do1, int i) {
        this.a = interfaceC11938do1;
        this.b = new Object[i];
        this.c = new InterfaceC6695Oo7[i];
    }

    public final void a(InterfaceC6695Oo7 interfaceC6695Oo7, Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        InterfaceC6695Oo7[] interfaceC6695Oo7Arr = this.c;
        this.d = i + 1;
        AbstractC13042fc3.g(interfaceC6695Oo7, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        interfaceC6695Oo7Arr[i] = interfaceC6695Oo7;
    }

    public final void b(InterfaceC11938do1 interfaceC11938do1) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            InterfaceC6695Oo7 interfaceC6695Oo7 = this.c[length];
            AbstractC13042fc3.f(interfaceC6695Oo7);
            interfaceC6695Oo7.d0(interfaceC11938do1, this.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
