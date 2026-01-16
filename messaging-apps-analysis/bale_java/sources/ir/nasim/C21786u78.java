package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.u78, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21786u78 {
    private final InterfaceC9336Zm4 a;
    private final InterfaceC10258bL6 b;

    public C21786u78() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C19900r78(null, null, 3, null));
        this.a = interfaceC9336Zm4A;
        this.b = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    public final InterfaceC10258bL6 a() {
        return this.b;
    }

    public final void b(List list) {
        Object value;
        AbstractC13042fc3.i(list, "inBoundTracks");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C19900r78.b((C19900r78) value, null, list, 1, null)));
    }

    public final void c(List list) {
        Object value;
        AbstractC13042fc3.i(list, "outBoundTracks");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C19900r78.b((C19900r78) value, list, null, 2, null)));
    }
}
