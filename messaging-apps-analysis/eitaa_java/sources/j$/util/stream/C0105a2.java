package j$.util.stream;

/* renamed from: j$.util.stream.a2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0105a2 extends AbstractC0200y2<Double, j$.util.o, C0109b2> {
    final /* synthetic */ j$.util.function.r b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0105a2(W2 w2, j$.util.function.r rVar) {
        super(w2);
        this.b = rVar;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0109b2(this.b);
    }
}
