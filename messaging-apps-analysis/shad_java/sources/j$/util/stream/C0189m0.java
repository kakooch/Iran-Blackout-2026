package j$.util.stream;

/* renamed from: j$.util.stream.m0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0189m0 extends AbstractC0201o0 implements InterfaceC0186l3 {
    final j$.util.function.q b;

    C0189m0(j$.util.function.q qVar, boolean z) {
        super(z);
        this.b = qVar;
    }

    @Override // j$.util.stream.AbstractC0201o0, j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        this.b.accept(j);
    }

    @Override // j$.util.function.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        AbstractC0202o1.c(this, l);
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }
}
