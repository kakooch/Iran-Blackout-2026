package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ls {
    private final aee a = new aee(8);
    private int b;

    private final long b(jv jvVar) throws IOException {
        int i = 0;
        jvVar.g(this.a.i(), 0, 1);
        int i2 = this.a.i()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (i3 ^ (-1));
        jvVar.g(this.a.i(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.i()[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    public final boolean a(jv jvVar) throws IOException {
        long jM = jvVar.m();
        long j = 1024;
        if (jM != -1 && jM <= 1024) {
            j = jM;
        }
        int i = (int) j;
        jvVar.g(this.a.i(), 0, 4);
        long jT = this.a.t();
        this.b = 4;
        while (jT != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            jvVar.g(this.a.i(), 0, 1);
            jT = ((jT << 8) & (-256)) | (this.a.i()[0] & 255);
        }
        long jB = b(jvVar);
        long j2 = this.b;
        if (jB != Long.MIN_VALUE && (jM == -1 || j2 + jB < jM)) {
            while (true) {
                long j3 = this.b;
                long j4 = j2 + jB;
                if (j3 < j4) {
                    if (b(jvVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jB2 = b(jvVar);
                    if (jB2 < 0) {
                        return false;
                    }
                    if (jB2 != 0) {
                        int i3 = (int) jB2;
                        jvVar.i(i3);
                        this.b += i3;
                    }
                } else if (j3 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
