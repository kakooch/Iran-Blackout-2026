package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0098i;
import j$.util.function.Consumer;
import j$.util.stream.C2;
import j$.util.stream.U2;

/* loaded from: classes2.dex */
final class c3<P_IN> extends Y2<P_IN, Integer, U2.c> implements Spliterator.b {
    c3(V1 v1, Spliterator spliterator, boolean z) {
        super(v1, spliterator, z);
    }

    c3(V1 v1, j$.util.function.L l, boolean z) {
        super(v1, l, z);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return j$.util.r.f(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(final j$.util.function.y yVar) {
        if (this.h != null || this.i) {
            while (n(yVar)) {
            }
            return;
        }
        yVar.getClass();
        h();
        this.b.s0(new C2.f() { // from class: j$.util.stream.e
            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(double d) {
                j$.time.a.c(this);
                throw null;
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public final void accept(int i) {
                yVar.accept(i);
            }

            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(long j) {
                j$.time.a.b(this);
                throw null;
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Integer num) {
                S1.b(this, num);
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar2) {
                yVar2.getClass();
                return new C0098i(this, yVar2);
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
        j$.util.r.b(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean n(j$.util.function.y yVar) {
        yVar.getClass();
        boolean zA = a();
        if (zA) {
            U2.c cVar = (U2.c) this.h;
            long j = this.g;
            int iV = cVar.v(j);
            yVar.accept((cVar.c == 0 && iV == 0) ? ((int[]) cVar.e)[(int) j] : ((int[][]) cVar.f)[iV][(int) (j - cVar.d[iV])]);
        }
        return zA;
    }

    @Override // j$.util.stream.Y2
    void j() {
        final U2.c cVar = new U2.c();
        this.h = cVar;
        this.e = this.b.t0(new C2.f() { // from class: j$.util.stream.N0
            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(double d) {
                j$.time.a.c(this);
                throw null;
            }

            @Override // j$.util.stream.C2.f, j$.util.stream.C2, j$.util.function.y
            public final void accept(int i) {
                cVar.accept(i);
            }

            @Override // j$.util.stream.C2
            public /* synthetic */ void accept(long j) {
                j$.time.a.b(this);
                throw null;
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Integer num) {
                S1.b(this, num);
            }

            @Override // j$.util.function.y
            public j$.util.function.y k(j$.util.function.y yVar) {
                yVar.getClass();
                return new C0098i(this, yVar);
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
        this.f = new j$.util.function.q() { // from class: j$.util.stream.B0
            @Override // j$.util.function.q
            public final boolean a() {
                c3 c3Var = this.a;
                return c3Var.d.b(c3Var.e);
            }
        };
    }

    @Override // j$.util.stream.Y2
    Y2 k(Spliterator spliterator) {
        return new c3(this.b, spliterator, this.a);
    }

    @Override // j$.util.stream.Y2, j$.util.Spliterator
    public Spliterator.b trySplit() {
        return (Spliterator.b) super.trySplit();
    }
}
