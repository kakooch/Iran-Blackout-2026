package io.sentry.android.core;

import android.net.TrafficStats;
import io.sentry.InterfaceC3112f0;

/* loaded from: classes3.dex */
public final class G implements InterfaceC3112f0 {
    private static final G a = new G();

    private G() {
    }

    public static G c() {
        return a;
    }

    @Override // io.sentry.InterfaceC3112f0
    public void a() {
        TrafficStats.clearThreadStatsTag();
    }

    @Override // io.sentry.InterfaceC3112f0
    public void b() {
        TrafficStats.setThreadStatsTag(61441);
    }
}
