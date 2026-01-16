package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.ShuffleOrder;
import ir.nasim.AbstractC20011rK;

/* renamed from: com.google.android.exoplayer2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2017a extends J0 {
    private final int f;
    private final ShuffleOrder g;
    private final boolean h;

    public AbstractC2017a(boolean z, ShuffleOrder shuffleOrder) {
        this.h = z;
        this.g = shuffleOrder;
        this.f = shuffleOrder.getLength();
    }

    public static Object A(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object B(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object D(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int G(int i, boolean z) {
        if (z) {
            return this.g.c(i);
        }
        if (i < this.f - 1) {
            return i + 1;
        }
        return -1;
    }

    private int H(int i, boolean z) {
        if (z) {
            return this.g.b(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    protected abstract Object C(int i);

    protected abstract int E(int i);

    protected abstract int F(int i);

    protected abstract J0 I(int i);

    @Override // com.google.android.exoplayer2.J0
    public int f(boolean z) {
        if (this.f == 0) {
            return -1;
        }
        if (this.h) {
            z = false;
        }
        int iF = z ? this.g.f() : 0;
        while (I(iF).v()) {
            iF = G(iF, z);
            if (iF == -1) {
                return -1;
            }
        }
        return F(iF) + I(iF).f(z);
    }

    @Override // com.google.android.exoplayer2.J0
    public final int g(Object obj) {
        int iG;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objB = B(obj);
        Object objA = A(obj);
        int iX = x(objB);
        if (iX == -1 || (iG = I(iX).g(objA)) == -1) {
            return -1;
        }
        return E(iX) + iG;
    }

    @Override // com.google.android.exoplayer2.J0
    public int h(boolean z) {
        int i = this.f;
        if (i == 0) {
            return -1;
        }
        if (this.h) {
            z = false;
        }
        int iD = z ? this.g.d() : i - 1;
        while (I(iD).v()) {
            iD = H(iD, z);
            if (iD == -1) {
                return -1;
            }
        }
        return F(iD) + I(iD).h(z);
    }

    @Override // com.google.android.exoplayer2.J0
    public int j(int i, int i2, boolean z) {
        if (this.h) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int iZ = z(i);
        int iF = F(iZ);
        int iJ = I(iZ).j(i - iF, i2 != 2 ? i2 : 0, z);
        if (iJ != -1) {
            return iF + iJ;
        }
        int iG = G(iZ, z);
        while (iG != -1 && I(iG).v()) {
            iG = G(iG, z);
        }
        if (iG != -1) {
            return F(iG) + I(iG).f(z);
        }
        if (i2 == 2) {
            return f(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.J0
    public final J0.b l(int i, J0.b bVar, boolean z) {
        int iY = y(i);
        int iF = F(iY);
        I(iY).l(i - E(iY), bVar, z);
        bVar.c += iF;
        if (z) {
            bVar.b = D(C(iY), AbstractC20011rK.e(bVar.b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.J0
    public final J0.b m(Object obj, J0.b bVar) {
        Object objB = B(obj);
        Object objA = A(obj);
        int iX = x(objB);
        int iF = F(iX);
        I(iX).m(objA, bVar);
        bVar.c += iF;
        bVar.b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.J0
    public int q(int i, int i2, boolean z) {
        if (this.h) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int iZ = z(i);
        int iF = F(iZ);
        int iQ = I(iZ).q(i - iF, i2 != 2 ? i2 : 0, z);
        if (iQ != -1) {
            return iF + iQ;
        }
        int iH = H(iZ, z);
        while (iH != -1 && I(iH).v()) {
            iH = H(iH, z);
        }
        if (iH != -1) {
            return F(iH) + I(iH).h(z);
        }
        if (i2 == 2) {
            return h(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.J0
    public final Object r(int i) {
        int iY = y(i);
        return D(C(iY), I(iY).r(i - E(iY)));
    }

    @Override // com.google.android.exoplayer2.J0
    public final J0.d t(int i, J0.d dVar, long j) {
        int iZ = z(i);
        int iF = F(iZ);
        int iE = E(iZ);
        I(iZ).t(i - iF, dVar, j);
        Object objC = C(iZ);
        if (!J0.d.r.equals(dVar.a)) {
            objC = D(objC, dVar.a);
        }
        dVar.a = objC;
        dVar.o += iE;
        dVar.p += iE;
        return dVar;
    }

    protected abstract int x(Object obj);

    protected abstract int y(int i);

    protected abstract int z(int i);
}
