package io.sentry;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* renamed from: io.sentry.y1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3227y1 {
    private final URL a;
    private final Map b;

    public C3227y1(String str, Map map) {
        io.sentry.util.u.c(str, "url is required");
        io.sentry.util.u.c(map, "headers is required");
        try {
            this.a = URI.create(str).toURL();
            this.b = map;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e);
        }
    }

    public Map a() {
        return this.b;
    }

    public URL b() {
        return this.a;
    }
}
