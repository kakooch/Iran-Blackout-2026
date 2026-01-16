package j$.util.stream;

import j$.C0066h;
import j$.C0206w;
import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
class U2<E> extends AbstractC0156n1 implements Consumer<E>, Iterable<E>, Iterable {
    protected Object[] e = new Object[16];
    protected Object[][] f;

    class a implements Spliterator<E> {
        int a;
        final int b;
        int c;
        final int d;
        Object[] e;

        a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            Object[][] objArr = U2.this.f;
            this.e = objArr == null ? U2.this.e : objArr[i];
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            int i = this.a;
            int i2 = this.b;
            if (i >= i2 && (i != i2 || this.c >= this.d)) {
                return false;
            }
            Object[] objArr = this.e;
            int i3 = this.c;
            this.c = i3 + 1;
            consumer.accept(objArr[i3]);
            if (this.c == this.e.length) {
                this.c = 0;
                int i4 = this.a + 1;
                this.a = i4;
                Object[][] objArr2 = U2.this.f;
                if (objArr2 != null && i4 <= this.b) {
                    this.e = objArr2[i4];
                }
            }
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 16464;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            int i = this.a;
            int i2 = this.b;
            if (i == i2) {
                return this.d - this.c;
            }
            long[] jArr = U2.this.d;
            return ((jArr[i2] + this.d) - jArr[i]) - this.c;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            int i;
            consumer.getClass();
            int i2 = this.a;
            int i3 = this.b;
            if (i2 < i3 || (i2 == i3 && this.c < this.d)) {
                int i4 = this.c;
                while (true) {
                    i = this.b;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = U2.this.f[i2];
                    while (i4 < objArr.length) {
                        consumer.accept(objArr[i4]);
                        i4++;
                    }
                    i4 = 0;
                    i2++;
                }
                Object[] objArr2 = this.a == i ? this.e : U2.this.f[i];
                int i5 = this.d;
                while (i4 < i5) {
                    consumer.accept(objArr2[i4]);
                    i4++;
                }
                this.a = this.b;
                this.c = this.d;
            }
        }

        @Override // j$.util.Spliterator
        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return j$.time.a.g(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return j$.time.a.h(this, i);
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.a;
            int i2 = this.b;
            if (i < i2) {
                U2 u2 = U2.this;
                int i3 = i2 - 1;
                a aVar = new a(i, i3, this.c, u2.f[i3].length);
                int i4 = this.b;
                this.a = i4;
                this.c = 0;
                this.e = U2.this.f[i4];
                return aVar;
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
            Spliterator spliteratorN = j$.util.u.n(this.e, i6, i6 + i7, 1040);
            this.c += i7;
            return spliteratorN;
        }
    }

    static class b extends e<Double, double[], j$.util.function.s> implements j$.util.function.s {

        class a extends e<Double, double[], j$.util.function.s>.a<Spliterator.a> implements Spliterator.a {
            a(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            @Override // j$.util.stream.U2.e.a
            void a(Object obj, int i, Object obj2) {
                ((j$.util.function.s) obj2).accept(((double[]) obj)[i]);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.e(this, consumer);
            }

            @Override // j$.util.stream.U2.e.a
            Spliterator.d f(Object obj, int i, int i2) {
                return j$.util.u.j((double[]) obj, i, i2 + i, 1040);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.a(this, consumer);
            }

            @Override // j$.util.stream.U2.e.a
            Spliterator.d h(int i, int i2, int i3, int i4) {
                return b.this.new a(i, i2, i3, i4);
            }
        }

        b() {
        }

        b(int i) {
            super(i);
        }

        @Override // j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public Spliterator.a spliterator() {
            return new a(0, this.c, 0, this.b);
        }

        public void accept(double d) {
            z();
            double[] dArr = (double[]) this.e;
            int i = this.b;
            this.b = i + 1;
            dArr[i] = d;
        }

        @Override // j$.util.stream.U2.e
        public Object c(int i) {
            return new double[i];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof j$.util.function.s) {
                g((j$.util.function.s) consumer);
            } else {
                if (k3.a) {
                    k3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                    throw null;
                }
                spliterator().forEachRemaining(consumer);
            }
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator iterator() {
            return j$.util.u.f(spliterator());
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }

        @Override // j$.util.stream.U2.e
        protected void s(Object obj, int i, int i2, Object obj2) {
            double[] dArr = (double[]) obj;
            j$.util.function.s sVar = (j$.util.function.s) obj2;
            while (i < i2) {
                sVar.accept(dArr[i]);
                i++;
            }
        }

        @Override // j$.util.stream.U2.e
        protected int t(Object obj) {
            return ((double[]) obj).length;
        }

        public String toString() {
            double[] dArr = (double[]) e();
            return dArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(dArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(dArr, 200)));
        }

        @Override // j$.util.stream.U2.e
        protected Object[] y(int i) {
            return new double[i][];
        }
    }

    static class c extends e<Integer, int[], j$.util.function.y> implements j$.util.function.y {

        class a extends e<Integer, int[], j$.util.function.y>.a<Spliterator.b> implements Spliterator.b {
            a(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            @Override // j$.util.stream.U2.e.a
            void a(Object obj, int i, Object obj2) {
                ((j$.util.function.y) obj2).accept(((int[]) obj)[i]);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.f(this, consumer);
            }

            @Override // j$.util.stream.U2.e.a
            Spliterator.d f(Object obj, int i, int i2) {
                return j$.util.u.k((int[]) obj, i, i2 + i, 1040);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.b(this, consumer);
            }

            @Override // j$.util.stream.U2.e.a
            Spliterator.d h(int i, int i2, int i3, int i4) {
                return c.this.new a(i, i2, i3, i4);
            }
        }

        c() {
        }

        c(int i) {
            super(i);
        }

        @Override // j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public Spliterator.b spliterator() {
            return new a(0, this.c, 0, this.b);
        }

        public void accept(int i) {
            z();
            int[] iArr = (int[]) this.e;
            int i2 = this.b;
            this.b = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.stream.U2.e
        public Object c(int i) {
            return new int[i];
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof j$.util.function.y) {
                g((j$.util.function.y) consumer);
            } else {
                if (k3.a) {
                    k3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                    throw null;
                }
                spliterator().forEachRemaining(consumer);
            }
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator iterator() {
            return j$.util.u.g(spliterator());
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }

        @Override // j$.util.stream.U2.e
        protected void s(Object obj, int i, int i2, Object obj2) {
            int[] iArr = (int[]) obj;
            j$.util.function.y yVar = (j$.util.function.y) obj2;
            while (i < i2) {
                yVar.accept(iArr[i]);
                i++;
            }
        }

        @Override // j$.util.stream.U2.e
        protected int t(Object obj) {
            return ((int[]) obj).length;
        }

        public String toString() {
            int[] iArr = (int[]) e();
            return iArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(iArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(iArr, 200)));
        }

        @Override // j$.util.stream.U2.e
        protected Object[] y(int i) {
            return new int[i][];
        }
    }

    static class d extends e<Long, long[], j$.util.function.E> implements j$.util.function.E {

        class a extends e<Long, long[], j$.util.function.E>.a<Spliterator.c> implements Spliterator.c {
            a(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            @Override // j$.util.stream.U2.e.a
            void a(Object obj, int i, Object obj2) {
                ((j$.util.function.E) obj2).accept(((long[]) obj)[i]);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return j$.util.r.g(this, consumer);
            }

            @Override // j$.util.stream.U2.e.a
            Spliterator.d f(Object obj, int i, int i2) {
                return j$.util.u.l((long[]) obj, i, i2 + i, 1040);
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                j$.util.r.c(this, consumer);
            }

            @Override // j$.util.stream.U2.e.a
            Spliterator.d h(int i, int i2, int i3, int i4) {
                return d.this.new a(i, i2, i3, i4);
            }
        }

        d() {
        }

        d(int i) {
            super(i);
        }

        @Override // j$.util.stream.U2.e, java.lang.Iterable, j$.lang.Iterable
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public Spliterator.c spliterator() {
            return new a(0, this.c, 0, this.b);
        }

        public void accept(long j) {
            z();
            long[] jArr = (long[]) this.e;
            int i = this.b;
            this.b = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.stream.U2.e
        public Object c(int i) {
            return new long[i];
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }

        @Override // j$.lang.Iterable
        public void forEach(Consumer consumer) {
            if (consumer instanceof j$.util.function.E) {
                g((j$.util.function.E) consumer);
            } else {
                if (k3.a) {
                    k3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                    throw null;
                }
                spliterator().forEachRemaining(consumer);
            }
        }

        @Override // java.lang.Iterable, j$.lang.Iterable
        public Iterator iterator() {
            return j$.util.u.h(spliterator());
        }

        @Override // j$.util.stream.U2.e
        protected void s(Object obj, int i, int i2, Object obj2) {
            long[] jArr = (long[]) obj;
            j$.util.function.E e = (j$.util.function.E) obj2;
            while (i < i2) {
                e.accept(jArr[i]);
                i++;
            }
        }

        @Override // j$.util.stream.U2.e
        protected int t(Object obj) {
            return ((long[]) obj).length;
        }

        public String toString() {
            long[] jArr = (long[]) e();
            return jArr.length < 200 ? String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(jArr)) : String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.c), Arrays.toString(Arrays.copyOf(jArr, 200)));
        }

        @Override // j$.util.stream.U2.e
        protected Object[] y(int i) {
            return new long[i][];
        }
    }

    static abstract class e<E, T_ARR, T_CONS> extends AbstractC0156n1 implements Iterable<E>, Iterable {
        Object e;
        Object[] f;

        abstract class a<T_SPLITR extends Spliterator.d<E, T_CONS, T_SPLITR>> implements Spliterator.d<E, T_CONS, T_SPLITR> {
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
                Object[] objArr = e.this.f;
                this.e = objArr == null ? e.this.e : objArr[i];
            }

            abstract void a(Object obj, int i, Object obj2);

            @Override // j$.util.Spliterator
            public int characteristics() {
                return 16464;
            }

            @Override // j$.util.Spliterator
            public long estimateSize() {
                int i = this.a;
                int i2 = this.b;
                if (i == i2) {
                    return this.d - this.c;
                }
                long[] jArr = e.this.d;
                return ((jArr[i2] + this.d) - jArr[i]) - this.c;
            }

            abstract Spliterator.d f(Object obj, int i, int i2);

            @Override // j$.util.Spliterator.d
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
                        e eVar = e.this;
                        Object obj2 = eVar.f[i2];
                        eVar.s(obj2, i4, eVar.t(obj2), obj);
                        i4 = 0;
                        i2++;
                    }
                    e.this.s(this.a == i ? this.e : e.this.f[i], i4, this.d, obj);
                    this.a = this.b;
                    this.c = this.d;
                }
            }

            @Override // j$.util.Spliterator
            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ long getExactSizeIfKnown() {
                return j$.time.a.g(this);
            }

            abstract Spliterator.d h(int i, int i2, int i3, int i4);

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean hasCharacteristics(int i) {
                return j$.time.a.h(this, i);
            }

            @Override // j$.util.Spliterator.d
            /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public boolean n(Object obj) {
                obj.getClass();
                int i = this.a;
                int i2 = this.b;
                if (i >= i2 && (i != i2 || this.c >= this.d)) {
                    return false;
                }
                Object obj2 = this.e;
                int i3 = this.c;
                this.c = i3 + 1;
                a(obj2, i3, obj);
                if (this.c == e.this.t(this.e)) {
                    this.c = 0;
                    int i4 = this.a + 1;
                    this.a = i4;
                    Object[] objArr = e.this.f;
                    if (objArr != null && i4 <= this.b) {
                        this.e = objArr[i4];
                    }
                }
                return true;
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
                return (Spliterator.a) trySplit();
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.b trySplit() {
                return (Spliterator.b) trySplit();
            }

            @Override // j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.c trySplit() {
                return (Spliterator.c) trySplit();
            }

            @Override // j$.util.Spliterator
            public Spliterator.d trySplit() {
                int i = this.a;
                int i2 = this.b;
                if (i < i2) {
                    int i3 = this.c;
                    e eVar = e.this;
                    Spliterator.d dVarH = h(i, i2 - 1, i3, eVar.t(eVar.f[i2 - 1]));
                    int i4 = this.b;
                    this.a = i4;
                    this.c = 0;
                    this.e = e.this.f[i4];
                    return dVarH;
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
                Spliterator.d dVarF = f(this.e, i6, i7);
                this.c += i7;
                return dVarF;
            }
        }

        e() {
            this.e = c(16);
        }

        e(int i) {
            super(i);
            this.e = c(1 << this.a);
        }

        private void x() {
            if (this.f == null) {
                Object[] objArrY = y(8);
                this.f = objArrY;
                this.d = new long[8];
                objArrY[0] = this.e;
            }
        }

        public abstract Object c(int i);

        @Override // j$.util.stream.AbstractC0156n1
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

        public void d(Object obj, int i) {
            long j = i;
            long jCount = count() + j;
            if (jCount > t(obj) || jCount < j) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.c == 0) {
                System.arraycopy(this.e, 0, obj, i, this.b);
                return;
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                Object[] objArr = this.f;
                System.arraycopy(objArr[i2], 0, obj, i, t(objArr[i2]));
                i += t(this.f[i2]);
            }
            int i3 = this.b;
            if (i3 > 0) {
                System.arraycopy(this.e, 0, obj, i, i3);
            }
        }

        public Object e() {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            Object objC = c((int) jCount);
            d(objC, 0);
            return objC;
        }

        public void g(Object obj) {
            for (int i = 0; i < this.c; i++) {
                Object[] objArr = this.f;
                s(objArr[i], 0, t(objArr[i]), obj);
            }
            s(this.e, 0, this.b, obj);
        }

        protected abstract void s(Object obj, int i, int i2, Object obj2);

        public abstract Spliterator spliterator();

        @Override // java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return C0066h.a(spliterator());
        }

        protected abstract int t(Object obj);

        protected long u() {
            int i = this.c;
            if (i == 0) {
                return t(this.e);
            }
            return t(this.f[i]) + this.d[i];
        }

        protected int v(long j) {
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
                if (j < this.d[i] + t(this.f[i])) {
                    return i;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        }

        protected final void w(long j) {
            long jU = u();
            if (j <= jU) {
                return;
            }
            x();
            int i = this.c;
            while (true) {
                i++;
                if (j <= jU) {
                    return;
                }
                Object[] objArr = this.f;
                if (i >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f = Arrays.copyOf(objArr, length);
                    this.d = Arrays.copyOf(this.d, length);
                }
                int iR = r(i);
                this.f[i] = c(iR);
                long[] jArr = this.d;
                jArr[i] = jArr[i - 1] + t(this.f[r5]);
                jU += iR;
            }
        }

        protected abstract Object[] y(int i);

        protected void z() {
            if (this.b == t(this.e)) {
                x();
                int i = this.c;
                int i2 = i + 1;
                Object[] objArr = this.f;
                if (i2 >= objArr.length || objArr[i + 1] == null) {
                    w(u() + 1);
                }
                this.b = 0;
                int i3 = this.c + 1;
                this.c = i3;
                this.e = this.f[i3];
            }
        }
    }

    U2() {
    }

    private void u() {
        if (this.f == null) {
            Object[][] objArr = new Object[8][];
            this.f = objArr;
            this.d = new long[8];
            objArr[0] = this.e;
        }
    }

    public void accept(Object obj) {
        if (this.b == this.e.length) {
            u();
            int i = this.c;
            int i2 = i + 1;
            Object[][] objArr = this.f;
            if (i2 >= objArr.length || objArr[i + 1] == null) {
                t(s() + 1);
            }
            this.b = 0;
            int i3 = this.c + 1;
            this.c = i3;
            this.e = this.f[i3];
        }
        Object[] objArr2 = this.e;
        int i4 = this.b;
        this.b = i4 + 1;
        objArr2[i4] = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0156n1
    public void clear() {
        Object[][] objArr = this.f;
        if (objArr != null) {
            this.e = objArr[0];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.e;
                if (i >= objArr2.length) {
                    break;
                }
                objArr2[i] = null;
                i++;
            }
            this.f = null;
            this.d = null;
        } else {
            for (int i2 = 0; i2 < this.b; i2++) {
                this.e[i2] = null;
            }
        }
        this.b = 0;
        this.c = 0;
    }

    public void forEach(Consumer consumer) {
        for (int i = 0; i < this.c; i++) {
            for (Object obj : this.f[i]) {
                consumer.accept(obj);
            }
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            consumer.accept(this.e[i2]);
        }
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(C0206w.b(consumer));
    }

    public void i(Object[] objArr, int i) {
        long j = i;
        long jCount = count() + j;
        if (jCount > objArr.length || jCount < j) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.c == 0) {
            System.arraycopy(this.e, 0, objArr, i, this.b);
            return;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            Object[][] objArr2 = this.f;
            System.arraycopy(objArr2[i2], 0, objArr, i, objArr2[i2].length);
            i += this.f[i2].length;
        }
        int i3 = this.b;
        if (i3 > 0) {
            System.arraycopy(this.e, 0, objArr, i, i3);
        }
    }

    @Override // java.lang.Iterable, j$.lang.Iterable
    public Iterator iterator() {
        return j$.util.u.i(spliterator());
    }

    protected long s() {
        int i = this.c;
        if (i == 0) {
            return this.e.length;
        }
        return this.f[i].length + this.d[i];
    }

    public Spliterator spliterator() {
        return new a(0, this.c, 0, this.b);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ java.util.Spliterator spliterator() {
        return C0066h.a(spliterator());
    }

    protected final void t(long j) {
        long jS = s();
        if (j <= jS) {
            return;
        }
        u();
        int i = this.c;
        while (true) {
            i++;
            if (j <= jS) {
                return;
            }
            Object[][] objArr = this.f;
            if (i >= objArr.length) {
                int length = objArr.length * 2;
                this.f = (Object[][]) Arrays.copyOf(objArr, length);
                this.d = Arrays.copyOf(this.d, length);
            }
            int iR = r(i);
            this.f[i] = new Object[iR];
            long[] jArr = this.d;
            jArr[i] = jArr[i - 1] + r4[r6].length;
            jS += iR;
        }
    }

    public String toString() {
        final ArrayList arrayList = new ArrayList();
        forEach(new Consumer() { // from class: j$.util.stream.e1
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        });
        StringBuilder sbA = j$.com.android.tools.r8.a.a("SpinedBuffer:");
        sbA.append(arrayList.toString());
        return sbA.toString();
    }
}
