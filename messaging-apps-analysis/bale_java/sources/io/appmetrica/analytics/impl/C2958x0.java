package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import ir.nasim.AbstractC13042fc3;

/* renamed from: io.appmetrica.analytics.impl.x0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2958x0 {
    public final String a;
    public final String b;
    public final CounterConfigurationReporterType c;
    public final int d;
    public final String e;
    public final String f;

    public C2958x0(String str, String str2, CounterConfigurationReporterType counterConfigurationReporterType, int i, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = counterConfigurationReporterType;
        this.d = i;
        this.e = str3;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2958x0)) {
            return false;
        }
        C2958x0 c2958x0 = (C2958x0) obj;
        return AbstractC13042fc3.d(this.a, c2958x0.a) && AbstractC13042fc3.d(this.b, c2958x0.b) && this.c == c2958x0.c && this.d == c2958x0.d && AbstractC13042fc3.d(this.e, c2958x0.e) && AbstractC13042fc3.d(this.f, c2958x0.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((Integer.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "AppMetricaNativeCrashMetadata(apiKey=" + this.a + ", packageName=" + this.b + ", reporterType=" + this.c + ", processID=" + this.d + ", processSessionID=" + this.e + ", errorEnvironment=" + this.f + ')';
    }
}
