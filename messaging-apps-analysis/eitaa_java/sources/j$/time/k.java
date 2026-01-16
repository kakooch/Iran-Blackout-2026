package j$.time;

import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class k implements Comparable<k>, Serializable, Serializable {
    private final h a;
    private final m b;

    static {
        h.a.t(m.f);
        h.b.t(m.e);
    }

    private k(h hVar, m mVar) {
        if (hVar == null) {
            throw new NullPointerException("dateTime");
        }
        this.a = hVar;
        if (mVar == null) {
            throw new NullPointerException("offset");
        }
        this.b = mVar;
    }

    public static k t(h hVar, m mVar) {
        return new k(hVar, mVar);
    }

    public i b() {
        return this.a.b();
    }

    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        int iX;
        k kVar2 = kVar;
        if (this.b.equals(kVar2.b)) {
            iX = this.a.compareTo(kVar2.a);
        } else {
            iX = (u() > kVar2.u() ? 1 : (u() == kVar2.u() ? 0 : -1));
            if (iX == 0) {
                iX = b().x() - kVar2.b().x();
            }
        }
        return iX == 0 ? this.a.compareTo(kVar2.a) : iX;
    }

    public boolean d(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.h) || (lVar != null && lVar.n(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a.equals(kVar.a) && this.b.equals(kVar.b);
    }

    public int h(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return a.f(this, lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal != 28) {
            return iOrdinal != 29 ? this.a.h(lVar) : this.b.y();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public q j(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? (lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.OFFSET_SECONDS) ? lVar.h() : this.a.j(lVar) : lVar.t(this);
    }

    public long l(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        return iOrdinal != 28 ? iOrdinal != 29 ? this.a.l(lVar) : this.b.y() : u();
    }

    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        if (nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.g.a) {
            return this.b;
        }
        if (nVar == j$.time.temporal.d.a) {
            return null;
        }
        return nVar == j$.time.temporal.a.a ? this.a.C() : nVar == j$.time.temporal.f.a ? b() : nVar == j$.time.temporal.b.a ? j$.time.chrono.i.a : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(this);
    }

    public String toString() {
        return this.a.toString() + this.b.toString();
    }

    public long u() {
        return a.l(this.a, this.b);
    }

    public h v() {
        return this.a;
    }
}
