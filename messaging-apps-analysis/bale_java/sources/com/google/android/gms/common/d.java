package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import ir.nasim.AbstractC20013rK1;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.Fb8;
import ir.nasim.SA7;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class d {
    public static final int a = 12451000;
    private static boolean c = false;
    static boolean d = false;
    static final AtomicBoolean b = new AtomicBoolean();
    private static final AtomicBoolean e = new AtomicBoolean();

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static String b(int i) {
        return ConnectionResult.A0(i);
    }

    public static Context c(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean e(Context context) {
        try {
            if (!d) {
                try {
                    PackageInfo packageInfoE = Fb8.a(context).e("com.google.android.gms", 64);
                    e.a(context);
                    if (packageInfoE == null || e.e(packageInfoE, false) || !e.e(packageInfoE, true)) {
                        c = false;
                    } else {
                        c = true;
                    }
                    d = true;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e2);
                    d = true;
                }
            }
            return c || !AbstractC20013rK1.b();
        } catch (Throwable th) {
            d = true;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(android.content.Context r10, int r11) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.d.f(android.content.Context, int):int");
    }

    public static boolean g(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return k(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean h(Context context) {
        if (!AbstractC3993Df5.c()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        AbstractC3795Cj5.j(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean i(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    public static boolean j(Context context, int i, String str) {
        return SA7.b(context, i, str);
    }

    static boolean k(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        boolean zEquals = str.equals("com.google.android.gms");
        if (AbstractC3993Df5.f()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return zEquals ? applicationInfo.enabled : applicationInfo.enabled && !h(context);
    }
}
