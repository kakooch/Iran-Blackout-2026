package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.jl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2644jl {
    public final Dl A;
    public final Map B;
    public final C2919v9 C;
    public final String a;
    public final List b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;
    public final List g;
    public final List h;
    public final Map i;
    public final String j;
    public final String k;
    public final String l;
    public final C2938w4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final Hl r;
    public final Md s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C2889u3 y;
    public final C2697m2 z;

    public C2644jl(C2620il c2620il) {
        this.a = c2620il.a;
        List list = c2620il.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = c2620il.c;
        this.d = c2620il.d;
        this.e = c2620il.e;
        List list2 = c2620il.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = c2620il.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = c2620il.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map = c2620il.i;
        this.i = map != null ? CollectionUtils.unmodifiableMapCopy(map) : null;
        this.j = c2620il.j;
        this.k = c2620il.k;
        this.m = c2620il.m;
        this.s = c2620il.n;
        this.n = c2620il.o;
        this.o = c2620il.p;
        this.l = c2620il.l;
        this.p = c2620il.q;
        this.q = c2620il.r;
        this.r = c2620il.s;
        this.u = c2620il.t;
        this.v = c2620il.u;
        this.w = c2620il.v;
        RetryPolicyConfig retryPolicyConfig = c2620il.w;
        if (retryPolicyConfig == null) {
            C2979xl c2979xl = new C2979xl();
            this.t = new RetryPolicyConfig(c2979xl.w, c2979xl.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = c2620il.x;
        this.y = c2620il.y;
        this.z = c2620il.z;
        this.A = c2620il.A == null ? new Dl(D7.a.a) : c2620il.A;
        this.B = c2620il.B == null ? Collections.emptyMap() : c2620il.B;
        this.C = c2620il.C;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + '}';
    }
}
