package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.C2;
import j$.util.stream.U2;

/* loaded from: classes2.dex */
final class d3<P_IN> extends Y2<P_IN, Long, U2.d> implements Spliterator.c {
    d3(V1 v1, Spliterator spliterator, boolean z) {
        super(v1, spliterator, z);
    }

    d3(V1 v1, j$.util.function.L l, boolean z) {
        super(v1, l, z);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return j$.util.r.g(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e(final j$.util.function.E e) {
        if (this.h != null || this.i) {
            while (n(e)) {
            }
            return;
        }
        e.getClass();
        h();
        this.b.s0(new C2.g() { // from class: j$.util.stream.Y0
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

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public final void accept(long j) {
                e.accept(j);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Long l) {
                S1.c(this, l);
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e2) {
                e2.getClass();
                return new C0099j(this, e2);
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

    @Override // j$.util.Spliterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.r.c(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean n(j$.util.function.E e) {
        e.getClass();
        boolean zA = a();
        if (zA) {
            U2.d dVar = (U2.d) this.h;
            long j = this.g;
            int iV = dVar.v(j);
            e.accept((dVar.c == 0 && iV == 0) ? ((long[]) dVar.e)[(int) j] : ((long[][]) dVar.f)[iV][(int) (j - dVar.d[iV])]);
        }
        return zA;
    }

    @Override // j$.util.stream.Y2
    void j() {
        final U2.d dVar = new U2.d();
        this.h = dVar;
        this.e = this.b.t0(new C2.g() { // from class: j$.util.stream.p0
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

            @Override // j$.util.stream.C2.g, j$.util.stream.C2
            public final void accept(long j) {
                dVar.accept(j);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Long l) {
                S1.c(this, l);
            }

            @Override // j$.util.function.E
            public j$.util.function.E f(j$.util.function.E e) {
                e.getClass();
                return new C0099j(this, e);
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
        this.f = new j$.util.function.q() { // from class: j$.util.stream.C0
            @Override // j$.util.function.q
            public final boolean a() {
                d3 d3Var = this.a;
                return d3Var.d.b(d3Var.e);
            }
        };
    }

    @Override // j$.util.stream.Y2
    Y2 k(Spliterator spliterator) {
        return new d3(this.b, spliterator, this.a);
    }

    @Override // j$.util.stream.Y2, j$.util.Spliterator
    public Spliterator.c trySplit() {
        return (Spliterator.c) super.trySplit();
    }
}
