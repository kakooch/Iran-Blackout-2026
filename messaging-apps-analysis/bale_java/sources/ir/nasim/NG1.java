package ir.nasim;

/* loaded from: classes3.dex */
public final class NG1 implements InterfaceC19617qf2 {
    private InterfaceC7486Rx5 a;

    public static void a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        b((NG1) interfaceC7720Sx5, AbstractC8193Ux5.a(interfaceC7720Sx52));
    }

    private static void b(NG1 ng1, InterfaceC7486Rx5 interfaceC7486Rx5) {
        AbstractC4746Gj5.b(interfaceC7486Rx5);
        if (ng1.a != null) {
            throw new IllegalStateException();
        }
        ng1.a = interfaceC7486Rx5;
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    public Object get() {
        InterfaceC7486Rx5 interfaceC7486Rx5 = this.a;
        if (interfaceC7486Rx5 != null) {
            return interfaceC7486Rx5.get();
        }
        throw new IllegalStateException();
    }
}
