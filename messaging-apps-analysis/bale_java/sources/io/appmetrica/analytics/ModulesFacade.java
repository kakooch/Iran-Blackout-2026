package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.C2719n0;
import io.appmetrica.analytics.impl.Dh;
import io.appmetrica.analytics.impl.Ic;
import io.appmetrica.analytics.impl.Kc;
import io.appmetrica.analytics.impl.Lc;
import io.appmetrica.analytics.impl.Mc;
import io.appmetrica.analytics.impl.Nc;
import io.appmetrica.analytics.impl.Oc;

/* loaded from: classes3.dex */
public final class ModulesFacade {
    public static final int EXTERNAL_ATTRIBUTION_ADJUST = 2;
    public static final int EXTERNAL_ATTRIBUTION_AIRBRIDGE = 5;
    public static final int EXTERNAL_ATTRIBUTION_APPSFLYER = 1;
    public static final int EXTERNAL_ATTRIBUTION_KOCHAVA = 3;
    public static final int EXTERNAL_ATTRIBUTION_SINGULAR = 6;
    public static final int EXTERNAL_ATTRIBUTION_TENJIN = 4;
    private static Oc a = new Oc();

    public static IModuleReporter getModuleReporter(Context context, String str) {
        Oc oc = a;
        Ic ic = oc.b;
        ic.b.a(context);
        ic.d.a(str);
        oc.c.a.a(context.getApplicationContext().getApplicationContext());
        return Dh.a.a(context.getApplicationContext(), str);
    }

    public static boolean isActivatedForApp() {
        boolean z;
        Oc oc = a;
        oc.b.getClass();
        oc.c.getClass();
        oc.a.getClass();
        synchronized (C2719n0.class) {
            z = C2719n0.f;
        }
        return z;
    }

    public static void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, Boolean.TRUE);
    }

    public static void reportEvent(ModuleEvent moduleEvent) {
        Oc oc = a;
        oc.b.a.a(null);
        oc.c.getClass();
        oc.d.execute(new Lc(oc, moduleEvent));
    }

    public static void reportExternalAttribution(int i, String str) {
        Oc oc = a;
        oc.b.getClass();
        oc.c.getClass();
        oc.d.execute(new Mc(oc, i, str));
    }

    public static void sendEventsBuffer() {
        Oc oc = a;
        oc.b.getClass();
        oc.c.getClass();
        AppMetrica.sendEventsBuffer();
    }

    public static void setProxy(Oc oc) {
        a = oc;
    }

    public static void setSessionExtra(String str, byte[] bArr) {
        Oc oc = a;
        oc.b.c.a(str);
        oc.c.getClass();
        oc.d.execute(new Nc(oc, str, bArr));
    }

    public static void reportAdRevenue(AdRevenue adRevenue, Boolean bool) {
        Oc oc = a;
        boolean zBooleanValue = bool.booleanValue();
        oc.b.getClass();
        oc.c.getClass();
        oc.d.execute(new Kc(oc, adRevenue, zBooleanValue));
    }
}
