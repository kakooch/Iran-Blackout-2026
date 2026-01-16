package io.sentry.protocol;

import java.util.Locale;

/* loaded from: classes3.dex */
public enum F {
    CUSTOM,
    URL,
    ROUTE,
    VIEW,
    COMPONENT,
    TASK;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
