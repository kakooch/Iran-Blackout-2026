package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0095f;
import j$.util.function.Consumer;
import j$.util.stream.C2;
import j$.util.stream.U2;

/* loaded from: classes2.dex */
final class b3<P_IN> extends Y2<P_IN, Double, U2.b> implements Spliterator.a {
    b3(V1 v1, Spliterator spliterator, boolean z) {
        super(v1, spliterator, z);
    }

    b3(V1 v1, j$.util.function.L l, boolean z) {
        super(v1, l, z);
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean b(Consumer consumer) {
        return j$.util.r.e(this, consumer);
    }

    @Override // j$.util.Spliterator.d
    public void e(final j$.util.function.s sVar) {
        if (this.h != null || this.i) {
            while (n(sVar)) {
            }
            return;
        }
        sVar.getClass();
        h();
        this.b.s0(new C2.e() { // from class: j$.util.stream.n0
            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public final void accept(double d) {
                sVar.accept(d);
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
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Double d) {
                S1.a(this, d);
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar2) {
                sVar2.getClass();
                return new C0095f(this, sVar2);
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
        j$.util.r.a(this, consumer);
    }

    @Override // j$.util.stream.Y2
    void j() {
        final U2.b bVar = new U2.b();
        this.h = bVar;
        this.e = this.b.t0(new C2.e() { // from class: j$.util.stream.W0
            @Override // j$.util.stream.C2.e, j$.util.stream.C2
            public final void accept(double d) {
                bVar.accept(d);
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
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            @Override // j$.util.function.Consumer
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void accept(Double d) {
                S1.a(this, d);
            }

            @Override // j$.util.function.s
            public j$.util.function.s j(j$.util.function.s sVar) {
                sVar.getClass();
                return new C0095f(this, sVar);
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
        this.f = new j$.util.function.q() { // from class: j$.util.stream.A0
            @Override // j$.util.function.q
            public final boolean a() {
                b3 b3Var = this.a;
                return b3Var.d.b(b3Var.e);
            }
        };
    }

    @Override // j$.util.stream.Y2
    Y2 k(Spliterator spliterator) {
        return new b3(this.b, spliterator, this.a);
    }

    @Override // j$.util.Spliterator.d
    public boolean n(j$.util.function.s sVar) {
        sVar.getClass();
        boolean zA = a();
        if (zA) {
            U2.b bVar = (U2.b) this.h;
            long j = this.g;
            int iV = bVar.v(j);
            sVar.accept((bVar.c == 0 && iV == 0) ? ((double[]) bVar.e)[(int) j] : ((double[][]) bVar.f)[iV][(int) (j - bVar.d[iV])]);
        }
        return zA;
    }

    @Override // j$.util.stream.Y2, j$.util.Spliterator
    public Spliterator.a trySplit() {
        return (Spliterator.a) super.trySplit();
    }
}
