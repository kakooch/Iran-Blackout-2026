package j$.util.stream;

import j$.util.function.C0095f;
import j$.util.function.C0098i;
import j$.util.function.C0099j;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
abstract class Z2 {
    int a;

    static final class a extends d<j$.util.function.s> implements j$.util.function.s {
        final double[] c;

        a(int i) {
            this.c = new double[i];
        }

        @Override // j$.util.function.s
        public void accept(double d) {
            double[] dArr = this.c;
            int i = this.b;
            this.b = i + 1;
            dArr[i] = d;
        }

        @Override // j$.util.stream.Z2.d
        void b(Object obj, long j) {
            j$.util.function.s sVar = (j$.util.function.s) obj;
            for (int i = 0; i < j; i++) {
                sVar.accept(this.c[i]);
            }
        }

        @Override // j$.util.function.s
        public j$.util.function.s j(j$.util.function.s sVar) {
            sVar.getClass();
            return new C0095f(this, sVar);
        }
    }

    static final class b extends d<j$.util.function.y> implements j$.util.function.y {
        final int[] c;

        b(int i) {
            this.c = new int[i];
        }

        @Override // j$.util.function.y
        public void accept(int i) {
            int[] iArr = this.c;
            int i2 = this.b;
            this.b = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.stream.Z2.d
        public void b(Object obj, long j) {
            j$.util.function.y yVar = (j$.util.function.y) obj;
            for (int i = 0; i < j; i++) {
                yVar.accept(this.c[i]);
            }
        }

        @Override // j$.util.function.y
        public j$.util.function.y k(j$.util.function.y yVar) {
            yVar.getClass();
            return new C0098i(this, yVar);
        }
    }

    static final class c extends d<j$.util.function.E> implements j$.util.function.E {
        final long[] c;

        c(int i) {
            this.c = new long[i];
        }

        @Override // j$.util.function.E
        public void accept(long j) {
            long[] jArr = this.c;
            int i = this.b;
            this.b = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.stream.Z2.d
        public void b(Object obj, long j) {
            j$.util.function.E e = (j$.util.function.E) obj;
            for (int i = 0; i < j; i++) {
                e.accept(this.c[i]);
            }
        }

        @Override // j$.util.function.E
        public j$.util.function.E f(j$.util.function.E e) {
            e.getClass();
            return new C0099j(this, e);
        }
    }

    static abstract class d<T_CONS> extends Z2 {
        int b;

        d() {
        }

        abstract void b(Object obj, long j);
    }

    static final class e<T> extends Z2 implements Consumer<T> {
        final Object[] b;

        e(int i) {
            this.b = new Object[i];
        }

        @Override // j$.util.function.Consumer
        public void accept(Object obj) {
            Object[] objArr = this.b;
            int i = this.a;
            this.a = i + 1;
            objArr[i] = obj;
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    Z2() {
    }
}
