package j$.util.stream;

/* renamed from: j$.util.stream.m2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0153m2 extends AbstractC0200y2<Integer, Integer, C0157n2> {
    final /* synthetic */ j$.util.function.x b;
    final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0153m2(W2 w2, j$.util.function.x xVar, int i) {
        super(w2);
        this.b = xVar;
        this.c = i;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0157n2(this.c, this.b);
    }
}
