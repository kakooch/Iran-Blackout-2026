package j$.util.stream;

import j$.util.function.Consumer;
import java.util.Arrays;

/* loaded from: classes2.dex */
class D1 implements A1 {
    final Object[] a;
    int b;

    D1(long j, j$.util.function.m mVar) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.a = (Object[]) mVar.apply((int) j);
        this.b = 0;
    }

    D1(Object[] objArr) {
        this.a = objArr;
        this.b = objArr.length;
    }

    @Override // j$.util.stream.A1
    public void a(Consumer consumer) {
        for (int i = 0; i < this.b; i++) {
            consumer.accept(this.a[i]);
        }
    }

    @Override // j$.util.stream.A1
    public A1 c(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.A1
    public long count() {
        return this.b;
    }

    @Override // j$.util.stream.A1
    public void j(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, i, this.b);
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ int q() {
        return 0;
    }

    @Override // j$.util.stream.A1
    public Object[] r(j$.util.function.m mVar) {
        Object[] objArr = this.a;
        if (objArr.length == this.b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ A1 s(long j, long j2, j$.util.function.m mVar) {
        return AbstractC0202o1.q(this, j, j2, mVar);
    }

    @Override // j$.util.stream.A1
    public j$.util.t spliterator() {
        return j$.util.J.m(this.a, 0, this.b, 1040);
    }

    public String toString() {
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.a.length - this.b), Arrays.toString(this.a));
    }
}
