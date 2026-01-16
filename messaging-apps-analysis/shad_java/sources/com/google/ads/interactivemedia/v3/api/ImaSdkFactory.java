package com.google.ads.interactivemedia.v3.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.impl.data.ay;
import com.google.ads.interactivemedia.v3.impl.data.az;
import com.google.ads.interactivemedia.v3.impl.data.g;
import com.google.ads.interactivemedia.v3.internal.alj;
import com.google.ads.interactivemedia.v3.internal.alv;
import com.google.ads.interactivemedia.v3.internal.amb;
import com.google.ads.interactivemedia.v3.internal.ami;
import com.google.ads.interactivemedia.v3.internal.amp;
import com.google.ads.interactivemedia.v3.internal.amq;
import com.google.ads.interactivemedia.v3.internal.anv;
import com.google.ads.interactivemedia.v3.internal.anx;
import com.google.ads.interactivemedia.v3.internal.aoh;
import com.google.ads.interactivemedia.v3.internal.aqd;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ImaSdkFactory {
    private static ImaSdkFactory instance;

    private ImaSdkFactory() {
    }

    private AdsLoader createAdsLoader(Context context, Uri uri, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration, AdDisplayContainer adDisplayContainer) {
        alv alvVar = new alv(context, uri, imaSdkSettings, adDisplayContainer, testingConfiguration);
        alvVar.a();
        return alvVar;
    }

    @Deprecated
    public static VideoAdPlayer createSdkOwnedPlayer(Context context, ViewGroup viewGroup) {
        aqd.j(context);
        aqd.j(viewGroup);
        return new aoh(context, viewGroup);
    }

    public static ImaSdkFactory getInstance() {
        if (instance == null) {
            instance = new ImaSdkFactory();
        }
        return instance;
    }

    private Uri readJsCoreUri(ImaSdkSettings imaSdkSettings) {
        return (imaSdkSettings == null || !imaSdkSettings.isDebugMode()) ? amp.a : amp.b;
    }

    @Deprecated
    public AdDisplayContainer createAdDisplayContainer() {
        return new alj((ViewGroup) null, (VideoAdPlayer) null);
    }

    public AdsRenderingSettings createAdsRenderingSettings() {
        return new g();
    }

    public AdsRequest createAdsRequest() {
        return new amb();
    }

    @Deprecated
    public AdDisplayContainer createAudioAdDisplayContainer(Context context) {
        aqd.j(context);
        return new alj(context, (VideoAdPlayer) null);
    }

    public CompanionAdSlot createCompanionAdSlot() {
        return new ami();
    }

    public FriendlyObstruction createFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        ay ayVarBuilder = az.builder();
        ayVarBuilder.view(view);
        ayVarBuilder.purpose(friendlyObstructionPurpose);
        ayVarBuilder.detailedReason(str);
        return ayVarBuilder.build();
    }

    public ImaSdkSettings createImaSdkSettings() {
        return new amq();
    }

    public StreamRequest createLiveStreamRequest(String str, String str2) {
        anx anxVar = new anx();
        anxVar.a(str);
        anxVar.d(str2);
        return anxVar;
    }

    @Deprecated
    public StreamDisplayContainer createStreamDisplayContainer() {
        return new anv(null, null);
    }

    public StreamRequest createVodStreamRequest(String str, String str2, String str3) {
        anx anxVar = new anx();
        anxVar.b(str);
        anxVar.c(str2);
        anxVar.d(str3);
        return anxVar;
    }

    public static AdDisplayContainer createAdDisplayContainer(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        aqd.j(viewGroup);
        aqd.j(videoAdPlayer);
        return new alj(viewGroup, videoAdPlayer);
    }

    public static StreamDisplayContainer createStreamDisplayContainer(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        aqd.j(viewGroup);
        aqd.j(videoStreamPlayer);
        return new anv(viewGroup, videoStreamPlayer);
    }

    private AdsLoader createAdsLoader(Context context, Uri uri, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration, StreamDisplayContainer streamDisplayContainer) {
        alv alvVar = new alv(context, uri, imaSdkSettings, streamDisplayContainer, testingConfiguration);
        alvVar.a();
        return alvVar;
    }

    public static AdDisplayContainer createAudioAdDisplayContainer(Context context, VideoAdPlayer videoAdPlayer) {
        aqd.j(context);
        aqd.j(videoAdPlayer);
        return new alj(context, videoAdPlayer);
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
        return new alv(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, adDisplayContainer, (TestingConfiguration) null);
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer) {
        return new alv(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, streamDisplayContainer, (TestingConfiguration) null);
    }

    private AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration, AdDisplayContainer adDisplayContainer) {
        return createAdsLoader(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, testingConfiguration, adDisplayContainer);
    }

    private AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration, StreamDisplayContainer streamDisplayContainer) {
        return createAdsLoader(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, testingConfiguration, streamDisplayContainer);
    }
}
