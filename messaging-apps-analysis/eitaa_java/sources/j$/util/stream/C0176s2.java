package j$.util.stream;

/* renamed from: j$.util.stream.s2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0176s2 extends AbstractC0200y2<Long, Long, C0180t2> {
    final /* synthetic */ j$.util.function.D b;
    final /* synthetic */ long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0176s2(W2 w2, j$.util.function.D d, long j) {
        super(w2);
        this.b = d;
        this.c = j;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0180t2(this.c, this.b);
    }
}
