package ir.nasim;

/* renamed from: ir.nasim.d57, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC11490d57 {
    public static final int a(String str, int i, int i2, int i3) {
        return (int) AbstractC10110b57.c(str, i, i2, i3);
    }

    public static final long b(String str, long j, long j2, long j3) {
        String strD = AbstractC10110b57.d(str);
        if (strD == null) {
            return j;
        }
        Long lQ = AbstractC19562qZ6.q(strD);
        if (lQ == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lQ.longValue();
        if (j2 <= jLongValue && jLongValue <= j3) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String strD = AbstractC10110b57.d(str);
        return strD == null ? str2 : strD;
    }

    public static final boolean d(String str, boolean z) {
        String strD = AbstractC10110b57.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z;
    }

    public static /* synthetic */ int e(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return AbstractC10110b57.b(str, i, i2, i3);
    }

    public static /* synthetic */ long f(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return AbstractC10110b57.c(str, j, j4, j3);
    }
}
