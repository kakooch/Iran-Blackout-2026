package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
class Y3 extends Z3 implements j$.util.function.q {
    Y3() {
    }

    Y3(int i) {
        super(i);
    }

    @Override // j$.util.stream.Z3
    protected Object[] A(int i) {
        return new long[i][];
    }

    @Override // j$.util.stream.Z3, java.lang.Iterable, j$.lang.e
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public t.c spliterator() {
        return new X3(this, 0, this.c, 0, this.b);
    }

    @Override // j$.lang.e
    public void a(Consumer consumer) {
        if (consumer instanceof j$.util.function.q) {
            h((j$.util.function.q) consumer);
        } else {
            if (R4.a) {
                R4.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
            spliterator().forEachRemaining(consumer);
        }
    }

    @Override // j$.util.function.q
    public void accept(long j) {
        B();
        long[] jArr = (long[]) this.e;
        int i = this.b;
        this.b = i + 1;
        jArr[i] = j;
    }

    @Override // j$.util.stream.Z3
    public Object d(int i) {
        return new long[i];
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return j$.util.J.h(spliterator());
    }

    public String toString() {
        long[] jArr = (long[]) g();
        return jArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(jArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }

    @Override // j$.util.stream.Z3
    protected void u(Object obj, int i, int i2, Object obj2) {
        long[] jArr = (long[]) obj;
        j$.util.function.q qVar = (j$.util.function.q) obj2;
        while (i < i2) {
            qVar.accept(jArr[i]);
            i++;
        }
    }

    @Override // j$.util.stream.Z3
    protected int v(Object obj) {
        return ((long[]) obj).length;
    }
}
