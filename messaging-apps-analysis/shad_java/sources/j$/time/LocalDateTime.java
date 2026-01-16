package j$.time;

import j$.time.format.DateTimeFormatter;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import j$.time.temporal.x;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.chrono.c, Serializable, Serializable {
    public static final LocalDateTime c = k(g.d, i.e);
    public static final LocalDateTime d = k(g.e, i.f);
    private final g a;
    private final i b;

    private LocalDateTime(g gVar, i iVar) {
        this.a = gVar;
        this.b = iVar;
    }

    public static LocalDateTime j(int i, int i2, int i3, int i4, int i5) {
        return new LocalDateTime(g.n(i, i2, i3), i.j(i4, i5));
    }

    public static LocalDateTime k(g gVar, i iVar) {
        if (gVar == null) {
            throw new NullPointerException("date");
        }
        if (iVar != null) {
            return new LocalDateTime(gVar, iVar);
        }
        throw new NullPointerException("time");
    }

    public static LocalDateTime l(long j, int i, ZoneOffset zoneOffset) {
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        long j2 = i;
        j$.time.temporal.a.NANO_OF_SECOND.h(j2);
        return new LocalDateTime(g.o(j$.lang.d.f(j + zoneOffset.k(), 86400L)), i.k((((int) j$.lang.d.e(r5, 86400L)) * 1000000000) + j2));
    }

    @Override // j$.time.temporal.k
    public int a(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) lVar).b() ? this.b.a(lVar) : this.a.a(lVar) : j$.time.temporal.j.a(this, lVar);
    }

    @Override // j$.time.temporal.k
    public x b(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return lVar.e(this);
        }
        if (!((j$.time.temporal.a) lVar).b()) {
            return this.a.b(lVar);
        }
        i iVar = this.b;
        iVar.getClass();
        return j$.time.temporal.j.c(iVar, lVar);
    }

    @Override // j$.time.temporal.k
    public long c(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) lVar).b() ? this.b.c(lVar) : this.a.c(lVar) : lVar.c(this);
    }

    @Override // j$.time.temporal.k
    public Object d(u uVar) {
        int i = t.a;
        if (uVar == r.a) {
            return this.a;
        }
        if (uVar == j$.time.temporal.m.a || uVar == q.a || uVar == p.a) {
            return null;
        }
        if (uVar == s.a) {
            return p();
        }
        if (uVar != n.a) {
            return uVar == o.a ? j$.time.temporal.b.NANOS : uVar.a(this);
        }
        g();
        return j$.time.chrono.h.a;
    }

    @Override // j$.time.temporal.k
    public boolean e(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return lVar != null && lVar.d(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) lVar;
        return aVar.f() || aVar.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.a.equals(localDateTime.a) && this.b.equals(localDateTime.b);
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(j$.time.chrono.c cVar) {
        if (cVar instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) cVar;
            int iG = this.a.g(localDateTime.a);
            return iG == 0 ? this.b.compareTo(localDateTime.b) : iG;
        }
        LocalDateTime localDateTime2 = (LocalDateTime) cVar;
        int iCompareTo = ((g) o()).compareTo(localDateTime2.o());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iF = p().compareTo(localDateTime2.p());
        if (iF != 0) {
            return iF;
        }
        g();
        j$.time.chrono.h hVar = j$.time.chrono.h.a;
        localDateTime2.g();
        return 0;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return dateTimeFormatter.a(this);
        }
        throw new NullPointerException("formatter");
    }

    public j$.time.chrono.g g() {
        ((g) o()).getClass();
        return j$.time.chrono.h.a;
    }

    public int h() {
        return this.b.i();
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public int i() {
        return this.a.l();
    }

    public long m(ZoneOffset zoneOffset) {
        if (zoneOffset != null) {
            return ((((g) o()).q() * 86400) + p().m()) - zoneOffset.k();
        }
        throw new NullPointerException("offset");
    }

    public g n() {
        return this.a;
    }

    public j$.time.chrono.b o() {
        return this.a;
    }

    public i p() {
        return this.b;
    }

    public String toString() {
        return this.a.toString() + 'T' + this.b.toString();
    }
}
