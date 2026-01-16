package j$.util.stream;

import j$.util.AbstractC0102a;
import j$.util.t;
import j$.wrappers.C0277h;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Spliterator;

/* loaded from: classes2.dex */
abstract class Z3 extends AbstractC0140e implements Iterable, j$.lang.e {
    Object e;
    Object[] f;

    abstract class a implements j$.util.u {
        int a;
        final int b;
        int c;
        final int d;
        Object e;

        a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            Object[] objArr = Z3.this.f;
            this.e = objArr == null ? Z3.this.e : objArr[i];
        }

        abstract void b(Object obj, int i, Object obj2);

        @Override // j$.util.t
        public int characteristics() {
            return 16464;
        }

        @Override // j$.util.t
        public long estimateSize() {
            int i = this.a;
            int i2 = this.b;
            if (i == i2) {
                return this.d - this.c;
            }
            long[] jArr = Z3.this.d;
            return ((jArr[i2] + this.d) - jArr[i]) - this.c;
        }

        abstract j$.util.u f(Object obj, int i, int i2);

        @Override // j$.util.u
        /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void e(Object obj) {
            int i;
            obj.getClass();
            int i2 = this.a;
            int i3 = this.b;
            if (i2 < i3 || (i2 == i3 && this.c < this.d)) {
                int i4 = this.c;
                while (true) {
                    i = this.b;
                    if (i2 >= i) {
                        break;
                    }
                    Z3 z3 = Z3.this;
                    Object obj2 = z3.f[i2];
                    z3.u(obj2, i4, z3.v(obj2), obj);
                    i4 = 0;
                    i2++;
                }
                Z3.this.u(this.a == i ? this.e : Z3.this.f[i], i4, this.d, obj);
                this.a = this.b;
                this.c = this.d;
            }
        }

        @Override // j$.util.t
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.t
        public /* synthetic */ long getExactSizeIfKnown() {
            return AbstractC0102a.e(this);
        }

        @Override // j$.util.t
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return AbstractC0102a.f(this, i);
        }

        abstract j$.util.u i(int i, int i2, int i3, int i4);

        @Override // j$.util.u
        /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public boolean j(Object obj) {
            obj.getClass();
            int i = this.a;
            int i2 = this.b;
            if (i >= i2 && (i != i2 || this.c >= this.d)) {
                return false;
            }
            Object obj2 = this.e;
            int i3 = this.c;
            this.c = i3 + 1;
            b(obj2, i3, obj);
            if (this.c == Z3.this.v(this.e)) {
                this.c = 0;
                int i4 = this.a + 1;
                this.a = i4;
                Object[] objArr = Z3.this.f;
                if (objArr != null && i4 <= this.b) {
                    this.e = objArr[i4];
                }
            }
            return true;
        }

        @Override // j$.util.u, j$.util.t
        public /* bridge */ /* synthetic */ t.a trySplit() {
            return (t.a) trySplit();
        }

        @Override // j$.util.u, j$.util.t
        public /* bridge */ /* synthetic */ t.b trySplit() {
            return (t.b) trySplit();
        }

        @Override // j$.util.u, j$.util.t
        public /* bridge */ /* synthetic */ t.c trySplit() {
            return (t.c) trySplit();
        }

        @Override // j$.util.t
        public j$.util.u trySplit() {
            int i = this.a;
            int i2 = this.b;
            if (i < i2) {
                int i3 = this.c;
                Z3 z3 = Z3.this;
                j$.util.u uVarI = i(i, i2 - 1, i3, z3.v(z3.f[i2 - 1]));
                int i4 = this.b;
                this.a = i4;
                this.c = 0;
                this.e = Z3.this.f[i4];
                return uVarI;
            }
            if (i != i2) {
                return null;
            }
            int i5 = this.d;
            int i6 = this.c;
            int i7 = (i5 - i6) / 2;
            if (i7 == 0) {
                return null;
            }
            j$.util.u uVarF = f(this.e, i6, i7);
            this.c += i7;
            return uVarF;
        }
    }

    Z3() {
        this.e = d(16);
    }

    Z3(int i) {
        super(i);
        this.e = d(1 << this.a);
    }

    private void z() {
        if (this.f == null) {
            Object[] objArrA = A(8);
            this.f = objArrA;
            this.d = new long[8];
            objArrA[0] = this.e;
        }
    }

    protected abstract Object[] A(int i);

    protected void B() {
        if (this.b == v(this.e)) {
            z();
            int i = this.c;
            int i2 = i + 1;
            Object[] objArr = this.f;
            if (i2 >= objArr.length || objArr[i + 1] == null) {
                y(w() + 1);
            }
            this.b = 0;
            int i3 = this.c + 1;
            this.c = i3;
            this.e = this.f[i3];
        }
    }

    @Override // j$.util.stream.AbstractC0140e
    public void clear() {
        Object[] objArr = this.f;
        if (objArr != null) {
            this.e = objArr[0];
            this.f = null;
            this.d = null;
        }
        this.b = 0;
        this.c = 0;
    }

    public abstract Object d(int i);

    public void e(Object obj, int i) {
        long j = i;
        long jCount = count() + j;
        if (jCount > v(obj) || jCount < j) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.c == 0) {
            System.arraycopy(this.e, 0, obj, i, this.b);
            return;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            Object[] objArr = this.f;
            System.arraycopy(objArr[i2], 0, obj, i, v(objArr[i2]));
            i += v(this.f[i2]);
        }
        int i3 = this.b;
        if (i3 > 0) {
            System.arraycopy(this.e, 0, obj, i, i3);
        }
    }

    public Object g() {
        long jCount = count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object objD = d((int) jCount);
        e(objD, 0);
        return objD;
    }

    public void h(Object obj) {
        for (int i = 0; i < this.c; i++) {
            Object[] objArr = this.f;
            u(objArr[i], 0, v(objArr[i]), obj);
        }
        u(this.e, 0, this.b, obj);
    }

    public abstract j$.util.t spliterator();

    @Override // java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return C0277h.a(spliterator());
    }

    protected abstract void u(Object obj, int i, int i2, Object obj2);

    protected abstract int v(Object obj);

    protected long w() {
        int i = this.c;
        if (i == 0) {
            return v(this.e);
        }
        return v(this.f[i]) + this.d[i];
    }

    protected int x(long j) {
        if (this.c == 0) {
            if (j < this.b) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        if (j >= count()) {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        for (int i = 0; i <= this.c; i++) {
            if (j < this.d[i] + v(this.f[i])) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException(Long.toString(j));
    }

    protected final void y(long j) {
        long jW = w();
        if (j <= jW) {
            return;
        }
        z();
        int i = this.c;
        while (true) {
            i++;
            if (j <= jW) {
                return;
            }
            Object[] objArr = this.f;
            if (i >= objArr.length) {
                int length = objArr.length * 2;
                this.f = Arrays.copyOf(objArr, length);
                this.d = Arrays.copyOf(this.d, length);
            }
            int iT = t(i);
            this.f[i] = d(iT);
            long[] jArr = this.d;
            jArr[i] = jArr[i - 1] + v(this.f[r5]);
            jW += iT;
        }
    }
}
