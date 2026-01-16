package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import java.util.List;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class alp implements ana {
    final /* synthetic */ alv a;

    alp(alv alvVar) {
        this.a = alvVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ana
    public final void a(String str, List<Float> list, SortedSet<Float> sortedSet, boolean z) {
        AdsRequest adsRequest = (AdsRequest) this.a.f.get(str);
        this.a.h.c(((amb) adsRequest).g());
        try {
            alv alvVar = this.a;
            alv.p(alvVar, new alx(new alw(str, alvVar.b, this.a.l, adsRequest.getContentProgressProvider(), list, sortedSet, this.a.h, this.a.a, z), adsRequest.getUserRequestContext()));
        } catch (AdError e) {
            this.a.d.d(new alk(e, adsRequest.getUserRequestContext()));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ana
    public final void b(String str, String str2, boolean z) {
        StreamRequest streamRequest = (StreamRequest) this.a.g.get(str);
        this.a.h.c(streamRequest.getContentUrl());
        this.a.h.i();
        try {
            alv alvVar = this.a;
            ane aneVar = alvVar.b;
            String manifestSuffix = streamRequest.getManifestSuffix();
            anr anrVar = this.a.h;
            Context context = this.a.a;
            StreamDisplayContainer streamDisplayContainer = this.a.k;
            streamDisplayContainer.getVideoStreamPlayer();
            alv.p(alvVar, new alx(new anw(str, aneVar, streamDisplayContainer, manifestSuffix, anrVar, context, str2, z), streamRequest.getUserRequestContext()));
        } catch (AdError e) {
            this.a.d.d(new alk(e, streamRequest.getUserRequestContext()));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ana
    public final void c(String str, AdError.AdErrorType adErrorType, int i, String str2) {
        this.a.d.d(new alk(new AdError(adErrorType, i, str2), this.a.f.get(str) != null ? ((AdsRequest) this.a.f.get(str)).getUserRequestContext() : ((StreamRequest) this.a.g.get(str)).getUserRequestContext()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ana
    public final void d(String str, AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode) {
        this.a.d.d(new alk(new AdError(adErrorType, adErrorCode, "adsLoaded message did not contain cue points."), this.a.f.get(str) != null ? ((AdsRequest) this.a.f.get(str)).getUserRequestContext() : ((StreamRequest) this.a.g.get(str)).getUserRequestContext()));
    }
}
