package j$.util.stream;

/* renamed from: j$.util.stream.m1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0190m1 extends AbstractC0134d {
    private final C0184l1 j;

    C0190m1(C0184l1 c0184l1, AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        super(abstractC0256y2, tVar);
        this.j = c0184l1;
    }

    C0190m1(C0190m1 c0190m1, j$.util.t tVar) {
        super(c0190m1, tVar);
        this.j = c0190m1.j;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected Object a() {
        AbstractC0256y2 abstractC0256y2 = this.a;
        AbstractC0172j1 abstractC0172j1 = (AbstractC0172j1) this.j.c.get();
        abstractC0256y2.v0(abstractC0172j1, this.b);
        boolean z = abstractC0172j1.b;
        if (z != this.j.b.b) {
            return null;
        }
        l(Boolean.valueOf(z));
        return null;
    }

    @Override // j$.util.stream.AbstractC0146f
    protected AbstractC0146f f(j$.util.t tVar) {
        return new C0190m1(this, tVar);
    }

    @Override // j$.util.stream.AbstractC0134d
    protected Object k() {
        return Boolean.valueOf(!this.j.b.b);
    }
}
