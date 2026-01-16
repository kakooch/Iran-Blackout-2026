package ir.nasim;

/* renamed from: ir.nasim.rt, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20363rt implements InterfaceC7041Qa1 {
    private final C20954st a;
    private String b;

    public C20363rt(C20954st c20954st) {
        this.a = c20954st;
        this.b = ((Boolean) b().a().h()).booleanValue() ? C24007xt.b.b() : C24007xt.b.a();
    }

    private final XV4 e(String str) {
        Boolean bool;
        Boolean bool2;
        if (C24007xt.f(str, C24007xt.b.a())) {
            bool = Boolean.FALSE;
            bool2 = Boolean.TRUE;
        } else {
            bool = Boolean.TRUE;
            bool2 = Boolean.FALSE;
        }
        return AbstractC4616Fw7.a(bool, bool2);
    }

    @Override // ir.nasim.InterfaceC7041Qa1
    public long a() {
        C21669tv7 c21669tv7B = b().b();
        if (c21669tv7B != null) {
            return AbstractC24892zN7.b(c21669tv7B.p());
        }
        return 0L;
    }

    public C20954st b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public void d(long j) {
        C21669tv7 c21669tv7A = b().a();
        XV4 xv4E = e(c());
        Boolean bool = (Boolean) xv4E.a();
        bool.booleanValue();
        Boolean bool2 = (Boolean) xv4E.b();
        bool2.booleanValue();
        c21669tv7A.E(bool, bool2, j);
    }
}
