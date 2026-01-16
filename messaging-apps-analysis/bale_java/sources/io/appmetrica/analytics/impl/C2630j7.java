package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* renamed from: io.appmetrica.analytics.impl.j7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2630j7 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public C2630j7(Xa xa) {
        this.a = xa.b("dId");
        this.b = xa.b("uId");
        this.c = xa.b("analyticsSdkVersionName");
        this.d = xa.b("kitBuildNumber");
        this.e = xa.b("kitBuildType");
        this.f = xa.b("appVer");
        this.g = xa.optString("app_debuggable", "0");
        this.h = xa.b("appBuild");
        this.i = xa.b("osVer");
        this.k = xa.b("lang");
        this.l = xa.b("root");
        this.m = xa.optString(CommonUrlParts.APP_FRAMEWORK, FrameworkDetector.framework());
        int iOptInt = xa.optInt("osApiLev", -1);
        this.j = iOptInt == -1 ? null : String.valueOf(iOptInt);
        int iOptInt2 = xa.optInt("attribution_id", 0);
        this.n = iOptInt2 > 0 ? String.valueOf(iOptInt2) : null;
    }

    public final String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.a + "', uuid='" + this.b + "', analyticsSdkVersionName='" + this.c + "', kitBuildNumber='" + this.d + "', kitBuildType='" + this.e + "', appVersion='" + this.f + "', appDebuggable='" + this.g + "', appBuildNumber='" + this.h + "', osVersion='" + this.i + "', osApiLevel='" + this.j + "', locale='" + this.k + "', deviceRootStatus='" + this.l + "', appFramework='" + this.m + "', attributionId='" + this.n + "'}";
    }

    public C2630j7() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }
}
