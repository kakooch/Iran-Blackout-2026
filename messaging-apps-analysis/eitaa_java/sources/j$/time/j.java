package j$.time;

import j$.time.temporal.p;
import j$.time.temporal.q;

/* loaded from: classes2.dex */
public enum j implements j$.time.temporal.k {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    private static final j[] a = values();

    public static j w(int i) {
        if (i >= 1 && i <= 12) {
            return a[i - 1];
        }
        throw new c("Invalid value for MonthOfYear: " + i);
    }

    @Override // j$.time.temporal.k
    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.MONTH_OF_YEAR : lVar != null && lVar.n(this);
    }

    @Override // j$.time.temporal.k
    public int h(j$.time.temporal.l lVar) {
        return lVar == j$.time.temporal.h.MONTH_OF_YEAR ? v() : a.f(this, lVar);
    }

    @Override // j$.time.temporal.k
    public q j(j$.time.temporal.l lVar) {
        return lVar == j$.time.temporal.h.MONTH_OF_YEAR ? lVar.h() : a.k(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long l(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.h.MONTH_OF_YEAR) {
            return v();
        }
        if (!(lVar instanceof j$.time.temporal.h)) {
            return lVar.l(this);
        }
        throw new p("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        return nVar == j$.time.temporal.b.a ? j$.time.chrono.i.a : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.MONTHS : a.j(this, nVar);
    }

    public int t(boolean z) {
        int i;
        switch (this) {
            case JANUARY:
                return 1;
            case FEBRUARY:
                return 32;
            case MARCH:
                i = 60;
                break;
            case APRIL:
                i = 91;
                break;
            case MAY:
                i = 121;
                break;
            case JUNE:
                i = 152;
                break;
            case JULY:
                i = 182;
                break;
            case AUGUST:
                i = 213;
                break;
            case SEPTEMBER:
                i = 244;
                break;
            case OCTOBER:
                i = 274;
                break;
            case NOVEMBER:
                i = 305;
                break;
            default:
                i = 335;
                break;
        }
        return (z ? 1 : 0) + i;
    }

    public int v() {
        return ordinal() + 1;
    }

    public j x(long j) {
        return a[((((int) (j % 12)) + 12) + ordinal()) % 12];
    }
}
