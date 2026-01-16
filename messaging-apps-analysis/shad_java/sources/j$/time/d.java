package j$.time;

import j$.time.temporal.o;
import j$.time.temporal.t;
import j$.time.temporal.u;
import j$.time.temporal.w;
import j$.time.temporal.x;

/* loaded from: classes2.dex */
public enum d implements j$.time.temporal.k {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final d[] a = values();

    public static d g(int i) {
        if (i >= 1 && i <= 7) {
            return a[i - 1];
        }
        throw new c("Invalid value for DayOfWeek: " + i);
    }

    @Override // j$.time.temporal.k
    public int a(j$.time.temporal.l lVar) {
        return lVar == j$.time.temporal.a.DAY_OF_WEEK ? f() : j$.time.temporal.j.a(this, lVar);
    }

    @Override // j$.time.temporal.k
    public x b(j$.time.temporal.l lVar) {
        return lVar == j$.time.temporal.a.DAY_OF_WEEK ? lVar.a() : j$.time.temporal.j.c(this, lVar);
    }

    @Override // j$.time.temporal.k
    public long c(j$.time.temporal.l lVar) {
        if (lVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return f();
        }
        if (!(lVar instanceof j$.time.temporal.a)) {
            return lVar.c(this);
        }
        throw new w("Unsupported field: " + lVar);
    }

    @Override // j$.time.temporal.k
    public Object d(u uVar) {
        int i = t.a;
        return uVar == o.a ? j$.time.temporal.b.DAYS : j$.time.temporal.j.b(this, uVar);
    }

    @Override // j$.time.temporal.k
    public boolean e(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.a ? lVar == j$.time.temporal.a.DAY_OF_WEEK : lVar != null && lVar.d(this);
    }

    public int f() {
        return ordinal() + 1;
    }
}
