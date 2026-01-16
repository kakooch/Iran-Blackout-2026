package ir.nasim;

/* renamed from: ir.nasim.Yv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9182Yv3 {
    private final C3784Ci3 a;
    private final InterfaceC25246zy7 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final C8524Wi3 e;

    public C9182Yv3(C3784Ci3 c3784Ci3, InterfaceC25246zy7 interfaceC25246zy7, InterfaceC9173Yu3 interfaceC9173Yu3) {
        AbstractC13042fc3.i(c3784Ci3, "components");
        AbstractC13042fc3.i(interfaceC25246zy7, "typeParameterResolver");
        AbstractC13042fc3.i(interfaceC9173Yu3, "delegateForDefaultTypeQualifiers");
        this.a = c3784Ci3;
        this.b = interfaceC25246zy7;
        this.c = interfaceC9173Yu3;
        this.d = interfaceC9173Yu3;
        this.e = new C8524Wi3(this, interfaceC25246zy7);
    }

    public final C3784Ci3 a() {
        return this.a;
    }

    public final C8290Vi3 b() {
        return (C8290Vi3) this.d.getValue();
    }

    public final InterfaceC9173Yu3 c() {
        return this.c;
    }

    public final InterfaceC8507Wg4 d() {
        return this.a.l();
    }

    public final ON6 e() {
        return this.a.t();
    }

    public final InterfaceC25246zy7 f() {
        return this.b;
    }

    public final C8524Wi3 g() {
        return this.e;
    }
}
