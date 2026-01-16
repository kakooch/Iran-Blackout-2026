package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import ir.nasim.AbstractC20013rK1;
import ir.nasim.Fb8;
import ir.nasim.Zl8;

/* loaded from: classes3.dex */
public class b {
    public static final int a = d.a;
    private static final b b = new b();

    b() {
    }

    public static b f() {
        return b;
    }

    public int a(Context context) {
        return d.a(context);
    }

    public Intent b(Context context, int i, String str) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return null;
            }
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && AbstractC20013rK1.d(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Fb8.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public PendingIntent c(Context context, int i, int i2) {
        return d(context, i, i2, null);
    }

    public PendingIntent d(Context context, int i, int i2, String str) {
        Intent intentB = b(context, i, str);
        if (intentB == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, intentB, Zl8.a | 134217728);
    }

    public String e(int i) {
        return d.b(i);
    }

    public int g(Context context) {
        return h(context, a);
    }

    public int h(Context context, int i) throws PackageManager.NameNotFoundException {
        int iF = d.f(context, i);
        if (d.g(context, iF)) {
            return 18;
        }
        return iF;
    }

    public boolean i(Context context, String str) {
        return d.k(context, str);
    }

    public boolean j(int i) {
        return d.i(i);
    }
}
