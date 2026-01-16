package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;

/* loaded from: classes2.dex */
public final class ServerSideAdInsertionUtil {
    private ServerSideAdInsertionUtil() {
    }

    public static int a(AdPlaybackState adPlaybackState, int i) {
        int i2 = adPlaybackState.d(i).b;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    public static long b(long j, MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.c() ? c(j, mediaPeriodId.b, mediaPeriodId.c, adPlaybackState) : d(j, mediaPeriodId.e, adPlaybackState);
    }

    public static long c(long j, int i, int i2, AdPlaybackState adPlaybackState) {
        int i3;
        AdPlaybackState.AdGroup adGroupD = adPlaybackState.d(i);
        long j2 = j - adGroupD.a;
        int i4 = adPlaybackState.e;
        while (true) {
            i3 = 0;
            if (i4 >= i) {
                break;
            }
            AdPlaybackState.AdGroup adGroupD2 = adPlaybackState.d(i4);
            while (i3 < a(adPlaybackState, i4)) {
                j2 -= adGroupD2.f[i3];
                i3++;
            }
            j2 += adGroupD2.g;
            i4++;
        }
        if (i2 < a(adPlaybackState, i)) {
            while (i3 < i2) {
                j2 -= adGroupD.f[i3];
                i3++;
            }
        }
        return j2;
    }

    public static long d(long j, int i, AdPlaybackState adPlaybackState) {
        if (i == -1) {
            i = adPlaybackState.b;
        }
        long j2 = 0;
        for (int i2 = adPlaybackState.e; i2 < i; i2++) {
            AdPlaybackState.AdGroup adGroupD = adPlaybackState.d(i2);
            long j3 = adGroupD.a;
            if (j3 == Long.MIN_VALUE || j3 > j - j2) {
                break;
            }
            for (int i3 = 0; i3 < a(adPlaybackState, i2); i3++) {
                j2 += adGroupD.f[i3];
            }
            long j4 = adGroupD.g;
            j2 -= j4;
            long j5 = adGroupD.a;
            long j6 = j - j2;
            if (j4 + j5 > j6) {
                return Math.max(j5, j6);
            }
        }
        return j - j2;
    }

    public static long e(long j, MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.c() ? f(j, mediaPeriodId.b, mediaPeriodId.c, adPlaybackState) : g(j, mediaPeriodId.e, adPlaybackState);
    }

    public static long f(long j, int i, int i2, AdPlaybackState adPlaybackState) {
        int i3;
        AdPlaybackState.AdGroup adGroupD = adPlaybackState.d(i);
        long j2 = j + adGroupD.a;
        int i4 = adPlaybackState.e;
        while (true) {
            i3 = 0;
            if (i4 >= i) {
                break;
            }
            AdPlaybackState.AdGroup adGroupD2 = adPlaybackState.d(i4);
            while (i3 < a(adPlaybackState, i4)) {
                j2 += adGroupD2.f[i3];
                i3++;
            }
            j2 -= adGroupD2.g;
            i4++;
        }
        if (i2 < a(adPlaybackState, i)) {
            while (i3 < i2) {
                j2 += adGroupD.f[i3];
                i3++;
            }
        }
        return j2;
    }

    public static long g(long j, int i, AdPlaybackState adPlaybackState) {
        if (i == -1) {
            i = adPlaybackState.b;
        }
        long j2 = 0;
        for (int i2 = adPlaybackState.e; i2 < i; i2++) {
            AdPlaybackState.AdGroup adGroupD = adPlaybackState.d(i2);
            long j3 = adGroupD.a;
            if (j3 == Long.MIN_VALUE || j3 > j) {
                break;
            }
            long j4 = j3 + j2;
            for (int i3 = 0; i3 < a(adPlaybackState, i2); i3++) {
                j2 += adGroupD.f[i3];
            }
            long j5 = adGroupD.g;
            j2 -= j5;
            if (adGroupD.a + j5 > j) {
                return Math.max(j4, j + j2);
            }
        }
        return j + j2;
    }
}
