package j$.util.stream;

/* renamed from: j$.util.stream.c1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0130c1 extends AbstractC0136d1 {
    AbstractC0130c1(AbstractC0128c abstractC0128c, EnumC0151f4 enumC0151f4, int i) {
        super(abstractC0128c, i);
    }

    @Override // j$.util.stream.AbstractC0128c
    final boolean H0() {
        return false;
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
