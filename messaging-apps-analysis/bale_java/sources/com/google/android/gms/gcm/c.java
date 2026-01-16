package com.google.android.gms.gcm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
final class c {
    static c d;
    private final Context a;
    private String b;
    private final AtomicInteger c = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private c(Context context) {
        this.a = context.getApplicationContext();
    }

    static synchronized c a(Context context) {
        try {
            if (d == null) {
                d = new c(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return d;
    }

    static String b(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private final String c(Bundle bundle, String str) {
        String strB = b(bundle, str);
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        String strValueOf = String.valueOf(str);
        String strB2 = b(bundle, "_loc_key".length() != 0 ? strValueOf.concat("_loc_key") : new String(strValueOf));
        if (TextUtils.isEmpty(strB2)) {
            return null;
        }
        Resources resources = this.a.getResources();
        int identifier = resources.getIdentifier(strB2, "string", this.a.getPackageName());
        if (identifier == 0) {
            String strValueOf2 = String.valueOf(str);
            String strSubstring = ("_loc_key".length() != 0 ? strValueOf2.concat("_loc_key") : new String(strValueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 49 + String.valueOf(strB2).length());
            sb.append(strSubstring);
            sb.append(" resource not found: ");
            sb.append(strB2);
            sb.append(" Default value will be used.");
            Log.w("GcmNotification", sb.toString());
            return null;
        }
        String strValueOf3 = String.valueOf(str);
        String strB3 = b(bundle, "_loc_args".length() != 0 ? strValueOf3.concat("_loc_args") : new String(strValueOf3));
        if (TextUtils.isEmpty(strB3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(strB3);
            int length = jSONArray.length();
            Object[] objArr = new String[length];
            for (int i = 0; i < length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, objArr);
        } catch (MissingFormatArgumentException e) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(strB2).length() + 58 + String.valueOf(strB3).length());
            sb2.append("Missing format argument for ");
            sb2.append(strB2);
            sb2.append(": ");
            sb2.append(strB3);
            sb2.append(" Default value will be used.");
            Log.w("GcmNotification", sb2.toString(), e);
            return null;
        } catch (JSONException unused) {
            String strValueOf4 = String.valueOf(str);
            String strSubstring2 = ("_loc_args".length() != 0 ? strValueOf4.concat("_loc_args") : new String(strValueOf4)).substring(6);
            StringBuilder sb3 = new StringBuilder(String.valueOf(strSubstring2).length() + 41 + String.valueOf(strB3).length());
            sb3.append("Malformed ");
            sb3.append(strSubstring2);
            sb3.append(": ");
            sb3.append(strB3);
            sb3.append("  Default value will be used.");
            Log.w("GcmNotification", sb3.toString());
            return null;
        }
    }

    private final Bundle e() throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? Bundle.EMPTY : bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean d(android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.c.d(android.os.Bundle):boolean");
    }
}
