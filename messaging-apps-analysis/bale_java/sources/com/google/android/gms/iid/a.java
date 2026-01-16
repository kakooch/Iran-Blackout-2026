package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import ir.nasim.Gh8;
import ir.nasim.InterfaceC9881ai8;
import ir.nasim.KJ;
import ir.nasim.Th8;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class a {
    private static final InterfaceC9881ai8 c = Th8.b().a("gcm_check_for_different_iid_in_token", true);
    private static Map d = new KJ();
    private static final long e = TimeUnit.DAYS.toMillis(7);
    private static b f;
    private static Gh8 g;
    private static String h;
    private Context a;
    private String b;

    private a(Context context, String str) {
        this.b = "";
        this.a = context.getApplicationContext();
        this.b = str;
    }

    public static synchronized a a(Context context, Bundle bundle) {
        String string;
        a aVar;
        if (bundle == null) {
            string = "";
        } else {
            try {
                string = bundle.getString("subtype");
            } catch (Throwable th) {
                throw th;
            }
        }
        if (string == null) {
            string = "";
        }
        Context applicationContext = context.getApplicationContext();
        if (f == null) {
            String packageName = applicationContext.getPackageName();
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 73);
            sb.append("Instance ID SDK is deprecated, ");
            sb.append(packageName);
            sb.append(" should update to use Firebase Instance ID");
            Log.w("InstanceID", sb.toString());
            f = new b(applicationContext);
            g = new Gh8(applicationContext);
        }
        h = Integer.toString(b(applicationContext));
        aVar = (a) d.get(string);
        if (aVar == null) {
            aVar = new a(applicationContext, string);
            d.put(string, aVar);
        }
        return aVar;
    }

    static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            return 0;
        }
    }

    public static b d() {
        return f;
    }

    final void c() {
        f.c(this.b);
    }
}
