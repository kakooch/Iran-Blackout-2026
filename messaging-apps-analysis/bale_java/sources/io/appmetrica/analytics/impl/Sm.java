package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ReporterConfig;

/* loaded from: classes3.dex */
public class Sm {
    public final String a;
    public final Na b;

    public Sm(Na na, String str) {
        this.b = na;
        this.a = str;
    }

    public Oa a() {
        return this.b.a().b(ReporterConfig.newConfigBuilder(this.a).build());
    }
}
