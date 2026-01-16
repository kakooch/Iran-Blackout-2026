package j$.time.zone;

import j$.time.f;
import j$.time.g;
import j$.time.h;
import j$.time.m;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class c implements Serializable {
    private static final long[] a = new long[0];
    private static final b[] b = new b[0];
    private static final h[] c = new h[0];
    private static final a[] d = new a[0];
    private final long[] e;
    private final m[] f;
    private final long[] g;
    private final m[] h;
    private final b[] i;
    private final TimeZone j;
    private final transient ConcurrentMap k = new ConcurrentHashMap();

    private c(m mVar) {
        m[] mVarArr = {mVar};
        this.f = mVarArr;
        long[] jArr = a;
        this.e = jArr;
        this.g = jArr;
        this.h = mVarArr;
        this.i = b;
        this.j = null;
    }

    c(TimeZone timeZone) {
        m[] mVarArr = {f(timeZone.getRawOffset())};
        this.f = mVarArr;
        long[] jArr = a;
        this.e = jArr;
        this.g = jArr;
        this.h = mVarArr;
        this.i = b;
        this.j = timeZone;
    }

    private a[] a(int i) {
        long j;
        long j2;
        Integer numValueOf = Integer.valueOf(i);
        a[] aVarArr = (a[]) this.k.get(numValueOf);
        if (aVarArr != null) {
            return aVarArr;
        }
        if (this.j == null) {
            b[] bVarArr = this.i;
            a[] aVarArr2 = new a[bVarArr.length];
            if (bVarArr.length > 0) {
                b bVar = bVarArr[0];
                throw null;
            }
            if (i < 2100) {
                this.k.putIfAbsent(numValueOf, aVarArr2);
            }
            return aVarArr2;
        }
        if (i < 1800) {
            return d;
        }
        long jL = j$.time.a.l(h.y(i - 1, 12, 31, 0, 0), this.f[0]);
        long j3 = 1000;
        int offset = this.j.getOffset(jL * 1000);
        long j4 = 31968000 + jL;
        a[] aVarArr3 = d;
        while (jL < j4) {
            long j5 = 7776000 + jL;
            long j6 = jL;
            if (offset != this.j.getOffset(j5 * j3)) {
                jL = j6;
                while (j5 - jL > 1) {
                    long j7 = j4;
                    long jA = j$.time.a.A(j5 + jL, 2L);
                    long j8 = j5;
                    if (this.j.getOffset(jA * 1000) == offset) {
                        jL = jA;
                        j5 = j8;
                    } else {
                        j5 = jA;
                    }
                    j3 = 1000;
                    j4 = j7;
                }
                j = j4;
                long j9 = j5;
                j2 = j3;
                if (this.j.getOffset(jL * j2) == offset) {
                    jL = j9;
                }
                m mVarF = f(offset);
                int offset2 = this.j.getOffset(jL * j2);
                m mVarF2 = f(offset2);
                if (b(jL, mVarF2) == i) {
                    a[] aVarArr4 = (a[]) Arrays.copyOf(aVarArr3, aVarArr3.length + 1);
                    aVarArr4[aVarArr4.length - 1] = new a(jL, mVarF, mVarF2);
                    offset = offset2;
                    aVarArr3 = aVarArr4;
                } else {
                    offset = offset2;
                }
            } else {
                j = j4;
                j2 = j3;
                jL = j5;
            }
            j3 = j2;
            j4 = j;
        }
        if (1916 <= i && i < 2100) {
            this.k.putIfAbsent(numValueOf, aVarArr3);
        }
        return aVarArr3;
    }

    private int b(long j, m mVar) {
        return g.C(j$.time.a.A(j + mVar.y(), 86400L)).z();
    }

    public static c e(m mVar) {
        return new c(mVar);
    }

    private static m f(int i) {
        return m.B(i / 1000);
    }

    public m c(f fVar) {
        TimeZone timeZone = this.j;
        if (timeZone != null) {
            return f(timeZone.getOffset(fVar.A()));
        }
        if (this.g.length == 0) {
            return this.f[0];
        }
        long jW = fVar.w();
        if (this.i.length > 0) {
            if (jW > this.g[r8.length - 1]) {
                a[] aVarArrA = a(b(jW, this.h[r8.length - 1]));
                a aVar = null;
                for (int i = 0; i < aVarArrA.length; i++) {
                    aVar = aVarArrA[i];
                    if (jW < aVar.u()) {
                        return aVar.l();
                    }
                }
                return aVar.j();
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.g, jW);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.h[iBinarySearch + 1];
    }

    public boolean d() {
        TimeZone timeZone = this.j;
        if (timeZone == null) {
            return this.g.length == 0;
        }
        if (timeZone.useDaylightTime() || this.j.getDSTSavings() != 0) {
            return false;
        }
        f fVar = f.a;
        m mVar = m.d;
        f fVarY = f.y(System.currentTimeMillis());
        a aVar = null;
        if (this.j != null) {
            long jW = fVarY.w();
            if (fVarY.x() > 0 && jW < Long.MAX_VALUE) {
                jW++;
            }
            int iB = b(jW, c(fVarY));
            a[] aVarArrA = a(iB);
            int length = aVarArrA.length - 1;
            while (true) {
                if (length >= 0) {
                    if (jW > aVarArrA[length].u()) {
                        aVar = aVarArrA[length];
                        break;
                    }
                    length--;
                } else if (iB > 1800) {
                    a[] aVarArrA2 = a(iB - 1);
                    int length2 = aVarArrA2.length - 1;
                    while (true) {
                        if (length2 < 0) {
                            long jMin = Math.min(jW - 31104000, (j$.time.b.b().a() / 1000) + 31968000);
                            int offset = this.j.getOffset((jW - 1) * 1000);
                            long jM = g.B(1800, 1, 1).m() * 86400;
                            while (true) {
                                if (jM > jMin) {
                                    break;
                                }
                                int offset2 = this.j.getOffset(jMin * 1000);
                                if (offset != offset2) {
                                    int iB2 = b(jMin, f(offset2));
                                    a[] aVarArrA3 = a(iB2 + 1);
                                    int length3 = aVarArrA3.length - 1;
                                    while (true) {
                                        if (length3 < 0) {
                                            a[] aVarArrA4 = a(iB2);
                                            aVar = aVarArrA4[aVarArrA4.length - 1];
                                            break;
                                        }
                                        if (jW > aVarArrA3[length3].u()) {
                                            aVar = aVarArrA3[length3];
                                            break;
                                        }
                                        length3--;
                                    }
                                } else {
                                    jMin -= 7776000;
                                }
                            }
                        } else {
                            if (jW > aVarArrA2[length2].u()) {
                                aVar = aVarArrA2[length2];
                                break;
                            }
                            length2--;
                        }
                    }
                }
            }
        } else if (this.g.length != 0) {
            long jW2 = fVarY.w();
            if (fVarY.x() > 0 && jW2 < Long.MAX_VALUE) {
                jW2++;
            }
            long[] jArr = this.g;
            long j = jArr[jArr.length - 1];
            if (this.i.length <= 0 || jW2 <= j) {
                int iBinarySearch = Arrays.binarySearch(this.g, jW2);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                if (iBinarySearch > 0) {
                    int i = iBinarySearch - 1;
                    long j2 = this.g[i];
                    m[] mVarArr = this.h;
                    aVar = new a(j2, mVarArr[i], mVarArr[iBinarySearch]);
                }
            } else {
                m[] mVarArr2 = this.h;
                m mVar2 = mVarArr2[mVarArr2.length - 1];
                int iB3 = b(jW2, mVar2);
                a[] aVarArrA5 = a(iB3);
                int length4 = aVarArrA5.length - 1;
                while (true) {
                    if (length4 < 0) {
                        int i2 = iB3 - 1;
                        if (i2 > b(j, mVar2)) {
                            a[] aVarArrA6 = a(i2);
                            aVar = aVarArrA6[aVarArrA6.length - 1];
                        }
                    } else {
                        if (jW2 > aVarArrA5[length4].u()) {
                            aVar = aVarArrA5[length4];
                            break;
                        }
                        length4--;
                    }
                }
            }
        }
        return aVar == null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j$.time.a.y(this.j, cVar.j) && Arrays.equals(this.e, cVar.e) && Arrays.equals(this.f, cVar.f) && Arrays.equals(this.g, cVar.g) && Arrays.equals(this.h, cVar.h) && Arrays.equals(this.i, cVar.i);
    }

    public int hashCode() {
        TimeZone timeZone = this.j;
        return (((((timeZone == null ? 0 : timeZone.hashCode()) ^ Arrays.hashCode(this.e)) ^ Arrays.hashCode(this.f)) ^ Arrays.hashCode(this.g)) ^ Arrays.hashCode(this.h)) ^ Arrays.hashCode(this.i);
    }

    public String toString() {
        StringBuilder sbA;
        if (this.j != null) {
            sbA = j$.com.android.tools.r8.a.a("ZoneRules[timeZone=");
            sbA.append(this.j.getID());
        } else {
            sbA = j$.com.android.tools.r8.a.a("ZoneRules[currentStandardOffset=");
            sbA.append(this.f[r2.length - 1]);
        }
        sbA.append("]");
        return sbA.toString();
    }
}
