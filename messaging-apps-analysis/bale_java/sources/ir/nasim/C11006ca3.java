package ir.nasim;

/* renamed from: ir.nasim.ca3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11006ca3 implements InterfaceC19617qf2, InterfaceC8898Xu3 {
    private static final C11006ca3 b = new C11006ca3(null);
    private final Object a;

    private C11006ca3(Object obj) {
        this.a = obj;
    }

    public static InterfaceC19617qf2 a(Object obj) {
        return new C11006ca3(AbstractC4746Gj5.c(obj, "instance cannot be null"));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    public Object get() {
        return this.a;
    }
}
