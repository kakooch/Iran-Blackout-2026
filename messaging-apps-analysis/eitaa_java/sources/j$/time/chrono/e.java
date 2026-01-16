package j$.time.chrono;

import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;

/* loaded from: classes2.dex */
public final /* synthetic */ class e {
    public static int a(f fVar, f fVar2) {
        int i = (fVar.u() > fVar2.u() ? 1 : (fVar.u() == fVar2.u() ? 0 : -1));
        if (i != 0) {
            return i;
        }
        int iX = fVar.b().x() - fVar2.b().x();
        if (iX != 0) {
            return iX;
        }
        int iP = fVar.q().compareTo(fVar2.q());
        if (iP != 0) {
            return iP;
        }
        int iCompareTo = fVar.k().g().compareTo(fVar2.k().g());
        return iCompareTo == 0 ? fVar.a().compareTo(fVar2.a()) : iCompareTo;
    }

    public static int b(f fVar, l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            return j$.time.a.f(fVar, lVar);
        }
        int iOrdinal = ((j$.time.temporal.h) lVar).ordinal();
        if (iOrdinal != 28) {
            return iOrdinal != 29 ? fVar.q().h(lVar) : fVar.f().y();
        }
        throw new p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static Object c(f fVar, n nVar) {
        int i = m.a;
        return (nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.d.a) ? fVar.k() : nVar == j$.time.temporal.c.a ? fVar.f() : nVar == j$.time.temporal.f.a ? fVar.b() : nVar == j$.time.temporal.b.a ? fVar.a() : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(fVar);
    }

    public static long d(f fVar) {
        return ((fVar.c().m() * 86400) + fVar.b().C()) - fVar.f().y();
    }
}
