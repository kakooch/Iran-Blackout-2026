package ir.nasim;

import android.app.Activity;
import android.app.Application;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.Map;

/* renamed from: ir.nasim.mb2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17213mb2 {
    public static final C17213mb2 a = new C17213mb2();
    private static final FirebaseAnalytics b;
    private static boolean c;

    static {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(C5721Ko.a.d());
        AbstractC13042fc3.h(firebaseAnalytics, "getInstance(...)");
        b = firebaseAnalytics;
    }

    private C17213mb2() {
    }

    public static final void a(boolean z) {
        c = z;
    }

    private final String b(String str) {
        return AbstractC20153rZ6.M(str, Separators.SP, "_", false, 4, null);
    }

    public static /* synthetic */ void g(C17213mb2 c17213mb2, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        c17213mb2.f(str, map);
    }

    public static final void h(Activity activity, String str) {
        AbstractC13042fc3.i(activity, "activity");
        if (c) {
            b.setCurrentScreen(activity, str, null);
        }
    }

    public static final void i(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        if (c) {
            b.b(str, str2);
        }
    }

    public static final void j(String str) {
        AbstractC13042fc3.i(str, "eventName");
        p(str, "", "");
    }

    public static final void k(String str, String str2, Number number) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        AbstractC13042fc3.i(number, "value");
        o(str, str2, number);
    }

    public static final void l(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        AbstractC13042fc3.i(str3, "value");
        p(str, str2, str3);
    }

    public static final void m(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "data");
        try {
            q(a.b(str), map);
        } catch (Exception e) {
            C19406qI3.d("EventsLog", e);
        }
    }

    public static final void n(String str, Bundle bundle) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(bundle, "bundle");
        if (c) {
            try {
                b.a(a.b(str), bundle);
            } catch (Exception e) {
                C19406qI3.d("EventsLog", e);
            }
        }
    }

    public static final void o(String str, String str2, Number number) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        AbstractC13042fc3.i(number, "value");
        if (c) {
            try {
                Bundle bundle = new Bundle();
                C17213mb2 c17213mb2 = a;
                bundle.putString(c17213mb2.b(str2), number.toString());
                b.a(c17213mb2.b(str), bundle);
            } catch (Exception e) {
                C19406qI3.d("EventsLog", e);
            }
        }
    }

    public static final void p(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        AbstractC13042fc3.i(str3, "value");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(a.b(str2), str3);
            n(str, bundle);
        } catch (Exception e) {
            C19406qI3.d("EventsLog", e);
        }
    }

    private static final void q(String str, Map map) {
        if (c) {
            try {
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(C5721Ko.a.d());
                AbstractC13042fc3.h(firebaseAnalytics, "getInstance(...)");
                Bundle bundle = new Bundle();
                for (Map.Entry entry : map.entrySet()) {
                    bundle.putString(a.b((String) entry.getKey()), (String) entry.getValue());
                }
                firebaseAnalytics.a(a.b(str), bundle);
            } catch (Exception e) {
                C19406qI3.d("EventsLog", e);
            }
        }
    }

    public final void c(String str, Application application) {
        AbstractC13042fc3.i(str, "yandexApiKey");
        AbstractC13042fc3.i(application, SIPServerTransaction.CONTENT_TYPE_APPLICATION);
        AppMetricaConfig appMetricaConfigBuild = AppMetricaConfig.newConfigBuilder(str).build();
        AbstractC13042fc3.h(appMetricaConfigBuild, "build(...)");
        AppMetrica.activate(application.getApplicationContext(), appMetricaConfigBuild);
    }

    public final void d(String str, String str2) {
        AbstractC13042fc3.i(str, "name");
        AppMetrica.reportError(str, str2);
    }

    public final void e(Throwable th) {
        AppMetrica.reportError("ANR", th);
    }

    public final void f(String str, Map map) {
        AbstractC13042fc3.i(str, "name");
        AppMetrica.reportEvent(str, (Map<String, Object>) map);
    }
}
