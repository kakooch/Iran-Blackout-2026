package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import org.rbmain.messenger.MessagesController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class bk {
    private final acc a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final long g;
    private int h;
    private boolean i;

    public bk() {
        acc accVar = new acc();
        j(2500, 0, "bufferForPlaybackMs", "0");
        j(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        j(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        j(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        j(50000, 50000, "maxBufferMs", "minBufferMs");
        j(0, 0, "backBufferDurationMs", "0");
        this.a = accVar;
        this.b = bi.b(50000L);
        this.c = bi.b(50000L);
        this.d = bi.b(2500L);
        this.e = bi.b(5000L);
        this.f = -1;
        this.h = 13107200;
        this.g = bi.b(0L);
    }

    private final void i(boolean z) {
        this.h = 13107200;
        this.i = false;
        if (z) {
            this.a.a();
        }
    }

    private static void j(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        StringBuilder sb = new StringBuilder(str.length() + 21 + str2.length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        ary.p(z, sb.toString());
    }

    public final void a() {
        i(false);
    }

    public final void b() {
        i(true);
    }

    public final void c() {
        i(true);
    }

    public final long d() {
        return this.g;
    }

    public final boolean e(long j, float f, boolean z, long j2) {
        long jP = aeu.P(j, f);
        long jMin = z ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        return jMin <= 0 || jP >= jMin || this.a.g() >= this.h;
    }

    public final acc f() {
        return this.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void g(ed[] edVarArr, abb abbVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = edVarArr.length;
            int i3 = 13107200;
            if (i >= 2) {
                int iMax = Math.max(13107200, i2);
                this.h = iMax;
                this.a.b(iMax);
                return;
            }
            if (abbVar.a(i) != null) {
                switch (edVarArr[i].a()) {
                    case 0:
                        i3 = 144310272;
                        i2 += i3;
                        break;
                    case 1:
                        i2 += i3;
                        break;
                    case 2:
                        i3 = 131072000;
                        i2 += i3;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        i3 = MessagesController.UPDATE_MASK_REORDER;
                        i2 += i3;
                        break;
                    case 6:
                        i3 = 0;
                        i2 += i3;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
            i++;
        }
    }

    public final boolean h(long j, float f) {
        int iG = this.a.g();
        int i = this.h;
        long jMin = this.b;
        if (f > 1.0f) {
            jMin = Math.min(aeu.O(jMin, f), this.c);
        }
        if (j < Math.max(jMin, 500000L)) {
            boolean z = iG < i;
            this.i = z;
            if (!z && j < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.c || iG >= i) {
            this.i = false;
        }
        return this.i;
    }
}
