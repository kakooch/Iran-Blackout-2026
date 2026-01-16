package ir.nasim;

import android.graphics.Typeface;

/* renamed from: ir.nasim.kz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16273kz7 {
    private final InterfaceC9664aL6 a;
    private final C16273kz7 b;
    private final Object c;

    public C16273kz7(InterfaceC9664aL6 interfaceC9664aL6, C16273kz7 c16273kz7) {
        this.a = interfaceC9664aL6;
        this.b = c16273kz7;
        this.c = interfaceC9664aL6.getValue();
    }

    public final Typeface a() {
        Object obj = this.c;
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    public final boolean b() {
        C16273kz7 c16273kz7;
        return this.a.getValue() != this.c || ((c16273kz7 = this.b) != null && c16273kz7.b());
    }
}
