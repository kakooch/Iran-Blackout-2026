package j$.util.stream;

/* renamed from: j$.util.stream.r2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0220r2 extends AbstractC0226s2 {
    private final Object[] h;

    C0220r2(C0220r2 c0220r2, j$.util.t tVar, long j, long j2) {
        super(c0220r2, tVar, j, j2, c0220r2.h.length);
        this.h = c0220r2.h;
    }

    C0220r2(j$.util.t tVar, AbstractC0256y2 abstractC0256y2, Object[] objArr) {
        super(tVar, abstractC0256y2, objArr.length);
        this.h = objArr;
    }

    @Override // j$.util.stream.AbstractC0226s2
    AbstractC0226s2 a(j$.util.t tVar, long j, long j2) {
        return new C0220r2(this, tVar, j, j2);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        int i = this.f;
        if (i >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(this.f));
        }
        Object[] objArr = this.h;
        this.f = i + 1;
        objArr[i] = obj;
    }
}
