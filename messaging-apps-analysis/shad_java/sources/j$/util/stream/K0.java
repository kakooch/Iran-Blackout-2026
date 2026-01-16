package j$.util.stream;

/* loaded from: classes2.dex */
abstract class K0 extends L0 {
    K0(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i) {
        super(abstractC0128c, i);
    }

    @Override // j$.util.stream.AbstractC0128c
    final boolean H0() {
        return false;
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
