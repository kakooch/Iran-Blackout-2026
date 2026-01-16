package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import ir.nasim.Fp8;

/* loaded from: classes3.dex */
final class F2 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ G2 a;

    /* synthetic */ F2(G2 g2, Fp8 fp8) {
        this.a = g2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        H1 h1;
        Uri data;
        try {
            try {
                this.a.a.b().v().a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null || (data = intent.getData()) == null || !data.isHierarchical()) {
                    h1 = this.a.a;
                } else {
                    this.a.a.N();
                    String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    this.a.a.a().z(new E2(this, bundle == null, data, ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "gs" : "auto", data.getQueryParameter("referrer")));
                    h1 = this.a.a;
                }
            } catch (RuntimeException e) {
                this.a.a.b().r().b("Throwable caught in onActivityCreated", e);
                h1 = this.a.a;
            }
            h1.K().y(activity, bundle);
        } catch (Throwable th) {
            this.a.a.K().y(activity, bundle);
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.a.a.K().z(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.a.a.K().A(activity);
        J3 j3M = this.a.a.M();
        j3M.a.a().z(new B3(j3M, j3M.a.c().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        J3 j3M = this.a.a.M();
        j3M.a.a().z(new A3(j3M, j3M.a.c().elapsedRealtime()));
        this.a.a.K().B(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.a.K().C(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
