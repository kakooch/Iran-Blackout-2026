package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.q5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2796q5 {
    public final PublicLogger a;

    public C2796q5(String str) {
        this.a = LoggerStorage.getOrCreatePublicLogger(str);
    }

    public final int a(int i) {
        if (i < 100) {
            this.a.warning("Value passed as maxReportsInDatabaseCount is invalid. Should be greater than or equal to 100, but was: " + i + ". Default value (100) will be used", new Object[0]);
            return 100;
        }
        if (i <= 10000) {
            return i;
        }
        this.a.warning("Value passed as maxReportsInDatabaseCount is invalid. Should be less than or equal to 10000, but was: " + i + ". Default value (10000) will be used", new Object[0]);
        return AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
    }
}
