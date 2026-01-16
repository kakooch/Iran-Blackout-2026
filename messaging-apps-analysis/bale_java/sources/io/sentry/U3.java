package io.sentry;

/* loaded from: classes3.dex */
public final class U3 {
    private final C3155n3 a;

    public U3(C3155n3 c3155n3) {
        this.a = (C3155n3) io.sentry.util.u.c(c3155n3, "options are required");
    }

    private boolean b(Double d, Double d2) {
        return d.doubleValue() >= d2.doubleValue();
    }

    public V3 a(A1 a1) {
        Double dA;
        Double dA2 = a1.a();
        V3 v3J = a1.b().j();
        if (v3J != null) {
            return io.sentry.util.y.a(v3J);
        }
        this.a.getProfilesSampler();
        Double profilesSampleRate = this.a.getProfilesSampleRate();
        Boolean boolValueOf = Boolean.valueOf(profilesSampleRate != null && b(profilesSampleRate, dA2));
        if (this.a.getTracesSampler() != null) {
            try {
                dA = this.a.getTracesSampler().a(a1);
            } catch (Throwable th) {
                this.a.getLogger().b(Y2.ERROR, "Error in the 'TracesSamplerCallback' callback.", th);
                dA = null;
            }
            if (dA != null) {
                return new V3(Boolean.valueOf(b(dA, dA2)), dA, dA2, boolValueOf, profilesSampleRate);
            }
        }
        V3 v3X = a1.b().x();
        if (v3X != null) {
            return io.sentry.util.y.a(v3X);
        }
        Double tracesSampleRate = this.a.getTracesSampleRate();
        Double dValueOf = tracesSampleRate == null ? null : Double.valueOf(tracesSampleRate.doubleValue() / Math.pow(2.0d, this.a.getBackpressureMonitor().a()));
        if (dValueOf != null) {
            return new V3(Boolean.valueOf(b(dValueOf, dA2)), dValueOf, dA2, boolValueOf, profilesSampleRate);
        }
        Boolean bool = Boolean.FALSE;
        return new V3(bool, null, dA2, bool, null);
    }

    public boolean c(double d) {
        Double profileSessionSampleRate = this.a.getProfileSessionSampleRate();
        return profileSessionSampleRate != null && b(profileSessionSampleRate, Double.valueOf(d));
    }
}
