package j$.util;

import ir.eitaa.tgnet.ConnectionsManager;
import j$.C0206w;
import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.function.E;
import j$.util.function.y;
import j$.util.s;
import java.util.NoSuchElementException;
import org.linphone.mediastream.Factory;

/* loaded from: classes2.dex */
public final class u {
    private static final Spliterator a = new g.d();
    private static final Spliterator.b b = new g.b();
    private static final Spliterator.c c = new g.c();
    private static final Spliterator.a d = new g.a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements java.util.Iterator<T>, Consumer<T>, Iterator {
        boolean a = false;
        Object b;
        final /* synthetic */ Spliterator c;

        a(Spliterator spliterator) {
            this.c = spliterator;
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            this.a = true;
            this.b = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, C0206w.b(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.c.b(this);
            }
            return this.a;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Object next() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class b implements s.b, y {
        boolean a = false;
        int b;
        final /* synthetic */ Spliterator.b c;

        b(Spliterator.b bVar) {
            this.c = bVar;
        }

        @Override // j$.util.function.y
        public void accept(int i) {
            this.a = true;
            this.b = i;
        }

        @Override // j$.util.s
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(y yVar) {
            yVar.getClass();
            while (hasNext()) {
                yVar.accept(nextInt());
            }
        }

        @Override // j$.util.s.b, j$.util.Iterator
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof y) {
                forEachRemaining((y) consumer);
                return;
            }
            consumer.getClass();
            if (w.a) {
                w.a(b.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                throw null;
            }
            forEachRemaining(new j$.util.h(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.c.tryAdvance(this);
            }
            return this.a;
        }

        @Override // j$.util.function.y
        public y k(y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Integer next() {
            if (!w.a) {
                return Integer.valueOf(nextInt());
            }
            w.a(b.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }

        @Override // j$.util.s.b
        public int nextInt() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class c implements s.c, E {
        boolean a = false;
        long b;
        final /* synthetic */ Spliterator.c c;

        c(Spliterator.c cVar) {
            this.c = cVar;
        }

        @Override // j$.util.function.E
        public void accept(long j) {
            this.a = true;
            this.b = j;
        }

        @Override // j$.util.s
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(E e) {
            e.getClass();
            while (hasNext()) {
                e.accept(nextLong());
            }
        }

        @Override // j$.util.function.E
        public E f(E e) {
            e.getClass();
            return new C0099j(this, e);
        }

        @Override // j$.util.s.c, j$.util.Iterator
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof E) {
                forEachRemaining((E) consumer);
                return;
            }
            consumer.getClass();
            if (w.a) {
                w.a(c.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
                throw null;
            }
            forEachRemaining(new j$.util.g(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.c.tryAdvance(this);
            }
            return this.a;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Long next() {
            if (!w.a) {
                return Long.valueOf(nextLong());
            }
            w.a(c.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }

        @Override // j$.util.s.c
        public long nextLong() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    class d implements s.a, j$.util.function.s {
        boolean a = false;
        double b;
        final /* synthetic */ Spliterator.a c;

        d(Spliterator.a aVar) {
            this.c = aVar;
        }

        @Override // j$.util.function.s
        public void accept(double d) {
            this.a = true;
            this.b = d;
        }

        @Override // j$.util.s
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void forEachRemaining(j$.util.function.s sVar) {
            sVar.getClass();
            while (hasNext()) {
                sVar.accept(nextDouble());
            }
        }

        @Override // j$.util.s.a, j$.util.Iterator
        public void forEachRemaining(Consumer consumer) {
            if (consumer instanceof j$.util.function.s) {
                forEachRemaining((j$.util.function.s) consumer);
                return;
            }
            consumer.getClass();
            if (w.a) {
                w.a(d.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
                throw null;
            }
            forEachRemaining(new j$.util.j(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (!this.a) {
                this.c.tryAdvance(this);
            }
            return this.a;
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public Double next() {
            if (!w.a) {
                return Double.valueOf(nextDouble());
            }
            w.a(d.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
            throw null;
        }

        @Override // j$.util.s.a
        public double nextDouble() {
            if (!this.a && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.a = false;
            return this.b;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public /* synthetic */ void remove() {
            Iterator.CC.a(this);
            throw null;
        }
    }

    static final class e<T> implements Spliterator<T> {
        private final Object[] a;
        private int b;
        private final int c;
        private final int d;

        public e(Object[] objArr, int i, int i2, int i3) {
            this.a = objArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            Object[] objArr = this.a;
            this.b = i + 1;
            consumer.accept(objArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.c - this.b;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            int i;
            consumer.getClass();
            Object[] objArr = this.a;
            int length = objArr.length;
            int i2 = this.c;
            if (length < i2 || (i = this.b) < 0) {
                return;
            }
            this.b = i2;
            if (i < i2) {
                do {
                    consumer.accept(objArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            Object[] objArr = this.a;
            this.b = i2;
            return new e(objArr, i, i2, this.d);
        }
    }

    static final class f implements Spliterator.a {
        private final double[] a;
        private int b;
        private final int c;
        private final int d;

        public f(double[] dArr, int i, int i2, int i3) {
            this.a = dArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.e(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: e */
        public void forEachRemaining(j$.util.function.s sVar) {
            int i;
            sVar.getClass();
            double[] dArr = this.a;
            int length = dArr.length;
            int i2 = this.c;
            if (length < i2 || (i = this.b) < 0) {
                return;
            }
            this.b = i2;
            if (i < i2) {
                do {
                    sVar.accept(dArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.c - this.b;
        }

        @Override // j$.util.Spliterator.a, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.a(this, consumer);
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator.d
        /* renamed from: n */
        public boolean tryAdvance(j$.util.function.s sVar) {
            sVar.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            double[] dArr = this.a;
            this.b = i + 1;
            sVar.accept(dArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator.a trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            double[] dArr = this.a;
            this.b = i2;
            return new f(dArr, i, i2, this.d);
        }
    }

    private static abstract class g<T, S extends Spliterator<T>, C> {

        private static final class a extends g<Double, Spliterator.a, j$.util.function.s> implements Spliterator.a {
            a() {
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.e(this, consumer);
            }

            @Override // j$.util.Spliterator.a
            /* renamed from: e */
            public void forEachRemaining(j$.util.function.s sVar) {
                sVar.getClass();
            }

            @Override // j$.util.Spliterator.a, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.a(this, consumer);
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.a
            /* renamed from: n */
            public boolean tryAdvance(j$.util.function.s sVar) {
                sVar.getClass();
                return false;
            }

            @Override // j$.util.u.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.a trySplit() {
                return null;
            }

            @Override // j$.util.u.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
                return null;
            }
        }

        private static final class b extends g<Integer, Spliterator.b, y> implements Spliterator.b {
            b() {
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.f(this, consumer);
            }

            @Override // j$.util.Spliterator.b
            /* renamed from: c */
            public void forEachRemaining(y yVar) {
                yVar.getClass();
            }

            @Override // j$.util.Spliterator.b, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.b(this, consumer);
            }

            @Override // j$.util.Spliterator.b
            /* renamed from: g */
            public boolean tryAdvance(y yVar) {
                yVar.getClass();
                return false;
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

            @Override // j$.util.u.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.b trySplit() {
                return null;
            }

            @Override // j$.util.u.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
                return null;
            }
        }

        private static final class c extends g<Long, Spliterator.c, E> implements Spliterator.c {
            c() {
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ boolean b(Consumer consumer) {
                return r.g(this, consumer);
            }

            @Override // j$.util.Spliterator.c
            /* renamed from: d */
            public void forEachRemaining(E e) {
                e.getClass();
            }

            @Override // j$.util.Spliterator.c, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                r.c(this, consumer);
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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

            @Override // j$.util.Spliterator.c
            /* renamed from: i */
            public boolean tryAdvance(E e) {
                e.getClass();
                return false;
            }

            @Override // j$.util.u.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.c trySplit() {
                return null;
            }

            @Override // j$.util.u.g, j$.util.Spliterator.a, j$.util.Spliterator.d, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.d trySplit() {
                return null;
            }
        }

        private static final class d<T> extends g<T, Spliterator<T>, Consumer<? super T>> implements Spliterator<T> {
            d() {
            }

            @Override // j$.util.Spliterator
            public boolean b(Consumer consumer) {
                consumer.getClass();
                return false;
            }

            @Override // j$.util.Spliterator
            public void forEachRemaining(Consumer consumer) {
                consumer.getClass();
            }

            @Override // j$.util.Spliterator
            public java.util.Comparator getComparator() {
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
        }

        g() {
        }

        public int characteristics() {
            return 16448;
        }

        public long estimateSize() {
            return 0L;
        }

        public void forEachRemaining(Object obj) {
            obj.getClass();
        }

        public boolean tryAdvance(Object obj) {
            obj.getClass();
            return false;
        }

        public Spliterator trySplit() {
            return null;
        }
    }

    static final class h implements Spliterator.b {
        private final int[] a;
        private int b;
        private final int c;
        private final int d;

        public h(int[] iArr, int i, int i2, int i3) {
            this.a = iArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.f(this, consumer);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: c */
        public void forEachRemaining(y yVar) {
            int i;
            yVar.getClass();
            int[] iArr = this.a;
            int length = iArr.length;
            int i2 = this.c;
            if (length < i2 || (i = this.b) < 0) {
                return;
            }
            this.b = i2;
            if (i < i2) {
                do {
                    yVar.accept(iArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.c - this.b;
        }

        @Override // j$.util.Spliterator.b, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.b(this, consumer);
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: g */
        public boolean tryAdvance(y yVar) {
            yVar.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            int[] iArr = this.a;
            this.b = i + 1;
            yVar.accept(iArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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
        public Spliterator.b trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            int[] iArr = this.a;
            this.b = i2;
            return new h(iArr, i, i2, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class i<T> implements Spliterator<T> {
        private final java.util.Collection a;
        private java.util.Iterator b;
        private final int c;
        private long d;
        private int e;

        public i(java.util.Collection collection, int i) {
            this.a = collection;
            this.b = null;
            this.c = (i & Factory.DEVICE_HAS_CRAPPY_AAUDIO) == 0 ? i | 64 | 16384 : i;
        }

        public i(java.util.Iterator it, int i) {
            this.a = null;
            this.b = it;
            this.d = Long.MAX_VALUE;
            this.c = i & (-16449);
        }

        @Override // j$.util.Spliterator
        public boolean b(Consumer consumer) {
            consumer.getClass();
            if (this.b == null) {
                this.b = this.a.iterator();
                this.d = this.a.size();
            }
            if (!this.b.hasNext()) {
                return false;
            }
            consumer.accept(this.b.next());
            return true;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.c;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            if (this.b != null) {
                return this.d;
            }
            this.b = this.a.iterator();
            long size = this.a.size();
            this.d = size;
            return size;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            java.util.Iterator it = this.b;
            if (it == null) {
                it = this.a.iterator();
                this.b = it;
                this.d = this.a.size();
            }
            if (it instanceof Iterator) {
                ((Iterator) it).forEachRemaining(consumer);
            } else {
                Iterator.CC.$default$forEachRemaining(it, consumer);
            }
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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
            long size;
            java.util.Iterator it = this.b;
            if (it == null) {
                it = this.a.iterator();
                this.b = it;
                size = this.a.size();
                this.d = size;
            } else {
                size = this.d;
            }
            if (size <= 1 || !it.hasNext()) {
                return null;
            }
            int i = this.e + Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
            if (i > size) {
                i = (int) size;
            }
            if (i > 33554432) {
                i = ConnectionsManager.FileTypeVideo;
            }
            Object[] objArr = new Object[i];
            int i2 = 0;
            do {
                objArr[i2] = it.next();
                i2++;
                if (i2 >= i) {
                    break;
                }
            } while (it.hasNext());
            this.e = i2;
            long j = this.d;
            if (j != Long.MAX_VALUE) {
                this.d = j - i2;
            }
            return new e(objArr, 0, i2, this.c);
        }
    }

    static final class j implements Spliterator.c {
        private final long[] a;
        private int b;
        private final int c;
        private final int d;

        public j(long[] jArr, int i, int i2, int i3) {
            this.a = jArr;
            this.b = i;
            this.c = i2;
            this.d = i3 | 64 | 16384;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ boolean b(Consumer consumer) {
            return r.g(this, consumer);
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.d;
        }

        @Override // j$.util.Spliterator.d
        /* renamed from: d */
        public void forEachRemaining(E e) {
            int i;
            e.getClass();
            long[] jArr = this.a;
            int length = jArr.length;
            int i2 = this.c;
            if (length < i2 || (i = this.b) < 0) {
                return;
            }
            this.b = i2;
            if (i < i2) {
                do {
                    e.accept(jArr[i]);
                    i++;
                } while (i < i2);
            }
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.c - this.b;
        }

        @Override // j$.util.Spliterator.c, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            r.c(this, consumer);
        }

        @Override // j$.util.Spliterator
        public java.util.Comparator getComparator() {
            if (j$.time.a.h(this, 4)) {
                return null;
            }
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

        @Override // j$.util.Spliterator.d
        /* renamed from: i */
        public boolean tryAdvance(E e) {
            e.getClass();
            int i = this.b;
            if (i < 0 || i >= this.c) {
                return false;
            }
            long[] jArr = this.a;
            this.b = i + 1;
            e.accept(jArr[i]);
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator.c trySplit() {
            int i = this.b;
            int i2 = (this.c + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            long[] jArr = this.a;
            this.b = i2;
            return new j(jArr, i, i2, this.d);
        }
    }

    private static void a(int i2, int i3, int i4) {
        if (i3 <= i4) {
            if (i3 < 0) {
                throw new ArrayIndexOutOfBoundsException(i3);
            }
            if (i4 > i2) {
                throw new ArrayIndexOutOfBoundsException(i4);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i3 + ") > fence(" + i4 + ")");
    }

    public static Spliterator.a b() {
        return d;
    }

    public static Spliterator.b c() {
        return b;
    }

    public static Spliterator.c d() {
        return c;
    }

    public static Spliterator e() {
        return a;
    }

    public static s.a f(Spliterator.a aVar) {
        aVar.getClass();
        return new d(aVar);
    }

    public static s.b g(Spliterator.b bVar) {
        bVar.getClass();
        return new b(bVar);
    }

    public static s.c h(Spliterator.c cVar) {
        cVar.getClass();
        return new c(cVar);
    }

    public static java.util.Iterator i(Spliterator spliterator) {
        spliterator.getClass();
        return new a(spliterator);
    }

    public static Spliterator.a j(double[] dArr, int i2, int i3, int i4) {
        dArr.getClass();
        a(dArr.length, i2, i3);
        return new f(dArr, i2, i3, i4);
    }

    public static Spliterator.b k(int[] iArr, int i2, int i3, int i4) {
        iArr.getClass();
        a(iArr.length, i2, i3);
        return new h(iArr, i2, i3, i4);
    }

    public static Spliterator.c l(long[] jArr, int i2, int i3, int i4) {
        jArr.getClass();
        a(jArr.length, i2, i3);
        return new j(jArr, i2, i3, i4);
    }

    public static Spliterator m(java.util.Collection collection, int i2) {
        collection.getClass();
        return new i(collection, i2);
    }

    public static Spliterator n(Object[] objArr, int i2, int i3, int i4) {
        objArr.getClass();
        a(objArr.length, i2, i3);
        return new e(objArr, i2, i3, i4);
    }

    public static Spliterator o(java.util.Iterator it, int i2) {
        it.getClass();
        return new i(it, i2);
    }
}
