package io.sentry.config;

import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.util.AbstractC3203b;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes3.dex */
final class b {
    private final String a;
    private final ClassLoader b;
    private final ILogger c;

    public b(String str, ClassLoader classLoader, ILogger iLogger) {
        this.a = str;
        this.b = AbstractC3203b.a(classLoader);
        this.c = iLogger;
    }

    public Properties a() throws IOException {
        try {
            InputStream resourceAsStream = this.b.getResourceAsStream(this.a);
            if (resourceAsStream == null) {
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return null;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    resourceAsStream.close();
                    return properties;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            this.c.a(Y2.ERROR, e, "Failed to load Sentry configuration from classpath resource: %s", this.a);
            return null;
        }
    }

    public b(ILogger iLogger) {
        this("sentry.properties", b.class.getClassLoader(), iLogger);
    }
}
