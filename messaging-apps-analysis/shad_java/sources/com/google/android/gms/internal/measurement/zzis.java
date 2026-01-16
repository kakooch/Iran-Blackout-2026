package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzis {
    zzis() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzir zzirVar = (zzir) obj;
        if (zzirVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzirVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzir zzirVarZzc = (zzir) obj;
        zzir zzirVar = (zzir) obj2;
        if (!zzirVar.isEmpty()) {
            if (!zzirVarZzc.zze()) {
                zzirVarZzc = zzirVarZzc.zzc();
            }
            zzirVarZzc.zzb(zzirVar);
        }
        return zzirVarZzc;
    }
}
