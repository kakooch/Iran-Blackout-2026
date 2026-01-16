package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhm implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhn zza;

    /* synthetic */ zzhm(zzhn zzhnVar, zzgz zzgzVar) {
        this.zza = zzhnVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfl zzflVar;
        Uri data;
        try {
            try {
                this.zza.zzx.zzat().zzk().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null || (data = intent.getData()) == null || !data.isHierarchical()) {
                    zzflVar = this.zza.zzx;
                } else {
                    this.zza.zzx.zzl();
                    String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    boolean z = true;
                    String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                    String queryParameter = data.getQueryParameter("referrer");
                    if (bundle != null) {
                        z = false;
                    }
                    this.zza.zzx.zzau().zzh(new zzhl(this, z, data, str, queryParameter));
                    zzflVar = this.zza.zzx;
                }
            } catch (Exception e) {
                this.zza.zzx.zzat().zzb().zzb("Throwable caught in onActivityCreated", e);
                zzflVar = this.zza.zzx;
            }
            zzflVar.zzx().zzo(activity, bundle);
        } catch (Throwable th) {
            this.zza.zzx.zzx().zzo(activity, bundle);
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzx.zzx().zzt(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) throws IllegalStateException {
        this.zza.zzx.zzx().zzr(activity);
        zzjq zzjqVarZzh = this.zza.zzx.zzh();
        zzjqVarZzh.zzx.zzau().zzh(new zzjj(zzjqVarZzh, zzjqVarZzh.zzx.zzax().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) throws IllegalStateException {
        zzjq zzjqVarZzh = this.zza.zzx.zzh();
        zzjqVarZzh.zzx.zzau().zzh(new zzji(zzjqVarZzh, zzjqVarZzh.zzx.zzax().elapsedRealtime()));
        this.zza.zzx.zzx().zzq(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzx.zzx().zzs(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
