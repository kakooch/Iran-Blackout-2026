package j$.util.stream;

/* loaded from: classes2.dex */
class I0 extends L0 {
    I0(j$.util.t tVar, int i, boolean z) {
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

    @Override // j$.util.stream.L0, j$.util.stream.IntStream
    public void J(j$.util.function.l lVar) {
        if (!isParallel()) {
            L0.N0(K0()).e(lVar);
        } else {
            lVar.getClass();
            y0(new C0183l0(lVar, true));
        }
    }

    @Override // j$.util.stream.L0, j$.util.stream.IntStream
    public void V(j$.util.function.l lVar) {
        if (isParallel()) {
            super.V(lVar);
        } else {
            L0.N0(K0()).e(lVar);
        }
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* bridge */ /* synthetic */ IntStream parallel() {
        parallel();
        return this;
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* bridge */ /* synthetic */ IntStream sequential() {
        sequential();
        return this;
    }
}
