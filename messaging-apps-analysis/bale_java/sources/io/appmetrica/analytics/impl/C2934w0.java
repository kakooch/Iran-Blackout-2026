package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import ir.nasim.AbstractC13042fc3;

/* renamed from: io.appmetrica.analytics.impl.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2934w0 {
    public final NativeCrashSource a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final C2958x0 f;

    public C2934w0(NativeCrashSource nativeCrashSource, String str, String str2, String str3, long j, C2958x0 c2958x0) {
        this.a = nativeCrashSource;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = c2958x0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2934w0)) {
            return false;
        }
        C2934w0 c2934w0 = (C2934w0) obj;
        return this.a == c2934w0.a && AbstractC13042fc3.d(this.b, c2934w0.b) && AbstractC13042fc3.d(this.c, c2934w0.c) && AbstractC13042fc3.d(this.d, c2934w0.d) && this.e == c2934w0.e && AbstractC13042fc3.d(this.f, c2934w0.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((Long.hashCode(this.e) + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AppMetricaNativeCrash(source=" + this.a + ", handlerVersion=" + this.b + ", uuid=" + this.c + ", dumpFile=" + this.d + ", creationTime=" + this.e + ", metadata=" + this.f + ')';
    }
}
