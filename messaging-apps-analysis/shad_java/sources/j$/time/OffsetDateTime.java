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
public final class OffsetDateTime implements Comparable<OffsetDateTime>, Serializable, Serializable {
    private final LocalDateTime a;
    private final ZoneOffset b;

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

    static {
        new OffsetDateTime(LocalDateTime.c, ZoneOffset.g);
        new OffsetDateTime(LocalDateTime.d, ZoneOffset.f);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (localDateTime == null) {
            throw new NullPointerException("dateTime");
        }
        this.a = localDateTime;
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        this.b = zoneOffset;
    }

    public static OffsetDateTime f(Instant instant, l lVar) {
        if (lVar == null) {
            throw new NullPointerException("zone");
        }
        ZoneOffset zoneOffsetC = j$.time.zone.c.e((ZoneOffset) lVar).c(instant);
        return new OffsetDateTime(LocalDateTime.l(instant.h(), instant.i(), zoneOffsetC), zoneOffsetC);
    }

    public int a(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.j.a(this, lVar);
        }
        int i = a.a[((j$.time.temporal.a) lVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.a(lVar) : this.b.k();
        }
        throw new w("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public x b(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.a ? (lVar == j$.time.temporal.a.INSTANT_SECONDS || lVar == j$.time.temporal.a.OFFSET_SECONDS) ? lVar.a() : this.a.b(lVar) : lVar.e(this);
    }

    public long c(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return lVar.c(this);
        }
        int i = a.a[((j$.time.temporal.a) lVar).ordinal()];
        return i != 1 ? i != 2 ? this.a.c(lVar) : this.b.k() : g();
    }

    @Override // java.lang.Comparable
    public int compareTo(OffsetDateTime offsetDateTime) {
        int iH;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.b.equals(offsetDateTime2.b)) {
            iH = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            iH = (g() > offsetDateTime2.g() ? 1 : (g() == offsetDateTime2.g() ? 0 : -1));
            if (iH == 0) {
                iH = h().h() - offsetDateTime2.h().h();
            }
        }
        return iH == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : iH;
    }

    public Object d(u uVar) {
        int i = t.a;
        if (uVar == p.a || uVar == q.a) {
            return this.b;
        }
        if (uVar == j$.time.temporal.m.a) {
            return null;
        }
        return uVar == r.a ? this.a.n() : uVar == s.a ? h() : uVar == n.a ? j$.time.chrono.h.a : uVar == o.a ? j$.time.temporal.b.NANOS : uVar.a(this);
    }

    public boolean e(j$.time.temporal.l lVar) {
        return (lVar instanceof j$.time.temporal.a) || (lVar != null && lVar.d(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.a.equals(offsetDateTime.a) && this.b.equals(offsetDateTime.b);
    }

    public long g() {
        return this.a.m(this.b);
    }

    public i h() {
        return this.a.p();
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public LocalDateTime toLocalDateTime() {
        return this.a;
    }

    public String toString() {
        return this.a.toString() + this.b.toString();
    }
}
