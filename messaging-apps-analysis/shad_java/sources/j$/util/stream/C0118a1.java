package j$.util.stream;

/* renamed from: j$.util.stream.a1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0118a1 extends AbstractC0136d1 {
    C0118a1(j$.util.t tVar, int i, boolean z) {
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

    @Override // j$.util.stream.AbstractC0136d1, j$.util.stream.InterfaceC0142e1
    public void a0(j$.util.function.q qVar) {
        if (!isParallel()) {
            AbstractC0136d1.N0(K0()).e(qVar);
        } else {
            qVar.getClass();
            y0(new C0189m0(qVar, true));
        }
    }

    @Override // j$.util.stream.AbstractC0136d1, j$.util.stream.InterfaceC0142e1
    public void e(j$.util.function.q qVar) {
        if (isParallel()) {
            super.e(qVar);
        } else {
            AbstractC0136d1.N0(K0()).e(qVar);
        }
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* bridge */ /* synthetic */ InterfaceC0142e1 parallel() {
        parallel();
        return this;
    }

    @Override // j$.util.stream.AbstractC0128c, j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* bridge */ /* synthetic */ InterfaceC0142e1 sequential() {
        sequential();
        return this;
    }
}
