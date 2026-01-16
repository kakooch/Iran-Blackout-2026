package j$.util.stream;

/* renamed from: j$.util.stream.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0128c extends AbstractC0256y2 implements InterfaceC0152g {
    private final AbstractC0128c a;
    private final AbstractC0128c b;
    protected final int c;
    private AbstractC0128c d;
    private int e;
    private int f;
    private j$.util.t g;
    private boolean h;
    private boolean i;
    private Runnable j;
    private boolean k;

    AbstractC0128c(AbstractC0128c abstractC0128c, int i) {
        if (abstractC0128c.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        abstractC0128c.h = true;
        abstractC0128c.d = this;
        this.b = abstractC0128c;
        this.c = EnumC0145e4.h & i;
        this.f = EnumC0145e4.a(i, abstractC0128c.f);
        AbstractC0128c abstractC0128c2 = abstractC0128c.a;
        this.a = abstractC0128c2;
        if (H0()) {
            abstractC0128c2.i = true;
        }
        this.e = abstractC0128c.e + 1;
    }

    AbstractC0128c(j$.util.t tVar, int i, boolean z) {
        this.b = null;
        this.g = tVar;
        this.a = this;
        int i2 = EnumC0145e4.g & i;
        this.c = i2;
        this.f = ((i2 << 1) ^ (-1)) & EnumC0145e4.l;
        this.e = 0;
        this.k = z;
    }

    private j$.util.t J0(int i) {
        int i2;
        int i3;
        AbstractC0128c abstractC0128c = this.a;
        j$.util.t tVarG0 = abstractC0128c.g;
        if (tVarG0 == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0128c.g = null;
        if (abstractC0128c.k && abstractC0128c.i) {
            AbstractC0128c abstractC0128c2 = abstractC0128c.d;
            int i4 = 1;
            while (abstractC0128c != this) {
                int i5 = abstractC0128c2.c;
                if (abstractC0128c2.H0()) {
                    i4 = 0;
                    if (EnumC0145e4.SHORT_CIRCUIT.d(i5)) {
                        i5 &= EnumC0145e4.u ^ (-1);
                    }
                    tVarG0 = abstractC0128c2.G0(abstractC0128c, tVarG0);
                    if (tVarG0.hasCharacteristics(64)) {
                        i2 = i5 & (EnumC0145e4.t ^ (-1));
                        i3 = EnumC0145e4.s;
                    } else {
                        i2 = i5 & (EnumC0145e4.s ^ (-1));
                        i3 = EnumC0145e4.t;
                    }
                    i5 = i2 | i3;
                }
                abstractC0128c2.e = i4;
                abstractC0128c2.f = EnumC0145e4.a(i5, abstractC0128c.f);
                i4++;
                AbstractC0128c abstractC0128c3 = abstractC0128c2;
                abstractC0128c2 = abstractC0128c2.d;
                abstractC0128c = abstractC0128c3;
            }
        }
        if (i != 0) {
            this.f = EnumC0145e4.a(i, this.f);
        }
        return tVarG0;
    }

    abstract A1 A0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z, j$.util.function.m mVar);

    abstract void B0(j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3);

    abstract EnumC0151f4 C0();

    final boolean D0() {
        return EnumC0145e4.ORDERED.d(this.f);
    }

    public /* synthetic */ j$.util.t E0() {
        return J0(0);
    }

    A1 F0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, j$.util.function.m mVar) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    j$.util.t G0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        return F0(abstractC0256y2, tVar, new j$.util.function.m() { // from class: j$.util.stream.a
            @Override // j$.util.function.m
            public final Object apply(int i) {
                return new Object[i];
            }
        }).spliterator();
    }

    abstract boolean H0();

    abstract InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3);

    final j$.util.t K0() {
        AbstractC0128c abstractC0128c = this.a;
        if (this != abstractC0128c) {
            throw new IllegalStateException();
        }
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        j$.util.t tVar = abstractC0128c.g;
        if (tVar == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0128c.g = null;
        return tVar;
    }

    abstract j$.util.t L0(AbstractC0256y2 abstractC0256y2, j$.util.function.z zVar, boolean z);

    @Override // j$.util.stream.InterfaceC0152g, java.lang.AutoCloseable
    public void close() {
        this.h = true;
        this.g = null;
        AbstractC0128c abstractC0128c = this.a;
        Runnable runnable = abstractC0128c.j;
        if (runnable != null) {
            abstractC0128c.j = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.InterfaceC0152g
    public final boolean isParallel() {
        return this.a.k;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final void o0(InterfaceC0192m3 interfaceC0192m3, j$.util.t tVar) {
        interfaceC0192m3.getClass();
        if (EnumC0145e4.SHORT_CIRCUIT.d(this.f)) {
            p0(interfaceC0192m3, tVar);
            return;
        }
        interfaceC0192m3.o(tVar.getExactSizeIfKnown());
        tVar.forEachRemaining(interfaceC0192m3);
        interfaceC0192m3.n();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public InterfaceC0152g onClose(Runnable runnable) {
        AbstractC0128c abstractC0128c = this.a;
        Runnable runnable2 = abstractC0128c.j;
        if (runnable2 != null) {
            runnable = new N4(runnable2, runnable);
        }
        abstractC0128c.j = runnable;
        return this;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final void p0(InterfaceC0192m3 interfaceC0192m3, j$.util.t tVar) {
        AbstractC0128c abstractC0128c = this;
        while (abstractC0128c.e > 0) {
            abstractC0128c = abstractC0128c.b;
        }
        interfaceC0192m3.o(tVar.getExactSizeIfKnown());
        abstractC0128c.B0(tVar, interfaceC0192m3);
        interfaceC0192m3.n();
    }

    public final InterfaceC0152g parallel() {
        this.a.k = true;
        return this;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final A1 q0(j$.util.t tVar, boolean z, j$.util.function.m mVar) {
        if (this.a.k) {
            return A0(this, tVar, z, mVar);
        }
        InterfaceC0225s1 interfaceC0225s1U0 = u0(r0(tVar), mVar);
        interfaceC0225s1U0.getClass();
        o0(w0(interfaceC0225s1U0), tVar);
        return interfaceC0225s1U0.b();
    }

    @Override // j$.util.stream.AbstractC0256y2
    final long r0(j$.util.t tVar) {
        if (EnumC0145e4.SIZED.d(this.f)) {
            return tVar.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final EnumC0151f4 s0() {
        AbstractC0128c abstractC0128c = this;
        while (abstractC0128c.e > 0) {
            abstractC0128c = abstractC0128c.b;
        }
        return abstractC0128c.C0();
    }

    public final InterfaceC0152g sequential() {
        this.a.k = false;
        return this;
    }

    public j$.util.t spliterator() {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        AbstractC0128c abstractC0128c = this.a;
        if (this != abstractC0128c) {
            return L0(this, new C0122b(this), abstractC0128c.k);
        }
        j$.util.t tVar = abstractC0128c.g;
        if (tVar == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0128c.g = null;
        return tVar;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final int t0() {
        return this.f;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final InterfaceC0192m3 v0(InterfaceC0192m3 interfaceC0192m3, j$.util.t tVar) {
        interfaceC0192m3.getClass();
        o0(w0(interfaceC0192m3), tVar);
        return interfaceC0192m3;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final InterfaceC0192m3 w0(InterfaceC0192m3 interfaceC0192m3) {
        interfaceC0192m3.getClass();
        for (AbstractC0128c abstractC0128c = this; abstractC0128c.e > 0; abstractC0128c = abstractC0128c.b) {
            interfaceC0192m3 = abstractC0128c.I0(abstractC0128c.b.f, interfaceC0192m3);
        }
        return interfaceC0192m3;
    }

    @Override // j$.util.stream.AbstractC0256y2
    final j$.util.t x0(j$.util.t tVar) {
        return this.e == 0 ? tVar : L0(this, new C0122b(tVar), this.a.k);
    }

    final Object y0(O4 o4) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        return this.a.k ? o4.c(this, J0(o4.a())) : o4.d(this, J0(o4.a()));
    }

    final A1 z0(j$.util.function.m mVar) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (!this.a.k || this.b == null || !H0()) {
            return q0(J0(0), true, mVar);
        }
        this.e = 0;
        AbstractC0128c abstractC0128c = this.b;
        return F0(abstractC0128c, abstractC0128c.J0(0), mVar);
    }
}
