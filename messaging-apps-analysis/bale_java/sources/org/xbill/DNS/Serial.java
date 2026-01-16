package org.xbill.DNS;

/* loaded from: classes8.dex */
public final class Serial {
    private static final String ERROR_MESSAGE_SUFFIX = " out of range";
    private static final long MAX32 = 4294967295L;

    private Serial() {
    }

    public static int compare(long j, long j2) {
        if (j < 0 || j > MAX32) {
            throw new IllegalArgumentException(j + ERROR_MESSAGE_SUFFIX);
        }
        if (j2 < 0 || j2 > MAX32) {
            throw new IllegalArgumentException(j2 + ERROR_MESSAGE_SUFFIX);
        }
        long j3 = j - j2;
        if (j3 >= MAX32) {
            j3 -= 4294967296L;
        }
        return (int) j3;
    }

    public static long increment(long j) {
        if (j >= 0 && j <= MAX32) {
            if (j == MAX32) {
                return 1L;
            }
            return j + 1;
        }
        throw new IllegalArgumentException(j + ERROR_MESSAGE_SUFFIX);
    }
}
