package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.util.AbstractC3203b;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class f extends d {
    private final ClassLoader e;

    public f(ILogger iLogger) {
        this(iLogger, f.class.getClassLoader());
    }

    @Override // io.sentry.internal.modules.d
    protected Map b() throws IOException {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream resourceAsStream = this.e.getResourceAsStream("sentry-external-modules.txt");
            try {
                if (resourceAsStream != null) {
                    Map mapC = c(resourceAsStream);
                    resourceAsStream.close();
                    return mapC;
                }
                this.a.c(Y2.INFO, "%s file was not found.", "sentry-external-modules.txt");
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return treeMap;
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            this.a.b(Y2.INFO, "Access to resources failed.", e);
            return treeMap;
        } catch (SecurityException e2) {
            this.a.b(Y2.INFO, "Access to resources denied.", e2);
            return treeMap;
        }
    }

    f(ILogger iLogger, ClassLoader classLoader) {
        super(iLogger);
        this.e = AbstractC3203b.a(classLoader);
    }
}
