package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import ir.nasim.KI3;

@VisibleForTesting
@Deprecated
/* loaded from: classes3.dex */
public abstract class zzfa {
    private static volatile KI3 zza = new zzcu();

    public static void zzb(String str, Object obj) {
        String string;
        zzfb zzfbVarZza = zzfb.zza();
        if (zzfbVarZza != null) {
            zzfbVarZza.zzK(str, obj);
        } else if (zzf(3)) {
            if (obj != null) {
                String str2 = (String) obj;
                StringBuilder sb = new StringBuilder(str.length() + 1 + str2.length());
                sb.append(str);
                sb.append(":");
                sb.append(str2);
                string = sb.toString();
            } else {
                string = str;
            }
            Log.e(zzeu.zzc.zzb(), string);
        }
        KI3 ki3 = zza;
        if (ki3 != null) {
            ki3.error(str);
        }
    }

    public static boolean zzf(int i) {
        return zza != null && zza.getLogLevel() <= i;
    }
}
