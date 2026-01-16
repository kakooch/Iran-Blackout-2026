package ir.nasim;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* loaded from: classes3.dex */
public final class C46 {
    private static C46 b;
    private static final RootTelemetryConfiguration c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    private RootTelemetryConfiguration a;

    private C46() {
    }

    public static synchronized C46 b() {
        try {
            if (b == null) {
                b = new C46();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public RootTelemetryConfiguration a() {
        return this.a;
    }

    public final synchronized void c(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.a = c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.x0() < rootTelemetryConfiguration.x0()) {
            this.a = rootTelemetryConfiguration;
        }
    }
}
