package ir.nasim;

import androidx.emoji2.text.e;

/* renamed from: ir.nasim.iE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14633iE1 implements Q52 {
    private InterfaceC9664aL6 a;

    /* renamed from: ir.nasim.iE1$a */
    public static final class a extends e.f {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ C14633iE1 b;

        a(InterfaceC9102Ym4 interfaceC9102Ym4, C14633iE1 c14633iE1) {
            this.a = interfaceC9102Ym4;
            this.b = c14633iE1;
        }

        @Override // androidx.emoji2.text.e.f
        public void a(Throwable th) {
            this.b.a = R52.a;
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            this.a.setValue(Boolean.TRUE);
            this.b.a = new X33(true);
        }
    }

    public C14633iE1() {
        this.a = androidx.emoji2.text.e.k() ? c() : null;
    }

    private final InterfaceC9664aL6 c() {
        androidx.emoji2.text.e eVarC = androidx.emoji2.text.e.c();
        if (eVarC.g() == 1) {
            return new X33(true);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4D = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        eVarC.v(new a(interfaceC9102Ym4D, this));
        return interfaceC9102Ym4D;
    }

    @Override // ir.nasim.Q52
    public InterfaceC9664aL6 a() {
        InterfaceC9664aL6 interfaceC9664aL6 = this.a;
        if (interfaceC9664aL6 != null) {
            AbstractC13042fc3.f(interfaceC9664aL6);
            return interfaceC9664aL6;
        }
        if (!androidx.emoji2.text.e.k()) {
            return R52.a;
        }
        InterfaceC9664aL6 interfaceC9664aL6C = c();
        this.a = interfaceC9664aL6C;
        AbstractC13042fc3.f(interfaceC9664aL6C);
        return interfaceC9664aL6C;
    }
}
