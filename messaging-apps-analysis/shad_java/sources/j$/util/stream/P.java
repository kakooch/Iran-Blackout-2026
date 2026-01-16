package j$.util.stream;

/* loaded from: classes2.dex */
class P extends T {
    P(j$.util.t tVar, int i, boolean z) {
        super(tVar, i, z);
    }

    @Override // j$.util.stream.AbstractC0128c
    final boolean H0() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.AbstractC0128c
    final InterfaceC0192m3 I0(int i, InterfaceC0192m3 interfaceC0192m3) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.T, j$.util.stream.U
    public void k(j$.util.function.f fVar) {
        if (isParallel()) {
            super.k(fVar);
        } else {
            T.N0(K0()).e(fVar);
        }
    }

    @Override // j$.util.stream.T, j$.util.stream.U
    public void m0(j$.util.function.f fVar) {
        if (!isParallel()) {
            T.N0(K0()).e(fVar);
        } else {
            fVar.getClass();
            y0(new C0177k0(fVar, true));
        }
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* bridge */ /* synthetic */ U parallel() {
        parallel();
        return this;
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* bridge */ /* synthetic */ U sequential() {
        sequential();
        return this;
    }
}
