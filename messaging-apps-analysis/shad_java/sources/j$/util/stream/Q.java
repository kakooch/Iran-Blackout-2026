package j$.util.stream;

/* loaded from: classes2.dex */
abstract class Q extends T {
    Q(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i) {
        super(abstractC0128c, i);
    }

    @Override // j$.util.stream.AbstractC0128c
    final boolean H0() {
        return true;
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
