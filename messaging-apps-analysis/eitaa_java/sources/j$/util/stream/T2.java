package j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class T2<T> extends H2<T> {
    private Object[] d;
    private int e;

    T2(C2 c2, Comparator comparator) {
        super(c2, comparator);
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        Object[] objArr = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr[i] = obj;
    }

    @Override // j$.util.stream.C2.d, j$.util.stream.C2
    public void l() {
        int i = 0;
        Arrays.sort(this.d, 0, this.e, this.b);
        this.a.m(this.e);
        if (this.c) {
            while (i < this.e && !this.a.o()) {
                this.a.accept(this.d[i]);
                i++;
            }
        } else {
            while (i < this.e) {
                this.a.accept(this.d[i]);
                i++;
            }
        }
        this.a.l();
        this.d = null;
    }

    @Override // j$.util.stream.C2.d, j$.util.stream.C2
    public void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.d = new Object[(int) j];
    }
}
