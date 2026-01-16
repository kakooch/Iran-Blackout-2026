package io.sentry.internal.debugmeta;

import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.util.AbstractC3203b;
import io.sentry.util.AbstractC3205d;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/* loaded from: classes3.dex */
public final class c implements a {
    private final ILogger a;
    private final ClassLoader b;

    public c(ILogger iLogger) {
        this(iLogger, c.class.getClassLoader());
    }

    @Override // io.sentry.internal.debugmeta.a
    public List a() throws IOException {
        InputStream inputStreamOpenStream;
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.b.getResources(AbstractC3205d.a);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                try {
                    inputStreamOpenStream = urlNextElement.openStream();
                } catch (RuntimeException e) {
                    this.a.a(Y2.ERROR, e, "%s file is malformed.", urlNextElement);
                }
                try {
                    Properties properties = new Properties();
                    properties.load(inputStreamOpenStream);
                    arrayList.add(properties);
                    this.a.c(Y2.INFO, "Debug Meta Data Properties loaded from %s", urlNextElement);
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenStream != null) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e2) {
            this.a.a(Y2.ERROR, e2, "Failed to load %s", AbstractC3205d.a);
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        this.a.c(Y2.INFO, "No %s file was found.", AbstractC3205d.a);
        return null;
    }

    c(ILogger iLogger, ClassLoader classLoader) {
        this.a = iLogger;
        this.b = AbstractC3203b.a(classLoader);
    }
}
