package ir.nasim;

/* renamed from: ir.nasim.pD6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18773pD6 implements InterfaceC7486Rx5 {
    private static final Object c = new Object();
    private volatile InterfaceC7486Rx5 a;
    private volatile Object b = c;

    private C18773pD6(InterfaceC7486Rx5 interfaceC7486Rx5) {
        this.a = interfaceC7486Rx5;
    }

    public static InterfaceC7486Rx5 a(InterfaceC7486Rx5 interfaceC7486Rx5) {
        return ((interfaceC7486Rx5 instanceof C18773pD6) || (interfaceC7486Rx5 instanceof C14202hX1)) ? interfaceC7486Rx5 : new C18773pD6((InterfaceC7486Rx5) AbstractC4746Gj5.b(interfaceC7486Rx5));
    }

    public static InterfaceC7720Sx5 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return a(AbstractC8193Ux5.a(interfaceC7720Sx5));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    public Object get() {
        Object obj = this.b;
        if (obj != c) {
            return obj;
        }
        InterfaceC7486Rx5 interfaceC7486Rx5 = this.a;
        if (interfaceC7486Rx5 == null) {
            return this.b;
        }
        Object obj2 = interfaceC7486Rx5.get();
        this.b = obj2;
        this.a = null;
        return obj2;
    }
}
