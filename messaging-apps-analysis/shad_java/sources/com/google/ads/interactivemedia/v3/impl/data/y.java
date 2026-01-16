package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.alt;
import com.google.ads.interactivemedia.v3.internal.aly;
import com.google.ads.interactivemedia.v3.internal.alz;
import com.google.ads.interactivemedia.v3.internal.ama;
import com.google.ads.interactivemedia.v3.internal.aon;
import com.google.ads.interactivemedia.v3.internal.arn;
import com.google.ads.interactivemedia.v3.internal.ars;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class y implements bc {
    private ars<String, String> adTagParameters;
    private String adTagUrl;
    private String adsResponse;
    private String apiKey;
    private String assetKey;
    private String authToken;
    private ars<String, String> companionSlots;
    private au consentSettings;
    private Float contentDuration;
    private arn<String> contentKeywords;
    private String contentSourceId;
    private String contentTitle;
    private String contentUrl;
    private String env;
    private ars<String, aw> experimentState;
    private ars<String, String> extraParameters;
    private String format;
    private aon identifierInfo;
    private Boolean isTv;
    private Integer linearAdSlotHeight;
    private Integer linearAdSlotWidth;
    private Float liveStreamPrefetchSeconds;
    private alt marketAppInfo;
    private String msParameter;
    private String network;
    private Boolean omidAdSessionsOnStartedOnly;
    private ImaSdkSettings settings;
    private String streamActivityMonitorId;
    private Boolean supportsExternalNavigation;
    private Boolean supportsIconClickFallback;
    private Boolean supportsNativeXhr;
    private Boolean supportsResizing;
    private Boolean useQAStreamBaseUrl;
    private Boolean usesCustomVideoPlayback;
    private Float vastLoadTimeout;
    private alz videoContinuousPlay;
    private String videoId;
    private aly videoPlayActivation;
    private ama videoPlayMuted;

    y() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc adTagParameters(Map<String, String> map) {
        this.adTagParameters = map == null ? null : ars.d(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc adTagUrl(String str) {
        this.adTagUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc adsResponse(String str) {
        this.adsResponse = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc apiKey(String str) {
        this.apiKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc assetKey(String str) {
        this.assetKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc authToken(String str) {
        this.authToken = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bd build() {
        return new z(this.adTagUrl, this.adTagParameters, this.adsResponse, this.apiKey, this.assetKey, this.authToken, this.companionSlots, this.contentDuration, this.contentKeywords, this.contentTitle, this.contentUrl, this.contentSourceId, this.consentSettings, this.env, this.experimentState, this.extraParameters, this.format, this.identifierInfo, this.isTv, this.linearAdSlotWidth, this.linearAdSlotHeight, this.liveStreamPrefetchSeconds, this.marketAppInfo, this.msParameter, this.network, this.omidAdSessionsOnStartedOnly, this.settings, this.supportsExternalNavigation, this.supportsIconClickFallback, this.supportsNativeXhr, this.streamActivityMonitorId, this.supportsResizing, this.useQAStreamBaseUrl, this.usesCustomVideoPlayback, this.vastLoadTimeout, this.videoId, this.videoPlayActivation, this.videoContinuousPlay, this.videoPlayMuted);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc companionSlots(Map<String, String> map) {
        this.companionSlots = map == null ? null : ars.d(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc consentSettings(au auVar) {
        this.consentSettings = auVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc contentDuration(Float f) {
        this.contentDuration = f;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc contentKeywords(List<String> list) {
        this.contentKeywords = list == null ? null : arn.l(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc contentSourceId(String str) {
        this.contentSourceId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc contentTitle(String str) {
        this.contentTitle = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc contentUrl(String str) {
        this.contentUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc env(String str) {
        this.env = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc experimentState(ars<String, aw> arsVar) {
        this.experimentState = arsVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc extraParameters(Map<String, String> map) {
        this.extraParameters = map == null ? null : ars.d(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc format(String str) {
        this.format = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc identifierInfo(aon aonVar) {
        this.identifierInfo = aonVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc isTv(Boolean bool) {
        this.isTv = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc linearAdSlotHeight(Integer num) {
        this.linearAdSlotHeight = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc linearAdSlotWidth(Integer num) {
        this.linearAdSlotWidth = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc liveStreamPrefetchSeconds(Float f) {
        this.liveStreamPrefetchSeconds = f;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc marketAppInfo(alt altVar) {
        this.marketAppInfo = altVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc msParameter(String str) {
        this.msParameter = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc network(String str) {
        this.network = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc omidAdSessionsOnStartedOnly(Boolean bool) {
        this.omidAdSessionsOnStartedOnly = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc settings(ImaSdkSettings imaSdkSettings) {
        this.settings = imaSdkSettings;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc streamActivityMonitorId(String str) {
        this.streamActivityMonitorId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc supportsExternalNavigation(Boolean bool) {
        this.supportsExternalNavigation = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc supportsIconClickFallback(Boolean bool) {
        this.supportsIconClickFallback = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc supportsNativeXhr(Boolean bool) {
        this.supportsNativeXhr = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc supportsResizing(Boolean bool) {
        this.supportsResizing = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc useQAStreamBaseUrl(Boolean bool) {
        this.useQAStreamBaseUrl = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc usesCustomVideoPlayback(Boolean bool) {
        this.usesCustomVideoPlayback = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc vastLoadTimeout(Float f) {
        this.vastLoadTimeout = f;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc videoContinuousPlay(alz alzVar) {
        this.videoContinuousPlay = alzVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc videoId(String str) {
        this.videoId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc videoPlayActivation(aly alyVar) {
        this.videoPlayActivation = alyVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bc
    public bc videoPlayMuted(ama amaVar) {
        this.videoPlayMuted = amaVar;
        return this;
    }
}
