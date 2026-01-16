package j$.time;

import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class g implements j$.time.temporal.k, j$.time.chrono.b, Serializable {
    public static final g a = B(-999999999, 1, 1);
    public static final g b = B(999999999, 12, 31);
    private final int c;
    private final short d;
    private final short e;

    private g(int i, int i2, int i3) {
        this.c = i;
        this.d = (short) i2;
        this.e = (short) i3;
    }

    public static g B(int i, int i2, int i3) {
        long j = i;
        j$.time.temporal.h.YEAR.x(j);
        j$.time.temporal.h.MONTH_OF_YEAR.x(i2);
        j$.time.temporal.h.DAY_OF_MONTH.x(i3);
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (j$.time.chrono.i.a.h(j)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                StringBuilder sbA = j$.com.android.tools.r8.a.a("Invalid date '");
                sbA.append(j.w(i2).name());
                sbA.append(" ");
                sbA.append(i3);
                sbA.append("'");
                throw new c(sbA.toString());
            }
        }
        return new g(i, i2, i3);
    }

    public static g C(long j) {
        long j2;
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new g(j$.time.temporal.h.YEAR.w(j5 + j2 + (i2 / 10)), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static g v(j$.time.temporal.k kVar) {
        if (kVar == null) {
            throw new NullPointerException("temporal");
        }
        int i = j$.time.temporal.m.a;
        g gVar = (g) kVar.n(j$.time.temporal.a.a);
        if (gVar != null) {
            return gVar;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName());
    }

    private int w(j$.time.temporal.l lVar) {
        switch (((j$.time.temporal.h) lVar).ordinal()) {
            case 15:
                return x().t();
            case 16:
                return ((this.e - 1) % 7) + 1;
            case 17:
                return ((y() - 1) % 7) + 1;
            case 18:
                return this.e;
            case 19:
                return y();
            case 20:
                throw new p("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 21:
                return ((this.e - 1) / 7) + 1;
            case 22:
                return ((y() - 1) / 7) + 1;
            case 23:
                return this.d;
            case 24:
                throw new p("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 25:
                int i = this.c;
                return i >= 1 ? i : 1 - i;
            case 26:
                return this.c;
            case 27:
                return this.c >= 1 ? 1 : 0;
            default:
                throw new p("Unsupported field: " + lVar);
        }
    }

    public boolean A() {
        return j$.time.chrono.i.a.h(this.c);
    }

    public g D(long j) {
        int i;
        if (j == 0) {
            return this;
        }
        int iW = j$.time.temporal.h.YEAR.w(this.c + j);
        short s = this.d;
        int iMin = this.e;
        if (s != 2) {
            if (s == 4 || s == 6 || s == 9 || s == 11) {
                i = 30;
            }
            return new g(iW, s, iMin);
        }
        i = j$.time.chrono.i.a.h((long) iW) ? 29 : 28;
        iMin = Math.min(iMin, i);
        return new g(iW, s, iMin);
    }

    public g E(int i) {
        if (y() == i) {
            return this;
        }
        int i2 = this.c;
        long j = i2;
        j$.time.temporal.h.YEAR.x(j);
        j$.time.temporal.h.DAY_OF_YEAR.x(i);
        boolean zH = j$.time.chrono.i.a.h(j);
        if (i == 366 && !zH) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
        }
        int i3 = 31;
        j jVarW = j.w(((i - 1) / 31) + 1);
        int iT = jVarW.t(zH);
        int iOrdinal = jVarW.ordinal();
        if (iOrdinal == 1) {
            i3 = zH ? 29 : 28;
        } else if (iOrdinal == 3 || iOrdinal == 5 || iOrdinal == 8 || iOrdinal == 10) {
            i3 = 30;
        }
        if (i > (iT + i3) - 1) {
            jVarW = jVarW.x(1L);
        }
        return new g(i2, jVarW.v(), (i - jVarW.t(zH)) + 1);
    }

    @Override // j$.time.chrono.b
    public j$.time.chrono.h a() {
        return j$.time.chrono.i.a;
    }

    @Override // j$.time.temporal.k
    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar.v() : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && t((g) obj) == 0;
    }

    @Override // j$.time.temporal.k
    public int h(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? w(lVar) : a.f(this, lVar);
    }

    public int hashCode() {
        int i = this.c;
        return (((i << 11) + (this.d << 6)) + this.e) ^ (i & (-2048));
    }

    @Override // j$.time.temporal.k
    public q j(j$.time.temporal.l lVar) {
        int i;
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.t(this);
        }
        j$.time.temporal.h hVar = (j$.time.temporal.h) lVar;
        if (!hVar.v()) {
            throw new p("Unsupported field: " + lVar);
        }
        int iOrdinal = hVar.ordinal();
        if (iOrdinal == 18) {
            short s = this.d;
            i = s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : A() ? 29 : 28;
        } else {
            if (iOrdinal != 19) {
                if (iOrdinal == 21) {
                    return q.i(1L, (j.w(this.d) != j.FEBRUARY || A()) ? 5L : 4L);
                }
                if (iOrdinal != 25) {
                    return lVar.h();
                }
                return q.i(1L, this.c <= 0 ? 1000000000L : 999999999L);
            }
            i = A() ? 366 : 365;
        }
        return q.i(1L, i);
    }

    @Override // j$.time.temporal.k
    public long l(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.EPOCH_DAY ? m() : lVar == j$.time.temporal.h.PROLEPTIC_MONTH ? ((this.c * 12) + this.d) - 1 : w(lVar) : lVar.l(this);
    }

    @Override // j$.time.chrono.b
    public long m() {
        long j;
        long j2 = this.c;
        long j3 = this.d;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / (-400)) + ((j2 / (-4)) - (j2 / (-100))));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + (this.e - 1);
        if (j3 > 2) {
            j5--;
            if (!A()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    @Override // j$.time.temporal.k
    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        if (nVar == j$.time.temporal.a.a) {
            return this;
        }
        if (nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a || nVar == j$.time.temporal.f.a) {
            return null;
        }
        if (nVar != j$.time.temporal.b.a) {
            return nVar == j$.time.temporal.e.a ? j$.time.temporal.i.DAYS : nVar.a(this);
        }
        a();
        return j$.time.chrono.i.a;
    }

    @Override // java.lang.Comparable
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public int compareTo(j$.time.chrono.b bVar) {
        if (bVar instanceof g) {
            return t((g) bVar);
        }
        int i = (m() > bVar.m() ? 1 : (m() == bVar.m() ? 0 : -1));
        if (i != 0) {
            return i;
        }
        a();
        return j$.time.chrono.i.a.compareTo(bVar.a());
    }

    int t(g gVar) {
        int i = this.c - gVar.c;
        if (i != 0) {
            return i;
        }
        int i2 = this.d - gVar.d;
        return i2 == 0 ? this.e - gVar.e : i2;
    }

    public String toString() {
        int i;
        int i2 = this.c;
        short s = this.d;
        short s2 = this.e;
        int iAbs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs < 1000) {
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 >= 10 ? "-" : "-0");
        sb.append((int) s2);
        return sb.toString();
    }

    public d x() {
        return d.v(((int) a.z(m() + 3, 7L)) + 1);
    }

    public int y() {
        return (j.w(this.d).t(A()) + this.e) - 1;
    }

    public int z() {
        return this.c;
    }
}
