package com.google.ads.interactivemedia.v3.impl.data;

import android.os.Build;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.internal.alj;
import com.google.ads.interactivemedia.v3.internal.alt;
import com.google.ads.interactivemedia.v3.internal.aly;
import com.google.ads.interactivemedia.v3.internal.alz;
import com.google.ads.interactivemedia.v3.internal.ama;
import com.google.ads.interactivemedia.v3.internal.amb;
import com.google.ads.interactivemedia.v3.internal.amg;
import com.google.ads.interactivemedia.v3.internal.anv;
import com.google.ads.interactivemedia.v3.internal.aoi;
import com.google.ads.interactivemedia.v3.internal.aon;
import com.google.ads.interactivemedia.v3.internal.aqa;
import com.google.ads.interactivemedia.v3.internal.arn;
import com.google.ads.interactivemedia.v3.internal.arq;
import com.google.ads.interactivemedia.v3.internal.ars;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class bd {
    public static bc builder() {
        return new y();
    }

    public static bd create(AdsRequest adsRequest, String str, au auVar, String str2, ImaSdkSettings imaSdkSettings, alt altVar, boolean z, aon aonVar, AdDisplayContainer adDisplayContainer) {
        String adTagUrl = adsRequest.getAdTagUrl();
        String adsResponse = adsRequest.getAdsResponse();
        Map<String, String> extraParameters = adsRequest.getExtraParameters();
        amb ambVar = (amb) adsRequest;
        aly alyVarA = ambVar.a();
        ama amaVarB = ambVar.b();
        alz alzVarC = ambVar.c();
        Float fD = ambVar.d();
        List<String> listE = ambVar.e();
        String strF = ambVar.f();
        String strG = ambVar.g();
        Float fH = ambVar.h();
        Float fI = ambVar.i();
        Map<String, String> companionSlots = getCompanionSlots((alj) adDisplayContainer);
        ViewGroup adContainer = adDisplayContainer.getAdContainer();
        ars<String, aw> arsVar = (ars) aqa.c(adsRequest.getForcedExperimentId()).b(ba.$instance).a();
        bc bcVarBuilder = builder();
        bcVarBuilder.adTagUrl(adTagUrl);
        bcVarBuilder.adsResponse(adsResponse);
        bcVarBuilder.companionSlots(companionSlots);
        bcVarBuilder.consentSettings(auVar);
        bcVarBuilder.contentDuration(fD);
        bcVarBuilder.contentKeywords(listE);
        bcVarBuilder.contentTitle(strF);
        bcVarBuilder.contentUrl(strG);
        bcVarBuilder.env(str);
        bcVarBuilder.experimentState(arsVar);
        bcVarBuilder.extraParameters(extraParameters);
        bcVarBuilder.identifierInfo(aonVar);
        Boolean boolValueOf = Boolean.valueOf(z);
        bcVarBuilder.isTv(boolValueOf);
        bcVarBuilder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        bcVarBuilder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        bcVarBuilder.liveStreamPrefetchSeconds(fI);
        bcVarBuilder.marketAppInfo(altVar);
        bcVarBuilder.network(str2);
        bcVarBuilder.omidAdSessionsOnStartedOnly(Boolean.TRUE);
        bcVarBuilder.settings(imaSdkSettings);
        bcVarBuilder.supportsExternalNavigation(Boolean.valueOf(!z));
        bcVarBuilder.supportsIconClickFallback(boolValueOf);
        bcVarBuilder.supportsNativeXhr(Boolean.valueOf(supportsNativeNetworkRequests()));
        bcVarBuilder.supportsResizing(Boolean.valueOf(adDisplayContainer.getPlayer() instanceof ResizablePlayer));
        bcVarBuilder.usesCustomVideoPlayback(Boolean.valueOf(!(adDisplayContainer.getPlayer() instanceof aoi)));
        bcVarBuilder.vastLoadTimeout(fH);
        bcVarBuilder.videoContinuousPlay(alzVarC);
        bcVarBuilder.videoPlayActivation(alyVarA);
        bcVarBuilder.videoPlayMuted(amaVarB);
        return bcVarBuilder.build();
    }

    public static bd createFromStreamRequest(StreamRequest streamRequest, String str, au auVar, String str2, ImaSdkSettings imaSdkSettings, alt altVar, boolean z, String str3, aon aonVar, StreamDisplayContainer streamDisplayContainer) {
        Map<String, String> companionSlots = getCompanionSlots((anv) streamDisplayContainer);
        ViewGroup adContainer = streamDisplayContainer.getAdContainer();
        ars<String, aw> arsVar = (ars) aqa.c(streamRequest.getForcedExperimentId()).b(bb.$instance).a();
        String str4 = streamRequest.getFormat() == StreamRequest.StreamFormat.DASH ? "dash" : "hls";
        bc bcVarBuilder = builder();
        bcVarBuilder.adTagParameters(streamRequest.getAdTagParameters());
        bcVarBuilder.apiKey(streamRequest.getApiKey());
        bcVarBuilder.assetKey(streamRequest.getAssetKey());
        bcVarBuilder.authToken(streamRequest.getAuthToken());
        bcVarBuilder.companionSlots(companionSlots);
        bcVarBuilder.consentSettings(auVar);
        bcVarBuilder.contentSourceId(streamRequest.getContentSourceId());
        bcVarBuilder.contentUrl(streamRequest.getContentUrl());
        bcVarBuilder.env(str);
        bcVarBuilder.experimentState(arsVar);
        bcVarBuilder.format(str4);
        bcVarBuilder.identifierInfo(aonVar);
        bcVarBuilder.network(str2);
        bcVarBuilder.settings(imaSdkSettings);
        bcVarBuilder.marketAppInfo(altVar);
        Boolean boolValueOf = Boolean.valueOf(z);
        bcVarBuilder.isTv(boolValueOf);
        bcVarBuilder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        bcVarBuilder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        bcVarBuilder.msParameter(str3);
        bcVarBuilder.omidAdSessionsOnStartedOnly(Boolean.TRUE);
        bcVarBuilder.streamActivityMonitorId(streamRequest.getStreamActivityMonitorId());
        bcVarBuilder.supportsExternalNavigation(Boolean.valueOf(!z));
        bcVarBuilder.supportsIconClickFallback(boolValueOf);
        bcVarBuilder.supportsNativeXhr(Boolean.valueOf(supportsNativeNetworkRequests()));
        bcVarBuilder.supportsResizing(Boolean.valueOf(streamDisplayContainer.getVideoStreamPlayer() instanceof ResizablePlayer));
        bcVarBuilder.useQAStreamBaseUrl(streamRequest.getUseQAStreamBaseUrl());
        bcVarBuilder.videoId(streamRequest.getVideoId());
        return bcVarBuilder.build();
    }

    private static Map<String, String> getCompanionSlots(amg amgVar) {
        Map<String, CompanionAdSlot> mapA = amgVar.a();
        if (mapA == null || mapA.isEmpty()) {
            return null;
        }
        arq arqVar = new arq();
        for (String str : mapA.keySet()) {
            CompanionAdSlot companionAdSlot = mapA.get(str);
            int width = companionAdSlot.getWidth();
            int height = companionAdSlot.getHeight();
            StringBuilder sb = new StringBuilder(23);
            sb.append(width);
            sb.append("x");
            sb.append(height);
            arqVar.b(str, sb.toString());
        }
        return arqVar.a();
    }

    private static boolean supportsNativeNetworkRequests() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public abstract ars<String, String> adTagParameters();

    public abstract String adTagUrl();

    public abstract String adsResponse();

    public abstract String apiKey();

    public abstract String assetKey();

    public abstract String authToken();

    public abstract ars<String, String> companionSlots();

    public abstract au consentSettings();

    public abstract Float contentDuration();

    public abstract arn<String> contentKeywords();

    public abstract String contentSourceId();

    public abstract String contentTitle();

    public abstract String contentUrl();

    public abstract String env();

    public abstract ars<String, aw> experimentState();

    public abstract ars<String, String> extraParameters();

    public abstract String format();

    public abstract aon identifierInfo();

    public abstract Boolean isTv();

    public abstract Integer linearAdSlotHeight();

    public abstract Integer linearAdSlotWidth();

    public abstract Float liveStreamPrefetchSeconds();

    public abstract alt marketAppInfo();

    public abstract String msParameter();

    public abstract String network();

    public abstract Boolean omidAdSessionsOnStartedOnly();

    public abstract ImaSdkSettings settings();

    public abstract String streamActivityMonitorId();

    public abstract Boolean supportsExternalNavigation();

    public abstract Boolean supportsIconClickFallback();

    public abstract Boolean supportsNativeXhr();

    public abstract Boolean supportsResizing();

    public abstract Boolean useQAStreamBaseUrl();

    public abstract Boolean usesCustomVideoPlayback();

    public abstract Float vastLoadTimeout();

    public abstract alz videoContinuousPlay();

    public abstract String videoId();

    public abstract aly videoPlayActivation();

    public abstract ama videoPlayMuted();
}
