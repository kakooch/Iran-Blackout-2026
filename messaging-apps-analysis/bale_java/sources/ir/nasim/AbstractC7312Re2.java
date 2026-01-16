package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.monitoring.installer.config.SentryConfiguration;

/* renamed from: ir.nasim.Re2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7312Re2 {
    public static final SentryConfiguration a(AF2 af2, KS2 ks2) {
        Object objB;
        AbstractC13042fc3.i(af2, "<this>");
        AbstractC13042fc3.i(ks2, "gson");
        String strA = af2.a("app.android.core.sentry_configuration");
        if (strA != null) {
            if (!(!AbstractC20762sZ6.n0(strA))) {
                strA = null;
            }
            if (strA != null) {
                try {
                    C9475a16.a aVar = C9475a16.b;
                    objB = C9475a16.b((SentryConfiguration) ks2.k(strA, SentryConfiguration.class));
                } catch (Throwable th) {
                    C9475a16.a aVar2 = C9475a16.b;
                    objB = C9475a16.b(AbstractC10685c16.a(th));
                }
                Throwable thE = C9475a16.e(objB);
                if (thE != null) {
                    C19406qI3.c("Sentry", "Failed to load the configuration.", thE);
                }
                SentryConfiguration sentryConfiguration = (SentryConfiguration) (C9475a16.g(objB) ? null : objB);
                return sentryConfiguration == null ? new SentryConfiguration(false, 0.0d, false, false, false, 0, false, false, 0, false, 1023, null) : sentryConfiguration;
            }
        }
        return new SentryConfiguration(false, 0.0d, false, false, false, 0, false, false, 0, false, 1023, null);
    }
}
