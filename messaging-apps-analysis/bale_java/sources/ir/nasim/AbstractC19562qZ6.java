package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.qZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19562qZ6 extends AbstractC18971pZ6 {
    public static final Void m(String str) {
        AbstractC13042fc3.i(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static Byte n(String str, int i) {
        int iIntValue;
        AbstractC13042fc3.i(str, "<this>");
        Integer numP = p(str, i);
        if (numP == null || (iIntValue = numP.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    public static Integer o(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return p(str, 10);
    }

    public static Integer p(String str, int i) {
        boolean z;
        int i2;
        int i3;
        AbstractC13042fc3.i(str, "<this>");
        AbstractC10868cL0.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (AbstractC13042fc3.k(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i5 = RecyclerView.UNDEFINED_DURATION;
                z = true;
            }
        } else {
            z = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int iB = AbstractC10868cL0.b(str.charAt(i2), i);
            if (iB < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + iB) {
                return null;
            }
            i4 = i3 - iB;
            i2++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long q(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return r(str, 10);
    }

    public static Long r(String str, int i) {
        boolean z;
        AbstractC13042fc3.i(str, "<this>");
        AbstractC10868cL0.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (AbstractC13042fc3.k(cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i2 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z = false;
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iB = AbstractC10868cL0.b(str.charAt(i2), i);
            if (iB < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / i;
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * i;
            long j6 = iB;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }

    public static Short s(String str, int i) {
        int iIntValue;
        AbstractC13042fc3.i(str, "<this>");
        Integer numP = p(str, i);
        if (numP == null || (iIntValue = numP.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }
}
