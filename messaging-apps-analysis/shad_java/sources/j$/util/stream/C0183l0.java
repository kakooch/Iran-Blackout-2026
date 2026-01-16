package j$.util.stream;

/* renamed from: j$.util.stream.l0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0183l0 extends AbstractC0201o0 implements InterfaceC0180k3 {
    final j$.util.function.l b;

    C0183l0(j$.util.function.l lVar, boolean z) {
        super(z);
        this.b = lVar;
    }

    @Override // j$.util.stream.AbstractC0201o0, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        this.b.accept(i);
    }

    @Override // j$.util.function.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        AbstractC0202o1.b(this, num);
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
    }
}
