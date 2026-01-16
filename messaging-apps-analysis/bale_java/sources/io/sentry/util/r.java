package io.sentry.util;

import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.Y2;

/* loaded from: classes3.dex */
public class r {
    public boolean a(String str, ILogger iLogger) {
        return c(str, iLogger) != null;
    }

    public boolean b(String str, C3155n3 c3155n3) {
        return a(str, c3155n3 != null ? c3155n3.getLogger() : null);
    }

    public Class c(String str, ILogger iLogger) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            if (iLogger == null) {
                return null;
            }
            iLogger.c(Y2.INFO, "Class not available: " + str, new Object[0]);
            return null;
        } catch (UnsatisfiedLinkError e) {
            if (iLogger == null) {
                return null;
            }
            iLogger.b(Y2.ERROR, "Failed to load (UnsatisfiedLinkError) " + str, e);
            return null;
        } catch (Throwable th) {
            if (iLogger == null) {
                return null;
            }
            iLogger.b(Y2.ERROR, "Failed to initialize " + str, th);
            return null;
        }
    }
}
