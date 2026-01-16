package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.player.ContentProgressProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class amb implements AdsRequest {
    private String a;
    private Map<String, String> b;
    private String c;
    private ContentProgressProvider d;
    private aly e = aly.UNKNOWN;
    private ama f = ama.UNKNOWN;
    private alz g = alz.UNKNOWN;
    private Float h;
    private List<String> i;
    private String j;
    private String k;
    private Integer l;
    private Float m;
    private Float n;
    private transient Object o;

    public final aly a() {
        return this.e;
    }

    public final ama b() {
        return this.f;
    }

    public final alz c() {
        return this.g;
    }

    public final Float d() {
        return this.h;
    }

    public final List<String> e() {
        return this.i;
    }

    public final String f() {
        return this.j;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void forceExperimentId(Integer num) {
        this.l = num;
    }

    public final String g() {
        return this.k;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final String getAdTagUrl() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final String getAdsResponse() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final ContentProgressProvider getContentProgressProvider() {
        return this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final String getExtraParameter(String str) {
        Map<String, String> map = this.b;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final Map<String, String> getExtraParameters() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final Integer getForcedExperimentId() {
        return this.l;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final Object getUserRequestContext() {
        return this.o;
    }

    public final Float h() {
        return this.m;
    }

    public final Float i() {
        return this.n;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdTagUrl(String str) {
        this.a = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdWillAutoPlay(boolean z) {
        this.e = z ? aly.AUTO : aly.CLICK;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdWillPlayMuted(boolean z) {
        this.f = z ? ama.MUTED : ama.UNMUTED;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setAdsResponse(String str) {
        this.c = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentDuration(float f) {
        this.h = Float.valueOf(f);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentKeywords(List<String> list) {
        this.i = list;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentProgressProvider(ContentProgressProvider contentProgressProvider) {
        this.d = contentProgressProvider;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentTitle(String str) {
        this.j = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContentUrl(String str) {
        this.k = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setContinuousPlayback(boolean z) {
        this.g = z ? alz.ON : alz.OFF;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setExtraParameter(String str, String str2) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, str2);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setLiveStreamPrefetchSeconds(float f) {
        this.n = Float.valueOf(f);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setUserRequestContext(Object obj) {
        this.o = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRequest
    public final void setVastLoadTimeout(float f) {
        this.m = Float.valueOf(f);
    }
}
