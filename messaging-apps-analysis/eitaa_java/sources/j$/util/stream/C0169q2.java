package j$.util.stream;

/* JADX INFO: Add missing generic type declarations: [R] */
/* renamed from: j$.util.stream.q2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0169q2<R> extends AbstractC0200y2<Integer, R, C0172r2> {
    final /* synthetic */ j$.util.function.p b;
    final /* synthetic */ j$.util.function.J c;
    final /* synthetic */ j$.util.function.L d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0169q2(W2 w2, j$.util.function.p pVar, j$.util.function.J j, j$.util.function.L l) {
        super(w2);
        this.b = pVar;
        this.c = j;
        this.d = l;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0172r2(this.d, this.c, this.b);
    }
}
