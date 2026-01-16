package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.gov.nist.core.Separators;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.AbstractC22035uZ2;
import ir.nasim.AbstractC3795Cj5;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes3.dex */
public abstract class zzfs {
    public static long zza(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static zzaw zzb(zzfb zzfbVar, String str) {
        AbstractC3795Cj5.j(zzfbVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            String strValueOf = String.valueOf(str);
            Map mapA = AbstractC22035uZ2.a(new URI(strValueOf.length() != 0 ? Separators.QUESTION.concat(strValueOf) : new String(Separators.QUESTION)), "UTF-8");
            zzaw zzawVar = new zzaw();
            zzawVar.zzp((String) mapA.get("utm_content"));
            zzawVar.zzu((String) mapA.get("utm_medium"));
            zzawVar.zzv((String) mapA.get("utm_campaign"));
            zzawVar.zzw((String) mapA.get("utm_source"));
            zzawVar.zzt((String) mapA.get("utm_term"));
            zzawVar.zzs((String) mapA.get("utm_id"));
            zzawVar.zzo((String) mapA.get("anid"));
            zzawVar.zzr((String) mapA.get("gclid"));
            zzawVar.zzq((String) mapA.get("dclid"));
            zzawVar.zzn((String) mapA.get("aclid"));
            return zzawVar;
        } catch (URISyntaxException e) {
            zzfbVar.zzS("No valid campaign data found", e);
            return null;
        }
    }

    public static String zzd(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry().toLowerCase(locale));
        }
        return sb.toString();
    }

    public static void zzg(Map<String, String> map, String str, String str2) {
        if (str2 == null || map.containsKey(str)) {
            return;
        }
        map.put(str, str2);
    }

    public static boolean zzi(Context context, String str, boolean z) throws PackageManager.NameNotFoundException {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (!z) {
                    return true;
                }
                if (receiverInfo.exported) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
