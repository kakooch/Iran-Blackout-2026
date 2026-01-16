package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
final class g3<P_IN, P_OUT> extends Y2<P_IN, P_OUT, U2<P_OUT>> {
    g3(V1 v1, Spliterator spliterator, boolean z) {
        super(v1, spliterator, z);
    }

    g3(V1 v1, j$.util.function.L l, boolean z) {
        super(v1, l, z);
    }

    @Override // j$.util.Spliterator
    public boolean b(Consumer consumer) {
        Object obj;
        consumer.getClass();
        boolean zA = a();
        if (zA) {
            U2 u2 = (U2) this.h;
            long j = this.g;
            if (u2.c != 0) {
                if (j >= u2.count()) {
                    throw new IndexOutOfBoundsException(Long.toString(j));
                }
                for (int i = 0; i <= u2.c; i++) {
                    long[] jArr = u2.d;
                    long j2 = jArr[i];
                    Object[][] objArr = u2.f;
                    if (j < j2 + objArr[i].length) {
                        obj = objArr[i][(int) (j - jArr[i])];
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            if (j >= u2.b) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            obj = u2.e[(int) j];
            consumer.accept(obj);
        }
        return zA;
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(final Consumer consumer) {
        if (this.h != null || this.i) {
            while (b(consumer)) {
            }
            return;
        }
        consumer.getClass();
        h();
        this.b.s0(new C2() { // from class: j$.util.stream.P0
            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(double d) {
                j$.time.a.c(this);
                throw null;
            }

            @Override // j$.util.stream.C2, j$.util.function.y
            public /* synthetic */ void accept(int i) {
                j$.time.a.a(this);
                throw null;
            }

            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(long j) {
                j$.time.a.b(this);
                throw null;
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                consumer.accept(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer.CC.$default$andThen(this, consumer2);
            }

            @Override // j$.util.stream.C2
            public void l() {
            }

            @Override // j$.util.stream.C2
            public void m(long j) {
            }

            @Override // j$.util.stream.C2
            public /* synthetic */ boolean o() {
                return false;
            }
        }, this.d);
        this.i = true;
    }

    @Override // j$.util.stream.Y2
    void j() {
        final U2 u2 = new U2();
        this.h = u2;
        this.e = this.b.t0(new C2() { // from class: j$.util.stream.g
            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(double d) {
                j$.time.a.c(this);
                throw null;
            }

            @Override // j$.util.stream.C2, j$.util.function.y
            public /* synthetic */ void accept(int i) {
                j$.time.a.a(this);
                throw null;
            }

            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(long j) {
                j$.time.a.b(this);
                throw null;
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                u2.accept(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.stream.C2
            public void l() {
            }

            @Override // j$.util.stream.C2
            public void m(long j) {
            }

            @Override // j$.util.stream.C2
            public /* synthetic */ boolean o() {
                return false;
            }
        });
        this.f = new j$.util.function.q() { // from class: j$.util.stream.I0
            @Override // j$.util.function.q
            public final boolean a() {
                g3 g3Var = this.a;
                return g3Var.d.b(g3Var.e);
            }
        };
    }

    @Override // j$.util.stream.Y2
    Y2 k(Spliterator spliterator) {
        return new g3(this.b, spliterator, this.a);
    }
}
