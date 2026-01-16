package ir.nasim;

import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.zo2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C25144zo2 {
    private final C4705Gf0 a;
    private boolean c;
    private final List b = new ArrayList();
    private final int[] d = new int[5];

    /* renamed from: ir.nasim.zo2$b */
    private static final class b implements Serializable, Comparator {
        private final float a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C23960xo2 c23960xo2, C23960xo2 c23960xo22) {
            int iCompare = Integer.compare(c23960xo22.h(), c23960xo2.h());
            return iCompare == 0 ? Float.compare(Math.abs(c23960xo2.i() - this.a), Math.abs(c23960xo22.i() - this.a)) : iCompare;
        }

        private b(float f) {
            this.a = f;
        }
    }

    /* renamed from: ir.nasim.zo2$c */
    private static final class c implements Serializable, Comparator {
        private final float a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C23960xo2 c23960xo2, C23960xo2 c23960xo22) {
            return Float.compare(Math.abs(c23960xo22.i() - this.a), Math.abs(c23960xo2.i() - this.a));
        }

        private c(float f) {
            this.a = f;
        }
    }

    public C25144zo2(C4705Gf0 c4705Gf0, InterfaceC12683f16 interfaceC12683f16) {
        this.a = c4705Gf0;
    }

    private static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] iArrJ = j();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.a.e(i2 - i6, i - i6)) {
            iArrJ[2] = iArrJ[2] + 1;
            i6++;
        }
        if (iArrJ[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.a.e(i2 - i6, i - i6)) {
            iArrJ[1] = iArrJ[1] + 1;
            i6++;
        }
        if (iArrJ[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.a.e(i2 - i6, i - i6)) {
            iArrJ[0] = iArrJ[0] + 1;
            i6++;
        }
        if (iArrJ[0] == 0) {
            return false;
        }
        int i7 = this.a.i();
        int iM = this.a.m();
        int i8 = 1;
        while (true) {
            int i9 = i + i8;
            if (i9 >= i7 || (i5 = i2 + i8) >= iM || !this.a.e(i5, i9)) {
                break;
            }
            iArrJ[2] = iArrJ[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i + i8;
            if (i10 >= i7 || (i4 = i2 + i8) >= iM || this.a.e(i4, i10)) {
                break;
            }
            iArrJ[3] = iArrJ[3] + 1;
            i8++;
        }
        if (iArrJ[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i + i8;
            if (i11 >= i7 || (i3 = i2 + i8) >= iM || !this.a.e(i3, i11)) {
                break;
            }
            iArrJ[4] = iArrJ[4] + 1;
            i8++;
        }
        if (iArrJ[4] == 0) {
            return false;
        }
        return i(iArrJ);
    }

    private float d(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        C4705Gf0 c4705Gf0 = this.a;
        int iM = c4705Gf0.m();
        int[] iArrJ = j();
        int i8 = i;
        while (i8 >= 0 && c4705Gf0.e(i8, i2)) {
            iArrJ[2] = iArrJ[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !c4705Gf0.e(i8, i2)) {
            int i9 = iArrJ[1];
            if (i9 > i3) {
                break;
            }
            iArrJ[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrJ[1] <= i3) {
            while (i8 >= 0 && c4705Gf0.e(i8, i2) && (i7 = iArrJ[0]) <= i3) {
                iArrJ[0] = i7 + 1;
                i8--;
            }
            if (iArrJ[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iM && c4705Gf0.e(i10, i2)) {
                iArrJ[2] = iArrJ[2] + 1;
                i10++;
            }
            if (i10 == iM) {
                return Float.NaN;
            }
            while (i10 < iM && !c4705Gf0.e(i10, i2) && (i6 = iArrJ[3]) < i3) {
                iArrJ[3] = i6 + 1;
                i10++;
            }
            if (i10 != iM && iArrJ[3] < i3) {
                while (i10 < iM && c4705Gf0.e(i10, i2) && (i5 = iArrJ[4]) < i3) {
                    iArrJ[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrJ[4];
                if (i11 < i3 && Math.abs(((((iArrJ[0] + iArrJ[1]) + iArrJ[2]) + iArrJ[3]) + i11) - i4) * 5 < i4 && h(iArrJ)) {
                    return a(iArrJ, i10);
                }
            }
        }
        return Float.NaN;
    }

    private float e(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        C4705Gf0 c4705Gf0 = this.a;
        int i8 = c4705Gf0.i();
        int[] iArrJ = j();
        int i9 = i;
        while (i9 >= 0 && c4705Gf0.e(i2, i9)) {
            iArrJ[2] = iArrJ[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !c4705Gf0.e(i2, i9)) {
            int i10 = iArrJ[1];
            if (i10 > i3) {
                break;
            }
            iArrJ[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && iArrJ[1] <= i3) {
            while (i9 >= 0 && c4705Gf0.e(i2, i9) && (i7 = iArrJ[0]) <= i3) {
                iArrJ[0] = i7 + 1;
                i9--;
            }
            if (iArrJ[0] > i3) {
                return Float.NaN;
            }
            int i11 = i + 1;
            while (i11 < i8 && c4705Gf0.e(i2, i11)) {
                iArrJ[2] = iArrJ[2] + 1;
                i11++;
            }
            if (i11 == i8) {
                return Float.NaN;
            }
            while (i11 < i8 && !c4705Gf0.e(i2, i11) && (i6 = iArrJ[3]) < i3) {
                iArrJ[3] = i6 + 1;
                i11++;
            }
            if (i11 != i8 && iArrJ[3] < i3) {
                while (i11 < i8 && c4705Gf0.e(i2, i11) && (i5 = iArrJ[4]) < i3) {
                    iArrJ[4] = i5 + 1;
                    i11++;
                }
                int i12 = iArrJ[4];
                if (i12 < i3 && Math.abs(((((iArrJ[0] + iArrJ[1]) + iArrJ[2]) + iArrJ[3]) + i12) - i4) * 5 < i4 * 2 && h(iArrJ)) {
                    return a(iArrJ, i11);
                }
            }
        }
        return Float.NaN;
    }

    private int g() {
        if (this.b.size() <= 1) {
            return 0;
        }
        C23960xo2 c23960xo2 = null;
        for (C23960xo2 c23960xo22 : this.b) {
            if (c23960xo22.h() >= 2) {
                if (c23960xo2 != null) {
                    this.c = true;
                    return ((int) (Math.abs(c23960xo2.c() - c23960xo22.c()) - Math.abs(c23960xo2.d() - c23960xo22.d()))) / 2;
                }
                c23960xo2 = c23960xo22;
            }
        }
        return 0;
    }

    protected static boolean h(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    protected static boolean i(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    private int[] j() {
        b(this.d);
        return this.d;
    }

    private boolean l() {
        int size = this.b.size();
        float fAbs = 0.0f;
        int i = 0;
        float fI = 0.0f;
        for (C23960xo2 c23960xo2 : this.b) {
            if (c23960xo2.h() >= 2) {
                i++;
                fI += c23960xo2.i();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = fI / size;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(((C23960xo2) it.next()).i() - f);
        }
        return fAbs <= fI * 0.05f;
    }

    private C23960xo2[] m() throws NotFoundException {
        int size = this.b.size();
        if (size < 3) {
            throw NotFoundException.a();
        }
        float fI = 0.0f;
        if (size > 3) {
            Iterator it = this.b.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                float fI2 = ((C23960xo2) it.next()).i();
                f += fI2;
                f2 += fI2 * fI2;
            }
            float f3 = f / size;
            float fSqrt = (float) Math.sqrt((f2 / r0) - (f3 * f3));
            Collections.sort(this.b, new c(f3));
            float fMax = Math.max(0.2f * f3, fSqrt);
            int i = 0;
            while (i < this.b.size() && this.b.size() > 3) {
                if (Math.abs(((C23960xo2) this.b.get(i)).i() - f3) > fMax) {
                    this.b.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.b.size() > 3) {
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                fI += ((C23960xo2) it2.next()).i();
            }
            Collections.sort(this.b, new b(fI / this.b.size()));
            List list = this.b;
            list.subList(3, list.size()).clear();
        }
        return new C23960xo2[]{(C23960xo2) this.b.get(0), (C23960xo2) this.b.get(1), (C23960xo2) this.b.get(2)};
    }

    protected final void b(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    final C3364Ao2 f(Map map) throws NotFoundException {
        boolean z = map != null && map.containsKey(EnumC19932rB1.TRY_HARDER);
        int i = this.a.i();
        int iM = this.a.m();
        int i2 = (i * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean zL = false;
        while (i3 < i && !zL) {
            b(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < iM) {
                if (this.a.e(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (h(iArr) && k(iArr, i3, i4)) {
                    if (this.c) {
                        zL = l();
                    } else {
                        int iG = g();
                        int i6 = iArr[2];
                        if (iG > i6) {
                            i3 += (iG - i6) - 2;
                            i4 = iM - 1;
                        }
                    }
                    b(iArr);
                    i2 = 2;
                    i5 = 0;
                } else {
                    n(iArr);
                    i5 = 3;
                }
                i4++;
            }
            if (h(iArr) && k(iArr, i3, iM)) {
                i2 = iArr[0];
                if (this.c) {
                    zL = l();
                }
            }
            i3 += i2;
        }
        C23960xo2[] c23960xo2ArrM = m();
        C12092e16.e(c23960xo2ArrM);
        return new C3364Ao2(c23960xo2ArrM);
    }

    protected final boolean k(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i2);
        float fE = e(i, iA, iArr[2], i4);
        if (!Float.isNaN(fE)) {
            int i5 = (int) fE;
            float fD = d(iA, i5, iArr[2], i4);
            if (!Float.isNaN(fD) && c(i5, (int) fD)) {
                float f = i4 / 7.0f;
                while (true) {
                    if (i3 >= this.b.size()) {
                        this.b.add(new C23960xo2(fD, fE, f));
                        break;
                    }
                    C23960xo2 c23960xo2 = (C23960xo2) this.b.get(i3);
                    if (c23960xo2.f(f, fE, fD)) {
                        this.b.set(i3, c23960xo2.g(fE, fD, f));
                        break;
                    }
                    i3++;
                }
                return true;
            }
        }
        return false;
    }

    protected final void n(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
