package com.google.android.gms.internal.icing;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzq {
    static final String[] zza;
    private static final Map<String, Integer> zzb;

    public static String zza(int i) {
        if (i < 0) {
            return null;
        }
        String[] strArr = zza;
        if (i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    static {
        int i = 0;
        String[] strArr = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
        zza = strArr;
        zzb = new HashMap(strArr.length);
        while (true) {
            String[] strArr2 = zza;
            if (i >= strArr2.length) {
                return;
            }
            zzb.put(strArr2[i], Integer.valueOf(i));
            i++;
        }
    }
}
