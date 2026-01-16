package j$.time;

import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.chrono.f<g>, Serializable, Serializable {
    private final h a;
    private final m b;
    private final l c;

    private ZonedDateTime(h hVar, m mVar, l lVar) {
        this.a = hVar;
        this.b = mVar;
        this.c = lVar;
    }

    public static ZonedDateTime t(f fVar, l lVar) {
        if (fVar == null) {
            throw new NullPointerException("instant");
        }
        if (lVar == null) {
            throw new NullPointerException("zone");
        }
        long jW = fVar.w();
        int iX = fVar.x();
        m mVarC = lVar.t().c(f.z(jW, iX));
        return new ZonedDateTime(h.A(jW, iX, mVarC), mVarC, lVar);
    }

    @Override // j$.time.chrono.f
    public j$.time.chrono.h a() {
        ((g) c()).getClass();
        return j$.time.chrono.i.a;
    }

    @Override // j$.time.chrono.f
    public i b() {
        return this.a.b();
    }

    @Override // j$.time.chrono.f
    public j$.time.chrono.b c() {
        return this.a.C();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(j$.time.chrono.f<?> fVar) {
        return j$.time.chrono.e.a(this, fVar);
    }

    public boolean d(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.a.equals(zonedDateTime.a) && this.b.equals(zonedDateTime.b) && this.c.equals(zonedDateTime.c);
    }

    @Override // j$.time.chrono.f
    public m f() {
        return this.b;
    }

    public int h(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return j$.time.chrono.e.b(this, lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal != 28) {
            return iOrdinal != 29 ? this.a.h(lVar) : this.b.y();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    public q j(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : this.a.j(lVar) : lVar.t(this);
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
        return iOrdinal != 28 ? iOrdinal != 29 ? this.a.l(lVar) : this.b.y() : j$.time.chrono.e.d(this);
    }

    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        return nVar == j$.time.temporal.a.a ? this.a.C() : j$.time.chrono.e.c(this, nVar);
    }

    @Override // j$.time.chrono.f
    public j$.time.chrono.c q() {
        return this.a;
    }

    public String toString() {
        String str = this.a.toString() + this.b.toString();
        if (this.b == this.c) {
            return str;
        }
        return str + '[' + this.c.toString() + ']';
    }

    @Override // j$.time.chrono.f
    public /* synthetic */ long u() {
        return j$.time.chrono.e.d(this);
    }

    public h v() {
        return this.a;
    }
}
