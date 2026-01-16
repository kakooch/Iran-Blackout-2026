package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.alt;
import com.google.ads.interactivemedia.v3.internal.aly;
import com.google.ads.interactivemedia.v3.internal.alz;
import com.google.ads.interactivemedia.v3.internal.ama;
import com.google.ads.interactivemedia.v3.internal.aon;
import com.google.ads.interactivemedia.v3.internal.ars;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public interface bc {
    bc adTagParameters(Map<String, String> map);

    bc adTagUrl(String str);

    bc adsResponse(String str);

    bc apiKey(String str);

    bc assetKey(String str);

    bc authToken(String str);

    bd build();

    bc companionSlots(Map<String, String> map);

    bc consentSettings(au auVar);

    bc contentDuration(Float f);

    bc contentKeywords(List<String> list);

    bc contentSourceId(String str);

    bc contentTitle(String str);

    bc contentUrl(String str);

    bc env(String str);

    bc experimentState(ars<String, aw> arsVar);

    bc extraParameters(Map<String, String> map);

    bc format(String str);

    bc identifierInfo(aon aonVar);

    bc isTv(Boolean bool);

    bc linearAdSlotHeight(Integer num);

    bc linearAdSlotWidth(Integer num);

    bc liveStreamPrefetchSeconds(Float f);

    bc marketAppInfo(alt altVar);

    bc msParameter(String str);

    bc network(String str);

    bc omidAdSessionsOnStartedOnly(Boolean bool);

    bc settings(ImaSdkSettings imaSdkSettings);

    bc streamActivityMonitorId(String str);

    bc supportsExternalNavigation(Boolean bool);

    bc supportsIconClickFallback(Boolean bool);

    bc supportsNativeXhr(Boolean bool);

    bc supportsResizing(Boolean bool);

    bc useQAStreamBaseUrl(Boolean bool);

    bc usesCustomVideoPlayback(Boolean bool);

    bc vastLoadTimeout(Float f);

    bc videoContinuousPlay(alz alzVar);

    bc videoId(String str);

    bc videoPlayActivation(aly alyVar);

    bc videoPlayMuted(ama amaVar);
}
