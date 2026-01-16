package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* loaded from: classes3.dex */
public class O5 extends BaseRequestConfig {
    public String a;
    public String b;
    public C2549fl c;

    public final String b() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig
    public String toString() {
        return "CoreRequestConfig{mAppDebuggable='" + this.a + "', mAppSystem='" + this.b + "', startupState=" + this.c + '}';
    }

    public final String a() {
        return this.a;
    }
}
