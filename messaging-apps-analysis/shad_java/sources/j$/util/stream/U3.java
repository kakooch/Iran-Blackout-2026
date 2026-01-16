package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
class U3 extends Z3 implements j$.util.function.f {
    U3() {
    }

    U3(int i) {
        super(i);
    }

    @Override // j$.util.stream.Z3
    protected Object[] A(int i) {
        return new double[i][];
    }

    @Override // j$.util.stream.Z3, java.lang.Iterable, j$.lang.e
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public t.a spliterator() {
        return new T3(this, 0, this.c, 0, this.b);
    }

    @Override // j$.lang.e
    public void a(Consumer consumer) {
        if (consumer instanceof j$.util.function.f) {
            h((j$.util.function.f) consumer);
        } else {
            if (R4.a) {
                R4.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            }
            spliterator().forEachRemaining(consumer);
        }
    }

    @Override // j$.util.function.f
    public void accept(double d) {
        B();
        double[] dArr = (double[]) this.e;
        int i = this.b;
        this.b = i + 1;
        dArr[i] = d;
    }

    @Override // j$.util.stream.Z3
    public Object d(int i) {
        return new double[i];
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return j$.util.J.f(spliterator());
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }

    public String toString() {
        double[] dArr = (double[]) g();
        return dArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(dArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }

    @Override // j$.util.stream.Z3
    protected void u(Object obj, int i, int i2, Object obj2) {
        double[] dArr = (double[]) obj;
        j$.util.function.f fVar = (j$.util.function.f) obj2;
        while (i < i2) {
            fVar.accept(dArr[i]);
            i++;
        }
    }

    @Override // j$.util.stream.Z3
    protected int v(Object obj) {
        return ((double[]) obj).length;
    }
}
