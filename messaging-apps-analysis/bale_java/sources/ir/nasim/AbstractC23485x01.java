package ir.nasim;

/* renamed from: ir.nasim.x01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23485x01 {
    public static final InterfaceC22299v01 a(InterfaceC13730gj3 interfaceC13730gj3) {
        return new C22895w01(interfaceC13730gj3);
    }

    public static final InterfaceC22299v01 b(Object obj) {
        C22895w01 c22895w01 = new C22895w01(null);
        c22895w01.U(obj);
        return c22895w01;
    }

    public static /* synthetic */ InterfaceC22299v01 c(InterfaceC13730gj3 interfaceC13730gj3, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC13730gj3 = null;
        }
        return a(interfaceC13730gj3);
    }

    public static final boolean d(InterfaceC22299v01 interfaceC22299v01, Object obj) {
        Throwable thE = C9475a16.e(obj);
        return thE == null ? interfaceC22299v01.U(obj) : interfaceC22299v01.e(thE);
    }
}
