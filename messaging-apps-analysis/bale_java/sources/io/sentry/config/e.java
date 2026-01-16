package io.sentry.config;

import io.sentry.ILogger;
import io.sentry.Y2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: classes3.dex */
final class e {
    private final String a;
    private final ILogger b;

    public e(String str, ILogger iLogger) {
        this.a = str;
        this.b = iLogger;
    }

    public Properties a() throws IOException {
        try {
            File file = new File(this.a);
            if (!file.isFile() || !file.canRead()) {
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                bufferedInputStream.close();
                return properties;
            } finally {
            }
        } catch (IOException e) {
            this.b.a(Y2.ERROR, e, "Failed to load Sentry configuration from file: %s", this.a);
            return null;
        }
    }
}
