package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ia implements hq {
    final /* synthetic */ ie a;

    /* synthetic */ ia(ie ieVar) {
        this.a = ieVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hq
    public final void a(long j) {
        if (this.a.o != null) {
            this.a.o.a(j);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hq
    public final void b(long j, long j2, long j3, long j4) {
        long jR = this.a.R();
        long jS = this.a.S();
        StringBuilder sb = new StringBuilder(182);
        sb.append("Spurious audio timestamp (frame position mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(jR);
        sb.append(", ");
        sb.append(jS);
        Log.w("AudioTrack", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hq
    public final void c(long j, long j2, long j3, long j4) {
        long jR = this.a.R();
        long jS = this.a.S();
        StringBuilder sb = new StringBuilder(180);
        sb.append("Spurious audio timestamp (system clock mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(jR);
        sb.append(", ");
        sb.append(jS);
        Log.w("AudioTrack", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hq
    public final void d(long j) {
        StringBuilder sb = new StringBuilder(61);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j);
        Log.w("AudioTrack", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.hq
    public final void e(int i, long j) {
        if (this.a.o != null) {
            this.a.o.b(i, j, SystemClock.elapsedRealtime() - this.a.V);
        }
    }
}
