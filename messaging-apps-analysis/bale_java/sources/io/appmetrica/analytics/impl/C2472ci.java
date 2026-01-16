package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.ci, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2472ci {
    public final Revenue a;
    public final Ul b;
    public final C2476cm c;
    public final C2476cm d;
    public final PublicLogger e;

    public C2472ci(Revenue revenue, PublicLogger publicLogger) {
        this.e = publicLogger;
        this.a = revenue;
        this.b = new Ul(30720, "revenue payload", publicLogger);
        this.c = new C2476cm(new Ul(184320, "receipt data", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
        this.d = new C2476cm(new Wl(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, "receipt signature", publicLogger), "<truncated data was not sent, exceeded the limit of 180kb>");
    }
}
