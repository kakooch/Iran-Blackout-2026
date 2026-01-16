package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class BJ1 {
    private final C4705Gf0 a;
    private final C11531d98 b;

    private static final class b {
        private final C12092e16 a;
        private final C12092e16 b;
        private final int c;

        C12092e16 a() {
            return this.a;
        }

        C12092e16 b() {
            return this.b;
        }

        int c() {
            return this.c;
        }

        public String toString() {
            return this.a + Separators.SLASH + this.b + '/' + this.c;
        }

        private b(C12092e16 c12092e16, C12092e16 c12092e162, int i) {
            this.a = c12092e16;
            this.b = c12092e162;
            this.c = i;
        }
    }

    private static final class c implements Serializable, Comparator {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public BJ1(C4705Gf0 c4705Gf0) {
        this.a = c4705Gf0;
        this.b = new C11531d98(c4705Gf0);
    }

    private C12092e16 a(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164, int i) {
        float f = i;
        float fD = d(c12092e16, c12092e162) / f;
        float fD2 = d(c12092e163, c12092e164);
        C12092e16 c12092e165 = new C12092e16(c12092e164.c() + (((c12092e164.c() - c12092e163.c()) / fD2) * fD), c12092e164.d() + (fD * ((c12092e164.d() - c12092e163.d()) / fD2)));
        float fD3 = d(c12092e16, c12092e163) / f;
        float fD4 = d(c12092e162, c12092e164);
        C12092e16 c12092e166 = new C12092e16(c12092e164.c() + (((c12092e164.c() - c12092e162.c()) / fD4) * fD3), c12092e164.d() + (fD3 * ((c12092e164.d() - c12092e162.d()) / fD4)));
        if (f(c12092e165)) {
            return (f(c12092e166) && Math.abs(h(c12092e163, c12092e165).c() - h(c12092e162, c12092e165).c()) > Math.abs(h(c12092e163, c12092e166).c() - h(c12092e162, c12092e166).c())) ? c12092e166 : c12092e165;
        }
        if (f(c12092e166)) {
            return c12092e166;
        }
        return null;
    }

    private C12092e16 b(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164, int i, int i2) {
        float fD = d(c12092e16, c12092e162) / i;
        float fD2 = d(c12092e163, c12092e164);
        C12092e16 c12092e165 = new C12092e16(c12092e164.c() + (((c12092e164.c() - c12092e163.c()) / fD2) * fD), c12092e164.d() + (fD * ((c12092e164.d() - c12092e163.d()) / fD2)));
        float fD3 = d(c12092e16, c12092e163) / i2;
        float fD4 = d(c12092e162, c12092e164);
        C12092e16 c12092e166 = new C12092e16(c12092e164.c() + (((c12092e164.c() - c12092e162.c()) / fD4) * fD3), c12092e164.d() + (fD3 * ((c12092e164.d() - c12092e162.d()) / fD4)));
        if (f(c12092e165)) {
            return (f(c12092e166) && Math.abs(i - h(c12092e163, c12092e165).c()) + Math.abs(i2 - h(c12092e162, c12092e165).c()) > Math.abs(i - h(c12092e163, c12092e166).c()) + Math.abs(i2 - h(c12092e162, c12092e166).c())) ? c12092e166 : c12092e165;
        }
        if (f(c12092e166)) {
            return c12092e166;
        }
        return null;
    }

    private static int d(C12092e16 c12092e16, C12092e16 c12092e162) {
        return AbstractC23186wV3.c(C12092e16.b(c12092e16, c12092e162));
    }

    private static void e(Map map, C12092e16 c12092e16) {
        Integer num = (Integer) map.get(c12092e16);
        map.put(c12092e16, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(C12092e16 c12092e16) {
        return c12092e16.c() >= 0.0f && c12092e16.c() < ((float) this.a.m()) && c12092e16.d() > 0.0f && c12092e16.d() < ((float) this.a.i());
    }

    private static C4705Gf0 g(C4705Gf0 c4705Gf0, C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164, int i, int i2) {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return AbstractC12277eL2.b().c(c4705Gf0, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, c12092e16.c(), c12092e16.d(), c12092e164.c(), c12092e164.d(), c12092e163.c(), c12092e163.d(), c12092e162.c(), c12092e162.d());
    }

    private b h(C12092e16 c12092e16, C12092e16 c12092e162) {
        int iC = (int) c12092e16.c();
        int iD = (int) c12092e16.d();
        int iC2 = (int) c12092e162.c();
        int iD2 = (int) c12092e162.d();
        int i = 0;
        boolean z = Math.abs(iD2 - iD) > Math.abs(iC2 - iC);
        if (z) {
            iD = iC;
            iC = iD;
            iD2 = iC2;
            iC2 = iD2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iD2 - iD);
        int i2 = (-iAbs) / 2;
        int i3 = iD < iD2 ? 1 : -1;
        int i4 = iC >= iC2 ? -1 : 1;
        boolean zE = this.a.e(z ? iD : iC, z ? iC : iD);
        while (iC != iC2) {
            boolean zE2 = this.a.e(z ? iD : iC, z ? iC : iD);
            if (zE2 != zE) {
                i++;
                zE = zE2;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (iD == iD2) {
                    break;
                }
                iD += i3;
                i2 -= iAbs;
            }
            iC += i4;
        }
        return new b(c12092e16, c12092e162, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FJ1 c() throws NotFoundException {
        C12092e16 c12092e16;
        C4705Gf0 c4705Gf0G;
        C12092e16[] c12092e16ArrC = this.b.c();
        C12092e16 c12092e162 = c12092e16ArrC[0];
        C12092e16 c12092e163 = c12092e16ArrC[1];
        C12092e16 c12092e164 = c12092e16ArrC[2];
        C12092e16 c12092e165 = c12092e16ArrC[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(c12092e162, c12092e163));
        arrayList.add(h(c12092e162, c12092e164));
        arrayList.add(h(c12092e163, c12092e165));
        arrayList.add(h(c12092e164, c12092e165));
        C12092e16 c12092e166 = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        e(map, bVar.a());
        e(map, bVar.b());
        e(map, bVar2.a());
        e(map, bVar2.b());
        C12092e16 c12092e167 = null;
        C12092e16 c12092e168 = null;
        for (Map.Entry entry : map.entrySet()) {
            C12092e16 c12092e169 = (C12092e16) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                c12092e167 = c12092e169;
            } else if (c12092e166 == null) {
                c12092e166 = c12092e169;
            } else {
                c12092e168 = c12092e169;
            }
        }
        if (c12092e166 == null || c12092e167 == null || c12092e168 == null) {
            throw NotFoundException.a();
        }
        C12092e16[] c12092e16Arr = {c12092e166, c12092e167, c12092e168};
        C12092e16.e(c12092e16Arr);
        C12092e16 c12092e1610 = c12092e16Arr[0];
        C12092e16 c12092e1611 = c12092e16Arr[1];
        C12092e16 c12092e1612 = c12092e16Arr[2];
        C12092e16 c12092e1613 = !map.containsKey(c12092e162) ? c12092e162 : !map.containsKey(c12092e163) ? c12092e163 : !map.containsKey(c12092e164) ? c12092e164 : c12092e165;
        int iC = h(c12092e1612, c12092e1613).c();
        int iC2 = h(c12092e1610, c12092e1613).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i2 = iC2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            C12092e16 c12092e16B = b(c12092e1611, c12092e1610, c12092e1612, c12092e1613, i, i2);
            if (c12092e16B != null) {
                c12092e1613 = c12092e16B;
            }
            int iC3 = h(c12092e1612, c12092e1613).c();
            int iC4 = h(c12092e1610, c12092e1613).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i3 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            c12092e16 = c12092e1612;
            c4705Gf0G = g(this.a, c12092e1612, c12092e1611, c12092e1610, c12092e1613, i3, iC4);
        } else {
            C12092e16 c12092e16A = a(c12092e1611, c12092e1610, c12092e1612, c12092e1613, Math.min(i2, i));
            if (c12092e16A != null) {
                c12092e1613 = c12092e16A;
            }
            int iMax = Math.max(h(c12092e1612, c12092e1613).c(), h(c12092e1610, c12092e1613).c());
            int i4 = iMax + 1;
            int i5 = (i4 & 1) == 1 ? iMax + 2 : i4;
            c4705Gf0G = g(this.a, c12092e1612, c12092e1611, c12092e1610, c12092e1613, i5, i5);
            c12092e16 = c12092e1612;
        }
        return new FJ1(c4705Gf0G, new C12092e16[]{c12092e16, c12092e1611, c12092e1610, c12092e1613});
    }
}
