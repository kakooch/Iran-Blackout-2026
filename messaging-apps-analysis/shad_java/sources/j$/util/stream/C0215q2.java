package j$.util.stream;

/* renamed from: j$.util.stream.q2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0215q2 extends AbstractC0226s2 implements InterfaceC0186l3 {
    private final long[] h;

    C0215q2(C0215q2 c0215q2, j$.util.t tVar, long j, long j2) {
        super(c0215q2, tVar, j, j2, c0215q2.h.length);
        this.h = c0215q2.h;
    }

    C0215q2(j$.util.t tVar, AbstractC0256y2 abstractC0256y2, long[] jArr) {
        super(tVar, abstractC0256y2, jArr.length);
        this.h = jArr;
    }

    @Override // j$.util.stream.AbstractC0226s2
    AbstractC0226s2 a(j$.util.t tVar, long j, long j2) {
        return new C0215q2(this, tVar, j, j2);
    }

    @Override // j$.util.stream.AbstractC0226s2, j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        long[] jArr = this.h;
        this.f = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        AbstractC0202o1.c(this, l);
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }
}
