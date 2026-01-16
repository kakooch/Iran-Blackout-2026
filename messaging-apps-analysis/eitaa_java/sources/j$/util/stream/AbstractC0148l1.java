package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0164p1;
import j$.util.stream.T1;

/* renamed from: j$.util.stream.l1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0148l1<E_IN, E_OUT, S extends InterfaceC0164p1<E_OUT, S>> extends V1<E_OUT> implements InterfaceC0164p1<E_OUT, S> {
    private final AbstractC0148l1 a;
    private final AbstractC0148l1 b;
    protected final int c;
    private AbstractC0148l1 d;
    private int e;
    private int f;
    private Spliterator g;
    private boolean h;
    private boolean i;
    private Runnable j;
    private boolean k;

    AbstractC0148l1(Spliterator spliterator, int i, boolean z) {
        this.b = null;
        this.g = spliterator;
        this.a = this;
        int i2 = V2.b & i;
        this.c = i2;
        this.f = ((i2 << 1) ^ (-1)) & V2.g;
        this.e = 0;
        this.k = z;
    }

    AbstractC0148l1(AbstractC0148l1 abstractC0148l1, int i) {
        if (abstractC0148l1.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        abstractC0148l1.h = true;
        abstractC0148l1.d = this;
        this.b = abstractC0148l1;
        this.c = V2.c & i;
        this.f = V2.h(i, abstractC0148l1.f);
        AbstractC0148l1 abstractC0148l12 = abstractC0148l1.a;
        this.a = abstractC0148l12;
        if (E0()) {
            abstractC0148l12.i = true;
        }
        this.e = abstractC0148l1.e + 1;
    }

    private Spliterator G0(int i) {
        int i2;
        int i3;
        AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l1 = this.a;
        Spliterator spliteratorD0 = abstractC0148l1.g;
        if (spliteratorD0 == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0148l1.g = null;
        if (abstractC0148l1.k && abstractC0148l1.i) {
            AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l12 = abstractC0148l1.d;
            int i4 = 1;
            while (abstractC0148l1 != this) {
                int i5 = abstractC0148l12.c;
                if (abstractC0148l12.E0()) {
                    i4 = 0;
                    if (V2.SHORT_CIRCUIT.n(i5)) {
                        i5 &= V2.p ^ (-1);
                    }
                    spliteratorD0 = abstractC0148l12.D0(abstractC0148l1, spliteratorD0);
                    if (spliteratorD0.hasCharacteristics(64)) {
                        i2 = i5 & (V2.o ^ (-1));
                        i3 = V2.n;
                    } else {
                        i2 = i5 & (V2.n ^ (-1));
                        i3 = V2.o;
                    }
                    i5 = i2 | i3;
                }
                abstractC0148l12.e = i4;
                abstractC0148l12.f = V2.h(i5, abstractC0148l1.f);
                i4++;
                AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l13 = abstractC0148l12;
                abstractC0148l12 = abstractC0148l12.d;
                abstractC0148l1 = abstractC0148l13;
            }
        }
        if (i != 0) {
            this.f = V2.h(i, this.f);
        }
        return spliteratorD0;
    }

    final boolean A0() {
        return V2.ORDERED.n(this.f);
    }

    public /* synthetic */ Spliterator B0() {
        return G0(0);
    }

    T1 C0(V1 v1, Spliterator spliterator, j$.util.function.z zVar) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    Spliterator D0(V1 v1, Spliterator spliterator) {
        return C0(v1, spliterator, new j$.util.function.z() { // from class: j$.util.stream.j
            @Override // j$.util.function.z
            public final Object apply(int i) {
                return new Object[i];
            }
        }).spliterator();
    }

    abstract boolean E0();

    abstract C2 F0(int i, C2 c2);

    final Spliterator H0() {
        AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l1 = this.a;
        if (this != abstractC0148l1) {
            throw new IllegalStateException();
        }
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        Spliterator spliterator = abstractC0148l1.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0148l1.g = null;
        return spliterator;
    }

    abstract Spliterator I0(V1 v1, j$.util.function.L l, boolean z);

    @Override // j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    public void close() {
        this.h = true;
        this.g = null;
        AbstractC0148l1 abstractC0148l1 = this.a;
        Runnable runnable = abstractC0148l1.j;
        if (runnable != null) {
            abstractC0148l1.j = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public final boolean isParallel() {
        return this.a.k;
    }

    @Override // j$.util.stream.V1
    final void l0(C2 c2, Spliterator spliterator) {
        c2.getClass();
        if (V2.SHORT_CIRCUIT.n(this.f)) {
            m0(c2, spliterator);
            return;
        }
        c2.m(spliterator.getExactSizeIfKnown());
        spliterator.forEachRemaining(c2);
        c2.l();
    }

    @Override // j$.util.stream.V1
    final void m0(C2 c2, Spliterator spliterator) {
        AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l1 = this;
        while (abstractC0148l1.e > 0) {
            abstractC0148l1 = abstractC0148l1.b;
        }
        c2.m(spliterator.getExactSizeIfKnown());
        abstractC0148l1.y0(spliterator, c2);
        c2.l();
    }

    @Override // j$.util.stream.V1
    final T1 n0(Spliterator spliterator, boolean z, j$.util.function.z zVar) {
        if (this.a.k) {
            return x0(this, spliterator, z, zVar);
        }
        T1.a aVarR0 = r0(o0(spliterator), zVar);
        aVarR0.getClass();
        l0(t0(aVarR0), spliterator);
        return aVarR0.a();
    }

    @Override // j$.util.stream.V1
    final long o0(Spliterator spliterator) {
        if (V2.SIZED.n(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public InterfaceC0164p1 onClose(Runnable runnable) {
        AbstractC0148l1 abstractC0148l1 = this.a;
        Runnable runnable2 = abstractC0148l1.j;
        if (runnable2 != null) {
            runnable = new h3(runnable2, runnable);
        }
        abstractC0148l1.j = runnable;
        return this;
    }

    @Override // j$.util.stream.V1
    final W2 p0() {
        AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l1 = this;
        while (abstractC0148l1.e > 0) {
            abstractC0148l1 = abstractC0148l1.b;
        }
        return abstractC0148l1.z0();
    }

    public final InterfaceC0164p1 parallel() {
        this.a.k = true;
        return this;
    }

    @Override // j$.util.stream.V1
    final int q0() {
        return this.f;
    }

    @Override // j$.util.stream.V1
    final C2 s0(C2 c2, Spliterator spliterator) {
        c2.getClass();
        l0(t0(c2), spliterator);
        return c2;
    }

    public final InterfaceC0164p1 sequential() {
        this.a.k = false;
        return this;
    }

    public Spliterator spliterator() {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l1 = this.a;
        if (this != abstractC0148l1) {
            return I0(this, new j$.util.function.L() { // from class: j$.util.stream.k
                @Override // j$.util.function.L
                public final Object get() {
                    return this.a.B0();
                }
            }, abstractC0148l1.k);
        }
        Spliterator spliterator = abstractC0148l1.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        abstractC0148l1.g = null;
        return spliterator;
    }

    @Override // j$.util.stream.V1
    final C2 t0(C2 c2) {
        c2.getClass();
        for (AbstractC0148l1<E_IN, E_OUT, S> abstractC0148l1 = this; abstractC0148l1.e > 0; abstractC0148l1 = abstractC0148l1.b) {
            c2 = abstractC0148l1.F0(abstractC0148l1.b.f, c2);
        }
        return c2;
    }

    @Override // j$.util.stream.V1
    final Spliterator u0(final Spliterator spliterator) {
        return this.e == 0 ? spliterator : I0(this, new j$.util.function.L() { // from class: j$.util.stream.l
            @Override // j$.util.function.L
            public final Object get() {
                return spliterator;
            }
        }, this.a.k);
    }

    final Object v0(i3 i3Var) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        return this.a.k ? i3Var.c(this, G0(i3Var.b())) : i3Var.d(this, G0(i3Var.b()));
    }

    final T1 w0(j$.util.function.z zVar) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (!this.a.k || this.b == null || !E0()) {
            return n0(G0(0), true, zVar);
        }
        this.e = 0;
        AbstractC0148l1 abstractC0148l1 = this.b;
        return C0(abstractC0148l1, abstractC0148l1.G0(0), zVar);
    }

    abstract T1 x0(V1 v1, Spliterator spliterator, boolean z, j$.util.function.z zVar);

    abstract void y0(Spliterator spliterator, C2 c2);

    abstract W2 z0();
}
