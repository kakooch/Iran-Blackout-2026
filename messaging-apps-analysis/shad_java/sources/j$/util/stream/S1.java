package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class S1 extends C1 {
    S1(A1 a1, A1 a12) {
        super(a1, a12);
    }

    @Override // j$.util.stream.A1
    public void a(Consumer consumer) {
        this.a.a(consumer);
        this.b.a(consumer);
    }

    @Override // j$.util.stream.A1
    public void j(Object[] objArr, int i) {
        objArr.getClass();
        this.a.j(objArr, i);
        this.b.j(objArr, i + ((int) this.a.count()));
    }

    @Override // j$.util.stream.A1
    public Object[] r(j$.util.function.m mVar) {
        long jCount = count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) mVar.apply((int) jCount);
        j(objArr, 0);
        return objArr;
    }

    @Override // j$.util.stream.A1
    public A1 s(long j, long j2, j$.util.function.m mVar) {
        if (j == 0 && j2 == count()) {
            return this;
        }
        long jCount = this.a.count();
        return j >= jCount ? this.b.s(j - jCount, j2 - jCount, mVar) : j2 <= jCount ? this.a.s(j, j2, mVar) : AbstractC0251x2.i(EnumC0151f4.REFERENCE, this.a.s(j, jCount, mVar), this.b.s(0L, j2 - jCount, mVar));
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return new C0173j2(this);
    }

    public String toString() {
        return count() < 32 ? String.format("ConcNode[%s.%s]", this.a, this.b) : String.format("ConcNode[size=%d]", Long.valueOf(count()));
    }
}
