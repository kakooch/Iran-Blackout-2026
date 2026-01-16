package ir.nasim;

/* renamed from: ir.nasim.iX1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14813iX1 implements InterfaceC7720Sx5 {
    private static final Object c = new Object();
    private volatile InterfaceC7720Sx5 a;
    private volatile Object b = c;

    private C14813iX1(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static InterfaceC7720Sx5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC3561Bj5.b(interfaceC7720Sx5);
        return interfaceC7720Sx5 instanceof C14813iX1 ? interfaceC7720Sx5 : new C14813iX1(interfaceC7720Sx5);
    }

    public static Object b(Object obj, Object obj2) {
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
                        this.b = b(this.b, obj);
                        this.a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
