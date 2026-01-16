package io.sentry;

import java.io.File;

/* loaded from: classes3.dex */
public interface S1 {
    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void c(ILogger iLogger, String str, AbstractC3197u abstractC3197u, File file) {
        Y2 y2 = Y2.DEBUG;
        iLogger.c(y2, "Started processing cached files from %s", str);
        abstractC3197u.e(file);
        iLogger.c(y2, "Finished processing cached files from %s", str);
    }

    default P1 a(final AbstractC3197u abstractC3197u, final String str, final ILogger iLogger) {
        final File file = new File(str);
        return new P1() { // from class: io.sentry.R1
            @Override // io.sentry.P1
            public final void a() {
                S1.c(iLogger, str, abstractC3197u, file);
            }
        };
    }

    P1 d(Z z, C3155n3 c3155n3);

    default boolean e(String str, ILogger iLogger) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        iLogger.c(Y2.INFO, "No cached dir path is defined in options.", new Object[0]);
        return false;
    }
}
