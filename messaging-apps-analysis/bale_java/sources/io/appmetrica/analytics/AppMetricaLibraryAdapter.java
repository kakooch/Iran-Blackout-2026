package io.appmetrica.analytics;

import android.content.Context;
import io.appmetrica.analytics.impl.C2849sb;
import io.appmetrica.analytics.impl.C2886u0;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;

/* loaded from: classes3.dex */
public class AppMetricaLibraryAdapter {
    private static C2886u0 a = new C2886u0();

    public static void activate(Context context) {
        a.a(context);
    }

    public static void reportEvent(String str, String str2, String str3) {
        C2886u0 c2886u0 = a;
        C2849sb c2849sb = c2886u0.b;
        c2849sb.b.a(null);
        c2849sb.c.a(str);
        c2849sb.d.a(str2);
        c2849sb.e.a(str3);
        c2886u0.c.getClass();
        c2886u0.d.getClass();
        ModulesFacade.reportEvent(ModuleEvent.newBuilder(4).withName("appmetrica_system_event_42").withAttributes(AbstractC20051rO3.n(AbstractC4616Fw7.a("sender", str), AbstractC4616Fw7.a("event", str2), AbstractC4616Fw7.a("payload", str3))).build());
    }

    public static void setProxy(C2886u0 c2886u0) {
        a = c2886u0;
    }
}
