package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.eK6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12272eK6 implements InterfaceC10465bf2 {
    private final long a;
    private final InterfaceC10465bf2 b;

    /* renamed from: ir.nasim.eK6$a */
    class a implements InterfaceC22148uk6 {
        final /* synthetic */ InterfaceC22148uk6 a;

        a(InterfaceC22148uk6 interfaceC22148uk6) {
            this.a = interfaceC22148uk6;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public InterfaceC22148uk6.a c(long j) {
            InterfaceC22148uk6.a aVarC = this.a.c(j);
            C23334wk6 c23334wk6 = aVarC.a;
            C23334wk6 c23334wk62 = new C23334wk6(c23334wk6.a, c23334wk6.b + C12272eK6.this.a);
            C23334wk6 c23334wk63 = aVarC.b;
            return new InterfaceC22148uk6.a(c23334wk62, new C23334wk6(c23334wk63.a, c23334wk63.b + C12272eK6.this.a));
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public boolean g() {
            return this.a.g();
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public long i() {
            return this.a.i();
        }
    }

    public C12272eK6(long j, InterfaceC10465bf2 interfaceC10465bf2) {
        this.a = j;
        this.b = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public InterfaceC4589Ft7 b(int i, int i2) {
        return this.b.b(i, i2);
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void o(InterfaceC22148uk6 interfaceC22148uk6) {
        this.b.o(new a(interfaceC22148uk6));
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void s() {
        this.b.s();
    }
}
