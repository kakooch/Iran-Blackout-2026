package j$.time;

import ir.eitaa.messenger.MediaController;
import j$.time.temporal.p;
import j$.time.temporal.q;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class i implements Comparable<i>, Serializable, Serializable {
    public static final i a;
    public static final i b;
    private static final i[] c = new i[24];
    private final byte d;
    private final byte e;
    private final byte f;
    private final int g;

    static {
        int i = 0;
        while (true) {
            i[] iVarArr = c;
            if (i >= iVarArr.length) {
                i iVar = iVarArr[0];
                i iVar2 = iVarArr[12];
                a = iVarArr[0];
                b = new i(23, 59, 59, 999999999);
                return;
            }
            iVarArr[i] = new i(i, 0, 0, 0);
            i++;
        }
    }

    private i(int i, int i2, int i3, int i4) {
        this.d = (byte) i;
        this.e = (byte) i2;
        this.f = (byte) i3;
        this.g = i4;
    }

    public static i A(long j) {
        j$.time.temporal.h.NANO_OF_DAY.x(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (i * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (i2 * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        int i4 = (int) (j3 - (i3 * 1000000000));
        return ((i2 | i3) | i4) == 0 ? c[i] : new i(i, i2, i3, i4);
    }

    public static i v(j$.time.temporal.k kVar) {
        if (kVar == null) {
            throw new NullPointerException("temporal");
        }
        int i = j$.time.temporal.m.a;
        i iVar = (i) kVar.n(j$.time.temporal.f.a);
        if (iVar != null) {
            return iVar;
        }
        throw new c("Unable to obtain LocalTime from TemporalAccessor: " + kVar + " of type " + kVar.getClass().getName());
    }

    private int w(j$.time.temporal.l lVar) {
        switch (((j$.time.temporal.h) lVar).ordinal()) {
            case 0:
                return this.g;
            case 1:
                throw new p("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 2:
                return this.g / 1000;
            case 3:
                throw new p("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 4:
                return this.g / MediaController.VIDEO_BITRATE_480;
            case 5:
                return (int) (B() / 1000000);
            case 6:
                return this.f;
            case 7:
                return C();
            case 8:
                return this.e;
            case 9:
                return (this.d * 60) + this.e;
            case 10:
                return this.d % 12;
            case 11:
                int i = this.d % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 12:
                return this.d;
            case 13:
                byte b2 = this.d;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 14:
                return this.d / 12;
            default:
                throw new p("Unsupported field: " + lVar);
        }
    }

    public static i z(int i, int i2) {
        j$.time.temporal.h.HOUR_OF_DAY.x(i);
        if (i2 == 0) {
            return c[i];
        }
        j$.time.temporal.h.MINUTE_OF_HOUR.x(i2);
        return new i(i, i2, 0, 0);
    }

    public long B() {
        return (this.f * 1000000000) + (this.e * 60000000000L) + (this.d * 3600000000000L) + this.g;
    }

    public int C() {
        return (this.e * 60) + (this.d * 3600) + this.f;
    }

    public boolean d(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar.j() : lVar != null && lVar.n(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.d == iVar.d && this.e == iVar.e && this.f == iVar.f && this.g == iVar.g;
    }

    public int h(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? w(lVar) : a.f(this, lVar);
    }

    public int hashCode() {
        long jB = B();
        return (int) (jB ^ (jB >>> 32));
    }

    public q j(j$.time.temporal.l lVar) {
        return a.k(this, lVar);
    }

    public long l(j$.time.temporal.l lVar) {
        return lVar instanceof j$.time.temporal.h ? lVar == j$.time.temporal.h.NANO_OF_DAY ? B() : lVar == j$.time.temporal.h.MICRO_OF_DAY ? B() / 1000 : w(lVar) : lVar.l(this);
    }

    public Object n(j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        if (nVar == j$.time.temporal.b.a || nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a) {
            return null;
        }
        if (nVar == j$.time.temporal.f.a) {
            return this;
        }
        if (nVar == j$.time.temporal.a.a) {
            return null;
        }
        return nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        int iV = a.v(this.d, iVar.d);
        if (iV != 0) {
            return iV;
        }
        int iV2 = a.v(this.e, iVar.e);
        if (iV2 != 0) {
            return iV2;
        }
        int iV3 = a.v(this.f, iVar.f);
        return iV3 == 0 ? a.v(this.g, iVar.g) : iV3;
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.d;
        byte b3 = this.e;
        byte b4 = this.f;
        int i2 = this.g;
        sb.append(b2 < 10 ? "0" : "");
        sb.append((int) b2);
        sb.append(b3 < 10 ? ":0" : ":");
        sb.append((int) b3);
        if (b4 > 0 || i2 > 0) {
            sb.append(b4 >= 10 ? ":" : ":0");
            sb.append((int) b4);
            if (i2 > 0) {
                sb.append('.');
                int i3 = MediaController.VIDEO_BITRATE_480;
                if (i2 % MediaController.VIDEO_BITRATE_480 == 0) {
                    i = (i2 / MediaController.VIDEO_BITRATE_480) + 1000;
                } else {
                    if (i2 % 1000 == 0) {
                        i2 /= 1000;
                    } else {
                        i3 = 1000000000;
                    }
                    i = i2 + i3;
                }
                sb.append(Integer.toString(i).substring(1));
            }
        }
        return sb.toString();
    }

    public int x() {
        return this.g;
    }

    public int y() {
        return this.f;
    }
}
