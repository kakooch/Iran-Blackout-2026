package io.appmetrica.analytics.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import io.appmetrica.analytics.impl.BinderC2696m1;
import io.appmetrica.analytics.impl.C1;
import io.appmetrica.analytics.impl.C2586ha;
import io.appmetrica.analytics.impl.C2628j5;
import io.appmetrica.analytics.impl.C2672l1;
import io.appmetrica.analytics.impl.C2762oj;
import io.appmetrica.analytics.impl.C2768p1;
import io.appmetrica.analytics.impl.C2815r1;
import io.appmetrica.analytics.impl.C2839s1;
import io.appmetrica.analytics.impl.C2863t1;
import io.appmetrica.analytics.impl.C2887u1;
import io.appmetrica.analytics.impl.C2911v1;
import io.appmetrica.analytics.impl.C3007z1;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.Di;
import io.appmetrica.analytics.impl.F1;
import io.appmetrica.analytics.logger.common.BaseReleaseLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class AppMetricaService extends Service {
    private static C3007z1 c;
    private final C2672l1 a = new C2672l1(this);
    private final a b = new a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        IBinder binderC2696m1 = (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) ? this.b : new BinderC2696m1();
        C3007z1 c3007z1 = c;
        c3007z1.a.execute(new C2863t1(c3007z1, intent));
        return binderC2696m1;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3007z1 c3007z1 = c;
        c3007z1.a.execute(new C2768p1(c3007z1, configuration));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C2586ha.a(getApplicationContext());
        BaseReleaseLogger.init(getApplicationContext());
        C3007z1 c3007z1 = c;
        if (c3007z1 == null) {
            Context applicationContext = getApplicationContext();
            C1 c1 = new C1(applicationContext, this.a, new C2628j5(applicationContext));
            C2762oj c2762oj = C2586ha.C.v;
            F1 f1 = new F1(c1);
            LinkedHashMap linkedHashMap = c2762oj.a;
            Object arrayList = linkedHashMap.get(1);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(1, arrayList);
            }
            ((List) arrayList).add(f1);
            c = new C3007z1(C2586ha.C.d.b(), c1);
        } else {
            c3007z1.b.a(this.a);
        }
        C2586ha c2586ha = C2586ha.C;
        Di di = new Di(c);
        synchronized (c2586ha) {
            c2586ha.f = new Ci(c2586ha.a, di);
        }
        c.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        C3007z1 c3007z1 = c;
        c3007z1.a.execute(new C2887u1(c3007z1, intent));
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        C3007z1 c3007z1 = c;
        c3007z1.a.execute(new C2815r1(c3007z1, intent, i));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        C3007z1 c3007z1 = c;
        c3007z1.a.execute(new C2839s1(c3007z1, intent, i, i2));
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C3007z1 c3007z1 = c;
        c3007z1.a.execute(new C2911v1(c3007z1, intent));
        String action = intent.getAction();
        return (action == null || !action.startsWith("io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK")) && intent.getData() != null;
    }
}
