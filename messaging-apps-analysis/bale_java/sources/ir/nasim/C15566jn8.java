package ir.nasim;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.jn8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15566jn8 {
    private static volatile C15566jn8 j;
    private final String a;
    protected final OV0 b;
    protected final ExecutorService c;
    private final C17002mE d;
    private final List e;
    private int f;
    private boolean g;
    private final String h;
    private volatile InterfaceC15546jl8 i;

    protected C15566jn8(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !k(str2, str3)) {
            this.a = "FA";
        } else {
            this.a = str;
        }
        this.b = BD1.a();
        AbstractC24516yk8.a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC15556jm8(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.c = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.d = new C17002mE(this);
        this.e = new ArrayList();
        try {
            if (AbstractC12578eq8.b(context, "google_app_id", Pn8.a(context)) != null && !g()) {
                this.h = null;
                this.g = true;
                Log.w(this.a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (k(str2, str3)) {
            this.h = str2;
        } else {
            this.h = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.a, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        j(new Gl8(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new C14976in8(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Exception exc, boolean z, boolean z2) {
        this.g |= z;
        if (z) {
            Log.w(this.a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            a(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.a, "Error with data collection. Data lost.", exc);
    }

    private final void i(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        j(new C23946xm8(this, l, str, str2, bundle, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Cm8 cm8) {
        this.c.execute(cm8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String str, String str2) {
        return (str2 == null || str == null || g()) ? false : true;
    }

    public static C15566jn8 q(Context context, String str, String str2, String str3, Bundle bundle) {
        AbstractC3795Cj5.j(context);
        if (j == null) {
            synchronized (C15566jn8.class) {
                try {
                    if (j == null) {
                        j = new C15566jn8(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return j;
    }

    public final void B(String str) {
        j(new Il8(this, str));
    }

    public final void C(String str, String str2, Bundle bundle) {
        j(new Al8(this, str, str2, bundle));
    }

    public final void D(String str) {
        j(new Jl8(this, str));
    }

    public final void E(String str, Bundle bundle) {
        i(null, str, bundle, false, true, null);
    }

    public final void F(String str, String str2, Bundle bundle) {
        i(str, str2, bundle, true, true, null);
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        j(new C14966im8(this, false, 5, str, obj, null, null));
    }

    public final void b(Bundle bundle) {
        j(new C24526yl8(this, bundle));
    }

    public final void c(Activity activity, String str, String str2) {
        j(new El8(this, activity, str, str2));
    }

    public final void d(String str, String str2, Object obj, boolean z) {
        j(new Am8(this, str, str2, obj, z));
    }

    protected final boolean g() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, C15566jn8.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final int l(String str) {
        Ck8 ck8 = new Ck8();
        j(new C16147km8(this, str, ck8));
        Integer num = (Integer) Ck8.F2(ck8.C2(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long m() {
        Ck8 ck8 = new Ck8();
        j(new C12538em8(this, ck8));
        Long lD2 = ck8.D2(500L);
        if (lD2 != null) {
            return lD2.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.b.currentTimeMillis()).nextLong();
        int i = this.f + 1;
        this.f = i;
        return jNextLong + i;
    }

    public final C17002mE n() {
        return this.d;
    }

    protected final InterfaceC15546jl8 p(Context context, boolean z) {
        try {
            return AbstractBinderC13164fl8.asInterface(DynamiteModule.e(context, DynamiteModule.e, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            h(e, true, false);
            return null;
        }
    }

    public final String s() {
        Ck8 ck8 = new Ck8();
        j(new C11926dm8(this, ck8));
        return ck8.E2(50L);
    }

    public final String t() {
        Ck8 ck8 = new Ck8();
        j(new C13765gm8(this, ck8));
        return ck8.E2(500L);
    }

    public final String u() {
        Ck8 ck8 = new Ck8();
        j(new C13174fm8(this, ck8));
        return ck8.E2(500L);
    }

    public final String v() {
        Ck8 ck8 = new Ck8();
        j(new C11304cm8(this, ck8));
        return ck8.E2(500L);
    }

    public final List w(String str, String str2) {
        Ck8 ck8 = new Ck8();
        j(new Bl8(this, str, str2, ck8));
        List list = (List) Ck8.F2(ck8.C2(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map x(String str, String str2, boolean z) {
        Ck8 ck8 = new Ck8();
        j(new C14358hm8(this, str, str2, z, ck8));
        Bundle bundleC2 = ck8.C2(5000L);
        if (bundleC2 == null || bundleC2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleC2.size());
        for (String str3 : bundleC2.keySet()) {
            Object obj = bundleC2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }
}
