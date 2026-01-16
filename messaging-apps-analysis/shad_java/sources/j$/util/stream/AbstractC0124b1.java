package j$.util.stream;

/* renamed from: j$.util.stream.b1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0124b1 extends AbstractC0136d1 {
    AbstractC0124b1(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i) {
        super(abstractC0128c, i);
    }

    @Override // j$.util.stream.AbstractC0128c
    final boolean H0() {
        return true;
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
