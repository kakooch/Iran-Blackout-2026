package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StrictMode;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.rbmain.messenger.MessagesController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class alv implements AdsLoader {
    private final Context a;
    private final ane b;
    private final ana c;
    private final amo d;
    private final List<AdsLoader.AdsLoadedListener> e;
    private final Map<String, AdsRequest> f;
    private final Map<String, StreamRequest> g;
    private final anr h;
    private final ImaSdkSettings i;
    private final TestingConfiguration j;
    private final StreamDisplayContainer k;
    private final AdDisplayContainer l;
    private final Object m;
    private apk n;

    public alv(Context context, Uri uri, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer, TestingConfiguration testingConfiguration) {
        this(new ane(context, uri, imaSdkSettings, testingConfiguration), context, imaSdkSettings, testingConfiguration, adDisplayContainer, null);
        this.b.a();
    }

    static /* synthetic */ com.google.ads.interactivemedia.v3.impl.data.au e(alv alvVar) {
        Context context = alvVar.a;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        if (sharedPreferences == null) {
            return null;
        }
        try {
            return com.google.ads.interactivemedia.v3.impl.data.au.create(sharedPreferences.contains("IABTCF_gdprApplies") ? String.valueOf(sharedPreferences.getInt("IABTCF_gdprApplies", 0)) : BuildConfig.FLAVOR, sharedPreferences.getString("IABTCF_TCString", BuildConfig.FLAVOR), sharedPreferences.getString("IABTCF_AddtlConsent", BuildConfig.FLAVOR), sharedPreferences.getString("IABUSPrivacy_String", BuildConfig.FLAVOR));
        } catch (ClassCastException e) {
            yy.e("Failed to read TCF Consent settings from SharedPreferences.", e);
            return null;
        }
    }

    static /* synthetic */ String g(alv alvVar) {
        if (alvVar.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            yy.d("Host application doesn't have ACCESS_NETWORK_STATE permission");
            return "android:0";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) alvVar.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? "android:0" : String.format(Locale.US, "android:%d:%d", Integer.valueOf(activeNetworkInfo.getType()), Integer.valueOf(activeNetworkInfo.getSubtype()));
    }

    static /* synthetic */ alt i(alv alvVar) throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo;
        PackageManager packageManager = alvVar.a.getPackageManager();
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads.interactivemedia.v3")), MessagesController.UPDATE_MASK_CHECK);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                return alt.create(packageInfo.versionCode, activityInfo.packageName);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    static /* synthetic */ void p(alv alvVar, AdsManagerLoadedEvent adsManagerLoadedEvent) {
        Iterator<AdsLoader.AdsLoadedListener> it = alvVar.e.iterator();
        while (it.hasNext()) {
            it.next().onAdsManagerLoaded(adsManagerLoadedEvent);
        }
    }

    private final String t() {
        TestingConfiguration testingConfiguration = this.j;
        if (testingConfiguration == null || !testingConfiguration.ignoreStrictModeFalsePositives()) {
            return UUID.randomUUID().toString();
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
        String string = UUID.randomUUID().toString();
        StrictMode.setThreadPolicy(threadPolicy);
        return string;
    }

    public final void a() {
        this.b.a();
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.d.a(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void addAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.e.add(adsLoadedListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void contentComplete() {
        this.b.n(new amx(amv.adsLoader, amw.contentComplete, "*"));
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final ImaSdkSettings getSettings() {
        return this.i;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void release() {
        AdDisplayContainer adDisplayContainer = this.l;
        if (adDisplayContainer != null) {
            adDisplayContainer.destroy();
        }
        StreamDisplayContainer streamDisplayContainer = this.k;
        if (streamDisplayContainer != null) {
            streamDisplayContainer.destroy();
        }
        ane aneVar = this.b;
        if (aneVar != null) {
            aneVar.m();
        }
        this.f.clear();
        this.e.clear();
        this.g.clear();
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.d.b(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void removeAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.e.remove(adsLoadedListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void requestAds(AdsRequest adsRequest) {
        String strT = t();
        if (adsRequest == null) {
            this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsRequest cannot be null.")));
            return;
        }
        AdDisplayContainer adDisplayContainer = this.l;
        if (adDisplayContainer == null) {
            this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad display container must be provided.")));
            return;
        }
        if (adDisplayContainer.getAdContainer() == null) {
            this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad display container must have a UI container.")));
            return;
        }
        if (aqd.b(adsRequest.getAdTagUrl()) && aqd.b(adsRequest.getAdsResponse())) {
            this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad tag url must non-null and non empty.")));
            return;
        }
        if (this.l.getPlayer() == null) {
            AdDisplayContainer adDisplayContainer2 = this.l;
            adDisplayContainer2.setPlayer(ImaSdkFactory.createSdkOwnedPlayer(this.a, adDisplayContainer2.getAdContainer()));
        }
        this.f.put(strT, adsRequest);
        this.b.e(this.c, strT);
        this.b.k(this.l, strT);
        new alq(this, adsRequest, strT).execute(adsRequest.getAdTagUrl());
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final String requestStream(StreamRequest streamRequest) {
        String strT = t();
        if (streamRequest == null) {
            this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "StreamRequest cannot be null.")));
        } else {
            StreamDisplayContainer streamDisplayContainer = this.k;
            if (streamDisplayContainer == null) {
                this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Stream display container must be provided.")));
            } else if (streamDisplayContainer.getVideoStreamPlayer() == null) {
                this.d.d(new alk(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Stream requests must specify a player.")));
            } else {
                this.g.put(strT, streamRequest);
                this.b.e(this.c, strT);
                this.b.k(this.k, strT);
                new alu(this, streamRequest, strT).execute(new Void[0]);
            }
        }
        return strT;
    }

    public alv(Context context, Uri uri, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer, TestingConfiguration testingConfiguration) {
        this(new ane(context, uri, imaSdkSettings, testingConfiguration), context, imaSdkSettings, testingConfiguration, null, streamDisplayContainer);
        this.b.a();
    }

    private alv(ane aneVar, Context context, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration, AdDisplayContainer adDisplayContainer, StreamDisplayContainer streamDisplayContainer) {
        this.c = new alp(this);
        this.d = new amo();
        this.e = new ArrayList(1);
        this.f = new HashMap();
        this.g = new HashMap();
        this.m = new Object();
        this.b = aneVar;
        this.a = context;
        this.i = imaSdkSettings == null ? ImaSdkFactory.getInstance().createImaSdkSettings() : imaSdkSettings;
        this.j = testingConfiguration;
        this.l = adDisplayContainer;
        this.k = streamDisplayContainer;
        anr anrVar = new anr(aneVar, context);
        this.h = anrVar;
        aneVar.g(anrVar);
        if (adDisplayContainer != null) {
            adDisplayContainer.claim();
        }
        if (streamDisplayContainer != null) {
            streamDisplayContainer.claim();
        }
    }
}
