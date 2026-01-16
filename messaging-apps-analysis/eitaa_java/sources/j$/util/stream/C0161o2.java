package j$.util.stream;

/* renamed from: j$.util.stream.o2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0161o2 extends AbstractC0200y2<Integer, j$.util.p, C0165p2> {
    final /* synthetic */ j$.util.function.x b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0161o2(W2 w2, j$.util.function.x xVar) {
        super(w2);
        this.b = xVar;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0165p2(this.b);
    }
}
