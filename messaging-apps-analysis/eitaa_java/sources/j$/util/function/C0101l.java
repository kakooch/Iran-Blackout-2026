package j$.util.function;

/* renamed from: j$.util.function.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0101l implements H {
    public final /* synthetic */ H a;
    public final /* synthetic */ H b;

    public /* synthetic */ C0101l(H h, H h2) {
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
        return this.a.applyAsLong(this.b.applyAsLong(j));
    }

    @Override // j$.util.function.H
    public H b(H h) {
        h.getClass();
        return new C0101l(this, h);
    }
}
