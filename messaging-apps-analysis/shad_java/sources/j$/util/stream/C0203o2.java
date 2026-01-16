package j$.util.stream;

/* renamed from: j$.util.stream.o2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0203o2 extends AbstractC0226s2 implements InterfaceC0174j3 {
    private final double[] h;

    C0203o2(C0203o2 c0203o2, j$.util.t tVar, long j, long j2) {
        super(c0203o2, tVar, j, j2, c0203o2.h.length);
        this.h = c0203o2.h;
    }

    C0203o2(j$.util.t tVar, AbstractC0256y2 abstractC0256y2, double[] dArr) {
        super(tVar, abstractC0256y2, dArr.length);
        this.h = dArr;
    }

    @Override // j$.util.stream.AbstractC0226s2
    AbstractC0226s2 a(j$.util.t tVar, long j, long j2) {
        return new C0203o2(this, tVar, j, j2);
    }

    @Override // j$.util.stream.AbstractC0226s2, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        double[] dArr = this.h;
        this.f = i + 1;
        dArr[i] = d;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }
}
