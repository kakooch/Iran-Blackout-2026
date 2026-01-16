package j$.util.stream;

/* renamed from: j$.util.stream.p2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0209p2 extends AbstractC0226s2 implements InterfaceC0180k3 {
    private final int[] h;

    C0209p2(C0209p2 c0209p2, j$.util.t tVar, long j, long j2) {
        super(c0209p2, tVar, j, j2, c0209p2.h.length);
        this.h = c0209p2.h;
    }

    C0209p2(j$.util.t tVar, AbstractC0256y2 abstractC0256y2, int[] iArr) {
        super(tVar, abstractC0256y2, iArr.length);
        this.h = iArr;
    }

    @Override // j$.util.stream.AbstractC0226s2
    AbstractC0226s2 a(j$.util.t tVar, long j, long j2) {
        return new C0209p2(this, tVar, j, j2);
    }

    @Override // j$.util.stream.AbstractC0226s2, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        int i2 = this.f;
        if (i2 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        int[] iArr = this.h;
        this.f = i2 + 1;
        iArr[i2] = i;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        AbstractC0202o1.b(this, num);
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
    }
}
