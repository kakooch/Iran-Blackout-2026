package com.fasterxml.jackson.core.io;

/* loaded from: classes.dex */
public final class NumberOutput {
    private static int BILLION = 1000000000;
    private static long BILLION_L = 1000000000;
    private static long MAX_INT_AS_LONG = 2147483647L;
    private static int MILLION = 1000000;
    private static long MIN_INT_AS_LONG = -2147483648L;
    static final String SMALLEST_INT = String.valueOf(Integer.MIN_VALUE);
    static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    private static final int[] TRIPLET_TO_CHARS = new int[1000];
    private static final String[] sSmallIntStrs;
    private static final String[] sSmallIntStrs2;

    static {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                int i4 = 0;
                while (i4 < 10) {
                    TRIPLET_TO_CHARS[i] = ((i2 + 48) << 16) | ((i3 + 48) << 8) | (i4 + 48);
                    i4++;
                    i++;
                }
            }
        }
        sSmallIntStrs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        sSmallIntStrs2 = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int outputInt(int i, char[] cArr, int i2) {
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                return _outputSmallestI(cArr, i2);
            }
            cArr[i2] = '-';
            i = -i;
            i2++;
        }
        if (i < MILLION) {
            if (i >= 1000) {
                int i4 = i / 1000;
                return _full3(i - (i4 * 1000), cArr, _leading3(i4, cArr, i2));
            }
            if (i < 10) {
                cArr[i2] = (char) (i + 48);
                return i2 + 1;
            }
            return _leading3(i, cArr, i2);
        }
        int i5 = BILLION;
        if (i >= i5) {
            int i6 = i - i5;
            if (i6 >= i5) {
                i6 -= i5;
                i3 = i2 + 1;
                cArr[i2] = '2';
            } else {
                i3 = i2 + 1;
                cArr[i2] = '1';
            }
            return _outputFullBillion(i6, cArr, i3);
        }
        int i7 = i / 1000;
        int i8 = i7 / 1000;
        return _full3(i - (i7 * 1000), cArr, _full3(i7 - (i8 * 1000), cArr, _leading3(i8, cArr, i2)));
    }

    public static int outputLong(long j, char[] cArr, int i) {
        int i_outputFullBillion;
        if (j < 0) {
            if (j > MIN_INT_AS_LONG) {
                return outputInt((int) j, cArr, i);
            }
            if (j == Long.MIN_VALUE) {
                return _outputSmallestL(cArr, i);
            }
            cArr[i] = '-';
            j = -j;
            i++;
        } else if (j <= MAX_INT_AS_LONG) {
            return outputInt((int) j, cArr, i);
        }
        long j2 = BILLION_L;
        long j3 = j / j2;
        long j4 = j - (j3 * j2);
        if (j3 < j2) {
            i_outputFullBillion = _outputUptoBillion((int) j3, cArr, i);
        } else {
            long j5 = j3 / j2;
            int i_leading3 = _leading3((int) j5, cArr, i);
            i_outputFullBillion = _outputFullBillion((int) (j3 - (j2 * j5)), cArr, i_leading3);
        }
        return _outputFullBillion((int) j4, cArr, i_outputFullBillion);
    }

    public static boolean notFinite(double d) {
        return Double.isNaN(d) || Double.isInfinite(d);
    }

    public static boolean notFinite(float f) {
        return Float.isNaN(f) || Float.isInfinite(f);
    }

    private static int _outputUptoBillion(int i, char[] cArr, int i2) {
        if (i < MILLION) {
            if (i < 1000) {
                return _leading3(i, cArr, i2);
            }
            int i3 = i / 1000;
            return _outputUptoMillion(cArr, i2, i3, i - (i3 * 1000));
        }
        int i4 = i / 1000;
        int i5 = i - (i4 * 1000);
        int i6 = i4 / 1000;
        int i7 = i4 - (i6 * 1000);
        int i_leading3 = _leading3(i6, cArr, i2);
        int[] iArr = TRIPLET_TO_CHARS;
        int i8 = iArr[i7];
        int i9 = i_leading3 + 1;
        cArr[i_leading3] = (char) (i8 >> 16);
        int i10 = i9 + 1;
        cArr[i9] = (char) ((i8 >> 8) & 127);
        int i11 = i10 + 1;
        cArr[i10] = (char) (i8 & 127);
        int i12 = iArr[i5];
        int i13 = i11 + 1;
        cArr[i11] = (char) (i12 >> 16);
        int i14 = i13 + 1;
        cArr[i13] = (char) ((i12 >> 8) & 127);
        int i15 = i14 + 1;
        cArr[i14] = (char) (i12 & 127);
        return i15;
    }

    private static int _outputFullBillion(int i, char[] cArr, int i2) {
        int i3 = i / 1000;
        int i4 = i - (i3 * 1000);
        int i5 = i3 / 1000;
        int[] iArr = TRIPLET_TO_CHARS;
        int i6 = iArr[i5];
        int i7 = i2 + 1;
        cArr[i2] = (char) (i6 >> 16);
        int i8 = i7 + 1;
        cArr[i7] = (char) ((i6 >> 8) & 127);
        int i9 = i8 + 1;
        cArr[i8] = (char) (i6 & 127);
        int i10 = iArr[i3 - (i5 * 1000)];
        int i11 = i9 + 1;
        cArr[i9] = (char) (i10 >> 16);
        int i12 = i11 + 1;
        cArr[i11] = (char) ((i10 >> 8) & 127);
        int i13 = i12 + 1;
        cArr[i12] = (char) (i10 & 127);
        int i14 = iArr[i4];
        int i15 = i13 + 1;
        cArr[i13] = (char) (i14 >> 16);
        int i16 = i15 + 1;
        cArr[i15] = (char) ((i14 >> 8) & 127);
        int i17 = i16 + 1;
        cArr[i16] = (char) (i14 & 127);
        return i17;
    }

    private static int _outputUptoMillion(char[] cArr, int i, int i2, int i3) {
        int[] iArr = TRIPLET_TO_CHARS;
        int i4 = iArr[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                cArr[i] = (char) (i4 >> 16);
                i++;
            }
            cArr[i] = (char) ((i4 >> 8) & 127);
            i++;
        }
        int i5 = i + 1;
        cArr[i] = (char) (i4 & 127);
        int i6 = iArr[i3];
        int i7 = i5 + 1;
        cArr[i5] = (char) (i6 >> 16);
        int i8 = i7 + 1;
        cArr[i7] = (char) ((i6 >> 8) & 127);
        int i9 = i8 + 1;
        cArr[i8] = (char) (i6 & 127);
        return i9;
    }

    private static int _leading3(int i, char[] cArr, int i2) {
        int i3 = TRIPLET_TO_CHARS[i];
        if (i > 9) {
            if (i > 99) {
                cArr[i2] = (char) (i3 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i3 >> 8) & 127);
            i2++;
        }
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 & 127);
        return i4;
    }

    private static int _full3(int i, char[] cArr, int i2) {
        int i3 = TRIPLET_TO_CHARS[i];
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 >> 16);
        int i5 = i4 + 1;
        cArr[i4] = (char) ((i3 >> 8) & 127);
        int i6 = i5 + 1;
        cArr[i5] = (char) (i3 & 127);
        return i6;
    }

    private static int _outputSmallestL(char[] cArr, int i) {
        String str = SMALLEST_LONG;
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return i + length;
    }

    private static int _outputSmallestI(char[] cArr, int i) {
        String str = SMALLEST_INT;
        int length = str.length();
        str.getChars(0, length, cArr, i);
        return i + length;
    }
}
