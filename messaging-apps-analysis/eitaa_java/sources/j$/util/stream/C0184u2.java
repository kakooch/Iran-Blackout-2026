package j$.util.stream;

/* renamed from: j$.util.stream.u2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0184u2 extends AbstractC0200y2<Long, j$.util.q, C0188v2> {
    final /* synthetic */ j$.util.function.D b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0184u2(W2 w2, j$.util.function.D d) {
        super(w2);
        this.b = d;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0188v2(this.b);
    }
}
