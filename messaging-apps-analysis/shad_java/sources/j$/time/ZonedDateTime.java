package j$.time;

import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;
import j$.time.temporal.w;
import j$.time.temporal.x;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.chrono.f, Serializable, Serializable {
    private final LocalDateTime a;
    private final ZoneOffset b;
    private final l c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j$.time.temporal.a.values().length];
            a = iArr;
            try {
                iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, l lVar) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = lVar;
    }

    public static ZonedDateTime i(Instant instant, l lVar) {
        if (instant == null) {
            throw new NullPointerException("instant");
        }
        if (lVar == null) {
            throw new NullPointerException("zone");
        }
        long jH = instant.h();
        int i = instant.i();
        ZoneOffset zoneOffsetC = lVar.g().c(Instant.k(jH, i));
        return new ZonedDateTime(LocalDateTime.l(jH, i, zoneOffsetC), zoneOffsetC, lVar);
    }

    @Override // j$.time.temporal.k
    public int a(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return j$.time.chrono.d.a(this, lVar);
        }
        int i = a.a[((j$.time.temporal.a) lVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.a(lVar) : this.b.k();
        }
        throw new w("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    @Override // j$.time.temporal.k
    public x b(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.a ? (lVar == j$.time.temporal.a.INSTANT_SECONDS || lVar == j$.time.temporal.a.OFFSET_SECONDS) ? lVar.a() : this.a.b(lVar) : lVar.e(this);
    }

    @Override // j$.time.temporal.k
    public long c(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return lVar.c(this);
        }
        int i = a.a[((j$.time.temporal.a) lVar).ordinal()];
        return i != 1 ? i != 2 ? this.a.c(lVar) : this.b.k() : j();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        ZonedDateTime zonedDateTime = (ZonedDateTime) ((j$.time.chrono.f) obj);
        int i = (j() > zonedDateTime.j() ? 1 : (j() == zonedDateTime.j() ? 0 : -1));
        if (i != 0) {
            return i;
        }
        int iH = m().h() - zonedDateTime.m().h();
        if (iH != 0) {
            return iH;
        }
        int iF = ((LocalDateTime) l()).compareTo(zonedDateTime.l());
        if (iF != 0) {
            return iF;
        }
        int iCompareTo = h().f().compareTo(zonedDateTime.h().f());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        f();
        j$.time.chrono.h hVar = j$.time.chrono.h.a;
        zonedDateTime.f();
        return 0;
    }

    @Override // j$.time.temporal.k
    public Object d(u uVar) {
        int i = t.a;
        if (uVar == r.a) {
            return this.a.n();
        }
        if (uVar == q.a || uVar == j$.time.temporal.m.a) {
            return this.c;
        }
        if (uVar == p.a) {
            return this.b;
        }
        if (uVar == s.a) {
            return m();
        }
        if (uVar != n.a) {
            return uVar == o.a ? j$.time.temporal.b.NANOS : uVar.a(this);
        }
        f();
        return j$.time.chrono.h.a;
    }

    @Override // j$.time.temporal.k
    public boolean e(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.a) || (lVar != null && lVar.d(this));
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

    public j$.time.chrono.g f() {
        ((g) k()).getClass();
        return j$.time.chrono.h.a;
    }

    public ZoneOffset g() {
        return this.b;
    }

    public l h() {
        return this.c;
    }

    public int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    public long j() {
        return ((((g) k()).q() * 86400) + m().m()) - g().k();
    }

    public j$.time.chrono.b k() {
        return this.a.n();
    }

    public j$.time.chrono.c l() {
        return this.a;
    }

    public i m() {
        return this.a.p();
    }

    public String toString() {
        String str = this.a.toString() + this.b.toString();
        if (this.b == this.c) {
            return str;
        }
        return str + '[' + this.c.toString() + ']';
    }
}
