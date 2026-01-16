package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.C5490Jo2;
import java.util.List;

/* loaded from: classes3.dex */
class o {
    private final Context a;
    private String b;
    private String c;
    private int d;
    private int e = 0;

    o(Context context) {
        this.a = context;
    }

    static String c(C5490Jo2 c5490Jo2) {
        String strD = c5490Jo2.m().d();
        if (strD != null) {
            return strD;
        }
        String strC = c5490Jo2.m().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("FirebaseMessaging", "Failed to find package " + e);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo packageInfoF = f(this.a.getPackageName());
        if (packageInfoF != null) {
            this.b = Integer.toString(packageInfoF.versionCode);
            this.c = packageInfoF.versionName;
        }
    }

    synchronized String a() {
        try {
            if (this.b == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    synchronized String b() {
        try {
            if (this.c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    synchronized int d() {
        PackageInfo packageInfoF;
        try {
            if (this.d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
                this.d = packageInfoF.versionCode;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.d;
    }

    synchronized int e() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!AbstractC3993Df5.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (AbstractC3993Df5.h()) {
            this.e = 2;
        } else {
            this.e = 1;
        }
        return this.e;
    }

    boolean g() {
        return e() != 0;
    }
}
