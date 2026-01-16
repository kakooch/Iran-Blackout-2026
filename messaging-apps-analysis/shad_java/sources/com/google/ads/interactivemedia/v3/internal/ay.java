package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ay extends es {
    private final int b;
    private final ve c;

    public ay(ve veVar) {
        this.c = veVar;
        this.b = veVar.a();
    }

    public static Object a(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object b(Object obj) {
        return ((Pair) obj).second;
    }

    private final int r(int i, boolean z) {
        if (z) {
            return this.c.b(i);
        }
        if (i >= this.b - 1) {
            return -1;
        }
        return i + 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int c(int i, int i2, boolean z) {
        int iL = l(i);
        int iP = p(iL);
        int iC = n(iL).c(i - iP, i2 == 2 ? 0 : i2, z);
        if (iC != -1) {
            return iP + iC;
        }
        int iR = r(iL, z);
        while (iR != -1 && n(iR).u()) {
            iR = r(iR, z);
        }
        if (iR != -1) {
            return p(iR) + n(iR).e(z);
        }
        if (i2 == 2) {
            return e(z);
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int d(boolean z) {
        int i = this.b;
        if (i == 0) {
            return -1;
        }
        int iD = z ? this.c.d() : i - 1;
        while (n(iD).u()) {
            iD = z ? this.c.c(iD) : iD > 0 ? iD - 1 : -1;
            if (iD == -1) {
                return -1;
            }
        }
        return p(iD) + n(iD).d(z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int e(boolean z) {
        if (this.b == 0) {
            return -1;
        }
        int iE = z ? this.c.e() : 0;
        while (n(iE).u()) {
            iE = r(iE, z);
            if (iE == -1) {
                return -1;
            }
        }
        return p(iE) + n(iE).e(z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final er f(int i, er erVar, long j) {
        int iL = l(i);
        int iP = p(iL);
        int iO = o(iL);
        n(iL).f(i - iP, erVar, j);
        Object objQ = q(iL);
        if (!er.a.equals(erVar.b)) {
            objQ = Pair.create(objQ, erVar.b);
        }
        erVar.b = objQ;
        erVar.l += iO;
        erVar.m += iO;
        return erVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final eq g(Object obj, eq eqVar) {
        Object objA = a(obj);
        Object objB = b(obj);
        int iM = m(objA);
        int iP = p(iM);
        n(iM).g(objB, eqVar);
        eqVar.c += iP;
        eqVar.b = obj;
        return eqVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final eq h(int i, eq eqVar, boolean z) {
        int iK = k(i);
        int iP = p(iK);
        n(iK).h(i - o(iK), eqVar, z);
        eqVar.c += iP;
        if (z) {
            Object objQ = q(iK);
            Object obj = eqVar.b;
            ary.t(obj);
            eqVar.b = Pair.create(objQ, obj);
        }
        return eqVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final int i(Object obj) {
        int i;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objA = a(obj);
        Object objB = b(obj);
        int iM = m(objA);
        if (iM == -1 || (i = n(iM).i(objB)) == -1) {
            return -1;
        }
        return o(iM) + i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.es
    public final Object j(int i) {
        int iK = k(i);
        return Pair.create(q(iK), n(iK).j(i - o(iK)));
    }

    protected abstract int k(int i);

    protected abstract int l(int i);

    protected abstract int m(Object obj);

    protected abstract es n(int i);

    protected abstract int o(int i);

    protected abstract int p(int i);

    protected abstract Object q(int i);
}
