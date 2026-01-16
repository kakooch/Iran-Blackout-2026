package j$.time;

import ir.eitaa.messenger.MediaController;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class f implements Comparable<f>, Serializable, Serializable {
    public static final f a = new f(0, 0);
    private final long b;
    private final int c;

    static {
        z(-31557014167219200L, 0L);
        z(31556889864403199L, 999999999L);
    }

    private f(long j, int i) {
        this.b = j;
        this.c = i;
    }

    private static f v(long j, int i) {
        if ((i | j) == 0) {
            return a;
        }
        if (j < -31557014167219200L || j > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new f(j, i);
    }

    public static f y(long j) {
        return v(a.A(j, 1000L), ((int) a.z(j, 1000L)) * MediaController.VIDEO_BITRATE_480);
    }

    public static f z(long j, long j2) {
        return v(a.w(j, a.A(j2, 1000000000L)), (int) a.z(j2, 1000000000L));
    }

    public long A() {
        long jB;
        int i;
        long j = this.b;
        if (j >= 0 || this.c <= 0) {
            jB = a.B(j, 1000L);
            i = this.c / MediaController.VIDEO_BITRATE_480;
        } else {
            jB = a.B(j + 1, 1000L);
            i = (this.c / MediaController.VIDEO_BITRATE_480) - 1000;
        }
        return a.w(jB, i);
    }

    @Override // java.lang.Comparable
    public int compareTo(f fVar) {
        f fVar2 = fVar;
        int i = (this.b > fVar2.b ? 1 : (this.b == fVar2.b ? 0 : -1));
        return i != 0 ? i : this.c - fVar2.c;
    }

    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.INSTANT_SECONDS || lVar == j$.time.temporal.h.NANO_OF_SECOND || lVar == j$.time.temporal.h.MICRO_OF_SECOND || lVar == j$.time.temporal.h.MILLI_OF_SECOND : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.b == fVar.b && this.c == fVar.c;
    }

    public int h(j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return a.k(this, lVar).a(lVar.l(this), lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal == 0) {
            return this.c;
        }
        if (iOrdinal == 2) {
            return this.c / 1000;
        }
        if (iOrdinal == 4) {
            return this.c / MediaController.VIDEO_BITRATE_480;
        }
        if (iOrdinal == 28) {
            j$.time.temporal.h.INSTANT_SECONDS.w(this.b);
        }
        throw new p("Unsupported field: " + lVar);
    }

    public int hashCode() {
        long j = this.b;
        return (this.c * 51) + ((int) (j ^ (j >>> 32)));
    }

    public q j(j$.time.temporal.l lVar) {
        return a.k(this, lVar);
    }

    public long l(j$.time.temporal.l lVar) {
        int i;
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal == 0) {
            i = this.c;
        } else if (iOrdinal == 2) {
            i = this.c / 1000;
        } else {
            if (iOrdinal != 4) {
                if (iOrdinal == 28) {
                    return this.b;
                }
                throw new p("Unsupported field: " + lVar);
            }
            i = this.c / MediaController.VIDEO_BITRATE_480;
        }
        return i;
    }

    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        if (nVar == j$.time.temporal.e.a) {
            return j$.time.temporal.i.NANOS;
        }
        if (nVar == j$.time.temporal.b.a || nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.a.a || nVar == j$.time.temporal.f.a) {
            return null;
        }
        return nVar.a(this);
    }

    public int t(f fVar) {
        int i = (this.b > fVar.b ? 1 : (this.b == fVar.b ? 0 : -1));
        return i != 0 ? i : this.c - fVar.c;
    }

    public String toString() {
        return j$.time.format.b.a.a(this);
    }

    public long w() {
        return this.b;
    }

    public int x() {
        return this.c;
    }
}
