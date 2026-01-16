package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Ng {
    public final Q5 a;
    public final boolean b;
    public final int c;
    public final HashMap d;
    public final Wg e;

    public Ng(Q5 q5, boolean z, int i, HashMap map, Wg wg) {
        this.a = q5;
        this.b = z;
        this.c = i;
        this.d = map;
        this.e = wg;
    }

    public final String toString() {
        return "ReportToSend(report=" + this.a + ", serviceDataReporterType=" + this.c + ", environment=" + this.e + ", isCrashReport=" + this.b + ", trimmedFields=" + this.d + ')';
    }
}
