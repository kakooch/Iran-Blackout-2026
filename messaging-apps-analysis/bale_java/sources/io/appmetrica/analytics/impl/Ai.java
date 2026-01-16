package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* loaded from: classes3.dex */
public final class Ai {
    public final String a;
    public final Context b;
    public final CounterConfigurationReporterType c;
    public final Di d;

    public Ai(String str, Context context, CounterConfigurationReporterType counterConfigurationReporterType, Di di) {
        this.a = str;
        this.b = context;
        int i = AbstractC3024zi.a[counterConfigurationReporterType.ordinal()];
        if (i == 1) {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MAIN;
        } else if (i != 2) {
            this.c = null;
        } else {
            this.c = CounterConfigurationReporterType.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = di;
    }
}
