package j$.util.stream;

import j$.util.function.Consumer;
import java.util.Arrays;

/* loaded from: classes2.dex */
class T1 implements InterfaceC0235u1 {
    final double[] a;
    int b;

    T1(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.a = new double[(int) j];
        this.b = 0;
    }

    T1(double[] dArr) {
        this.a = dArr;
        this.b = dArr.length;
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ void a(Consumer consumer) {
        AbstractC0202o1.k(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0260z1, j$.util.stream.A1
    public InterfaceC0260z1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.A1
    public long count() {
        return this.b;
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public void e(Object obj, int i) {
        System.arraycopy(this.a, 0, (double[]) obj, i, this.b);
    }

    @Override // j$.util.stream.A1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Double[] dArr, int i) {
        AbstractC0202o1.h(this, dArr, i);
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public Object g() {
        double[] dArr = this.a;
        int length = dArr.length;
        int i = this.b;
        return length == i ? dArr : Arrays.copyOf(dArr, i);
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public void h(Object obj) {
        j$.util.function.f fVar = (j$.util.function.f) obj;
        for (int i = 0; i < this.b; i++) {
            fVar.accept(this.a[i]);
        }
    }

    @Override // j$.util.stream.A1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ InterfaceC0235u1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.n(this, j, j2, mVar);
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ int q() {
        return 0;
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ Object[] r(j$.util.function.m mVar) {
        return AbstractC0202o1.g(this, mVar);
    }

    @Override // j$.util.stream.InterfaceC0260z1, j$.util.stream.A1
    public j$.util.u spliterator() {
        return j$.util.J.j(this.a, 0, this.b, 1040);
    }

    public String toString() {
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
    }

    @Override // j$.util.stream.A1
    public /* bridge */ /* synthetic */ A1 c(int i) {
        c(i);
        throw null;
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return j$.util.J.j(this.a, 0, this.b, 1040);
    }
}
