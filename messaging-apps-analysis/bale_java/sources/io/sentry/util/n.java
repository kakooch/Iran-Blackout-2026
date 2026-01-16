package io.sentry.util;

import io.sentry.C3113f1;
import io.sentry.C3155n3;
import io.sentry.D0;
import io.sentry.Y2;

/* loaded from: classes3.dex */
public abstract class n {
    public static boolean a(C3155n3 c3155n3, C3155n3 c3155n32, boolean z) {
        if (w.c() && (c3155n32.getVersionDetector() instanceof C3113f1)) {
            c3155n32.setVersionDetector(new D0(c3155n32));
        }
        if (!c3155n32.getVersionDetector().a()) {
            return !z || c3155n3 == null || c3155n32.isForceInit() || c3155n3.getInitPriority().ordinal() <= c3155n32.getInitPriority().ordinal();
        }
        c3155n32.getLogger().c(Y2.ERROR, "Not initializing Sentry because mixed SDK versions have been detected.", new Object[0]);
        throw new IllegalStateException("Sentry SDK has detected a mix of versions. This is not supported and likely leads to crashes. Please always use the same version of all SDK modules (dependencies). See " + (w.a() ? "https://docs.sentry.io/platforms/android/troubleshooting/mixed-versions" : "https://docs.sentry.io/platforms/java/troubleshooting/mixed-versions") + " for more details.");
    }
}
