package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;

/* loaded from: classes3.dex */
public final class Rj {
    public final tn a;

    public Rj(tn tnVar) {
        this.a = tnVar;
    }

    public final long a() {
        long jOptLong;
        tn tnVar = this.a;
        synchronized (tnVar) {
            jOptLong = tnVar.a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (jOptLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + jOptLong;
        }
        this.a.c(j);
        return j;
    }
}
