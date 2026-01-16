package ir.nasim;

/* renamed from: ir.nasim.da3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11770da3 implements InterfaceC20817sf2 {
    private static final C11770da3 b = new C11770da3(null);
    private final Object a;

    private C11770da3(Object obj) {
        this.a = obj;
    }

    public static InterfaceC20817sf2 a(Object obj) {
        return new C11770da3(AbstractC3561Bj5.c(obj, "instance cannot be null"));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    public Object get() {
        return this.a;
    }
}
