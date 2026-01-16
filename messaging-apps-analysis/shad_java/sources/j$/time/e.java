package j$.time;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class e implements Comparable, Serializable {
    public static final e c = new e(0, 0);
    private final long a;
    private final int b;

    static {
        BigInteger.valueOf(1000000000L);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private e(long j, int i) {
        this.a = j;
        this.b = i;
    }

    private static e a(long j, int i) {
        return (((long) i) | j) == 0 ? c : new e(j, i);
    }

    public static e b(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (i + 1000000000);
            j2--;
        }
        return a(j2, i);
    }

    public static e c(long j) {
        return a(j, 0);
    }

    public static e d(long j, long j2) {
        return a(j$.lang.d.d(j, j$.lang.d.f(j2, 1000000000L)), (int) j$.lang.d.e(j2, 1000000000L));
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        e eVar = (e) obj;
        int i = (this.a > eVar.a ? 1 : (this.a == eVar.a ? 0 : -1));
        return i != 0 ? i : this.b - eVar.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b;
    }

    public int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        if (this == c) {
            return "PT0S";
        }
        long j = this.a;
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
        if (i2 == 0 && this.b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.b <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.b > 0) {
            int length = sb.length();
            if (i2 < 0) {
                sb.append(2000000000 - this.b);
            } else {
                sb.append(this.b + 1000000000);
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
