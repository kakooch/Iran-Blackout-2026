package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.StreamRequest;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class anx implements StreamRequest {
    private String a;
    private String b;
    private String c;
    private String d;
    private Map<String, String> e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Integer j;
    private StreamRequest.StreamFormat k;
    private Boolean l;
    private transient Object m;

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void c(String str) {
        this.d = str;
    }

    public final void d(String str) {
        this.b = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void forceExperimentId(Integer num) {
        this.j = num;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final Map<String, String> getAdTagParameters() {
        return this.e;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getApiKey() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getAssetKey() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getAuthToken() {
        return this.h;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getContentSourceId() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getContentUrl() {
        return this.g;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final Integer getForcedExperimentId() {
        return this.j;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final StreamRequest.StreamFormat getFormat() {
        return this.k;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getManifestSuffix() {
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getStreamActivityMonitorId() {
        return this.i;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final Boolean getUseQAStreamBaseUrl() {
        return this.l;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final Object getUserRequestContext() {
        return this.m;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final String getVideoId() {
        return this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setAdTagParameters(Map<String, String> map) {
        this.e = map;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setAuthToken(String str) {
        this.h = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setContentUrl(String str) {
        this.g = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setFormat(StreamRequest.StreamFormat streamFormat) {
        this.k = streamFormat;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setManifestSuffix(String str) {
        this.f = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setStreamActivityMonitorId(String str) {
        this.i = str;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setUseQAStreamBaseUrl(Boolean bool) {
        this.l = bool;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamRequest
    public final void setUserRequestContext(Object obj) {
        this.m = obj;
    }
}
