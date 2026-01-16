package j$.util.function;

/* renamed from: j$.util.function.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0100k implements H {
    public final /* synthetic */ H a;
    public final /* synthetic */ H b;

    public /* synthetic */ C0100k(H h, H h2) {
        this.a = h;
        this.b = h2;
    }

    @Override // j$.util.function.H
    public H a(H h) {
        h.getClass();
        return new C0100k(this, h);
    }

    @Override // j$.util.function.H
    public final long applyAsLong(long j) {
        return this.b.applyAsLong(this.a.applyAsLong(j));
    }

    @Override // j$.util.function.H
    public H b(H h) {
        h.getClass();
        return new C0101l(this, h);
    }
}
