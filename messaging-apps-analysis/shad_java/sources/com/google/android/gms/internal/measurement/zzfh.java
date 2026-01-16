package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzfh implements zzer {
    private static final Map<String, zzfh> zza = new ArrayMap();
    private final SharedPreferences zzb;

    static zzfh zza(Context context, String str) {
        zzfh zzfhVar;
        if (zzej.zza()) {
            throw null;
        }
        synchronized (zzfh.class) {
            zzfhVar = zza.get(null);
            if (zzfhVar == null) {
                StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    throw null;
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    throw th;
                }
            }
        }
        return zzfhVar;
    }

    static synchronized void zzb() {
        Map<String, zzfh> map = zza;
        Iterator<zzfh> it = map.values().iterator();
        if (it.hasNext()) {
            SharedPreferences sharedPreferences = it.next().zzb;
            throw null;
        }
        map.clear();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object zze(String str) {
        throw null;
    }
}
