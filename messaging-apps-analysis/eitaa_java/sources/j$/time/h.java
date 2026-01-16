package j$.time;

import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class h implements j$.time.chrono.c<g>, Serializable, Serializable {
    public static final h a = z(g.a, i.a);
    public static final h b = z(g.b, i.b);
    private final g c;
    private final i d;

    private h(g gVar, i iVar) {
        this.c = gVar;
        this.d = iVar;
    }

    public static h A(long j, int i, m mVar) {
        if (mVar == null) {
            throw new NullPointerException("offset");
        }
        long j2 = i;
        j$.time.temporal.h.NANO_OF_SECOND.x(j2);
        return new h(g.C(a.A(j + mVar.y(), 86400L)), i.A((((int) a.z(r5, 86400L)) * 1000000000) + j2));
    }

    public static h v(j$.time.temporal.k kVar) {
        if (kVar instanceof h) {
            return (h) kVar;
        }
        if (kVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) kVar).v();
        }
        if (kVar instanceof k) {
            return ((k) kVar).v();
        }
        try {
            return new h(g.v(kVar), i.v(kVar));
        } catch (c e) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName(), e);
        }
    }

    public static h y(int i, int i2, int i3, int i4, int i5) {
        return new h(g.B(i, i2, i3), i.z(i4, i5));
    }

    public static h z(g gVar, i iVar) {
        if (gVar == null) {
            throw new NullPointerException("date");
        }
        if (iVar != null) {
            return new h(gVar, iVar);
        }
        throw new NullPointerException("time");
    }

    public /* synthetic */ long B(m mVar) {
        return a.l(this, mVar);
    }

    public g C() {
        return this.c;
    }

    @Override // j$.time.chrono.c
    public j$.time.chrono.h a() {
        this.c.getClass();
        return j$.time.chrono.i.a;
    }

    @Override // j$.time.chrono.c
    public i b() {
        return this.d;
    }

    @Override // j$.time.chrono.c
    public j$.time.chrono.b c() {
        return this.c;
    }

    public boolean d(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar != null && lVar.n(this);
        }
        j$.time.temporal.h hVar = (j$.time.temporal.h) lVar;
        return hVar.v() || hVar.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.c.equals(hVar.c) && this.d.equals(hVar.d);
    }

    public int h(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? ((j$.time.temporal.h) lVar).j() ? this.d.h(lVar) : this.c.h(lVar) : a.f(this, lVar);
    }

    public int hashCode() {
        return this.c.hashCode() ^ this.d.hashCode();
    }

    public q j(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.t(this);
        }
        if (!((j$.time.temporal.h) lVar).j()) {
            return this.c.j(lVar);
        }
        i iVar = this.d;
        iVar.getClass();
        return a.k(iVar, lVar);
    }

    public long l(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? ((j$.time.temporal.h) lVar).j() ? this.d.l(lVar) : this.c.l(lVar) : lVar.l(this);
    }

    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        return nVar == j$.time.temporal.a.a ? this.c : a.i(this, nVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(j$.time.chrono.c cVar) {
        if (!(cVar instanceof h)) {
            return a.d(this, cVar);
        }
        h hVar = (h) cVar;
        int iT = this.c.t(hVar.c);
        return iT == 0 ? this.d.compareTo(hVar.d) : iT;
    }

    public k t(m mVar) {
        return k.t(this, mVar);
    }

    public String toString() {
        return this.c.toString() + 'T' + this.d.toString();
    }

    public int w() {
        return this.d.y();
    }

    public int x() {
        return this.c.z();
    }
}
