package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.internal.AppMetricaService;

/* loaded from: classes3.dex */
public abstract class Aj {
    public static final SafePackageManager a = new SafePackageManager();

    public static Intent a(Context context) {
        Bundle bundle;
        C2785pi c2785pi;
        Intent intentAddFlags = new Intent(context, (Class<?>) AppMetricaService.class).setAction("io.appmetrica.analytics.IAppMetricaService").setData(new Uri.Builder().scheme("appmetrica").authority(context.getPackageName()).build()).addFlags(32);
        try {
            bundle = a.getApplicationInfo(context, context.getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
        } catch (Throwable unused) {
            bundle = new Bundle();
        }
        Intent intentPutExtras = intentAddFlags.putExtras(bundle);
        intentPutExtras.setData(intentPutExtras.getData().buildUpon().path("client").appendQueryParameter("pid", String.valueOf(Process.myPid())).appendQueryParameter("psid", Oe.c).build());
        C2747o4 c2747o4G = C2747o4.g();
        synchronized (c2747o4G) {
            try {
                if (c2747o4G.n == null) {
                    C2785pi c2785pi2 = new C2785pi();
                    c2747o4G.n = c2785pi2;
                    c2747o4G.h.a(c2785pi2);
                }
                c2785pi = c2747o4G.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        ScreenInfo screenInfoA = c2785pi.a(context);
        intentPutExtras.putExtra("screen_size", screenInfoA == null ? null : Ya.a(screenInfoA));
        return intentPutExtras.setPackage(context.getApplicationContext().getPackageName());
    }
}
