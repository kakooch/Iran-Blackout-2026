package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class oe implements pp {
    private final int a;
    private final List<cy> b;

    public oe() {
        this(null);
    }

    public oe(int i, List<cy> list) {
        this.a = i;
        this.b = list;
    }

    private final pf c(po poVar) {
        return new pf(e(poVar));
    }

    private final ps d(po poVar) {
        return new ps(e(poVar));
    }

    private final List<cy> e(po poVar) {
        String str;
        int i;
        List<byte[]> listSingletonList;
        if (f(32)) {
            return this.b;
        }
        aee aeeVar = new aee(poVar.d);
        List<cy> arrayList = this.b;
        while (aeeVar.d() > 0) {
            int iN = aeeVar.n();
            int iG = aeeVar.g() + aeeVar.n();
            if (iN == 134) {
                arrayList = new ArrayList<>();
                int iN2 = aeeVar.n() & 31;
                for (int i2 = 0; i2 < iN2; i2++) {
                    String strE = aeeVar.E(3);
                    int iN3 = aeeVar.n();
                    int i3 = iN3 & 128;
                    if (i3 != 0) {
                        i = iN3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bN = (byte) aeeVar.n();
                    aeeVar.k(1);
                    if (i3 != 0) {
                        int i4 = adl.a;
                        listSingletonList = Collections.singletonList((bN & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    cx cxVar = new cx();
                    cxVar.ae(str);
                    cxVar.V(strE);
                    cxVar.F(i);
                    cxVar.T(listSingletonList);
                    arrayList.add(cxVar.a());
                }
            }
            aeeVar.h(iG);
        }
        return arrayList;
    }

    private final boolean f(int i) {
        return (i & this.a) != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pp
    public final SparseArray<pr> a() {
        return new SparseArray<>();
    }

    public oe(byte[] bArr) {
        this(0, arn.i());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pp
    public final pr b(int i, po poVar) {
        if (i == 2) {
            return new ox(new oj(d(poVar)));
        }
        if (i == 3 || i == 4) {
            return new ox(new ou(poVar.b));
        }
        if (i == 21) {
            return new ox(new os());
        }
        if (i == 27) {
            if (f(4)) {
                return null;
            }
            return new ox(new op(c(poVar), f(1), f(8)));
        }
        if (i == 36) {
            return new ox(new or(c(poVar)));
        }
        if (i == 89) {
            return new ox(new og(poVar.c));
        }
        if (i != 138) {
            if (i == 172) {
                return new ox(new oa(poVar.b));
            }
            if (i == 257) {
                return new pe(new ow("application/vnd.dvb.ait"));
            }
            if (i != 129) {
                if (i != 130) {
                    if (i == 134) {
                        if (f(16)) {
                            return null;
                        }
                        return new pe(new ow("application/x-scte35"));
                    }
                    if (i != 135) {
                        switch (i) {
                            case 15:
                                if (!f(2)) {
                                    break;
                                }
                                break;
                            case 17:
                                if (!f(2)) {
                                    break;
                                }
                                break;
                        }
                        return null;
                    }
                } else if (!f(64)) {
                    return null;
                }
            }
            return new ox(new nx(poVar.b));
        }
        return new ox(new of(poVar.b));
    }
}
