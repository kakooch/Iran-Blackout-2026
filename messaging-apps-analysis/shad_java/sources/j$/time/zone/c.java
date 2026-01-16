package j$.time.zone;

import com.facebook.stetho.websocket.CloseCodes;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.util.AbstractC0102a;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class c implements Serializable {
    private static final long[] h = new long[0];
    private static final b[] i = new b[0];
    private static final a[] j = new a[0];
    private final long[] a;
    private final ZoneOffset[] b;
    private final long[] c;
    private final ZoneOffset[] d;
    private final b[] e;
    private final TimeZone f;
    private final transient ConcurrentMap g = new ConcurrentHashMap();

    private c(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.b = zoneOffsetArr;
        long[] jArr = h;
        this.a = jArr;
        this.c = jArr;
        this.d = zoneOffsetArr;
        this.e = i;
        this.f = null;
    }

    c(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {f(timeZone.getRawOffset())};
        this.b = zoneOffsetArr;
        long[] jArr = h;
        this.a = jArr;
        this.c = jArr;
        this.d = zoneOffsetArr;
        this.e = i;
        this.f = timeZone;
    }

    private a[] a(int i2) {
        Integer numValueOf = Integer.valueOf(i2);
        a[] aVarArr = (a[]) this.g.get(numValueOf);
        if (aVarArr != null) {
            return aVarArr;
        }
        if (this.f == null) {
            b[] bVarArr = this.e;
            a[] aVarArr2 = new a[bVarArr.length];
            if (bVarArr.length > 0) {
                b bVar = bVarArr[0];
                throw null;
            }
            if (i2 < 2100) {
                this.g.putIfAbsent(numValueOf, aVarArr2);
            }
            return aVarArr2;
        }
        if (i2 < 1800) {
            return j;
        }
        long jM = LocalDateTime.j(i2 - 1, 12, 31, 0, 0).m(this.b[0]);
        long j2 = 1000;
        int offset = this.f.getOffset(jM * 1000);
        long j3 = 31968000 + jM;
        a[] aVarArr3 = j;
        while (jM < j3) {
            long j4 = 7776000 + jM;
            long j5 = jM;
            if (offset != this.f.getOffset(j4 * j2)) {
                jM = j5;
                while (j4 - jM > 1) {
                    long j6 = j3;
                    long jF = j$.lang.d.f(j4 + jM, 2L);
                    long j7 = j4;
                    if (this.f.getOffset(jF * 1000) == offset) {
                        jM = jF;
                        j2 = 1000;
                        j4 = j7;
                    } else {
                        j4 = jF;
                        j2 = 1000;
                    }
                    j3 = j6;
                }
                long j8 = j3;
                long j9 = j4;
                long j10 = j2;
                if (this.f.getOffset(jM * j10) == offset) {
                    jM = j9;
                }
                ZoneOffset zoneOffsetF = f(offset);
                int offset2 = this.f.getOffset(jM * j10);
                ZoneOffset zoneOffsetF2 = f(offset2);
                if (b(jM, zoneOffsetF2) == i2) {
                    aVarArr3 = (a[]) Arrays.copyOf(aVarArr3, aVarArr3.length + 1);
                    aVarArr3[aVarArr3.length - 1] = new a(jM, zoneOffsetF, zoneOffsetF2);
                }
                offset = offset2;
                j2 = j10;
                j3 = j8;
            } else {
                jM = j4;
            }
        }
        if (1916 <= i2 && i2 < 2100) {
            this.g.putIfAbsent(numValueOf, aVarArr3);
        }
        return aVarArr3;
    }

    private int b(long j2, ZoneOffset zoneOffset) {
        return j$.time.g.o(j$.lang.d.f(j2 + zoneOffset.k(), 86400L)).l();
    }

    public static c e(ZoneOffset zoneOffset) {
        return new c(zoneOffset);
    }

    private static ZoneOffset f(int i2) {
        return ZoneOffset.n(i2 / CloseCodes.NORMAL_CLOSURE);
    }

    public ZoneOffset c(Instant instant) {
        TimeZone timeZone = this.f;
        if (timeZone != null) {
            return f(timeZone.getOffset(instant.l()));
        }
        if (this.c.length == 0) {
            return this.b[0];
        }
        long jH = instant.h();
        if (this.e.length > 0) {
            if (jH > this.c[r8.length - 1]) {
                a[] aVarArrA = a(b(jH, this.d[r8.length - 1]));
                a aVar = null;
                for (int i2 = 0; i2 < aVarArrA.length; i2++) {
                    aVar = aVarArrA[i2];
                    if (jH < aVar.d()) {
                        return aVar.c();
                    }
                }
                return aVar.b();
            }
        }
        int iBinarySearch = Arrays.binarySearch(this.c, jH);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.d[iBinarySearch + 1];
    }

    public boolean d() {
        TimeZone timeZone = this.f;
        if (timeZone == null) {
            return this.c.length == 0;
        }
        if (timeZone.useDaylightTime() || this.f.getDSTSavings() != 0) {
            return false;
        }
        Instant instant = Instant.c;
        ZoneOffset zoneOffset = ZoneOffset.UTC;
        Instant instantJ = Instant.j(System.currentTimeMillis());
        a aVar = null;
        if (this.f != null) {
            long jH = instantJ.h();
            if (instantJ.i() > 0 && jH < Long.MAX_VALUE) {
                jH++;
            }
            int iB = b(jH, c(instantJ));
            a[] aVarArrA = a(iB);
            int length = aVarArrA.length - 1;
            while (true) {
                if (length >= 0) {
                    if (jH > aVarArrA[length].d()) {
                        aVar = aVarArrA[length];
                        break;
                    }
                    length--;
                } else if (iB > 1800) {
                    a[] aVarArrA2 = a(iB - 1);
                    int length2 = aVarArrA2.length - 1;
                    while (true) {
                        if (length2 < 0) {
                            long jMin = Math.min(jH - 31104000, (j$.time.b.b().a() / 1000) + 31968000);
                            int offset = this.f.getOffset((jH - 1) * 1000);
                            long jQ = j$.time.g.n(1800, 1, 1).q() * 86400;
                            while (true) {
                                if (jQ > jMin) {
                                    break;
                                }
                                int offset2 = this.f.getOffset(jMin * 1000);
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
                                        if (jH > aVarArrA3[length3].d()) {
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
                            if (jH > aVarArrA2[length2].d()) {
                                aVar = aVarArrA2[length2];
                                break;
                            }
                            length2--;
                        }
                    }
                }
            }
        } else if (this.c.length != 0) {
            long jH2 = instantJ.h();
            if (instantJ.i() > 0 && jH2 < Long.MAX_VALUE) {
                jH2++;
            }
            long[] jArr = this.c;
            long j2 = jArr[jArr.length - 1];
            if (this.e.length <= 0 || jH2 <= j2) {
                int iBinarySearch = Arrays.binarySearch(this.c, jH2);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                if (iBinarySearch > 0) {
                    int i2 = iBinarySearch - 1;
                    long j3 = this.c[i2];
                    ZoneOffset[] zoneOffsetArr = this.d;
                    aVar = new a(j3, zoneOffsetArr[i2], zoneOffsetArr[iBinarySearch]);
                }
            } else {
                ZoneOffset[] zoneOffsetArr2 = this.d;
                ZoneOffset zoneOffset2 = zoneOffsetArr2[zoneOffsetArr2.length - 1];
                int iB3 = b(jH2, zoneOffset2);
                a[] aVarArrA5 = a(iB3);
                int length4 = aVarArrA5.length - 1;
                while (true) {
                    if (length4 < 0) {
                        int i3 = iB3 - 1;
                        if (i3 > b(j2, zoneOffset2)) {
                            a[] aVarArrA6 = a(i3);
                            aVar = aVarArrA6[aVarArrA6.length - 1];
                        }
                    } else {
                        if (jH2 > aVarArrA5[length4].d()) {
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
        return AbstractC0102a.u(this.f, cVar.f) && Arrays.equals(this.a, cVar.a) && Arrays.equals(this.b, cVar.b) && Arrays.equals(this.c, cVar.c) && Arrays.equals(this.d, cVar.d) && Arrays.equals(this.e, cVar.e);
    }

    public int hashCode() {
        TimeZone timeZone = this.f;
        return (((((timeZone != null ? timeZone.hashCode() : 0) ^ Arrays.hashCode(this.a)) ^ Arrays.hashCode(this.b)) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.d)) ^ Arrays.hashCode(this.e);
    }

    public String toString() {
        StringBuilder sb;
        if (this.f != null) {
            sb = new StringBuilder();
            sb.append("ZoneRules[timeZone=");
            sb.append(this.f.getID());
        } else {
            sb = new StringBuilder();
            sb.append("ZoneRules[currentStandardOffset=");
            sb.append(this.b[r2.length - 1]);
        }
        sb.append("]");
        return sb.toString();
    }
}
