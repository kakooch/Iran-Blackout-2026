package ir.nasim;

/* renamed from: ir.nasim.hX1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14202hX1 implements InterfaceC7486Rx5, InterfaceC8898Xu3 {
    private static final Object c = new Object();
    private volatile InterfaceC7486Rx5 a;
    private volatile Object b = c;

    private C14202hX1(InterfaceC7486Rx5 interfaceC7486Rx5) {
        this.a = interfaceC7486Rx5;
    }

    public static InterfaceC8898Xu3 a(InterfaceC7486Rx5 interfaceC7486Rx5) {
        return interfaceC7486Rx5 instanceof InterfaceC8898Xu3 ? (InterfaceC8898Xu3) interfaceC7486Rx5 : new C14202hX1((InterfaceC7486Rx5) AbstractC4746Gj5.b(interfaceC7486Rx5));
    }

    public static InterfaceC7486Rx5 b(InterfaceC7486Rx5 interfaceC7486Rx5) {
        AbstractC4746Gj5.b(interfaceC7486Rx5);
        return interfaceC7486Rx5 instanceof C14202hX1 ? interfaceC7486Rx5 : new C14202hX1(interfaceC7486Rx5);
    }

    public static InterfaceC7720Sx5 c(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return b(AbstractC8193Ux5.a(interfaceC7720Sx5));
    }

    private static Object d(Object obj, Object obj2) {
        if (obj == c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    public Object get() {
        Object obj = this.b;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.b;
                    if (obj == obj2) {
                        obj = this.a.get();
                        this.b = d(this.b, obj);
                        this.a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
