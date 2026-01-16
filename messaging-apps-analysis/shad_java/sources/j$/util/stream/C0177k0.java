package j$.util.stream;

/* renamed from: j$.util.stream.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0177k0 extends AbstractC0201o0 implements InterfaceC0174j3 {
    final j$.util.function.f b;

    C0177k0(j$.util.function.f fVar, boolean z) {
        super(z);
        this.b = fVar;
    }

    @Override // j$.util.stream.AbstractC0201o0, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        this.b.accept(d);
    }

    @Override // j$.util.function.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }
}
