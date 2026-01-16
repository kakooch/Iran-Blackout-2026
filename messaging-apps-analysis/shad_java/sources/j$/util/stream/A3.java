package j$.util.stream;

/* loaded from: classes2.dex */
final class A3 extends AbstractC0134d {
    private final AbstractC0128c j;
    private final j$.util.function.m k;
    private final long l;
    private final long m;
    private long n;
    private volatile boolean o;

    A3(A3 a3, j$.util.t tVar) {
        super(a3, tVar);
        this.j = a3.j;
        this.k = a3.k;
        this.l = a3.l;
        this.m = a3.m;
    }

    A3(AbstractC0128c abstractC0128c, AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar, long j, long j2) {
        super(abstractC0256y2, tVar);
        this.j = abstractC0128c;
        this.k = mVar;
        this.l = j;
        this.m = j2;
    }

    private long m(long j) {
        if (this.o) {
            return this.n;
        }
        A3 a3 = (A3) this.d;
        A3 a32 = (A3) this.e;
        if (a3 == null || a32 == null) {
            return this.n;
        }
        long jM = a3.m(j);
        return jM >= j ? jM : jM + a32.m(j);
    }

    @Override // j$.util.stream.AbstractC0146f
    protected Object a() {
        if (e()) {
            InterfaceC0225s1 interfaceC0225s1U0 = this.j.u0(EnumC0145e4.SIZED.e(this.j.c) ? this.j.r0(this.b) : -1L, this.k);
            InterfaceC0192m3 interfaceC0192m3I0 = this.j.I0(this.a.t0(), interfaceC0225s1U0);
            AbstractC0256y2 abstractC0256y2 = this.a;
            abstractC0256y2.p0(abstractC0256y2.w0(interfaceC0192m3I0), this.b);
            return interfaceC0225s1U0.b();
        }
        AbstractC0256y2 abstractC0256y22 = this.a;
        InterfaceC0225s1 interfaceC0225s1U02 = abstractC0256y22.u0(-1L, this.k);
        abstractC0256y22.v0(interfaceC0225s1U02, this.b);
        A1 a1B = interfaceC0225s1U02.b();
        this.n = a1B.count();
        this.o = true;
        this.b = null;
        return a1B;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected AbstractC0146f f(j$.util.t tVar) {
        return new A3(this, tVar);
    }

    @Override // j$.util.stream.AbstractC0134d
    protected void i() {
        this.i = true;
        if (this.o) {
            g(k());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractC0134d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final A1 k() {
        return AbstractC0251x2.k(this.j.C0());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    @Override // j$.util.stream.AbstractC0146f, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r12) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.A3.onCompletion(java.util.concurrent.CountedCompleter):void");
    }
}
