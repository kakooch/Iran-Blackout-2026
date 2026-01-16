package j$.time;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class e implements Comparable<e>, Serializable {
    public static final e a = new e(0, 0);
    private final long b;
    private final int c;

    static {
        BigInteger.valueOf(1000000000L);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private e(long j, int i) {
        this.b = j;
        this.c = i;
    }

    private static e h(long j, int i) {
        return (((long) i) | j) == 0 ? a : new e(j, i);
    }

    public static e j(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (i + 1000000000);
            j2--;
        }
        return h(j2, i);
    }

    public static e l(long j) {
        return h(j, 0);
    }

    public static e n(long j, long j2) {
        return h(a.w(j, a.A(j2, 1000000000L)), (int) a.z(j2, 1000000000L));
    }

    @Override // java.lang.Comparable
    public int compareTo(e eVar) {
        e eVar2 = eVar;
        int i = (this.b > eVar2.b ? 1 : (this.b == eVar2.b ? 0 : -1));
        return i != 0 ? i : this.c - eVar2.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == eVar.b && this.c == eVar.c;
    }

    public int hashCode() {
        long j = this.b;
        return (this.c * 51) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        if (this == a) {
            return "PT0S";
        }
        long j = this.b;
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.c == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.c <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.c > 0) {
            int length = sb.length();
            if (i2 < 0) {
                sb.append(2000000000 - this.c);
            } else {
                sb.append(this.c + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
