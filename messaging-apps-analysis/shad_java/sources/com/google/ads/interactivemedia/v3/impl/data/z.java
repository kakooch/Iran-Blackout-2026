package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.internal.alt;
import com.google.ads.interactivemedia.v3.internal.aly;
import com.google.ads.interactivemedia.v3.internal.alz;
import com.google.ads.interactivemedia.v3.internal.ama;
import com.google.ads.interactivemedia.v3.internal.aon;
import com.google.ads.interactivemedia.v3.internal.arn;
import com.google.ads.interactivemedia.v3.internal.ars;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class z extends bd {
    private final ars<String, String> adTagParameters;
    private final String adTagUrl;
    private final String adsResponse;
    private final String apiKey;
    private final String assetKey;
    private final String authToken;
    private final ars<String, String> companionSlots;
    private final au consentSettings;
    private final Float contentDuration;
    private final arn<String> contentKeywords;
    private final String contentSourceId;
    private final String contentTitle;
    private final String contentUrl;
    private final String env;
    private final ars<String, aw> experimentState;
    private final ars<String, String> extraParameters;
    private final String format;
    private final aon identifierInfo;
    private final Boolean isTv;
    private final Integer linearAdSlotHeight;
    private final Integer linearAdSlotWidth;
    private final Float liveStreamPrefetchSeconds;
    private final alt marketAppInfo;
    private final String msParameter;
    private final String network;
    private final Boolean omidAdSessionsOnStartedOnly;
    private final ImaSdkSettings settings;
    private final String streamActivityMonitorId;
    private final Boolean supportsExternalNavigation;
    private final Boolean supportsIconClickFallback;
    private final Boolean supportsNativeXhr;
    private final Boolean supportsResizing;
    private final Boolean useQAStreamBaseUrl;
    private final Boolean usesCustomVideoPlayback;
    private final Float vastLoadTimeout;
    private final alz videoContinuousPlay;
    private final String videoId;
    private final aly videoPlayActivation;
    private final ama videoPlayMuted;

    private z(String str, ars<String, String> arsVar, String str2, String str3, String str4, String str5, ars<String, String> arsVar2, Float f, arn<String> arnVar, String str6, String str7, String str8, au auVar, String str9, ars<String, aw> arsVar3, ars<String, String> arsVar4, String str10, aon aonVar, Boolean bool, Integer num, Integer num2, Float f2, alt altVar, String str11, String str12, Boolean bool2, ImaSdkSettings imaSdkSettings, Boolean bool3, Boolean bool4, Boolean bool5, String str13, Boolean bool6, Boolean bool7, Boolean bool8, Float f3, String str14, aly alyVar, alz alzVar, ama amaVar) {
        this.adTagUrl = str;
        this.adTagParameters = arsVar;
        this.adsResponse = str2;
        this.apiKey = str3;
        this.assetKey = str4;
        this.authToken = str5;
        this.companionSlots = arsVar2;
        this.contentDuration = f;
        this.contentKeywords = arnVar;
        this.contentTitle = str6;
        this.contentUrl = str7;
        this.contentSourceId = str8;
        this.consentSettings = auVar;
        this.env = str9;
        this.experimentState = arsVar3;
        this.extraParameters = arsVar4;
        this.format = str10;
        this.identifierInfo = aonVar;
        this.isTv = bool;
        this.linearAdSlotWidth = num;
        this.linearAdSlotHeight = num2;
        this.liveStreamPrefetchSeconds = f2;
        this.marketAppInfo = altVar;
        this.msParameter = str11;
        this.network = str12;
        this.omidAdSessionsOnStartedOnly = bool2;
        this.settings = imaSdkSettings;
        this.supportsExternalNavigation = bool3;
        this.supportsIconClickFallback = bool4;
        this.supportsNativeXhr = bool5;
        this.streamActivityMonitorId = str13;
        this.supportsResizing = bool6;
        this.useQAStreamBaseUrl = bool7;
        this.usesCustomVideoPlayback = bool8;
        this.vastLoadTimeout = f3;
        this.videoId = str14;
        this.videoPlayActivation = alyVar;
        this.videoContinuousPlay = alzVar;
        this.videoPlayMuted = amaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public ars<String, String> adTagParameters() {
        return this.adTagParameters;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String adTagUrl() {
        return this.adTagUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String adsResponse() {
        return this.adsResponse;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String apiKey() {
        return this.apiKey;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String assetKey() {
        return this.assetKey;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String authToken() {
        return this.authToken;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public ars<String, String> companionSlots() {
        return this.companionSlots;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public au consentSettings() {
        return this.consentSettings;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Float contentDuration() {
        return this.contentDuration;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public arn<String> contentKeywords() {
        return this.contentKeywords;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String contentSourceId() {
        return this.contentSourceId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String contentTitle() {
        return this.contentTitle;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String contentUrl() {
        return this.contentUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String env() {
        return this.env;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bd) {
            bd bdVar = (bd) obj;
            String str = this.adTagUrl;
            if (str != null ? str.equals(bdVar.adTagUrl()) : bdVar.adTagUrl() == null) {
                ars<String, String> arsVar = this.adTagParameters;
                if (arsVar != null ? arsVar.equals(bdVar.adTagParameters()) : bdVar.adTagParameters() == null) {
                    String str2 = this.adsResponse;
                    if (str2 != null ? str2.equals(bdVar.adsResponse()) : bdVar.adsResponse() == null) {
                        String str3 = this.apiKey;
                        if (str3 != null ? str3.equals(bdVar.apiKey()) : bdVar.apiKey() == null) {
                            String str4 = this.assetKey;
                            if (str4 != null ? str4.equals(bdVar.assetKey()) : bdVar.assetKey() == null) {
                                String str5 = this.authToken;
                                if (str5 != null ? str5.equals(bdVar.authToken()) : bdVar.authToken() == null) {
                                    ars<String, String> arsVar2 = this.companionSlots;
                                    if (arsVar2 != null ? arsVar2.equals(bdVar.companionSlots()) : bdVar.companionSlots() == null) {
                                        Float f = this.contentDuration;
                                        if (f != null ? f.equals(bdVar.contentDuration()) : bdVar.contentDuration() == null) {
                                            arn<String> arnVar = this.contentKeywords;
                                            if (arnVar != null ? arnVar.equals(bdVar.contentKeywords()) : bdVar.contentKeywords() == null) {
                                                String str6 = this.contentTitle;
                                                if (str6 != null ? str6.equals(bdVar.contentTitle()) : bdVar.contentTitle() == null) {
                                                    String str7 = this.contentUrl;
                                                    if (str7 != null ? str7.equals(bdVar.contentUrl()) : bdVar.contentUrl() == null) {
                                                        String str8 = this.contentSourceId;
                                                        if (str8 != null ? str8.equals(bdVar.contentSourceId()) : bdVar.contentSourceId() == null) {
                                                            au auVar = this.consentSettings;
                                                            if (auVar != null ? auVar.equals(bdVar.consentSettings()) : bdVar.consentSettings() == null) {
                                                                String str9 = this.env;
                                                                if (str9 != null ? str9.equals(bdVar.env()) : bdVar.env() == null) {
                                                                    ars<String, aw> arsVar3 = this.experimentState;
                                                                    if (arsVar3 != null ? arsVar3.equals(bdVar.experimentState()) : bdVar.experimentState() == null) {
                                                                        ars<String, String> arsVar4 = this.extraParameters;
                                                                        if (arsVar4 != null ? arsVar4.equals(bdVar.extraParameters()) : bdVar.extraParameters() == null) {
                                                                            String str10 = this.format;
                                                                            if (str10 != null ? str10.equals(bdVar.format()) : bdVar.format() == null) {
                                                                                aon aonVar = this.identifierInfo;
                                                                                if (aonVar != null ? aonVar.equals(bdVar.identifierInfo()) : bdVar.identifierInfo() == null) {
                                                                                    Boolean bool = this.isTv;
                                                                                    if (bool != null ? bool.equals(bdVar.isTv()) : bdVar.isTv() == null) {
                                                                                        Integer num = this.linearAdSlotWidth;
                                                                                        if (num != null ? num.equals(bdVar.linearAdSlotWidth()) : bdVar.linearAdSlotWidth() == null) {
                                                                                            Integer num2 = this.linearAdSlotHeight;
                                                                                            if (num2 != null ? num2.equals(bdVar.linearAdSlotHeight()) : bdVar.linearAdSlotHeight() == null) {
                                                                                                Float f2 = this.liveStreamPrefetchSeconds;
                                                                                                if (f2 != null ? f2.equals(bdVar.liveStreamPrefetchSeconds()) : bdVar.liveStreamPrefetchSeconds() == null) {
                                                                                                    alt altVar = this.marketAppInfo;
                                                                                                    if (altVar != null ? altVar.equals(bdVar.marketAppInfo()) : bdVar.marketAppInfo() == null) {
                                                                                                        String str11 = this.msParameter;
                                                                                                        if (str11 != null ? str11.equals(bdVar.msParameter()) : bdVar.msParameter() == null) {
                                                                                                            String str12 = this.network;
                                                                                                            if (str12 != null ? str12.equals(bdVar.network()) : bdVar.network() == null) {
                                                                                                                Boolean bool2 = this.omidAdSessionsOnStartedOnly;
                                                                                                                if (bool2 != null ? bool2.equals(bdVar.omidAdSessionsOnStartedOnly()) : bdVar.omidAdSessionsOnStartedOnly() == null) {
                                                                                                                    ImaSdkSettings imaSdkSettings = this.settings;
                                                                                                                    if (imaSdkSettings != null ? imaSdkSettings.equals(bdVar.settings()) : bdVar.settings() == null) {
                                                                                                                        Boolean bool3 = this.supportsExternalNavigation;
                                                                                                                        if (bool3 != null ? bool3.equals(bdVar.supportsExternalNavigation()) : bdVar.supportsExternalNavigation() == null) {
                                                                                                                            Boolean bool4 = this.supportsIconClickFallback;
                                                                                                                            if (bool4 != null ? bool4.equals(bdVar.supportsIconClickFallback()) : bdVar.supportsIconClickFallback() == null) {
                                                                                                                                Boolean bool5 = this.supportsNativeXhr;
                                                                                                                                if (bool5 != null ? bool5.equals(bdVar.supportsNativeXhr()) : bdVar.supportsNativeXhr() == null) {
                                                                                                                                    String str13 = this.streamActivityMonitorId;
                                                                                                                                    if (str13 != null ? str13.equals(bdVar.streamActivityMonitorId()) : bdVar.streamActivityMonitorId() == null) {
                                                                                                                                        Boolean bool6 = this.supportsResizing;
                                                                                                                                        if (bool6 != null ? bool6.equals(bdVar.supportsResizing()) : bdVar.supportsResizing() == null) {
                                                                                                                                            Boolean bool7 = this.useQAStreamBaseUrl;
                                                                                                                                            if (bool7 != null ? bool7.equals(bdVar.useQAStreamBaseUrl()) : bdVar.useQAStreamBaseUrl() == null) {
                                                                                                                                                Boolean bool8 = this.usesCustomVideoPlayback;
                                                                                                                                                if (bool8 != null ? bool8.equals(bdVar.usesCustomVideoPlayback()) : bdVar.usesCustomVideoPlayback() == null) {
                                                                                                                                                    Float f3 = this.vastLoadTimeout;
                                                                                                                                                    if (f3 != null ? f3.equals(bdVar.vastLoadTimeout()) : bdVar.vastLoadTimeout() == null) {
                                                                                                                                                        String str14 = this.videoId;
                                                                                                                                                        if (str14 != null ? str14.equals(bdVar.videoId()) : bdVar.videoId() == null) {
                                                                                                                                                            aly alyVar = this.videoPlayActivation;
                                                                                                                                                            if (alyVar != null ? alyVar.equals(bdVar.videoPlayActivation()) : bdVar.videoPlayActivation() == null) {
                                                                                                                                                                alz alzVar = this.videoContinuousPlay;
                                                                                                                                                                if (alzVar != null ? alzVar.equals(bdVar.videoContinuousPlay()) : bdVar.videoContinuousPlay() == null) {
                                                                                                                                                                    ama amaVar = this.videoPlayMuted;
                                                                                                                                                                    if (amaVar != null ? amaVar.equals(bdVar.videoPlayMuted()) : bdVar.videoPlayMuted() == null) {
                                                                                                                                                                        return true;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public ars<String, aw> experimentState() {
        return this.experimentState;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public ars<String, String> extraParameters() {
        return this.extraParameters;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String format() {
        return this.format;
    }

    public int hashCode() {
        String str = this.adTagUrl;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        ars<String, String> arsVar = this.adTagParameters;
        int iHashCode2 = (iHashCode ^ (arsVar == null ? 0 : arsVar.hashCode())) * 1000003;
        String str2 = this.adsResponse;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.apiKey;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.assetKey;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.authToken;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        ars<String, String> arsVar2 = this.companionSlots;
        int iHashCode7 = (iHashCode6 ^ (arsVar2 == null ? 0 : arsVar2.hashCode())) * 1000003;
        Float f = this.contentDuration;
        int iHashCode8 = (iHashCode7 ^ (f == null ? 0 : f.hashCode())) * 1000003;
        arn<String> arnVar = this.contentKeywords;
        int iHashCode9 = (iHashCode8 ^ (arnVar == null ? 0 : arnVar.hashCode())) * 1000003;
        String str6 = this.contentTitle;
        int iHashCode10 = (iHashCode9 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.contentUrl;
        int iHashCode11 = (iHashCode10 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.contentSourceId;
        int iHashCode12 = (iHashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        au auVar = this.consentSettings;
        int iHashCode13 = (iHashCode12 ^ (auVar == null ? 0 : auVar.hashCode())) * 1000003;
        String str9 = this.env;
        int iHashCode14 = (iHashCode13 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        ars<String, aw> arsVar3 = this.experimentState;
        int iHashCode15 = (iHashCode14 ^ (arsVar3 == null ? 0 : arsVar3.hashCode())) * 1000003;
        ars<String, String> arsVar4 = this.extraParameters;
        int iHashCode16 = (iHashCode15 ^ (arsVar4 == null ? 0 : arsVar4.hashCode())) * 1000003;
        String str10 = this.format;
        int iHashCode17 = (iHashCode16 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        aon aonVar = this.identifierInfo;
        int iHashCode18 = (iHashCode17 ^ (aonVar == null ? 0 : aonVar.hashCode())) * 1000003;
        Boolean bool = this.isTv;
        int iHashCode19 = (iHashCode18 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Integer num = this.linearAdSlotWidth;
        int iHashCode20 = (iHashCode19 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.linearAdSlotHeight;
        int iHashCode21 = (iHashCode20 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        Float f2 = this.liveStreamPrefetchSeconds;
        int iHashCode22 = (iHashCode21 ^ (f2 == null ? 0 : f2.hashCode())) * 1000003;
        alt altVar = this.marketAppInfo;
        int iHashCode23 = (iHashCode22 ^ (altVar == null ? 0 : altVar.hashCode())) * 1000003;
        String str11 = this.msParameter;
        int iHashCode24 = (iHashCode23 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.network;
        int iHashCode25 = (iHashCode24 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        Boolean bool2 = this.omidAdSessionsOnStartedOnly;
        int iHashCode26 = (iHashCode25 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        ImaSdkSettings imaSdkSettings = this.settings;
        int iHashCode27 = (iHashCode26 ^ (imaSdkSettings == null ? 0 : imaSdkSettings.hashCode())) * 1000003;
        Boolean bool3 = this.supportsExternalNavigation;
        int iHashCode28 = (iHashCode27 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Boolean bool4 = this.supportsIconClickFallback;
        int iHashCode29 = (iHashCode28 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        Boolean bool5 = this.supportsNativeXhr;
        int iHashCode30 = (iHashCode29 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        String str13 = this.streamActivityMonitorId;
        int iHashCode31 = (iHashCode30 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        Boolean bool6 = this.supportsResizing;
        int iHashCode32 = (iHashCode31 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        Boolean bool7 = this.useQAStreamBaseUrl;
        int iHashCode33 = (iHashCode32 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
        Boolean bool8 = this.usesCustomVideoPlayback;
        int iHashCode34 = (iHashCode33 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
        Float f3 = this.vastLoadTimeout;
        int iHashCode35 = (iHashCode34 ^ (f3 == null ? 0 : f3.hashCode())) * 1000003;
        String str14 = this.videoId;
        int iHashCode36 = (iHashCode35 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        aly alyVar = this.videoPlayActivation;
        int iHashCode37 = (iHashCode36 ^ (alyVar == null ? 0 : alyVar.hashCode())) * 1000003;
        alz alzVar = this.videoContinuousPlay;
        int iHashCode38 = (iHashCode37 ^ (alzVar == null ? 0 : alzVar.hashCode())) * 1000003;
        ama amaVar = this.videoPlayMuted;
        return iHashCode38 ^ (amaVar != null ? amaVar.hashCode() : 0);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public aon identifierInfo() {
        return this.identifierInfo;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean isTv() {
        return this.isTv;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Integer linearAdSlotHeight() {
        return this.linearAdSlotHeight;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Integer linearAdSlotWidth() {
        return this.linearAdSlotWidth;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Float liveStreamPrefetchSeconds() {
        return this.liveStreamPrefetchSeconds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public alt marketAppInfo() {
        return this.marketAppInfo;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String msParameter() {
        return this.msParameter;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String network() {
        return this.network;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean omidAdSessionsOnStartedOnly() {
        return this.omidAdSessionsOnStartedOnly;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public ImaSdkSettings settings() {
        return this.settings;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String streamActivityMonitorId() {
        return this.streamActivityMonitorId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean supportsExternalNavigation() {
        return this.supportsExternalNavigation;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean supportsIconClickFallback() {
        return this.supportsIconClickFallback;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean supportsNativeXhr() {
        return this.supportsNativeXhr;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean supportsResizing() {
        return this.supportsResizing;
    }

    public String toString() {
        String str = this.adTagUrl;
        String strValueOf = String.valueOf(this.adTagParameters);
        String str2 = this.adsResponse;
        String str3 = this.apiKey;
        String str4 = this.assetKey;
        String str5 = this.authToken;
        String strValueOf2 = String.valueOf(this.companionSlots);
        String strValueOf3 = String.valueOf(this.contentDuration);
        String strValueOf4 = String.valueOf(this.contentKeywords);
        String str6 = this.contentTitle;
        String str7 = this.contentUrl;
        String str8 = this.contentSourceId;
        String strValueOf5 = String.valueOf(this.consentSettings);
        String str9 = this.env;
        String strValueOf6 = String.valueOf(this.experimentState);
        String strValueOf7 = String.valueOf(this.extraParameters);
        String str10 = this.format;
        String strValueOf8 = String.valueOf(this.identifierInfo);
        String strValueOf9 = String.valueOf(this.isTv);
        String strValueOf10 = String.valueOf(this.linearAdSlotWidth);
        String strValueOf11 = String.valueOf(this.linearAdSlotHeight);
        String strValueOf12 = String.valueOf(this.liveStreamPrefetchSeconds);
        String strValueOf13 = String.valueOf(this.marketAppInfo);
        String str11 = this.msParameter;
        String str12 = this.network;
        String strValueOf14 = String.valueOf(this.omidAdSessionsOnStartedOnly);
        String strValueOf15 = String.valueOf(this.settings);
        String strValueOf16 = String.valueOf(this.supportsExternalNavigation);
        String strValueOf17 = String.valueOf(this.supportsIconClickFallback);
        String strValueOf18 = String.valueOf(this.supportsNativeXhr);
        String str13 = this.streamActivityMonitorId;
        String strValueOf19 = String.valueOf(this.supportsResizing);
        String strValueOf20 = String.valueOf(this.useQAStreamBaseUrl);
        String strValueOf21 = String.valueOf(this.usesCustomVideoPlayback);
        String strValueOf22 = String.valueOf(this.vastLoadTimeout);
        String str14 = this.videoId;
        String strValueOf23 = String.valueOf(this.videoPlayActivation);
        String strValueOf24 = String.valueOf(this.videoContinuousPlay);
        String strValueOf25 = String.valueOf(this.videoPlayMuted);
        int length = String.valueOf(str).length() + 689 + strValueOf.length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + strValueOf2.length() + strValueOf3.length() + strValueOf4.length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length();
        int length2 = strValueOf5.length();
        int length3 = String.valueOf(str9).length();
        int length4 = strValueOf6.length();
        int length5 = strValueOf7.length();
        int length6 = String.valueOf(str10).length();
        int length7 = strValueOf8.length();
        int length8 = strValueOf9.length();
        int length9 = strValueOf10.length();
        int length10 = strValueOf11.length();
        int length11 = strValueOf12.length();
        int length12 = strValueOf13.length();
        int length13 = String.valueOf(str11).length();
        int length14 = String.valueOf(str12).length();
        int length15 = strValueOf14.length();
        int length16 = strValueOf15.length();
        int length17 = strValueOf16.length();
        int length18 = strValueOf17.length();
        int length19 = strValueOf18.length();
        int length20 = String.valueOf(str13).length();
        int length21 = strValueOf19.length();
        int length22 = strValueOf20.length();
        int length23 = strValueOf21.length();
        int length24 = strValueOf22.length();
        int length25 = String.valueOf(str14).length();
        int length26 = strValueOf23.length();
        StringBuilder sb = new StringBuilder(length + length2 + length3 + length4 + length5 + length6 + length7 + length8 + length9 + length10 + length11 + length12 + length13 + length14 + length15 + length16 + length17 + length18 + length19 + length20 + length21 + length22 + length23 + length24 + length25 + length26 + strValueOf24.length() + strValueOf25.length());
        sb.append("GsonAdsRequest{adTagUrl=");
        sb.append(str);
        sb.append(", adTagParameters=");
        sb.append(strValueOf);
        sb.append(", adsResponse=");
        sb.append(str2);
        sb.append(", apiKey=");
        sb.append(str3);
        sb.append(", assetKey=");
        sb.append(str4);
        sb.append(", authToken=");
        sb.append(str5);
        sb.append(", companionSlots=");
        sb.append(strValueOf2);
        sb.append(", contentDuration=");
        sb.append(strValueOf3);
        sb.append(", contentKeywords=");
        sb.append(strValueOf4);
        sb.append(", contentTitle=");
        sb.append(str6);
        sb.append(", contentUrl=");
        sb.append(str7);
        sb.append(", contentSourceId=");
        sb.append(str8);
        sb.append(", consentSettings=");
        sb.append(strValueOf5);
        sb.append(", env=");
        sb.append(str9);
        sb.append(", experimentState=");
        sb.append(strValueOf6);
        sb.append(", extraParameters=");
        sb.append(strValueOf7);
        sb.append(", format=");
        sb.append(str10);
        sb.append(", identifierInfo=");
        sb.append(strValueOf8);
        sb.append(", isTv=");
        sb.append(strValueOf9);
        sb.append(", linearAdSlotWidth=");
        sb.append(strValueOf10);
        sb.append(", linearAdSlotHeight=");
        sb.append(strValueOf11);
        sb.append(", liveStreamPrefetchSeconds=");
        sb.append(strValueOf12);
        sb.append(", marketAppInfo=");
        sb.append(strValueOf13);
        sb.append(", msParameter=");
        sb.append(str11);
        sb.append(", network=");
        sb.append(str12);
        sb.append(", omidAdSessionsOnStartedOnly=");
        sb.append(strValueOf14);
        sb.append(", settings=");
        sb.append(strValueOf15);
        sb.append(", supportsExternalNavigation=");
        sb.append(strValueOf16);
        sb.append(", supportsIconClickFallback=");
        sb.append(strValueOf17);
        sb.append(", supportsNativeXhr=");
        sb.append(strValueOf18);
        sb.append(", streamActivityMonitorId=");
        sb.append(str13);
        sb.append(", supportsResizing=");
        sb.append(strValueOf19);
        sb.append(", useQAStreamBaseUrl=");
        sb.append(strValueOf20);
        sb.append(", usesCustomVideoPlayback=");
        sb.append(strValueOf21);
        sb.append(", vastLoadTimeout=");
        sb.append(strValueOf22);
        sb.append(", videoId=");
        sb.append(str14);
        sb.append(", videoPlayActivation=");
        sb.append(strValueOf23);
        sb.append(", videoContinuousPlay=");
        sb.append(strValueOf24);
        sb.append(", videoPlayMuted=");
        sb.append(strValueOf25);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean useQAStreamBaseUrl() {
        return this.useQAStreamBaseUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Boolean usesCustomVideoPlayback() {
        return this.usesCustomVideoPlayback;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public Float vastLoadTimeout() {
        return this.vastLoadTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public alz videoContinuousPlay() {
        return this.videoContinuousPlay;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public String videoId() {
        return this.videoId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public aly videoPlayActivation() {
        return this.videoPlayActivation;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bd
    public ama videoPlayMuted() {
        return this.videoPlayMuted;
    }
}
