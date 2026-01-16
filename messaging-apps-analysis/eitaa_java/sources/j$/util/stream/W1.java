package j$.util.stream;

/* JADX INFO: Add missing generic type declarations: [R] */
/* loaded from: classes2.dex */
class W1<R> extends AbstractC0200y2<Long, R, X1> {
    final /* synthetic */ j$.util.function.p b;
    final /* synthetic */ j$.util.function.K c;
    final /* synthetic */ j$.util.function.L d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    W1(W2 w2, j$.util.function.p pVar, j$.util.function.K k, j$.util.function.L l) {
        super(w2);
        this.b = pVar;
        this.c = k;
        this.d = l;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new X1(this.d, this.c, this.b);
    }
}
