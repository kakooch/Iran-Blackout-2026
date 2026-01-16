package j$.time.format;

import j$.time.l;
import j$.time.temporal.k;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.q;

/* loaded from: classes2.dex */
class d implements k {
    final /* synthetic */ j$.time.chrono.b a;
    final /* synthetic */ k b;
    final /* synthetic */ j$.time.chrono.h c;
    final /* synthetic */ l d;

    d(j$.time.chrono.b bVar, k kVar, j$.time.chrono.h hVar, l lVar) {
        this.a = bVar;
        this.b = kVar;
        this.c = hVar;
        this.d = lVar;
    }

    @Override // j$.time.temporal.k
    public boolean d(j$.time.temporal.l lVar) {
        return (this.a == null || !lVar.v()) ? this.b.d(lVar) : this.a.d(lVar);
    }

    @Override // j$.time.temporal.k
    public /* synthetic */ int h(j$.time.temporal.l lVar) {
        return j$.time.a.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(j$.time.temporal.l lVar) {
        return ((this.a == null || !lVar.v()) ? this.b : this.a).j(lVar);
    }

    @Override // j$.time.temporal.k
    public long l(j$.time.temporal.l lVar) {
        return ((this.a == null || !lVar.v()) ? this.b : this.a).l(lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(n nVar) {
        int i = m.a;
        return nVar == j$.time.temporal.b.a ? this.c : nVar == j$.time.temporal.d.a ? this.d : nVar == j$.time.temporal.e.a ? this.b.n(nVar) : nVar.a(this);
    }
}
