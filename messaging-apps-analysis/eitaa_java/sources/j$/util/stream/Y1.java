package j$.util.stream;

/* loaded from: classes2.dex */
class Y1 extends AbstractC0200y2<Double, Double, Z1> {
    final /* synthetic */ j$.util.function.r b;
    final /* synthetic */ double c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Y1(W2 w2, j$.util.function.r rVar, double d) {
        super(w2);
        this.b = rVar;
        this.c = d;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new Z1(this.c, this.b);
    }
}
