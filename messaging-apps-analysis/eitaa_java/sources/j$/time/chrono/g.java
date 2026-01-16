package j$.time.chrono;

import j$.time.chrono.b;
import j$.time.l;
import j$.time.m;
import j$.time.temporal.n;
import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
final class g<D extends b> implements f<D>, Serializable {
    private final transient d a;
    private final transient m b;
    private final transient l c;

    private g(d dVar, m mVar, l lVar) {
        if (dVar == null) {
            throw new NullPointerException("dateTime");
        }
        this.a = dVar;
        this.b = mVar;
        this.c = lVar;
    }

    static g t(h hVar, j$.time.f fVar, l lVar) {
        m mVarC = lVar.t().c(fVar);
        j$.time.a.x(mVarC, "offset");
        return new g((d) hVar.o(j$.time.h.A(fVar.w(), fVar.x(), mVarC)), mVarC, lVar);
    }

    @Override // j$.time.chrono.f
    public h a() {
        c();
        throw null;
    }

    @Override // j$.time.chrono.f
    public j$.time.i b() {
        return ((d) q()).b();
    }

    @Override // j$.time.chrono.f
    public b c() {
        return ((d) q()).c();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(f<?> fVar) {
        return e.a(this, fVar);
    }

    public boolean d(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && e.a(this, (f) obj) == 0;
    }

    @Override // j$.time.chrono.f
    public m f() {
        return this.b;
    }

    public /* synthetic */ int h(j$.time.temporal.l lVar) {
        return e.b(this, lVar);
    }

    public int hashCode() {
        this.a.getClass();
        throw null;
    }

    public q j(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : ((d) q()).j(lVar) : lVar.t(this);
    }

    @Override // j$.time.chrono.f
    public l k() {
        return this.c;
    }

    public long l(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        return iOrdinal != 28 ? iOrdinal != 29 ? ((d) q()).l(lVar) : f().y() : u();
    }

    public /* synthetic */ Object n(n nVar) {
        return e.c(this, nVar);
    }

    @Override // j$.time.chrono.f
    public c q() {
        return this.a;
    }

    public String toString() {
        this.a.getClass();
        throw null;
    }

    @Override // j$.time.chrono.f
    public /* synthetic */ long u() {
        return e.d(this);
    }
}
